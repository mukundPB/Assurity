package Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	private static Properties properties = new Properties();

	static {
		try {
			InputStream fileInput = ConfigProperties.class.getClassLoader()
					.getSystemResourceAsStream("config/config.properties");
			properties.load(fileInput);
			fileInput.close();

		} catch (FileNotFoundException e) {
			System.err.println("Unable to find config.properties file - FileNotFoundException: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Exception on loading stream file to properties object: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public ConfigProperties() {
	}

	public String getPropertyValue(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	/******************************************************************************
	 * Get URL
	 ******************************************************************************/
	public String getURL() {
		return properties.getProperty("url");
	}

	/******************************************************************************
	 * Get  Catalog 
	 ******************************************************************************/
	public String getCatalog() {
		return properties.getProperty("catalog");
	}
	
	/******************************************************************************
	 * Get  Name
	 ******************************************************************************/
	public String getName() {
		return properties.getProperty("name");
	}
	
	/******************************************************************************
	 * Get  CanRelist 
	 ******************************************************************************/
	public String getCanRelist() {
		return properties.getProperty("canRelist");
	}
	
	/******************************************************************************
	 * Get  descname
	 ******************************************************************************/
	public String getDescname() {
		return properties.getProperty("descname");
	}
	
	/******************************************************************************
	 * Get  description
	 ******************************************************************************/
	public String getDescription() {
		return properties.getProperty("description");
	}

}
