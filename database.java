import java.io.*;
import java.util.*;

public class database {
    private String filename;
    private ArrayList<String> data;

    public database(String filename) {
        this.filename = filename;
        this.data = new ArrayList<String>();
    }

    public void read() {
        try {
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
        if (this.data.contains(line)) {
            this.data.clear();
            read();
            this.data.remove(line);
            write();
        }
    }

    public void clear() {
        this.data.clear();
        //clear file
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

    public boolean contains(String line) {
        read();
        return this.data.contains(line);
    }

    public boolean isEmpty() {
        read();
        return this.data.isEmpty();
    }


    /**
     * Matches all the queries and returns true if all queries are true. 
     * Example,
     * match("username=user1,address=dhaka") returns true if both values are present in the database
     * @param Query The Query string
     * @return true or false
     */
    public boolean match(String query) {
        read();
    
        String[] queries = query.split(",");

        final int yetToMatch = queries.length;
        
        for (int i = 0; i < data.size(); i++){
            int matched = 0;
            String[] queryStrings = data.get(i).split(",");
            for (int j = 0; j < queries.length; j++){
                for (int k = 0; k < queryStrings.length; k++){
                    //System.out.println(queryStrings[k] + " = " + queries[j] + " " + matched + " " + yetToMatch);
                    if (queryStrings[k].equals(queries[j])){
                        matched++;
                        if (matched == yetToMatch){
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
     * @param PrimaryKey The cell's unique identifier or the 1st Key on which line the operation will be performed on
     * @param QueryKey The query key which's value will be returned
     * @return The query result
     */
    public String getQueryResult(String PrimaryKey, String QueryKey){
        read();

        String[] lines = new String[this.data.size()];
        this.data.toArray(lines);

        
        //get which line the user is on
        int lineNum = -1;
        for (int i = 0; i < lines.length; i++){
            if (lines[i].equals("")){
                continue;
            }
            String[] lineParts = lines[i].split(",");
            if (lineParts[0].split("=")[1].equals(PrimaryKey)){
                lineNum = i;
            }
        }

        if (lineNum == -1){
            return "";
        }

        String[] linePartsArr = lines[lineNum].split(",");
        for (int i = 0; i < linePartsArr.length; i++){
            String[] parts = linePartsArr[i].split("=");
            if (parts[0].equals(QueryKey)){
                return parts[1];
            }
        }

        return "";
    }

}
