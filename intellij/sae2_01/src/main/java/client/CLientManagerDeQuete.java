package client;
import java.io.File;
import java.util.ArrayList;

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

        int nbSolutions = 4;
        String typeSolution = "exhaustif"; // efficace / exhaustif
        String objectEtudie = "dureeTotal"; // dureeTotal / experience / deplacement / parcoursNum
        String meilleurPire = "meilleur"; // meilleur / pire 
        ArrayList<Joueur> solutions = managerDeQuete1.niveau2(nbSolutions, typeSolution , objectEtudie, meilleurPire);
        

        System.out.println(objectEtudie);
        for (Joueur joueur : solutions){
            System.out.println(joueur);
            if (objectEtudie.equals("experience"))
                System.out.println("Experience : " + joueur.getExperience());
            else if (objectEtudie.equals("dureeTotal"))
                System.out.println("Duree total : " + joueur.getDureeTotal());
            else if (objectEtudie.equals("deplacement"))
                System.out.println("Déplacement : " + joueur.getDeplacement());
            else if (objectEtudie.equals("parcoursNum"))
                System.out.println("Nombre de quetes : " + joueur.getParcoursNum().size());
        }
    }
}
