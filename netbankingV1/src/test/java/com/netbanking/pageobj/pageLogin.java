package com.netbanking.pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageLogin 

{
	WebDriver tdriver;
	
	public pageLogin(WebDriver cdriver)
	{
		tdriver=cdriver;
		PageFactory.initElements(tdriver, this);    //webelement creation
	}
	
	
	@FindBy(name="uid")
	WebElement textusername;
	
	@FindBy (name="password")
	WebElement textpassword;
	
	@FindBy (name="btnLogin")
    WebElement loginclick;
	
	@FindBy (xpath="//a[contains(text(),'Log out')]")
	WebElement logoutclick;
	
	public void setusername(String uname)
	{
		textusername.sendKeys(uname);
	}
	public void setpassword(String pwd)
	{
		textpassword.sendKeys(pwd);
	}
	public void setloginclick()
	{
		loginclick.click();
	}
	
    public void setlogout() 
    {
          logoutclick.click();
    }
}
