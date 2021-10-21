package com.buzzware.mood.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ItemDesignAddBookmarkMainBinding;
import com.buzzware.mood.databinding.ItemDesignAddBookmarkSubcategoriesBinding;
import com.buzzware.mood.model.BookmarkModel;
import com.buzzware.mood.viewHolder.AddBookmarkItemDesignViewHolder;
import com.buzzware.mood.viewHolder.SubCategoriesBookmarkItemDesignViewHolder;

import java.util.ArrayList;


public class SubCategoriesBookmarkItemAdapter extends RecyclerView.Adapter<SubCategoriesBookmarkItemDesignViewHolder> {

    Context context;
    ArrayList<String> mData;
    Dialog dialog;


    @NonNull
    @Override
    public SubCategoriesBookmarkItemDesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemDesignAddBookmarkSubcategoriesBinding itemDesignAddBookmarkSubcategoriesBinding =
                ItemDesignAddBookmarkSubcategoriesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new SubCategoriesBookmarkItemDesignViewHolder(itemDesignAddBookmarkSubcategoriesBinding);
    }

    public SubCategoriesBookmarkItemAdapter(Context context, ArrayList<String> data) {
        mData = new ArrayList<>();
        mData = data;
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoriesBookmarkItemDesignViewHolder holder, final int position) {

        holder.binding.categoriesNameTV1.setText(mData.get(position));


    }

    @Override
    public int getItemCount() {
        return mData.size();

    }

}
