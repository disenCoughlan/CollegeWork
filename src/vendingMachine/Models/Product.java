package vendingMachine.Models;

import java.math.BigDecimal;

public class Product {
    private int ProductId;
    private String ProductName;
    private BigDecimal ProductPrice;

    public Product(int productId, String productName, BigDecimal productPrice){
        ProductId = productId;
        ProductName = productName;
        ProductPrice = productPrice;
    }

    public int getProductId() {
        return ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public BigDecimal getProductPrice() {
        return ProductPrice;
    }

    @Override
    public String toString() {
        return new String("Product Id: " + getProductName() +
                          ", Product Name: " + getProductName() +
                          ", Product Price: " + getProductPrice());
    }
}
