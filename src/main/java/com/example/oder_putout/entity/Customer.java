package com.example.oder_putout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String address;
    private int tel;
    private String easyWrite;

    public String getEasyWrite() {
        return easyWrite;
    }

    public void setEasyWrite(String easyWrite) {
        this.easyWrite = easyWrite;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

}
