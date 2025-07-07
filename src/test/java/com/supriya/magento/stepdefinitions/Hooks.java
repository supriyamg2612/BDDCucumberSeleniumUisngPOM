package com.supriya.magento.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.supriya.magento.base.BasePage;
import com.supriya.magento.pages.HomePage;
import com.supriya.magento.utilities.DriverUtility;
import com.supriya.magento.utilities.PropertyUtility;
import com.supriya.magento.utilities.ScreenshotUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
	
	
	public static WebDriver driver;
	
	@Before
    public void setup() throws Exception {
        driver = DriverUtility.getDriver();
        
       
        HomePage homePage = new HomePage(driver);
       
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                String screenshotPath = ScreenshotUtility.captureScreenshot(driver,scenario.getName().replaceAll(" ", "_"));
                System.out.println("Screenshot saved at: " + screenshotPath);
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }

     DriverUtility.quitDriver();
    }
}