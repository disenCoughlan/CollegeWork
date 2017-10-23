package vendingMachine.Scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import vendingMachine.Controllers.VendingMachineController;
import vendingMachine.StartUp;

import java.io.IOException;

public class VendingMachineScene implements VScene {

    private String SceneName = "VendingMachine";

    private Parent root = FXMLLoader.load(getClass().getResource("../Views/VendingMachine.fxml"));
    private Scene Scene;
    public VendingMachineScene() throws IOException {
        Scene = new Scene(root);
    }

    public Scene GetScene(){
        return Scene;
    }

    @Override
    public String GetName() {
        return SceneName;
    }
}
