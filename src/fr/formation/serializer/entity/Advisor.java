package fr.formation.serializer.entity;

import java.util.ArrayList;
import java.util.List;

public class Advisor {

	private String name;

	private Client principal;

	private List<Client> clients;
	
	public Advisor() {
		this.clients = new ArrayList<>();
	}
	
	public Advisor(String name) {
		this();
		this.name = name;
	}
	
	public Advisor(String name, Client principal) {
		this(name);
		this.principal = principal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client getPrincipal() {
		return principal;
	}

	public void setPrincipal(Client principal) {
		this.principal = principal;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}
