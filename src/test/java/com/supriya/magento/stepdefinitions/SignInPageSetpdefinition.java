package com.supriya.magento.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.supriya.magento.pages.HomePage;
import com.supriya.magento.pages.SignInPage;
import com.supriya.magento.utilities.PropertyUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SignInPageSetpdefinition {
	
	WebDriver driver = Hooks.driver;
	SignInPage signInPage = new SignInPage(driver);
	 HomePage homepage =new HomePage(driver);
	
	
	@Given("the user navigates to the login page")
	public void the_user_navigates_to_the_login_page() throws Exception {
		 driver.get(PropertyUtility.readProperty("url"));
	      homepage.handleCookieConsent("consent");
	      homepage.clickSignInLink();
	        System.out.println("✅ Navigated to Login Page");
	    
	}

	@Then("the email input field should be visible")
	public void the_email_input_field_should_be_visible() {
	   Assert.assertTrue("❌ Email input field is not visible on the login page.", signInPage.isEmailFieldVisible());
	}

	@Then("the password input field should be visible")
	public void the_password_input_field_should_be_visible() {
		 Assert.assertTrue("❌ Password input field is not visible on the login page.", signInPage.isPasswordFieldVisible());
	}

	@Then("the {string} button should be visible")
	public void the_button_should_be_visible(String buttonLabel) {
		if (buttonLabel.equalsIgnoreCase("Sign In")) {
            Assert.assertTrue("❌ 'Sign In' button is not visible on the login page.", signInPage.isSignInButtonVisible());
        } else {
            Assert.fail("⚠ Unsupported button label: " + buttonLabel);
        }
    }
	
	@Then("the {string} link should be visible")
	public void the_link_should_be_visible(String linkText) {
		boolean isVisible = false;
	    switch (linkText.toLowerCase()) {
	        case "forgot your password?":
	            isVisible = signInPage.isForgotPasswordLinkVisible();
	            break;
	        case "create an account":
	            isVisible = signInPage.isCreateAccountLinkVisible();
	            break;
	        default:
	            Assert.fail("⚠ Unsupported link: " + linkText);
	    }

	    Assert.assertTrue("❌ '" + linkText + "' link is not visible on the login page.", isVisible);
	}
	}

	





