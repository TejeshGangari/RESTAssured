package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

	public Properties prop;
	public FileInputStream fi;
	
	public BaseClass() {
		prop = new Properties();
		try {
			fi = new FileInputStream(new File(System.getProperty("user.dir")+"\\config.properties"));
			prop.load(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
