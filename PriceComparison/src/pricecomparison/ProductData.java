package pricecomparison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * ProductData --- program to read the ProductData.txt file.
 *
 * @author Khoi Tran
 */
public class ProductData extends Database {

    //gets column of data from txt file and sends to DataStorage
    /**
     * Gets column of data from ProductData.txt file and sends to DataStorage
     *
     * @param col
     * @param filePath
     * @param delimiter
     * @return colData.toArray(new String[0])
     */
    public static String[] getData(int col, String filePath, String delimiter) {
        String data[];
        String currentLine;
        ArrayList<String> colData = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(delimiter);
                colData.add(data[col]);
            }
        } catch (Exception e) {
            System.out.print(e);
            return null;
        }
        return colData.toArray(new String[0]);
    }
}
