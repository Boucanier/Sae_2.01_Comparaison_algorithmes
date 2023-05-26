package lectureEcritureFichier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import modele.Quete;
import modele.Scenario;

/**
 * Classe permettant de lire un fichier texte
 */
public class LectureFichierTexte {
    public static Scenario lecture (File fichier) {
        Scenario scenario = new Scenario();
        try {
            Scanner scanner = new Scanner(fichier, StandardCharsets.UTF_8);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                scenario.ajout(new Quete(line));
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return scenario;
    }
}