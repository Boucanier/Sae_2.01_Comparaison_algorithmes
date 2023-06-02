package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import vue.GridPaneFormulaire;
import vue.VBoxSolution;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        if (event.getSource() instanceof Button){
            switch ((((Button) event.getSource()).getAccessibleText())){
                case "valider":
                    System.out.println(GridPaneFormulaire.getChoixScenario() + " " + GridPaneFormulaire.getChoixSolution());

                    for (int i = 0; i < GridPaneFormulaire.getChoixScenario().length(); i++) {
                        String scenario = VBoxSolution.getStackPaneSolution().getChildren().get(i).getUserData().toString();
                        if (scenario.equals(GridPaneFormulaire.getChoixScenario() + " " + GridPaneFormulaire.getChoixSolution())) {
                            VBoxSolution.getStackPaneSolution().getChildren().get(i).toFront();
                            break;
                        }
                    }
            }
        }
    }
}
