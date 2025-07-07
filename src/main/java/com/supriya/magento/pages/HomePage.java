package com.supriya.magento.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	
	WebDriver driver ;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	
	
	 @FindBy(css = "header")  // Header section
	    private WebElement header;

	    @FindBy(css = "footer")  // Footer section
	    private WebElement footer;
	    
	    @FindBy(xpath = "//a[@aria-label='store logo']//img")  
	    private WebElement magentoLogo;

	    @FindBy(linkText = "Sign In") // Sign In link
	    private WebElement signInLink;
	    
	    @FindBy(linkText = "Create an Account") // Create an Account link
	    private WebElement createAccountLink;

	    @FindBy(xpath = "//button[@aria-label='Consent']")
		WebElement consentButton;
		
		@FindBy(xpath = "//button[@aria-label='Manage options']")
		WebElement manageOptionButton;

	    public boolean isHeaderVisible() {
	        return header.isDisplayed();
	    }

	    public boolean isFooterVisible() {
	    	wait.until(ExpectedConditions.visibilityOf(footer));
	        return footer.isDisplayed();
	    }

	     public boolean isMagentoLogoVisible() {
	        return magentoLogo.isDisplayed();
	    }

	    public void clickMagentoLogo() {
	        magentoLogo.click();
	    }

	    public boolean isSignInLinkVisible() {
	        return signInLink.isDisplayed();
	    }

	    public boolean isCreateAccountLinkVisible() {
	        return createAccountLink.isDisplayed();
	    }

	    public void clickSignInLink() {
	        signInLink.click();
	    }

	    public void clickCreateAccountLink() {
	        createAccountLink.click();
	    }
	    
	    public void handleCookieConsent(String option) {
	        try {
	        	 wait.until(ExpectedConditions.visibilityOf(consentButton));

	 	        switch (option.toLowerCase()) {
	 	            case "consent":
	 	            	consentButton.click();
	 	                break;
	 	            case "Option":
	 	            	manageOptionButton.click();
	 	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Cookie consent popup not shown or buttons not found.");
	        }
	    }
		
	}


