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
import modele.ConstantesSolutions;
import modele.Scenario;

/**
 * Contient le menu de sélection de la solution et du scénario
 * Hérite de la classe VBox
 */
public class VBoxRootMenu extends VBox implements ConstantesSolutions {
    public static MenuBar menuBar = new MenuBar();
    public static Menu menu = new Menu("_Solutions");
    public static Menu menuScenario = new Menu("S_cénarios");
    public static Menu quitMenu = new Menu("_Quitter");
    public static Scenario [] scenarios;
    VBoxSolution vBoxSolution = new VBoxSolution();

    /**
     * Constructeur de la classe VBoxRootMenu
     */
    public VBoxRootMenu() {
        ToggleGroup groupSolutions = new ToggleGroup();

        for (String item : SOLUTIONS){
            RadioMenuItem menuItem = new RadioMenuItem("_"+item);
            menuItem.setUserData(item);
            menu.getItems().add(menuItem);
            menuItem.setToggleGroup(groupSolutions);
            menuItem.setId("menuItem");
            menuItem.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent){
                    System.out.println(menuItem.getUserData());
                    String annee = (String) vBoxSolution.getStackPaneSolution().getChildren().get(1).getUserData();

                    if (!annee.equals(menuItem.getUserData()))
                        vBoxSolution.getStackPaneSolution().getChildren().get(1).toBack();
                }
            });
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
            RadioMenuItem menuItemScenario = new RadioMenuItem(fichiers[i].getName());
            menuItemScenario.setUserData(fichiers[i].getName());
            menuScenario.getItems().add(menuItemScenario);
            menuItemScenario.setToggleGroup(groupScenarios);
            menuItemScenario.setId("menuItemScenario");
        }

        ((RadioMenuItem)menu.getItems().get(0)).setSelected(true);
        ((RadioMenuItem)menuScenario.getItems().get(0)).setSelected(true);

        String solution = (String) vBoxSolution.getStackPaneSolution().getChildren().get(1).getUserData();
        if (!solution.equals(groupSolutions.getUserData()))
            vBoxSolution.getStackPaneSolution().getChildren().get(1).toBack();

        menuBar.getMenus().addAll(menu, menuScenario, quitMenu);
        this.getChildren().addAll(menuBar,vBoxSolution);
    }
}
