package com.example.galrewardsfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context context;
    private List<Order> list1;

    public OrderAdapter(Context context, List<Order> list) {
        this.context = context;
        this.list1 = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_itemnew, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Order order = list1.get(position);

        holder.textTitle.setText(order.getInvoiceno());
        holder.textRating.setText(String.valueOf(order.getPoints()));
        holder.textYear.setText(String.valueOf(order.getStatusinv()));

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, textRating, textYear;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.main_title1);
            textRating = itemView.findViewById(R.id.main_rating1);
            textYear = itemView.findViewById(R.id.main_year1);
        }

    }}

