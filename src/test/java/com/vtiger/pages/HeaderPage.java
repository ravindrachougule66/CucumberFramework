package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class HeaderPage {
	
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public HeaderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New Lead")
	WebElement newlead;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(linkText="Accounts")
	WebElement Accounts;
	
	public void ClickAccounts()
	{
		cm.ClickElement(driver, Accounts,"Accounts Tab");
	}
	
	public void logout()
	{
		cm.ClickElement(driver, logout,"Logout");
	}
	
	public void ClickNewLead()
	{
		cm.ClickElement(driver, newlead,"New Lead");
	}


}
