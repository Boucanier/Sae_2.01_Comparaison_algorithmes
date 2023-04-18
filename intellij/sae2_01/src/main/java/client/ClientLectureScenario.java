package client;
import java.io.File;

import lectureEcritureFichier.LectureFichierTexte;
import modele.Scenario;

public class ClientLectureScenario {
    public static void main (String[] args) {
        Scenario scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + "scenario_9.txt"));
        System.out.println(scenario);
    }
}