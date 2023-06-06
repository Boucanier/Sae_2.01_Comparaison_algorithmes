package controleur;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioMenuItem;
import lectureEcritureFichier.LectureFichierTexte;
import modele.Joueur;
import modele.ManagerDeQuete;
import modele.Scenario;
import vue.GridPaneFormulaire;
import vue.VBoxSolution;
import vue.VBoxTable;

/**
 * Controleur de l'application qui gère les événements
 * Implémente l'interface EventHandler
 */
public class Controleur implements EventHandler<ActionEvent> {
    public static ArrayList<String> listeScenario = VBoxSolution.getListeScenario();

    /**
     * Constructeur de la classe Controleur
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button){
            switch ((((Button) event.getSource()).getAccessibleText())){
                case "valider":
                    String nomScenario = VBoxSolution.getStackPaneSolution().getChildren().get(listeScenario.size() - 1).getUserData().toString();
                    String solution = GridPaneFormulaire.getChoixSolution();
                    String critere = GridPaneFormulaire.getChoixCritere();
                    String ordre = GridPaneFormulaire.getChoixTri();
                    int nombre = GridPaneFormulaire.getChoixNombre();

                    System.out.println(nomScenario + " " + solution + " " + critere + " " + ordre + " " + nombre + " solutions");

                    Scenario scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + nomScenario));
                    ManagerDeQuete managerDeQuete = new ManagerDeQuete(scenario);
                    ArrayList<Joueur> listeJoueur = managerDeQuete.niveau2(nombre, solution, critere, ordre);
                    VBoxTable vBoxTable = (VBoxTable) VBoxSolution.getStackPaneSolution().getChildren().get(listeScenario.size() - 1);
                    vBoxTable.update(listeJoueur);
                
                case "annuler" :
                    GridPaneFormulaire.resetFormulaire();
            }
        }
        if (event.getSource() instanceof RadioMenuItem){
            RadioMenuItem radioMenuItem = (RadioMenuItem) event.getSource();
            String choix = radioMenuItem.getUserData().toString();

            for (int i = 0; i < listeScenario.size(); i++) {
                String scenario = VBoxSolution.getStackPaneSolution().getChildren().get(i).getUserData().toString();
                if (scenario.equals(choix)) {
                    VBoxSolution.getStackPaneSolution().getChildren().get(i).toFront();
                    break;
                }
            }
        }
    }
}
