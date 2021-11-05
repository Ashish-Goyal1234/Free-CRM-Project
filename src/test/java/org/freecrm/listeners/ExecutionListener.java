package org.freecrm.listeners;

import org.testng.IExecutionListener;

public class ExecutionListener implements IExecutionListener {
    /**
     * Invoked before the TestNG run starts.
     */

    public void onExecutionStart() {

    }

    /**
     * Invoked once all the suites have been run.
     */

    public void onExecutionFinish() {
        CleanUp cleanup = new CleanUp();
        cleanup.closeBrowserDriver();
        //cleanup.sendEmailReport();
    }

}
