package org.freecrm.contact;

import org.freecrm.contacts.ContactsPage;
import org.freecrm.datadriven.DataProviderPage;
import org.freecrm.skeleton.BaseClass;
import org.freecrm.utility.CybageLogger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactsTest extends BaseClass{

	private ContactsPage contactspage;

	
	 @BeforeClass
	    public void initializeResources() {
		 contactspage = new ContactsPage(browserDriver);
	     CybageLogger.info("Initialized the POM object for Contacts page.");
	    }
	
	 
	 
	 
	 @Test(priority=0, description = "This test method is used to Inspect Webelements present under Contacts")
	 public void assertContactsButtons(){
		 contactspage.hoverContacts();
		 Assert.assertEquals(contactspage.getlnkNewContacts().getText(), getConfig().readPropValue("pageElements", "newcontact"));
		 Assert.assertEquals(contactspage.getlnkCombinedForm().getText(), getConfig().readPropValue("pageElements", "combinedform"));
		 Assert.assertEquals(contactspage.getlnkFullSearchForm().getText(), getConfig().readPropValue("pageElements", "fullsearchform"));
		 CybageLogger.info("Asserted Elements Present under Contacts Link");
	 }
	 
	 
	 @Test(priority = 1, dataProvider="createNewContactData", dataProviderClass = DataProviderPage.class,description = "This test method is used to create a new contact" )
	 public void createNewContact(String title, String firstName, String middleName, String lastName,
			 String suffix, String filePath){
		 try{
		 contactspage.clkNewContacts();
		 contactspage.enterContactInformation(title, firstName, middleName, lastName,suffix,filePath);
		 }catch(Exception e){
			 CybageLogger.debug("Failed to Create New contact" + e);
			 Assert.fail("Create New Contacts Failed" + e);
		 }
	 }
	 
	 
	
}
