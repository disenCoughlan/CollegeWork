package vendingMachine.Scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import vendingMachine.Controllers.StockController;

import java.io.IOException;

public class StockScene implements IScene {

    private String SceneName = "Stock";
    private Parent root = FXMLLoader.load(getClass().getResource("../Views/Stock.fxml"));
    private Scene Scene;
    private StockController stockController = new StockController();

    public StockScene() throws IOException {
        Scene = new Scene(root);
    }

    public Scene GetScene()
    {
        return Scene;
    }

    @Override
    public String GetName() {
        return SceneName;
    }
}
