
package org.freecrm.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class ready the properties file and extract the properties.
 *
 */

public class ApplicationConfiguration {

    private Properties prop;

    /**
     * This method reads the properties file.
     */
    public void loadConfiguration() {
        if (prop == null) {
            try {
                prop = new Properties();
                String paths = System.getProperty("user.dir")
                        + IConstants.PROPERTIES_FILE;
                FileInputStream fis;
                fis = new FileInputStream(paths);
                prop.load(fis);
            } catch (IOException e) {
                CybageLogger.fatal("Failed to load Configuration" + e);
            }
            CybageLogger.info("Successfully load the configuration..!");
        }
    }

    /**
     * @return String Url from properties file, null if its not present.
     */
    public String getUrl() {
        if (prop != null) {
            return prop.getProperty("url");
        }
        return null;
    }
    
    /**
     * @return String local or remote execution from properties file, null if its not present.
     */
    public String getLocalOrRemote() {
        if (prop != null) {
            return prop.getProperty("localOrRemote");
        }
        return null;
    }

    /**
     * @return String Browser Name from properties file, null if its not
     *         present.
     */
    public String getBrowserName() {
        if (prop != null) {
            return prop.getProperty("browser");
        }
        return null;
    }

    /**
     * @return String Implicit timeout from properties file, 0 if its not
     *         present.
     */
    public int getImplicitTimeout() {
        if (prop != null) {
            return Integer.parseInt(prop.getProperty("implicitWait"));
        }
        return 0;
    }
    
    /**
     * @return String pageload time from properties file, 0 if its not present.
     */
    public int getPageLoadTimeout() {
        if (prop != null) {
            return Integer.parseInt(prop.getProperty("pageloadTimeout"));
        }
        return 0;
    }
    
    /**
     * @return String script timeout from properties file, 0 if its not present.
     */
    public int getScriptTimeout() {
        if (prop != null) {
            return Integer.parseInt(prop.getProperty("scriptTimeout"));
        }
        return 0;
    }
    
    
    /**
     * @return String screen shot directory path from properties file, null if
     *         its not present.
     */
    public String getScreenshotPath() {
        if (prop != null) {
            return prop.getProperty("screenshotsPath");
        }
        return null;
    }
    
    /**
     * @return String reports directory path from properties file, null if its
     *         not present.
     */
    public String getextentReportsPath() {
        if (prop != null) {
            return prop.getProperty("extentReports");
        }
        return null;
    }
    
    
    /**
     * @return String Excel file directory path based on module from properties
     *         file, null if its not present.
     */
    public String getExcelSheetPath() {
        if (prop != null) {
            return prop.getProperty("emailAddressExcel");
        }
        return null;
    }
    
    
    /**
     * @return String Browser version from the properties file.
     */
    public String getBrowserVersion() {
        if (prop != null) {
            return prop.getProperty("browser.version");
        }
        return null;
    }
    
    /**
     * @return String reports directory path from properties file, null if its
     *         not present.
     */
    public String getEmailAddressSheetName() {
        if (prop != null) {
            return prop.getProperty("emailAddressSheetName");
        }
        return null;
    }
    
    
    /**
     * @return String reports directory path from properties file, null if its
     *         not present.
     */
    public String getEmailAddressHostName() {
        if (prop != null) {
            return prop.getProperty("emailAddressHostName");
        }
        return null;
    }
    
    /**
     * @return String reports directory path from properties file, null if its
     *         not present.
     */
    public String getEmailAddressUserName() {
        if (prop != null) {
            return prop.getProperty("emailAddressUserName");
        }
        return null;
    }
    
    /**
     * @return String reports directory path from properties file, null if its
     *         not present.
     */
    public String getEmailAddressPassword() {
        if (prop != null) {
            return prop.getProperty("emailAddressPassword");
        }
        return null;
    }
    
    /**
     * @return String reports directory path from properties file, null if its
     *         not present.
     */
    public String getEmailFromAddress() {
        if (prop != null) {
            return prop.getProperty("emailFromAddress");
        }
        return null;
    }
    
    
    /**
     * @return String reports directory path from properties file, null if its
     *         not present.
     */
    public String getEmailFromName() {
        if (prop != null) {
            return prop.getProperty("emailFromName");
        }
        return null;
    }
    
    
    /**
     * @return String reports directory path from properties file, null if its
     *         not present.
     */
    public String getEmailSubject() {
        if (prop != null) {
            return prop.getProperty("emailSubject");
        }
        return null;
    }
    
    
    /**
     * @return String reports directory path from properties file, null if its
     *         not present.
     */
    public String getEmailMessage() {
        if (prop != null) {
            return prop.getProperty("emailMessage");
        }
        return null;
    }
    

}
