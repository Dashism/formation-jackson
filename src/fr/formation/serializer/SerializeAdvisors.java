package fr.formation.serializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fr.formation.serializer.entity.Account;
import fr.formation.serializer.entity.Advisor;
import fr.formation.serializer.entity.Client;

public class SerializeAdvisors implements Runnable {
	
	public static void main(String[] args) {
		new SerializeAdvisors().run();
	}

	List<Advisor> advisors;

	public SerializeAdvisors() {
		this.advisors = new ArrayList<>();
	}

	@Override
	public void run() {
		// Construction des données à écrire dans le fichier.
		this.buildAdvisor1();

		// Transformation en flux qui écriture dans le fichier JSON.
		ObjectWriter writer = new ObjectMapper()
				.writerWithDefaultPrettyPrinter();
		File jsonFile = new File("S:\\workbench\\advisors.json");
		try {
			writer.writeValue(jsonFile, advisors);
		} catch (JsonGenerationException e) {
			System.out.println(
					"JSON OK mais erreur pendant l'écriture dans le fichier.");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println(
					"Erreur pendant la conversion de List<Track> en flux JSON.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(
					"Jackson est OK, mais Java ne peux pas terminer le traitement.");
			e.printStackTrace();
		}
	}

	private void buildAdvisor1() {
		Advisor adv1 = new Advisor("Advisor 1");

		Client adv1Principal = new Client("Jean", "Truc",
				"jean.truc@proxibanque.fr");
		adv1Principal.setCurrentAccount(new Account("366980776", 66.6F));
		adv1Principal.setSavingsAccount(new Account("366980752", 2000F));

		List<Client> adv1Clients = Arrays.asList(
				new Client("Jo", "Répaduvnir", "jo.repaduv@proxibanque.fr",
						new Account("366466008", 200.54F),
						new Account("366467040", 4000F)),
				new Client("Al", "Anver", "al.anver@proxibanque.fr",
						new Account("366002546", 1000F),
						new Account("366002354", 642.1F)));

		adv1.setPrincipal(adv1Principal);
		adv1.setClients(adv1Clients);
		this.advisors.add(adv1);
	}
	
	private void buildAdvisor2() {
		Advisor adv2 = new Advisor("Advisor 2");
		
		this.advisors.add(adv2);
	}

}
