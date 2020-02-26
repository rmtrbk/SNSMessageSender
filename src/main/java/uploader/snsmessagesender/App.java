package uploader.snsmessagesender;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import uploader.snsmessagesender.service.SNSMessengerServiceImpl;
import uploader.snsmessagesender.util.PropertyManager;

/**
 * Entry point to the application.
 * Main method allows to send a message to a Simple notification Service.
 * 
 * @author theja.kotuwella
 *
 */
public class App {
	private static final String SNS_TOPIC 				= "BookInventoryNotification";
	private static final String NOTIFICATION_SUBJECT 	= "Book Inventory Notification";
	private static final String NOTIFICATION_BODY 		= "This notification is sent by Book Inventory Application";
	
	private SNSMessengerServiceImpl sqsMessengerService = null;
	
	App(){
		initLog();
		
		PropertyManager.loadProperties();
		
		sqsMessengerService = new SNSMessengerServiceImpl();
	}
	
	public static void main(String[] arg) {
		App app = new App();
		
		app.sendSNSMessage(SNS_TOPIC, NOTIFICATION_SUBJECT, NOTIFICATION_BODY);
	}
	
	private void sendSNSMessage(String snsTopicName,
									String notificationSubject,
									String notification) {
		sqsMessengerService.sendNotification(snsTopicName, notificationSubject, notification);
	}
	
	private static void initLog() {
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.INFO);

		PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");
		rootLogger.addAppender(new ConsoleAppender(layout));
		
		try {
			RollingFileAppender fileAppender = new RollingFileAppender(layout, "SNSMessageSender.log");

			rootLogger.addAppender(fileAppender);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
