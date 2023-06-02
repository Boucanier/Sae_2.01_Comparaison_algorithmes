package vue;

import java.io.File;
import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.ConstantesSolutions;

/**
 * Contient un stackPane de scénarios
 * Hérite de la classe VBox
 */
public class VBoxSolution extends VBox implements ConstantesSolutions {
    private StackPane stackPaneSolution = new StackPane();

    /**
     * Constructeur de la classe VBoxSolution
     */
    public VBoxSolution() {
        File[] fichiers = new File("scenarios").listFiles();
        Arrays.sort(fichiers);
        
        for (File item : fichiers){
            VBox vBox = new VBox();
            GridPaneFormulaire gridPaneFormulaire = new GridPaneFormulaire();
            Label labelSolution = new Label("Scenario " + item.getName().substring(9, item.getName().length() - 4));
            labelSolution.setId("titre");
            VBoxTable vBoxTable = new VBoxTable(item.getName());
            labelSolution.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(labelSolution, gridPaneFormulaire, vBoxTable);
            vBox.setUserData(item.getName());
            vBox.setAlignment(Pos.CENTER);
            stackPaneSolution.getChildren().addAll(vBox);
        }
        this.getChildren().add(stackPaneSolution);
    }

    /**
     * Permet de récupérer le stackPaneSolution
     * @return stackPaneSolution
     */
    public StackPane getStackPaneSolution() {
        return stackPaneSolution;
    }

    /**
     * Permet de modifier le stackPaneSolution
     * @param parStackPaneSolution
     */
    public void setStackPaneSolution(StackPane parStackPaneSolution) {
        stackPaneSolution = parStackPaneSolution;
    }
}
