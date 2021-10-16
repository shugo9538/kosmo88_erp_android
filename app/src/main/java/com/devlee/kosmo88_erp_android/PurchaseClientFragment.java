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
import com.devlee.kosmo88_erp_android.dto.PurchaseEstimateListViewDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PurchaseClientFragment extends Fragment {
    private static final String TAG = PurchaseClientFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private PurchaseClientFragmentAdapter mAdapter;

    private Web web;
    private Call<List<PurchaseClientDTO>> mcallClient;
    private List<PurchaseClientDTO> list = new ArrayList<>();

    public static PurchaseClientFragment newInstance() {
        PurchaseClientFragment fragment = new PurchaseClientFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private PurchaseClientFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.purchase_client_framgent_view, container, false);
        rootView.setTag(TAG);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PurchaseClientFragmentAdapter(rootView.getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallClient = mRetrofitAPI.getClientList();
        mcallClient.enqueue(new Callback<List<PurchaseClientDTO>>() {
            @Override
            public void onResponse(Call<List<PurchaseClientDTO>> call, Response<List<PurchaseClientDTO>> response) {
                List<PurchaseClientDTO> result = response.body();
                mAdapter.setDataSet(result);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PurchaseClientDTO>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}