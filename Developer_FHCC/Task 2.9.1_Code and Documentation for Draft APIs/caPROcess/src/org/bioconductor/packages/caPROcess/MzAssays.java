package org.bioconductor.packages.caPROcess;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Mon Jan 22 14:12:15 2007. 
	* It represents the S4 Class MzAssays in R package caPROcess. 
	*/


public class MzAssays implements java.io.Serializable  {
	private Object[] rData;
	private org.bioconductor.packages.caPROcess.MzSpectrum listTemplate;

	public MzAssays() {
		this.rData = new Object[]{};
		this.listTemplate = new org.bioconductor.packages.caPROcess.MzSpectrum();
	}

	public MzAssays(
		Object[] rData,
		org.bioconductor.packages.caPROcess.MzSpectrum listTemplate){

		this.rData = rData;
		this.listTemplate = listTemplate;
	}

	/**
	* Sets the rData value for this MzAssays
	*
	* @param	rData	
	*/
	public void setRData(Object[] rData) {
		this.rData = rData;
	}

	/**
	* Gets the rData value for this MzAssays
	*
	* @return	the value of rData
	*	
	*/
	public Object[] getRData() {
		return rData;
	}

	/**
	* Sets the listTemplate value for this MzAssays
	*
	* @param	listTemplate	
	*/
	public void setListTemplate(org.bioconductor.packages.caPROcess.MzSpectrum listTemplate) {
		this.listTemplate = listTemplate;
	}

	/**
	* Gets the listTemplate value for this MzAssays
	*
	* @return	the value of listTemplate
	*	
	*/
	public org.bioconductor.packages.caPROcess.MzSpectrum getListTemplate() {
		return listTemplate;
	}

	/**
	* Print this MzAssays to String
	*
	* @return	contents of MzAssays as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("rData=" + java.util.Arrays.toString( rData ));
		res.append(", ");
		res.append("listTemplate=" + String.valueOf( listTemplate ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this MzAssays with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			MzAssays obj = (MzAssays)inputObject;
			Object inputRData = obj.getRData();
			if((rData==null)||(inputRData==null))
				res = res&&(rData==inputRData);
			else
				res = res&&java.util.Arrays.equals(rData, (Object[])inputRData);
			Object inputListTemplate = obj.getListTemplate();
			if((listTemplate==null)||(inputListTemplate==null))
				res = res&&(listTemplate==inputListTemplate);
			else
				res = res&&listTemplate.equals(inputListTemplate);
		}
		return res;
	}

}