package vue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import modele.ConstantesSolutions;
import controleur.Controleur;

/**
 * Contient le menu de sélection du scénario et le bouton pour quitter l'application
 * Hérite de la classe VBox
 * Implémente l'interface ConstantesSolutions
 * 
 * @see VBox
 * @see ConstantesSolutions
 */
public class VBoxRootMenu extends VBox implements ConstantesSolutions {
    public static MenuBar menuBar = new MenuBar();
    public static Menu menuScenario = new Menu("_Scénarios");
    public static Menu quitMenu = new Menu("_Quitter");
    public static VBoxSolution vBoxSolution = new VBoxSolution();

    /**
     * Constructeur de la classe VBoxRootMenu
     */
    public VBoxRootMenu() {

        Controleur controleur = GridPaneFormulaire.getControleur();

        RadioMenuItem menuItem = new RadioMenuItem("_Quitter");
        quitMenu.getItems().add(menuItem);
        quitMenu.setMnemonicParsing(true);
        menuItem.setId("menuItem");
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quitter l'application ?");
                alert.setHeaderText("Êtes-vous certain de vouloir quitter l'application ?");

                Optional<ButtonType> option = alert.showAndWait();
                if (option.get() == ButtonType.OK)
                    System.exit(0);
            }
        });

        //prend liste des scénarios
        ArrayList<String> listeScenario = VBoxSolution.getListeScenario();
        
        // on supprime tous ce qui n'est pas des str
        ArrayList<String> nouvelleListe = new ArrayList<>();
        for (String item : listeScenario) {
            String itemSansCaracteresNonIntegers = item.replaceAll("\\D", "");
            nouvelleListe.add(itemSansCaracteresNonIntegers);
        }

        //on trie la liste dans l'ordre croissant
        ArrayList<Integer> listeTriee = new ArrayList<>();
        for (String item : nouvelleListe) {
            int nombre = Integer.parseInt(item);
            listeTriee.add(nombre);
        }
        Collections.sort(listeTriee);

        //mettre toute la liste sous forme de scénario scenario_X.txt
        ArrayList<String> listeScenarioTriee = new ArrayList<>();
        for (Integer numScenario : listeTriee) {
            String vraiScenario = "scenario_" + numScenario + ".txt";
            listeScenarioTriee.add(vraiScenario);
        }
        
        ToggleGroup toggleGroup = new ToggleGroup();
        for (int i= 0; i < listeTriee.size(); i++){
            RadioMenuItem radioMenuItem = new RadioMenuItem("Scenario " + listeTriee.get(i));
            radioMenuItem.setUserData(listeScenarioTriee.get(i));
            radioMenuItem.setMnemonicParsing(true);
            radioMenuItem.setId("menuItem");
            radioMenuItem.setToggleGroup(toggleGroup);
            menuScenario.getItems().add(radioMenuItem);
            radioMenuItem.setOnAction(controleur);
        }

        ((RadioMenuItem) menuScenario.getItems().get(0)).setSelected(true);
        
        for (int i = 0; i < menuScenario.getItems().size(); i++) {
            if (((RadioMenuItem) menuScenario.getItems().get(i)).isSelected()) {
                VBoxSolution.getStackPaneSolution().getChildren().get(i).toFront();
            }
        }

        menuBar.getMenus().addAll(menuScenario, quitMenu);
        this.getChildren().addAll(menuBar, vBoxSolution);
    }
}
