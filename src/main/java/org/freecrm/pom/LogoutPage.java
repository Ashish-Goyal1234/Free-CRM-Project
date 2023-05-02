package org.freecrm.pom;

import org.freecrm.skeleton.BaseClass;
import org.freecrm.utility.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BaseClass{
    
    
    public LogoutPage(WebDriver paramDriver) {
        PageFactory.initElements(paramDriver, this);
        Logger.info("Initialized Logout page POM elements.");
    }
    
    @FindBy(xpath="(//a[@class='topnavlink'])[3]")
    private WebElement logout;
    
    public WebElement getLogoutBtn() {
        return logout;
    }
    
    public void clkLogout(){
        getLogoutBtn().click();
    }
    

    
}
