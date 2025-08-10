package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.utility.ExtentManager;

public class TestBase {
 /*  WebDriver
  *  Properties
  *  Logs
  *  ExtentReport
  *  Excel Reading
  *  Mailing   
  */
	
	public static WebDriver driver; // to refer browser driver (chorme/geko)
	public static Properties config; // to store the data of property files
	public static Properties OR; // to store the data of locatores (XPATH)
	public static FileInputStream fis; // to locate the file;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentReports exReport = ExtentManager.getInstance();
	public static ExtentTest test;
	@BeforeSuite	
	public void setUp() throws IOException{
		try {
				config = new Properties();
				OR = new Properties();
				
				fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
				log.debug("Loading Config file");
				config.load(fis);
				fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
				OR.load(fis);
				if(config.getProperty("os").equals("mac"))
				{
					WebDriverManager.chromedriver().setup();
				    driver = new ChromeDriver();

				}
				else
				{
					if(config.getProperty("browser").equals("chrome"))
					{
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\chromedriver.exe");
						driver = new ChromeDriver();
						log.debug("Chrome Browser driver");
					}
					if(config.getProperty("browser").equals("firefox"))
					{
						System.out.println("firefox driver");
						System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\geckodriver.exe");
						driver = new FirefoxDriver();
						log.debug("Firefox Browser driver");
					}
				}
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			System.out.println(config.getProperty("testurl"));
//			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("ImplicityWait")), TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(config.getProperty("testurl"));
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
	public static Boolean isElementisPresent(By by)
	{
		try {
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
}
