package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.testng.asserts.SoftAssert;

import BasePack.BaseClass;

public class POM_MyRecommendations extends BaseClass
{
	SoftAssert sa;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[3]/div/div[2]/div[2]/div/div[2]/div/div[4]/div/span/a/div/span")
	WebElement myaccount;
	
	@FindBy(linkText = "My recommendations")
	WebElement myrec;
	
	@FindBy(className = "titleCartridge Heading ")
	WebElement text;
	
	@FindBy(id = "username") 
	WebElement uname;
	 
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(css = "#login-form > div > div:nth-child(7) > button") 
	WebElement log;
	
	
	public POM_MyRecommendations()
	{
		PageFactory.initElements(d, this);		
	}
	
	public void Navigate() throws InterruptedException
	{
		Actions ac=new Actions(d);
		ac.moveToElement(myaccount).build().perform();
		myaccount.click();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		uname.sendKeys(BaseClass.username);
		pass.sendKeys(BaseClass.password);
		log.click();
		
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		Actions ac2=new Actions(d);
		ac2.moveToElement(myaccount).build().perform();	
		myrec.click();		
	
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		String actual=text.getText();		
		String expected="People with a similar purchase history also bought";
		sa.assertEquals(actual, expected);
	}	
}
