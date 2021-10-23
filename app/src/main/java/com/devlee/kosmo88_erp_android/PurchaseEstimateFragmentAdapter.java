package com.devlee.kosmo88_erp_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.PurchaseEstimateListViewDTO;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class PurchaseEstimateFragmentAdapter extends RecyclerView.Adapter<PurchaseEstimateFragmentAdapter.PurchaseEstimateViewHolder> {
    private Context context;
    private List<PurchaseEstimateListViewDTO> dataSet;
    Web web = Web.WEB;

    public PurchaseEstimateFragmentAdapter(Context context, List<PurchaseEstimateListViewDTO> list) {
        this.context = context;
        this.dataSet = list;
    }

    public void setDataSet(List<PurchaseEstimateListViewDTO> dataSet) {
        this.dataSet = dataSet;
    }

    public static class PurchaseEstimateViewHolder extends RecyclerView.ViewHolder {
        private TextView request_id;
        private TextView client_name;
        private TextView client_ceo_name;
        private TextView client_phone;
        private TextView employee_name;
        private LinearLayout parent;

        public PurchaseEstimateViewHolder(View v) {
            super(v);
            parent = (LinearLayout) v;
            request_id = v.findViewById(R.id.request_id);
            client_name = v.findViewById(R.id.client_name);
            client_ceo_name = v.findViewById(R.id.client_ceo_name);
            client_phone = v.findViewById(R.id.client_phone);
            employee_name = v.findViewById(R.id.employee_name);
            parent = v.findViewById(R.id.parent);
        }

        public TextView getRequest_id() {
            return request_id;
        }

        public TextView getClient_name() {
            return client_name;
        }

        public TextView getClient_ceo_name() {
            return client_ceo_name;
        }

        public TextView getClient_phone() {
            return client_phone;
        }

        public TextView getEmployee_name() {
            return employee_name;
        }

    }

    @NonNull
    @Override
    public PurchaseEstimateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.purchase_estimate_item_layout, parent, false);
        return new PurchaseEstimateViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseEstimateViewHolder purchaseEstimateViewHolder, int position) {
        PurchaseEstimateListViewDTO dto = dataSet.get(position);

        purchaseEstimateViewHolder.getRequest_id().setText(dto.getRequest_id()+"");
        purchaseEstimateViewHolder.getClient_name().setText(dto.getClient_name());
        purchaseEstimateViewHolder.getClient_ceo_name().setText(dto.getClient_ceo_name());
        purchaseEstimateViewHolder.getClient_phone().setText(dto.getClient_phone());
        purchaseEstimateViewHolder.getEmployee_name().setText(dto.getEmployee_name());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
