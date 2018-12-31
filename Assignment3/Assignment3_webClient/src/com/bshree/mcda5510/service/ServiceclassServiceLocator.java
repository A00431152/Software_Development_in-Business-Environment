/**
 * ServiceclassServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bshree.mcda5510.service;

public class ServiceclassServiceLocator extends org.apache.axis.client.Service implements com.bshree.mcda5510.service.ServiceclassService {

    public ServiceclassServiceLocator() {
    }


    public ServiceclassServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceclassServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Serviceclass
    private java.lang.String Serviceclass_address = "http://localhost:8080/Assignment3_web/services/Serviceclass";

    public java.lang.String getServiceclassAddress() {
        return Serviceclass_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiceclassWSDDServiceName = "Serviceclass";

    public java.lang.String getServiceclassWSDDServiceName() {
        return ServiceclassWSDDServiceName;
    }

    public void setServiceclassWSDDServiceName(java.lang.String name) {
        ServiceclassWSDDServiceName = name;
    }

    public com.bshree.mcda5510.service.Serviceclass getServiceclass() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Serviceclass_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiceclass(endpoint);
    }

    public com.bshree.mcda5510.service.Serviceclass getServiceclass(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.bshree.mcda5510.service.ServiceclassSoapBindingStub _stub = new com.bshree.mcda5510.service.ServiceclassSoapBindingStub(portAddress, this);
            _stub.setPortName(getServiceclassWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiceclassEndpointAddress(java.lang.String address) {
        Serviceclass_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.bshree.mcda5510.service.Serviceclass.class.isAssignableFrom(serviceEndpointInterface)) {
                com.bshree.mcda5510.service.ServiceclassSoapBindingStub _stub = new com.bshree.mcda5510.service.ServiceclassSoapBindingStub(new java.net.URL(Serviceclass_address), this);
                _stub.setPortName(getServiceclassWSDDServiceName());
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
        if ("Serviceclass".equals(inputPortName)) {
            return getServiceclass();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.mcda5510.bshree.com", "ServiceclassService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.mcda5510.bshree.com", "Serviceclass"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Serviceclass".equals(portName)) {
            setServiceclassEndpointAddress(address);
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
