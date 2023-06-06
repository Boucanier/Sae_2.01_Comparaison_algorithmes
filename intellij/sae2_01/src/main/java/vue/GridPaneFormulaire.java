package vue;

import controleur.Controleur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modele.ConstantesSolutions;

/**
 * Contient le formulaire de choix du scénario et de la solution
 * Hérite de la classe GridPane
 * Implémente l'interface ConstantesSolutions
 */
public class GridPaneFormulaire extends GridPane implements ConstantesSolutions{
    public static ComboBox<String> comboBoxSolution;
    public static ComboBox<String> comboBoxCritere;
    public static ComboBox<Integer> comboBoxNombre;
    public static ComboBox<String> comboBoxTri;
    public static TextField nombreField;
    public static Controleur controleur = new Controleur();
    
    public static Controleur getControleur() {
        return controleur;
    }

    /**
     * Constructeur de la classe GridPaneFormulaire
     */
    public GridPaneFormulaire() {

        Label choixTri = new Label("Ordre des solutions");
        comboBoxTri = peupleComboBoxTri();
        comboBoxTri.setValue(comboBoxTri.getItems().get(0));

        Label choixNombre = new Label("Nombre maximum de solutions");
        comboBoxNombre = peupleComboBoxNombre();
        comboBoxNombre.setValue(comboBoxNombre.getItems().get(0));

        nombreField = new TextField();
        nombreField.setPromptText("Maximum");

        // Ici, on vérifie si la valeur entrée est un nombre
        nombreField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                nombreField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Label choixCritere = new Label("Choix du critère");
        comboBoxCritere = peupleComboBoxCritere();
        comboBoxCritere.setValue(comboBoxCritere.getItems().get(0));

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
        this.add(choixCritere, 0, 1, 2, 1);
        this.add(comboBoxCritere, 0, 2, 2, 1);
        this.add(choixNombre, 2, 1, 2, 1);
        this.add(nombreField, 2, 2, 2, 1);
        this.add(choixSolution, 0, 3, 2, 1);
        this.add(comboBoxSolution, 0, 4, 2, 1);
        this.add(choixTri, 2, 3, 2, 1);
        this.add(comboBoxTri, 2, 4, 2, 1);
        this.add(boutonAnnuler, 1, 5, 1, 1);
        this.add(boutonValider, 2, 5, 1, 1);

        this.setAlignment(Pos.CENTER);
        this.setId("formulaire");
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
     * Permet de peupler la comboBoxCritere
     * @return ComboBox
     */
    private ComboBox<String> peupleComboBoxCritere() {
        ComboBox<String> comboBox = new ComboBox<String>();
        
        for (String item : CRITERE){
            comboBox.getItems().add(item);
        }
        return comboBox;
    }

    /**
     * Permet de récupérer le choix du critère
     * @return String
     */
    public static String getChoixCritere() {
        return comboBoxCritere.getValue();
    }

    /**
     * Permet de peupler la comboBoxNombre
     * @return ComboBox
     */
    private ComboBox<Integer> peupleComboBoxNombre() {
        ComboBox<Integer> comboBox = new ComboBox<Integer>();
        
        for (int i = 1; i <= 10; i++){
            comboBox.getItems().add(i);
        }
        return comboBox;
    }

    /**
     * Permet de récupérer le choix du nombre de solution à afficher
     * @return String
     */
    public static int getChoixNombre() {
        return nombreField.getText().isEmpty() ? comboBoxNombre.getValue() : Integer.parseInt(nombreField.getText());
    }

    /**
     * Permet de peupler la comboBoxTri
     * @return ComboBox
     */
    private ComboBox<String> peupleComboBoxTri() {
        ComboBox<String> comboBox = new ComboBox<String>();
        
        for (String item : TRI){
            comboBox.getItems().add(item);
        }
        return comboBox;
    }

    /**
     * Permet de récupérer le choix de l'ordre des solutions à afficher
     * @return String
     */
    public static String getChoixTri() {
        return comboBoxTri.getValue();
    }

    public static void resetFormulaire() {
        comboBoxCritere.setValue(comboBoxCritere.getItems().get(0));
        comboBoxSolution.setValue(comboBoxSolution.getItems().get(0));
        comboBoxTri.setValue(comboBoxTri.getItems().get(0));
        nombreField.clear();
    }
}
