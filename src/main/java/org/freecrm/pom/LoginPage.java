
package org.freecrm.pom;

import org.freecrm.utility.CybageLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver paramDriver) {
        PageFactory.initElements(paramDriver, this);
        CybageLogger.info("Initialized Login page POM elements.");
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
    
    
    
    
    /**
     * This method returns the instance of Home link
     * 
     * @return lnkHome
     */
    public WebElement getHomeLink() {
        return lnkHome;
    }
    
    
    /**
     * This method returns the instance of Sign Up link
     * 
     * @return lnkSignUp
     */
    public WebElement getSignUpLink() {
        return lnkSignUp;
    }
    
    
    /**
     * This method returns the instance of Pricing link
     * 
     * @return lnkPricing
     */
    public WebElement getPricingLink() {
        return lnkPricing;
    }
    
    
    /**
     * This method returns the instance of Features link
     * 
     * @return lnkFeatures
     */
    public WebElement getFeaturesLink() {
        return lnkFeatures;
    }
    
    
    /**
     * This method returns the instance of Customers link
     * 
     * @return lnkCustomers
     */
    public WebElement getCustomersLink() {
        return lnkCustomers;
    }
    
    
    /**
     * This method returns the instance of Contact link
     * 
     * @return lnkContacts
     */
    public WebElement getContactsLink() {
        return lnkContacts;
    }
    
    
    /**
     * Getter for txtUsername
     * 
     * @return WebElement
     */
    public WebElement getTxtUsername() {
        return txtUsername;
    }
    
    
    /**
     * Getter for txtPassword
     * 
     * @return WebElement
     */
    public WebElement getTxtPassword() {
        return txtPassword;
    }

    /**
     * Getter for btnSubmit
     * 
     * @return WebElement
     */
    public WebElement getBtnLoginButton() {
        return btnSubmit;
    }

    
    /**
     * This method sets the provided username in the username text field.
     * 
     * @param username String value containing the username
     */
    public void enterUsername(String username) {
        getTxtUsername().clear();
        getTxtUsername().sendKeys(username);
        CybageLogger.info("Entered username " + username);
    }

    /**
     * This method sets the provided password in the password text field.
     * 
     * @param password String value containing the password
     */
    public void enterPassword(String password) {
        getTxtPassword().clear();
        getTxtPassword().sendKeys(password);
        CybageLogger.info("Entered password " + password);
    }

    /**
     * This method perform click operation on the login button.
     */
    public void clkLoginButton() {
        getBtnLoginButton().click();
        CybageLogger.info("Clicked on the login button.");
    }
    
}
