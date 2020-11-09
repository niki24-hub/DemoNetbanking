package com.netbanking.testCase;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.netbanking.pageobj.pageLogin;
import com.netbanking.utilities.XLUtils;


public class TC_LoginDTD_002 extends baseClass

{
	
	
	       @Test(dataProvider="loginda")   
           public void logindtd(String uname, String pwd) throws InterruptedException, IOException
	       {
	    	   //driver.manage().deleteAllCookies();   
	          // driver.get(Baseurl);   
        	  pageLogin pl=new pageLogin(driver);
        	  pl.setusername(uname);
        	  pl.setpassword(pwd);
        	  pl.setloginclick();
        	  Thread.sleep(3000);
        	  if(isalertpresent()==true) 
        	  {
        		  driver.switchTo().alert().accept(); 
        		  driver.switchTo().defaultContent();
        		  Assert.assertTrue(false);
        	  }
        	  else
        	  {
        		  Assert.assertTrue(true);
        		  capturescreen(driver,"logindtd");

        		  pl.setlogout();
        		  Thread.sleep(5000);
        		  driver.switchTo().alert().accept();
        		  Thread.sleep(3000);
        		  driver.switchTo().defaultContent();
        		  
        	  }
           }
	       
	       public boolean isalertpresent()
	       {
	    	   try
	    	   {
	    		   driver.switchTo().alert();
	    		   return true;
	    	   }
	    	   catch(NoAlertPresentException e )
	    	   {
	    		   return false;
	    	   }
	       }
           
            
           @DataProvider(name="loginda")
           String[][] getdata() throws IOException
           {
        	   String path="./testdata/logindata.xlsx";
        	   int rownum=XLUtils.getrowcount(path,"Sheet1");
        	   int colc=XLUtils.getcellcount(path,"Sheet1",1);
        	   String loginarr[][] =new String[rownum][colc];
        	   
        	   for(int i=1;i<=rownum;i++)
        	   {
        		   for(int j=0;j<colc;j++)
        		   {
        			   loginarr[i-1][j]=XLUtils.getcelldata(path,"Sheet1",i,j);
        		   }
        	   }
        	   return loginarr;
        	   
           }
}
