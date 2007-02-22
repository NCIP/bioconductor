
package org.bioconductor.rserviceJms.worker;
import java.io.*;
import java.util.*;

/**

 * RWorkerProperties defines the properties for RWorker
 * auto-generated by R function getRWebServicesProperties, Thu Feb 22 09:35:00 2007
 */
public class RWorkerProperties extends Properties
{
	public RWorkerProperties() throws Exception
	{
		super();
		try{
			load(getClass().getResourceAsStream("RWebServices4java.properties"));
		} catch(IOException e){
			System.err.println(e.getMessage());
			throw new Exception("File RWebServices4java.properties not found.");
		}
	}
}
