package vue;

import java.util.ArrayList;
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

        ArrayList<String> listeScenario = VBoxSolution.getListeScenario();
        
        ToggleGroup toggleGroup = new ToggleGroup();
        for (String item : listeScenario){
            RadioMenuItem radioMenuItem = new RadioMenuItem("Scenario " + item.substring(9, item.length() - 4));
            radioMenuItem.setUserData(item);
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
