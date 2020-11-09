package com.netbanking.testCase;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobj.pageLogin;


public class xl extends baseClass
{
	
	@Test
	public void loginxl() throws  IOException
	{
	   // driver.get("Baseurl");
		String pathxl="./testdata/logindata.xlsx";
	//	FileInputStream input=new FileInputStream(pathxl);
		Workbook wb=WorkbookFactory.create(new FileInputStream(pathxl));
		
		pageLogin pl=new pageLogin(driver);
		
	for(int i=1;i<=5;i++)
	{
		String usn=wb.getSheet("Sheet1").getRow(i).getCell(1).toString();
		String pwn=wb.getSheet("Sheet1").getRow(i).getCell(2).toString();
		pl.setusername(usn);
		pl.setpassword(pwn);
		pl.setloginclick();
			
		    if(isalertpresent()==true)
		    {
		    	driver.switchTo().alert().accept();
		    	driver.switchTo().defaultContent();
		    	Assert.assertTrue(false);
		    }
		    else
		    {
		    	pl.setlogout();
		    	driver.switchTo().alert().accept();
		    	driver.switchTo().defaultContent();
		    	Assert.assertTrue(true);
		    }
		}
	}

    public Boolean isalertpresent()
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
}

