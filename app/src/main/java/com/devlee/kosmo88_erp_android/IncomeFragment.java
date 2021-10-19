package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.IncomeDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IncomeFragment extends Fragment {
    private static final String TAG = IncomeFragment.class.getSimpleName();
//    private RecyclerView mRecyclerView;
//    private IncomeFragmentAdapter mAdapter;
    
    private TextView sales_cost_sum; // Ⅰ . 매 출 액
    private TextView sales_cost;  //상품매출
    private long salesSum;
    private long salesCost;

    private TextView basic_product; //기초상품재고액
    private TextView current_product; //당기상품매입액
    private TextView end_product; //기말상품재고액
    private long basic;
    private long current;
    private long end;

    private TextView sales_cost_total;  // Ⅲ . 매 출 총 이 익
    private long salesTotal;

    // Ⅳ . 판 매 관 리 비
    private TextView sales_expenses;
    private long salesExpenses;

    // 판매관리비
    private TextView employee_salary;
    private long employeeSalary;
    private TextView employee_benefits;
    private long employeeBenefits;
    private TextView travel_expenses;
    private long travelExpenses;
    private TextView entertainment;
    private long entertainmentTotal;
    private TextView communication_cost;
    private long communicationCost;
    private TextView water_utility_bill;
    private long waterUtilityBill;
    private TextView taxes_and_duties;
    private long taxesAndDuties;
    private TextView paid_rent;
    private long paidRent;
    private TextView premium;
    private long preiumTotal;
    private TextView vehicle_maintenance_cost;
    private long vehicleMaintenanceCost;
    private TextView office_supplies;
    private long officeSupplies;
    private TextView consumables_cost;
    private long consumablesCost;


    //영업이익
    private TextView sales_income;
    private long salesIncome;

    //Ⅵ . 영 업 외 수 익
    private TextView interest_interest_income_total;
    private long interestIncomeTotal;
    //영업외수익
    private TextView interest_income;
    private long interestIncome;

    // Ⅶ . 영 업 외 비 용
    private TextView interest_expense_total;
    private long getInterestExpenseTotal;
    //영업외비용
    private TextView interest_expense;
    private long interestExpense;

    // Ⅷ . 법인세비용차감전순이익
    private TextView net_income_before_tax;
    private long netIncomeBeforeTax;

    // Ⅸ . 법 인 세 비 용
    private TextView corporate_tax;
    private long corporateTax;

    // Ⅹ . 당 기 순 이 익
    private TextView net_income;
    private long netIncome;


    private Web web;
    private Call<IncomeDTO> mcallAccount;
    //private IncomeDTO list = new ArrayList<>();

    public static IncomeFragment newInstance() {
        IncomeFragment fragment = new IncomeFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private IncomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.income_item_layout, container, false);
        rootView.setTag(TAG);

        sales_cost_sum = rootView.findViewById(R.id.sales_cost_sum);
        sales_cost = rootView.findViewById(R.id.sales_cost);

        basic_product = rootView.findViewById(R.id.basic_product);
        current_product = rootView.findViewById(R.id.current_product);
        end_product = rootView.findViewById(R.id.end_product);
        sales_cost_total = rootView.findViewById(R.id.sales_cost_total);
        employee_salary = rootView.findViewById(R.id.employee_salary);
        employee_benefits = rootView.findViewById(R.id.employee_benefits);

        travel_expenses = rootView.findViewById(R.id.travel_expenses);
        entertainment = rootView.findViewById(R.id.entertainment);
        water_utility_bill = rootView.findViewById(R.id.water_utility_bill);
        office_supplies = rootView.findViewById(R.id.office_supplies);
        consumables_cost = rootView.findViewById(R.id.consumables_cost);
        sales_expenses = rootView.findViewById(R.id.sales_expenses);

        taxes_and_duties = rootView.findViewById(R.id.taxes_and_duties);

        communication_cost = rootView.findViewById(R.id.communication_cost);
        paid_rent = rootView.findViewById(R.id.paid_rent);
        premium = rootView.findViewById(R.id.premium);
        vehicle_maintenance_cost = rootView.findViewById(R.id.vehicle_maintenance_cost);

        interest_interest_income_total = rootView.findViewById(R.id.interest_interest_income_total);
        interest_income = rootView.findViewById(R.id.interest_income);

        interest_expense = rootView.findViewById(R.id.interest_expense);
        interest_expense_total = rootView.findViewById(R.id.interest_expense_total);

        corporate_tax = rootView.findViewById(R.id.corporate_tax);


        // Ⅴ . 영 업 이 익
        sales_income = rootView.findViewById(R.id.sales_income);
        // Ⅷ . 법인세비용차감전순이익
        net_income_before_tax = rootView.findViewById(R.id.net_income_before_tax);
        // Ⅸ . 법 인 세 비 용
        corporate_tax = rootView.findViewById(R.id.corporate_tax);
        // Ⅹ . 당 기 순 이 익
        net_income = rootView.findViewById(R.id.net_income);


//        mRecyclerView = rootView.findViewById(R.id.recyclerview);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
//        mRecyclerView.setLayoutManager(layoutManager);
//        mAdapter = new IncomeFragmentAdapter(rootView.getContext(), list);
//        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallAccount = mRetrofitAPI.getIncomeSatement();
        mcallAccount.enqueue(new Callback<IncomeDTO>() {
            @Override
            public void onResponse(Call<IncomeDTO> call, Response<IncomeDTO> response) {
                IncomeDTO result = response.body();
                DecimalFormat format = new DecimalFormat("###,###,###,###");

                // Ⅰ . 매 출 액
                salesCost = result.getSales_cost();
                sales_cost_sum.setText(format.format(salesCost));
                // 상 품 매 출
                sales_cost.setText(format.format(salesCost));

                // 상 품 매 출 원 가
                // 기말상품 재고액 계산
                basic = result.getBasic_product();
                current = result.getCurrent_product();
                end = (basic + current);

                // 기초상품재고액
                basic_product.setText(format.format(basic));
                // 당기상품매입액
                current_product.setText(format.format(current));
                // 기말상품재고액
                end_product.setText(format.format(end));

                // Ⅲ . 매 출 총 이 익
                sales_cost_total.setText(format.format(salesCost));

                // Ⅳ . 판 매 관 리 비
                employeeSalary = result.getEmployee_salary(); //직원급여
                employeeBenefits = result.getEmployee_benefits(); //복리후생비
                travelExpenses = result.getTravel_expenses(); //여비교통비
                entertainmentTotal =  result.getEntertainment(); // 접대비

                employee_salary.setText(format.format(employeeSalary));
                employee_benefits.setText(format.format(employeeBenefits));
                travel_expenses.setText(format.format(travelExpenses));
                entertainment.setText(format.format(entertainmentTotal));

                waterUtilityBill = result.getWater_utility_bill(); //수도광열비
                water_utility_bill.setText(format.format(waterUtilityBill));

                officeSupplies = result.getOffice_supplies(); //사무용품비
                office_supplies.setText(format.format(officeSupplies));

                consumablesCost = result.getConsumables_cost(); //소모품비
                consumables_cost.setText(format.format(consumablesCost));

                communicationCost = result.getCommunication_cost(); //통신비
                taxesAndDuties = result.getTaxes_and_duties();  //세금과공과금
                paidRent = result.getPaid_rent();   //지급임차료
                preiumTotal = result.getPremium();  //보험료
                vehicleMaintenanceCost = result.getVehicle_maintenance_cost(); //차량유지비


                taxes_and_duties.setText(format.format(taxesAndDuties));
                communication_cost.setText(format.format(communicationCost));
                paid_rent.setText(format.format(paidRent));
                premium.setText(format.format(preiumTotal));
                vehicle_maintenance_cost.setText(format.format(vehicleMaintenanceCost));


                // 판매관리비 합
                salesExpenses = (employeeSalary + employeeBenefits + travelExpenses + entertainmentTotal +
                        waterUtilityBill + officeSupplies + consumablesCost +communicationCost + taxesAndDuties +
                        paidRent +  preiumTotal + vehicleMaintenanceCost);
                sales_expenses.setText(format.format(salesExpenses));

                // Ⅴ . 영 업 이 익
                salesIncome = (salesCost - salesExpenses);
                sales_income.setText(format.format(salesIncome));


                // 이자수익
                interestIncome = result.getInterest_income();
                interest_income.setText(format.format(interestIncome));
                //Ⅵ . 영 업 외 수 익
                interestIncomeTotal = (interestIncome);
                interest_interest_income_total.setText(format.format(interestIncomeTotal));

                // 이자비용
                interestExpense = result.getInterest_expense();
                interest_expense.setText(format.format(interestExpense));
                // Ⅶ . 영 업 외 비 용
                interestIncomeTotal = (interestExpense);
                interest_interest_income_total.setText(format.format(interestIncomeTotal));


                // Ⅷ . 법인세비용차감전순이익
                netIncomeBeforeTax = (salesIncome + interestIncome - interestExpense);
                net_income_before_tax.setText(format.format(netIncomeBeforeTax));

                // Ⅸ . 법 인 세 비 용
                corporateTax = result.getCorporate_tax();
                corporate_tax.setText(format.format(corporateTax));
                
                interest_income.setText(format.format(interestIncome));
                interest_expense.setText(format.format(interestExpense));
                corporate_tax.setText(format.format(corporateTax));

                // Ⅹ . 당 기 순 이 익
                netIncome = (netIncomeBeforeTax - corporateTax);
                net_income.setText(format.format(netIncome));


            }

            @Override
            public void onFailure(Call<IncomeDTO> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}