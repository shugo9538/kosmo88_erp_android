package com.devlee.kosmo88_erp_android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.LayoutInflater;

import com.devlee.kosmo88_erp_android.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class EmployeeFragmentAdapter extends RecyclerView.Adapter<EmployeeFragmentAdapter.EmployeeViewHolder> {
    private Context context;
    private List<EmployeeDTO> dataSet;
    Web web = Web.WEB;

    public EmployeeFragmentAdapter(Context context, List<EmployeeDTO> list) {
        this.context = context;
        this.dataSet = list;
    }

    public void setDataSet(List<EmployeeDTO> dataSet) {
        this.dataSet = dataSet;
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private ImageView photo;
        private TextView id;
        private TextView name;
        private TextView phone;
        private TextView email;
        private TextView position_id;
        private LinearLayout parent;

        public EmployeeViewHolder(View v) {
            super(v);
            parent = (LinearLayout) v;
            photo = v.findViewById(R.id.photo);
            id = v.findViewById(R.id.id);
            name = v.findViewById(R.id.name);
            phone = v.findViewById(R.id.phone);
            email = v.findViewById(R.id.email);
            position_id = v.findViewById(R.id.position_id);
        }

        public ImageView getPhoto() {
            return photo;
        }

        public TextView getId() {
            return id;
        }

        public TextView getName() {
            return name;
        }

        public TextView getPhone() {
            return phone;
        }

        public TextView getEmail() {
            return email;
        }

        public TextView getPosition_id() {
            return position_id;
        }
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_item_layout, parent, false);
        return new EmployeeViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int position) {
        Log.d("여기서 데이터가 바인딩 되야하는데", "왜 안됨?");
        EmployeeDTO dto = dataSet.get(position);

        ImageLoadTask task = new ImageLoadTask(web.getServletURL() + dto.getPhoto(), employeeViewHolder.photo);
        employeeViewHolder.getId().setText(dto.getId());
        employeeViewHolder.getName().setText(dto.getName());
        employeeViewHolder.getPhone().setText(dto.getPhone());
        employeeViewHolder.getEmail().setText(dto.getEmail());
        employeeViewHolder.getPosition_id().setText(dto.getPosition_id()+"");
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
