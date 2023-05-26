package client;
import java.io.File;

import lectureEcritureFichier.LectureFichierTexte;
import modele.Scenario;

/**
 * Classe ClientLectureScenario qui permet de tester la lecture d'un scénario
 */
public class ClientLectureScenario {
    /**
     * Méthode main de la classe ClientLectureScenario qui permet de tester la lecture d'un scénario
     * @param args
     */
    public static void main (String[] args) {
        Scenario scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + "scenario_0.txt"));
        System.out.println(scenario);
    }
}