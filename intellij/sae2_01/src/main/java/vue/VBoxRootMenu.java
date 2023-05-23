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

/**
 * Contient le menu de sélection de la solution et du scénario
 * Hérite de la classe VBox
 */
public class VBoxRootMenu extends VBox implements ConstantesSolutions {
    public static MenuBar menuBar = new MenuBar();
    public static Menu menuScenario = new Menu("S_cénarios");
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

        File[] fichiers = new File("scenarios").listFiles();
        Arrays.sort(fichiers);
        
        ToggleGroup groupScenarios = new ToggleGroup();
        for (File item : fichiers) {
            RadioMenuItem menuItemScenario = new RadioMenuItem(item.getName());
            menuItemScenario.setUserData(item.getName());
            menuScenario.getItems().add(menuItemScenario);
            menuItemScenario.setToggleGroup(groupScenarios);
            menuItemScenario.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println(menuItemScenario.getUserData());
                    
                    for (int i = 0; i<fichiers.length; i++){
                        String scenario = (String) vBoxSolution.getStackPaneSolution().getChildren().get(i).getUserData();
                        if (scenario.equals(menuItemScenario.getUserData())){
                            vBoxSolution.getStackPaneSolution().getChildren().get(i).toFront();
                            break;
                        }
                    }
                }
            });
        }
        ((RadioMenuItem)menuScenario.getItems().get(0)).setSelected(true);

        for (int i = 0; i<fichiers.length; i++){
            String scenario = (String) vBoxSolution.getStackPaneSolution().getChildren().get(i).getUserData();
            if (scenario.equals(menuScenario.getItems().get(0).getUserData())){
                vBoxSolution.getStackPaneSolution().getChildren().get(i).toFront();
                break;
            }
        }

        menuBar.getMenus().addAll( menuScenario, quitMenu);
        this.getChildren().addAll(menuBar,vBoxSolution);
    }
}
