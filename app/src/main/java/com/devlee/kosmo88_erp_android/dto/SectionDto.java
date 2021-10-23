package com.devlee.kosmo88_erp_android.dto;

public class SectionDto {
    private int id;
    private int warehouse_id;
    private String section;
    private int capacity;
    private int loaded;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getWarehouse_id() {
        return warehouse_id;
    }
    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getLoaded() {
        return loaded;
    }
    public void setLoaded(int loaded) {
        this.loaded = loaded;
    }
    @Override
    public String toString() {
        return "SectionDto [id=" + id + ", warehouse_id=" + warehouse_id + ", section=" + section + ", capacity="
                + capacity + ", loaded=" + loaded + "]";
    }
}
