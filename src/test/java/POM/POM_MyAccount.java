package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.testng.asserts.SoftAssert;

import BasePack.BaseClass;

public class POM_MyAccount extends BaseClass
{
	SoftAssert sa;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[3]/div/div[2]/div[2]/div/div[2]/div/div[4]/div/span/a/div/span")
	WebElement myaccount;
	
	@FindBy(id = "username") 
	WebElement uname;
	 
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(css = "#login-form > div > div:nth-child(7) > button") 
	WebElement log;
	
	
	@FindBy(linkText = "My account")
	WebElement account;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div[5]/a")
	WebElement shop;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[4]/div[1]/div[2]/div/div[2]/span")
	WebElement text1;
	
	@FindBy(className = "css-9gl7u8 evu2eli18")
	WebElement viewOrders;

	@FindBy(className = "css-ww8iju e1p2iyht4")
	WebElement order;
	
	@FindBy(className = "css-1k8ky1d eqdeh202")
	WebElement orderHistory;
	
		
	public POM_MyAccount()
	{
		PageFactory.initElements(d, this);		
	}
	
	public void myAccount() throws InterruptedException
	{		
		
		  Actions ac=new Actions(d); ac.moveToElement(myaccount).build().perform();
		  myaccount.click(); d.manage().timeouts().pageLoadTimeout(20,
		  TimeUnit.SECONDS); 
		  Thread.sleep(1000); 
		  uname.sendKeys(BaseClass.username);
		  pass.sendKeys(BaseClass.password); log.click();
		  
		  d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  Thread.sleep(1000);
		  Actions ac2=new Actions(d);
		  ac2.moveToElement(myaccount).build().perform(); account.click();
		 	
		
		  d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  shop.click();
		  sa.assertEquals(text1.getText(), "Your shopping cart is currently empty");
		  
		  d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  Thread.sleep(1000); 
		  Actions ac3=new Actions(d);
		  ac3.moveToElement(myaccount).build().perform(); 
		  account.click();
		  sa.assertEquals(viewOrders.getText(), "You haven't placed an order in a while.");
		 
		  d.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS); 
		  order.click();
		  sa.assertEquals(orderHistory.getText(), "Order History");
		 
		  sa.assertAll();
	}	

}
