package BasePack;


import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass
{
	
	public static Properties pro=new Properties();
	public static WebDriver d;
	public static String username;
	public static String password;
	
	public BaseClass()
	{
		try 
		{
			FileInputStream file=new FileInputStream("C:\\Users\\Manny\\eclipse-workspace\\Walmart\\src\\test\\java\\EnvironmentVariables\\Config.properties");
			pro.load(file);
		} 
		catch (FileNotFoundException e) 
		{			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	}
	
	public static void initialize() throws InterruptedException
	{
		
		
		String bname=pro.getProperty("browser");
		username=pro.getProperty("UserName");
		password=pro.getProperty("Password");
		
		if(bname.equals("Google Chrome"))
		{
			System.setProperty("Webdriver.chrome.driver","chromedriver.exe");			
			d=new ChromeDriver();			
		}
		else if(bname.equals("Firefox"))
		{
			System.setProperty("Webdriver.gecko.driver","geckodriver.exe");
			d=new  FirefoxDriver();
		}
		
		d.get(pro.getProperty("URL"));		
		d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	
		d.manage().window().maximize();	
		Thread.sleep(1000);
		
			
	}
	
}
