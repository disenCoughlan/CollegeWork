package vendingMachine.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import vendingMachine.Managers.SceneManager;

import java.math.BigDecimal;

public class StockController {

    public Label listedItem0;
    public Label listedItem1;
    public Label balanceOfMachine;
    private BigDecimal bal = new  BigDecimal (0.00);

    public void openVendingMachine(ActionEvent actionEvent) throws Exception
    {
        SceneManager.SwitchToScene("VendingMachine");
    }

    public void listedItem(ActionEvent actionEvent) {
    }

    public void getBal(){
       String A = balanceOfMachine.getText();

    }
}
