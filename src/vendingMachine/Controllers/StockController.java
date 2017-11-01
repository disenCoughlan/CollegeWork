package vendingMachine.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import vendingMachine.Managers.SceneManager;

public class StockController {

    public Label listedItem0;
    public Label listedItem1;

    public void openVendingMachine(ActionEvent actionEvent) throws Exception
    {
        SceneManager.SwitchToScene("VendingMachine");
    }

    public void listedItem(ActionEvent actionEvent) {
    }
}
