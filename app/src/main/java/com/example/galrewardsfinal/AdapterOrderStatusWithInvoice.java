package com.example.galrewardsfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterOrderStatusWithInvoice extends RecyclerView.Adapter<AdapterOrderStatusWithInvoice.ViewHolder>  {
    private Context contextinvoice;
    private List<JavaClassOrderStatusWithInvoice>javaClassOrderStatusWithInvoices;

    public AdapterOrderStatusWithInvoice(Context context, List<JavaClassOrderStatusWithInvoice> javaClassOrderStatusWithInvoices) {
        this.contextinvoice = context;
        this.javaClassOrderStatusWithInvoices = javaClassOrderStatusWithInvoices;
    }

    @Override
    public AdapterOrderStatusWithInvoice.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contextinvoice).inflate(R.layout.orderinvoicestatusxml, parent, false);
        return new AdapterOrderStatusWithInvoice.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterOrderStatusWithInvoice.ViewHolder holder, int position) {
        JavaClassOrderStatusWithInvoice dynamicOrderStatusWithInvoice = javaClassOrderStatusWithInvoices.get(position);

        //  holder.textdate.setText(ticketList.getTicketdate());
        holder.textproductname.setText(String.valueOf(dynamicOrderStatusWithInvoice.getProductname()));
        holder.textorderstatus.setText(String.valueOf(dynamicOrderStatusWithInvoice.getOrderStatus()));
        holder.textordernumber.setText(String.valueOf(dynamicOrderStatusWithInvoice.getOrderNumber()));


    }

    @Override
    public int getItemCount() {
        return javaClassOrderStatusWithInvoices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textproductname, textorderstatus, textdate, textordernumber, texttxtview;

        public ViewHolder(View itemView) {
            super(itemView);

            textproductname = itemView.findViewById(R.id.invoiceproductname);
            textorderstatus = itemView.findViewById(R.id.invoiceproductstatus);
            // textdate = itemView.findViewById(R.id.ticktdate);
            textordernumber = itemView.findViewById(R.id.invoiceordernumber);
            //    texttxtview = itemView.findViewById(R.id.ticktview);

        }
    }
    }
