package org.freecrm.skeleton;

import org.freecrm.datadriven.DataDrivenScript;
import org.freecrm.utility.ApplicationConfiguration;
import org.freecrm.utility.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    protected WebDriver                browserDriver;
    protected DataDrivenScript         DrivenScript;
    protected ApplicationConfiguration config;
    
    
    /**
     * This method perform operations required before the test begins.
     * 
     * @param context Context Instance
     */
    @BeforeClass
    public void preProcessor(ITestContext context) {
        ISuite suite = context.getSuite();
        browserDriver = (WebDriver) suite.getAttribute("driverForBrowser");
        DrivenScript = new DataDrivenScript();
        config = (ApplicationConfiguration) suite
                .getAttribute("configurations");
        Logger.setClass(this);
        Logger.startTestCase(this.getClass().getSimpleName());
    }

    /**
     * This method perform operations required after the test of a class have
     * ended.
     */
    @AfterClass
    public void postProcessor() {
        Logger.endTestCase(this.getClass().getSimpleName());
    }

    /**
     * Returns the webdriver instance.
     * 
     * @return browserDriver instance
     */
    public WebDriver getBrowserDriver() {
        return browserDriver;
    }

    /**
     * Returns the ApplicationConfiguration Instance.
     * 
     * @return config ApplicationConfiguration
     */
    public ApplicationConfiguration getConfig() {
        return config;
    }
    
    
    /**
     * This is returns the data driven class to read the data from the xlsx file
     * 
     * @return object of data driven
     */
    public DataDrivenScript getExcelDataDriven() {
        return DrivenScript;
    }
}
