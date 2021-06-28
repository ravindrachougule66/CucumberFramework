package com.vtiger.stepDefinitions;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepdefinition extends BaseTest {
	//public WebDriver driver;
	public LoginPage lp ;
	public HomePage hp ;
	
	 @Before
	    public void beforeScenario(){
	        System.out.println("This will run before the Scenario");
	    } 
	 
	 @After
	    public void afterScenario(){
	        System.out.println("This will run after the Scenario");
	    }
	
	@Given("^: Application should be launched with <url>$")
	public void application_should_be_launched_with_url() throws Throwable {
		
		readSetting();
		logger = extent.createTest("valid Login_TC01");
	}

	@When("^: user enters valid userid and password$")
	public void user_enters_valid_userid_and_password() throws Throwable {
		lp = new LoginPage(driver);
		lp.SetUserName("admin");
		lp.SetPassword("admin");
	}
	
	@When("^: user enters valid \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enters_valid_and_password(String userid, String pwd) throws Throwable {
		lp = new LoginPage(driver);
		lp.SetUserName(userid);
		lp.SetPassword(pwd);
	}

	@When("^: user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		
		lp.Clicklogin();
	}

	@Then("^: user should be navigated on home page$")
	public void user_should_be_navigated_on_home_page() throws Throwable {
		 hp = new HomePage(driver);
		hp.verifymyupcomingactivity();
	}

	@Then("^: user can see logout link available at home page$")
	public void user_can_see_logout_link_available_at_home_page() throws Throwable {
		
		hp.logout();
		extent.flush();
	}
	
	@Then("^close browser$")
	public void close_browser() throws Throwable {
		
		driver.quit();
	}


}
