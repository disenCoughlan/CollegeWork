package vendingMachine.Controllers;

import javafx.event.ActionEvent;
import vendingMachine.Managers.SceneManager;

public class StockController {

    public void openVendingMachine(ActionEvent actionEvent) throws Exception
    {
        SceneManager.SwitchToScene("VendingMachine");
    }
}
