package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.ConstantesSolutions;

/**
 * Contient le nom de la solution choisie ainsi qu'un StackPane contenant les solutions pour tous les scénarios pour cette solution
 * Hérite de la classe VBox
 */
public class VBoxSolution extends VBox implements ConstantesSolutions {
    private StackPane stackPaneSolution = new StackPane();

    /**
     * Constructeur de la classe VBoxSolution
     */
    public VBoxSolution() {
        for (String item : SOLUTIONS){
            Label labelSolution = new Label("Solution " + item);
            labelSolution.setUserData(item);
            labelSolution.setId("solution");
            stackPaneSolution.getChildren().add(labelSolution);
        }
        this.getChildren().addAll(stackPaneSolution);
    }
    public StackPane getStackPaneSolution() {
        return stackPaneSolution;
    }

    public void setStackPaneSolution(StackPane parStackPaneSolution) {
        stackPaneSolution = parStackPaneSolution;
    }
}
