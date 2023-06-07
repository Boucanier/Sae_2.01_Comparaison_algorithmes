package vue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import lectureEcritureFichier.LectureFichierTexte;
import modele.ConstantesSolutions;
import modele.ManagerDeQuete;
import modele.Scenario;

/**
 * Contient un stackPane de solution pour chaque scénario et un GridPaneFormulaire
 * Hérite de la classe VBox
 * Implémente l'interface ConstantesSolutions
 */
public class VBoxSolution extends VBox implements ConstantesSolutions {
    public static StackPane stackPaneSolution = new StackPane();
    public static ArrayList<String> listeScenario = new ArrayList<String>();

    /**
     * Permet de récupérer la liste des noms de scénarios
     * @return ArrayList<String>
     */
    public static ArrayList<String> getListeScenario() {
        return listeScenario;
    }

    /**
     * Constructeur de la classe VBoxSolution
     */
    public VBoxSolution() {
        File[] fichiers = new File("scenarios").listFiles();
        Arrays.sort(fichiers);
        GridPaneFormulaire gridPaneFormulaire = new GridPaneFormulaire();
        
        for (File item : fichiers){
            Scenario scenario = LectureFichierTexte.lecture(item);
            ManagerDeQuete managerDeQuete = new ManagerDeQuete(scenario);
            Label labelSolution = new Label("Scenario " + item.getName().substring(9, item.getName().length() - 4));
            labelSolution.setId("titre");
            VBoxTable vBoxTable = new VBoxTable(managerDeQuete.niveau1("efficace"), item.getName().substring(9, item.getName().length() - 4));
            vBoxTable.setUserData(item.getName());
            stackPaneSolution.getChildren().addAll(vBoxTable);
            listeScenario.add(item.getName());
        }
        CanvasSolution canvasSolution = new CanvasSolution(430,920, LectureFichierTexte.lecture(fichiers[0]));
        stackPaneSolution.getChildren().add(canvasSolution);
        stackPaneSolution.getChildren().get(stackPaneSolution.getChildren().size() - 1).setUserData("canvas");

        this.getChildren().addAll(stackPaneSolution, gridPaneFormulaire);
    }

    /**
     * Permet de récupérer le stackPaneSolution
     * @return stackPaneSolution
     */
    public static StackPane getStackPaneSolution() {
        return stackPaneSolution;
    }

    /**
     * Permet de modifier le stackPaneSolution
     * @param parStackPaneSolution
     */
    public static void setStackPaneSolution(StackPane parStackPaneSolution) {
        stackPaneSolution = parStackPaneSolution;
    }
}
