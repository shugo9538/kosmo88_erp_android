package com.devlee.kosmo88_erp_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.WarehouseDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/*보자...
*태그를 만들었고 (뭐에 쓰는진 모름)
*RecyclerView(View를 사앙속)와 그 하위클래스인 Adapter
* Web 생성
* Call 생성
*
* onCreateView 메소드 오버라이드
*
 */
public class WmsFragment extends Fragment {
    private static final String TAG = WmsFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private WmsFragmentAdapter mAdapter;

    private Web web;
    private Call<List<WarehouseDto>> mcallWms;
    private List<WarehouseDto> list = new ArrayList<>();

    public static WmsFragment newInstance() {
        WmsFragment fragment = new WmsFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    private WmsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.wms_framgent_view, container, false);
        rootView.setTag(TAG);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new WmsFragmentAdapter(rootView.getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();

        return rootView;
    }

    public void loadData() {
        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        mcallWms = mRetrofitAPI.warehouseList();
        mcallWms.enqueue(new Callback<List<WarehouseDto>>() {
            @Override
            public void onResponse(Call<List<WarehouseDto>> call, Response<List<WarehouseDto>> response) {
                List<WarehouseDto> result = response.body();
                mAdapter.setDataSet(result);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<WarehouseDto>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}