package com.netbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig 
{
	Properties pro;
	
	public readConfig()
	
	{
		
	try
	{
		File readsrc= new File("./configuration/config.properties");

		FileInputStream fis=new FileInputStream(readsrc);
		pro=new Properties();
		pro.load(fis);
		
	}
	catch (Exception e)
	{
		System.out.println("An Exception is" +e.getMessage());
	}

}

	public String getbaseurl()
	{
		String url=pro.getProperty("Baseurl");
		return url;
	}
	
	public String fetchusername()
	{
		String uid=pro.getProperty("username");
		return uid;
	}
	
	public String fetchpassowrd()
	{
		String pw=pro.getProperty("password");
		return pw;
	}
	
	public String fetchfirefox()
	{
		String firefx=pro.getProperty("Firefoxpath");
		return firefx;
		
	}
	
	public String gethomepage()
	{
		String hmpg=pro.getProperty("homepage");
		return hmpg;
		
	}
	
	public String fetchchrome()
	{
		String chromee=pro.getProperty("Chromepath");
		return chromee;
		
	}
	
}
	
	
	
	
	
	
	
	
	
