package vue;

import java.io.File;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lectureEcritureFichier.LectureFichierTexte;
import modele.ConstantesSolutions;
import modele.ManagerDeQuete;
import modele.Quete;
import modele.Scenario;

/**
 * Tableau de solution qui contient des quêtes
 * Hérite de la classe VBox
 * Implémente l'interface ConstantesSolutions
 */
public class VBoxTable extends VBox implements ConstantesSolutions {
    private Scenario scenario;
    private TableView<Quete> tableQuete;

    /**
     * Constructeur de la classe VBoxTable
     * @param parNomFichier
     * @param parSolution
     */
    public VBoxTable(String parNomFichier, String parSolution) {
        super(20);
        scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + parNomFichier));
        HBox hBox = new HBox(30);

        tableQuete = new TableView<Quete>();
        TableColumn<Quete, Integer> numeroCol = new TableColumn<Quete, Integer>("Numéro");
        numeroCol.setCellValueFactory(new PropertyValueFactory<>("numero"));
        numeroCol.setReorderable(false);
        numeroCol.setSortable(false);
        numeroCol.setResizable(false);
        numeroCol.setPrefWidth(80);
        numeroCol.setId("colonne");
        TableColumn<Quete, String> nomCol = new TableColumn<Quete, String>("Intitulé");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("intitule"));
        nomCol.setReorderable(false);
        nomCol.setSortable(false);
        nomCol.setResizable(false);
        nomCol.setPrefWidth(420);
        nomCol.setId("colonne");
        TableColumn<Quete, Integer> dureeCol = new TableColumn<Quete, Integer>("Durée");
        dureeCol.setCellValueFactory(new PropertyValueFactory<>("duree"));
        dureeCol.setReorderable(false);
        dureeCol.setSortable(false);
        dureeCol.setResizable(false);
        dureeCol.setId("colonne");
        TableColumn<Quete, Integer> experienceCol = new TableColumn<Quete, Integer>("Expérience");
        experienceCol.setCellValueFactory(new PropertyValueFactory<>("experience"));
        experienceCol.setReorderable(false);
        experienceCol.setSortable(false);
        experienceCol.setResizable(false);
        experienceCol.setPrefWidth(100);
        experienceCol.setId("colonne");
        TableColumn<Quete, String> precondCol = new TableColumn<Quete, String>("Préconditions");
        precondCol.setCellValueFactory(new PropertyValueFactory<>("precondStr"));
        precondCol.setReorderable(false);
        precondCol.setSortable(false);
        precondCol.setResizable(false);
        precondCol.setPrefWidth(120);
        precondCol.setId("colonne");
        TableColumn<Quete, String> posCol = new TableColumn<Quete, String>("Positions");
        posCol.setCellValueFactory(new PropertyValueFactory<>("posStr"));
        posCol.setReorderable(false);
        posCol.setSortable(false);
        posCol.setResizable(false);
        posCol.setId("colonne");
        posCol.setPrefWidth(90);

        tableQuete.getColumns().addAll(numeroCol, nomCol, dureeCol, experienceCol, precondCol, posCol);

        tableQuete.setFixedCellSize(25);
        tableQuete.setId("tableau");

        hBox.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(tableQuete);

        this.setId("solution");
        this.getChildren().addAll(hBox);

        ManagerDeQuete managerDeQuete = new ManagerDeQuete(scenario);
        ArrayList<Quete> listeQuetes = managerDeQuete.niveau1(parSolution).getParcoursQuete();
        for (Quete quete : listeQuetes){
            tableQuete.getItems().add(quete);
        }
    }

    /**
     * Met à jour le tableau de solution
     * @param listeQuetes
     */
    public void update(ArrayList<Quete> listeQuetes){
        tableQuete.getItems().clear();
        for (Quete quete : listeQuetes){
            tableQuete.getItems().add(quete);
        }
    }
}
