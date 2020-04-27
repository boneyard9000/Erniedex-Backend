package com.erniedexapplication.erniedexapplication.Repositories;


import com.erniedexapplication.erniedexapplication.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ItemRepository implements ItemDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemRepository(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Item> getAllItems(){
        List<Item> items = null;
        try {
            items = jdbcTemplate.query(Queries.GET_ALL_ITEMS, new ItemMapper());
        }

        catch(DataAccessException ex) {
            System.out.print(ex);
        }
        return items;

    }


    @Override
    public Item getItemById(UUID id){
        Item item = null;
        try {
            item = jdbcTemplate.queryForObject(Queries.GET_ITEM_BY_ID, new ItemMapper(), id);
        }   catch(DataAccessException ex) {
            System.out.print(ex);
        }
        return item;
    }

    @Override
    public Item addItem(Item item){
        int colorId;
        try{
            colorId = item.getColorId();
        } catch (NullPointerException ex) {
            colorId = -1;
        }
        Item newItem = null;
        try {
            Object[] params = new Object[] {item.getTypeId(), colorId, item.getPrice(), item.getShape(), item.getSize()};
            newItem = jdbcTemplate.queryForObject(Queries.ADD_ITEM, new ItemMapper(), params);
        }   catch(DataAccessException ex) {
            System.out.print(ex);
        }

        return newItem;
    }

    @Override
    public boolean deleteItem(UUID id){
        boolean success = false;
        try {
            success = (jdbcTemplate.update(Queries.DELETE_ITEM, id) > 0);
        }   catch (DataAccessException ex){
            System.out.print(ex);
        }
        return success;
    }

    @Override
    public Item updateItem(Item item){
        Item updated = null;
        int colorId;
        try{
            colorId = item.getColorId();
        } catch (NullPointerException ex) {
            colorId = -1;
        }

        try {
            Object[] params = new Object[] {item.getTypeId(), colorId, item.getPrice(), item.getShape(), item.getSize(), item.getId()};
            item = jdbcTemplate.queryForObject(Queries.UPDATE_ITEM, new ItemMapper(), params);
        }   catch(DataAccessException ex) {
            System.out.print(ex);
        }
        return item;
    }

    @Override
    public List<SimpleItemDisplay> getGroupedItems(){
         Map<Integer, Integer> groupedTypes = new HashMap<Integer, Integer>();
         List<SimpleItemDisplay> displayItems = new ArrayList<SimpleItemDisplay>();
        try {
           SqlRowSet result = jdbcTemplate.queryForRowSet(Queries.GET_LIST_TYPE_IDS);
           while(result.next()){
               int id = result.getInt("typeid");
               if(!groupedTypes.containsKey(id)){
                   groupedTypes.put(id, 1);
               } else {
                   groupedTypes.put(id, groupedTypes.get(id) + 1);
               }
           }
           List<ItemType> itemTypes = jdbcTemplate.query(Queries.GET_TYPES, new ItemTypeMapper());
           for(ItemType type : itemTypes){
               SimpleItemDisplay display = new SimpleItemDisplay(groupedTypes.get(type.getTypeId()), type.getType(), type.getTypeId());
               displayItems.add(display);
           }

       }    catch(Exception ex){
           System.out.print(ex);
       }
       return displayItems;

    }

    private static class Queries{
        private static final String GET_ALL_ITEMS = "SELECT * FROM item";
        private static final String GET_ITEM_BY_ID = "SELECT id, typeid, colorid, price, shape, size FROM item WHERE id = ?";
        private static final String ADD_ITEM = "INSERT INTO item (typeid, colorid, price, shape, size) VALUES (?, ?, ?, ?, ?)" +
                                                " RETURNING id, typeid, colorid, price, shape, size";
        private static final String DELETE_ITEM = "DELETE FROM item WHERE id = ?";
        private static final String UPDATE_ITEM = "UPDATE item SET (typeid, colorid, price, shape, size) = " +
                                                    " (?, ?, ?, ?, ?) WHERE id = ?";
        private static final String GET_TYPES = "SELECT typeid, type FROM type";
        private static final String GET_LIST_TYPE_IDS = "SELECT typeid FROM item";
    }
}

