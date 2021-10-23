package com.devlee.kosmo88_erp_android.dto;

public class PurchaseOrderListViewDTO {

    private int request_id;			// 주문번호
    private String client_name;		// 주문처
    private String client_ceo_name; // 주문처 대표자
    private String client_phone; 	// 주문처 연락처
    private String employee_name;	// 구매 담당자

    public PurchaseOrderListViewDTO() {}

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_ceo_name() {
        return client_ceo_name;
    }

    public void setClient_ceo_name(String client_ceo_name) {
        this.client_ceo_name = client_ceo_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
}
