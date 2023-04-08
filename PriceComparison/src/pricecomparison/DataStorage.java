package pricecomparison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DataStorage extends ProductData{
    private String[] price;
    private String[] name;
    private String[] store;
    private String[][] prod = new String[21][3];
    public String[] getProductPrice() {
        String[]price = getData(1,"productData.txt",",");
        for(int i =0; i<price.length;i++){
            prod = new String[i][1];
        }
        return price;
    }
    
    public String[] getProductName() {
        String[]name = getData(0,"productData.txt",",");
        for(int j =0; j<name.length;j++){
            prod = new String[j][0];
        }
        return name;
    }
    
    public String[] getProductStore() {
        String[]store = getData(2,"productData.txt",",");
        for(int k =0; k<store.length;k++){
            prod = new String[k][2];
        }
        return store;
    }
    

    
    
}
