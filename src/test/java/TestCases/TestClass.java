package TestCases;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import BasePack.BaseClass;
import POM.POM_MyAccount;
import POM.POM_MyRecommendations;

public class TestClass extends BaseClass
{
	WebDriver d;
	POM_MyRecommendations p;
	POM_MyAccount ma;
	
	public TestClass()
	{
		super(); 
	}
	
	@BeforeSuite
	public void initsetup() throws InterruptedException
	{
		initialize();		
		p= new POM_MyRecommendations();
		ma=new POM_MyAccount();
	}	
	
	@Test public void navigate() throws InterruptedException
	{ 
		p.Navigate(); 
	}	  	 
	
	@Test
	public void account() throws InterruptedException
	{
		ma.myAccount();
	}		
	 
	@AfterMethod	
	public void close()
	{
		d.close();
	}
}