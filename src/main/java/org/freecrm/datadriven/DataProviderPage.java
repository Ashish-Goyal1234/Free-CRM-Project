package org.freecrm.datadriven;

import org.freecrm.skeleton.BaseClass;
import org.testng.annotations.DataProvider;

public class DataProviderPage extends BaseClass{
    
    private static String LoginSheetName                                              = "Logintest";
    private static String createNewContactSheetName                                   = "ContactInformation";
    
    @DataProvider(name = "CredentailsTestData12")
    public static Object[][] getCredentailsTestData() {
            return DataDrivenScript.readSheetData("TestData//Login.xlsx", LoginSheetName);
    }
    
    @DataProvider(name = "createNewContactData")
    public static Object[][] getNewContactsTestData() {
            return DataDrivenScript.readSheetData("TestData//Data.xlsx", createNewContactSheetName);
    }
    
    
    
}
