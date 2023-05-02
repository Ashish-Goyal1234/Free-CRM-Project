package org.freecrm.contacts;

import java.time.Duration;
import java.util.List;

import org.freecrm.utility.Logger;
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
		waitForReload = new WebDriverWait(paramDriver,Duration.ofMinutes(5));
		this.paramDriver = paramDriver;
		action = new Actions(paramDriver);
		PageFactory.initElements(paramDriver, this);
		Logger.info("Initialized Contacts page POM elements.");
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
	
	@FindBy(xpath="//select[@name='suffix']")
	private WebElement drpSuffix;
	
	@FindBy(name="image_file")
	private WebElement btnChooseFile;
	
	@FindBy(css="fieldset.fieldset:nth-child(3) table:nth-child(5) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) > input.button:nth-child(2)")
	private WebElement btnSave;
	
	@FindBy(name ="contact_id")
	private List<WebElement> chkBoxSelectAllContacts;
	
	@FindBy(name = "do_action")
	private WebElement drpDowndeleteChecked;
	
	@FindBy(xpath="//input[@value='DO']")
	private WebElement doBtn;
	
	
	public WebElement getDoBtn(){
		return doBtn;
	}
	
	public WebElement getdrpDownDeleteChecked(){
		return drpDowndeleteChecked;
	}
	
	public WebElement selectAllContactsCheckbox(){	
		return chkBoxSelectAllContacts.get(0);	
	}

	public WebElement getlnkNewContacts() {
		return lnkNewContacts;
	}
	
	public WebElement getlnkCombinedForm() {
		return lnkCombinedForm;
	}
	
	public WebElement getlnkFullSearchForm() {
		return lnkFullSearchForm;
	}
	
	
	public void clkNewContacts(){
		hoverContacts();
		lnkNewContacts.click();
		Logger.info("Clicked on New Contacts......!");
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
	
	
	public WebElement clkBtnSave(){
		return btnSave;
	}
	
	public void enterContactInformation(String title, String firstName, String middleName, String lastName,
			String suffix, String filePath) throws InterruptedException{
		Utilities.selectDropDownValue(paramDriver, drpTitle, title);
		waitForReload.until(ExpectedConditions.elementToBeClickable(getFirstName())).clear();
		waitForReload.until(ExpectedConditions.elementToBeClickable(getFirstName())).sendKeys(firstName);
		waitForReload.until(ExpectedConditions.elementToBeClickable(getMiddleName())).clear();
		waitForReload.until(ExpectedConditions.elementToBeClickable(getMiddleName())).sendKeys(middleName);
		waitForReload.until(ExpectedConditions.elementToBeClickable(getLastName())).clear();
		waitForReload.until(ExpectedConditions.elementToBeClickable(getLastName())).sendKeys(lastName);
		Utilities.selectDropDownValue(paramDriver, drpSuffix, suffix);
		Utilities.uploadAnImage(btnChooseFile, filePath);
		waitForReload.until(ExpectedConditions.elementToBeClickable(clkBtnSave())).click();
		Logger.info("Entered First Name as : "+firstName+" "+middleName+" "+lastName );
	}
	
	
	public void clkContactsLbl(){
		frame.switchToMainPanelFrame();
		waitForReload.until(ExpectedConditions.elementToBeClickable(lnkContacts)).click();
		Logger.info("Clicked on CONTACTS......!");
	}
	
	public void clkSelectAllContactsCheckbox(){
		waitForReload.until(ExpectedConditions.elementToBeClickable(selectAllContactsCheckbox())).click();
		Logger.info("Clicked on Select All Checkbox to select all the contacts......!");
	}
	
	public void deleteAllContacts(){
		clkSelectAllContactsCheckbox();
		Utilities.selectDropDownValue(paramDriver, getdrpDownDeleteChecked(), "Delete Checked");
		waitForReload.until(ExpectedConditions.elementToBeClickable(getDoBtn())).click();
		paramDriver.switchTo().alert().accept();
		Logger.info("Clicked on Select all checkbox and clicked on do btn");
	}
	

}
