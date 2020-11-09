package com.netbanking.testCase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import java.io.File;
//import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;

import com.netbanking.utilities.readConfig;


public class baseClass 

{
	WebDriver driver;
	
	
	readConfig read=new readConfig();
	
	public String Baseurl=read.getbaseurl();
	public String username=read.fetchusername();
	public String password=read.fetchpassowrd();
	public String homepage=read.gethomepage();
	
	/*public String Baseurl="http://demo.guru99.com/v4/index.php";
	public String username="mngr261481";
	public String password="AbYhemy";
	public String homepage="Guru99 Bank Manager HomePage";*/ //In case of not using reading data  from properties file
	//public static Logger Logger;
	
	//@Parameters("Browser")
	@BeforeClass
	public void sitelaunch()
	{
    	//System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver",read.fetchfirefox());

		driver=new FirefoxDriver();
	 //   Logger= Logger.getLogger("ebanking");
	//	PropertyConfigurator.configure("log4j2.properties");
		
/*		if(br.equals("firefox"))
				{
			           System.setProperty("webdriver.gecko.driver",read.fetchfirefox());
			           driver=new FirefoxDriver();
				}
		else
	        	{
			          System.setProperty("webdriver.chrome.driver",read.fetchchrome());
		              driver=new ChromeDriver();
		        } 
		                                  */
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
	       driver.get(Baseurl); 
	       
	}
	
	@AfterClass
	public void siteclose()
	{
		driver.quit();
	}
	
	 public void capturescreen(WebDriver driver,String scrname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
	    //File dest=new File(System.getProperty("user.dir")+ "/Screenshots/" +scrname+  ".png");
		File dest=new File("./Screenshots/" +scrname+ ".png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot taken");
	} 
}	
