package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class AccountPage extends HeaderPage {
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public AccountPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@name='accountname'])[2]")
	WebElement accountname;
	
	
	public void searchAccount(String acc)
	{
		ClickAccounts();
		cm.EnterValue(driver, accountname, acc,"accountname");
	}
	

}
