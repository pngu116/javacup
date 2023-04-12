package pricecomparison;

/**
 * DataFulillment --- checks if user input is valid and creates a new list of
 * products.
 *
 * @author Phil Nguyen
 */
public class DataFulfillment extends Application {

    DataStorage ds = new DataStorage();
    public boolean found = false;
    private int count;
    private int pos;

    /**
     * Checks if user input is in the product list
     *
     * @param search A string containing user input
     */
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

    /**
     * Creates list of product the user requested
     *
     * @param search A string from checkValidity() containing user input
     * @return newList
     */
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
