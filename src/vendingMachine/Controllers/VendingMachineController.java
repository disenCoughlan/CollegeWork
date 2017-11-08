package vendingMachine.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import vendingMachine.Managers.SceneManager;
import vendingMachine.Models.Product;
import vendingMachine.Models.VendingMachine;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

import static vendingMachine.Managers.VendingMachineManager.TryPurchaseProduct;
import static vendingMachine.Managers.VendingMachineManager.initVendingMachine;

public class VendingMachineController{
    public Label selectionMessage;
    public Label amountInsertedLabel;
    public Label selectedProductCode;
    public Label image;
    private String currentSelection = new String();
    public BigDecimal ammountInserted = new BigDecimal(0.00);

    public void openStockControl(ActionEvent actionEvent) throws Exception
    {
        SceneManager.SwitchToScene("Stock");
    }

    public void selectKey(ActionEvent actionEvent)
    {
        if(currentSelection.length() < 2){
            String value = ((Button) actionEvent.getSource()).getText();
            currentSelection = currentSelection + value;
            selectedProductCode.setText(currentSelection);
        }
    }

    public void clearSelection(ActionEvent actionEvent) {
        currentSelection = new String();
        selectedProductCode.setText("");
    }

    public void acceptSelection(ActionEvent actionEvent) {//this is doing nothing but write ramdom text !!
        if(currentSelection.length() == 2 && currentSelection.equals(11))
            //VendingMachine.getProducts();this bit i found realy hard to do :(
        selectionMessage.setText("Enjoy your "+ currentSelection);
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
                break;//do we need a default rout?
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

    public void openStock(ActionEvent actionEvent) throws Exception {
        SceneManager.SwitchToScene("Stock");
    }


}
