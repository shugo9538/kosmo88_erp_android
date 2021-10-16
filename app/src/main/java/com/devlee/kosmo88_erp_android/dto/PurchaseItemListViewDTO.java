package com.devlee.kosmo88_erp_android.dto;

public class PurchaseItemListViewDTO {

    private int item_id;				// 상품코드
    private String item_name;			// 상품명
    private String item_category;		// 종류
    private int item_price;				// 상품가격(공급단가)
    private String client_name;			// 거래처(구매처)
    private String client_register_num; // 사업자번호

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_register_num() {
        return client_register_num;
    }

    public void setClient_register_num(String client_register_num) {
        this.client_register_num = client_register_num;
    }
}
