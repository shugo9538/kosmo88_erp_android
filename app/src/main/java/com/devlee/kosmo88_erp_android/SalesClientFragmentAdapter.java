package com.devlee.kosmo88_erp_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.devlee.kosmo88_erp_android.dto.SalesClientDTO;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class SalesClientFragmentAdapter extends RecyclerView.Adapter<SalesClientFragmentAdapter.SalesClientViewHolder>{
    private Context context;
    private List<SalesClientDTO> dataSet;
    Web web = Web.WEB;

    public SalesClientFragmentAdapter(Context context, List<SalesClientDTO> list) {
        this.context = context;
        this.dataSet = list;
    }
    public void setDataSet(List<SalesClientDTO> dataSet) {this.dataSet = dataSet;}

    public static class SalesClientViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView name;
        private TextView register_num;
        private TextView ceo_name;
        private TextView phone;
        private TextView address;
        //private TextView register_date;
        private LinearLayout parent;

        public SalesClientViewHolder(View v){
            super(v);
            parent = (LinearLayout) v;
            id = v.findViewById(R.id.id);
            name = v.findViewById(R.id.name);
            register_num = v.findViewById(R.id.register_num);
            ceo_name = v.findViewById(R.id.ceo_name);
            phone = v.findViewById(R.id.phone);
            address = v.findViewById(R.id.address);
            //register_date = v.findViewById(R.id.register_date);
        }

        public TextView getId() {return id;}
        public TextView getName() {return name;}
        public TextView getRegister_num() {return register_num;}
        public TextView getCeo_name() {return ceo_name;}
        public TextView getPhone() {return phone;}
        public TextView getAddress() {return address;}
        //public TextView getRegister_date() {return register_date;}
    }

    @NonNull
    @Override
    public SalesClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_client_layout, parent, false);
        return new SalesClientViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesClientViewHolder salesClientViewHolder, int position) {
        SalesClientDTO dto = dataSet.get(position);

        salesClientViewHolder.getId().setText(dto.getId()+"");
        salesClientViewHolder.getName().setText(dto.getName());
        salesClientViewHolder.getRegister_num().setText(dto.getRegister_num());
        salesClientViewHolder.getCeo_name().setText(dto.getCeo_name());
        salesClientViewHolder.getPhone().setText(dto.getPhone());
        salesClientViewHolder.getAddress().setText(dto.getAddress());
        //salesClientViewHolder.getRegister_date().setText((CharSequence) dto.getRegister_date());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
