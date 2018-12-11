package fr.formation.serializer.entity;

public class Client {

	private String firstname;

	private String lastname;

	private String email;

	private Account currentAccount;

	private Account savingsAccount;

	public Client() {
	}

	public Client(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public Client(String firstname, String lastname, String email,
			Account currentAccount, Account savingsAccount) {
		this(firstname, lastname, email);
		this.currentAccount = currentAccount;
		this.savingsAccount = savingsAccount;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}

	public Account getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(Account savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

}
