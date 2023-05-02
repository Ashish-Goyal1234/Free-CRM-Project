package org.freecrm.logout;

import org.freecrm.pom.LogoutPage;
import org.freecrm.skeleton.BaseClass;
import org.freecrm.utility.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest extends BaseClass{
    LogoutPage            logoutPage;
   
    @BeforeClass
    public void initializeResources() {
        logoutPage = new LogoutPage(browserDriver);
        Logger.info("Initialized the POM object for Logout page.");
    }
    
    
    @Test
    public void performLogout(){
    	try {
        logoutPage.clkLogout();
    	}catch(Exception e) {
        	e.printStackTrace();
        	Assert.fail("performLogout testcase failed " + e);
        }
    }
    
    
    
}
