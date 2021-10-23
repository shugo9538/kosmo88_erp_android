package com.devlee.kosmo88_erp_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.PurchaseEstimateListViewDTO;
import com.devlee.kosmo88_erp_android.dto.PurchaseItemListViewDTO;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class PurchaseItemFragmentAdapter extends RecyclerView.Adapter<PurchaseItemFragmentAdapter.PurchaseItemViewHolder> {
    private Context context;
    private List<PurchaseItemListViewDTO> dataSet;
    Web web = Web.WEB;

    public PurchaseItemFragmentAdapter(Context context, List<PurchaseItemListViewDTO> list) {
        this.context = context;
        this.dataSet = list;
    }

    public void setDataSet(List<PurchaseItemListViewDTO> dataSet) {
        this.dataSet = dataSet;
    }

    public static class PurchaseItemViewHolder extends RecyclerView.ViewHolder {
        private TextView item_id;
        private TextView item_name;
        private TextView item_category;
        private TextView item_price;
        private TextView client_name;
        private TextView client_register_num;
        private LinearLayout parent;

        public PurchaseItemViewHolder(View v) {
            super(v);
            parent = (LinearLayout) v;
            item_id = v.findViewById(R.id.item_id);
            item_name = v.findViewById(R.id.item_name);
            item_category = v.findViewById(R.id.item_category);
            item_price = v.findViewById(R.id.item_price);
            client_name = v.findViewById(R.id.client_name);
            client_register_num = v.findViewById(R.id.client_register_num);
            parent = v.findViewById(R.id.parent);
        }

        public TextView getItem_id() {
            return item_id;
        }

        public TextView getItem_name() {
            return item_name;
        }

        public TextView getItem_category() {
            return item_category;
        }

        public TextView getItem_price() {
            return item_price;
        }

        public TextView getClient_name() {
            return client_name;
        }

        public TextView getClient_register_num() {
            return client_register_num;
        }
    }

    @NonNull
    @Override
    public PurchaseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.purchase_item_item_layout, parent, false);
        return new PurchaseItemViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseItemViewHolder purchaseItemViewHolder, int position) {
        PurchaseItemListViewDTO dto = dataSet.get(position);

        purchaseItemViewHolder.getItem_id().setText(dto.getItem_id()+"");
        purchaseItemViewHolder.getItem_name().setText(dto.getItem_name());
        purchaseItemViewHolder.getItem_category().setText(dto.getItem_category());
        purchaseItemViewHolder.getItem_price().setText(dto.getItem_price()+"");
        purchaseItemViewHolder.getClient_name().setText(dto.getClient_name());
        purchaseItemViewHolder.getClient_name().setText(dto.getClient_name());
        purchaseItemViewHolder.getClient_register_num().setText((dto.getClient_register_num()));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
