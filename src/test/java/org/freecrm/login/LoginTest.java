
package org.freecrm.login;

import org.freecrm.datadriven.DataProviderPage;
import org.freecrm.pom.LoginPage;
import org.freecrm.skeleton.BaseClass;
import org.freecrm.utility.CybageLogger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {

    private LoginPage loginPage;

    
    /**
     * This method initializes required instances for test.
     * 
     * @author Ashish-HP
     */
    @BeforeClass
    public void initializeResources() {
        loginPage = new LoginPage(browserDriver);
        CybageLogger.info("Initialized the POM object for Login page.");
    }

    /**
     * This method test the login credentials supplied to it via DataProvider
     * method 'CredentailsTestData'. This method also depends on method
     * 'verifyPresenceOfElements'
     * 
     * @param username String Username to test.
     * @param password String password to test.
     * @param result String Expected result of the login attempt.
     */

    
    @Test( priority = 1, dataProviderClass = DataProviderPage.class, dataProvider = "CredentailsTestData12")
    public void testLogin(String userName, String password) {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clkLoginButton();
    }

    /**
     * This method checks if elements required for login are present or not.
     */
    @Test(priority = 0)
    public void verifyPresenceOfElements() {
        int elementCount = 0;
        elementCount += (loginPage.getHomeLink() == null ? 0 : 1);
        elementCount += (loginPage.getSignUpLink() == null ? 0 : 1);
        elementCount += (loginPage.getPricingLink() == null ? 0 : 1);
        elementCount += (loginPage.getFeaturesLink() == null ? 0 : 1);
        elementCount += (loginPage.getCustomersLink() == null ? 0 : 1);
        elementCount += (loginPage.getContactsLink() == null ? 0 : 1);
        elementCount += (loginPage.getBtnLoginButton() == null ? 0 : 1);
        elementCount += (loginPage.getTxtPassword() == null ? 0 : 1);
        elementCount += (loginPage.getTxtUsername() == null ? 0 : 1);
        if (elementCount != 9) {
            Assert.fail("Elements not present");
            CybageLogger.error("Login elements are not present.");
        }
        CybageLogger.info("Login elements are present.");
    }
}