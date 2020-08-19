package com.example.demo.entity;

public class Item {
    private int Id;
    private String Pw;
    private String NickName;
    private int Item;
    private int Price;

    public void setId(int id) {
        Id = id;
    }

    public void setPw(String pw) {
        Pw = pw;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public void setItem(int item) {
        Item = item;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getId() {
        return Id;
    }

    public String getPw() {
        return Pw;
    }

    public String getNickName() {
        return NickName;
    }

    public int getItem() {
        return Item;
    }

    public int getPrice() {
        return Price;
    }
}
