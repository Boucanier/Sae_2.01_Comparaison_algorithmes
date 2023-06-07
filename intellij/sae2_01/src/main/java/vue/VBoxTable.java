package vue;

import java.util.ArrayList;

import controleur.Controleur;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.ConstantesSolutions;
import modele.Joueur;

/**
 * Tableau de solution qui contient des Joueur
 * Hérite de la classe VBox
 * Implémente l'interface ConstantesSolutions
 */
public class VBoxTable extends VBox implements ConstantesSolutions {
    private TableView<Joueur> tableJoueur;

    /**
     * Constructeur de la classe VBoxTable
     * @param parNomFichier
     * @param parSolution
     */
    public VBoxTable(Joueur joueur, String parScenario) {
        super(20);
        VBox vbox = new VBox(20);
        Controleur controleur = GridPaneFormulaire.getControleur();

        Label labelScenario = new Label("Scenario " + parScenario);
        labelScenario.setId("titre");
        labelScenario.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(30);

        tableJoueur = new TableView<Joueur>();
        TableColumn<Joueur, Integer> dureeCol = new TableColumn<Joueur, Integer>("Durée");
        dureeCol.setCellValueFactory(new PropertyValueFactory<>("dureeTotal"));
        dureeCol.setReorderable(false);
        dureeCol.setSortable(false);
        dureeCol.setResizable(false);
        dureeCol.setId("colonne");
        dureeCol.setPrefWidth(100);
        TableColumn<Joueur, Integer> experienceCol = new TableColumn<Joueur, Integer>("Expérience");
        experienceCol.setCellValueFactory(new PropertyValueFactory<>("experience"));
        experienceCol.setReorderable(false);
        experienceCol.setSortable(false);
        experienceCol.setResizable(false);
        experienceCol.setId("colonne");
        experienceCol.setPrefWidth(150);
        TableColumn<Joueur, ArrayList<Integer>> parcoursCol = new TableColumn<Joueur, ArrayList<Integer>>("Parcours");
        parcoursCol.setCellValueFactory(new PropertyValueFactory<>("parcoursNum"));
        parcoursCol.setReorderable(false);
        parcoursCol.setSortable(false);
        parcoursCol.setResizable(false);
        parcoursCol.setId("colonne");
        parcoursCol.setPrefWidth(300);
        TableColumn<Joueur, Integer> deplacementCol = new TableColumn<Joueur, Integer>("Déplacements");
        deplacementCol.setCellValueFactory(new PropertyValueFactory<>("deplacement"));
        deplacementCol.setReorderable(false);
        deplacementCol.setSortable(false);
        deplacementCol.setResizable(false);
        deplacementCol.setId("colonne");
        deplacementCol.setPrefWidth(150);

        tableJoueur.getColumns().addAll(dureeCol, experienceCol, parcoursCol, deplacementCol);

        tableJoueur.setFixedCellSize(25);
        tableJoueur.setId("tableau");


        TableViewSelectionModel<Joueur> selectionModel = tableJoueur.getSelectionModel();
        tableJoueur.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tableJoueur.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                ObservableList<Joueur> selectedItems = selectionModel.getSelectedItems();
                if (selectedItems != null) {
                    controleur.setJoueur(selectedItems.get(0));
                }
            }
        });

        hBox.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(tableJoueur);

        vbox.getChildren().addAll(labelScenario, hBox);

        this.setId("solution");
        this.getChildren().addAll(vbox);

        tableJoueur.getItems().add(joueur);
    }

    /**
     * Met à jour le tableau de solution
     * @param listeQuetes
     */
    public void update(ArrayList<Joueur> listeJoueurs){
        tableJoueur.getItems().clear();
        for (Joueur joueur : listeJoueurs){
            tableJoueur.getItems().add(joueur);
        }
    }
}
