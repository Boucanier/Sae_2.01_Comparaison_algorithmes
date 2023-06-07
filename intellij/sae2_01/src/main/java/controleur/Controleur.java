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
import vue.CanvasSolution;
import vue.GridPaneFormulaire;
import vue.VBoxSolution;
import vue.VBoxTable;

/**
 * Controleur de l'application qui gère les événements
 * Implémente l'interface EventHandler
 * 
 * @see EventHandler
 */
public class Controleur implements EventHandler<ActionEvent> {
    public static ArrayList<String> listeScenario = VBoxSolution.getListeScenario();
    private String nomScenario;
    private Joueur joueurSelect;

    /**
     * Méthode handle de la classe Controleur qui gère les événements
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button){
            switch ((((Button) event.getSource()).getAccessibleText())){
                
                case "simuler" :
                    if (joueurSelect != null) {
                        nomScenario = VBoxSolution.getStackPaneSolution().getChildren().get(listeScenario.size()).getUserData().toString();
                        if (nomScenario.equals("canvas")) {
                            nomScenario = VBoxSolution.getStackPaneSolution().getChildren().get(listeScenario.size() - 1).getUserData().toString();
                        }
                        Scenario scenario2 = LectureFichierTexte.lecture(new File("scenarios" + File.separator + nomScenario));
                        for (int i = 0; i < VBoxSolution.getStackPaneSolution().getChildren().size(); i++) {
                            String userData = VBoxSolution.getStackPaneSolution().getChildren().get(i).getUserData().toString();
                            if (userData.equals("canvas")) {
                                ((CanvasSolution) VBoxSolution.getStackPaneSolution().getChildren().get(i)).draw(scenario2);
                                VBoxSolution.getStackPaneSolution().getChildren().get(i).toFront();
                                break;
                            }
                        }
                    }
                    joueurSelect = null;
                    break;

                case "valider" :
                    nomScenario = VBoxSolution.getStackPaneSolution().getChildren().get(listeScenario.size()).getUserData().toString();

                    if (nomScenario.equals("canvas")) {
                        nomScenario = VBoxSolution.getStackPaneSolution().getChildren().get(listeScenario.size() - 1).getUserData().toString();

                        for (int i = 0; i < listeScenario.size(); i++) {
                            String scenario = VBoxSolution.getStackPaneSolution().getChildren().get(i).getUserData().toString();
                            if (scenario.equals(nomScenario)) {
                                VBoxSolution.getStackPaneSolution().getChildren().get(i).toFront();
                                break;
                            }
                        }
                    }

                    String solution = GridPaneFormulaire.getChoixSolution();
                    String critere = GridPaneFormulaire.getChoixCritere();
                    String ordre = GridPaneFormulaire.getChoixTri();
                    int nombre = GridPaneFormulaire.getChoixNombre();

                    System.out.println(nomScenario + " " + solution + " " + critere + " " + ordre + " " + nombre + " solutions");

                    Scenario scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + nomScenario));
                    ManagerDeQuete managerDeQuete = new ManagerDeQuete(scenario);
                    ArrayList<Joueur> listeJoueur = managerDeQuete.niveau2(nombre, solution, critere, ordre);
                    VBoxTable vBoxTable = (VBoxTable) VBoxSolution.getStackPaneSolution().getChildren().get(listeScenario.size());
                    vBoxTable.update(listeJoueur);
                    joueurSelect = null;
                    break;
                
                case "annuler" :
                    GridPaneFormulaire.resetFormulaire();
                    nomScenario = VBoxSolution.getStackPaneSolution().getChildren().get(listeScenario.size()).getUserData().toString();

                    if (nomScenario.equals("canvas")) {
                        nomScenario = VBoxSolution.getStackPaneSolution().getChildren().get(listeScenario.size() - 1).getUserData().toString();
                        
                        for (int i = 0; i < listeScenario.size(); i++) {
                            String scenario3 = VBoxSolution.getStackPaneSolution().getChildren().get(i).getUserData().toString();
                            if (scenario3.equals(nomScenario)) {
                                VBoxSolution.getStackPaneSolution().getChildren().get(i).toFront();
                                break;
                            }
                        }
                    }
                    joueurSelect = null;
                    break;
            }
        }
        if (event.getSource() instanceof RadioMenuItem){
            RadioMenuItem radioMenuItem = (RadioMenuItem) event.getSource();
            String choix = radioMenuItem.getUserData().toString();
            joueurSelect = null;

            for (int i = 0; i < listeScenario.size(); i++) {
                String scenario = VBoxSolution.getStackPaneSolution().getChildren().get(i).getUserData().toString();
                if (scenario.equals(choix)) {
                    VBoxSolution.getStackPaneSolution().getChildren().get(i).toFront();
                    break;
                }
            }

            if (choix.equals("scenario_10.txt")) {
                GridPaneFormulaire.getBoutonValider().setDisable(true);
            }
            else {
                GridPaneFormulaire.getBoutonValider().setDisable(false);
            }
        }
    }

    public void setJoueur(Joueur parJoueur) {
        joueurSelect = parJoueur;
    }
}
