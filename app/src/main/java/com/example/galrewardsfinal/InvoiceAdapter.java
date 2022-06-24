package com.example.galrewardsfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.ViewHolder> {

    private Context context;
    private List<OrderInvoice> list;
    private ImageView imageView;

    public InvoiceAdapter(Context context,List<OrderInvoice> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.invoicedetail,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderInvoice orderInvoice = list.get(position);

        holder.invoicenomain.setText(orderInvoice.getInvoiceno());
        holder.invoiceproductname.setText(String.valueOf(orderInvoice.getProductname()));
        holder.invoiceproductpoint.setText(String.valueOf(orderInvoice.getPoints()));
        holder.invoiceproductqty.setText(String.valueOf(orderInvoice.getQty()));
        holder.invoiceproductsubtotal.setText(String.valueOf(orderInvoice.getSubtotal()));
        Picasso.get().load(orderInvoice.getInvoimg()).into(holder.iimg);

        //  holder.textcountry.setText(String.valueOf(category.getCountry()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView invoicenomain,invoiceproductname,invoiceproductpoint,invoiceproductqty,invoiceproductsubtotal;
        public ImageView iimg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            invoicenomain = itemView.findViewById(R.id.main_invoiceno);
            invoiceproductname = itemView.findViewById(R.id.main_invoiceproductname);
            invoiceproductpoint = itemView.findViewById(R.id.main_invoiceproductpoint);
            invoiceproductqty  = itemView.findViewById(R.id.main_invoiceproductqty);
            invoiceproductsubtotal = itemView.findViewById(R.id.main_invoiceproductsubtotal);
            iimg = itemView.findViewById(R.id.main_invoiceimg);

        }
    }
}
