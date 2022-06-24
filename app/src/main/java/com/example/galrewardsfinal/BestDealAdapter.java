package com.example.galrewardsfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BestDealAdapter extends RecyclerView.Adapter<BestDealAdapter.ViewHolder> {
    private Context context;
    private List<BestDeal> list;
    private ImageView ImageView;

    public BestDealAdapter(Context context, List<BestDeal> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_bestseal, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BestDeal bestDeal = list.get(position);


        holder.textTitlebest.setText(bestDeal.getProductname());
        holder.textRatingbest.setText(String.valueOf(bestDeal.getPoints()));
        Picasso.get().load(bestDeal.getImg()).into(holder.img);
            //Glide.with(holder.img.getContext()).load("http://mygalrewards.com/galrewards/public/upload/products/thambnail/"+holder.img[position].getImage()).into(holder.img);
            // holder.textYear.setText(String.valueOf(movie.getYear()));
        //  holder.textId.setText(String.valueOf(movie.getId()));
        // holder.textcat.setText(String.valueOf(movie.getCatname()));
        // holder.textcountry.setText(String.valueOf(movie.getCountry()));

        //Picasso.get().load(bestDeal.getImg());

        //Picasso.get().load(bestDeal.getImg()).into(ImageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitlebest, textRatingbest, textYearbest,textIdbest,textcatbest,textcountrybest;
        public ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitlebest = itemView.findViewById(R.id.main_titlebest);
            textRatingbest = itemView.findViewById(R.id.main_ratingbest);
            textYearbest = itemView.findViewById(R.id.main_yearbest);
            textIdbest = itemView.findViewById(R.id.main_specialbest);
            textcatbest = itemView.findViewById(R.id.main_catybest);
            textcountrybest = itemView.findViewById(R.id.main_countrybest);
            img = itemView.findViewById(R.id.main_imgbest);

        }
    }
}
