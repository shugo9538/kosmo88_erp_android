package com.devlee.kosmo88_erp_android.dto;

import java.sql.Date;

public class WarehouseDto {
    private int id;
    private String name;
    private String address;
    private int section_count;
    private int stock_count;
    private int capacity_sum;
    private int count_sum;

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
    public int getSection_count() {
        return section_count;
    }
    public void setSection_count(int section_count) {
        this.section_count = section_count;
    }
    public int getStock_count() {
        return stock_count;
    }
    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }
    public int getCapacity_sum() {
        return capacity_sum;
    }
    public void setCapacity_sum(int capacity_sum) {
        this.capacity_sum = capacity_sum;
    }
    public int getCount_sum() {
        return count_sum;
    }
    public void setCount_sum(int count_sum) {
        this.count_sum = count_sum;
    }

}
