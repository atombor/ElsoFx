package reversi.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Table {

    private Canvas canvas;
    private int rows;
    private int columns;
    private double boxWidth;
    private double boxHeight;


    public static Table createTable() {
        Table table = new Table();
        return table;
    }

    public Table init(Canvas canvas, int rows, int columns) {
        this.canvas = canvas;
        this.rows = rows;
        this.columns = columns;

        return this;
    }

    public double getBoxWidth() {
        return boxWidth;
    }

    public double getBoxHeight() {
        return boxHeight;
    }

    public int getColumns() {
        return columns;
    }

    public Table reset(Canvas canvas) {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        initBorders();

        return this;
    }

    private void initBorders() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);

        boxWidth = canvas.getWidth() / columns;
        for (double actX = boxWidth; actX < canvas.getWidth(); actX += boxWidth) {
            gc.strokeLine(actX, 0, actX, canvas.getHeight());
        }

        boxHeight = canvas.getHeight() / rows;
        for (double actY = boxHeight; actY < canvas.getWidth(); actY += boxHeight) {
            gc.strokeLine(0, actY, canvas.getWidth(), actY);
        }
    }
}
