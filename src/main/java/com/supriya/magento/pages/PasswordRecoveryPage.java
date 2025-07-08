package com.supriya.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecoveryPage {
	
	WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   
}
