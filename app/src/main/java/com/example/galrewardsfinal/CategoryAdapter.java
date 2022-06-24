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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
private Context context;
private List<Category> list;

public CategoryAdapter(Context context, List<Category> list) {
        this.context = context;
        this.list = list;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(v);
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {

    Glide.with(context).load(list.get(position).img).into(holder.img);
        Category category = list.get(position);

        holder.textTitle.setText(category.getTitle());
        holder.textRating.setText(String.valueOf(category.getRating()));
        holder.textYear.setText(String.valueOf(category.getYear()));
        holder.textId.setText(String.valueOf(category.getId()));
        holder.textcat.setText(String.valueOf(category.getCatname()));
        holder.textcountry.setText(String.valueOf(category.getCountry()));
        holder.textidpro.setText(String.valueOf(category.getIdpro()));

        Picasso.get().load(category.getImg());

        }

@Override
public int getItemCount() {
        return list.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView textTitle, textRating, textYear,textId,textcat,textcountry,textidpro;
    public ImageView img;

    public ViewHolder(View itemView) {
        super(itemView);

        textTitle = itemView.findViewById(R.id.main_titlepro);
        textRating = itemView.findViewById(R.id.main_ratingpro);
        textYear = itemView.findViewById(R.id.main_yearpro);
        textId = itemView.findViewById(R.id.main_specialpro);
        textcat = itemView.findViewById(R.id.main_catypro);
        textcountry = itemView.findViewById(R.id.main_countrypro);
        img = itemView.findViewById(R.id.main_imgpro);
        textidpro = itemView.findViewById(R.id.main_productid);

    }
}

}
