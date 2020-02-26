package uploader.snsmessagesender.service;

/**
 * Messenger services interface.
 * 
 * @author theja.kotuwella
 *
 */
public interface ISNSMessengerService {
	void sendNotification(String snsTopicName, 
							String notificationSubject, 
							String notification);
}
