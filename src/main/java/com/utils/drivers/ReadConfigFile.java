/**
 * @author PrepelRa
 * ReadConfigFile
 */

package com.utils.drivers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigFile {

	private static Properties prop;

	static {
		try {
			prop = new Properties();

			prop.load(new FileInputStream("config.properties"));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}
}