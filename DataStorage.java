/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datastorage;

import java.io.*;
import java.util.*;

/**
 *
 * @author tambl
 */
public class DataStorage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[]data = read(0,"C:\\Users\\tambl\\Desktop\\productData.txt",",");
        for(int i =0; i<data.length;i++){
            System.out.println(data[i]);
        }
    }
    public static String[] read(int col,String filePath,String delimiter){
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
