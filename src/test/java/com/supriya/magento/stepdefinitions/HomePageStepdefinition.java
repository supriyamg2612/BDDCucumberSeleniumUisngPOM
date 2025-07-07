package com.supriya.magento.stepdefinitions;

import java.util.List;
import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;

import com.supriya.magento.pages.HomePage;
import com.supriya.magento.utilities.PropertyUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepdefinition {

    WebDriver driver = Hooks.driver;
	 HomePage homepage =new HomePage(driver);
	
	@Given("the user has opened the browser")
	public void the_user_has_opened_the_browser() {

		 Assert.assertTrue("❌ Browser window was not opened or is not visible.",
	                driver.getWindowHandles().size() > 0);
		// Browser is launched in Hooks @Before, nothing extra here
	}
	
	
	@When("the user navigates to Home Page")
	public void the_user_navigates_to_home_page() throws Exception {
		 driver.get(PropertyUtility.readProperty("url"));
	      homepage.handleCookieConsent("consent");
	}
	

	@Then("the page should load without errors")
	public void the_page_should_load_without_errors() {
		 Assert.assertTrue("❌ The page title is empty, indicating it may not have loaded properly.",
	                driver.getTitle().length() > 0);
	}
	
	@Then("the header should be visible")
	public void the_header_should_be_visible() {
		Assert.assertTrue("❌ The header is not visible on the Home Page.",
                homepage.isHeaderVisible());
	   
	}
	@Then("the footer should be visible")
	public void the_footer_should_be_visible() {
		Assert.assertTrue("❌ The footer is not visible on the Home Page.",
                homepage.isFooterVisible());
	}
	
	@Given("the user is on the home page")

	public void the_user_is_on_the_home_page() throws Exception {
		driver.get(PropertyUtility.readProperty("url"));
	      homepage.handleCookieConsent("consent");
	}

	 @Then("the Magento logo should be visible at the top-left corner")

	public void the_magento_logo_should_be_visible_at_the_top_left_corner() {
		 Assert.assertTrue("❌ Magento logo is not visible on the Home Page. This may indicate that the page didn't load fully or elements are missing.", 
                 homepage.isMagentoLogoVisible());
	

	}

	 @Given("the user is on any page")

	public void the_user_is_on_any_page() {
		driver.get("https://magento.softwaretestingboard.com/catalogsearch/result/?q=shirt"); // example different page
		 homepage.handleCookieConsent("consent");
}

	  @When("the user clicks the Magento logo")

	public void the_user_clicks_the_magento_logo() {
		  homepage.clickMagentoLogo();
}

	 @Then("the user should be redirected to the home page")

	public void the_user_should_be_redirected_to_the_home_page() throws Exception {

		 String currentUrl = driver.getCurrentUrl();
		 String homeUrl =PropertyUtility.readProperty("url");
		 Assert.assertTrue("❌ Current URL does not contain the expected home URL", currentUrl.contains(homeUrl));
				    

	}
	 
	
	@Then("the header should display a {string} link")

	public void the_header_should_display_a_link(String linkText) {

		switch (linkText.toLowerCase()) {
		case "sign in":
			Assert.assertTrue(homepage.isSignInLinkVisible());
			break;
		case "create an account":
			Assert.assertTrue(homepage.isCreateAccountLinkVisible());
			break;
		default:
			Assert.fail("Link text not recognized: " + linkText);
		}

	}

	  @When("the user clicks the {string} link")

	public void the_user_clicks_the_link(String linkText) {
		  switch (linkText.toLowerCase()) {
		  case "sign in":
			  homepage.clickSignInLink();
			  break;
		  case "create an account":
			  homepage.clickCreateAccountLink();
			  break;
		  default:
		  Assert.fail("Link text not recognized: " + linkText);
		  
		  }
	}

	@Then("the user should be redirected to the login page")

	public void the_user_should_be_redirected_to_the_login_page() {
		Assert.assertTrue("❌ The current URL does not indicate the user is on the login page. Expected URL to contain 'customer/account/login' but was: " + driver.getCurrentUrl(),
			    driver.getCurrentUrl().contains("customer/account/login"));
			    
			
	  
}
	  

	@Then("the user should be redirected to the registration page")

	public void the_user_should_be_redirected_to_the_registration_page() {
		Assert.assertTrue("❌ The current URL does not indicate the user is on the login page. Expected URL to contain 'customer/account/create' but was: " + driver.getCurrentUrl(),driver.getCurrentUrl().contains("customer/account/create"));
	  }
	  

	@Then("the footer should be visible with all expected links and social icons")

	public void the_footer_should_be_visible_with_all_expected_links_and_social_icons() {


	 
	}

	@Given("the user opens browser console")

	public void the_user_opens_browser_console() {


	}

	@When("the user navigates to the home page")

	public void the_user_navigates_to_the_home_page() throws Exception {

	

	}

	  

	@Then("no errors should be displayed in the console")

	public void no_errors_should_be_displayed_in_the_console() {


	}

	  

	  

	  

	


	

}