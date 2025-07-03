package com.supriya.magento.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.supriya.magento.utilities.PropertyUtility;

import io.cucumber.java.Before;


public class Hooks {
	
	
	public static WebDriver driver;
	
	@Before
    public void setup() throws Exception {
		String browserName = PropertyUtility.readProperty("browser"); //reading browser name
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			driver = new ChromeDriver();
		}

		if(browserName.equalsIgnoreCase("firefox")) {

		System.setProperty("webdriver.gecko.driver", "driver/geckodriver");

		driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();

		driver.get(PropertyUtility.readProperty("url"));
		}
	
	
}
