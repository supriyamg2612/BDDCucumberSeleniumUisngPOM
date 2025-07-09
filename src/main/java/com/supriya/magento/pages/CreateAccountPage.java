package com.supriya.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {
	
	WebDriver driver ;
	WebDriverWait wait;
	
	
	public CreateAccountPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	
	
	 @FindBy(xpath = "//span[text()='Create New Customer Account']")
	public WebElement pageHeadTitlField;
	
	 @FindBy(xpath = "//span[text()='Personal Information']")
	    private WebElement personalInfosection;
	 
	 @FindBy(xpath = "//span[text()='Sign-in Information']")
	    private WebElement signInInfoSection;
	 
	 @FindBy(id = "firstname")
	    private WebElement firstNameField;
	 
	 @FindBy(id = "lastname")
	    private WebElement lastNameField;
	 
	 @FindBy(id = "email_address")
	    private WebElement emailField;
	 
	 @FindBy(id = "password")
	    private WebElement passwordField;
	 
	 @FindBy(id = "password-confirmation")
	    private WebElement confirmPasswordField;
	
	 
	 @FindBy(xpath = "//button[@title='Create an Account']")
	    private WebElement createAccountButtonFiled;
	 
	 
	 public boolean isPageHeadTitlFieldVisible() {
	        return pageHeadTitlField.isDisplayed();
	    }
	 
	 public boolean isSignInInfoSectionVisible() {
	        return signInInfoSection.isDisplayed();
	    }
	 
	 
	 public boolean isPersonalInfosectionVisible() {
	        return personalInfosection.isDisplayed();
	    }
	 
	 
	 
		public boolean isFirstNamedFieldVisible() {
	        return firstNameField.isDisplayed() && firstNameField.isEnabled();
	    }
		
		
		public boolean isLastNamedFieldVisible() {
	        return lastNameField.isDisplayed() && lastNameField.isEnabled();
	    }
		
	 
		public boolean isEmailFieldVisible() {
	        return emailField.isDisplayed() && emailField.isEnabled();
	    }
		
		public boolean isPasswordFieldVisible() {
	        return passwordField.isDisplayed() && emailField.isEnabled();
	    }
		
		public boolean isConfirmPasswordFieldVisible() {
	        return confirmPasswordField.isDisplayed() && confirmPasswordField.isEnabled();
	    }
		
		public boolean createAccountButtonFieldVisible() {
	        return createAccountButtonFiled.isDisplayed();
	    }
		
		
		public String getFirstNamePlaceholder() {
		    return firstNameField.getAttribute("placeholder");
		}

		public String getLastNamePlaceholder() {
		    return lastNameField.getAttribute("placeholder");
		}

		public String getEmailPlaceholder() {
		    return emailField.getAttribute("placeholder");
		}

		public String getPasswordPlaceholder() {
		    return passwordField.getAttribute("placeholder");
		}

		public String getConfirmPasswordPlaceholder() {
		    return confirmPasswordField.getAttribute("placeholder");
		}
		
		
		
		
		
}
