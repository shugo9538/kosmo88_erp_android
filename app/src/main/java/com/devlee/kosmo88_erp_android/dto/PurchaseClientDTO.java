package com.devlee.kosmo88_erp_android.dto;

public class PurchaseClientDTO {

    private int id;					// 거래처코드
    private String name;			// 거래처명
    private String register_num;  	// 사업자번호
    private String ceo_name;		// 대표자명
    private String phone;			// 거래처 연락처
    private String address;			// 주소

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
}
