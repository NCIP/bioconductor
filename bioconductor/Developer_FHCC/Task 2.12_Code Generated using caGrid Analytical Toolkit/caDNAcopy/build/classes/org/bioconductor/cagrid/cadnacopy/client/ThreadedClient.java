package org.bioconductor.cagrid.cadnacopy.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.axis.utils.ClassUtils;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyPortType;
import org.bioconductor.cagrid.cadnacopy.stubs.service.CaDNAcopyServiceAddressingLocator;
import org.bioconductor.cagrid.cadnacopy.common.CaDNAcopyI;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.0
 */

/**
 * Simple integration test client using a mock data set
 *
 **/
 
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThreadedClient extends ServiceSecurityClient implements CaDNAcopyI {	
	protected CaDNAcopyPortType portType;
	private Object portTypeMutex;

	public ThreadedClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public ThreadedClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	   	initialize();
	}
	
	public ThreadedClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public ThreadedClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
		initialize();
	}
	
	private void initialize() throws RemoteException {
	    this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private CaDNAcopyPortType createPortType() throws RemoteException {

		CaDNAcopyServiceAddressingLocator locator = new CaDNAcopyServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = ClassUtils.getResourceAsStream(getClass(), "client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		CaDNAcopyPortType port = null;
		try {
			port = locator.getCaDNAcopyPortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:" + e.getMessage(), e);
		}

		return port;
	}
	
	public GetResourcePropertyResponse getResourceProperty(QName resourcePropertyQName) throws RemoteException {
		return portType.getResourceProperty(resourcePropertyQName);
	}

	public static void usage(){
		System.out.println(ThreadedClient.class.getName() + " -url <service url>");
	}

    private static void head(org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment segment,
			     int from, int to) {
	for (int i = from; i < to; ++i) {
	    System.out.println(segment.getSampleId()[i] + "\t" +
			       segment.getChromosomeIndex()[i] + "\t" + 
			       segment.getStartMapPosition()[i] + "\t" +
			       segment.getEndMapPosition()[i] + "\t" +
			       segment.getMarkersPerSegment()[i] + "\t" +
			       segment.getAverageSegmentValue()[i]);
	}
    }
    
    public static void main(String [] args){
	System.out.println("Running caDNAcopy grid service client");
	try{
	    if(!(args.length < 2)){
		if(args[0].equals("-url")){
		    ThreadedClient client = new ThreadedClient(args[1]);

		    org.bioconductor.cagrid.cadnacopy.DNAcopyParameter dnacopyParameter =
			new org.bioconductor.cagrid.cadnacopy.DNAcopyParameter();

		    ObjectInputStream oin=null;
		    try {
			String jDataFile = client.getClass().getResource("Data/DNAcopyAssays.data").getFile();
			FileInputStream fin  = new FileInputStream(jDataFile);
			oin = new ObjectInputStream(fin);
		    } catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		    }
		    
		    org.bioconductor.packages.caDNAcopy.DNAcopyAssays myAssays = null;
		    myAssays = (org.bioconductor.packages.caDNAcopy.DNAcopyAssays) oin.readObject();

		    // convert mapLocation from int to long
		    int[] mapLoc = myAssays.getMapLocation();
		    long[] mapLocation = new long[mapLoc.length];
		    for (int i=0; i < mapLoc.length; ++i) mapLocation[i] = mapLoc[i];
		    // convert ExpressionData
		    org.bioconductor.packages.rservices.RJNumericMatrix rjMatrix = myAssays.getLogratioValues();
		    int[] dim = rjMatrix.getDim(); // column-major order
		    double[] dat = rjMatrix.getValue();
		    String[] sampleNames = myAssays.getSampleNames();
		    System.out.println("Input dimensions: " +
				       dim[0] + " markers x " + dim[1] + " samples");
		    System.out.print("Sample names: ");
		    for (int i = 0; i < sampleNames.length; ++i)
			System.out.print(sampleNames[i] + " ");
		    System.out.println();
		    System.out.println();

		    org.bioconductor.cagrid.cadnacopy.ExpressionData[] expr =
			new org.bioconductor.cagrid.cadnacopy.ExpressionData[2];
		    for (int j=0; j < dim[1]; ++j) {
			double[] e = new double[dim[0]];
			for (int i = 0; i < dim[0]; ++i) e[i] = dat[j*dim[0]+i];
			expr[j] = new
			    org.bioconductor.cagrid.cadnacopy.ExpressionData(e, sampleNames[j]);
		    }

		    // convert data instance
		    org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dnacopyAssays = new
			org.bioconductor.cagrid.cadnacopy.DNAcopyAssays(myAssays.getChromosomeId(),
									expr,
									mapLocation);

		    // invoke method
		    System.out.println("invoking method");
		    System.out.println();
		    org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment
			res = client.caDNAcopy(dnacopyAssays, dnacopyParameter);

		    // output interesting results
		    System.out.println("Results -- first and last 5 rows:");
		    System.out.println("Sample\tChromsome\tStart\tEnd\t" +
				       "Markers\tAvg value");
		    head(res, 0, 5);
		    System.out.println("...");
		    head(res, res.getSampleId().length-5, res.getSampleId().length);
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

	public org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment caDNAcopy(org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dnacopyAssays,org.bioconductor.cagrid.cadnacopy.DNAcopyParameter dnacopyParameter) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"caDNAcopy");
        org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequest params = new org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequest();
        org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyAssays dnacopyAssaysContainer = new org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyAssays();
        dnacopyAssaysContainer.setDNAcopyAssays(dnacopyAssays);
        params.setDnacopyAssays(dnacopyAssaysContainer);
        org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyParameter dnacopyParameterContainer = new org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyParameter();
        dnacopyParameterContainer.setDNAcopyParameter(dnacopyParameter);
        params.setDnacopyParameter(dnacopyParameterContainer);
        org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyResponse boxedResult = portType.caDNAcopy(params);
        return boxedResult.getDerivedDNAcopySegment();
      }
    }
	public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"getServiceSecurityMetadata");
        gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest params = new gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest();
        gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataResponse boxedResult = portType.getServiceSecurityMetadata(params);
        return boxedResult.getServiceSecurityMetadata();
      }
    }

}
