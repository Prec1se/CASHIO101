package com.example.Model;

import com.example.DbHandler.ProductHandler;
import com.example.myproject.Item;

import java.util.Vector;

public class Product {
    private String name;
    private int price, count;
    private int minimumCount;

//    public static Vector<Product> allProduct = null;

    public Product() {
        name = "";
        price = 0;
        count = 0;
        minimumCount = 0;
    }

    public Product(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
        minimumCount = 0;
    }

    public Product(String name, int price, int count, int minimumCount) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.minimumCount = minimumCount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getMinimumCount() { return minimumCount; }

//    public static void setAllProduct() {
//        // get items from db and copy them to allItem variable
//        ProductHandler.setAllProduct();
//    }

    public static void addNewProduct(Vector<Item> i) {
//        allProduct.add(i);
        // add to db ()
        int j = 0;
        while(j < i.size()) {
            String nm = i.get(j).Itemname;
            int prc = i.get(j).Itemprice;
            int cnt = i.get(j).Itemquantaty;
            Product x = new Product(nm, prc, cnt);
            ProductHandler.addProduct(x);
        }
    }

    public static void deleteProduct(Product i) {

    }

    public static void setPrice(String name, int newPrice) {
        ProductHandler.updateProductPrice(name, newPrice);
    }

    public static void setCount(String name, int count) {
        ProductHandler.updateProductCount(name, count);
    }

    public static Vector<Product> getAllProduct() {
        return ProductHandler.getAllProduct();
    }
}

