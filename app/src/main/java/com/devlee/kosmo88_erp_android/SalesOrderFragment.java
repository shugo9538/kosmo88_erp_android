package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.SalesOrderDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SalesOrderFragment extends Fragment {
    private static final String TAG = SalesOrderFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private SalesOrderFragmentAdapter mAdapter;

    private Web web;
    private Call<List<SalesOrderDTO>> mcallSalesOrder;
    private List<SalesOrderDTO> list = new ArrayList<>();

    public static SalesOrderFragment newInstance() {
        SalesOrderFragment fragment = new SalesOrderFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private SalesOrderFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sales_order_fragment_view, container, false);
        rootView.setTag(TAG);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new SalesOrderFragmentAdapter(rootView.getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallSalesOrder = mRetrofitAPI.getSalesOrderList();
        mcallSalesOrder.enqueue(new Callback<List<SalesOrderDTO>>() {
            @Override
            public void onResponse(Call<List<SalesOrderDTO>> call, Response<List<SalesOrderDTO>> response) {
                List<SalesOrderDTO> result = response.body();
                mAdapter.setDataSet(result);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SalesOrderDTO>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
