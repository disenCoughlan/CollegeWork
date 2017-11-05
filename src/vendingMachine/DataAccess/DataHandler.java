package vendingMachine.DataAccess;

import vendingMachine.Models.Product;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.FileHandler;

public class DataHandler {
    private static String directory = System.getProperty("user.dir");
    private static BufferedReader reader;
    private static String productFileName = "Product.csv";
    private static final String pathname = directory + "\\" + productFileName;
    private static int ProductLocation = 0;
    private static int ProductName = 1;
    private static int ProductPrice = 2;

    public static ArrayList<Product> GetProductsFromFile() throws Exception {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(pathname);
        if(file.exists())
        {
            try{
                reader = new BufferedReader(new FileReader(pathname));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] product  = line.split(",");
                    products.add(new Product(
                            Integer.parseInt(product[ProductLocation]),
                            product[ProductName],
                            new BigDecimal(product[ProductPrice])));
                }
            } catch (Exception e) {
                throw new Exception("An issue occurred when reading data from product file." ,e);
            }
        }
        return products;
    }

    public static void WriteProductToFile(Product product) throws Exception {
        CreateFile(pathname);
        try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(pathname, true));
                writer.append(new String(product.getProductLocation() +
                        "," + product.getProductName() +
                        "," + product.getProductPrice()
                            + "\n"));
                writer.close();
        }
        catch (Exception e)
        {
            throw new Exception("Issue adding product to file");
        }
    }

    public static void RemoveProduct(Product product) throws Exception
    {
        StringBuilder fileContents = new StringBuilder();
        reader = new BufferedReader(new FileReader(pathname));
        String line;
        boolean hasBeenRemoved = false;
        while((line = reader.readLine()) != null){
            if(!line.startsWith(product.getProductLocation() + ",") || hasBeenRemoved)
                fileContents.append(line + "\n");
            else{
                hasBeenRemoved = true;
            }
        }

            File file = new File(pathname);
        file.delete();
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(pathname));
        writer.write(fileContents.toString());
        writer.close();
    }

    private static void CreateFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists())
            file.createNewFile();

    }
}
