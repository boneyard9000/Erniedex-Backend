package com.erniedexapplication.erniedexapplication.Repositories;

import com.erniedexapplication.erniedexapplication.Models.Item;
import com.erniedexapplication.erniedexapplication.Models.ItemType;
import com.erniedexapplication.erniedexapplication.Models.SimpleItemDisplay;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ItemDao {
    public List<Item> getAllItems();
    public Item getItemById(UUID id);
    public Item addItem(Item item);
    public boolean deleteItem(UUID id);
    public Item updateItem(Item item);
    public List<SimpleItemDisplay> getGroupedItems();

}
