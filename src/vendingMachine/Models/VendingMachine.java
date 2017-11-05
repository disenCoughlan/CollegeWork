package vendingMachine.Models;

import vendingMachine.DataAccess.Readers.ProductReader;
import vendingMachine.DataAccess.Writers.ProductWriter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private BigDecimal VendingMachineBalance;
    private ArrayList<Product> Products;

    public VendingMachine(BigDecimal vendingMachineBalance, ArrayList<Product> products){

        VendingMachineBalance = vendingMachineBalance;
        Products = products;
    }

    public BigDecimal getVendingMachineBalance() {
        return VendingMachineBalance;
    }

    public ArrayList<Product> getProducts() throws Exception {
        Products = ProductReader.LoadProducts();
        return Products;
    }

    public void RemoveProduct(Product product) throws Exception {
        ProductWriter.RemoveProduct(product);
        Products = ProductReader.LoadProducts();
    }

    public void AddProduct (Product product)throws Exception{
        ProductWriter.AddProduct(product);
        Products = ProductReader.LoadProducts();
    }
}
