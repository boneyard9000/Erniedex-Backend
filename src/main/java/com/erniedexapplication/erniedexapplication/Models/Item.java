package com.erniedexapplication.erniedexapplication.Models;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {

    private Integer typeId;
    private Integer colorId;
    private UUID id;
    private String size;
    private String shape;
    private BigDecimal price;

    public Item() {
    }

    public Item(Integer typeId, Integer colorId, UUID id, String size, String shape, BigDecimal price) {
        this.typeId = typeId;
        this.colorId = colorId;
        this.id = id;
        this.size = size;
        this.shape = shape;
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }
}

