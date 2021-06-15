package com.vtiger.lib;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.stepDefinitions.BaseTest;



public class commonfunctions {
	/*
	public WebDriver driver;
	
	public commonfunctions(WebDriver driver)
	{
		this.driver = driver;
	}
	*/
	public WebDriverWait w ;
	// Entering value into textbox
	public void EnterValue(WebDriver driver,WebElement elm, String val, String fieldname)
	{
		 w = new WebDriverWait(driver,30);	
		try
		{		
		w.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(val);
		BaseTest.logger.pass(val + " has been entered in "+fieldname);
		}
		catch(Exception e)
		{
			BaseTest.logger.fail(val + " has not been entered in "+fieldname);
			BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
			System.out.println(e.getMessage());
		}		
	}
	
	
	public void SelectByIndex(WebDriver driver,WebElement elm, int val, String fieldname)
	{
		 w = new WebDriverWait(driver,30);	
		try
		{		
		w.until(ExpectedConditions.visibilityOf(elm));
		Select sel = new Select(elm);
		sel.deselectByIndex(val);
		BaseTest.logger.pass(val + "st item has been selected in "+fieldname);
		}
		catch(Exception e)
		{
			BaseTest.logger.fail(val + " has not been selected in "+fieldname);
			BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
			System.out.println(e.getMessage());
		}		
	}
	
	// click on element
		public void ClickElement(WebDriver driver,WebElement elm,String fieldname )
		{
			 w = new WebDriverWait(driver,30);	
			try
			{		
			w.until(ExpectedConditions.elementToBeClickable(elm));
			elm.click();		
			BaseTest.logger.pass(fieldname + " has been clicked");
			}
			catch(Exception e)
			{
				BaseTest.logger.fail(fieldname + " did not click");
				BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
				System.out.println(e.getMessage());
			}		
		}
		
          // verify element present
		public boolean IsElementPresent(WebDriver driver,WebElement elm,String fieldname)
		{
			 w = new WebDriverWait(driver,30);	
			boolean val = false;
			try
			{		
			w.until(ExpectedConditions.visibilityOf(elm));
			val = elm.isDisplayed();	
			BaseTest.logger.pass(fieldname + " displayed successfully");
			}
			catch(Exception e)
			{
				BaseTest.logger.fail(fieldname + " not found");
				BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
				System.out.println(e.getMessage());
			}	
			
			return val;
		}
		
		public static String getScreenshot(WebDriver driver, String screenshotName)  {
			//below line is just to append the date format with the screenshot name to avoid duplicate names		
		    String destination=null;
			try
			{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			//after execution, you could see a folder "FailedTestsScreenshots" under src folder
			destination = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//Returns the captured file path
			return destination;
		}
		
		
		public void TestDeepikaCode()
		{
			System.out.println("Deepika");
		}

}
