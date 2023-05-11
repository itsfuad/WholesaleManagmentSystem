import java.util.*;

import javax.swing.JOptionPane;

import utils.*;

public class Main{
    public static void main(String[] args){ 
        System.out.println("Welcome to Wholesale Management System");

        database checkpoint = new database("loggedIn.txt");

        database db1 = new database("users.txt");

        String prev = db1.getQueryResult("itsfuad", "password");

        
        if (prev.equals("12345qwert")){
            String curr = "sexyNahin1";

            if (new validator().validatePassword(curr) == false){
                return;
            }

            JOptionPane.showMessageDialog(null, "Password changed successfully");

            db1.update("itsfuad", "password", curr);
        }else{
            System.out.println("Password incorrect");
            return; 
        }

            
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