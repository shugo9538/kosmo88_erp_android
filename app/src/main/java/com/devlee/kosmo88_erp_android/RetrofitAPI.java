package com.devlee.kosmo88_erp_android;

import com.devlee.kosmo88_erp_android.dto.EmployeeDTO;
import com.devlee.kosmo88_erp_android.dto.FinancialDTO;
import com.devlee.kosmo88_erp_android.dto.IncomeDTO;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

//    @GET("주소")
//    Call<받아오는 형태 = 스프링에서 return 하는 값> 메서드 명();
public interface RetrofitAPI {
    @POST("/logistics_erp/loginAction")
    Call<String> login(@Query("map") Map<String, String> map);

    @GET("/logistics_erp/hr/employee/selectEmployee")
    Call<List<EmployeeDTO>> getEmployeeList();

    @GET("/logistics_erp/account/rest/selectIncomeStatement")
    Call<IncomeDTO> getIncomeSatement();

    @GET("/logistics_erp/account/rest/selectFinancialStatement")
    Call<FinancialDTO> getFinancialSatement();


}