package com.buzzware.mood.viewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.databinding.ItemDesignSelectCategoriesBinding;


public class CategoriesItemDesignViewHolder extends RecyclerView.ViewHolder {
    public ItemDesignSelectCategoriesBinding binding;
    public CategoriesItemDesignViewHolder(@NonNull ItemDesignSelectCategoriesBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
