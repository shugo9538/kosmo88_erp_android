package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.PurchaseItemListViewDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PurchaseItemFragment extends Fragment {
    private static final String TAG = PurchaseItemFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private PurchaseItemFragmentAdapter mAdapter;

    private Web web;
    private Call<List<PurchaseItemListViewDTO>> mcallItem;
    private List<PurchaseItemListViewDTO> list = new ArrayList<>();

    public static PurchaseItemFragment newInstance() {
        PurchaseItemFragment fragment = new PurchaseItemFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private PurchaseItemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.purchase_item_framgent_view, container, false);
        rootView.setTag(TAG);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PurchaseItemFragmentAdapter(rootView.getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallItem = mRetrofitAPI.getItemList();
        mcallItem.enqueue(new Callback<List<PurchaseItemListViewDTO>>() {
            @Override
            public void onResponse(Call<List<PurchaseItemListViewDTO>> call, Response<List<PurchaseItemListViewDTO>> response) {
                List<PurchaseItemListViewDTO> result = response.body();
                mAdapter.setDataSet(result);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PurchaseItemListViewDTO>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}