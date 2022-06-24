package com.example.galrewardsfinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TicketListAdapter extends RecyclerView.Adapter<TicketListAdapter.ViewHolder> {
    private Context contextticket;
    private List<TicketList> listticket;
    private Button btnticketview;




    public TicketListAdapter(Context contextticket, List<TicketList> listticket) {
        this.contextticket = contextticket;
        this.listticket = listticket;


    }

    @Override
    public TicketListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contextticket).inflate(R.layout.single_ticketlist, parent, false);
        return new TicketListAdapter.ViewHolder(v);


    }

    @Override
    public void onBindViewHolder(TicketListAdapter.ViewHolder holder, int position) {
        TicketList ticketList = listticket.get(position);

      //  holder.textdate.setText(ticketList.getTicketdate());
        holder.textneedassistance.setText(String.valueOf(ticketList.getNeedassistance()));
        holder.textcomment.setText(String.valueOf(ticketList.getComment()));
        holder.textstatus.setText(String.valueOf(ticketList.getStatus()));




    }

    @Override
    public int getItemCount() {
        return listticket.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textneedassistance, textcomment, textdate,textstatus,texttxtview;

        public ViewHolder(View itemView) {
            super(itemView);

            textneedassistance = itemView.findViewById(R.id.ticktneedassistance);
            textcomment = itemView.findViewById(R.id.ticketcomment);
           // textdate = itemView.findViewById(R.id.ticktdate);
            textstatus = itemView.findViewById(R.id.ticketstatus);
        //    texttxtview = itemView.findViewById(R.id.ticktview);



        }

    }
}
