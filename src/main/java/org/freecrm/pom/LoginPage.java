
package org.freecrm.pom;

import java.time.Duration;

import org.freecrm.utility.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriverWait waitForReload;

    public LoginPage(WebDriver paramDriver) {
    	waitForReload = new WebDriverWait(paramDriver, Duration.ofMinutes(5));
        PageFactory.initElements(paramDriver, this);
        Logger.info("Initialized Login page POM elements.");
    }
    
    @FindBy(linkText = "Home")
    private WebElement lnkHome;
    
    @FindBy(linkText = "Sign Up")
    private WebElement lnkSignUp;
    
    @FindBy(linkText = "Pricing")
    private WebElement lnkPricing;
    
    @FindBy(linkText = "Features")
    private WebElement lnkFeatures;
    
    @FindBy(linkText = "Customers")
    private WebElement lnkCustomers;
    
    @FindBy(linkText = "Contact")
    private WebElement lnkContacts;
    
    @FindBy(name = "username")
    private WebElement txtUsername;
    
    @FindBy(name = "password")
    private WebElement txtPassword;
    
    @FindBy(xpath="//input[@type='submit']")
    private WebElement btnSubmit;
    
    
    public WebElement getHomeLink() {
        return lnkHome;
    }
    
    
    public WebElement getSignUpLink() {
        return lnkSignUp;
    }
    
    public WebElement getPricingLink() {
        return lnkPricing;
    }
    
    public WebElement getFeaturesLink() {
        return lnkFeatures;
    }

    public WebElement getCustomersLink() {
        return lnkCustomers;
    }
    
    public WebElement getContactsLink() {
        return lnkContacts;
    }
    

    public WebElement getTxtUsername() {
        return txtUsername;
    }
    
    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public WebElement getBtnLoginButton() {
        return btnSubmit;
    }

    public void enterUsername(String username) {
    	getTxtUsername().clear();
        getTxtUsername().sendKeys(username);
        Logger.info("Entered username " + username);
    }

    /**
     * This method sets the provided password in the password text field.
     * 
     * @param password String value containing the password
     */
    public void enterPassword(String password) {
    	waitForReload.until(ExpectedConditions.elementToBeClickable(txtPassword)).clear();
    	waitForReload.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(password);
        Logger.info("Entered password " + password);
    }

    /**
     * This method perform click operation on the login button.
     */
    public void clkLoginButton() {
        getBtnLoginButton().click();
        Logger.info("Clicked on the login button.");
    }
    
}
