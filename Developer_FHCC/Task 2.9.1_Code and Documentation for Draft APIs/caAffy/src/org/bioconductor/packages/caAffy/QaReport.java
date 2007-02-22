package org.bioconductor.packages.caAffy;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Thu Feb 22 09:34:59 2007. 
	* It represents the S4 Class QaReport in R package caAffy. 
	*	This class encapsulates returned by
	*	affyQAReport as invoked by object caQAReport in R
	*	package caAffy.
	*/


public class QaReport implements java.io.Serializable  {
	private org.bioconductor.packages.caAffy.QualityControlStatistics qualityControlStatistics;
	private org.bioconductor.packages.caAffy.ProbeLevelLinearModel probeLevelLinearModel;
	private org.bioconductor.packages.rservices.RJNumericMatrix madsMatrix;
	private byte[] pdfFile;

	public QaReport() {
		this.qualityControlStatistics = new org.bioconductor.packages.caAffy.QualityControlStatistics();
		this.probeLevelLinearModel = new org.bioconductor.packages.caAffy.ProbeLevelLinearModel();
		this.madsMatrix = new org.bioconductor.packages.rservices.RJNumericMatrix();
		this.pdfFile = new byte[]{};
	}

	public QaReport(
		org.bioconductor.packages.caAffy.QualityControlStatistics qualityControlStatistics,
		org.bioconductor.packages.caAffy.ProbeLevelLinearModel probeLevelLinearModel,
		org.bioconductor.packages.rservices.RJNumericMatrix madsMatrix,
		byte[] pdfFile){

		this.qualityControlStatistics = qualityControlStatistics;
		this.probeLevelLinearModel = probeLevelLinearModel;
		this.madsMatrix = madsMatrix;
		this.pdfFile = pdfFile;
	}

	/**
	* Sets the qualityControlStatistics value for this QaReport
	*
	* @param	qualityControlStatistics	Object of class
	*	"QualityControlStatistics".
	*/
	public void setQualityControlStatistics(org.bioconductor.packages.caAffy.QualityControlStatistics qualityControlStatistics) {
		this.qualityControlStatistics = qualityControlStatistics;
	}

	/**
	* Gets the qualityControlStatistics value for this QaReport
	*
	* @return	the value of qualityControlStatistics
	*	Object of class
	*	"QualityControlStatistics".
	*/
	public org.bioconductor.packages.caAffy.QualityControlStatistics getQualityControlStatistics() {
		return qualityControlStatistics;
	}

	/**
	* Sets the probeLevelLinearModel value for this QaReport
	*
	* @param	probeLevelLinearModel	Object of class
	*	"QualityControlStatistics".
	*/
	public void setProbeLevelLinearModel(org.bioconductor.packages.caAffy.ProbeLevelLinearModel probeLevelLinearModel) {
		this.probeLevelLinearModel = probeLevelLinearModel;
	}

	/**
	* Gets the probeLevelLinearModel value for this QaReport
	*
	* @return	the value of probeLevelLinearModel
	*	Object of class
	*	"QualityControlStatistics".
	*/
	public org.bioconductor.packages.caAffy.ProbeLevelLinearModel getProbeLevelLinearModel() {
		return probeLevelLinearModel;
	}

	/**
	* Sets the madsMatrix value for this QaReport
	*
	* @param	madsMatrix	Object of class
	*	"QualityControlStatistics".
	*/
	public void setMadsMatrix(org.bioconductor.packages.rservices.RJNumericMatrix madsMatrix) {
		this.madsMatrix = madsMatrix;
	}

	/**
	* Gets the madsMatrix value for this QaReport
	*
	* @return	the value of madsMatrix
	*	Object of class
	*	"QualityControlStatistics".
	*/
	public org.bioconductor.packages.rservices.RJNumericMatrix getMadsMatrix() {
		return madsMatrix;
	}

	/**
	* Sets the pdfFile value for this QaReport
	*
	* @param	pdfFile	Object of class
	*	"QualityControlStatistics".
	*/
	public void setPdfFile(byte[] pdfFile) {
		this.pdfFile = pdfFile;
	}

	/**
	* Gets the pdfFile value for this QaReport
	*
	* @return	the value of pdfFile
	*	Object of class
	*	"QualityControlStatistics".
	*/
	public byte[] getPdfFile() {
		return pdfFile;
	}

	/**
	* Print this QaReport to String
	*
	* @return	contents of QaReport as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("qualityControlStatistics=" + String.valueOf( qualityControlStatistics ));
		res.append(", ");
		res.append("probeLevelLinearModel=" + String.valueOf( probeLevelLinearModel ));
		res.append(", ");
		res.append("madsMatrix=" + String.valueOf( madsMatrix ));
		res.append(", ");
		res.append("pdfFile=" + java.util.Arrays.toString( pdfFile ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this QaReport with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			QaReport obj = (QaReport)inputObject;
			Object inputQualityControlStatistics = obj.getQualityControlStatistics();
			if((qualityControlStatistics==null)||(inputQualityControlStatistics==null))
				res = res&&(qualityControlStatistics==inputQualityControlStatistics);
			else
				res = res&&qualityControlStatistics.equals(inputQualityControlStatistics);
			Object inputProbeLevelLinearModel = obj.getProbeLevelLinearModel();
			if((probeLevelLinearModel==null)||(inputProbeLevelLinearModel==null))
				res = res&&(probeLevelLinearModel==inputProbeLevelLinearModel);
			else
				res = res&&probeLevelLinearModel.equals(inputProbeLevelLinearModel);
			Object inputMadsMatrix = obj.getMadsMatrix();
			if((madsMatrix==null)||(inputMadsMatrix==null))
				res = res&&(madsMatrix==inputMadsMatrix);
			else
				res = res&&madsMatrix.equals(inputMadsMatrix);
			Object inputPdfFile = obj.getPdfFile();
			if((pdfFile==null)||(inputPdfFile==null))
				res = res&&(pdfFile==inputPdfFile);
			else
				res = res&&java.util.Arrays.equals(pdfFile, (byte[])inputPdfFile);
		}
		return res;
	}

}
