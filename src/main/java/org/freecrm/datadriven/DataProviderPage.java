package org.freecrm.datadriven;

import org.freecrm.skeleton.BaseClass;
import org.testng.annotations.DataProvider;

public class DataProviderPage extends BaseClass{
    
    private static String LoginSheetName                                              = "Logintest";
    
    
    @DataProvider(name = "CredentailsTestData12")
    public static Object[][] getCredentailsTestData() {
            return DataDrivenScript.readSheetData("TestData//Login.xlsx", LoginSheetName);
    }
}
