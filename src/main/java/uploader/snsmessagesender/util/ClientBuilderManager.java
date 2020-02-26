package uploader.snsmessagesender.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

/**
 * Builds the AWS clients.
 * 
 * @author theja.kotuwella
 *
 */
public class ClientBuilderManager {
	static AmazonSNS snsClient = null;
	
	public static AmazonSNS getSNSClient(){
		if(snsClient == null) {
			snsClient = AmazonSNSClientBuilder.standard()
							.withRegion(Regions.AP_SOUTHEAST_2)
							.withCredentials(getcredentials()).build();
		}
		return snsClient;
	}
	
	private static AWSStaticCredentialsProvider getcredentials() {
		AWSCredentials credentials 	= new BasicAWSCredentials(PropertyManager.ACCESS_KEY_ATTRIBUTE,
																PropertyManager.SECRET_ATTRIBUTE);
		
		AWSStaticCredentialsProvider credProv = new AWSStaticCredentialsProvider(credentials);
		
		return credProv;
	}
}
