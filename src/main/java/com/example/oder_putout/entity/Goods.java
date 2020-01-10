package com.example.oder_putout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Goods {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private float price;
    private int stock;
    private String easyWrite;
//    种类
    private int categories;
    private String unit;
//    每件数量
    private float boxSize;

    public String getEasyWrite() {
        return easyWrite;
    }

    public void setEasyWrite(String easyWrite) {
        this.easyWrite = easyWrite;
    }

    public float getBoxSize() {
        return boxSize;
    }

    public void setBoxSize(float boxSize) {
        this.boxSize = boxSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategories() {
        return categories;
    }

    public void setCategories(int categories) {
        this.categories = categories;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
