package com.buzzware.mood.viewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.databinding.ItemDesignAddBookmarkMainBinding;
import com.buzzware.mood.databinding.ItemDesignAddBookmarkSubcategoriesBinding;


public class SubCategoriesBookmarkItemDesignViewHolder extends RecyclerView.ViewHolder {
    public ItemDesignAddBookmarkSubcategoriesBinding binding;
    public SubCategoriesBookmarkItemDesignViewHolder(@NonNull ItemDesignAddBookmarkSubcategoriesBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
