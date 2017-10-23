package vendingMachine;

import javafx.application.Application;
import javafx.stage.Stage;
import vendingMachine.Managers.SceneManager;

public class StartUp extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager.initSceneManager(primaryStage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
