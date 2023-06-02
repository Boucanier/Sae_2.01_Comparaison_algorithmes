package vue;

import controleur.Controleur;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GridPaneFormulaire extends GridPane {
    public ComboBox<String> comboBoxSolution = new ComboBox<String>();
    
    public GridPaneFormulaire() {
        Controleur controleur = new Controleur();
        Label choixSolution = new Label("Choix de la solution");
        
        this.setPadding(new Insets(10));
        this.add(choixSolution, 0, 0);
    }
}
