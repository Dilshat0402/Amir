package com.amir.Diploma.services.impl;

import com.amir.Diploma.models.Item;
import com.amir.Diploma.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item addApartment(Item apartment) {
        return itemRepository.save(apartment);
    }

    public Item savePost(Item post) {
        return itemRepository.save(post);
    }
}
