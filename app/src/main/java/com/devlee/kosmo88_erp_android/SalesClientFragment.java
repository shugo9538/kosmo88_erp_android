package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.SalesClientDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SalesClientFragment extends Fragment {
    private static final String TAG = SalesClientFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private SalesClientFragmentAdapter mAdapter;

    private Web web;
    private Call<List<SalesClientDTO>> mcallSalesClient;
    private List<SalesClientDTO> list = new ArrayList<>();

    public static SalesClientFragment newInstance() {
        SalesClientFragment fragment = new SalesClientFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private SalesClientFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sales_client_fragment_view, container, false);
        rootView.setTag(TAG);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new SalesClientFragmentAdapter(rootView.getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallSalesClient = mRetrofitAPI.getSalesClientList();
        mcallSalesClient.enqueue(new Callback<List<SalesClientDTO>>() {
            @Override
            public void onResponse(Call<List<SalesClientDTO>> call, Response<List<SalesClientDTO>> response) {
                List<SalesClientDTO> result = response.body();
                mAdapter.setDataSet(result);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SalesClientDTO>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
