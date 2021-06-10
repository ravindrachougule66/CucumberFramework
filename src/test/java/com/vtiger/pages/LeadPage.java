package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class LeadPage extends HeaderPage {
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public LeadPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="salutationtype")
	WebElement salutaion;
	
	@FindBy(name="firstname")
	WebElement fname;
	
	@FindBy(name="lastname")
	WebElement lname;
	
	@FindBy(name="company")
	WebElement company;
	
	@FindBy(name="button")
	WebElement save;
	
	
	
	
	public void createleadwithMandatoryField(String lastname,String comp)
	{	
		ClickNewLead();
		cm.EnterValue(driver, lname, lastname,"lastname");
		cm.EnterValue(driver, company, comp,"company");
		cm.ClickElement(driver, save,"save button");
	}
	
	public void createleadwithAllField(String sal,String firstname,String lastname,String comp)
	{
		ClickNewLead();
		cm.EnterValue(driver, salutaion, sal,"salutaion");
		cm.EnterValue(driver, fname, firstname,"firstname");
		cm.EnterValue(driver, lname, lastname,"lastname");
		cm.EnterValue(driver, company, comp,"company");
		cm.ClickElement(driver, save,"save");
	}
	
	
	
	

}
