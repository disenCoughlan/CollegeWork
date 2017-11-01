package vendingMachine.Models;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachine {
    private BigDecimal VendingMachineBalance;
    private List<Product> Products;

    public VendingMachine(BigDecimal vendingMachineBalance, List<Product> products){

        VendingMachineBalance = vendingMachineBalance;
        Products = products;
    }

    public BigDecimal getVendingMachineBalance() {
        return VendingMachineBalance;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void RemoveProduct(Product product){
        Products.remove(product);
    }
}
