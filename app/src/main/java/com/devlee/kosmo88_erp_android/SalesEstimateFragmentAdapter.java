package com.devlee.kosmo88_erp_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.SalesEstimateDTO;

import java.util.List;

public class SalesEstimateFragmentAdapter extends RecyclerView.Adapter<SalesEstimateFragmentAdapter.SalesEstimateViewHolder>{
    private Context context;
    private List<SalesEstimateDTO> dataSet;
    Web web = Web.WEB;

    public SalesEstimateFragmentAdapter(Context context, List<SalesEstimateDTO> list) {
        this.context = context;
        this.dataSet = list;
    }
    public void setDataSet(List<SalesEstimateDTO> dataSet) {this.dataSet = dataSet;}

    public static class SalesEstimateViewHolder extends RecyclerView.ViewHolder {
        private TextView request_id;
        private TextView client_name;
        private TextView client_ceo_name;
        private TextView client_phone;
        private TextView employee_name;
        private LinearLayout parent;

        public SalesEstimateViewHolder(View v){
            super(v);
            parent = (LinearLayout) v;
            request_id = v.findViewById(R.id.request_id);
            client_name = v.findViewById(R.id.client_name);
            client_ceo_name = v.findViewById(R.id.client_ceo_name);
            client_phone = v.findViewById(R.id.client_phone);
            employee_name = v.findViewById(R.id.employee_name);
        }

        public TextView getRequest_id() {return request_id;}
        public TextView getClient_name() {return client_name;}
        public TextView getClient_ceo_name() {return client_ceo_name;}
        public TextView getClient_phone() {return client_phone;}
        public TextView getEmployee_name() {return employee_name;}
    }

    @NonNull
    @Override
    public SalesEstimateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_estimate_layout, parent, false);
        return new SalesEstimateFragmentAdapter.SalesEstimateViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesEstimateViewHolder salesEstimateViewHolder, int position) {
        SalesEstimateDTO dto = dataSet.get(position);

        salesEstimateViewHolder.getRequest_id().setText(dto.getRequest_id()+"");
        salesEstimateViewHolder.getClient_name().setText(dto.getClient_name());
        salesEstimateViewHolder.getClient_ceo_name().setText(dto.getClient_ceo_name());
        salesEstimateViewHolder.getClient_phone().setText(dto.getClient_phone());
        salesEstimateViewHolder.getEmployee_name().setText(dto.getEmployee_name());
    }

    @Override
    public int getItemCount() {return dataSet.size();}
}
