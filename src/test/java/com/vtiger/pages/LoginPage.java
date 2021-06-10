package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class LoginPage {
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="user_name")
	WebElement elmUserid;	
	
	@FindBy(name="user_password")
	WebElement elmPwd;
	
	@FindBy(name="Login")
	WebElement elmBtn;
	
	
	
	/*
	By elmUserid = By.name("user_name");
	By elmPwd = By.name("user_password");
	By elmBtn = By.name("Login");
	
	WebElement elm = driver.findElement(By.name("user_name"));
	*/
	
	public void SetUserName(String userid)
	{
		cm.EnterValue(driver,elmUserid, userid,"UserName");
	}
	
	public void SetPassword(String pwd)
	{
		cm.EnterValue(driver,elmPwd, pwd,"Password");
	}
	
	public void Clicklogin()
	{
		cm.ClickElement(driver,elmBtn,"Login button");
	}
	
	public void login(String userid,String pwd)
	{
		cm.EnterValue(driver,elmUserid, userid,"UserName");
		cm.EnterValue(driver,elmPwd, pwd,"Password");
		cm.ClickElement(driver,elmBtn,"Login button");
	}

}
