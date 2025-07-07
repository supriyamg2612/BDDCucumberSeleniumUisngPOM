package com.supriya.magento.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtility {
	

    private static WebDriver driver;

    
public static WebDriver getDriver() throws Exception {
    if (driver == null) {
        String browser = PropertyUtility.readProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup(); // No manual binary path needed
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    return driver;
}
public static void quitDriver() {
    if (driver != null) {
        driver.quit();
        driver = null;
    }
}
}