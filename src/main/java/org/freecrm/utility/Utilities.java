package org.freecrm.utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This is a Utility class and contains methods which are used to by other
 * classes in the framework.
 * 
 * @author Ashish-Hp
 *
 */
public class Utilities {
    
    /**
     * This method helps to wait element for input milliseconds
     * 
     * @param millis
     */
    public static void tempMethodForThreadSleep(int millis) {
        try {
            Logger.info("Thread.sleep for " + millis + " milliseconds.");
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Logger.error("Interrupted Exception : ", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * This method captures screenshots
     * 
     * @param testMethodName
     * @param driver
     * @param path
     */

    public static void captureScreenShots(String testMethodName,
            WebDriver driver, String path) {
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        try {
            File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(new Utilities()
                    .buildScreenshotFilePath(path, testMethodName)));
        } catch (Exception e) {
            Logger.fatal("Screenshot Failed :", e);
        }
    }

    

    /**
     * This method captures screenshots using Robot class
     * 
     * @param testMethodName
     * @param path
     * @return
     */
    public static String captureScreenshotWithRobot(String testMethodName,
            String path) {
        try {
            Robot robotClassObject = new Robot();
            Rectangle screenSize = new Rectangle(
                    Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage tmp = robotClassObject
                    .createScreenCapture(screenSize);

            path = new Utilities().buildScreenshotFilePath(path,
                    testMethodName);
            File screenshotFile = new File(path);
            FileUtils.touch(screenshotFile);
            // To copy temp image in to permanent file
            ImageIO.write(tmp, "png", screenshotFile);
        } catch (Exception e) {
            Logger.fatal("Screenshot using Robot Failed :", e);
        }

        return path;
    }
    
    
    /**
     * this method helps to build file path required for screenshot
     * 
     * @param path
     * @param testMethodName
     * @return
     */
    private String buildScreenshotFilePath(String path, String testMethodName) {
        path = System.getProperty("user.dir") + "\\" + path + getCurrentDate()
                + "\\temp";
        String fileName = testMethodName + "_" + UUID.randomUUID() + ".png";
        return path + fileName;
    }
    
    /**
     * returns current date
     * 
     * @return
     */
    public String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    
    public static void selectDropDownValue(WebDriver driver,WebElement element, String value){
    	Select drp = new Select(element);
    	drp.selectByVisibleText(value);
    	Logger.info("Select Value from dropdown : " + value);
    }
    
    public static void uploadAnImage(WebElement element, String filePath) throws InterruptedException{
    	Thread.sleep(2000);
    	WebElement UploadImg = element;
    	UploadImg.sendKeys(filePath);
    }
    

}
