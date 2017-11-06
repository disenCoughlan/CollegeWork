package vendingMachine.Models;

import vendingMachine.DataAccess.Readers.ProductReader;
import vendingMachine.DataAccess.Writers.ProductWriter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class VendingMachine {
    private BigDecimal VendingMachineBalance;
    private ArrayList<Product> Products;


    private ArrayList<ProductType> ProductTypes;

    public VendingMachine(BigDecimal vendingMachineBalance, ArrayList<Product> products){

        VendingMachineBalance = vendingMachineBalance;
        Products = products;
        ProductTypes = new ArrayList<ProductType>();
            ProductTypes.add(new ProductType("11", "Walkers cheese & onion", "1.50"));
            ProductTypes.add(new ProductType("12", "Walkers cheese & onion", "1.50"));
            ProductTypes.add(new ProductType("13", "Walkers ready salted", "1.50"));
            ProductTypes.add(new ProductType("14", "Walkers ready salted", "1.50"));
            ProductTypes.add(new ProductType("21", "McCoys flame grilled stake", "1.50"));
            ProductTypes.add(new ProductType("22", "McCoys salt & malt vingar", "1.50"));
            ProductTypes.add(new ProductType("23", "McCoys cheddar & onion", "1.50"));
            ProductTypes.add(new ProductType("24", "Quavers", "1.50"));
            ProductTypes.add(new ProductType("31", "M&M", "1.00"));
            ProductTypes.add(new ProductType("32", "Minstrels", "1.00"));
            ProductTypes.add(new ProductType("33", "Maltesers", "1.00"));
            ProductTypes.add(new ProductType("34", "double decker", "1.00"));
            ProductTypes.add(new ProductType("35", "Kit Kat", "1.00"));
            ProductTypes.add(new ProductType("36", "Boost", "1.00"));
            ProductTypes.add(new ProductType("37", "Twirl", "1.00"));
            ProductTypes.add(new ProductType("38", "Wispa", "1.00"));
            ProductTypes.add(new ProductType("41", "Pasta", "3.00"));
            ProductTypes.add(new ProductType("42", "Ham and cheese", "2.00"));
            ProductTypes.add(new ProductType("43", "Double cheese and onion", "2.00"));
            ProductTypes.add(new ProductType("51", "Water", "1.00"));
            ProductTypes.add(new ProductType("52", "Lucozade", "1.50"));
            ProductTypes.add(new ProductType("53", "Engery drink", "1.50"));
            ProductTypes.add(new ProductType("54", "Ribena", "1.50"));
            ProductTypes.add(new ProductType("55", "Tropicana", "1.50"));
            ProductTypes.add(new ProductType("56", "Coke botle", "1.50"));
            ProductTypes.add(new ProductType("61", "Redbull", "2.00"));
            ProductTypes.add(new ProductType("62", "Sprite", "1.00"));
            ProductTypes.add(new ProductType("63", "Fanta", "1.00"));
            ProductTypes.add(new ProductType("64", "Coke can", "1.00"));

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

    public void AddProduct (ProductType productType)throws Exception{

        Product product = new Product(Integer.parseInt(productType.getProductLocation()), productType.getProductName(), new BigDecimal(productType.getProductPrice()));
        ProductWriter.AddProduct(product);
        Products = ProductReader.LoadProducts();
    }

    public ArrayList<ProductType> GetProductTypes(){
        return ProductTypes;
    }

    public ProductType GetProductType(String identifier){
        Stream<ProductType> stream = ProductTypes
                .stream()
                .filter(x -> x.getProductLocation().compareTo(identifier) == 0);
        return stream.findFirst().orElse(null);

    }
}
