package com.example.galrewardsfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<Product> list;
    private ImageView ImageView;



    public ProductAdapter (Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = list.get(position);

        holder.textTitle.setText(product.getCategoriesname());
        holder.textRating.setText(String.valueOf(product.getId()));
        holder.textYear.setText(String.valueOf(product.getCategoriesstatus()));
        holder.textcat.setText(String.valueOf(product.getCatname()));
        holder.textcountry.setText(String.valueOf(product.getCategoriesname()));
        Picasso.get().load(product.getImgcat()).into(holder.catimg);
      //  Picasso.get().load(bestDeal.getImg()).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, textRating, textYear,textcat,textcountry;
        public ImageView catimg;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.main_title);
            textRating = itemView.findViewById(R.id.main_rating);
            textYear = itemView.findViewById(R.id.main_year);
            textcat = itemView.findViewById(R.id.main_caty);
            textcountry = itemView.findViewById(R.id.main_country);
            catimg = itemView.findViewById(R.id.main_img);

        }


    }
}