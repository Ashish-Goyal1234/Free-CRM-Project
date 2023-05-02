
package org.freecrm.listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.freecrm.utility.ApplicationConfiguration;
import org.freecrm.utility.BrowserFactory;
import org.freecrm.utility.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SuiteListener implements ISuiteListener {

	public  WebDriver webDriverInstance;
	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extent;

	@Override
	public void onStart(ISuite suite) {
		performStartupActivities(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
		closeBrowserDriver(suite);
		performCleanupActivities(suite);
	}

	private void performStartupActivities(ISuite suite) {
		ApplicationConfiguration config = readConfigurationFile(suite);
		loadBrowserDriverInstance(suite, config);
		String filePath = System.getProperty("user.dir") + File.separator + config.getextentReportsPath();
		filePath += new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		try {
			Files.createDirectories(Paths.get(filePath));
		} catch (IOException e) {
			Logger.debug("Error while creating  extent file report directory", e);
		}
		htmlReporter = new ExtentHtmlReporter(
				filePath + "//Extent_" + new Date().toString().replace(":", "-") + ".html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Extent reports");
		htmlReporter.config().setReportName("Automation Test Result");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		suite.setAttribute("extentReport", extent); // Setting extent value in extentReport

		extent.setSystemInfo("Automation Tester", "Ashish Goyal");
		extent.setSystemInfo("Organization", "Ashish Automation Labs");
		extent.setSystemInfo("Build No", "WA-11122");
		extent.setSystemInfo("Runtype", config.getLocalOrRemote());
		extent.setSystemInfo("URL", config.getUrl());
		extent.setSystemInfo("Browser", config.getBrowserName());
	}

	private ApplicationConfiguration readConfigurationFile(ISuite suite) {
		ApplicationConfiguration config = new ApplicationConfiguration();
		config.loadConfiguration();
		suite.setAttribute("configurations", config);
		return config;
	}

	private void loadBrowserDriverInstance(ISuite suite, ApplicationConfiguration config) {
		BrowserFactory browserFactory = new BrowserFactory();
		if (config.getLocalOrRemote().equalsIgnoreCase("local")) {
			if (config.getRunParallel().equalsIgnoreCase("false")) {
				webDriverInstance = browserFactory.getBrowser(config.getBrowserName());
			} else if (config.getRunParallel().equalsIgnoreCase("true")) {
				String[] browsers = config.getMultipleBrowserNames().split(",");
				for (String browser : browsers) {
					webDriverInstance = browserFactory.getBrowser(browser);
				}
			}
			setTimeouts(config, webDriverInstance.manage());
			webDriverInstance.manage().window().maximize();
			suite.setAttribute("driverForBrowser", webDriverInstance);
			webDriverInstance.get(config.getUrl());
		} else if (config.getLocalOrRemote().equalsIgnoreCase("remote")) {
			/*try {
				webDriverInstance = (WebDriver) suite.getAttribute("driverForBrowser");
				webDriverInstance = browserFactory.getRemoteBrowser(config.getBrowserName());
				setTimeouts(config, webDriverInstance.manage());
				webDriverInstance.manage().window().maximize();
				if (webDriverInstance != null) {
					suite.setAttribute("driverForBrowser", webDriverInstance);
					webDriverInstance.get(config.getUrl());
				}
			} catch (Exception e) {
				Logger.error("Failed to load remote browser", e);
			}
		}*/
		}
	}

	private void setTimeouts(ApplicationConfiguration config, Options optionsInstance) {
		setImplicitTimeOutForBrowser(config, optionsInstance);
		setPageLoadTimeOutForBrowser(config, optionsInstance);
		setScriptTimeOutForBrowser(config, optionsInstance);
		Logger.info("Initialized Timeout settings.");
	}

	private void setImplicitTimeOutForBrowser(ApplicationConfiguration config, Options optionsInstance) {
		optionsInstance.timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitTimeout()));
	}

	private void setPageLoadTimeOutForBrowser(ApplicationConfiguration config, Options optionsInstance) {
		optionsInstance.timeouts().pageLoadTimeout(Duration.ofSeconds(config.getPageLoadTimeout()));
	}

	private void setScriptTimeOutForBrowser(ApplicationConfiguration config, Options optionsInstance) {
		optionsInstance.timeouts().scriptTimeout(Duration.ofSeconds(config.getScriptTimeout()));
	}

	private void closeBrowserDriver(ISuite suite) {
		webDriverInstance = (WebDriver) suite.getAttribute("driverForBrowser");
		webDriverInstance.quit();
		Logger.info("Closed Browser window.");
	}

	private void performCleanupActivities(ISuite suite) {
		extent.flush();
		suite.removeAttribute("driverForBrowser");
		suite.removeAttribute("configurations");
	}

	/*
	 * public void loadEmailReportInstance( ) { ApplicationConfiguration config =
	 * readConfigurationFile(suite);
	 * 
	 * SendEmailableReportTest emailRpt = new SendEmailableReportTest();
	 * 
	 * String filePath = System.getProperty("user.dir") + "\\" +
	 * config.getextentReportsPath(); filePath += new SimpleDateFormat("dd-MM-yyyy")
	 * .format(new Date());
	 * 
	 * String reportPath = filePath+ "\\";
	 * 
	 * emailRpt.testSendEmailableReportTest(config.getExcelSheetPath(),
	 * config.getEmailAddressSheetName(), reportPath,
	 * config.getEmailAddressHostName(), config.getEmailAddressUserName(),
	 * config.getEmailAddressPassword(), config.getEmailFromAddress(),
	 * config.getEmailFromName(), config.getEmailSubject(),
	 * config.getEmailMessage()); }
	 */

}
