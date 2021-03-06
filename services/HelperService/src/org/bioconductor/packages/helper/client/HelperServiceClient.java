package org.bioconductor.packages.helper.client;

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

import org.bioconductor.packages.helper.stubs.HelperServicePortType;
import org.bioconductor.packages.helper.stubs.service.HelperServiceAddressingLocator;
import org.bioconductor.packages.helper.common.HelperServiceI;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

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
public class HelperServiceClient extends HelperServiceClientBase implements HelperServiceI {	

	public HelperServiceClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public HelperServiceClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	}
	
	public HelperServiceClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public HelperServiceClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
	}

	public static void usage(){
		System.out.println(HelperServiceClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  HelperServiceClient client = new HelperServiceClient(args[1]);
			  // place client calls here if you want to use this main as a
			  // test....
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

  public java.lang.String testContextLookup(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"testContextLookup");
    org.bioconductor.packages.helper.stubs.TestContextLookupRequest params = new org.bioconductor.packages.helper.stubs.TestContextLookupRequest();
    org.bioconductor.packages.helper.stubs.TestContextLookupRequestSessionIdentifier sessionIdentifierContainer = new org.bioconductor.packages.helper.stubs.TestContextLookupRequestSessionIdentifier();
    sessionIdentifierContainer.setSessionIdentifier(sessionIdentifier);
    params.setSessionIdentifier(sessionIdentifierContainer);
    org.bioconductor.packages.helper.stubs.TestContextLookupResponse boxedResult = portType.testContextLookup(params);
    return boxedResult.getResponse();
    }
  }

  public org.bioconductor.cagrid.statefulservices.CaGridFileReferenceCollection getUploadFileReferences(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier,org.bioconductor.cagrid.rservices.FileReferenceCollection fileReferenceCollection) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getUploadFileReferences");
    org.bioconductor.packages.helper.stubs.GetUploadFileReferencesRequest params = new org.bioconductor.packages.helper.stubs.GetUploadFileReferencesRequest();
    org.bioconductor.packages.helper.stubs.GetUploadFileReferencesRequestSessionIdentifier sessionIdentifierContainer = new org.bioconductor.packages.helper.stubs.GetUploadFileReferencesRequestSessionIdentifier();
    sessionIdentifierContainer.setSessionIdentifier(sessionIdentifier);
    params.setSessionIdentifier(sessionIdentifierContainer);
    org.bioconductor.packages.helper.stubs.GetUploadFileReferencesRequestFileReferenceCollection fileReferenceCollectionContainer = new org.bioconductor.packages.helper.stubs.GetUploadFileReferencesRequestFileReferenceCollection();
    fileReferenceCollectionContainer.setFileReferenceCollection(fileReferenceCollection);
    params.setFileReferenceCollection(fileReferenceCollectionContainer);
    org.bioconductor.packages.helper.stubs.GetUploadFileReferencesResponse boxedResult = portType.getUploadFileReferences(params);
    return boxedResult.getCaGridFileReferenceCollection();
    }
  }

  public org.bioconductor.cagrid.statefulservices.CaGridObjectReference getUploadObjectReference(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getUploadObjectReference");
    org.bioconductor.packages.helper.stubs.GetUploadObjectReferenceRequest params = new org.bioconductor.packages.helper.stubs.GetUploadObjectReferenceRequest();
    org.bioconductor.packages.helper.stubs.GetUploadObjectReferenceRequestSessionIdentifier sessionIdentifierContainer = new org.bioconductor.packages.helper.stubs.GetUploadObjectReferenceRequestSessionIdentifier();
    sessionIdentifierContainer.setSessionIdentifier(sessionIdentifier);
    params.setSessionIdentifier(sessionIdentifierContainer);
    org.bioconductor.packages.helper.stubs.GetUploadObjectReferenceResponse boxedResult = portType.getUploadObjectReference(params);
    return boxedResult.getCaGridObjectReference();
    }
  }

  public org.bioconductor.cagrid.statefulservices.CaGridObjectReference getDownloadObjectReference(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getDownloadObjectReference");
    org.bioconductor.packages.helper.stubs.GetDownloadObjectReferenceRequest params = new org.bioconductor.packages.helper.stubs.GetDownloadObjectReferenceRequest();
    org.bioconductor.packages.helper.stubs.GetDownloadObjectReferenceRequestSessionIdentifier sessionIdentifierContainer = new org.bioconductor.packages.helper.stubs.GetDownloadObjectReferenceRequestSessionIdentifier();
    sessionIdentifierContainer.setSessionIdentifier(sessionIdentifier);
    params.setSessionIdentifier(sessionIdentifierContainer);
    org.bioconductor.packages.helper.stubs.GetDownloadObjectReferenceResponse boxedResult = portType.getDownloadObjectReference(params);
    return boxedResult.getCaGridObjectReference();
    }
  }

  public org.bioconductor.cagrid.rservices.FileReferenceCollection getFileReferenceCollection(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getFileReferenceCollection");
    org.bioconductor.packages.helper.stubs.GetFileReferenceCollectionRequest params = new org.bioconductor.packages.helper.stubs.GetFileReferenceCollectionRequest();
    org.bioconductor.packages.helper.stubs.GetFileReferenceCollectionRequestSessionIdentifier sessionIdentifierContainer = new org.bioconductor.packages.helper.stubs.GetFileReferenceCollectionRequestSessionIdentifier();
    sessionIdentifierContainer.setSessionIdentifier(sessionIdentifier);
    params.setSessionIdentifier(sessionIdentifierContainer);
    org.bioconductor.packages.helper.stubs.GetFileReferenceCollectionResponse boxedResult = portType.getFileReferenceCollection(params);
    return boxedResult.getFileReferenceCollection();
    }
  }

}
