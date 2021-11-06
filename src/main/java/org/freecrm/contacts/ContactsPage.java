package org.freecrm.contacts;

import org.freecrm.utility.CybageLogger;
import org.freecrm.utility.FrameLocators;
import org.freecrm.utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage {

	private FrameLocators frame;
	private Actions action;
	private WebDriver paramDriver;
	private WebDriverWait waitForReload;

	public ContactsPage(WebDriver paramDriver) {

		frame = new FrameLocators(paramDriver);
		waitForReload = new WebDriverWait(paramDriver,15);
		this.paramDriver = paramDriver;
		action = new Actions(paramDriver);
		PageFactory.initElements(paramDriver, this);
		CybageLogger.info("Initialized Contacts page POM elements.");
	}

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement lnkContacts;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	private WebElement lnkNewContacts;
	
	@FindBy(xpath = "(//a[text()='Combined Form'])[2]")
	private WebElement lnkCombinedForm;
	
	@FindBy(xpath = "(//a[text()='Full Search Form'])[2]")
	private WebElement lnkFullSearchForm;
	
	@FindBy(xpath="//select[@name='title']")
	private WebElement drpTitle;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="middle_initial")
	private WebElement middleName;
	
	@FindBy(id="surname")
	private WebElement lastName;
	
	

	public WebElement getlnkNewContacts() {
		return lnkNewContacts;
	}
	
	public WebElement getlnkCombinedForm() {
		return lnkCombinedForm;
	}
	
	public WebElement getlnkFullSearchForm() {
		return lnkFullSearchForm;
	}
	
	
	public void clkNewContacts() {
		hoverContacts();
		lnkNewContacts.click();
		CybageLogger.info("Clicked on New Contacts......!");
	}
	
	public void hoverContacts(){
		frame.switchToMainPanelFrame();
		action.moveToElement(lnkContacts).build().perform();
	}
	
	public WebElement getFirstName(){
		return firstName;
	}
	
	public WebElement getMiddleName(){
		return middleName;
	}
	
	public WebElement getLastName(){
		return lastName;
	}
	
	public void enterContactInformation(String title, String firstName, String middleName, String lastName){
		Utilities.selectDropDownValue(paramDriver, drpTitle, title);
		waitForReload.until(ExpectedConditions.elementToBeClickable(getFirstName())).clear();
		waitForReload.until(ExpectedConditions.elementToBeClickable(getFirstName())).sendKeys(firstName);
		waitForReload.until(ExpectedConditions.elementToBeClickable(getMiddleName())).clear();
		waitForReload.until(ExpectedConditions.elementToBeClickable(getMiddleName())).sendKeys(middleName);
		waitForReload.until(ExpectedConditions.elementToBeClickable(getLastName())).clear();
		waitForReload.until(ExpectedConditions.elementToBeClickable(getLastName())).sendKeys(lastName);
		
		CybageLogger.info("Entered First Name as :"+firstName+" Middle Name as : "+middleName+" Last Name as : "+lastName );
		System.out.println("Entered First Name as :"+firstName+" Middle Name as : "+middleName+" Last Name as : "+lastName );
	}
	
	
	
	

}