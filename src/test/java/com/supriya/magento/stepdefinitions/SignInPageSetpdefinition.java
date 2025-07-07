package com.supriya.magento.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.supriya.magento.pages.DashBoardPage;
import com.supriya.magento.pages.HomePage;
import com.supriya.magento.pages.SignInPage;
import com.supriya.magento.utilities.PropertyUtility;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInPageSetpdefinition {
	private String email;
	private String password;
	
	WebDriver driver = Hooks.driver;
	SignInPage signInPage = new SignInPage(driver);
	 HomePage homepage =new HomePage(driver);
	 DashBoardPage dashboard = new DashBoardPage(driver);
	
	
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
	
	
	@Then("the email input field should have placeholder {string}")
	public void the_email_input_field_should_have_placeholder(String expectedPlaceholder) {
		String actualPlaceholder = signInPage.getEmailPlaceholder();
		Assert.assertEquals(
			    "❌ Email placeholder mismatch. Expected: '" + expectedPlaceholder + "', but found: '" + actualPlaceholder + "'",
			    expectedPlaceholder,
			    actualPlaceholder
			);	}

	@Then("the password input field should have placeholder {string}")
	public void the_password_input_field_should_have_placeholder(String expectedPlaceholder) {
		 String actualPlaceholder = signInPage.getPasswordPlaceholder();
		 Assert.assertEquals(
		            "❌ Password placeholder mismatch. Expected: '" + expectedPlaceholder + "', but found: '" + actualPlaceholder + "'",
		            expectedPlaceholder,
		            actualPlaceholder
		        );  
	}
	
	@When("the user enters {string} into the password field")
	public void the_user_enters_into_the_password_field(String password) {
	    signInPage.enterPassword(password); 
	}
	@Then("the password input should mask the characters")
	public void the_password_input_should_mask_the_characters() {
	    String fieldType = signInPage.getPasswordFieldType();
	    Assert.assertEquals("❌ Password field should mask characters, but it doesn't.", "password", fieldType);
	}
	
	@When("the user enters a valid {string} and {string}")
	public void the_user_enters_a_valid_and(String email, String password) {
		signInPage.enterEmail(email);
		signInPage.enterPassword(password);
	}

	@Given("the user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		signInPage.clickSignIn();
	}

	@Then("the user should see the welcome message {string}")
	public void the_user_should_see_the_welcome_message(String expectedUsername) {
		 String actualWelcomeText = dashboard.getWelcomeMessage(); // e.g., "Welcome, Vendy Jones!"

		    boolean matched = actualWelcomeText.contains(expectedUsername);

		    Assert.assertTrue(
		        "❌ Welcome message incorrect. Expected username: '" + expectedUsername + "', but found: '" + actualWelcomeText + "'",
		        matched
		    );
		    
		    
	}
	
	@When("user enters {string} and {string}")
	public void user_enters_and(String email, String password) {		
		 this.email = email;
		    this.password = password;
	        signInPage.logIntoApplication(this.email, this.password);
		
    }
	

	 @And("user clicks the {string} button")
	    public void user_clicks_the_button(String buttonText) {
		 
	       signInPage.clickSignIn();
	    }

	 @Then("the user should see an error message {string}")
	    public void the_user_should_see_an_error_message(String expectedMessage) {
		 boolean displayed;

		    switch (expectedMessage) {
		        case "This is a required field.":
		            displayed = this.email.isEmpty()
		                ? signInPage.isErrorMessageDisplayedForEmptyEmail()
		                : signInPage.isErrorMessageDisplayedForEmptyPassword();
		            break;

		        case "Please enter a valid email address (Ex: johndoe@domain.com).":
		            displayed = signInPage.isErrorMessageDisplayedForInvalidEmail();
		            break;

		        case "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.":
		            displayed = signInPage.isErrorMessageDisplayedForInvalidCredentials();
		            break;

		        default:
		            throw new IllegalArgumentException(
		                "No mapping for expected message: " + expectedMessage
		            );
		    }

		    Assert.assertTrue(
		        "Expected to see error [" + expectedMessage + "] but it was not displayed.",
		        displayed
		    );
	    }
}
	

	





