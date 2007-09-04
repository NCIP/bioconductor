package org.bioconductor.cagrid.cadnacopy.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public interface CaDNAcopyI {

    public org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment caDNAcopy(org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dnacopyAssays,org.bioconductor.cagrid.cadnacopy.DNAcopyParameter dnacopyParameter) throws RemoteException ;

    public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException ;

}
