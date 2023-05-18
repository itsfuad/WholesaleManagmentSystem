package Database;

import java.io.*;
import java.util.*;

import Types.*;

public class Database {
    private String filename;
    private ArrayList<String> data;

    public Database(String filename) {
        this.filename = "Database\\" + filename;
        this.data = new ArrayList<String>();
    }

    public void read() {
        try {
            // if file doesn't exist, create it
            File file = new File(this.filename);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            String line = br.readLine();
            while (line != null) {
                // check if data exists in list
                if (!this.data.contains(line)) {
                    this.data.add(line);
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file" + e.toString());
        }
    }

    public void write() {
        try {
            // if file doesn't exist, create it
            File file = new File(this.filename);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename));
            for (String line : this.data) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public void add(String line) {
        if (!this.data.contains(line)) {
            this.data.clear();
            read();
            this.data.add(line);
            write();
        }
    }

    public void remove(String line) {
        read();
        if (this.data.contains(line)) {
            this.data.clear();
            this.data.remove(line);
            write();
        }
    }

    public void removeProduct(String productId) {
        read();
        for (String line : this.data) {
            if (line.contains(productId)) {
                this.data.remove(line);
                break;
            }
        }
        write();
    }

    public void clear() {
        this.data.clear();
        // clear file
        write();
    }

    public void print() {
        read();
        for (String line : this.data) {
            System.out.println(line);
        }
    }

    public ArrayList<String> getData() {
        read();
        return this.data;
    }

    public String get() {
        read();
        if (this.data.size() > 0) {
            return this.data.get(0);
        } else {
            return "";
        }
    }


    public ArrayList<String> getProdsName() {
        read();
        ArrayList<String> temp = new ArrayList<String>();
        for (String _data : this.data) {
            temp.add(_data.split(",")[1].split("=")[1]);
        }

        return temp;
    }

    public ArrayList<Product> getAllProducts() {
        read();
        ArrayList<Product> products = new ArrayList<Product>();
        for (String line : this.data) {
            String[] parts = line.split(",");
            String id = parts[0];
            String name = parts[1];
            String manufacturer = parts[4];
            String price = parts[3];
            String manufactureDate = parts[5];
            String expiryDate = parts[6];

            System.out.println("Product manufacturer: " + manufacturer);

            Product prod = new Product(id.split("=")[1], name.split("=")[1], price.split("=")[1], manufacturer.split("=")[1], manufactureDate.split("=")[1], expiryDate.split("=")[1]);
            products.add(prod);
        }

        System.out.println("Size: " + products.size());

        return products;
    }

    /**
     * Updates the cart
     * @param cartItems
     */
    public void updateCart(ArrayList<Product> cartItems) {
        this.data.clear();
        for (Product item : cartItems) {
            String line = "id=" + item.productID + ",name=" + item.productName + ",price=" + item.productPrice +
                    ",quantity=" + item.productQuantity + ",manufacturingDate=" + item.manufacturingDate +
                    ",expiryDate=" + item.expiryDate;
            this.data.add(line);
        }
        write();
    }

    /**
     * Returns the cart items
     * @return
     */
    public ArrayList<Product> getCart(){
        read();
        ArrayList<Product> products = new ArrayList<Product>();

        for (String line : this.data) {
            String[] parts = line.split(",");
            String id = parts[0];
            String name = parts[1];
            String price = parts[2];
            String quantity = parts[3];
            String manufactureDate = parts[4];
            String expiryDate = parts[5];

            //System.out.println("Product name: " + nameParts[1]);

            Product prod = new Product(id.split("=")[1], name.split("=")[1], price.split("=")[1], quantity.split("=")[1], manufactureDate.split("=")[1], expiryDate.split("=")[1]);
            products.add(prod);
        }

        return products;
    }

    /**
     * Returns true if the line exists in the database
     *
     * @param line The line to check
     * @return true or false
     */
    public boolean contains(String line) {
        read();
        return this.data.contains(line);
    }


    /**
     * Returns true if the database is empty
     * @return
     */
    public boolean isEmpty() {
        read();
        return this.data.isEmpty();
    }

    /**
     * Matches all the queries and returns true if all queries are true.
     * Example,
     * match("username=user1,address=dhaka") returns true if both values are present
     * in the database
     *
     * @param Query The Query string
     * @return true or false
     */
    public boolean match(String query) {
        read();

        String[] queries = query.split(",");

        final int yetToMatch = queries.length;

        for (int i = 0; i < data.size(); i++) {
            int matched = 0;
            String[] queryStrings = data.get(i).split(",");
            for (int j = 0; j < queries.length; j++) {
                for (int k = 0; k < queryStrings.length; k++) {
                    // System.out.println(queryStrings[k] + " = " + queries[j] + " " + matched + " "
                    // + yetToMatch);
                    if (queryStrings[k].equals(queries[j])) {
                        matched++;
                        if (matched == yetToMatch) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;

    }

    /**
     * Searches the database for the QueryKey and returns the value
     *
     * @param PrimaryKey The cell's unique identifier or the 1st Key on which line
     *                   the operation will be performed on
     * @param QueryKey   The query key which's value will be returned
     * @return The query result
     */
    public String getQueryResult(String PrimaryKey, String QueryKey) {
        read();

        String[] lines = new String[this.data.size()];
        this.data.toArray(lines);

        // get which line the user is on
        int lineNum = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("")) {
                continue;
            }
            String[] lineParts = lines[i].split(",");
            //System.out.println(lineParts[0].split("=")[1] + " " + PrimaryKey);
            if (lineParts[0].split("=")[1].equals(PrimaryKey)) {
                lineNum = i;
            }
        }

        if (lineNum == -1) {
            return "";
        }

        String[] linePartsArr = lines[lineNum].split(",");
        for (int i = 0; i < linePartsArr.length; i++) {
            String[] parts = linePartsArr[i].split("=");
            if (parts[0].equals(QueryKey)) {
                return parts[1];
            }
        }

        return "";
    }

    /**
     *
     * @param PrimaryKey The cell's unique identifier or the 1st Key on which line
     *                   the operation will be performed on
     * @param QueryKey   The query key which's value will be updated
     * @param QueryValue The new value
     */
    public void update(String PrimaryKey, String QueryKey, String QueryValue) {
        read();

        String[] lines = new String[this.data.size()];
        this.data.toArray(lines);

        System.out.println("Updating " + QueryKey + " with " + QueryValue + " where primaryKey = " + PrimaryKey);

        // get which line the user is on
        int lineNum = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("")) {
                continue;
            }
            String[] lineParts = lines[i].split(",");
            if (lineParts[0].split("=")[1].equals(PrimaryKey)) {
                lineNum = i;
            }
        }

        if (lineNum == -1) {
            return;
        }

        String[] linePartsArr = lines[lineNum].split(",");
        for (int i = 0; i < linePartsArr.length; i++) {
            String[] parts = linePartsArr[i].split("=");
            if (parts[0].equals(QueryKey)) {
                linePartsArr[i] = QueryKey + "=" + QueryValue;
            }
        }

        String newLine = "";
        for (int i = 0; i < linePartsArr.length; i++) {
            newLine += linePartsArr[i] + ",";
        }
        newLine = newLine.substring(0, newLine.length() - 1);

        lines[lineNum] = newLine;

        this.data.clear();
        for (int i = 0; i < lines.length; i++) {
            this.data.add(lines[i]);
        }

        write();
    }

    /**
     * Returns all the products that matches the productName
     * @param productName
     * @return
     */
    public ArrayList<Product> getProducts(String productName) {
        read();

        productName = productName.toLowerCase();

        System.out.println("Searching for " + productName + " in database");

        String[] lines = new String[this.data.size()];
        this.data.toArray(lines);

        // search the 1st index for the Product name
        ArrayList<Product> products = new ArrayList<Product>();

        for (int i = 0; i < lines.length; i++) {
            String[] lineParts = lines[i].split(",");
            String[] productNameParts = lineParts[1].split("=");

            if (productNameParts[1].toLowerCase().contains(productName)) {
                System.out.println("Found " + productNameParts[1] + " in database");

                String id = lineParts[0];
                String name = lineParts[1];
                String price = lineParts[3];
                String manufactureDate = lineParts[5];
                String expiryDate = lineParts[6];

                //System.out.println("Product name: " + nameParts[1]);

                Product prod = new Product(id.split("=")[1], name.split("=")[1], price.split("=")[1], manufactureDate.split("=")[1], expiryDate.split("=")[1]);
                products.add(prod);
            }
        }

        return products;
    }

}
