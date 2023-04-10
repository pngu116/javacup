package pricecomparison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//gets product information from txt file
public class DataStorage extends Database{
    ProductData pd = new ProductData();
    public String[] price;
    public String[] name;
    public String[] store;
    private String[][] prod = new String[21][3];
    
    // getProductPrice() gets product price from productData.txt
    public String[] getProductPrice() {
        String[]price = pd.getData(1,"productData.txt",",");
        String[]newPrice = new String[21];
        for(int i =0; i<price.length;i++){
            newPrice = new String[i];
        }
        return price;
    }
    
    // getProductName() gets product name from productData.txt
    public String[] getProductName() {
        String[]name = pd.getData(0,"productData.txt",",");
        String[]newName = new String[21];
        for(int j =0; j<name.length;j++){
            newName = new String[j];
        }
        return name;
    }
    
    // getProductStore() gets product store from productData.txt
    public String[] getProductStore() {
        String[]store = pd.getData(2,"productData.txt",",");
        String[]newStore = new String[21];
        for(int k =0; k<store.length;k++){
            newStore = new String[k];
        }
        return store;
    }
    

    
    
}