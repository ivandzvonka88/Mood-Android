package com.buzzware.mood.viewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.databinding.ItemDesignAddBookmarkMainBinding;
import com.buzzware.mood.databinding.ItemDesignSelectCategoriesBinding;


public class AddBookmarkItemDesignViewHolder extends RecyclerView.ViewHolder {
    public ItemDesignAddBookmarkMainBinding binding;
    public AddBookmarkItemDesignViewHolder(@NonNull ItemDesignAddBookmarkMainBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
