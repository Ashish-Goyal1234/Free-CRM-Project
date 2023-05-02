
package org.freecrm.login;

import org.freecrm.datadriven.DataProviderPage;
import org.freecrm.pom.LoginPage;
import org.freecrm.skeleton.BaseClass;
import org.freecrm.utility.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {

    private LoginPage loginPage;

    @BeforeClass
    public void initializeResources() {
        loginPage = new LoginPage(browserDriver);
        Logger.info("Initialized the POM object for Login page.");
    }

    @Test( priority = 1, dataProviderClass = DataProviderPage.class, dataProvider = "CredentailsTestData12")
    public void testLogin(String userName, String password) {
      try {
    	  loginPage.enterUsername(userName);
          loginPage.enterPassword(password);
          loginPage.clkLoginButton();
      } catch(Exception| AssertionError e) {
    	  e.printStackTrace();
    	  Assert.fail("testLogin - testcase is fail " + e);
      }
    }

   
    @Test(priority = 0)
    public void verifyPresenceOfElements() {
    	try {
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
                Logger.error("Login elements are not present.");
            } else {
            Logger.info("Login elements are present.");
            }
    	} catch(Exception| AssertionError e) {
    		e.printStackTrace();
    		Assert.fail("verifyPresenceOfElements testcase is fail " + e);
    	}
        
    }
}