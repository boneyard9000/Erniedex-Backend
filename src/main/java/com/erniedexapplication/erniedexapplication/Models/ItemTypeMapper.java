package com.erniedexapplication.erniedexapplication.Models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemTypeMapper implements RowMapper<ItemType> {
    @Override
    public ItemType mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemType type = new ItemType();
        type.setType(rs.getString("type"));
        type.setTypeId(rs.getInt("typeid"));
        return type;
    }
}
