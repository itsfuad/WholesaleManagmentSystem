import Database.*;
import GUI.Checkpoint.*;
import GUI.Frames.*;

public class Main{

    public static String USERNAME;

    public static void main(String[] args){
        System.out.println("Welcome to Wholesale Management System");

        Database checkpoint = new Database("loggedIn.txt");

        USERNAME = checkpoint.get();

        if (USERNAME.equals("")){
            System.out.println("No user logged in");
            new DefaultPage();
            return;
        }

        System.out.println("Verifying user: " + USERNAME);

        Database db = new Database("users.txt");

        String ret = db.getQueryResult(USERNAME, "username");

        System.out.println("Found user: " + ret);

        if (!ret.equals("")){
            System.out.println("Logged in as: " + USERNAME);
            new Menu();
        }else{
            new DefaultPage();
        }
    }
}