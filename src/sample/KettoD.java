package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KettoD extends Application {


    private Canvas canvas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Kettoe DD");
        Group root = new Group();
        canvas = new Canvas(800, 600);
        reset(canvas, Color.DARKSEAGREEN);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.GREEN);
        gc.fillOval(canvas.getWidth()/2, canvas.getHeight()/2, 50, 100);

        gc.setFill(Color.BLACK);
        gc.fillOval(canvas.getWidth()/2, canvas.getHeight()/2, 5, 5);


        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                e -> {
                    if (e.isPrimaryButtonDown()) {
                        gc.setFill(toMyIntColor(e.getX(), e.getY()));
                        gc.fillOval(e.getX(), e.getY(), e.getX()/canvas.getWidth() * 100, e.getY()/canvas.getHeight() * 100);

                    } else if (e.isMiddleButtonDown()) {

                        gc.applyEffect(new Lighting());

                    } else if (e.isSecondaryButtonDown()) {

                        reset(canvas, toMyIntColor(e.getX(), e.getY()));
                    }

                }
        );

//        gc.setFill(Color.GREEN);
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
//        gc.strokeLine(40, 10, 10, 40);
//        gc.fillOval(10, 60, 30, 30);
//        gc.strokeOval(60, 60, 30, 30);
//        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
//        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
//        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
//        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
//        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
//        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
//        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
//        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
//        gc.fillPolygon(new double[]{10, 40, 10, 40},
//                new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolygon(new double[]{60, 90, 60, 90},
//                new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolyline(new double[]{110, 140, 110, 140},
//                new double[]{210, 210, 240, 240}, 4);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    private Color toMyIntColor(double x, double y) {
        int xr = (int)x;
        int yg = (int)y;


        xr = (int)(x/canvas.getWidth()  * 255);
        yg = (int)(y/canvas.getHeight() * 255);


        return Color.rgb(xr, yg, 100);
    }

    private void reset(Canvas canvas, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}
