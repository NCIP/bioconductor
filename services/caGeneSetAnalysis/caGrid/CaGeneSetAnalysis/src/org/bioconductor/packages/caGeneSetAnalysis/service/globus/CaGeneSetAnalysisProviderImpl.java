package org.bioconductor.packages.caGeneSetAnalysis.service.globus;

import org.bioconductor.packages.caGeneSetAnalysis.service.CaGeneSetAnalysisImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the CaGeneSetAnalysisImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaGeneSetAnalysisProviderImpl{
	
	CaGeneSetAnalysisImpl impl;
	
	public CaGeneSetAnalysisProviderImpl() throws RemoteException {
		impl = new CaGeneSetAnalysisImpl();
	}
	

    public org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeResponse analyze(org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequest params) throws RemoteException {
    org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeResponse boxedResult = new org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeResponse();
    boxedResult.setGeneSetAnalysisResultCollection(impl.analyze(params.getTopTable().getTopTable(),params.getGeneSetAnalysisParameters().getGeneSetAnalysisParameters()));
    return boxedResult;
  }

    public org.bioconductor.packages.caGeneSetAnalysis.stubs.GetRpackageSessionInfoResponse getRpackageSessionInfo(org.bioconductor.packages.caGeneSetAnalysis.stubs.GetRpackageSessionInfoRequest params) throws RemoteException {
    org.bioconductor.packages.caGeneSetAnalysis.stubs.GetRpackageSessionInfoResponse boxedResult = new org.bioconductor.packages.caGeneSetAnalysis.stubs.GetRpackageSessionInfoResponse();
    boxedResult.setResponse(impl.getRpackageSessionInfo());
    return boxedResult;
  }

    public org.bioconductor.packages.caGeneSetAnalysis.stubs.CreateCaGeneSetAnalysisSessionResponse createCaGeneSetAnalysisSession(org.bioconductor.packages.caGeneSetAnalysis.stubs.CreateCaGeneSetAnalysisSessionRequest params) throws RemoteException {
    org.bioconductor.packages.caGeneSetAnalysis.stubs.CreateCaGeneSetAnalysisSessionResponse boxedResult = new org.bioconductor.packages.caGeneSetAnalysis.stubs.CreateCaGeneSetAnalysisSessionResponse();
    boxedResult.setSessionIdentifier(impl.createCaGeneSetAnalysisSession());
    return boxedResult;
  }

    public org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeResponse invokeAnalyze(org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeRequest params) throws RemoteException {
    org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeResponse boxedResult = new org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeResponse();
    impl.invokeAnalyze(params.getSessionIdentifier().getSessionIdentifier(),params.getGeneSetAnalysisParameters().getGeneSetAnalysisParameters());
    return boxedResult;
  }

    public org.bioconductor.packages.caGeneSetAnalysis.stubs.GetStatusResponse getStatus(org.bioconductor.packages.caGeneSetAnalysis.stubs.GetStatusRequest params) throws RemoteException {
    org.bioconductor.packages.caGeneSetAnalysis.stubs.GetStatusResponse boxedResult = new org.bioconductor.packages.caGeneSetAnalysis.stubs.GetStatusResponse();
    boxedResult.setStatus(impl.getStatus(params.getSessionIdentifier().getSessionIdentifier()));
    return boxedResult;
  }

}
