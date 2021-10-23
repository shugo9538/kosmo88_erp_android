package com.devlee.kosmo88_erp_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.WarehouseDto;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class WmsFragmentAdapter extends RecyclerView.Adapter<WmsFragmentAdapter.WmsViewHolder> {
    private Context context;
    private List<WarehouseDto> dataSet;
    Web web = Web.WEB;

    public WmsFragmentAdapter(Context context, List<WarehouseDto> list) {
        this.context = context;
        this.dataSet = list;
    }

    public void setDataSet(List<WarehouseDto> dataSet) {
        this.dataSet = dataSet;
    }

    public static class WmsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView address;
        private TextView section_count;
        private TextView stock_count;
        private TextView capacity_sum;
        private TextView count_sum;
        private LinearLayout parent;

        public WmsViewHolder(View v) {
            super(v);
            parent = (LinearLayout) v;
            name = v.findViewById(R.id.name);
            address = v.findViewById(R.id.address);
//            section_count = v.findViewById(R.id.section_count);
//            stock_count = v.findViewById(R.id.stock_count);
//            capacity_sum = v.findViewById(R.id.capacity_sum);
//            count_sum = v.findViewById(R.id.count_sum);
            section_count = v.findViewById(R.id.section_count);
            stock_count = v.findViewById(R.id.stock_count);
            capacity_sum = v.findViewById(R.id.capacity_sum);
            count_sum = v.findViewById(R.id.count_sum);
        }



        public TextView getName() {
            return name;
        }
        public TextView getAddress() {
            return address;
        }
        public TextView getSection_count() {
            return section_count;
        }
        public TextView getStock_count() { return stock_count; }
        public TextView getCapacity_sum() {
            return capacity_sum;
        }
        public TextView getCount_sum() {
            return count_sum;
        }
    }

    @NonNull
    @Override
    public WmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wms_item_layout, parent, false);
        return new WmsViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull WmsViewHolder wmsViewHolder, int position) {
        WarehouseDto dto = dataSet.get(position);

        wmsViewHolder.getName().setText(dto.getName());
        wmsViewHolder.getAddress().setText(dto.getAddress());
        wmsViewHolder.getSection_count().setText("" + dto.getSection_count());
        wmsViewHolder.getStock_count().setText("" +dto.getStock_count());
        wmsViewHolder.getCapacity_sum().setText("" +dto.getCapacity_sum());
        wmsViewHolder.getCount_sum().setText("" +dto.getCount_sum());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
