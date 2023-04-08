package pricecomparison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProductData extends Database{
    public static String[] getData(int col,String filePath,String delimiter){
        String data[];
        String currentLine;
        ArrayList<String> colData = new ArrayList<String>();
        
        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            
            while((currentLine =br.readLine())!=null){
                data = currentLine.split(delimiter);
                colData.add(data[col]);
            }
        }
         catch(Exception e){
             System.out.print(e);
             return null;
         }       
        return colData.toArray(new String [0]);
    }
}
