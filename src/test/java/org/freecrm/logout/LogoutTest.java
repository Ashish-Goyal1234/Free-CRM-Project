package org.freecrm.logout;

import org.freecrm.pom.LogoutPage;
import org.freecrm.skeleton.BaseClass;
import org.freecrm.utility.CybageLogger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This class contains the test methods to handle the test cases related to the
 * logout use cases.
 * 
 * @author Ashish-Hp
 *
 */

public class LogoutTest extends BaseClass{
    LogoutPage            logoutPage;

    /**
     * This method initializes required instances for test.
     */
    @BeforeClass
    public void initializeResources() {
        logoutPage = new LogoutPage(browserDriver);
        CybageLogger.info("Initialized the POM object for Login page.");
    }
    
    
    @Test
    public void performLogout() throws InterruptedException{
        logoutPage.clkLogout();
    }
    
    
    
}
