package client;
import java.io.File;

import lectureEcritureFichier.LectureFichierTexte;
import modele.ManagerDeQuete;
import modele.Scenario;

/**
 * Classe ClientManagerDeQuete qui permet de tester le manager de quête
 */
public class CLientManagerDeQuete {
    /**
     * Méthode main de la classe ClientManagerDeQuete qui permet de tester le manager de quête
     * @param args
     */
    public static void main (String[] args) {
        Scenario scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + "scenario_0.txt"));
        ManagerDeQuete managerDeQuete1 = new ManagerDeQuete(scenario);
    }
}
