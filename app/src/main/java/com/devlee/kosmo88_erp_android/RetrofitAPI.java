package com.devlee.kosmo88_erp_android;

import com.devlee.kosmo88_erp_android.dto.EmployeeDTO;
import com.devlee.kosmo88_erp_android.dto.FinancialDTO;
import com.devlee.kosmo88_erp_android.dto.IncomeDTO;
import com.devlee.kosmo88_erp_android.dto.PurchaseClientDTO;
import com.devlee.kosmo88_erp_android.dto.PurchaseEstimateListViewDTO;
import com.devlee.kosmo88_erp_android.dto.PurchaseItemListViewDTO;
import com.devlee.kosmo88_erp_android.dto.PurchaseOrderListViewDTO;
import com.devlee.kosmo88_erp_android.dto.SalesClientDTO;
import com.devlee.kosmo88_erp_android.dto.SalesEstimateDTO;
import com.devlee.kosmo88_erp_android.dto.SalesOrderDTO;
import com.devlee.kosmo88_erp_android.dto.WarehouseDto;

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

    @GET("/logistics_erp/purchase/itemManagement/itemList")
    Call<List<PurchaseItemListViewDTO>> getItemList();

    @GET("/logistics_erp/purchase/clientManagement/clientList")
    Call<List<PurchaseClientDTO>> getClientList();

    @GET("/logistics_erp/purchase/estimateManagement/estimateList")
    Call<List<PurchaseEstimateListViewDTO>> getEstimateList();

    @GET("/logistics_erp/purchase/orderManagement/orderList")
    Call<List<PurchaseOrderListViewDTO>> getOrderList();

    @GET("/logistics_erp/sales/clientManagement/clientList")
    Call<List<SalesClientDTO>> getSalesClientList();

    @GET("/logistics_erp/sales/estimateManagement/estimateList")
    Call<List<SalesEstimateDTO>> getSalesEstimateList();

    @GET("/logistics_erp/sales/orderManagement/orderList")
    Call<List<SalesOrderDTO>> getSalesOrderList();

    //    @GET("주소")
    @GET("/logistics_erp/wms/warehouse/warehouseList")
    Call<List<WarehouseDto>> warehouseList();

//    @GET("주소")
//    Call<받아오는 형태 = 스프링에서 return 하는 값> 메서드 명();
}