package com.devlee.kosmo88_erp_android.dto;

import java.util.Date;

public class SalesClientDTO {
    private int id;              		// 거래처코드
    private String name;           		// 거래처명
    private String register_num;   		// 사업자번호
    private String ceo_name;       		// 대표자명
    private String phone;               // 전화번호
    private String address;        		// 주소
    //private Date register_date;   	    // 거래처 등록일

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

    public String getRegister_num() {
        return register_num;
    }

    public void setRegister_num(String register_num) {
        this.register_num = register_num;
    }

    public String getCeo_name() {
        return ceo_name;
    }

    public void setCeo_name(String ceo_name) {
        this.ceo_name = ceo_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //public Date getRegister_date() {
    //    return register_date;
    //}

    //public void setRegister_date(Date register_date) {
    //    this.register_date = register_date;
    //}
}
