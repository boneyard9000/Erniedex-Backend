package com.erniedexapplication.erniedexapplication.Models;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ItemMapper implements RowMapper<Item>{
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {

        Item item = new Item();
        item.setId(UUID.fromString(rs.getString("id")));
        item.setShape(rs.getString("shape"));
        item.setSize(rs.getString("size"));
        item.setTypeId(rs.getInt("typeid"));
        item.setPrice(rs.getBigDecimal("price"));
        item.setColorId(rs.getInt("colorid"));

        return item;
    }
}
