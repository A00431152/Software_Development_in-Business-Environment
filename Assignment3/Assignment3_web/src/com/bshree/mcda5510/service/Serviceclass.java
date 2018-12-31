package com.bshree.mcda5510.service;

import com.bshree.mcda5510.entity.Transaction;


import com.bshree.mcda5510.dao.MySQLAccess;

public class Serviceclass {

	

	public static String getTrxns() throws Exception {

		return MySQLAccess.getAllTransactions();
	}

	public static String insertTrxns(int ID, String nameOnCard, double Unitprice, int Quantity, double TotalPrice,
			String cardNumber, String ExpDate) throws Exception {

		Transaction t = new Transaction();

		System.out.println("Enter ID :");
		t.setID(ID);
		System.out.println("Enter Name: ");
		t.setNameOnCard(nameOnCard);
		System.out.println("Enter Unitprice ");
		t.setUnitprice(Unitprice);
		System.out.println("Enter Quantity: ");
		t.setQuantity(Quantity);
		System.out.println("Enter TotalPrice: ");
		t.setTotalPrice(TotalPrice);
		System.out.println("Enter Card Number:");
		t.setCardNumber(cardNumber);
		System.out.println("Enter Exp Date in MM/yyyy format ");
		t.setExpDate(ExpDate);

		String queryres = MySQLAccess.insertTrxns(t);
		return queryres;

	}

	public static String deleteTrxns(int ID) throws Exception {

		Transaction t = new Transaction();

		System.out.println("Enter ID :");
		t.setID(ID);
		return MySQLAccess.deleteTrxns(t);

	}

	public static String updateTrxns(String Id, String NameOnCard, String Unitprice, String Quantity, String Totalprice,
			String cardNumber, String ExpDate) throws Exception {

		Transaction t = new Transaction();

		System.out.println("Enter ID :");
		if (Id != null) {
			int ID = Integer.parseInt(Id);
			t.setID(ID);
		}

		System.out.println("Enter Name: ");
		if (NameOnCard != null) {
			t.setNameOnCard(NameOnCard);
		}
		System.out.println("Enter Unitprice ");
		if (Unitprice != null) {
			double Unit_price = Double.parseDouble(Unitprice);
			t.setUnitprice(Unit_price);
		}
		System.out.println("Enter Quantity: ");
		if (Quantity != null) {
			int quantity = Integer.parseInt(Quantity);
			t.setQuantity(quantity);
		}
		System.out.println("Enter TotalPrice: ");
		if (Totalprice != null) {
			double TotalPrice = Double.parseDouble(Totalprice);
			t.setTotalPrice(TotalPrice);
		}
		System.out.println("Enter Card Number:");
		if (cardNumber != null) {
			t.setCardNumber(cardNumber);
		}
		System.out.println("Enter Exp Date in MM/yyyy format ");
		if (ExpDate != null) {
			t.setExpDate(ExpDate);
		}

		return MySQLAccess.updateTransaction(t);
	}

	public static String getoneTrxns(int ID) throws Exception {

		Transaction t = new Transaction();

		System.out.println("Enter ID :");
		t.setID(ID);
		return MySQLAccess.getTrxns(t);

	}

}
