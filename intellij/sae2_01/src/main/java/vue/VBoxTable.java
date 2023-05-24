package vue;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.control.Label;
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
 * Contient les tableaux des quêtes des solutions pour le niveau 1
 * Hérite de la classe VBox
 */
public class VBoxTable extends VBox implements ConstantesSolutions {
    private Scenario scenario;
    private TableView<Quete> tableQuete;

    /**
     * Constructeur de la classe VBoxTable
     * @param parNomFichier
     */
    public VBoxTable(String parNomFichier) {
        scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + parNomFichier));
        for (String solution : SOLUTIONS){
            VBox vBox = new VBox();
            Label labelSolution = new Label(solution);
            vBox.getChildren().addAll(labelSolution);
            ManagerDeQuete managerDeQuete = new ManagerDeQuete(scenario);
            ArrayList<Quete> arrayQuetes = managerDeQuete.niveau1(solution);

            tableQuete = new TableView<Quete>();
            TableColumn<Quete, Integer> numeroCol = new TableColumn<Quete, Integer>("numero");
            numeroCol.setCellValueFactory(new PropertyValueFactory<>("numero"));
            numeroCol.setReorderable(false);
            numeroCol.setSortable(false);
            numeroCol.setResizable(false);
            numeroCol.setPrefWidth(70);
            TableColumn<Quete, String> nomCol = new TableColumn<Quete, String>("nom");
            nomCol.setCellValueFactory(new PropertyValueFactory<>("intitule"));
            nomCol.setReorderable(false);
            nomCol.setSortable(false);
            nomCol.setResizable(false);
            nomCol.setPrefWidth(420);
            TableColumn<Quete, Integer> dureeCol = new TableColumn<Quete, Integer>("duree");
            dureeCol.setCellValueFactory(new PropertyValueFactory<>("duree"));
            dureeCol.setReorderable(false);
            dureeCol.setSortable(false);
            dureeCol.setResizable(false);
            TableColumn<Quete, Integer> experienceCol = new TableColumn<Quete, Integer>("experience");
            experienceCol.setCellValueFactory(new PropertyValueFactory<>("experience"));
            experienceCol.setReorderable(false);
            experienceCol.setSortable(false);
            experienceCol.setResizable(false);
            experienceCol.setPrefWidth(100);
            TableColumn<Quete, String> precondCol = new TableColumn<Quete, String>("Préconditions");
            precondCol.setCellValueFactory(new PropertyValueFactory<>("precondStr"));
            precondCol.setReorderable(false);
            precondCol.setSortable(false);
            precondCol.setResizable(false);
            TableColumn<Quete, String> posCol = new TableColumn<Quete, String>("Pos");
            posCol.setCellValueFactory(new PropertyValueFactory<>("posStr"));
            posCol.setReorderable(false);
            posCol.setSortable(false);
            posCol.setResizable(false);

            tableQuete.getColumns().addAll(numeroCol, nomCol, dureeCol, experienceCol, precondCol, posCol);

            tableQuete.getItems().addAll(arrayQuetes);
            tableQuete.setFixedCellSize(25);
            tableQuete.setPrefHeight((arrayQuetes.size()+1) * tableQuete.getFixedCellSize() + 3);
            vBox.getChildren().addAll(tableQuete);

            this.setId("solution");
            this.getChildren().addAll(vBox);
        }
    }
}
