	package com.supriya.magento.pages;
	
	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		 
		 @FindBy(xpath = " //div[text()='Please enter a valid email address (Ex: johndoe@domain.com).']")
		    private WebElement invalidEmailError;
		 
		  @FindBy(xpath =" //div[text()='This is a required field.']" )
		    private WebElement EmptyEmailError;
		  
		  @FindBy(id = "pass-error")
		    private WebElement passError;
		  
		  @FindBy(xpath = " //div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")
		  private WebElement invalidCredentials;
		  
	
		 
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
		    
		    
		    public DashBoardPage validLogin(String email, String password) {
		        enterEmail(email);
		        enterPassword(password);
		        clickSignIn();
		        return new DashBoardPage(driver); // Navigate to DashboardPage after successful login
		    }
		    public void logIntoApplication(String email, String password) {
		        
		        enterEmail(email);
		        enterPassword(password);
		        clickSignIn();
		        }
		        
		    public boolean isErrorMessageDisplayedForEmptyEmail() {
		        return EmptyEmailError.isDisplayed();
		    }
		        
		        public boolean isErrorMessageDisplayedForInvalidEmail() {
		            return invalidEmailError.isDisplayed();
		        }
		            
		            public boolean isErrorMessageDisplayedForEmptyPassword() {
		                return passError.isDisplayed();
		            }
		            
		            public boolean isErrorMessageDisplayedForInvalidCredentials() {
		            	return invalidCredentials.isDisplayed();
		            }
		    
		    
	
		    public void clickCreateAccount() {
		    	try {
		            Actions actions = new Actions(driver);
		            actions.sendKeys(Keys.ESCAPE).perform();
		            Thread.sleep(1000);

		            WebElement body = driver.findElement(By.tagName("body"));
		            for (int i = 0; i < 3; i++) {
		                body.click();
		                Thread.sleep(500);
		            }
		            System.out.println("Attempted to close overlay ad.");
		        } catch (Exception e) {
		            System.out.println("No overlay ad to close.");
		        }
		    	

		        WebDriverWait wait = new WebDriverWait(driver, 15);
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("aswift_1")));

		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountLink);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createAccountLink);
		    }
		    
		    public PasswordRecoveryPage clickForgotPasswordLink() {
		    	try {
		            Actions actions = new Actions(driver);
		            actions.sendKeys(Keys.ESCAPE).perform();
		            Thread.sleep(1000);

		            WebElement body = driver.findElement(By.tagName("body"));
		            for (int i = 0; i < 3; i++) {
		                body.click();
		                Thread.sleep(500);
		            }
		            System.out.println("Attempted to close overlay ad.");
		        } catch (Exception e) {
		            System.out.println("No overlay ad to close.");
		        }

		        WebDriverWait wait = new WebDriverWait(driver, 15);
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("aswift_1")));

		        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forgotPasswordLink);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", forgotPasswordLink);

		        return new PasswordRecoveryPage(driver);
		    }
		    
		    public WebElement getEmailField() {
		        return emailField;
		    }

		    public WebElement getPasswordField() {
		        return passwordField;
		    }

		    public WebElement getSignInButton() {
		        return signInButton;
		    }

	}
		    
		    
	
		    
		    
		    
	
	
