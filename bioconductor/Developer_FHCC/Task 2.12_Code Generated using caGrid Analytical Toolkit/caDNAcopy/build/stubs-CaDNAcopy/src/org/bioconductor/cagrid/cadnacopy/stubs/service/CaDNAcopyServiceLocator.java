/**
 * CaDNAcopyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.cadnacopy.stubs.service;

public class CaDNAcopyServiceLocator extends org.apache.axis.client.Service implements org.bioconductor.cagrid.cadnacopy.stubs.service.CaDNAcopyService {

    public CaDNAcopyServiceLocator() {
    }


    public CaDNAcopyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CaDNAcopyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CaDNAcopyPortTypePort
    private java.lang.String CaDNAcopyPortTypePort_address = "http://localhost:8080/wsrf/services/";

    public java.lang.String getCaDNAcopyPortTypePortAddress() {
        return CaDNAcopyPortTypePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CaDNAcopyPortTypePortWSDDServiceName = "CaDNAcopyPortTypePort";

    public java.lang.String getCaDNAcopyPortTypePortWSDDServiceName() {
        return CaDNAcopyPortTypePortWSDDServiceName;
    }

    public void setCaDNAcopyPortTypePortWSDDServiceName(java.lang.String name) {
        CaDNAcopyPortTypePortWSDDServiceName = name;
    }

    public org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyPortType getCaDNAcopyPortTypePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CaDNAcopyPortTypePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCaDNAcopyPortTypePort(endpoint);
    }

    public org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyPortType getCaDNAcopyPortTypePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bioconductor.cagrid.cadnacopy.stubs.bindings.CaDNAcopyPortTypeSOAPBindingStub _stub = new org.bioconductor.cagrid.cadnacopy.stubs.bindings.CaDNAcopyPortTypeSOAPBindingStub(portAddress, this);
            _stub.setPortName(getCaDNAcopyPortTypePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCaDNAcopyPortTypePortEndpointAddress(java.lang.String address) {
        CaDNAcopyPortTypePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bioconductor.cagrid.cadnacopy.stubs.bindings.CaDNAcopyPortTypeSOAPBindingStub _stub = new org.bioconductor.cagrid.cadnacopy.stubs.bindings.CaDNAcopyPortTypeSOAPBindingStub(new java.net.URL(CaDNAcopyPortTypePort_address), this);
                _stub.setPortName(getCaDNAcopyPortTypePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CaDNAcopyPortTypePort".equals(inputPortName)) {
            return getCaDNAcopyPortTypePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy/service", "CaDNAcopyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy/service", "CaDNAcopyPortTypePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("CaDNAcopyPortTypePort".equals(portName)) {
            setCaDNAcopyPortTypePortEndpointAddress(address);
        }
        else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
