package vue;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Classe SaeApplication qui permet de lancer l'application
 * Hérite de la classe Application
 */
public class SaeApplication extends Application {
    
    /**
     * Méthode start de la classe SaeApplication qui permet de lancer l'application
     */
    public void start(Stage stage) {
        VBox root = new VBox();
        Scene scene = new Scene(root, 1000, 500);
        File css = new File("css" + File.separator + "sae.css");
        scene.getStylesheets().add(css.toURI().toString());

        stage.setScene(scene);
        stage.setTitle("Saé 2.01.02 - Comparaison algorithmique");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Méthode main de la classe SaeApplication qui permet de lancer l'application
     */
    public static void main(String [] args) {
        Application.launch(args);
    }
}