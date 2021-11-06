package org.freecrm.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class FrameLocators {

    private static FrameLocators locators;
    private WebDriver            browserDriverInstance;
    
    
    public FrameLocators(WebDriver paramDriver) {
        this.browserDriverInstance = paramDriver;
        PageFactory.initElements(browserDriverInstance, this);
    }
    
    @FindBy(name = "mainpanel")
    WebElement                   mainPanelFrame;
    
    
    
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
    	browserDriverInstance.switchTo().frame(mainPanelFrame);
    }
    
}
