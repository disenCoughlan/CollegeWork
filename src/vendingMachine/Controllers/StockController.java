package vendingMachine.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    public ListView productList;
    private ListView<String>listView;

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
        try {
            String productName = getProductName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            errorMessages.append(e.getMessage()+ "\n");
        }
        try {
            BigDecimal productPrice = getProductPrice();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            errorMessages.append(e.getMessage()+ "\n");
        }

        validationErrorLabel.setText(errorMessages.toString());
        if(errorMessages.toString() != null  || errorMessages.toString().length() > 0){
            SuccessNotification.setText("Product Added");
        }
            else {
            SuccessNotification.setText("Product Not Added");
        }
            return;
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
    public String getProductName () throws Exception{
        if (productNameField.getText()!= null && productNameField.getText()!="")
        {
            try {
                boolean hasMatch = Pattern.matches("[a-z,A-Z,]", productNameField.getText());
                if (hasMatch)
                    return new String(productNameField.getText());
            }catch (Exception e){
                    throw new Exception("Name is not valid");
                }
            }
            throw new Exception("Product name is not valid");
        }
    //(^[0-9]?\.?[0-9]?[0-9]$) pattern for price
    public BigDecimal getProductPrice() throws Exception{
        if (productPriceField.getText()!= null && productPriceField.getText() != "")
        {
         try {
             boolean hasMatch = Pattern.matches("^[0-9]?\\.?[0-9]?[0-9]$",productPriceField.getText());
             if (hasMatch)
                 return BigDecimal.valueOf(Double.parseDouble(productPriceField.getText()));
         }catch (Exception e){
             throw new Exception("not a valid price");
         }
        }
        throw new Exception("Product price is not valid");
    }
    public void setProductList(){
        ObservableList<String> items =listView.getItems();
        //items.add ();
    }
}
