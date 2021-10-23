package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.SalesEstimateDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SalesEstimateFragment extends Fragment {
    private static final String TAG = SalesEstimateFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private SalesEstimateFragmentAdapter mAdapter;

    private Web web;
    private Call<List<SalesEstimateDTO>> mcallSalesEstimate;
    private List<SalesEstimateDTO> list = new ArrayList<>();

    public static SalesEstimateFragment newInstance() {
        SalesEstimateFragment fragment = new SalesEstimateFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private SalesEstimateFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sales_estimate_fragment_view, container, false);
        rootView.setTag(TAG);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new SalesEstimateFragmentAdapter(rootView.getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallSalesEstimate = mRetrofitAPI.getSalesEstimateList();
        mcallSalesEstimate.enqueue(new Callback<List<SalesEstimateDTO>>() {
            @Override
            public void onResponse(Call<List<SalesEstimateDTO>> call, Response<List<SalesEstimateDTO>> response) {
                List<SalesEstimateDTO> result = response.body();
                mAdapter.setDataSet(result);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SalesEstimateDTO>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
