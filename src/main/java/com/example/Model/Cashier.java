package com.example.Model;

import com.example.DbHandler.userHandler;
import javafx.util.Pair;

import java.util.Vector;

public class Cashier extends user{

    public Cashier(String userName, int password, int userID) {
        super(userName, password, userID);
    }

    public void createNewReceipt(int _totalPrice, Vector<Pair<Product, Integer>> _itemList) {
        cashierReceipt.addCashierReceipt(_totalPrice, _itemList);
    }

    public void addCashier(String name, int password) {
        userHandler.addUser(name, "Cashier", password);
    }

    public cashierReceipt getLastReceipt() {
        return cashierReceipt.getLastReceipt();
    }

    public static Vector<String> getAllCashierName() {
        return userHandler.getAllCashierName();
    }

    public static void changeCashierName(String old, String now) {
        userHandler.changeCashierName(old, now);
    }

    public static void addReceipt(cashierReceipt r) {
        
    }
}
