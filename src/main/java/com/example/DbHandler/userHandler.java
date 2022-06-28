package com.example.DbHandler;

import java.io.File;
import java.sql.*;
import java.util.Vector;

public class userHandler {
    public static void addUser(String name, String category, int password) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "db.sqlite");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "INSERT into User (Category, Password, UserName) " +
                         "VALUES (" + category + ", " + password + ", " + name + ");";
            s.executeUpdate(sql);
            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void updateUser(int id, int newPass) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "db.sqlite");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "UPDATE User SET Password = "+ newPass + " WHERE UserId = " + id + ";";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void deleteUser(int id) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "db.sqlite");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "DELETE  from User WHERE UserId = " + id + ";";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static Vector<String> getAllCashierName() {
        Vector<String> us = new Vector<String>();
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "db.sqlite");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "SELECT * FROM User WHERE Category = 'Cashier';";
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {
                String name = r.getString("UserName");
                us.add(name);
            }
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return us;
    }

    public static void changeCashierName(String old, String now) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "db.sqlite");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "UPDATE User SET Username = now WHERE Username = old";
            ResultSet r = s.executeQuery(sql);
        }
        catch (SQLException | ClassNotFoundException e){
            System.err.print(e.getClass().getName() + " " + e.getMessage());
            System.exit(0);
        }
    }

    public static String getAdminPassword() {
        Connection c = null;
        Statement s = null;

        try {
            System.out.println("1");
            Class.forName("org.sqlite.JDBC");
            System.out.println("2");
            c = DriverManager.getConnection( "jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "db.sqlite");
            System.out.println("3");
            c.setAutoCommit(false);
//            System.out.println("4");
            s = c.createStatement();
            String sql = "SELECT * FROM User WHERE Category = 'Admin';";
            ResultSet r = s.executeQuery(sql);
            String pass = Integer.toString(r.getInt("Password"));
//            System.out.println("no exception");
            return pass;
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            System.exit(0);
            return null;
        }
    }

    public static void changePassword(String cat, String name, int pass) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:" + File.pathSeparator + "Users"
                    + File.pathSeparator + "Prec1se" + File.pathSeparator + "IdeaProjects" + File.pathSeparator
                    + "CASHIO101" + File.pathSeparator + "src" + File.pathSeparator +
                    "main" + File.pathSeparator
                    +"resources" + File.pathSeparator + "db.sqlite");
            c.setAutoCommit(false);
            s = c.createStatement();
            if(cat.equals("Admin")) {
                String sql = "UPDATE User SET Password = pass WHERE Category = cat;";
                ResultSet r = s.executeQuery(sql);
            }
            else {
                String sql = "UPDATE User SET Password = pass WHERE Category = cat" +
                        " AND UserName = name;";
                ResultSet r = s.executeQuery(sql);
            }
//            System.out.println("no exception");
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

}
