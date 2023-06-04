package vue;

import java.io.File;
import java.util.Arrays;

import controleur.Controleur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import modele.ConstantesSolutions;

/**
 * Contient le formulaire de choix du scénario et de la solution
 * Hérite de la classe GridPane
 * Implémente l'interface ConstantesSolutions
 */
public class GridPaneFormulaire extends GridPane implements ConstantesSolutions{
    public static ComboBox<String> comboBoxSolution;
    public static ComboBox<String> comboBoxScenario;
    
    /**
     * Constructeur de la classe GridPaneFormulaire
     */
    public GridPaneFormulaire() {
        Controleur controleur = new Controleur();

        Label choixScenario = new Label("Choix du scénario");
        comboBoxScenario = peupleComboBoxScenario();
        comboBoxScenario.setValue(comboBoxScenario.getItems().get(0));

        Label choixSolution = new Label("Choix de la solution");
        comboBoxSolution = peupleComboBoxSolution();
        comboBoxSolution.setValue(comboBoxSolution.getItems().get(0));

        Button boutonAnnuler = new Button("_Annuler");
        boutonAnnuler.setAccessibleText("annuler");
        boutonAnnuler.setOnAction(controleur);
        Button boutonValider = new Button("_Valider");
        boutonValider.setAccessibleText("valider");
        boutonValider.setOnAction(controleur);
        
        this.setPadding(new Insets(10));
        this.add(new Separator(), 0, 0, 2, 1);
        this.add(choixScenario, 0, 1, 2, 1);
        this.add(comboBoxScenario, 0, 2, 2, 1);
        this.add(choixSolution, 0, 3, 2, 1);
        this.add(comboBoxSolution, 0, 4, 2, 1);
        this.add(boutonAnnuler, 0, 5, 1, 1);
        this.add(boutonValider, 1, 5, 1, 1);

        this.setAlignment(Pos.CENTER);
        this.setId("titre");
        // this.setGridLinesVisible(true);
    }

    /**
     * Permet de peupler la comboBoxSolution
     * @return ComboBox
     */
    private ComboBox<String> peupleComboBoxSolution() {
        ComboBox<String> comboBox = new ComboBox<String>();
        for (String item : SOLUTIONS) {
            comboBox.getItems().add(item);
        }
        return comboBox;
    }

    /**
     * Permet de récupérer le choix de la solution
     * @return String
     */
    public static String getChoixSolution() {
        return comboBoxSolution.getValue();
    }

    /**
     * Permet de peupler la comboBoxScenario
     * @return ComboBox
     */
    private ComboBox<String> peupleComboBoxScenario() {
        ComboBox<String> comboBox = new ComboBox<String>();

        File[] fichiers = new File("scenarios").listFiles();
        Arrays.sort(fichiers);
        
        for (File item : fichiers){
            comboBox.getItems().add(item.getName());
        }
        return comboBox;
    }

    /**
     * Permet de récupérer le choix du scénario
     * @return String
     */
    public static String getChoixScenario() {
        return comboBoxScenario.getValue();
    }

    public static void resetFormulaire() {
        comboBoxScenario.setValue(comboBoxScenario.getItems().get(0));
        comboBoxSolution.setValue(comboBoxSolution.getItems().get(0));
    }
}
