package vue;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.layout.VBox;
import modele.ConstantesSolutions;

/**
 * Contient le menu de sélection du scénario
 * Hérite de la classe VBox
 */
public class VBoxRootMenu extends VBox implements ConstantesSolutions {
    public static MenuBar menuBar = new MenuBar();
    // public static Menu menuScenario = new Menu("S_cénarios");
    public static Menu quitMenu = new Menu("_Quitter");
    public static VBoxSolution vBoxSolution = new VBoxSolution();

    /**
     * Constructeur de la classe VBoxRootMenu
     */
    public VBoxRootMenu() {

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

        menuBar.getMenus().addAll(quitMenu);
        this.getChildren().addAll(menuBar,vBoxSolution);
    }
}
