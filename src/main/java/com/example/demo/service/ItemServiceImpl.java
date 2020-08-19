package com.example.demo.service;

import com.example.demo.Repository.ItemRepository;
import com.example.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void register(Item item) throws Exception {
        itemRepository.create(item);
    }

    @Override
    public List<Item> list() throws Exception {
        return itemRepository.list();
    }

    @Override
    public Item read(Integer id) throws Exception {
        return itemRepository.read(id);
    }

    @Override
    public void remove(int id) throws Exception {
        itemRepository.remove(id);
    }

    @Override
    public void modify(Item item) throws Exception {
        itemRepository.modify(item);
    }
}
