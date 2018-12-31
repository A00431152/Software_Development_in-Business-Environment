/**
 * TrxnWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dpenny.mcda5510.service;

public interface TrxnWebService extends java.rmi.Remote {
    public com.dpenny.mcda5510.entity.Transaction getTransaction(int trxnID) throws java.rmi.RemoteException;
    public void updateTransaction(int trxnID, java.lang.String name, java.lang.String cardNumber, double unitPrice, int qty, double totalPrice, java.lang.String expDate) throws java.rmi.RemoteException;
}
