package properties_file_reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Properties_File_Reader {
	String value = null;

	public String reader() throws FileNotFoundException {

		File file = new File("D:/selenium web driver/_COACH/src/main/java/Config/data.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Enumeration keyValues = prop.keys();

		while (keyValues.hasMoreElements()) {
			String key = (String) keyValues.nextElement();
			value = prop.getProperty(key);
		}
		return value;

	}

}
