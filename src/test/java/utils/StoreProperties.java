package utils;

import java.io.FileReader;
import java.util.Properties;

import os.OSType;

@SuppressWarnings("all")
public class StoreProperties {
	private static final String PROPERTIES_FILENAME = "store-automation.properties";
	private static final Properties properties = loadProperties(PROPERTIES_FILENAME);
//	public static final DriverFactory.DriverType BROWSER = DriverFactory.DriverType
//			.getDriver(properties.getProperty("BROWSER"));
	public static final OSType OS = OSType.getOS();
	private static final String PROTOCOL = properties.getProperty("PROTOCOL");
	private static final String HOST = properties.getProperty("HOST");
	public static final String URL = String.format("%s://%s", PROTOCOL, HOST);

	public static Properties loadProperties(String file) {
		Properties properties = new Properties();
		try {
			FileReader fr = new FileReader(file);
			properties.load(fr);
		} catch (Exception e) {
			throw new RuntimeException("Exception In ProjectProperties.loadProperties():" + e.getMessage(), e);
		}
		return properties;
	}
}
