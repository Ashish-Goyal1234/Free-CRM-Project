package org.freecrm.pom;

import java.util.List;
import org.freecrm.utility.CybageLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    
    
    public LogoutPage(WebDriver paramDriver) {
        PageFactory.initElements(paramDriver, this);
        CybageLogger.info("Initialized Login page POM elements.");
    }
    
    @FindBy(css=".topnavlink")
    private List<WebElement> logout;
    
    public List<WebElement> getLogoutBtn() {
        return logout;
    }
    
    public void clkLogout() throws InterruptedException{
        getLogoutBtn().get(2).click();
    }
    

    
}
