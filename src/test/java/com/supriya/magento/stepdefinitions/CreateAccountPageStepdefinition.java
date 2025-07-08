package com.supriya.magento.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.supriya.magento.pages.CreateAccountPage;
import com.supriya.magento.pages.HomePage;
import com.supriya.magento.utilities.PropertyUtility;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateAccountPageStepdefinition {
	
	WebDriver driver = Hooks.driver;
	 HomePage homepage =new HomePage(driver);
	 CreateAccountPage createAccountPage = new CreateAccountPage(driver);
	
	
	@Given("the user navigates to the Create Account page")
	public void the_user_navigates_to_the_create_account_page() throws Exception {
		Assert.assertTrue("❌ Browser window was not opened or is not visible.",
                driver.getWindowHandles().size() > 0);
		 driver.get(PropertyUtility.readProperty("url"));
		  homepage.handleCookieConsent("consent");
		  homepage.clickCreateAccountLink();
		  System.out.println("✅ Create Account Page");
		  
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String expectedTitle) {
		  String actualTitle = driver.getTitle();
		  Assert.assertEquals("❌ Page title did not match!", expectedTitle, actualTitle);
		  System.out.println("✅ Page title verified: " + actualTitle);
	}
	
	 @Then("the URL should be {string}")
	    public void the_url_should_be(String expectedURL) {
	        String actualURL = driver.getCurrentUrl();
	        Assert.assertEquals("❌ URL did not match!", expectedURL, actualURL);
	        System.out.println("✅ URL verified: " + actualURL);
	    }
	 
	 @Then("the page should be secure")
	    public void the_page_should_be_secure() {
	        String currentUrl = driver.getCurrentUrl();
	        Assert.assertTrue("❌ Page is not secure (HTTPS missing)!", currentUrl.startsWith("https://"));
	        System.out.println("✅ Page is secure (HTTPS confirmed)");
	 }
	 
	

	 @Then("the {string} section should be visible")
	 public void the_section_should_be_visible(String sectionName) {
		 switch (sectionName) {
		 case "Personal Information":
			 Assert.assertTrue("❌ Personal Information section not visible",
                     createAccountPage.isPersonalInfosectionVisible());
			 System.out.println("✅ 'Personal Information' section is visible");
			  break;
		    case "Sign-in Information":
		    	Assert.assertTrue("❌ Sign-in Information section not visible",
                        createAccountPage.isSignInInfoSectionVisible());
                System.out.println("✅ 'Sign-in Information' section is visible");
                break;

		    default:
                Assert.fail("❌ Unknown section name: " + sectionName);
		 
		 }
	 }
	 
	 @Then("the page title heading {string} should be visible")
	 public void the_page_title_heading_should_be_visible(String expectedHeading) {
		 Assert.assertTrue("❌ Page title heading is not visible!",
		            createAccountPage.isPageHeadTitlFieldVisible());
		 
		 String actualHeading = createAccountPage.pageHeadTitlField.getText().trim();
		 Assert.assertEquals("❌ Page heading text did not match!", expectedHeading, actualHeading);

		    System.out.println("✅ Page title heading '" + actualHeading + "' is visible and correct.");
		}
	 
	 
	 @Then("the {string} field should be visible and editable")
	 public void the_field_should_be_visible_and_editable(String fieldName) {
		 boolean isEditable = false;
		 switch(fieldName) {
		 case "First Name":
			 isEditable=createAccountPage.isFirstNamedFieldVisible();
			 break;
		 case "Last Name":
	            isEditable = createAccountPage.isLastNamedFieldVisible();
	            break;
		 case "Email":
	            isEditable = createAccountPage.isEmailFieldVisible();
	            break;
	        case "Password":
	            isEditable = createAccountPage.isPasswordFieldVisible();
	            break;
	        case "Confirm Password":
	            isEditable = createAccountPage.isConfirmPasswordFieldVisible();
	            break;
	       
	        default:
	            Assert.fail("❌ Unknown field: '" + fieldName + "'");
	    }
		 Assert.assertTrue("❌ '" + fieldName + "' field is not visible or editable.", isEditable);
		 }
	 
	 @And("{string} button should be visible")
	 public void button_should_be_visible(String buttonName) {
	     boolean isVisible = false;

	     if (buttonName.equals("Create an Account")) {
	         isVisible = createAccountPage.createAccountButtonFieldVisible();
	     } else {
	         Assert.fail("❌ Unknown button: '" + buttonName + "'");
	     }

	     Assert.assertTrue("❌ '" + buttonName + "' button is not visible.", isVisible);
	     System.out.println("✅ '" + buttonName + "' button is visible.");
	 }
	     
	 }


	 





