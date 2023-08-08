package com.example.e_management_manager.views.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.e_management_manager.databinding.ActivityMainBinding;
import com.example.e_management_manager.utils.Constants;
import com.example.e_management_manager.utils.Helper;
import com.example.e_management_manager.views.fragments.AddTransactionFragment;
import com.example.e_management_manager.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.toolBar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Transactions");


        Constants.setCategories();

        calendar = Calendar.getInstance();
        updateDate();

        binding.nextDateBtn.setOnClickListener(c->{
           calendar.add(Calendar.DATE, +1);
           updateDate();
        });
        binding.previousDateBtn.setOnClickListener(c->{
            calendar.add(Calendar.DATE, -1);
            updateDate();
        });






      binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
                new AddTransactionFragment().show(getSupportFragmentManager(),null);
          }
      });
    }
        void updateDate (){
           // SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy ");
            //binding.currentDate.setText(dateFormat.format(calendar.getTime()));
            binding.currentDate.setText(Helper.formatDate(calendar.getTime()));
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.top_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}