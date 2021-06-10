package com.vtiger.stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.lib.Xls_Reader;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public List<List<String>> ls;
	
	
	public void readSetting() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/vtiger/config/setting.properties");
	    prop.load(fis);	    
	    createReport();
	    launchApplication();
	}
	
	
	public void launchApplication()
	{
		//logger = extent.createTest("Opening application and perform login");
		if(prop.getProperty("browser").equals("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", "C:/Selenium/Selenium_Software/chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		
		if(prop.getProperty("browser").equals("firefox"))
		{
		//System.setProperty("webdriver.gecko.driver", "C:/Selenium/Selenium_Software/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		int time = Integer.parseInt(prop.getProperty("wait"));
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		/*
		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("userid"), prop.getProperty("pwd"));
		extent.flush();
		*/
	}
	
	public void createReport() 
	{
		DateFormat f = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		Date d = new Date();
		String str = f.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+str+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.DARK); 
	}
	
	public List<List<String>> ReadExcelDataintoList(String path, String sheet)
	{
		Xls_Reader xr = new Xls_Reader(path);
		//Xls_Reader xr = new Xls_Reader(System.getProperty("user.dir")+"/src/TestCases/TestData.xlsx");
		int rowcount = xr.getRowCount(sheet);
		int colcount = xr.getColumnCount(sheet);
		List<List<String>> ls = new ArrayList<List<String>>();
		
		List<String> lst=null ;
		for(int i=1;i<=rowcount;i++)
		{
			 lst = new ArrayList<String>();
			 
			for(int j=0;j<=colcount;j++)
			{
				String data = xr.getCellData(sheet, j, i).trim();
				lst.add(data);
			}
			
			ls.add(lst);
			
		}	
		
		return ls;
		
	}
	
	
	@AfterSuite
	public void closeBrowser()
	{
		HeaderPage hp=new HeaderPage(driver);
		hp.logout();
		driver.quit();
	}
	
	

}
