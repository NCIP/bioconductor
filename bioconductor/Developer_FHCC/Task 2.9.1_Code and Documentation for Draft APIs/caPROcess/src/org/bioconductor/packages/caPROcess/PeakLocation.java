package org.bioconductor.packages.caPROcess;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Mon Jan 22 14:12:15 2007. 
	* It represents the S4 Class PeakLocation in R package caPROcess. 
	*/


public class PeakLocation implements java.io.Serializable  {
	private String[] spectrumName;
	private int[] spectrumId;
	private int[] peakNumberInSpectrum;
	private double[] relativeIntensity;
	private double[] substanceMassAtIntensity;

	public PeakLocation() {
		this.spectrumName = new String[]{};
		this.spectrumId = new int[]{};
		this.peakNumberInSpectrum = new int[]{};
		this.relativeIntensity = new double[]{};
		this.substanceMassAtIntensity = new double[]{};
	}

	public PeakLocation(
		String[] spectrumName,
		int[] spectrumId,
		int[] peakNumberInSpectrum,
		double[] relativeIntensity,
		double[] substanceMassAtIntensity){

		this.spectrumName = spectrumName;
		this.spectrumId = spectrumId;
		this.peakNumberInSpectrum = peakNumberInSpectrum;
		this.relativeIntensity = relativeIntensity;
		this.substanceMassAtIntensity = substanceMassAtIntensity;
	}

	/**
	* Sets the spectrumName value for this PeakLocation
	*
	* @param	spectrumName	
	*/
	public void setSpectrumName(String[] spectrumName) {
		this.spectrumName = spectrumName;
	}

	/**
	* Gets the spectrumName value for this PeakLocation
	*
	* @return	the value of spectrumName
	*	
	*/
	public String[] getSpectrumName() {
		return spectrumName;
	}

	/**
	* Sets the spectrumId value for this PeakLocation
	*
	* @param	spectrumId	
	*/
	public void setSpectrumId(int[] spectrumId) {
		this.spectrumId = spectrumId;
	}

	/**
	* Gets the spectrumId value for this PeakLocation
	*
	* @return	the value of spectrumId
	*	
	*/
	public int[] getSpectrumId() {
		return spectrumId;
	}

	/**
	* Sets the peakNumberInSpectrum value for this PeakLocation
	*
	* @param	peakNumberInSpectrum	
	*/
	public void setPeakNumberInSpectrum(int[] peakNumberInSpectrum) {
		this.peakNumberInSpectrum = peakNumberInSpectrum;
	}

	/**
	* Gets the peakNumberInSpectrum value for this PeakLocation
	*
	* @return	the value of peakNumberInSpectrum
	*	
	*/
	public int[] getPeakNumberInSpectrum() {
		return peakNumberInSpectrum;
	}

	/**
	* Sets the relativeIntensity value for this PeakLocation
	*
	* @param	relativeIntensity	
	*/
	public void setRelativeIntensity(double[] relativeIntensity) {
		this.relativeIntensity = relativeIntensity;
	}

	/**
	* Gets the relativeIntensity value for this PeakLocation
	*
	* @return	the value of relativeIntensity
	*	
	*/
	public double[] getRelativeIntensity() {
		return relativeIntensity;
	}

	/**
	* Sets the substanceMassAtIntensity value for this PeakLocation
	*
	* @param	substanceMassAtIntensity	
	*/
	public void setSubstanceMassAtIntensity(double[] substanceMassAtIntensity) {
		this.substanceMassAtIntensity = substanceMassAtIntensity;
	}

	/**
	* Gets the substanceMassAtIntensity value for this PeakLocation
	*
	* @return	the value of substanceMassAtIntensity
	*	
	*/
	public double[] getSubstanceMassAtIntensity() {
		return substanceMassAtIntensity;
	}

	/**
	* Print this PeakLocation to String
	*
	* @return	contents of PeakLocation as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("spectrumName=" + java.util.Arrays.toString( spectrumName ));
		res.append(", ");
		res.append("spectrumId=" + java.util.Arrays.toString( spectrumId ));
		res.append(", ");
		res.append("peakNumberInSpectrum=" + java.util.Arrays.toString( peakNumberInSpectrum ));
		res.append(", ");
		res.append("relativeIntensity=" + java.util.Arrays.toString( relativeIntensity ));
		res.append(", ");
		res.append("substanceMassAtIntensity=" + java.util.Arrays.toString( substanceMassAtIntensity ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this PeakLocation with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			PeakLocation obj = (PeakLocation)inputObject;
			Object inputSpectrumName = obj.getSpectrumName();
			if((spectrumName==null)||(inputSpectrumName==null))
				res = res&&(spectrumName==inputSpectrumName);
			else
				res = res&&java.util.Arrays.equals(spectrumName, (String[])inputSpectrumName);
			Object inputSpectrumId = obj.getSpectrumId();
			if((spectrumId==null)||(inputSpectrumId==null))
				res = res&&(spectrumId==inputSpectrumId);
			else
				res = res&&java.util.Arrays.equals(spectrumId, (int[])inputSpectrumId);
			Object inputPeakNumberInSpectrum = obj.getPeakNumberInSpectrum();
			if((peakNumberInSpectrum==null)||(inputPeakNumberInSpectrum==null))
				res = res&&(peakNumberInSpectrum==inputPeakNumberInSpectrum);
			else
				res = res&&java.util.Arrays.equals(peakNumberInSpectrum, (int[])inputPeakNumberInSpectrum);
			Object inputRelativeIntensity = obj.getRelativeIntensity();
			if((relativeIntensity==null)||(inputRelativeIntensity==null))
				res = res&&(relativeIntensity==inputRelativeIntensity);
			else
				res = res&&java.util.Arrays.equals(relativeIntensity, (double[])inputRelativeIntensity);
			Object inputSubstanceMassAtIntensity = obj.getSubstanceMassAtIntensity();
			if((substanceMassAtIntensity==null)||(inputSubstanceMassAtIntensity==null))
				res = res&&(substanceMassAtIntensity==inputSubstanceMassAtIntensity);
			else
				res = res&&java.util.Arrays.equals(substanceMassAtIntensity, (double[])inputSubstanceMassAtIntensity);
		}
		return res;
	}

}
