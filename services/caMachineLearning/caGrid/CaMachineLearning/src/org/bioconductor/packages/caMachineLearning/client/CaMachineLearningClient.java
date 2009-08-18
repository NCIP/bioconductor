package org.bioconductor.packages.caMachineLearning.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import org.bioconductor.packages.caMachineLearning.stubs.CaMachineLearningPortType;
import org.bioconductor.packages.caMachineLearning.stubs.service.CaMachineLearningServiceAddressingLocator;
import org.bioconductor.packages.caMachineLearning.common.CaMachineLearningI;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

import org.bioconductor.packages.caMachineLearning.common.CaMachineLearningHelper;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.2
 */
public class CaMachineLearningClient extends CaMachineLearningClientBase implements CaMachineLearningI {	

	public CaMachineLearningClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public CaMachineLearningClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	}
	
	public CaMachineLearningClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public CaMachineLearningClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
	}

	public static void usage(){
		System.out.println(CaMachineLearningClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  CaMachineLearningClient client = new CaMachineLearningClient(args[1]);
			  // place client calls here if you want to use this main as a
			  // test....
			  String filePath = "/home/mtra2/CaGridProj/CaMachineLearning/Data/OneChannelExpressionData.rda_java.Data";
			  org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleExpDataColl = CaMachineLearningHelper.deserializeToSingleChannelExpDataCollection(filePath);
/*			  
			  org.bioconductor.cagrid.camachinelearning.HierarchicalClusteringMachineLearningParameters param = new
			                    org.bioconductor.cagrid.camachinelearning.HierarchicalClusteringMachineLearningParameters();
			  param.setAlgorithm("ward");
			  param.setDistanceMetric("euclidean");
			  param.setNumberOfClusters(2);
*/
/*			  
			  org.bioconductor.cagrid.camachinelearning.KMeansMachineLearningParameters param = new
              														org.bioconductor.cagrid.camachinelearning.KMeansMachineLearningParameters();
			  param.setAlgorithm("Forgy");
			  param.setNumberOfClusters(10);
*/	

			  String supervisedParamFilePath = "/home/mtra2/CaGridProj/CaMachineLearning/Data/LinearDiscriminantAnalysisParameters.rda_java.Data";
			  org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters param = 
				  		CaMachineLearningHelper.deserializeToCagridSupervisedMachineLearningParameters(supervisedParamFilePath);
/*					  
			  org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection result = client.learn(singleExpDataColl, param);
			  if(result != null) {
				  System.out.println("I got something back from the service.");
				  client.printOutputLearningResult(result);
			  }
*/			  
/*			  
			  org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEP = client.createCaMachineLearningSession();
			  org.bioconductor.packages.helper.common.HelperService helperService = new org.bioconductor.packages.helper.common.HelperService();
			  helperService.uploadDataObject(args[1], sessionEP, singleExpDataColl);
			  client.invokeLearn(sessionEP, param);
			  Object returnResultObj = helperService.getResultObject(args[1], sessionEP);
			  org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection resultCollection = 
				                     (org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection)returnResultObj;
			  client.printOutputLearningResult(resultCollection);
*/
			  System.out.println(client.getRpackageSessionInfo());
			  
			} else {
				usage();
				System.exit(1);
			}
		} else {
			usage();
			System.exit(1);
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void printOutputLearningResult(org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection result) 
	{
		if(result instanceof org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningResultCollection) {
			org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningResult[] resultArr = 
				((org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningResultCollection)result).getUnsupervisedMachineLearningResult();
			for(int i = 0; i < resultArr.length; i++) {
				System.out.println("At index: " + i);
				System.out.println("neighboringPartition: " + resultArr[i].getNeighboringPartition());
				System.out.println("predictedPartition: " + resultArr[i].getPredictedPartition());
				System.out.println("sihouetteWidth: " + resultArr[i].getSilhouetteWidth());
				System.out.println("sample name: " + resultArr[i].getSampleName());
				System.out.println("Done with index: " + i);
			}
		}
		else if(result instanceof org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningResultCollection) {
			org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningResult[] resultArr = 
				((org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningResultCollection)result).getSupervisedMachineLearningResult();
			for(int i = 0; i < resultArr.length; i++) {
				System.out.println("At index: " + i);
				System.out.println("isTrainingSample: " + resultArr[i].isIsTrainingSample());
				System.out.println("observedClassification: " + resultArr[i].getObservedClassification().getValue());
				System.out.println("predictedClassification: " + resultArr[i].getPredictedClassification().getValue());
				System.out.println("sample name: " + resultArr[i].getSampleName());
				System.out.println("Done with index: " + i);
			}
		}
	}

  public java.lang.String getRpackageSessionInfo() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getRpackageSessionInfo");
    org.bioconductor.packages.caMachineLearning.stubs.GetRpackageSessionInfoRequest params = new org.bioconductor.packages.caMachineLearning.stubs.GetRpackageSessionInfoRequest();
    org.bioconductor.packages.caMachineLearning.stubs.GetRpackageSessionInfoResponse boxedResult = portType.getRpackageSessionInfo(params);
    return boxedResult.getResponse();
    }
  }

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getMultipleResourceProperties");
    return portType.getMultipleResourceProperties(params);
    }
  }

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getResourceProperty");
    return portType.getResourceProperty(params);
    }
  }

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"queryResourceProperties");
    return portType.queryResourceProperties(params);
    }
  }

  public org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection learn(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChannelExpressionDataCollection,org.bioconductor.cagrid.camachinelearning.MachineLearningParameters cagridMachineLearningParameters) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"learn");
    org.bioconductor.packages.caMachineLearning.stubs.LearnRequest params = new org.bioconductor.packages.caMachineLearning.stubs.LearnRequest();
    org.bioconductor.packages.caMachineLearning.stubs.LearnRequestSingleChannelExpressionDataCollection singleChannelExpressionDataCollectionContainer = new org.bioconductor.packages.caMachineLearning.stubs.LearnRequestSingleChannelExpressionDataCollection();
    singleChannelExpressionDataCollectionContainer.setSingleChannelExpressionDataCollection(singleChannelExpressionDataCollection);
    params.setSingleChannelExpressionDataCollection(singleChannelExpressionDataCollectionContainer);
    org.bioconductor.packages.caMachineLearning.stubs.LearnRequestCagridMachineLearningParameters cagridMachineLearningParametersContainer = new org.bioconductor.packages.caMachineLearning.stubs.LearnRequestCagridMachineLearningParameters();
    cagridMachineLearningParametersContainer.setMachineLearningParameters(cagridMachineLearningParameters);
    params.setCagridMachineLearningParameters(cagridMachineLearningParametersContainer);
    org.bioconductor.packages.caMachineLearning.stubs.LearnResponse boxedResult = portType.learn(params);
    return boxedResult.getMachineLearningResultCollection();
    }
  }

  public org.bioconductor.cagrid.statefulservices.SessionEndpoint createCaMachineLearningSession() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"createCaMachineLearningSession");
    org.bioconductor.packages.caMachineLearning.stubs.CreateCaMachineLearningSessionRequest params = new org.bioconductor.packages.caMachineLearning.stubs.CreateCaMachineLearningSessionRequest();
    org.bioconductor.packages.caMachineLearning.stubs.CreateCaMachineLearningSessionResponse boxedResult = portType.createCaMachineLearningSession(params);
    return boxedResult.getSessionEndpoint();
    }
  }

  public void invokeLearn(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint,org.bioconductor.cagrid.camachinelearning.MachineLearningParameters cagridMachineLearningParameters) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"invokeLearn");
    org.bioconductor.packages.caMachineLearning.stubs.InvokeLearnRequest params = new org.bioconductor.packages.caMachineLearning.stubs.InvokeLearnRequest();
    org.bioconductor.packages.caMachineLearning.stubs.InvokeLearnRequestSessionEndpoint sessionEndpointContainer = new org.bioconductor.packages.caMachineLearning.stubs.InvokeLearnRequestSessionEndpoint();
    sessionEndpointContainer.setSessionEndpoint(sessionEndpoint);
    params.setSessionEndpoint(sessionEndpointContainer);
    org.bioconductor.packages.caMachineLearning.stubs.InvokeLearnRequestCagridMachineLearningParameters cagridMachineLearningParametersContainer = new org.bioconductor.packages.caMachineLearning.stubs.InvokeLearnRequestCagridMachineLearningParameters();
    cagridMachineLearningParametersContainer.setMachineLearningParameters(cagridMachineLearningParameters);
    params.setCagridMachineLearningParameters(cagridMachineLearningParametersContainer);
    org.bioconductor.packages.caMachineLearning.stubs.InvokeLearnResponse boxedResult = portType.invokeLearn(params);
    }
  }

  public org.bioconductor.cagrid.statefulservices.Status getStatus(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getStatus");
    org.bioconductor.packages.caMachineLearning.stubs.GetStatusRequest params = new org.bioconductor.packages.caMachineLearning.stubs.GetStatusRequest();
    org.bioconductor.packages.caMachineLearning.stubs.GetStatusRequestSessionEndpoint sessionEndpointContainer = new org.bioconductor.packages.caMachineLearning.stubs.GetStatusRequestSessionEndpoint();
    sessionEndpointContainer.setSessionEndpoint(sessionEndpoint);
    params.setSessionEndpoint(sessionEndpointContainer);
    org.bioconductor.packages.caMachineLearning.stubs.GetStatusResponse boxedResult = portType.getStatus(params);
    return boxedResult.getStatus();
    }
  }

}