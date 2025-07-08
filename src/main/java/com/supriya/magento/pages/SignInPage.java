	package com.supriya.magento.pages;
	
	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
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
		        createAccountLink.click();
		    }
		    public PasswordRecoveryPage clickForgotPasswordLink() {
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forgotPasswordLink);
		        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
		        forgotPasswordLink.click();
				return new PasswordRecoveryPage(driver);
		    }
		    
	}
		    
		    
	
		    
		    
		    
	
	
