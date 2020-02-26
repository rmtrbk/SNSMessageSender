package uploader.snsmessagesender.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.Topic;

import uploader.snsmessagesender.util.ClientBuilderManager;

/**
 * Sends a message to a given SNS Topic.
 *  
 * @author theja.kotuwella
 *
 */
public class SNSMessengerServiceImpl implements ISNSMessengerService {
	private static Logger log = Logger.getLogger(SNSMessengerServiceImpl.class.getName());
	
	public void sendNotification(String snsTopicName, 
											String notificationSubject, 
											String notification) {
		
		List<Topic> topics = ClientBuilderManager.getSNSClient().listTopics().getTopics();
		
		topics.forEach(topic -> {
			if(topic.getTopicArn().endsWith(snsTopicName)) {
				
				String topicARN = topic.getTopicArn();
    		
				PublishRequest publishReq = new PublishRequest()
												.withTopicArn(topicARN)
												.withSubject(notificationSubject)
												.withMessage(notification);

				ClientBuilderManager.getSNSClient().publish(publishReq);
				
				log.info("SNSMessengerServiceImpl: Notification sent to SNS " + topicARN);
			}
		});
	}
}
