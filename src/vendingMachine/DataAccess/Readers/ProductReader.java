package vendingMachine.DataAccess.Readers;

import vendingMachine.Models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
//This class should read from csv file in a certain format
public class ProductReader {


    public ArrayList<Product> LoadProducts(){//where does you enter the list?
        return new ArrayList<Product>(){{
            new Product(00, "Tayto Original", new BigDecimal(0.5));
            new Product(00, "Tayto Original", new BigDecimal(0.5));
            new Product(00, "Tayto Original", new BigDecimal(0.5));
            new Product(00, "Tayto Original", new BigDecimal(0.5));
            new Product(01, "Tayto Salt & Vinegar", new BigDecimal(0.5));
            new Product(01, "Tayto Salt & Vinegar", new BigDecimal(0.5));
            new Product(01, "Tayto Salt & Vinegar", new BigDecimal(0.5));
            new Product(01, "Tayto Salt & Vinegar", new BigDecimal(0.5));
            new Product(02, "Tayto Smoky Bacon", new BigDecimal(0.5));
            new Product(02, "Tayto Smoky Bacon", new BigDecimal(0.5));
            new Product(02, "Tayto Smoky Bacon", new BigDecimal(0.5));
            new Product(02, "Tayto Smoky Bacon", new BigDecimal(0.5));
            new Product(02, "Tayto Smoky Bacon", new BigDecimal(0.5));
            new Product(02, "Tayto Smoky Bacon", new BigDecimal(0.5));
            new Product(02, "Tayto Smoky Bacon", new BigDecimal(0.5));
            new Product(02, "Tayto Smoky Bacon", new BigDecimal(0.5));
            new Product(10, "Mars", new BigDecimal(1.0));
            new Product(10, "Mars", new BigDecimal(1.0));
            new Product(10, "Mars", new BigDecimal(1.0));
            new Product(10, "Mars", new BigDecimal(1.0));
            new Product(10, "Mars", new BigDecimal(1.0));
            new Product(11, "Kit Kat", new BigDecimal(1.0));
            new Product(12, "Kit Kat", new BigDecimal(1.0));
            new Product(12, "Kit Kat", new BigDecimal(1.0));
            new Product(12, "Kit Kat", new BigDecimal(1.0));
            new Product(12, "Kit Kat", new BigDecimal(1.0));
            new Product(12, "Kit Kat", new BigDecimal(1.0));
        }};

    }
}
