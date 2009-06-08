package org.bioconductor.packages.caLinearModel.service;

import java.rmi.RemoteException;

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaLinearModelImpl extends CaLinearModelImplBase {

	org.bioconductor.rserviceJms.services.caLinearModel.caLinearModel m_caLinearModel = null;
	
	public CaLinearModelImpl() throws RemoteException {
		super();
		
		try {
			m_caLinearModel = new org.bioconductor.rserviceJms.services.caLinearModel.caLinearModel();
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}
		
	}
	
  public org.bioconductor.cagrid.data.TopTableCollection fit(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChannelExpressionDataCollection,org.bioconductor.cagrid.calinearmodel.OneChannelModel oneChannelModel) throws RemoteException {
	  
	  try {
		  //type mapping: cagrid oneChannelModel will be splitted into two parts in R:
		  // one is R OneChannelModel, the other is R OneChannelSampleAnnotion:
		  
		  // define R types:
		  org.bioconductor.packages.caLinearModel.OneChannelModel rOneChannelModel = null;
		  org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoCollection = null;
		  
		  
		  // cagrid OneChannelModel to R OneChannelModel:
		   
		  if (oneChannelModel instanceof org.bioconductor.cagrid.calinearmodel.TTest) {
			  // R OneChannelModel mapping:
			  String[] strSampleAnnotationCollectionTestColumnName = new String[] {"TTestFactor"};
			  
			  org.bioconductor.cagrid.calinearmodel.TTest cagridTTest = (org.bioconductor.cagrid.calinearmodel.TTest)oneChannelModel;
			  rOneChannelModel = new org.bioconductor.packages.caLinearModel.TTest();
			  ((org.bioconductor.packages.caLinearModel.TTest)rOneChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnotationCollectionTestColumnName);
			  rOneChannelModel.setNumberOfTopReporters(new int[]{cagridTTest.getNumberOfTopReporters()});

			  // R OneChannelSampleAnnotation mapping:
			  org.bioconductor.cagrid.calinearmodel.TTestAnnotation[] cagridTTestAnnoArr = cagridTTest.getTTestAnnotation();
			  String[] strSampleAnnoCollection = new String[cagridTTestAnnoArr.length];
			  String[] strSampleIdens = new String[cagridTTestAnnoArr.length];
			  String[] strSampleChannels = new String[cagridTTestAnnoArr.length];
			  for(int i = 0; i < cagridTTestAnnoArr.length; i++) {
				  strSampleIdens[i] = cagridTTestAnnoArr[i].getSampleIdentifier();
				  strSampleChannels[i] = "ChannelOne";
				  strSampleAnnoCollection[i] = cagridTTestAnnoArr[i].getFactorLevel().getValue();
			  }
			  
			  // Construct RJDataFrame:
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnotationCollectionTestColumnName[0] });
			  rjDataFrame.setRowNames(strSampleIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strSampleChannels, strSampleAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
			
		  }
		  else if(oneChannelModel instanceof org.bioconductor.cagrid.calinearmodel.PairedTTest) {
			  String[] strSampleAnnotationCollectionTestColumnName = new String[] {"TTestFactor"};
			  String[] strSampleAnnotationCollectionPairingColumnName = new String[] {"PairIdentifier"};
			  
			  org.bioconductor.cagrid.calinearmodel.PairedTTest cagridPairTTest = (org.bioconductor.cagrid.calinearmodel.PairedTTest)oneChannelModel;
			  rOneChannelModel = new org.bioconductor.packages.caLinearModel.PairedTTest();
			  ((org.bioconductor.packages.caLinearModel.PairedTTest)rOneChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnotationCollectionTestColumnName);
			  ((org.bioconductor.packages.caLinearModel.PairedTTest)rOneChannelModel).setSampleAnnotationCollectionPairingColumnName(strSampleAnnotationCollectionPairingColumnName);
			  rOneChannelModel.setNumberOfTopReporters(new int[]{cagridPairTTest.getNumberOfTopReporters()});
			  
			  org.bioconductor.cagrid.calinearmodel.PairedTTestAnnotation[] cagridPairedTTestAnnoArr = cagridPairTTest.getPairedTTestAnnotation();
			  String[] strSampleAnnoCollection = new String[cagridPairedTTestAnnoArr.length];
			  String[] strSampleIdens = new String[cagridPairedTTestAnnoArr.length];
			  String[] strSampleChannels = new String[cagridPairedTTestAnnoArr.length];
			  String[] strSamplePairIdensCollection = new String[cagridPairedTTestAnnoArr.length];
			  for(int i = 0; i < cagridPairedTTestAnnoArr.length; i++) {
				  strSampleIdens[i] = cagridPairedTTestAnnoArr[i].getSampleIdentifier();
				  strSampleChannels[i] = "ChannelOne";
				  strSampleAnnoCollection[i] = cagridPairedTTestAnnoArr[i].getFactorLevel().getValue();
				  strSamplePairIdensCollection[i] = cagridPairedTTestAnnoArr[i].getPairIdentifier();
			  }
			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnotationCollectionTestColumnName[0], strSampleAnnotationCollectionPairingColumnName[0] });
			  rjDataFrame.setRowNames(strSampleIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strSampleChannels, strSampleAnnoCollection, strSamplePairIdensCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
			  
		  }
		  else if(oneChannelModel instanceof org.bioconductor.cagrid.calinearmodel.OneFactorANOVA) {
			  String[] strSampleAnnotationCollectionFactorColumnName = new String[] {"ANOVAFactor"};
			  
			  org.bioconductor.cagrid.calinearmodel.OneFactorANOVA cagridOneFactorANOVA = (org.bioconductor.cagrid.calinearmodel.OneFactorANOVA)oneChannelModel;
			  rOneChannelModel = new org.bioconductor.packages.caLinearModel.OneFactorANOVA();
			  ((org.bioconductor.packages.caLinearModel.OneFactorANOVA)rOneChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnotationCollectionFactorColumnName);
			  rOneChannelModel.setNumberOfTopReporters(new int[]{cagridOneFactorANOVA.getNumberOfTopReporters()});

			  org.bioconductor.cagrid.calinearmodel.OneFactorANOVAAnnotation[] cagridOneFactorANOVAAnnoArr = cagridOneFactorANOVA.getOneFactorANOVAAnnotation();
			  String[] strSampleAnnoCollection = new String[cagridOneFactorANOVAAnnoArr.length];
			  String[] strSampleIdens = new String[cagridOneFactorANOVAAnnoArr.length];
			  String[] strSampleChannels = new String[cagridOneFactorANOVAAnnoArr.length];
			  for(int i = 0; i < cagridOneFactorANOVAAnnoArr.length; i++) {
				  strSampleIdens[i] = cagridOneFactorANOVAAnnoArr[i].getSampleIdentifier();
				  strSampleChannels[i] = "ChannelOne";
				  strSampleAnnoCollection[i] = cagridOneFactorANOVAAnnoArr[i].getFactorLevel().getValue();
			  }
			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnotationCollectionFactorColumnName[0] });
			  rjDataFrame.setRowNames(strSampleIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strSampleChannels, strSampleAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
		  }
		  else if(oneChannelModel instanceof org.bioconductor.cagrid.calinearmodel.TwoFactorANOVA) {
			  // OneChannelModel mapping:
			  String[] strSampleAnnotationCollectionFactorOneColumnName = new String[] {"ANOVAFactorOne"};
			  String[] strSampleAnnotationCollectionFactorTwoColumnName = new String[] {"ANOVAFactorTwo"};
			  
			  org.bioconductor.cagrid.calinearmodel.TwoFactorANOVA cagridTwoFactorANOVA = (org.bioconductor.cagrid.calinearmodel.TwoFactorANOVA)oneChannelModel;
			  rOneChannelModel = new org.bioconductor.packages.caLinearModel.TwoFactorANOVA();
			  ((org.bioconductor.packages.caLinearModel.TwoFactorANOVA)rOneChannelModel).setSampleAnnotationCollectionFactorOneColumnName(strSampleAnnotationCollectionFactorOneColumnName);
			  ((org.bioconductor.packages.caLinearModel.TwoFactorANOVA)rOneChannelModel).setSampleAnnotationCollectionFactorTwoColumnName(strSampleAnnotationCollectionFactorTwoColumnName);
			  rOneChannelModel.setNumberOfTopReporters(new int[]{cagridTwoFactorANOVA.getNumberOfTopReporters()});
			  
			  // OneChannelSampleAnnotation mapping:
			  org.bioconductor.cagrid.calinearmodel.TwoFactorANOVAAnnotation[] cagridTwoFactorANOVAAnnoArr = cagridTwoFactorANOVA.getTwoFactorANOVAAnnotation();
			  String[] strSampleFactorOneAnnoCollection = new String[cagridTwoFactorANOVAAnnoArr.length];
			  String[] strSampleFactorTwoAnnoCollection = new String[cagridTwoFactorANOVAAnnoArr.length];
			  String[] strSampleIdens = new String[cagridTwoFactorANOVAAnnoArr.length];
			  String[] strSampleChannels = new String[cagridTwoFactorANOVAAnnoArr.length];			  
			  for(int i = 0; i < cagridTwoFactorANOVAAnnoArr.length; i++) {
				  strSampleIdens[i] = cagridTwoFactorANOVAAnnoArr[i].getSampleIdentifier();
				  strSampleChannels[i] = "ChannelOne";
				  strSampleFactorOneAnnoCollection[i] = cagridTwoFactorANOVAAnnoArr[i].getFactorOneLevel().getValue();
				  strSampleFactorTwoAnnoCollection[i] = cagridTwoFactorANOVAAnnoArr[i].getFactorTwoLevel().getValue();
			  }
			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnotationCollectionFactorOneColumnName[0], strSampleAnnotationCollectionFactorTwoColumnName[0] });
			  rjDataFrame.setRowNames(strSampleIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strSampleChannels, strSampleFactorOneAnnoCollection, strSampleFactorTwoAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
		  }
		  else {
			  throw new RemoteException("CaLinearModelImpl::fit - Undefined OneChannelModel " + oneChannelModel.getClass().getName());
		  }
		  
		  // cagrid SingleChannelExpressionDataCollection to R OneChannelExpressionData:
		  org.bioconductor.packages.caCommonClasses.OneChannelExpressionData oneChanExpData = this.cagridSingleChanExpDataToROneChanExpData(singleChannelExpressionDataCollection);
		  
		  org.bioconductor.packages.caCommonClasses.TopTableCollection rTopTableCollection = m_caLinearModel.fit(rOneChannelModel, oneChanExpData, rSampleAnnoCollection);
		  
		  return this.rTopTableCollectionToCagridTopTableCollection(rTopTableCollection);
		  
		  
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }
  
  public org.bioconductor.cagrid.data.TopTableCollection twoChannelFit(org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection twoChannelExpressionDataCollection,org.bioconductor.cagrid.calinearmodel.TwoChannelModel twoChannelModel) throws RemoteException {
	  // type mapping: cagrid ToChannelModel will be splitted into 2 parts:
	  // one is R TwoChannelModel, the other is TwoChannelSampleAnnotation:
	  org.bioconductor.packages.caLinearModel.TwoChannelModel rTwoChannelModel = null;
	  org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoCollection = null;
	  String[] strChannelIdensNoDup = null;
	  
	  try {
		  if(twoChannelModel instanceof org.bioconductor.cagrid.calinearmodel.DyeSwapTTest) {
			  
			  // R TwoChannelModel mapping:
			  rTwoChannelModel = new org.bioconductor.packages.caLinearModel.DyeSwapTTest();
			  rTwoChannelModel.setNumberOfTopReporters(new int[]{twoChannelModel.getNumberOfTopReporters()});
			  rTwoChannelModel.setChannelReferenceLevel(new String[]{twoChannelModel.getReferenceChannelIdentifier()});
			  
			  // downcast cagrid TwoChannelModel to a specific type of cagrid DyeSwapTTest 
			  org.bioconductor.cagrid.calinearmodel.DyeSwapTTest cagridDyeSwapTTest = (org.bioconductor.cagrid.calinearmodel.DyeSwapTTest)twoChannelModel;
			  
			  // R TwoChannelModel:
			  String[] strSampleAnnoCollTestColName = new String[]{"DyeSwapTTestFactor"};
			  String[] strTestRefLevel = new String[]{cagridDyeSwapTTest.getReferenceLevel().getValue()};
			  
			  ((org.bioconductor.packages.caLinearModel.DyeSwapTTest)rTwoChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnoCollTestColName);
			  ((org.bioconductor.packages.caLinearModel.DyeSwapTTest)rTwoChannelModel).setTestReferenceLevel(strTestRefLevel);
			  
			  
			  // R TwoChannelSampleAnnotation:			 
			  org.bioconductor.cagrid.calinearmodel.DyeSwapTTestAnnotation[] cagridDyeSwapTTestAnnoArr = cagridDyeSwapTTest.getDyeSwapTTestAnnotation();
			  
			  String[] strChannelRefLevel = new String[]{cagridDyeSwapTTestAnnoArr[0].getChannelIdentifier()};
			  rTwoChannelModel.setChannelReferenceLevel(strChannelRefLevel);
			  
			  String[] strSampleFactorLevelAnnoCollection = new String[cagridDyeSwapTTestAnnoArr.length];
			  String[] strChannelIdens = new String[cagridDyeSwapTTestAnnoArr.length];
			  String[] strSampleIdens = new String[cagridDyeSwapTTestAnnoArr.length];
			  String[] strRownameIdens = new String[cagridDyeSwapTTestAnnoArr.length];
			  
			  for(int i = 0; i < cagridDyeSwapTTestAnnoArr.length; i++) {
				  strChannelIdens[i] = cagridDyeSwapTTestAnnoArr[i].getChannelIdentifier();
				  strSampleIdens[i] = cagridDyeSwapTTestAnnoArr[i].getSampleIdentifier();				  
				  strSampleFactorLevelAnnoCollection[i] = cagridDyeSwapTTestAnnoArr[i].getFactorLevel().getValue();	
				  strRownameIdens[i] = strSampleIdens[i] + "." + strChannelIdens[i];
			  }
			  
			  java.util.HashSet<String> channelIdensSet = new java.util.HashSet<String>();
			  for(String channelIden : strChannelIdens) {
				  channelIdensSet.add(channelIden);
			  }			  	  
			  strChannelIdensNoDup = new String[channelIdensSet.size()];
			  Object[] objChannelIdens = channelIdensSet.toArray();
			  for(int i = 0; i < objChannelIdens.length; i++) {
				  strChannelIdensNoDup[i] = (String)(objChannelIdens[i]);
			  }
			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnoCollTestColName[0]});
			  rjDataFrame.setRowNames(strRownameIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strChannelIdens, strSampleFactorLevelAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
			  
		  }
		  else if(twoChannelModel instanceof org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA) {
			// R TwoChannelModel mapping:
			  rTwoChannelModel = new org.bioconductor.packages.caLinearModel.CommonReferenceANOVA();
			  rTwoChannelModel.setNumberOfTopReporters(new int[]{twoChannelModel.getNumberOfTopReporters()});
			  rTwoChannelModel.setChannelReferenceLevel(new String[]{twoChannelModel.getReferenceChannelIdentifier()});
			  
			  org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA commonRefANOVA = (org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA)twoChannelModel;
			  
			  
			  String[] strSampleAnnoCollTestColName = new String[]{"CommonReferenceANOVAFactor"};
			  String[] strTestRefLevel = new String[]{commonRefANOVA.getReferenceLevel().getValue()};
			  
			  ((org.bioconductor.packages.caLinearModel.CommonReferenceANOVA)rTwoChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnoCollTestColName);
			  ((org.bioconductor.packages.caLinearModel.CommonReferenceANOVA)rTwoChannelModel).setTestReferenceLevel(strTestRefLevel);
			  
			  // R TwoChannelSampleAnnotation:
			  // downcast cagrid TwoChannelModel to a specific type of cagrid CommonReferenceANOVA
			  org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA cagridCommonRefANOVA = (org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA)twoChannelModel;
			  org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVAAnnotation[] cagridCommonRefANOVAAnnoArr = cagridCommonRefANOVA.getCommonReferenceANOVAAnnotation();
			  
			  String[] strChannelRefLevel = new String[]{cagridCommonRefANOVAAnnoArr[0].getChannelIdentifier()};
			  ((org.bioconductor.packages.caLinearModel.CommonReferenceANOVA)rTwoChannelModel).setChannelReferenceLevel(strChannelRefLevel);
			  
			  String[] strSampleFactorLevelAnnoCollection = new String[cagridCommonRefANOVAAnnoArr.length];
			  String[] strChannelIdens = new String[cagridCommonRefANOVAAnnoArr.length];
			  String[] strSampleIdens = new String[cagridCommonRefANOVAAnnoArr.length];
			  String[] strRownameIdens = new String[cagridCommonRefANOVAAnnoArr.length];
			  for(int i = 0; i < cagridCommonRefANOVAAnnoArr.length; i++) {
				  strChannelIdens[i] = cagridCommonRefANOVAAnnoArr[i].getChannelIdentifier();
				  strSampleIdens[i] = cagridCommonRefANOVAAnnoArr[i].getSampleIdentifier();				  
				  strSampleFactorLevelAnnoCollection[i] = cagridCommonRefANOVAAnnoArr[i].getFactorLevel().getValue();			
				  strRownameIdens[i] = strSampleIdens[i] + "." + strChannelIdens[i];
			  }
			  
			  java.util.HashSet<String> channelIdensSet = new java.util.HashSet<String>();
			  for(String channelIden : strChannelIdens) {
				  channelIdensSet.add(channelIden);
			  }			  	  
			  strChannelIdensNoDup = new String[channelIdensSet.size()];
			  Object[] objChannelIdens = channelIdensSet.toArray();
			  for(int i = 0; i < objChannelIdens.length; i++) {
				  strChannelIdensNoDup[i] = (String)(objChannelIdens[i]);
			  }
			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnoCollTestColName[0]});
			  rjDataFrame.setRowNames(strRownameIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strChannelIdens, strSampleFactorLevelAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
		  }
		  else {
			  throw new RemoteException("CaLinearModelImpl::twoChannelFit - Undefined TwoChannelModel " + twoChannelModel.getClass().getName());
		  }
		  
		  // TwoChannelExpressionData mappping:
		  org.bioconductor.packages.caCommonClasses.TwoChannelExpressionData twoChanExpData = this.cagridTwoChanExpDataToRTwoChanExpData(twoChannelExpressionDataCollection, strChannelIdensNoDup);
		  
		  org.bioconductor.packages.caCommonClasses.TopTableCollection rTopTableCollection = m_caLinearModel.twoChannelFit(rTwoChannelModel, twoChanExpData, rSampleAnnoCollection);
		  
		  return this.rTopTableCollectionToCagridTopTableCollection(rTopTableCollection);
		  
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }
  
  private org.bioconductor.packages.caCommonClasses.OneChannelExpressionData cagridSingleChanExpDataToROneChanExpData(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChanExpData) throws Exception  
  {
	  try { 
	  	org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix = this.convertCaGridExpDataToRJNumericMatrix(singleChanExpData.getExpressionDataCollection(), singleChanExpData.getReporterNames());
	  	org.bioconductor.packages.caCommonClasses.ExpressionMatrix expMatrix = new org.bioconductor.packages.caCommonClasses.ExpressionMatrix(rjNumericMatrix, new String[]{"ChannelOne"});
	  	return new org.bioconductor.packages.caCommonClasses.OneChannelExpressionData(expMatrix); 
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  
  }
  
  private org.bioconductor.packages.caCommonClasses.TwoChannelExpressionData cagridTwoChanExpDataToRTwoChanExpData(org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection twoChanExpData, String[] channelIdens) throws Exception 
  {
	  try {
		  org.bioconductor.cagrid.data.ExpressionData[] channelOneExpData = twoChanExpData.getRedExpressionDataCollection();
		  org.bioconductor.packages.rservices.RJNumericMatrix chanOneRJNumericMatrix = this.convertCaGridExpDataToRJNumericMatrix(channelOneExpData, twoChanExpData.getReporterNames());
		  org.bioconductor.packages.caCommonClasses.ExpressionMatrix channelOneExpMatrix = new org.bioconductor.packages.caCommonClasses.ExpressionMatrix(chanOneRJNumericMatrix, new String[]{channelIdens[0]});
		  
		  org.bioconductor.cagrid.data.ExpressionData[] channelTwoExpData = twoChanExpData.getGreenExpressionDataCollection();
		  org.bioconductor.packages.rservices.RJNumericMatrix channelTwoRJNumericMatrix = this.convertCaGridExpDataToRJNumericMatrix(channelTwoExpData, twoChanExpData.getReporterNames());
		  org.bioconductor.packages.caCommonClasses.ExpressionMatrix channelTwoExpMatrix = new org.bioconductor.packages.caCommonClasses.ExpressionMatrix(channelTwoRJNumericMatrix, new String[]{channelIdens[1]});
		  
		  return new org.bioconductor.packages.caCommonClasses.TwoChannelExpressionData(channelOneExpMatrix, channelTwoExpMatrix);
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  }
  
  private org.bioconductor.packages.rservices.RJNumericMatrix convertCaGridExpDataToRJNumericMatrix(
                                                                 final org.bioconductor.cagrid.data.ExpressionData[] expressDataArr, final String[] reporterNamesArr) throws Exception
  {
	  try {
		  int numOfSampleCols  = expressDataArr.length;
		  if(numOfSampleCols == 0) {  // nothing to do
			  return null;
		  }

		  int sampleColSize = expressDataArr[0].getReporterValues().getValues().length;
		  // columns length should be equal, data maybe missing, so:
		  if(sampleColSize == 0) {  // nothing to do
			  return null;
		  }

		  org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix = new org.bioconductor.packages.rservices.RJNumericMatrix();
		  rjNumericMatrix.setDim(new int[]{sampleColSize, numOfSampleCols});
		  // data represented in a flatten-array way:
		  double[] values = new double[sampleColSize  * numOfSampleCols];
		  String[] colSampleNames = new String[numOfSampleCols];
		  for(int col = 0; col < numOfSampleCols; col++) {
			  double[] dataArr = expressDataArr[col].getReporterValues().getValues();
			  System.arraycopy(dataArr, 0, values, col * sampleColSize, sampleColSize);
			  colSampleNames[col] = expressDataArr[col].getSampleName();
		  }
		  rjNumericMatrix.setValue(values);

		  Object[] dimNames = new Object[]{reporterNamesArr, colSampleNames};
		  rjNumericMatrix.setDimnames(dimNames);

		  return rjNumericMatrix;
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  }
  
  
  private org.bioconductor.cagrid.data.TopTableCollection rTopTableCollectionToCagridTopTableCollection(org.bioconductor.packages.caCommonClasses.TopTableCollection rTopTableCollection) 
  {
	  Object[] rTopTableObjArr = rTopTableCollection.getTopTableCollection();
	  
	  org.bioconductor.cagrid.data.TopTable[] cagridTopTable = new org.bioconductor.cagrid.data.TopTable[rTopTableObjArr.length];
	  for(int i = 0; i < rTopTableObjArr.length; i++) {
		  cagridTopTable[i] = new org.bioconductor.cagrid.data.TopTable();
		  
		  org.bioconductor.packages.caCommonClasses.TopTable rTopTable = (org.bioconductor.packages.caCommonClasses.TopTable)rTopTableObjArr[i];
		  cagridTopTable[i].setContrastSpecification(rTopTable.getContrastSpecification()[0]);
		  
		  // other array fields of R TopTable will have the same length:
		  int topTableEntryNum = rTopTable.getLogFoldChange().length;
		  org.bioconductor.cagrid.data.TopTableEntry[] cagridTopTableEntry = new org.bioconductor.cagrid.data.TopTableEntry[topTableEntryNum];
		  for(int tt = 0; tt < topTableEntryNum; tt++) {
			  cagridTopTableEntry[tt] = new org.bioconductor.cagrid.data.TopTableEntry();
			  cagridTopTableEntry[tt].setAdjustedPValue(rTopTable.getAdjustedPValue()[tt]);
			  cagridTopTableEntry[tt].setLogFoldChange(rTopTable.getLogFoldChange()[tt]);
			  cagridTopTableEntry[tt].setLogOddsScore(rTopTable.getLogOddsScore()[tt]);
			  cagridTopTableEntry[tt].setPValue(rTopTable.getPValue()[tt]);
			  cagridTopTableEntry[tt].setReporterName(rTopTable.getReporterName()[tt]);
			  cagridTopTableEntry[tt].setTCoefficient(rTopTable.getTCoefficient()[tt]);
		  }
		  
		  cagridTopTable[i].setTopTableEntry(cagridTopTableEntry);
	  }
	  
	  return new org.bioconductor.cagrid.data.TopTableCollection(rTopTableCollection.getModelSpecification()[0], cagridTopTable);
	  
  }

 

}
