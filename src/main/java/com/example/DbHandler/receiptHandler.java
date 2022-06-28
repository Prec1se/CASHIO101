package com.example.DbHandler;

import com.example.Model.Product;
import com.example.Model.cashierReceipt;
import javafx.util.Pair;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class receiptHandler {
    public static void addReceipt(int id, Vector<Pair<Product, Integer>> itemList) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "identifier.sqlite");

            s = c.createStatement();
            int i = 0;
            while(i < itemList.size()) {
                String sql = "INSERT into Receipt (ReceiptId, ItemCount, ItemName) VALUES (" +
                        Integer.toString(id) + ", " + Integer.toString(itemList.lastElement().getValue()) + ", '" + itemList.firstElement().getKey().getName() + "');";
                s.executeUpdate(sql);
                i++;
            }
            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static cashierReceipt getReceipt() {
        cashierReceipt cr = new cashierReceipt();

        return cr;
    }
//    public static supplyReceipt getSupplyReceipt() {
//
//    }
//
//    public static cashierReceipt getCashierReceipt() {
//
//    } static cashierReceipt getCashierReceipt() {
//
//    }
}
