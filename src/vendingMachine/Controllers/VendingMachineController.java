package vendingMachine.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import vendingMachine.Managers.SceneManager;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

public class VendingMachineController{
    public Label selectionMessage;
    public Label amountInsertedLabel;
    private String currentSelection = new String();
    private BigDecimal ammountInserted = new BigDecimal(0.00);

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
        String value = ((Button) actionEvent.getSource()).getText();
        System.out.println(value);
        switch (value){
            case "5c":
                ammountInserted = ammountInserted.add(new BigDecimal(0.05d));
                break;
            case "10c":
                ammountInserted = ammountInserted.add(new BigDecimal(0.10d));
                break;
            case "20c":
                ammountInserted = ammountInserted.add(new BigDecimal(0.20d));
                break;
            case "50c":
                ammountInserted = ammountInserted.add(new BigDecimal(0.50d));
                break;
            case "1E":
                ammountInserted = ammountInserted.add(new BigDecimal(1.00d));
                break;
            case "2E":
                ammountInserted = ammountInserted.add(new BigDecimal(2.00d));
                break;
        }
        DisplayAmountInserted();
    }

    public void returnMoney(ActionEvent actionEvent) {
        ammountInserted = new BigDecimal(0);
        DisplayAmountInserted();
    }

    private void DisplayAmountInserted(){
        ammountInserted = ammountInserted.setScale(2,BigDecimal.ROUND_DOWN);
        amountInsertedLabel.setText(ammountInserted + "E");
    }
}
