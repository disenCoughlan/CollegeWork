package vendingMachine.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vendingMachine.Managers.SceneManager;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class StockController {


    public TextField productLocationField;
    public TextField productNameField;
    public TextField productPriceField;
    public Label validationErrorLabel;
    public Label SuccessNotification;

    public void openVendingMachine(ActionEvent actionEvent) throws Exception
    {
        SceneManager.SwitchToScene("VendingMachine");
    }

    public void addProduct(ActionEvent actionEvent) {
        SuccessNotification.setText("");
        validationErrorLabel.setText("");
        StringBuilder errorMessages = new StringBuilder();
        try {
            int productLocation = getProductLocation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            errorMessages.append(e.getMessage() + "\n");
        }
        String productName = "";
        BigDecimal productPrice;

        validationErrorLabel.setText(errorMessages.toString());
        if(errorMessages.toString() != null  || errorMessages.toString().length() > 0)
            SuccessNotification.setText("Product Added");
    }

    public int getProductLocation() throws Exception {
        if(productLocationField.getText() != null && productLocationField.getText() != "" && productLocationField.getText().length() == 2 )
        {
            try{
                boolean hasMatch = Pattern.matches("^[0-4][0-2]$", productLocationField.getText());
                if(hasMatch )
                    return Integer.parseInt(productLocationField.getText());
            }catch (Exception e){
                throw new Exception("Product location is not valid number");
            }
        }
        throw new Exception("Product location is not valid");
    }
    //(^[0-9]?\.?[0-9]?[0-9]$) pattern for price
}
