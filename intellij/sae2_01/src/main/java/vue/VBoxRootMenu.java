package vue;

import java.io.File;
import java.util.Arrays;
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
import lectureEcritureFichier.LectureFichierTexte;
import modele.ConstantesSolutions;
import modele.Scenario;

public class VBoxRootMenu extends VBox implements ConstantesSolutions {
    public static MenuBar menuBar = new MenuBar();
    public static Menu menu = new Menu("_Solutions");
    public static Menu menuScenario = new Menu("_Scénarios");
    public static Menu quitMenu = new Menu("_Quitter");
    public static Scenario [] scenarios;

    public VBoxRootMenu() {
        ToggleGroup groupSolutions = new ToggleGroup();

        for (String item : SOLUTIONS){
            RadioMenuItem menuItem = new RadioMenuItem(item);
            menuItem.setUserData(item);
            menu.getItems().add(menuItem);
            menuItem.setToggleGroup(groupSolutions);
            menuItem.setId("menuItem");
        }
        
        menu.setMnemonicParsing(true);

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

        File[] fichiers = new File("scenarios").listFiles();
        scenarios = new Scenario[fichiers.length];
        Arrays.sort(fichiers);
        
        ToggleGroup groupScenarios = new ToggleGroup();
        for (int i = 0; i < fichiers.length; i++) {
            scenarios[i] = LectureFichierTexte.lecture(fichiers[i]);
            RadioMenuItem menuItemScenario = new RadioMenuItem(fichiers[i].getName());
            menuItemScenario.setUserData(fichiers[i].getName());
            menuScenario.getItems().add(menuItemScenario);
            menuItemScenario.setToggleGroup(groupScenarios);
            menuItemScenario.setId("menuItemScenario");
        }


        menuBar.getMenus().addAll(menu, menuScenario, quitMenu);
        this.getChildren().add(menuBar);
    }
}
