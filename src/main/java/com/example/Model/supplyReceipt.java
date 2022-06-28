package com.example.Model;

import javafx.util.Pair;

import java.util.Vector;

public class supplyReceipt extends receipt{
    public supplyReceipt() {
        super();
    }
    private static Vector<cashierReceipt> newReceipt, oldReceipt;
    public supplyReceipt(int totalPrice, Vector<Pair<Product, Integer>> itemList) {
        super(totalPrice, itemList);
    }
//    public static void addsupplyReceipt(int _totalPrice, Vector<Pair<Item, Integer>> _itemList) {
//        cashierReceipt c = new cashierReceipt(_totalPrice, _itemList);
//        newReceipt.add(c);
//        receiptHandler.addReceipt();
//    }

}
