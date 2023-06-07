package vue;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import modele.Joueur;
import modele.Quete;
import modele.Scenario;

public class CanvasSolution extends Canvas {
    
    public CanvasSolution(int parHeight, int parWidth) {
        super(parWidth, parHeight);
    }

    public void draw(Scenario parScenario, Joueur parJoueur) throws InterruptedException {
        GraphicsContext gc = getGraphicsContext2D();
        ArrayList<Quete> parcours = parJoueur.getParcoursQuete();

        gc.clearRect(0, 0, this.getWidth(), this.getHeight());

        gc.setFill(Color.BLACK);
        gc.fillRect(20, 0, 880, 490);

        gc.setFill(Color.WHITE);
        gc.fillRect(25, 5, 870, 420);

        final int [] origine = {25, 5};

        gc.setFill(Color.RED);
        gc.fillOval(origine[0], origine[1], 12, 12);
        
        int[] dimensionsMax = parScenario.dimensionsMax();

        double echelleX = 858 / dimensionsMax[0];
        double echelleY = 408 / dimensionsMax[1];

        for (Quete quete : parScenario.getListeQuetes()){
            int[] pos = quete.getPos();
            gc.setFill(Color.BLUE);
            gc.fillOval(origine[0] + (pos[0] * echelleX), origine[1] + (pos[1] * echelleY), 12, 12);
            gc.setStroke(Color.BLACK);
            gc.strokeText(String.valueOf(quete.getNumero()), origine[0] + (pos[0] * echelleX) + 1, (pos[1] * echelleY));
        }


        Timeline timeline = new Timeline();
        int[] oldPos = {origine[0], origine[1]};

        for (int i = 0; i < parcours.size(); i++){
            int[] pos = parcours.get(i).getPos();

            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i + 1), event ->{
            gc.setStroke(Color.GREEN);
            gc.strokeLine(oldPos[0] + 6, oldPos[1] + 6, origine[0] + (pos[0] * echelleX) + 6, origine[1] + (pos[1] * echelleY) + 6);
            gc.setFill(Color.GREEN);
            gc.fillOval(origine[0] + (pos[0] * echelleX), origine[1] + (pos[1] * echelleY), 12, 12);
            oldPos[0] = origine[0] + (pos[0] * (int) echelleX);
            oldPos[1] = origine[1] + (pos[1] * (int) echelleY);
            });
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }
}
