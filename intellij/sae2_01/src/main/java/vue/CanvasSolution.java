package vue;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.Quete;
import modele.Scenario;

public class CanvasSolution extends Canvas {
    Scenario scenario;
    
    public CanvasSolution(int parHeight, int parWidth, Scenario parScenario) {
        super(parWidth, parHeight);
        draw(parScenario);
    }

    private void draw(Scenario parScenario) {
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(20, 0, 880, 490);

        gc.setFill(Color.WHITE);
        gc.fillRect(25, 5, 870, 420);

        int [] origine = {25, 5};

        gc.setFill(Color.RED);
        gc.fillOval(origine[0], origine[1], 12, 12);
        
        int[] dimensionsMax = parScenario.dimensionsMax();

        double echelleX = 858 / dimensionsMax[0];
        double echelleY = 408 / dimensionsMax[1];

        for (Quete quete : parScenario.getListeQuetes()){
            int[] pos = quete.getPos();
            gc.setFill(Color.BLUE);
            gc.fillOval(origine[0] + (pos[0] * echelleX), origine[1] + (pos[1] * echelleY), 12, 12);
            gc.strokeText(String.valueOf(quete.getNumero()), origine[0] + (pos[0] * echelleX) + 1, (pos[1] * echelleY));
        }
    }
}
