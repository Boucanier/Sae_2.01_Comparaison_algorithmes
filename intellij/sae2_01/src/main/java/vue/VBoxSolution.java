package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.ConstantesSolutions;

public class VBoxSolution extends VBox implements ConstantesSolutions {
    StackPane stackPaneSolution = new StackPane();

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
