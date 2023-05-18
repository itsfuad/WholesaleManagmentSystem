package src;

import Database.*;
import GUI.Checkpoint.*;
import GUI.Frames.*;


public class Main{

    public static String USERNAME;
    public static String fullName;

    public static Database LoggedInDatabase = new Database("loggedIn.txt");
    public static Database UsersDatabase = new Database("users.txt");
    public static Database ProductsDatabase = new Database("products.txt");
    public static Database CartDatabase = new Database("cart.txt");
    public static Database purchaseHistoryDatabase = new Database("purchases.txt");

    public static void main(String[] args){
        System.out.println("Welcome to Wholesale Management System");

        USERNAME = LoggedInDatabase.get();

        if (USERNAME.equals("")){
            System.out.println("No user logged in");
            new DefaultPage();
            return;
        }

        System.out.println("Verifying user: " + USERNAME);

        String ret = UsersDatabase.getQueryResult(USERNAME, "username");
        fullName = UsersDatabase.getQueryResult(USERNAME, "fullName");

        System.out.println("Found user: " + ret);

        if (!ret.equals("")){
            System.out.println("Logged in as: " + USERNAME);
            new Menu();
        }else{
            new DefaultPage();
        }
    }
}