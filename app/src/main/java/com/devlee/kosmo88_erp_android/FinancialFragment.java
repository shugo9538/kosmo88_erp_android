package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.devlee.kosmo88_erp_android.dto.FinancialDTO;
import com.devlee.kosmo88_erp_android.dto.IncomeDTO;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FinancialFragment extends Fragment {
    private static final String TAG = FinancialFragment.class.getSimpleName();

    private TextView cash_asets; // 현금및 현금성자산(보통예금포함)
    private TextView accounts_receivable; //매출채권(외상매출금)
    private TextView vatPayment; //부가세대급금
    private long cashAsets;
    private long accountsReceivable;
    private long vatPaymenT;

    //당좌자산
    private TextView current_assets;
    private long currentAssets;

    //유동자산
    private TextView quick_assets;
    private long quickAssets;


    private TextView inventory_assets; //매입채권(외상매입금)
    private long inventoryAssets;

    private TextView inventory_assets_total; //재고자산
    private long inventoryAssetsToal;

    private TextView assets_total; //자산총계
    private long assetsToal;


    private TextView purchase_receivable; //매입채권(외상매입금)
    private TextView vatDeposit; //부가세예수금
    private long purchaseReceivable;
    private long vatDeposiT;

    //유동부채
    private long quickDept;
    private TextView quick_dept;

    //부채총계
    private TextView dept_total;
    private long deptToal;

    private TextView capital; //자본금
    private long capItal;
    private TextView capita_total; // 자본급합계

    //당기순이익
    private TextView net_income;
    private long netIncome;

    //자본총계
    private TextView asset3;
    private long asset3_sum;
    //부채및자본총계
    private TextView asset7;
    private long asset7_sum;

    private Web web;
    private Call<FinancialDTO> mcallAccount;
    //private IncomeDTO list = new ArrayList<>();

    public static FinancialFragment newInstance() {
        FinancialFragment fragment = new FinancialFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private FinancialFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.financial_item_layout, container, false);
        rootView.setTag(TAG);


        cash_asets = rootView.findViewById(R.id.cash_asets);
        accounts_receivable = rootView.findViewById(R.id.accounts_receivable);
        vatPayment = rootView.findViewById(R.id.vatPayment);
        inventory_assets = rootView.findViewById(R.id.inventory_assets);
        inventory_assets_total = rootView.findViewById(R.id.inventory_assets_total);

        current_assets = rootView.findViewById(R.id.current_assets);
        quick_assets = rootView.findViewById(R.id.quick_assets);

        //자산총계
        assets_total = rootView.findViewById(R.id.assets_total);

        purchase_receivable = rootView.findViewById(R.id.purchase_receivable);
        vatDeposit = rootView.findViewById(R.id.vatDeposit);
        capital = rootView.findViewById(R.id.capital);
        capita_total = rootView.findViewById(R.id.capita_total);

        //유동부채
        quick_dept = rootView.findViewById(R.id.quick_dept);

        //부채총계
        dept_total = rootView.findViewById(R.id.dept_total);

        //자본총계
        asset3 = rootView.findViewById(R.id.asset3);
        // 부채및 자본총계
        asset7 = rootView.findViewById(R.id.asset7);

        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallAccount = mRetrofitAPI.getFinancialSatement();
        mcallAccount.enqueue(new Callback<FinancialDTO>() {
            @Override
            public void onResponse(Call<FinancialDTO> call, Response<FinancialDTO> response) {
                FinancialDTO result = response.body();
                DecimalFormat format = new DecimalFormat("###,###,###,###");

                cashAsets = result.getCash_asets();// 현금및 현금성자산(보통예금포함)
                accountsReceivable = result.getAccounts_receivable();//매출채권(외상매출금)
                vatPaymenT = result.getVatPayment();//부가세대급금

                cash_asets.setText(format.format(cashAsets));
                accounts_receivable.setText(format.format(accountsReceivable));
                vatPayment.setText(format.format(vatPaymenT));
                //당좌자산
                currentAssets = (cashAsets + accountsReceivable + vatPaymenT);;
                current_assets.setText(format.format(currentAssets));

                inventoryAssets = result.getInventory_assets();//상품
                inventory_assets.setText(format.format(inventoryAssets));

                //재고자산
                inventoryAssetsToal = (inventoryAssets);
                inventory_assets_total.setText(format.format(inventoryAssetsToal));

                //유동자산
                quickAssets = (currentAssets + inventoryAssetsToal);
                quick_assets.setText(format.format(quickAssets));

                // 자산 총계
                assetsToal = (quickAssets);
                Log.d(TAG, "assetsToal: " + assetsToal);
                assets_total.setText(format.format(assetsToal));


                purchaseReceivable = result.getPurchase_receivable();//매입채권(외상매입금)
                vatDeposiT = result.getVatDeposit();//부가세예수금

                purchase_receivable.setText(format.format(purchaseReceivable));
                vatDeposit.setText(format.format(vatDeposiT));
                
                // 유동부채
                quickDept = (purchaseReceivable + vatDeposiT);
                quick_dept.setText(format.format(quickDept));
                // 부채 총계
                deptToal = (purchaseReceivable + vatDeposiT);
                dept_total.setText(format.format(deptToal));

                //<!-- 자    본    총    계(자본금계정 아님) 자본잉여금과 이익잉여금을 포함한 자기자본  -->
                //자본총계 = (자산총계 - 부채총계)
                asset3_sum = (assetsToal - deptToal);
                asset3.setText(format.format(asset3_sum));
                //부채및자본총계(총자본) = (자본총계 + 부채총계)
                asset7_sum = (asset3_sum + deptToal);
                asset7.setText(format.format(asset7_sum));

                capItal = result.getCapital();//자본금
                capital.setText(format.format(capItal));
                capita_total.setText(format.format(capItal));
            }

            @Override
            public void onFailure(Call<FinancialDTO> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}