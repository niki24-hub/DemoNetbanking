package com.netbanking.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobj.pageLogin;

public class TC_pagelogin_001 extends baseClass
{
	
	@Test
	public void login() throws IOException
	{
		      driver.manage().deleteAllCookies();   
              driver.get(Baseurl);          // in case not using XML file to use different browser
         // Logger.info("URL Opened");
          
	      pageLogin lp=new pageLogin(driver);
	      
        	lp.setusername(username);
        	// Logger.info("username get entered");
        	
        	 lp.setpassword(password);
       // 	 Logger.info("Password get entered");
        	
        	 lp.setloginclick();
       // 	 Logger.info("Homepage Opened");
	
	           if(driver.getTitle().equals(homepage))
	         {
	            	System.out.println(homepage);
	//            	 Logger.info("actual result matched");
	            	Assert.assertTrue(true);
	         }
	          else
        	{
	        	    capturescreen(driver,"login");
             		Assert.assertTrue(false,"not matched");
        	}
	
	       lp.setlogout();
	
	}
}
