package com.example.e_management_manager.utils;

import com.example.e_management_manager.R;
import com.example.e_management_manager.models.Category;

import java.util.ArrayList;

public class Constants {

    public static String INCOME = "INCOME";
    public static String EXPENSE = "EXPENSE";

    public  static  ArrayList<Category> categories ;

    public static void setCategories (){

        categories =  new ArrayList<>();

        categories.add (new Category("Salary", R.drawable.salary, R.color.category1));
        categories.add (new Category("Business",R.drawable.business, R.color.category2));
        categories.add (new Category("Investment",R.drawable.investment, R.color.category3));
        categories.add (new Category("Loan",R.drawable.loan, R.color.category4));
        categories.add (new Category("Rent",R.drawable.rent, R.color.category5));
        categories.add (new Category("Others",R.drawable.others, R.color.category6));

    }



}
