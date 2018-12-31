package com.dpenny.mcda5510;

import java.rmi.RemoteException;

import com.dpenny.mcda5510.entity.Transaction;
import com.dpenny.mcda5510.service.TrxnWebServiceProxy;

public class TestClient {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		TrxnWebServiceProxy proxy = new TrxnWebServiceProxy();
        proxy.setEndpoint("http://localhost:8080/Assignment3/services/TrxnWebService");//defined in wsdl

        try {
			Transaction t = proxy.getTransaction(-1);
			System.out.println(t.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
