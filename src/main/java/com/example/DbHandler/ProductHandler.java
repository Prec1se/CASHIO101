package com.example.DbHandler;

import com.example.Model.Product;

import java.io.File;
import java.sql.*;
import java.util.Vector;

public class ProductHandler {
    public final static String address = "jdbc:sqlite:C:" + File.pathSeparator + "Users"
            + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
            + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
            "main" + File.pathSeparator
            +"resources" + File.pathSeparator + "db.sqlite";
    private static final String low = "Low on Stock";
    private static final String zero = "No more available";
    private static final String enough = "In Stock";

    private static String stockStatus(int count, int minCount) {
        if(count == 0)
            return zero;
        if(count >= minCount)
            return enough;
        return low;
    }

    public static void addProduct(Product i) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);
            Statement s = c.createStatement();
            String stock = stockStatus(i.getCount(), i.getMinimumCount());
            String sql = "INSERT INTO Item (ItemName, ItemPrice, MinimumCount, InStockCount, StockStatus) " +
                    "VALUES (i.getName(), Integer.toString(i.getPrice()), Integer.toString(i.getMinimumCount()), Integer.toString(i.getCount()), stock);";
            s.executeUpdate(sql);
            s.close();
            c.commit();
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
//        System.out.println("Records added successfully");
    }

    public static void updateProductCount(String name, int addCount) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);

            Statement s = c.createStatement();
            String x = "SELECT * FROM Item WHERE ItemName = '" + name + "';";
            ResultSet r = s.executeQuery(x);
            int count = r.getInt("ItemCount") + addCount;
            int minimumCount = r.getInt("MinimumCount");
            String stock = stockStatus(count, minimumCount);
            String sql = "UPDATE Item " +
                    "SET InStockCount = " + count +
                    ", StockStatus = '" + stock + "' WHERE ItemName = '" + name + "';";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void updateProductPrice(String name, int newPrice) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);

            Statement s = c.createStatement();
            String sql = "UPDATE Item " +
                        "SET ItemPrice = " + newPrice +
                        " WHERE ItemName = '" + name + "';";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void deleteProduct(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);

            Statement s = c.createStatement();
            String sql = "DELETE from Item WHERE ItemName = '" + name + "';";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static Vector<Product> getAllProduct() {
        Vector<Product> allProduct = new Vector<>();
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "SELECT * FROM Item;";
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {
                String name = r.getString("ItemName");
                int price = r.getInt("ItemPrice");
                int count = r.getInt("InStockCount");
                Product x = new Product(name, price, count);
                allProduct.add(x);
//                System.out.println("not found");
            }
        } catch(SQLException | ClassNotFoundException e) {
//            System.out.println("exception Found");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return allProduct;
    }

//    public static Vector<item> searchItem(String name) {
//        Connection c = null;
//        Statement s = null;
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("");
//            c.setAutoCommit(false);
//
//            s = c.createStatement();
//            String sql = "";
//            s.executeQuery(sql);
//        } catch(SQLException | ClassNotFoundException e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//        }
//    }
//
//    public item getItem(String name) {
//
//    }

}
