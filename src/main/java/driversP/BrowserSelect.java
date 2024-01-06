package driversP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BrowserSelect {

	static Properties p = new Properties();
	static File f = new File(
			"D:\\SP Main Folder\\Java\\MyJavaProjects\\cucumberTestNG\\src\\main\\java\\utility\\config.properties");

	public static String getbrowser(String s) {

		String field = null;

		try {
			InputStream in = new FileInputStream(f);
			p.load(in);

			field = p.getProperty(s);

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("File not Find Exception");
		}
		return field;

	}

}
