package vendingMachine.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import vendingMachine.Managers.SceneManager;
import vendingMachine.Managers.VendingMachineManager;
import vendingMachine.Models.Product;

import java.util.ArrayList;

public class StockController {
    public Label validationErrorLabel;
    public Label SuccessNotification;
    public TextArea ProductList;

    @FXML
    protected void initialize() throws Exception {
        setProductList();
    }

    public void openVendingMachine(ActionEvent actionEvent) throws Exception
    {
        SceneManager.SwitchToScene("VendingMachine");
    }

    public void addProduct(ActionEvent actionEvent) throws Exception {
        SuccessNotification.setText("");
        validationErrorLabel.setText("");
        StringBuilder errorMessages = new StringBuilder();
        try {
            Product type = VendingMachineManager.GetProductType(Integer.parseInt(((Button)actionEvent.getSource()).getText()));
            VendingMachineManager.TryAddProduct(type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            errorMessages.append(e.getMessage() + "\n");
        }

        validationErrorLabel.setText(errorMessages.toString());
        if(errorMessages.toString() != null  || errorMessages.toString().length() > 0){
            SuccessNotification.setText("Product Added");
        }
        else {
            SuccessNotification.setText("Product Not Added");
        }
        setProductList();
        return;
    }


    //(^[0-9]?\.?[0-9]?[0-9]$) pattern for price
    public void setProductList() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Product> products = VendingMachineManager.TryGetProducts();
        for(Product product: products){
            stringBuilder.append(product.toString() + "\n");
        }
        ProductList.setText(stringBuilder.toString());
    }

    public void RemoveProduct(ActionEvent actionEvent) throws Exception {
        SuccessNotification.setText("");
        validationErrorLabel.setText("");
        StringBuilder errorMessages = new StringBuilder();
        try {
            Product type = VendingMachineManager.GetProductType(Integer.parseInt(((Button)actionEvent.getSource()).getText()));
            VendingMachineManager.TryRemoveProduct(type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            errorMessages.append(e.getMessage() + "\n");
        }

        validationErrorLabel.setText(errorMessages.toString());
        if(errorMessages.toString() != null  || errorMessages.toString().length() > 0){
            SuccessNotification.setText("Product Removed");
        }
        else {
            SuccessNotification.setText("Product Not Removed");
        }
        setProductList();
        return;
    }
}
