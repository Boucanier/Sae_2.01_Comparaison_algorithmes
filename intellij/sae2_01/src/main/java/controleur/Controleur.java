package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import vue.GridPaneFormulaire;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        if (event.getSource() instanceof Button){
            switch ((((Button) event.getSource()).getAccessibleText())){
                case "valider":
                    System.out.println(GridPaneFormulaire.getChoixScenario() + " " + GridPaneFormulaire.getChoixSolution());
            }
        }
    }
}
