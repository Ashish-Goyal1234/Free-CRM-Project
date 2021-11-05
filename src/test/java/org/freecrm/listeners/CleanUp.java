package org.freecrm.listeners;

import org.freecrm.utility.CybageLogger;

public class CleanUp extends SuiteListener{
    /**
     * Quits the browser driver window.
     */
    public void closeBrowserDriver() {
        webDriverInstance.quit();
        CybageLogger.info("Closed browser window.");
    }
    
    
    public void sendEmailReport() {
        loadEmailReportInstance();
    }
}
