package vendingMachine.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import vendingMachine.Managers.SceneManager;

import java.io.IOException;

public class VendingMachineController{
    public Label selectionMessage;
    private String currentSelection = new String();


    public void openStockControl(ActionEvent actionEvent) throws Exception
    {
        SceneManager.SwitchToScene("Stock");
    }

    public void selectKey(ActionEvent actionEvent)
    {
        String value = ((Button) actionEvent.getSource()).getText();
        currentSelection = currentSelection + value;
        System.out.println(currentSelection);
    }

    public void clearSelection(ActionEvent actionEvent) {
        currentSelection = new String();
    }

    public void acceptSelection(ActionEvent actionEvent) {
        if(currentSelection.length() == 2)
            selectionMessage.setText("You have selected " + currentSelection + "It will cost " + 2.0f);
        else
            selectionMessage.setText("You have entered an incorrect value.");
    }

    public void selectCoinKey(ActionEvent actionEvent) {
    }
}
