package com.example.e_management_manager.views.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.e_management_manager.R;
import com.example.e_management_manager.databinding.FragmentAddTransactionBinding;
import com.example.e_management_manager.databinding.ListDialogueBinding;
import com.example.e_management_manager.models.Category;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class AddTransactionFragment extends BottomSheetDialogFragment {


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

        binding.expenseBtn.setOnClickListener(v -> {

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

                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
                            String dateToShow = dateFormat.format(calendar.getTime());

                            binding.date.setText(dateToShow);
                        }
                    });
                    datePickerDialog.show();
                }
            });

            binding.category.setOnClickListener(v-> {
                ListDialogueBinding dialogueBinding = ListDialogueBinding.inflate(inflater);
                AlertDialog categoryDialog = new AlertDialog.Builder(getContext()).create();
                categoryDialog .setView(dialogueBinding.getRoot());

                ArrayList <Category> categories = new ArrayList<>();
                catego
                


            });


        return binding.getRoot();
    }
}