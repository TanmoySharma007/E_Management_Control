package com.example.e_management_manager.adapters;

import static com.example.e_management_manager.databinding.RowTransactionsBinding.inflate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_management_manager.R;
import com.example.e_management_manager.databinding.SampleCategoryItemBinding;
import com.example.e_management_manager.models.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context context;
    ArrayList<Category> categories;

    public CategoryAdapter (Context context,ArrayList<Category>categories){
        this.context =context;
        this.categories= categories;

    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.sample_category_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.binding.categoryText.setText(category.getCategoryName());
        holder.binding.categoryIcon.setImageResource(category.getCategoryImage());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        SampleCategoryItemBinding binding ;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SampleCategoryItemBinding.bind(itemView);
        }
    }
}
