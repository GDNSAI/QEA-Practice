package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j


public class BaseClass {
	// as same webdriver we are using every where so it will be static
	static public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = {"sanity","regression","master"})
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws InterruptedException, IOException {

		// loading properties file
		FileInputStream file = new FileInputStream(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);

		// Loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		
		
//local environment where browser we are changing not os
//		switch (br.toLowerCase()) {
//		case "chrome":
//			driver = new ChromeDriver();
//			break;
//
//		case "edge":
//			driver = new EdgeDriver();
//			break;
//		default:
//			System.out.println("No matching browser...");
//			return;
//		}
		
		//checking from properties file 
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}else {
				System.out.println("No matching os..");
				return;
			}
			
			//browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
	
			case "edge":
				capabilities.setBrowserName("edge");
				break;
			default:
				System.out.println("No matching browser...");
				return;
			}
		 	//node URL
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
			
			
		}else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
	
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser...");
				return;
			}
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get(p.getProperty("appURL"));

		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@AfterClass(groups = {"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
	}

	public String randomeString(int i) {
		String genarateString = RandomStringUtils.randomAlphabetic(i);
		return genarateString;
	}

	public String randomeNumber(int i) {
		String genarateNumber = RandomStringUtils.randomNumeric(i);
		return genarateNumber;
	}

	public String randomeAlphabeticNumber(int i, int j) {
		String genarateString = RandomStringUtils.randomNumeric(i);
		String genarateNumber = RandomStringUtils.randomNumeric(i);
		return genarateString + "@" + genarateNumber;
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		//rename the existing file
		sourceFile.renameTo(targetFile);
		
		//return the string path	
		return targetFilePath;

	}
}
