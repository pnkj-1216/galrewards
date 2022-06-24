package com.example.galrewardsfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {

    private Context context;
    private List<Account> listaccount;

    public AccountAdapter(Context context, List<Account> listaccount) {
        this.context = context;
        this.listaccount = listaccount;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_itemaccount, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Account account = listaccount.get(position);

      //  holder.txtBonusPoint.setText(account.getBonuspoint());
       // holder.txtMonthlyPoint.setText(account.getMonthlypoint());
       // holder.txtOrderPoint.setText(account.getOrderpoint());
      //  holder.txtclosingBalance.setText(account.getClosingbalance());

    }

    @Override
    public int getItemCount() {
        return listaccount.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtBonusPoint, txtMonthlyPoint, txtOrderPoint, txtclosingBalance;

        public ViewHolder(View itemView) {
            super(itemView);

            txtBonusPoint = itemView.findViewById(R.id.etaccountbonuspoint);
            txtMonthlyPoint = itemView.findViewById(R.id.etmonthlyaddedpoints);
            txtOrderPoint = itemView.findViewById(R.id.etorderpoints);
            txtclosingBalance = itemView.findViewById(R.id.etclosingbalance);

        }

    }
}