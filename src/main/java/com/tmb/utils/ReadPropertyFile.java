package com.tmb.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.PropertyFileUsageException;

public class ReadPropertyFile {

	private ReadPropertyFile() {
	}

	private static Properties property = new Properties();

	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		FileInputStream file = null;
		try {

			file = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(file);
			// property object creates a Hashtable which is slow and threadsafe.
			// we can also convert property object to HashMap as in below.

			for (Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

		} catch (IOException e) {
			e.getStackTrace();
		} finally {
			if (Objects.nonNull(file)) {
				try {
					file.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}

	public static String get(ConfigProperties key) {

		if (Objects.isNull(key.name()) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
			throw new PropertyFileUsageException(
					"Key provided " + key + " is not valid. Please check config.properties file!");
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
