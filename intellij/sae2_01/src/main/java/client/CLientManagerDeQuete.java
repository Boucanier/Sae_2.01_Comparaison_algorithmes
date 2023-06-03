package client;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lectureEcritureFichier.LectureFichierTexte;
import modele.Joueur;
import modele.ManagerDeQuete;
import modele.Quete;
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
