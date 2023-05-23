package vue;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lectureEcritureFichier.LectureFichierTexte;
import modele.ConstantesSolutions;
import modele.ManagerDeQuete;
import modele.Scenario;

/**
 * Contient les tableaux des quêtes des solutions pour le niveau 1
 * 
 * !!! N'AFFICHE QUE LES LISTES DES QUÊTES POUR LE MOMENT !!!
 */
public class VBoxTable extends VBox implements ConstantesSolutions {
    private Scenario scenario;

    /**
     * Constructeur de la classe VBoxTable
     * @param parNomFichier
     */
    public VBoxTable(String parNomFichier) {
        scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + parNomFichier));
        for (String solution : SOLUTIONS){
            Label labelSolution = new Label(solution);
            ManagerDeQuete managerDeQuete = new ManagerDeQuete(scenario);
            ArrayList<Integer> arrayList = managerDeQuete.niveau1(solution);
            Label listeSolutions = new Label(arrayList.toString());
            this.setId("solution");
            this.getChildren().addAll(labelSolution, listeSolutions);
        }
    }
}
