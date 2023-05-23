package vue;

import java.io.File;
import java.util.Arrays;

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
        
        for (File item : fichiers){
            Label labelSolution = new Label(item.getName());
            labelSolution.setUserData(item.getName());
            labelSolution.setId("solution");
            stackPaneSolution.getChildren().add(labelSolution);
        }
        this.getChildren().add(stackPaneSolution);
    }

    public StackPane getStackPaneSolution() {
        return stackPaneSolution;
    }

    public void setStackPaneSolution(StackPane parStackPaneSolution) {
        stackPaneSolution = parStackPaneSolution;
    }
}
