package com.example.e_management_manager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_management_manager.R;
import com.example.e_management_manager.databinding.RowTransactionsBinding;
import com.example.e_management_manager.models.Transaction;
import com.example.e_management_manager.utils.Constants;
import com.example.e_management_manager.utils.Helper;

import java.util.ArrayList;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>  {

    Context context;
    ArrayList<Transaction> transactions;

    public TransactionsAdapter(Context context, ArrayList<Transaction> transactions) {
        this.context = context;
        this.transactions = transactions;
    }
    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionViewHolder(LayoutInflater.from(context).inflate(R.layout.row_transactions, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
         Transaction transaction = transactions.get(position);

         holder.binding.transactionAmount.setText(String.valueOf(transaction.getAmount()));
         holder.binding.accountLbl.setText(transaction.getAccount());

        holder.binding.transactionsDate.setText(Helper.formatDate(transaction.getDate()));
        holder.binding.transactionCategory.setText(transaction.getCategory());

          if (transaction.getType().equals(Constants.INCOME)){
              holder.binding.transactionAmount.setTextColor(context.getColor(R.color.greenColor));
          } else if (transaction.getType().equals(Constants.EXPENSE)) {
              holder.binding.transactionAmount.setTextColor(context.getColor(R.color.redColor));
          }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder{

        RowTransactionsBinding binding;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RowTransactionsBinding.bind(itemView);
        }
    }
}
