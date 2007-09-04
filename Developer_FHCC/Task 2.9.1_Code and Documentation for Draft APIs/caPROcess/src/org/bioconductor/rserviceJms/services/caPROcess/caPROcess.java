
package org.bioconductor.rserviceJms.services.caPROcess;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import org.bioconductor.packages.rservices.RServicesConnection;
import java.util.*;


public class caPROcess {
	private ConnectionFactory connectionFactory;
	private String queueName;
	private long timeout;
	private org.bioconductor.packages.caPROcess.caPROcess mycaPROcess;

	public caPROcess() throws Exception {
		caPROcessProperties prop = new caPROcessProperties();
		String jmsUrl = "tcp://" + prop.getProperty("jms.host") + ":"+prop.getProperty("jms.port");
		String timeoutStr = prop.getProperty("jms.timeout", "6000");
		timeout=(new Long(timeoutStr)).longValue();
		connectionFactory = new ActiveMQConnectionFactory(jmsUrl);
		queueName = "BIOC";
		mycaPROcess= new org.bioconductor.packages.caPROcess.caPROcess();
	}
	public org.bioconductor.packages.caPROcess.PeakLocation caPROcess(org.bioconductor.packages.caPROcess.MzAssays mzAssays, org.bioconductor.packages.caPROcess.PROcessParameter proCessParameter) throws java.rmi.RemoteException {
		org.bioconductor.packages.caPROcess.PeakLocation ans=null;
		try {
			Connection jmsConnection = connectionFactory.createConnection();
			RServicesConnection connection = new RServicesConnection( jmsConnection, queueName, timeout );
			 ans= mycaPROcess.caPROcess( mzAssays, proCessParameter, connection );
		} catch (Exception rex) {
			throw new java.rmi.RemoteException(rex.getMessage());
		}
		return ans;
	}
}