package com.devlee.kosmo88_erp_android;

import com.devlee.kosmo88_erp_android.dto.EmployeeDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("/logistics_erp/hr/employee/selectEmployee")
    Call<List<EmployeeDTO>> getEmployeeList();

//    @GET("주소")
//    Call<받아오는 형태 = 스프링에서 return 하는 값> 메서드 명();
}