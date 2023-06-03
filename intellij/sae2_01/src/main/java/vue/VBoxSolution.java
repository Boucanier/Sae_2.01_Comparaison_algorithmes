package vue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.ConstantesSolutions;

/**
 * Contient un stackPane de solution pour chaque scénario
 * Hérite de la classe VBox
 * Implémente l'interface ConstantesSolutions
 */
public class VBoxSolution extends VBox implements ConstantesSolutions {
    public static StackPane stackPaneSolution = new StackPane();
    public static ArrayList<String> listeScenario = new ArrayList<String>();

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
            for (String solution : SOLUTIONS){
                VBox vBox = new VBox();
                Label labelSolution = new Label("Scenario " + item.getName().substring(9, item.getName().length() - 4) + " - " + solution);
                labelSolution.setId("titre");
                VBoxTable vBoxTable = new VBoxTable(item.getName(), solution);
                labelSolution.setAlignment(Pos.CENTER);
                vBox.getChildren().addAll(labelSolution, vBoxTable);
                vBox.setUserData(item.getName() + " " + solution);
                vBox.setAlignment(Pos.CENTER);
                stackPaneSolution.getChildren().addAll(vBox);
                listeScenario.add(item.getName());
            }
        }

        stackPaneSolution.getChildren().get(0).toFront();

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
