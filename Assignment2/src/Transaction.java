
//import java.sql.Date;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Transaction {

	public String nameOnCard;

	public String cardNumber;
	public int ID;
	double Unitprice;
	int Quantity;
	double TotalPrice;

	String CreatedBy;
	String ExpDate;

	String CardType;
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	public String sdate = sdf.format(date);
	
	
	

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public double getUnitprice() {
		return Unitprice;
	}

	public void setUnitprice(double unitprice) {
		Unitprice = unitprice;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getExpDate() {
		return ExpDate;
	}

	public void setExpDate(String expDate) {
		ExpDate = expDate;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

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

	public String toString() {

		String results = new String();

		results = "[ID :" + ID + ", NameOnCard: " + nameOnCard + ",CardNumber: " + cardNumber + ",UnitPrice:"
				+ Unitprice + ", " + "TotalPrice : " + TotalPrice + " ExpDate: " + ExpDate + " CreatedOn :" + sdate+ "CreateBy : " + CreatedBy
				+ ", CardType:" + CardType + "]";
		return results;

	}

}
