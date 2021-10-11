package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devlee.kosmo88_erp_android.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EmployeeFragment extends Fragment {
    private static final String TAG = EmployeeFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private EmployeeFragmentAdapter mAdapter;

    private Web web;
    private Call<List<EmployeeDTO>> mcallEmployee;
    private List<EmployeeDTO> list = new ArrayList<>();

    public static EmployeeFragment newInstance() {
        EmployeeFragment fragment = new EmployeeFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private EmployeeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.employee_framgent_view, container, false);
        rootView.setTag(TAG);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new EmployeeFragmentAdapter(rootView.getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallEmployee = mRetrofitAPI.getEmployeeList();
        mcallEmployee.enqueue(new Callback<List<EmployeeDTO>>() {
            @Override
            public void onResponse(Call<List<EmployeeDTO>> call, Response<List<EmployeeDTO>> response) {
                List<EmployeeDTO> result = response.body();
                mAdapter.setDataSet(result);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<EmployeeDTO>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}