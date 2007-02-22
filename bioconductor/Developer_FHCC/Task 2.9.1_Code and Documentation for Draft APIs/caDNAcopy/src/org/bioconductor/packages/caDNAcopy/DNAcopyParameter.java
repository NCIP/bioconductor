package org.bioconductor.packages.caDNAcopy;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Thu Feb 22 09:34:39 2007. 
	* It represents the S4 Class DNAcopyParameter in R package caDNAcopy. 
	*	A class encapsulating parameter values
	*	used by the object caDNAcopy in R package
	*	caDNAcopy algorithm
	*/


public class DNAcopyParameter implements java.io.Serializable  {
	private int[] randomNumberSeed;
	private double[] changePointSignificanceLevel;
	private int[] permutationReplicates;
	private double[] earlyStoppingCriterion;

	public DNAcopyParameter() {
		this.randomNumberSeed = new int[]{};
		this.changePointSignificanceLevel = new double[]{};
		this.permutationReplicates = new int[]{};
		this.earlyStoppingCriterion = new double[]{};
	}

	public DNAcopyParameter(
		int[] randomNumberSeed,
		double[] changePointSignificanceLevel,
		int[] permutationReplicates,
		double[] earlyStoppingCriterion){

		this.randomNumberSeed = randomNumberSeed;
		this.changePointSignificanceLevel = changePointSignificanceLevel;
		this.permutationReplicates = permutationReplicates;
		this.earlyStoppingCriterion = earlyStoppingCriterion;
	}

	/**
	* Sets the randomNumberSeed value for this DNAcopyParameter
	*
	* @param	randomNumberSeed	A single integer value to seed the random
	*	number generator, using R's set.seed.
	*/
	public void setRandomNumberSeed(int[] randomNumberSeed) {
		this.randomNumberSeed = randomNumberSeed;
	}

	/**
	* Gets the randomNumberSeed value for this DNAcopyParameter
	*
	* @return	the value of randomNumberSeed
	*	A single integer value to seed the random
	*	number generator, using R's set.seed.
	*/
	public int[] getRandomNumberSeed() {
		return randomNumberSeed;
	}

	/**
	* Sets the changePointSignificanceLevel value for this DNAcopyParameter
	*
	* @param	changePointSignificanceLevel	A single integer value to seed the random
	*	number generator, using R's set.seed.
	*/
	public void setChangePointSignificanceLevel(double[] changePointSignificanceLevel) {
		this.changePointSignificanceLevel = changePointSignificanceLevel;
	}

	/**
	* Gets the changePointSignificanceLevel value for this DNAcopyParameter
	*
	* @return	the value of changePointSignificanceLevel
	*	A single integer value to seed the random
	*	number generator, using R's set.seed.
	*/
	public double[] getChangePointSignificanceLevel() {
		return changePointSignificanceLevel;
	}

	/**
	* Sets the permutationReplicates value for this DNAcopyParameter
	*
	* @param	permutationReplicates	A single integer value to seed the random
	*	number generator, using R's set.seed.
	*/
	public void setPermutationReplicates(int[] permutationReplicates) {
		this.permutationReplicates = permutationReplicates;
	}

	/**
	* Gets the permutationReplicates value for this DNAcopyParameter
	*
	* @return	the value of permutationReplicates
	*	A single integer value to seed the random
	*	number generator, using R's set.seed.
	*/
	public int[] getPermutationReplicates() {
		return permutationReplicates;
	}

	/**
	* Sets the earlyStoppingCriterion value for this DNAcopyParameter
	*
	* @param	earlyStoppingCriterion	A single integer value to seed the random
	*	number generator, using R's set.seed.
	*/
	public void setEarlyStoppingCriterion(double[] earlyStoppingCriterion) {
		this.earlyStoppingCriterion = earlyStoppingCriterion;
	}

	/**
	* Gets the earlyStoppingCriterion value for this DNAcopyParameter
	*
	* @return	the value of earlyStoppingCriterion
	*	A single integer value to seed the random
	*	number generator, using R's set.seed.
	*/
	public double[] getEarlyStoppingCriterion() {
		return earlyStoppingCriterion;
	}

	/**
	* Print this DNAcopyParameter to String
	*
	* @return	contents of DNAcopyParameter as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("randomNumberSeed=" + java.util.Arrays.toString( randomNumberSeed ));
		res.append(", ");
		res.append("changePointSignificanceLevel=" + java.util.Arrays.toString( changePointSignificanceLevel ));
		res.append(", ");
		res.append("permutationReplicates=" + java.util.Arrays.toString( permutationReplicates ));
		res.append(", ");
		res.append("earlyStoppingCriterion=" + java.util.Arrays.toString( earlyStoppingCriterion ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this DNAcopyParameter with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			DNAcopyParameter obj = (DNAcopyParameter)inputObject;
			Object inputRandomNumberSeed = obj.getRandomNumberSeed();
			if((randomNumberSeed==null)||(inputRandomNumberSeed==null))
				res = res&&(randomNumberSeed==inputRandomNumberSeed);
			else
				res = res&&java.util.Arrays.equals(randomNumberSeed, (int[])inputRandomNumberSeed);
			Object inputChangePointSignificanceLevel = obj.getChangePointSignificanceLevel();
			if((changePointSignificanceLevel==null)||(inputChangePointSignificanceLevel==null))
				res = res&&(changePointSignificanceLevel==inputChangePointSignificanceLevel);
			else
				res = res&&java.util.Arrays.equals(changePointSignificanceLevel, (double[])inputChangePointSignificanceLevel);
			Object inputPermutationReplicates = obj.getPermutationReplicates();
			if((permutationReplicates==null)||(inputPermutationReplicates==null))
				res = res&&(permutationReplicates==inputPermutationReplicates);
			else
				res = res&&java.util.Arrays.equals(permutationReplicates, (int[])inputPermutationReplicates);
			Object inputEarlyStoppingCriterion = obj.getEarlyStoppingCriterion();
			if((earlyStoppingCriterion==null)||(inputEarlyStoppingCriterion==null))
				res = res&&(earlyStoppingCriterion==inputEarlyStoppingCriterion);
			else
				res = res&&java.util.Arrays.equals(earlyStoppingCriterion, (double[])inputEarlyStoppingCriterion);
		}
		return res;
	}

}
