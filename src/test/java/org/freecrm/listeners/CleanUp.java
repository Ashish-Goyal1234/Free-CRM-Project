package org.freecrm.listeners;

import org.freecrm.utility.Logger;

public class CleanUp extends SuiteListener{
    /**
     * Quits the browser driver window.
     */
    public void closeBrowserDriver() {
        webDriverInstance.quit();
        Logger.info("Closed browser window.");
    }
    
    
   /* public void sendEmailReport() {
        loadEmailReportInstance();
    }*/
}
