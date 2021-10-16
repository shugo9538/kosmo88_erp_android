package com.devlee.kosmo88_erp_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.PurchaseOrderListViewDTO;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class PurchaseOrderFragmentAdapter extends RecyclerView.Adapter<PurchaseOrderFragmentAdapter.PurchaseOrderViewHolder> {
    private Context context;
    private List<PurchaseOrderListViewDTO> dataSet;
    Web web = Web.WEB;

    public PurchaseOrderFragmentAdapter(Context context, List<PurchaseOrderListViewDTO> list) {
        this.context = context;
        this.dataSet = list;
    }

    public void setDataSet(List<PurchaseOrderListViewDTO> dataSet) {
        this.dataSet = dataSet;
    }

    public static class PurchaseOrderViewHolder extends RecyclerView.ViewHolder {
        private TextView request_id;
        private TextView client_name;
        private TextView client_ceo_name;
        private TextView client_phone;
        private TextView employee_name;
        private LinearLayout parent;

        public PurchaseOrderViewHolder(View v) {
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
    public PurchaseOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.purchase_order_item_layout, parent, false);
        return new PurchaseOrderViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseOrderViewHolder purchaseOrderViewHolder, int position) {
        PurchaseOrderListViewDTO dto = dataSet.get(position);

        purchaseOrderViewHolder.getRequest_id().setText(dto.getRequest_id()+"");
        purchaseOrderViewHolder.getClient_name().setText(dto.getClient_name());
        purchaseOrderViewHolder.getClient_ceo_name().setText(dto.getClient_ceo_name());
        purchaseOrderViewHolder.getClient_phone().setText(dto.getClient_phone());
        purchaseOrderViewHolder.getEmployee_name().setText(dto.getEmployee_name());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
