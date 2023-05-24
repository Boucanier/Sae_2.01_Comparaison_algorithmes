package vue;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lectureEcritureFichier.LectureFichierTexte;
import modele.ConstantesSolutions;
import modele.ManagerDeQuete;
import modele.Quete;
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
            VBox vBox = new VBox();
            Label labelSolution = new Label(solution);
            vBox.getChildren().addAll(labelSolution);
            ManagerDeQuete managerDeQuete = new ManagerDeQuete(scenario);
            ArrayList<Quete> arrayQuetes = managerDeQuete.niveau1(solution);
            Iterator<Quete> itr = arrayQuetes.iterator();
            while (itr.hasNext()){
                Quete e = itr.next();
                HBox hBox = new HBox();
                Label numero = new Label(String.valueOf(e.getNumero()) + " ");
                Label nom = new Label(e.getIntitule() + ", ");
                Label duree = new Label("duree = " + String.valueOf(e.getDuree()) + ", ");
                Label experience = new Label("xp = " + String.valueOf(e.getExperience()) + " ");
                int [] precondTab = e.getPrecond();
                Label precond = new Label("((" + String.valueOf(precondTab[0]) + ", " + String.valueOf(precondTab[1]) + "), (" + String.valueOf(precondTab[2]) + ", " + String.valueOf(precondTab[3]) + ")) ");
                int [] posTab = e.getPos();
                Label pos = new Label(String.valueOf(posTab[0]) + ":" + String.valueOf(posTab[1]));
                hBox.getChildren().addAll(numero, nom, duree, experience, precond, pos);
                vBox.getChildren().addAll(hBox);
            }
            this.setId("solution");
            this.getChildren().addAll(vBox);
        }
    }
}
