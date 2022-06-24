package com.example.galrewardsfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private Context context;
    private List<Profile> list;

    public ProfileAdapter(Context context, List<Profile> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_profile, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Profile profile = list.get(position);

        holder.firstname.setText(profile.getFirstname());
        holder.lastname.setText(String.valueOf(profile.getLastname()));
        holder.email.setText(String.valueOf(profile.getEmail()));
        holder.textpcc.setText(String.valueOf(profile.getPcc()));
        holder.textsignon.setText(String.valueOf(profile.getSignon()));
        holder.country.setText(String.valueOf(profile.getCountry()));
        holder.dob.setText(String.valueOf(profile.getDob()));
     //   holder.textRating.setText(String.valueOf(profile.getRating()));
        holder.number.setText(String.valueOf(profile.getNumber()));
        holder.agencyname.setText(String.valueOf(profile.getAgencyname()));

        //  Picasso.get().load(movie.getImg());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstname,lastname,email,textpcc, textsignon,country,dob, number,agencyname ;
        public ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            firstname = itemView.findViewById(R.id.main_firstname);
            lastname = itemView.findViewById(R.id.main_lastname);
            email = itemView.findViewById(R.id.main_email);
            textpcc = itemView.findViewById(R.id.main_pcc);
            textsignon = itemView.findViewById(R.id.main_signon);
            country = itemView.findViewById(R.id.main_country);
            dob = itemView.findViewById(R.id.main_dob);
            number = itemView.findViewById(R.id.main_contact);
            agencyname = itemView.findViewById(R.id.main_agencyname);

            //textRating = itemView.findViewById(R.id.main_ratingpro);


        }
    }}