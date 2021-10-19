package com.devlee.kosmo88_erp_android.dto;

public class SalesEstimateDTO {
    private int request_id;			// 견적번호
    private String client_name;		// 거래처명
    private String client_ceo_name; // 거래처대표자명
    private String client_phone; 	// 거래처연락처
    private String employee_name;	// 담당자

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
