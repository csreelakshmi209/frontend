package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DonateToNgo {

	@Id
	@GeneratedValue
	private int ngoId;
	private String bankName;
	private String cardNumber;
	private String amount;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getNgoId() {
		return ngoId;
	}
	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	@Override
	public String toString() {
		return "DonateToNgo [ngoId=" + ngoId + ", bankName=" + bankName + ", cardNumber=" + cardNumber + ", amount="
				+ amount + "]";
	}
	
}
