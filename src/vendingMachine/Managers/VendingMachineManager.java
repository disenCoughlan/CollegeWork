package vendingMachine.Managers;

import org.jetbrains.annotations.Nullable;
import vendingMachine.Models.Product;
import vendingMachine.Models.VendingMachine;

import java.math.BigDecimal;

public class VendingMachineManager {
    private static VendingMachine VendingMachine;

    public static void initVendingMachine(){
    }

    @Nullable
    public static Product TryPurchaseProduct(int productId, BigDecimal currentInsertedAmount)
    {
        Product product = VendingMachine.getProducts()
                .stream()
                .filter(x -> x.getProductId() == productId)
                .findFirst()
                .orElse(null);

        if(product == null || product.getProductPrice().doubleValue() > currentInsertedAmount.doubleValue())
            return null;

        VendingMachine.RemoveProduct(product);
        return product;
    }
}
