package vue;

import controleur.Controleur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import modele.ConstantesSolutions;

public class GridPaneFormulaire extends GridPane implements ConstantesSolutions{
    public ComboBox<String> comboBoxSolution;
    
    public GridPaneFormulaire() {
        Controleur controleur = new Controleur();

        Label choixSolution = new Label("Choix de la solution");
        comboBoxSolution = peupleComboBox();

        comboBoxSolution.setValue(comboBoxSolution.getItems().get(0));

        Button boutonAnnuler = new Button("_Annuler");
        Button boutonValider = new Button("_Valider");
        
        this.setPadding(new Insets(10));
        this.add(new Separator(), 0, 0, 2, 1);
        this.add(choixSolution, 0, 1, 2, 1);
        this.add(comboBoxSolution, 0, 2, 2, 1);
        this.add(boutonAnnuler, 0, 3, 1, 1);
        this.add(boutonValider, 1, 3, 1, 1);

        this.setAlignment(Pos.CENTER);
        this.setId("titre");
        this.setGridLinesVisible(true);
    }

    private ComboBox<String> peupleComboBox() {
        ComboBox<String> comboBox = new ComboBox<String>();
        for (String item : SOLUTIONS) {
            comboBox.getItems().add(item);
        }
        return comboBox;
    }

    public ComboBox<String> getComboBoxSolution() {
        return comboBoxSolution;
    }

    public void setComboBoxSolution(ComboBox<String> comboBoxSolution) {
        this.comboBoxSolution = comboBoxSolution;
    }
}
