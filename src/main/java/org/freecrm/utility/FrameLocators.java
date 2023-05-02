package org.freecrm.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class FrameLocators {


    private WebDriver            browserDriverInstance;
	private WebDriverWait waitForReload;
    
    
    public FrameLocators(WebDriver paramDriver) {
    	waitForReload = new WebDriverWait(paramDriver, Duration.ofMinutes(10));
        this.browserDriverInstance = paramDriver;
        PageFactory.initElements(browserDriverInstance, this);
    }
    
    @FindBy(name = "mainpanel")
    WebElement mainPanelFrame;
    
    
    
    /**
     * Returns webElement mainPanelFrame
     * 
     * @return frmPimStudio
     */
    public WebElement getMainPanelFrame() {
        return mainPanelFrame;
    }
    
    
    public void switchToMainPanelFrame(){
    	browserDriverInstance.switchTo().defaultContent();
		waitForReload.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(mainPanelFrame));
    }
    
}
