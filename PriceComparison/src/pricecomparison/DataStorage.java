package pricecomparison;

/**
 * DataStorage --- program that gets product information from productData.txt
 * file
 *
 * @author Tam Nguyen
 */
public class DataStorage extends Database {

    ProductData pd = new ProductData();
    private String[] price;
    private String[] name;
    private String[] store;
    private String[][] prod = new String[21][3];

    /**
     * Gets product price from productData.txt
     *
     * @return price
     */
    public String[] getProductPrice() {
        String[] price = pd.getData(1, "productData.txt", ",");
        String[] newPrice = new String[21];
        for (int i = 0; i < price.length; i++) {
            newPrice = new String[i];
        }
        return price;
    }

    /**
     * Gets product name from productData.txt
     *
     * @return name
     */
    public String[] getProductName() {
        String[] name = pd.getData(0, "productData.txt", ",");
        String[] newName = new String[21];
        for (int j = 0; j < name.length; j++) {
            newName = new String[j];
        }
        return name;
    }

    /**
     * Gets product store from productData.txt
     *
     * @return store
     */
    public String[] getProductStore() {
        String[] store = pd.getData(2, "productData.txt", ",");
        String[] newStore = new String[21];
        for (int k = 0; k < store.length; k++) {
            newStore = new String[k];
        }
        return store;
    }
}
