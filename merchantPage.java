import java.lang.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class merchantPage extends JFrame implements ActionListener {

    private String merchantNameString, shopNameString, shopId;
    private JLabel merchantName, shopName;

    // searchbox
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;

    // table
    private JTable table;
    private JScrollPane scrollPane;
    private String[] columnNames = { "Product ID", "Product Name", "Price", "Quantity", "Manufacturer ID",
            "Manufacturer Name" };

    // buttons
    private JButton addProductButton, editProductButton, deleteProductButton, logoutButton;

    private JPanel panel;

    public merchantPage(String shopId) {
        super("Merchant Page");

        setSize(800, 450);

        // disable maximize button and resizable window
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);

        this.shopId = shopId;
        fetchData();

        panel = new JPanel();
        panel.setLayout(null);

        panel.setSize(800, 450);
        panel.setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        merchantName = new JLabel(this.merchantNameString);
        merchantName.setBounds(260, 50, 300, 25);
        panel.add(merchantName);

        shopName = new JLabel(this.shopNameString);
        shopName.setBounds(260, 75, 300, 25);
        panel.add(shopName);

        searchLabel = new JLabel("Search");
        searchLabel.setBounds(260, 100, 80, 25);
        panel.add(searchLabel);

        searchField = new JTextField(20);
        searchField.setBounds(350, 100, 160, 25);
        panel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(520, 100, 100, 25);
        searchButton.addActionListener(this);
        panel.add(searchButton);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 150, 700, 200);
        panel.add(scrollPane);

        addProductButton = new JButton("Add Product");
        addProductButton.setBounds(50, 375, 100, 25);
        addProductButton.addActionListener(this);
        panel.add(addProductButton);

        editProductButton = new JButton("Edit Product");
        editProductButton.setBounds(200, 375, 100, 25);
        editProductButton.addActionListener(this);
        panel.add(editProductButton);

        deleteProductButton = new JButton("Delete Product");
        deleteProductButton.setBounds(350, 375, 100, 25);
        deleteProductButton.addActionListener(this);
        panel.add(deleteProductButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(500, 375, 100, 25);
        logoutButton.addActionListener(this);
        panel.add(logoutButton);

        this.add(panel);

        setVisible(true);
    }

    private void fetchData() {
        // fetch data from database
        database db = new database("users.txt");
        this.shopNameString = db.getQueryResult(this.shopId, "entityName");
        this.merchantNameString = db.getQueryResult(this.shopId, "fullName");
    }

    // action listener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            // logout
            new loginPage();
            this.dispose();
            database db = new database("loggedIn.txt");
            db.clear();
        }
    }
}
