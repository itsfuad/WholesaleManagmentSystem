import java.util.*;

public class Main{
    public static void main(String[] args){ 
        System.out.println("Welcome to Wholesale Management System");

        database checkpoint = new database("loggedIn.txt");
            
        if (checkpoint.isEmpty()){
            new defaultPage();
        }else{
            String value = checkpoint.getData().get(0);
            
            database db = new database("users.txt");
            String ret = db.getQueryResult(value, "username");

            if (!ret.equals("")){
                String type = db.getQueryResult(value, "accountType");
                if (type.equals("Merchant")){
                    new merchantPage(value);
                }else if (type.equals("Manufacturer")){
                    new manufacturerPage();
                }
            }else{
                new defaultPage();
            }
        }
    }
}