package org.bioconductor.packages.caDNAcopy;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Thu Feb 22 09:34:39 2007. 
	* It represents the S4 Class DNAcopyAssays in R package caDNAcopy. 
	*	Encapsulates DNA copy number data used
	*	for copy number estimation by object caDNAcopy in
	*	R package caDNAcopy
	*/


public class DNAcopyAssays implements java.io.Serializable  {
	private org.bioconductor.packages.rservices.RJNumericMatrix logratioValues;
	private String[] sampleNames;
	private int[] chromosomeId;
	private int[] mapLocation;

	public DNAcopyAssays() {
		this.logratioValues = new org.bioconductor.packages.rservices.RJNumericMatrix();
		this.sampleNames = new String[]{};
		this.chromosomeId = new int[]{};
		this.mapLocation = new int[]{};
	}

	public DNAcopyAssays(
		org.bioconductor.packages.rservices.RJNumericMatrix logratioValues,
		String[] sampleNames,
		int[] chromosomeId,
		int[] mapLocation){

		this.logratioValues = logratioValues;
		this.sampleNames = sampleNames;
		this.chromosomeId = chromosomeId;
		this.mapLocation = mapLocation;
	}

	/**
	* Sets the logratioValues value for this DNAcopyAssays
	*
	* @param	logratioValues	A NumericMatrix of log-ratio expression
	*	values, with rows corresponding to features and
	*	columns to samples
	*/
	public void setLogratioValues(org.bioconductor.packages.rservices.RJNumericMatrix logratioValues) {
		this.logratioValues = logratioValues;
	}

	/**
	* Gets the logratioValues value for this DNAcopyAssays
	*
	* @return	the value of logratioValues
	*	A NumericMatrix of log-ratio expression
	*	values, with rows corresponding to features and
	*	columns to samples
	*/
	public org.bioconductor.packages.rservices.RJNumericMatrix getLogratioValues() {
		return logratioValues;
	}

	/**
	* Sets the sampleNames value for this DNAcopyAssays
	*
	* @param	sampleNames	A NumericMatrix of log-ratio expression
	*	values, with rows corresponding to features and
	*	columns to samples
	*/
	public void setSampleNames(String[] sampleNames) {
		this.sampleNames = sampleNames;
	}

	/**
	* Gets the sampleNames value for this DNAcopyAssays
	*
	* @return	the value of sampleNames
	*	A NumericMatrix of log-ratio expression
	*	values, with rows corresponding to features and
	*	columns to samples
	*/
	public String[] getSampleNames() {
		return sampleNames;
	}

	/**
	* Sets the chromosomeId value for this DNAcopyAssays
	*
	* @param	chromosomeId	A NumericMatrix of log-ratio expression
	*	values, with rows corresponding to features and
	*	columns to samples
	*/
	public void setChromosomeId(int[] chromosomeId) {
		this.chromosomeId = chromosomeId;
	}

	/**
	* Gets the chromosomeId value for this DNAcopyAssays
	*
	* @return	the value of chromosomeId
	*	A NumericMatrix of log-ratio expression
	*	values, with rows corresponding to features and
	*	columns to samples
	*/
	public int[] getChromosomeId() {
		return chromosomeId;
	}

	/**
	* Sets the mapLocation value for this DNAcopyAssays
	*
	* @param	mapLocation	A NumericMatrix of log-ratio expression
	*	values, with rows corresponding to features and
	*	columns to samples
	*/
	public void setMapLocation(int[] mapLocation) {
		this.mapLocation = mapLocation;
	}

	/**
	* Gets the mapLocation value for this DNAcopyAssays
	*
	* @return	the value of mapLocation
	*	A NumericMatrix of log-ratio expression
	*	values, with rows corresponding to features and
	*	columns to samples
	*/
	public int[] getMapLocation() {
		return mapLocation;
	}

	/**
	* Print this DNAcopyAssays to String
	*
	* @return	contents of DNAcopyAssays as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("logratioValues=" + String.valueOf( logratioValues ));
		res.append(", ");
		res.append("sampleNames=" + java.util.Arrays.toString( sampleNames ));
		res.append(", ");
		res.append("chromosomeId=" + java.util.Arrays.toString( chromosomeId ));
		res.append(", ");
		res.append("mapLocation=" + java.util.Arrays.toString( mapLocation ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this DNAcopyAssays with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			DNAcopyAssays obj = (DNAcopyAssays)inputObject;
			Object inputLogratioValues = obj.getLogratioValues();
			if((logratioValues==null)||(inputLogratioValues==null))
				res = res&&(logratioValues==inputLogratioValues);
			else
				res = res&&logratioValues.equals(inputLogratioValues);
			Object inputSampleNames = obj.getSampleNames();
			if((sampleNames==null)||(inputSampleNames==null))
				res = res&&(sampleNames==inputSampleNames);
			else
				res = res&&java.util.Arrays.equals(sampleNames, (String[])inputSampleNames);
			Object inputChromosomeId = obj.getChromosomeId();
			if((chromosomeId==null)||(inputChromosomeId==null))
				res = res&&(chromosomeId==inputChromosomeId);
			else
				res = res&&java.util.Arrays.equals(chromosomeId, (int[])inputChromosomeId);
			Object inputMapLocation = obj.getMapLocation();
			if((mapLocation==null)||(inputMapLocation==null))
				res = res&&(mapLocation==inputMapLocation);
			else
				res = res&&java.util.Arrays.equals(mapLocation, (int[])inputMapLocation);
		}
		return res;
	}

}