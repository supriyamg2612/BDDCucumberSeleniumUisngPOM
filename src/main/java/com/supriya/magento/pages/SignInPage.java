package com.supriya.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	
	WebDriver driver ;
	WebDriverWait wait;
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(id = "email")
	    private WebElement emailField;
	 
	 @FindBy(id = "pass")
	    private WebElement passwordField;
	 
	
	 @FindBy(id = "send2")
	    private WebElement signInButton;
	 
	 @FindBy(linkText = "Forgot Your Password?")
	 private WebElement forgotPasswordLink;

	 
	 @FindBy(linkText = "Create an Account")
	    private WebElement createAccountLink;
	 

	 
	 @FindBy(css = ".message-error.error.message")
	    private WebElement errorMessage;
	 
	 @FindBy(css = "div.dashboard")  // Adjust selector based on actual HTML
	 private WebElement myAccountDashboard;
	 
	 
	 
	 public boolean isEmailFieldVisible() {
	        return emailField.isDisplayed();
	    }

	    public boolean isPasswordFieldVisible() {
	        return passwordField.isDisplayed();
	    }

	    public boolean isSignInButtonVisible() {
	        return signInButton.isDisplayed();
	    }
	 
	    
	    public boolean isForgotPasswordLinkVisible() {
	        return forgotPasswordLink.isDisplayed();
	    }
	    
	    
	    public boolean isCreateAccountLinkVisible() {
	        return createAccountLink.isDisplayed();
	    }
	    
	    public String getEmailPlaceholder() {
	        return emailField.getAttribute("placeholder");
	    }

	    public String getPasswordPlaceholder() {
	        return passwordField.getAttribute("placeholder");
	    }
	    
	    public String getPasswordFieldType() {
	        return passwordField.getAttribute("type");
	    }
	    
	 public void enterEmail(String email) {
	        emailField.clear();
	        emailField.sendKeys(email);
	    }
	 
	 public void enterPassword(String password) {
	        passwordField.clear();
	        passwordField.sendKeys(password);
	    }

	    public void clickSignIn() {
	        signInButton.click();
	    }
	    
	    public boolean isMyAccountDashboardVisible() {
	        try {
	            return myAccountDashboard.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	   

	    public void clickCreateAccount() {
	        createAccountLink.click();
	    }
	    
	    public boolean isErrorMessageDisplayed() {
	        try {
	            return errorMessage.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    
	    public String getErrorMessageText() {
	        if (isErrorMessageDisplayed()) {
	            return errorMessage.getText();
	        }
	        return "";
	    }

	    
	    
	    

}
