package com.example.e_management_manager.views.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.e_management_manager.R;
import com.example.e_management_manager.adapters.AccountsAdapter;
import com.example.e_management_manager.adapters.CategoryAdapter;
import com.example.e_management_manager.databinding.FragmentAddTransactionBinding;
import com.example.e_management_manager.databinding.ListDialogueBinding;
import com.example.e_management_manager.models.Account;
import com.example.e_management_manager.models.Category;
import com.example.e_management_manager.utils.Constants;
import com.example.e_management_manager.utils.Helper;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class AddTransactionFragment extends BottomSheetDialogFragment {

    CategoryAdapter categoryAdapter;
    public AddTransactionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

        FragmentAddTransactionBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddTransactionBinding.inflate(inflater);

        binding.incomeBtn.setOnClickListener(v -> {

            binding.incomeBtn.setBackground(getContext().getDrawable(R.drawable.income_selector));
            binding.expenseBtn.setBackground(getContext().getDrawable(R.drawable.default_selector));
            binding.expenseBtn.setTextColor(getContext().getColor(R.color.textColor));
            binding.incomeBtn.setTextColor(getContext().getColor(R.color.greenColor));

        });

        binding. expenseBtn.setOnClickListener(v -> {

            binding.incomeBtn.setBackground(getContext().getDrawable(R.drawable.default_selector));
            binding.expenseBtn.setBackground(getContext().getDrawable(R.drawable.expense_selector));
            binding.incomeBtn.setTextColor(getContext().getColor(R.color.textColor));
            binding.expenseBtn.setTextColor(getContext().getColor(R.color.redColor));

        });
            binding.date.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(getContext());

                    datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

                            Calendar calendar = Calendar.getInstance();
                            calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                            calendar.set(Calendar.MONTH, datePicker.getMonth());
                            calendar.set(Calendar.YEAR, datePicker.getYear());

                            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
                            String dateToShow = Helper.formatDate(calendar.getTime());

                            binding.date.setText(dateToShow);
                        }
                    });
                    datePickerDialog.show();
                }
            });

            binding.category.setOnClickListener((View v) -> {
                ListDialogueBinding dialogueBinding = ListDialogueBinding.inflate(inflater);
                AlertDialog categoryDialog = new AlertDialog.Builder(getContext()).create();
                categoryDialog .setView(dialogueBinding.getRoot());



               categoryAdapter = new CategoryAdapter(getContext(), Constants.categories, new CategoryAdapter.CategoryClickListener() {
                    @Override
                    public void onCategoryClicked(Category category) {
                        binding.category.setText(category.getCategoryName());
                        categoryDialog.dismiss();

                    }

                });



                dialogueBinding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                dialogueBinding.recyclerView.setAdapter(categoryAdapter);

                categoryDialog.show();

            });
                binding.account.setOnClickListener((View c) ->{
                ListDialogueBinding dialogueBinding = ListDialogueBinding.inflate(inflater);
                AlertDialog accountsDialog = new AlertDialog.Builder(getContext()).create();
                accountsDialog .setView(dialogueBinding.getRoot());

                ArrayList<Account>accounts = new ArrayList<>();
                accounts.add(new Account(0,"Cash"));
                accounts.add(new Account(0,"Bank"));
                accounts.add(new Account(0,"Nagad"));
                accounts.add(new Account(0,"BKash"));
                accounts.add(new Account(0,"Other"));

                AccountsAdapter adapter = new AccountsAdapter(getContext(), accounts, new AccountsAdapter.AccountsClickListener() {
                    @Override
                    public void onAccountSelected(Account account) {
                       binding.account.setText(account.getAccountName());
                        accountsDialog.dismiss();
                    }
                });
                    dialogueBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    dialogueBinding.recyclerView.setAdapter(adapter);

                    accountsDialog.show();
            });



        return binding.getRoot();
    }
}