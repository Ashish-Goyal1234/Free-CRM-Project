package org.freecrm.utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	WebDriver driver = null;

	public WebDriver getBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
		}
		return driver;
	}

	public WebDriver getBrowser(String browserName, String browserVersion) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.getInstance().browserVersion(browserVersion).setup();
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = getChromeConfigurations();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("ie")) {
			// Need to add implementation
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Need to add implementation
		}
		if (driver != null) {
			Logger.info("Loaded Browser Driver Instance.");
		} else {
			Logger.fatal("Failed to load Browser Driver Instance.");
		}
		return driver;
	}

	/*public WebDriver getRemoteBrowser(String browserName) throws MalformedURLException {
		WebDriver remoteDriver = null;
		if (browserName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			// cap.setPlatform(Platform.MAC);
			cap.setBrowserName(BrowserType.CHROME);
			URL url = new URL("http://localhost:4545/wd/hub");
			remoteDriver = new RemoteWebDriver(url, cap);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			// cap.setPlatform(Platform.WIN8);
			cap.setBrowserName(BrowserType.FIREFOX);
			URL url = new URL("http://localhost:4545/wd/hub");
			remoteDriver = new RemoteWebDriver(url, cap);
		}
		return remoteDriver;
	}*/

	private Map<String, Object> getChromeConfigurations() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", System.getProperty("user.home") + "\\Downloads\\");
		prefs.put("safebrowsing.enabled", "false");
		prefs.put("download.prompt_for_download", "false");
		return prefs;
	}
}
