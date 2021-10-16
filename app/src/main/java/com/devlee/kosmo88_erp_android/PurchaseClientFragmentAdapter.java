package com.devlee.kosmo88_erp_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.PurchaseClientDTO;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class PurchaseClientFragmentAdapter extends RecyclerView.Adapter<PurchaseClientFragmentAdapter.PurchaseClientViewHolder> {
    private Context context;
    private List<PurchaseClientDTO> dataSet;
    Web web = Web.WEB;

    public PurchaseClientFragmentAdapter(Context context, List<PurchaseClientDTO> list) {
        this.context = context;
        this.dataSet = list;
    }

    public void setDataSet(List<PurchaseClientDTO> dataSet) {
        this.dataSet = dataSet;
    }

    public static class PurchaseClientViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView name;
        private TextView register_num;
        private TextView ceo_name;
        private TextView phone;
        private TextView address;
        private LinearLayout parent;

        public PurchaseClientViewHolder(View v) {
            super(v);
            parent = (LinearLayout) v;
            id = v.findViewById(R.id.id);
            name = v.findViewById(R.id.name);
            register_num = v.findViewById(R.id.register_num);
            ceo_name = v.findViewById(R.id.ceo_name);
            phone = v.findViewById(R.id.phone);
            address = v.findViewById(R.id.address);
            parent = v.findViewById(R.id.parent);
        }

        public TextView getId() {
            return id;
        }

        public TextView getName() {
            return name;
        }

        public TextView getRegister_num() {
            return register_num;
        }

        public TextView getCeo_name() {
            return ceo_name;
        }

        public TextView getPhone() {
            return phone;
        }

        public TextView getAddress() {
            return address;
        }

    }

    @NonNull
    @Override
    public PurchaseClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.purchase_client_item_layout, parent, false);
        return new PurchaseClientViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseClientViewHolder clientViewHolder, int position) {
        PurchaseClientDTO dto = dataSet.get(position);

        clientViewHolder.getId().setText(dto.getId()+"");
        clientViewHolder.getName().setText(dto.getName());
        clientViewHolder.getRegister_num().setText(dto.getRegister_num());
        clientViewHolder.getCeo_name().setText(dto.getCeo_name());
        clientViewHolder.getPhone().setText(dto.getPhone());
        clientViewHolder.getAddress().setText(dto.getAddress());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
