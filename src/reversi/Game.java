package reversi;

import javafx.application.Application;
import javafx.stage.Stage;
import reversi.control.Controller;

public class Game extends Application {


    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Controller
                .createGame(primaryStage)
                .start();

    }

}
