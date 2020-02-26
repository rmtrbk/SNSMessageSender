package uploader.snsmessagesender.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads the properties in the properties file.
 * 
 * @author theja.kotuwella
 *
 */
public class PropertyManager {
	private final String PROPERTIES_FILE 			= "/Users/theja.kotuwella/Wellcom/Theja/SNSMessageSender/src/main/resources/properties";	
	private static final String ACCESS_KEY_PROP 	= "aws.accessKey";
	private static final String SECRET_PROP 		= "aws.secret";
	
	public static String ACCESS_KEY_ATTRIBUTE 		= "key";
	public static String SECRET_ATTRIBUTE 			= "secret";
	
	private Properties readPropertiesFile() {
		Properties prop = new Properties();
		
		try (InputStream input = new FileInputStream(PROPERTIES_FILE)) {
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		return prop;
	}
	
	public static void loadProperties() {
		PropertyManager propertyLoader = new PropertyManager();
		Properties prop = propertyLoader.readPropertiesFile();
		
		ACCESS_KEY_ATTRIBUTE 	= prop.getProperty(ACCESS_KEY_PROP);
		SECRET_ATTRIBUTE 		= prop.getProperty(SECRET_PROP);
	}
}
