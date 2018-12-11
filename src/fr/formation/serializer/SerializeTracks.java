package fr.formation.serializer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fr.formation.serializer.entity.Track;

public class SerializeTracks implements Runnable {

	public static void main(String[] args) {
		new SerializeTracks().run();
	}

	@Override
	public void run() {
		// Début des traitements du programme.
		List<Track> tracks = Arrays.asList(
				new Track("Spirit mates", "Their dogs were astronauts"),
				new Track("F63.9", "Break my fucking sky"),
				new Track("Libra", "Intervals"),
				new Track("Fractus", "I built the sky"),
				new Track("Ours et compagnie", "Andréas et Nicolas"));
		// Création d'une instance d'objet de la librairie Jackson pour
		// convertir nos objets en flux.
		ObjectMapper mapper = new ObjectMapper();
		// Activation du "pretty print", c'est à dire écrire les données de
		// manière lisibles, avec l'indentation.
		ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
		File jsonFile = new File("S:\\workbench\\tracks.json");
		try {
			writer.writeValue(jsonFile, tracks);
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

}
