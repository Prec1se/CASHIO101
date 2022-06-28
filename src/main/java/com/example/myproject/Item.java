package com.example.myproject;

public class Item {
    public String Itemname;
    public int Itemprice;
    public int Itemquantaty;
    Item(){}
    Item(String n,int p)
    {
        this.Itemname=n;
        this.Itemprice=p;
    }
    Item(String n,int p,int q)
    {
        this.Itemname=n;
        this.Itemprice=p;
        this.Itemquantaty=q;
    }
}
