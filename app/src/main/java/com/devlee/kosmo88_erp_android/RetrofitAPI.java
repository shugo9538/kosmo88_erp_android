package com.devlee.kosmo88_erp_android;

import com.devlee.kosmo88_erp_android.dto.EmployeeDTO;
import com.devlee.kosmo88_erp_android.dto.SalesClientDTO;
import com.devlee.kosmo88_erp_android.dto.SalesEstimateDTO;
import com.devlee.kosmo88_erp_android.dto.SalesOrderDTO;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {
    @POST("/logistics_erp/loginAction")
    Call<String> login(@Query("map") Map<String, String> map);

    @GET("/logistics_erp/hr/employee/selectEmployee")
    Call<List<EmployeeDTO>> getEmployeeList();

    @GET("/logistics_erp/sales/clientManagement/clientList")
    Call<List<SalesClientDTO>> getSalesClientList();

    @GET("/logistics_erp/sales/estimateManagement/estimateList")
    Call<List<SalesEstimateDTO>> getSalesEstimateList();

    @GET("/logistics_erp/sales/orderManagement/orderList")
    Call<List<SalesOrderDTO>> getSalesOrderList();

    //    @GET("주소")
//    Call<받아오는 형태 = 스프링에서 return 하는 값> 메서드 명();
}