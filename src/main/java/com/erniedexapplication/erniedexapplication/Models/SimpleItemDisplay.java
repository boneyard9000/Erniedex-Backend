package com.erniedexapplication.erniedexapplication.Models;

public class SimpleItemDisplay {

    private int count;
    private String type;
    private int typeId;

    public SimpleItemDisplay(){}
    public SimpleItemDisplay(int count, String type, int typeId){
        this.count = count;
        this.type = type;
        this.typeId = typeId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
