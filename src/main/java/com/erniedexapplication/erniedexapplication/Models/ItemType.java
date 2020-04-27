package com.erniedexapplication.erniedexapplication.Models;

public class ItemType {
    private String type;
    private int typeId;

    public ItemType(){}
    public ItemType(String type, int typeId){
        this.type = type;
        this.typeId =  typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
