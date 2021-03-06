package org.bioconductor.packages.caAffy;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Wed Feb 28 09:49:05 2007. 
	* It represents the S4 Class ExpressoParameter in R package caAffy. 
	*	This and related classes influences
	*	evaluation of object caExpresso in R package
	*	caAffy.
	*/


public class ExpressoParameter implements java.io.Serializable  {
	private String[] backgroundCorrectMethod;
	private org.bioconductor.packages.caAffy.NormalizeMethodParameter normalizeMethodParameter;
	private String[] pmCorrectMethod;
	private String[] probeSummaryMethod;

	public ExpressoParameter() {
		this.backgroundCorrectMethod = new String[]{"rma"};
		this.normalizeMethodParameter = new org.bioconductor.packages.caAffy.NormalizeMethodParameter();
		this.pmCorrectMethod = new String[]{"pmonly"};
		this.probeSummaryMethod = new String[]{"avgdiff"};
	}

	public ExpressoParameter(
		String[] backgroundCorrectMethod,
		org.bioconductor.packages.caAffy.NormalizeMethodParameter normalizeMethodParameter,
		String[] pmCorrectMethod,
		String[] probeSummaryMethod){

		this.backgroundCorrectMethod = backgroundCorrectMethod;
		this.normalizeMethodParameter = normalizeMethodParameter;
		this.pmCorrectMethod = pmCorrectMethod;
		this.probeSummaryMethod = probeSummaryMethod;
	}

	/**
	* Sets the backgroundCorrectMethod value for this ExpressoParameter
	*
	* @param	backgroundCorrectMethod	Object of class "character", indicating
	*	the backaground correct method for evaluation.
	*	Valid options are one of "none", "rma", "rma2",
	*	"mas".
	*/
	public void setBackgroundCorrectMethod(String[] backgroundCorrectMethod) {
		this.backgroundCorrectMethod = backgroundCorrectMethod;
	}

	/**
	* Gets the backgroundCorrectMethod value for this ExpressoParameter
	*
	* @return	the value of backgroundCorrectMethod
	*	Object of class "character", indicating
	*	the backaground correct method for evaluation.
	*	Valid options are one of "none", "rma", "rma2",
	*	"mas".
	*/
	public String[] getBackgroundCorrectMethod() {
		return backgroundCorrectMethod;
	}

	/**
	* Sets the normalizeMethodParameter value for this ExpressoParameter
	*
	* @param	normalizeMethodParameter	Object of class "character", indicating
	*	the backaground correct method for evaluation.
	*	Valid options are one of "none", "rma", "rma2",
	*	"mas".
	*/
	public void setNormalizeMethodParameter(org.bioconductor.packages.caAffy.NormalizeMethodParameter normalizeMethodParameter) {
		this.normalizeMethodParameter = normalizeMethodParameter;
	}

	/**
	* Gets the normalizeMethodParameter value for this ExpressoParameter
	*
	* @return	the value of normalizeMethodParameter
	*	Object of class "character", indicating
	*	the backaground correct method for evaluation.
	*	Valid options are one of "none", "rma", "rma2",
	*	"mas".
	*/
	public org.bioconductor.packages.caAffy.NormalizeMethodParameter getNormalizeMethodParameter() {
		return normalizeMethodParameter;
	}

	/**
	* Sets the pmCorrectMethod value for this ExpressoParameter
	*
	* @param	pmCorrectMethod	Object of class "character", indicating
	*	the backaground correct method for evaluation.
	*	Valid options are one of "none", "rma", "rma2",
	*	"mas".
	*/
	public void setPmCorrectMethod(String[] pmCorrectMethod) {
		this.pmCorrectMethod = pmCorrectMethod;
	}

	/**
	* Gets the pmCorrectMethod value for this ExpressoParameter
	*
	* @return	the value of pmCorrectMethod
	*	Object of class "character", indicating
	*	the backaground correct method for evaluation.
	*	Valid options are one of "none", "rma", "rma2",
	*	"mas".
	*/
	public String[] getPmCorrectMethod() {
		return pmCorrectMethod;
	}

	/**
	* Sets the probeSummaryMethod value for this ExpressoParameter
	*
	* @param	probeSummaryMethod	Object of class "character", indicating
	*	the backaground correct method for evaluation.
	*	Valid options are one of "none", "rma", "rma2",
	*	"mas".
	*/
	public void setProbeSummaryMethod(String[] probeSummaryMethod) {
		this.probeSummaryMethod = probeSummaryMethod;
	}

	/**
	* Gets the probeSummaryMethod value for this ExpressoParameter
	*
	* @return	the value of probeSummaryMethod
	*	Object of class "character", indicating
	*	the backaground correct method for evaluation.
	*	Valid options are one of "none", "rma", "rma2",
	*	"mas".
	*/
	public String[] getProbeSummaryMethod() {
		return probeSummaryMethod;
	}

	/**
	* Print this ExpressoParameter to String
	*
	* @return	contents of ExpressoParameter as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("backgroundCorrectMethod=" + java.util.Arrays.toString( backgroundCorrectMethod ));
		res.append(", ");
		res.append("normalizeMethodParameter=" + String.valueOf( normalizeMethodParameter ));
		res.append(", ");
		res.append("pmCorrectMethod=" + java.util.Arrays.toString( pmCorrectMethod ));
		res.append(", ");
		res.append("probeSummaryMethod=" + java.util.Arrays.toString( probeSummaryMethod ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this ExpressoParameter with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			ExpressoParameter obj = (ExpressoParameter)inputObject;
			Object inputBackgroundCorrectMethod = obj.getBackgroundCorrectMethod();
			if((backgroundCorrectMethod==null)||(inputBackgroundCorrectMethod==null))
				res = res&&(backgroundCorrectMethod==inputBackgroundCorrectMethod);
			else
				res = res&&java.util.Arrays.equals(backgroundCorrectMethod, (String[])inputBackgroundCorrectMethod);
			Object inputNormalizeMethodParameter = obj.getNormalizeMethodParameter();
			if((normalizeMethodParameter==null)||(inputNormalizeMethodParameter==null))
				res = res&&(normalizeMethodParameter==inputNormalizeMethodParameter);
			else
				res = res&&normalizeMethodParameter.equals(inputNormalizeMethodParameter);
			Object inputPmCorrectMethod = obj.getPmCorrectMethod();
			if((pmCorrectMethod==null)||(inputPmCorrectMethod==null))
				res = res&&(pmCorrectMethod==inputPmCorrectMethod);
			else
				res = res&&java.util.Arrays.equals(pmCorrectMethod, (String[])inputPmCorrectMethod);
			Object inputProbeSummaryMethod = obj.getProbeSummaryMethod();
			if((probeSummaryMethod==null)||(inputProbeSummaryMethod==null))
				res = res&&(probeSummaryMethod==inputProbeSummaryMethod);
			else
				res = res&&java.util.Arrays.equals(probeSummaryMethod, (String[])inputProbeSummaryMethod);
		}
		return res;
	}

}
