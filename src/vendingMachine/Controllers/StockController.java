package vendingMachine.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import vendingMachine.Managers.SceneManager;
import vendingMachine.Managers.VendingMachineManager;
import vendingMachine.Models.Product;
import vendingMachine.Models.ProductType;
import vendingMachine.Models.VendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
            ProductType type = VendingMachineManager.GetProductType(((Button)actionEvent.getSource()).getText());
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
}
