package pricecomparison;

import java.util.Arrays;
import java.util.List;
//checks if user input is valid and creates newlist of products 
public class DataFulfillment extends Application{
    public boolean found = false;
    DataStorage ds = new DataStorage();
    int count;
    int pos;

    public String getRequest() {

        return null;
    }
    //check if user input is in product list
    public void checkValidity(String search) {
        String[] productNames = ds.getProductName();
        String[] productPrices = ds.getProductPrice();
        String[] productStore = ds.getProductStore();
        for (int i = 0; i < productNames.length; i++) {
            if (productNames[i].toLowerCase().contains(search.toLowerCase())) {
                found = true;
                count++;
                pos = i;
            }
        }

        if (found) {
            makeList(search);
        }

    }
    //creates list of product the user requested
    public String[][] makeList(String search) {
        String[] productNames = ds.getProductName();
        String[] productPrices = ds.getProductPrice();
        String[] productStore = ds.getProductStore();

        String[][] newList = new String[count][count];

        newList[0][0] = productNames[pos];
        newList[0][1] = productPrices[pos];
        newList[0][2] = productStore[pos];

        newList[1][0] = productNames[pos - 1];
        newList[1][1] = productPrices[pos - 1];
        newList[1][2] = productStore[pos - 1];

        newList[2][0] = productNames[pos - 2];
        newList[2][1] = productPrices[pos - 2];
        newList[2][2] = productStore[pos - 2];

        newList[3][0] = productNames[pos - 3];
        newList[3][1] = productPrices[pos - 3];
        newList[3][2] = productStore[pos - 3];

        return newList;
    }
}
