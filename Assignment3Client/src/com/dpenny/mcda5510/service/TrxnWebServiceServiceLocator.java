/**
 * TrxnWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dpenny.mcda5510.service;

public class TrxnWebServiceServiceLocator extends org.apache.axis.client.Service implements com.dpenny.mcda5510.service.TrxnWebServiceService {

    public TrxnWebServiceServiceLocator() {
    }


    public TrxnWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TrxnWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TrxnWebService
    private java.lang.String TrxnWebService_address = "http://localhost:8080/Assignment3/services/TrxnWebService";

    public java.lang.String getTrxnWebServiceAddress() {
        return TrxnWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TrxnWebServiceWSDDServiceName = "TrxnWebService";

    public java.lang.String getTrxnWebServiceWSDDServiceName() {
        return TrxnWebServiceWSDDServiceName;
    }

    public void setTrxnWebServiceWSDDServiceName(java.lang.String name) {
        TrxnWebServiceWSDDServiceName = name;
    }

    public com.dpenny.mcda5510.service.TrxnWebService getTrxnWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TrxnWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTrxnWebService(endpoint);
    }

    public com.dpenny.mcda5510.service.TrxnWebService getTrxnWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dpenny.mcda5510.service.TrxnWebServiceSoapBindingStub _stub = new com.dpenny.mcda5510.service.TrxnWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTrxnWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTrxnWebServiceEndpointAddress(java.lang.String address) {
        TrxnWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.dpenny.mcda5510.service.TrxnWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dpenny.mcda5510.service.TrxnWebServiceSoapBindingStub _stub = new com.dpenny.mcda5510.service.TrxnWebServiceSoapBindingStub(new java.net.URL(TrxnWebService_address), this);
                _stub.setPortName(getTrxnWebServiceWSDDServiceName());
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
        if ("TrxnWebService".equals(inputPortName)) {
            return getTrxnWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.mcda5510.dpenny.com", "TrxnWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.mcda5510.dpenny.com", "TrxnWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TrxnWebService".equals(portName)) {
            setTrxnWebServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
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
