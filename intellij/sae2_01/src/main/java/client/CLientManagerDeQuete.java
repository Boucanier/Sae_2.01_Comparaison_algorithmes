package client;
import java.io.File;

import lectureEcritureFichier.LectureFichierTexte;
import modele.ManagerDeQuete;
import modele.Scenario;

public class CLientManagerDeQuete {
    public static void main (String[] args) {
        Scenario scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + "scenario_0.txt"));
        ManagerDeQuete managerDeQuete = new ManagerDeQuete(scenario);
        System.out.println("Le parcours final : " + managerDeQuete.niveau1("efficace"));
        //System.out.println("Le parcours final : " + managerDeQuete.niveau1("exhaustive"));
    }
}
