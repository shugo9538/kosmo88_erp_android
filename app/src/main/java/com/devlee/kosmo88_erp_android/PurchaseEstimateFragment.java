package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.PurchaseEstimateListViewDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PurchaseEstimateFragment extends Fragment {
    private static final String TAG = PurchaseEstimateFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private PurchaseEstimateFragmentAdapter mAdapter;

    private Web web;
    private Call<List<PurchaseEstimateListViewDTO>> mcallEstimate;
    private List<PurchaseEstimateListViewDTO> list = new ArrayList<>();

    public static PurchaseEstimateFragment newInstance() {
        PurchaseEstimateFragment fragment = new PurchaseEstimateFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private PurchaseEstimateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.purchase_estimate_framgent_view, container, false);
        rootView.setTag(TAG);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PurchaseEstimateFragmentAdapter(rootView.getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallEstimate = mRetrofitAPI.getEstimateList();
        mcallEstimate.enqueue(new Callback<List<PurchaseEstimateListViewDTO>>() {
            @Override
            public void onResponse(Call<List<PurchaseEstimateListViewDTO>> call, Response<List<PurchaseEstimateListViewDTO>> response) {
                List<PurchaseEstimateListViewDTO> result = response.body();
                mAdapter.setDataSet(result);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PurchaseEstimateListViewDTO>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}