package vue;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasSolution extends Canvas {
    
    public CanvasSolution(int parHeight, int parWidth) {
        super(parWidth, parHeight);
        draw();
    }

    private void draw() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(20, 0, 880, 490);

        gc.setFill(Color.WHITE);
        gc.fillRect(25, 5, 870, 420);

        int [] origine = {19, 419};

        gc.setFill(Color.RED);
        gc.fillOval(origine[0], origine[1], 12, 12);

        // gc.setFill(Color.GREEN);
        // gc.fillOval(50, 50, 100, 100);
    }
}
