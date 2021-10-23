package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.PurchaseClientDTO;
import com.devlee.kosmo88_erp_android.dto.PurchaseOrderListViewDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PurchaseOrderFragment extends Fragment {
    private static final String TAG = PurchaseOrderFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private PurchaseOrderFragmentAdapter mAdapter;

    private Web web;
    private Call<List<PurchaseOrderListViewDTO>> mcallClient;
    private List<PurchaseOrderListViewDTO> list = new ArrayList<>();

    public static PurchaseOrderFragment newInstance() {
        PurchaseOrderFragment fragment = new PurchaseOrderFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private PurchaseOrderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.purchase_order_framgent_view, container, false);
        rootView.setTag(TAG);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PurchaseOrderFragmentAdapter(rootView.getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallClient = mRetrofitAPI.getOrderList();
        mcallClient.enqueue(new Callback<List<PurchaseOrderListViewDTO>>() {
            @Override
            public void onResponse(Call<List<PurchaseOrderListViewDTO>> call, Response<List<PurchaseOrderListViewDTO>> response) {
                List<PurchaseOrderListViewDTO> result = response.body();
                mAdapter.setDataSet(result);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PurchaseOrderListViewDTO>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}