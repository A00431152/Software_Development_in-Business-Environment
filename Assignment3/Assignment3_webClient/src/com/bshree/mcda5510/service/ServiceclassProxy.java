package com.bshree.mcda5510.service;

public class ServiceclassProxy implements com.bshree.mcda5510.service.Serviceclass {
  private String _endpoint = null;
  private com.bshree.mcda5510.service.Serviceclass serviceclass = null;
  
  public ServiceclassProxy() {
    _initServiceclassProxy();
  }
  
  public ServiceclassProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceclassProxy();
  }
  
  private void _initServiceclassProxy() {
    try {
      serviceclass = (new com.bshree.mcda5510.service.ServiceclassServiceLocator()).getServiceclass();
      if (serviceclass != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceclass)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceclass)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceclass != null)
      ((javax.xml.rpc.Stub)serviceclass)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bshree.mcda5510.service.Serviceclass getServiceclass() {
    if (serviceclass == null)
      _initServiceclassProxy();
    return serviceclass;
  }
  
  public java.lang.String getTrxns() throws java.rmi.RemoteException{
    if (serviceclass == null)
      _initServiceclassProxy();
    return serviceclass.getTrxns();
  }
  
  public java.lang.String deleteTrxns(int ID) throws java.rmi.RemoteException{
    if (serviceclass == null)
      _initServiceclassProxy();
    return serviceclass.deleteTrxns(ID);
  }
  
  public java.lang.String updateTrxns(java.lang.String id, java.lang.String nameOnCard, java.lang.String unitprice, java.lang.String quantity, java.lang.String totalprice, java.lang.String cardNumber, java.lang.String expDate) throws java.rmi.RemoteException{
    if (serviceclass == null)
      _initServiceclassProxy();
    return serviceclass.updateTrxns(id, nameOnCard, unitprice, quantity, totalprice, cardNumber, expDate);
  }
  
  public java.lang.String getoneTrxns(int ID) throws java.rmi.RemoteException{
    if (serviceclass == null)
      _initServiceclassProxy();
    return serviceclass.getoneTrxns(ID);
  }
  
  public java.lang.String insertTrxns(int ID, java.lang.String nameOnCard, double unitprice, int quantity, double totalPrice, java.lang.String cardNumber, java.lang.String expDate) throws java.rmi.RemoteException{
    if (serviceclass == null)
      _initServiceclassProxy();
    return serviceclass.insertTrxns(ID, nameOnCard, unitprice, quantity, totalPrice, cardNumber, expDate);
  }
  
  
}