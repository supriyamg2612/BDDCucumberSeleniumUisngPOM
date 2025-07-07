package com.supriya.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashBoardPage {
	
	
	
	WebDriver driver;
	 WebDriverWait wait;
	
	
	  public DashBoardPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	@FindBy(css = ".greet.welcome")  // or use exact selector from your site
	private WebElement welcomeMessage;

	
	
	
	public String getWelcomeMessage() {
		 wait = new WebDriverWait(driver, 10); // 10 is in seconds
		 wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
		    return welcomeMessage.getText().trim(); // "Welcome, Vendy Jones!"
	}

}
