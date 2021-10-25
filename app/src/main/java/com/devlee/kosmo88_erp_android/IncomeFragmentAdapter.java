//package com.devlee.kosmo88_erp_android;
//
//import android.content.Context;
//import android.database.DataSetObserver;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Adapter;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.devlee.kosmo88_erp_android.dto.IncomeDTO;
//
//import java.util.List;
//
//import io.reactivex.annotations.NonNull;
//
//public class IncomeFragmentAdapter implements Adapter {
//    private Context context;
//    private IncomeDTO dataSet;
//    Web web = Web.WEB;
//
//    public IncomeFragmentAdapter(Context context, IncomeDTO list) {
//        this.context = context;
//        this.dataSet = list;
//    }
//
//    public void setDataSet(IncomeDTO dataSet) {
//        this.dataSet = dataSet;
//    }
//
//    @Override
//    public void registerDataSetObserver(DataSetObserver observer) {
//
//    }
//
//    @Override
//    public void unregisterDataSetObserver(DataSetObserver observer) {
//
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return 0;
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Nullable
//    @Override
//    public CharSequence[] getAutofillOptions() {
//        return new CharSequence[0];
//    }
//
//    public static class AccountViewHolder {
//        private TextView sales_cost;
//        private TextView basic_product;
//        private TextView current_product;
//        private TextView employee_salary;
//        private TextView employee_benefits;
////        private TextView travel_expenses;
////        private TextView entertainment;
////        private TextView communication_cost;
////        private TextView water_utility_bill;
////        private TextView taxes_and_duties;
////        private TextView paid_rent;
////        private TextView premium;
////        private TextView vehicle_maintenance_cost;
////        private TextView office_supplies;
////        private TextView consumables_cost;
////        private TextView interest_income;
////        private TextView interest_expense;
////        private TextView corporate_tax;
//          private LinearLayout parent;
//
//        public AccountViewHolder(View v) {
//            parent = (LinearLayout) v;
//            sales_cost = v.findViewById(R.id.sales_cost);
//            basic_product = v.findViewById(R.id.basic_product);
//            current_product = v.findViewById(R.id.current_product);
//            employee_salary = v.findViewById(R.id.employee_salary);
//            employee_benefits = v.findViewById(R.id.employee_benefits);
//        }
//
//
//        public TextView getSales_cost() {
//            return sales_cost;
//        }
//
//        public TextView getBasic_product() { return basic_product;}
//
//        public TextView getCurrent_product() {
//            return current_product;
//        }
//
//        public TextView getEmployee_salary() { return employee_salary;}
//
//        public TextView getEmployee_benefits() {
//            return employee_benefits;
//        }
//    }
//
//    @NonNull
//    @Override
//    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new AccountViewHolder(parent.getRootView());
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AccountViewHolder AccountViewHolder, int position) {
//        IncomeDTO dto = dataSet;
//        AccountViewHolder.getSales_cost().setText(dto.getSales_cost()+"");
//        AccountViewHolder.getBasic_product().setText(dto.getBasic_product()+"");
//        AccountViewHolder.getCurrent_product().setText(dto.getCurrent_product()+"");
//        AccountViewHolder.getEmployee_salary().setText(dto.getEmployee_salary()+"");
//        AccountViewHolder.getEmployee_benefits().setText(dto.getEmployee_benefits()+"");
//    }
//}
