package vendingMachine.Managers;

import org.jetbrains.annotations.Nullable;
import vendingMachine.DataAccess.DataHandler;
import vendingMachine.Models.Product;
import vendingMachine.Models.ProductType;
import vendingMachine.Models.VendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VendingMachineManager {
    private static VendingMachine VendingMachine ;

    public static void initVendingMachine() throws Exception {
        VendingMachine = new VendingMachine(new BigDecimal(100.00), DataHandler.GetProductsFromFile());
    }

    @Nullable
    public static Product TryPurchaseProduct(int productId, BigDecimal currentInsertedAmount) throws Exception {
        Product product = VendingMachine.getProducts()
                .stream()
                .filter(x -> x.getProductLocation() == productId)
                .findFirst()
                .orElse(null);

        if(product == null || product.getProductPrice().doubleValue() > currentInsertedAmount.doubleValue())
            return null;

        VendingMachine.RemoveProduct(product);
        return product;
    }

    public static void TryAddProduct(ProductType product) throws Exception {
        VendingMachine.AddProduct(product);
    }

    public static ArrayList<Product> TryGetProducts()throws Exception{
        return VendingMachine.getProducts();
    }

    public static ProductType GetProductType(String Identifier){
        return VendingMachine.GetProductType(Identifier);
    }
}
