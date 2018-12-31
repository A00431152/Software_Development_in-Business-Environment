package com.dpenny.mcda5510.entity;

public class Transaction{

	private String nameOnCard;
	
	private String cardNumber;
	
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}	
	
	public String toString(){
		
		String results = new String();
		
		results = "[NameOnCard: " + nameOnCard +",CardNumber: " + cardNumber+"]";
		return results;

	}

	
	
}
