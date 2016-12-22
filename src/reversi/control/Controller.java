package reversi.control;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import reversi.view.Table;

public class Controller {

    private static Stage primaryStage;
    private final int DEFAULT_TABLE_WIDTH = 5;
    private final int DEFAULT_TABLE_HEIGHT = DEFAULT_TABLE_WIDTH;

    private Controller() {}

    public static Controller createGame(Stage primaryStage) {
        Controller.primaryStage = primaryStage;
        return new Controller();
    }

    public Controller start() {

        Group root = new Group();
        Canvas canvas = new Canvas(400, 400);

        Table table = Table
                .createTable()
                .init(canvas, DEFAULT_TABLE_WIDTH, DEFAULT_TABLE_HEIGHT)
                .reset(canvas);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        return this;
    }


}
