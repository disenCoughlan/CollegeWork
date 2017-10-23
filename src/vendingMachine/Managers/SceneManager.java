package vendingMachine.Managers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import vendingMachine.Scenes.StockScene;
import vendingMachine.Scenes.VScene;
import vendingMachine.Scenes.VendingMachineScene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneManager {

    public static Stage VendingMachineStage;
    private static List<VScene> Scenes = new ArrayList<VScene>(){{
        try {
            add(new StockScene());
            add(new VendingMachineScene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }};

    public static void initSceneManager (Stage stage) throws IOException {
        VendingMachineStage = stage;
        SwitchToScene("Stock");
        VendingMachineStage.show();
    }

    public static void SwitchToScene(String name) throws IOException {
        VScene desiredScene = Scenes.stream().filter(x -> x.GetName() == name).findFirst().orElse(new VendingMachineScene());
        VendingMachineStage.setScene(desiredScene.GetScene());
        VendingMachineStage.setTitle(desiredScene.GetName());
    }
}
