/**
 * Serviceclass.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bshree.mcda5510.service;

public interface Serviceclass extends java.rmi.Remote {
    public java.lang.String getTrxns() throws java.rmi.RemoteException;
    public java.lang.String deleteTrxns(int ID) throws java.rmi.RemoteException;
    public java.lang.String updateTrxns(java.lang.String id, java.lang.String nameOnCard, java.lang.String unitprice, java.lang.String quantity, java.lang.String totalprice, java.lang.String cardNumber, java.lang.String expDate) throws java.rmi.RemoteException;
    public java.lang.String getoneTrxns(int ID) throws java.rmi.RemoteException;
    public java.lang.String insertTrxns(int ID, java.lang.String nameOnCard, double unitprice, int quantity, double totalPrice, java.lang.String cardNumber, java.lang.String expDate) throws java.rmi.RemoteException;
}
