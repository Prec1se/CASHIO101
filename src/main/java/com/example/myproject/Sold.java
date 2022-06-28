package com.example.myproject;

import javafx.util.Pair;

import java.util.Vector;

public class Sold {



    int price;
    int quantity;
    int total_price;
    String name;
    static int numberofelement=0;
    static int totalnumberofsoldelemewnt;
    static int totalprice=0;
    static  Vector<Purches> pur = new Vector<Purches>();
    static  Vector<Purches> sol = new Vector<Purches>();
     // Pair<String, Integer> mypair;
    Sold(int price)
    {
        this.price=price;

    }
    Sold(String n,int q,int p,int t)
    {
        this.name=n;
        this.quantity=q;
        this.price=p;
        this.total_price=t;

    }

    static void SetItems()
    {
        Item myitem= new Item("Pen",10,10);
        Dataclasss.Items.add(myitem);
        myitem= new Item("Paper",15,10);
        Dataclasss.Items.add(myitem);
        myitem= new Item("Rubber",20,10);
        Dataclasss.Items.add(myitem);
        myitem= new Item("Ball",250,10);
        Dataclasss.Items.add(myitem);
    }

}
