package org.bioconductor.packages.caPROcess.common;

import javax.xml.namespace.QName;


public interface CaPROcessConstants {
	public static final String SERVICE_NS = "http://caPROcess.packages.bioconductor.org/CaPROcess";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "CaPROcessKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "CaPROcessResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	
}
