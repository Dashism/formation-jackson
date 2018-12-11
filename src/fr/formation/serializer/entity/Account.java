package fr.formation.serializer.entity;

public class Account {

	private String number;

	private Float balance;

	public Account() {
	}

	public Account(String number, Float balance) {
		super();
		this.number = number;
		this.balance = balance;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

}
