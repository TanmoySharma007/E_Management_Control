package com.example.e_management_manager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_management_manager.R;
import com.example.e_management_manager.databinding.RowAccountBinding;
import com.example.e_management_manager.models.Account;

import java.util.ArrayList;

public class AccountsAdapter extends RecyclerView.Adapter<AccountsAdapter.AccountsViewHolder>{
    TextView accountName;
    Context context;
    ArrayList<Account> accountArrayList;

    public interface AccountsClickListener{
        void onAccountSelected(Account account);
    }

    AccountsClickListener accountsClickListener;
    public AccountsAdapter(Context context, ArrayList<Account> accountArrayList,AccountsClickListener accountsClickListener){
        this.context = context;
        this.accountArrayList = accountArrayList;
        this.accountsClickListener = accountsClickListener;
    }



    @NonNull
    @Override
    public AccountsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AccountsViewHolder(LayoutInflater.from(context).inflate(R.layout.row_account,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AccountsViewHolder holder, int position) {
        Account account = accountArrayList.get(position);
        holder.binding.accountName.setText(account.getAccountName());
        holder.itemView.setOnClickListener(c->{
           accountsClickListener.onAccountSelected(account);
        });
    }

    @Override
    public int getItemCount() {
        return accountArrayList.size();
    }

    public class AccountsViewHolder extends RecyclerView.ViewHolder{
        RowAccountBinding binding;
        public AccountsViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RowAccountBinding.bind(itemView);

        }
    }

}
