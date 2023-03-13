package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	private Properties properties;

	public void initializePropertyFile(String filePath) {
		FileInputStream fis;
		try {
			fis=new FileInputStream(filePath);
			properties=new Properties();
			properties.load(fis);
		}
		catch(IOException e) {

		}
	}
	public String getDataFromProperty(String key) {
		return properties.getProperty(key).trim();
	}
}