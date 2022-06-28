package com.example.myproject;

public class Purches {
    String name;
    int totalproduct;
    int totalocost;
    String date;

    Purches(){}

    Purches(String n,int p,int c)
    {
        this.name=n;
        this.totalocost=c;
        this.totalproduct=p;
    }
    Purches(String n,int p,int c,String d)
    {
        this.name=n;
        this.totalocost=c;
        this.totalproduct=p;
        this.date=d;
    }
}
