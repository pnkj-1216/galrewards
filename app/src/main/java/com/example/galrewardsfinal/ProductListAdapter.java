package com.example.galrewardsfinal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.util.List;

public class ProductListAdapter extends ArrayAdapter<ProductNew> {

    private Context context;
    private List<ProductNew> products;
    private int position;

    public ProductListAdapter(Context context, List<ProductNew> products){
        super(context,R.layout.product_list_layout,products);
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int Position, @Nullable View view, @NonNull ViewGroup parent){
        try {
            ViewHolder viewHolder;
            if(view == null){
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                view = layoutInflater.inflate(R.layout.product_list_layout,parent,false);
                viewHolder = new ViewHolder();
                viewHolder.textViewName = view.findViewById(R.id.textViewName);
                viewHolder.textViewPrice = view.findViewById(R.id.textViewPrice);
                viewHolder.imageViewPhoto = view.findViewById(R.id.imageViewPhoto);
                viewHolder.imageButtonBuyNow = view.findViewById(R.id.imageButtonBuyNow);
                viewHolder.buttonDetail = view.findViewById(R.id.buttonDetail);

                final ProductNew productNew = products.get(position);
                viewHolder.textViewPrice.setText(String.valueOf(productNew.getPrice()));
                viewHolder.textViewName.setText(productNew.getName());
                Bitmap photo = new ImageRequestAsk().execute(productNew.getPhoto()).get();
                viewHolder.imageViewPhoto.setImageBitmap(photo);
                // viewHolder.buttonDetail.setOnClickListener(new View.OnClickListener() {
                //  @Override

                viewHolder.imageButtonBuyNow.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {


                        Intent intent = new Intent(context, CartActivity.class);
                        intent.putExtra("product", productNew);
                        context.startActivity(intent);
                    }});

                //Toast.makeText(getContext(), "Buy:" + product.getName(), Toast.LENGTH_SHORT).show();


                view.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) view.getTag();
            }
            return view;

        }
        catch (Exception e) {
            return null;
        }
    }

    private static class ViewHolder{
        TextView textViewName;
        TextView textViewPrice;
        ImageView imageViewPhoto;
        ImageButton imageButtonBuyNow;
        Button buttonDetail;


    }

    public static class ImageRequestAsk extends AsyncTask<String,Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                InputStream inputStream  = new java.net.URL(params[0]).openStream();
                return BitmapFactory.decodeStream(inputStream);

            } catch (Exception e) {
                return null;
            }
        }


        @Override
        protected void onPostExecute(Bitmap bitmap){
            super.onPostExecute(bitmap);
        }
    }

}
