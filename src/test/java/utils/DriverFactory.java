package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

	// chrome driver supplier
	private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chrome_drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		return new ChromeDriver();
	};

	// firefox driver supplier
	private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\firefox_drivers\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "browser_logs.txt");
		return new FirefoxDriver();
	};

	// add more suppliers here

	// add all the drivers into a map
	static {
		driverMap.put(DriverType.CHROME, chromeDriverSupplier);
		driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
	}

	// return a new driver from the map
	public static final WebDriver getDriver(DriverType type) {
		return driverMap.get(type).get();
	}

	public enum DriverType {
		CHROME("chrome"), FIREFOX("firefox"), SAFARI("safari"), IE("ie");

		private String name;

		DriverType(String name) {
			this.name = name;
		}

		public static DriverType getDriver(String name) {
			for (DriverType browser : DriverType.values()) {
				if (browser.getName().equalsIgnoreCase(name))
					return browser;
			}
			// Default browser if string input is incorrect
			return CHROME;
		}

		public String getName() {
			return name;
		}

	}

}
