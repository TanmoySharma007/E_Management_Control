package com.example.e_management_manager.views.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.e_management_manager.databinding.ActivityMainBinding;
import com.example.e_management_manager.views.fragments.AddTransactionFragment;
import com.example.e_management_manager.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.toolBar);


        Objects.requireNonNull(getSupportActionBar()).setTitle("Transactions");

      binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

                new AddTransactionFragment().show(getSupportFragmentManager(),null);
          }
      });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.top_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}