package com.example.demo.service;

import com.example.demo.entity.Item;

import java.util.List;

public interface ItemService {
    public void register(Item item) throws Exception;
    public List<Item> list() throws Exception;
    public Item read(Integer id) throws Exception;
    public void remove(int item) throws Exception;
    public void modify(Item item) throws Exception;
//    public void Modify(Item item) throws Exception;
//    public void Modify(Item item) throws Exception;
}
