package client;
import java.io.File;

import lectureEcritureFichier.LectureFichierTexte;
import modele.Joueur;
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
        Joueur joueur1 = managerDeQuete1.niveau1("efficace");
        System.out.println(joueur1.getParcoursNum());
        System.out.println(joueur1.getExperience());
        

        ManagerDeQuete managerDeQuete2 = new ManagerDeQuete(scenario);
        Joueur joueur2 = managerDeQuete2.niveau1("exhaustive");
        System.out.println(joueur2.getParcoursNum());
        System.out.println(joueur1.getExperience());
    }
}
