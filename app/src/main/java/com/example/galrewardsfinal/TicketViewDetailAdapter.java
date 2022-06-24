package com.example.galrewardsfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TicketViewDetailAdapter extends RecyclerView.Adapter<TicketViewDetailAdapter.ViewHolder> {

    private Context contextticketview;
    private List<TicketViewDetail> ticketViewDetails;

    public TicketViewDetailAdapter(Context contextticketview, List<TicketViewDetail> ticketViewDetail){
        this.contextticketview = contextticketview;
        this.ticketViewDetails = ticketViewDetail;
    }

    @Override
    public TicketViewDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contextticketview).inflate(R.layout.single_ticketlistdetail, parent, false);
        return new TicketViewDetailAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TicketViewDetailAdapter.ViewHolder holder, int position) {
        TicketViewDetail ticketViewDetail = ticketViewDetails.get(position);

        holder.textdateview.setText(String.valueOf(ticketViewDetail.getDte()));
        holder.textneedassistanceview.setText(String.valueOf(ticketViewDetail.getNedassistance()));
        holder.textcommentview.setText(String.valueOf(ticketViewDetail.getComent()));
        holder.textstatusview.setText(String.valueOf(ticketViewDetail.getStaus()));


    }

    @Override
    public int getItemCount() {
        return ticketViewDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textneedassistanceview, textcommentview, textdateview,textstatusview,texttxtview;

        public ViewHolder(View itemView) {
            super(itemView);

            textneedassistanceview = itemView.findViewById(R.id.ticktneedassistanceview);
            textcommentview = itemView.findViewById(R.id.ticktcommentview);
             textdateview = itemView.findViewById(R.id.ticktdateview);
            textstatusview = itemView.findViewById(R.id.ticktstatusview);
            //    texttxtview = itemView.findViewById(R.id.ticktview);

        }}}





