package com.example.Model;

import com.example.DbHandler.userHandler;
import com.example.myproject.Item;

import java.util.Vector;

public class Admin extends user{

    public Admin() {
        super();
    }

    public Admin(String userName, int password, int userID) {
        super(userName, password, userID);
    }
    public static void addProduct(Vector<Item> i) {
        Product.addNewProduct(i);
    }
    public void deleteProduct(Product i) {
        Product.deleteProduct(i);
    }
    public void changeProductCount(String name, int count) { Product.setCount(name, count); }
    public void changeProductPrice(String name, int price) { Product.setPrice(name, price); }
    public static String getPassword() {
//        System.out.println("admin");
        return userHandler.getAdminPassword();
    }
//    public void createSupplyReceipt(int totalPrice, Vector<Pair<Item, Integer>> itemList) {
//        supplyReceipt.
//    }
    public void changePassword() {

    }
}
