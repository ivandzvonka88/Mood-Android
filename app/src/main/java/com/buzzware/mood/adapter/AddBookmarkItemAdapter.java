package com.buzzware.mood.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.R;
import com.buzzware.mood.classes.ShowSubCategoriesEventBuss;
import com.buzzware.mood.databinding.ItemDesignAddBookmarkMainBinding;
import com.buzzware.mood.databinding.ItemDesignSelectCategoriesBinding;
import com.buzzware.mood.model.BookmarkModel;
import com.buzzware.mood.model.CategoriesModel;
import com.buzzware.mood.viewHolder.AddBookmarkItemDesignViewHolder;
import com.buzzware.mood.viewHolder.CategoriesItemDesignViewHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


public class AddBookmarkItemAdapter extends RecyclerView.Adapter<AddBookmarkItemDesignViewHolder> {

    Context context;
    ArrayList<BookmarkModel> mData;
    Dialog dialog;


    @NonNull
    @Override
    public AddBookmarkItemDesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemDesignAddBookmarkMainBinding itemDesignAddBookmarkMainBinding =
                ItemDesignAddBookmarkMainBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new AddBookmarkItemDesignViewHolder(itemDesignAddBookmarkMainBinding);
    }

    public AddBookmarkItemAdapter(Context context, ArrayList<BookmarkModel> data) {
        mData = new ArrayList<>();
        mData = data;
    }

    @Override
    public void onBindViewHolder(@NonNull AddBookmarkItemDesignViewHolder holder, final int position) {

        holder.binding.categoriesNameTV1.setText(mData.get(position).getName1());
        holder.binding.categoriesNameTV2.setText(mData.get(position).getName2());
        holder.binding.categoriesNameTV3.setText(mData.get(position).getName3());


        if(mData.get(position).getName1().equals("")) {
            holder.binding.categoriesLL1.setVisibility(View.GONE);
        }
        if(mData.get(position).getName2().equals("")) {
            holder.binding.categoriesLL2.setVisibility(View.GONE);
        }
        if(mData.get(position).getName3().equals("")) {
            holder.binding.categoriesLL3.setVisibility(View.GONE);
        }
        holder.binding.categoriesLL1.setOnClickListener(v -> {
            EventBus.getDefault().post(new ShowSubCategoriesEventBuss(holder.binding.categoriesNameTV1.getText().toString()));

//            if (holder.binding.categoriesLL1.getBackground().getConstantState()==context.getResources().getDrawable(R.drawable.rounder_corner_pink_big).getConstantState())
//            {
//                holder.binding.categoriesLL1.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
//                holder.binding.categoriesNameTV1.setTextColor(context.getResources().getColor(R.color.white));
//            }else{
//
//                holder.binding.categoriesLL1.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_pink_big));
//                holder.binding.categoriesNameTV1.setTextColor(context.getResources().getColor(R.color.white));
//            }
        });
        holder.binding.categoriesLL2.setOnClickListener(v -> {
            EventBus.getDefault().post(new ShowSubCategoriesEventBuss(holder.binding.categoriesNameTV2.getText().toString()));

//            if (holder.binding.categoriesLL2.getBackground().getConstantState()==context.getResources().getDrawable(R.drawable.rounder_corner_pink_big).getConstantState())
//            {
//                holder.binding.categoriesLL2.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
//                holder.binding.categoriesNameTV2.setTextColor(context.getResources().getColor(R.color.white));
//            }else{
//
//                holder.binding.categoriesLL2.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_pink_big));
//                holder.binding.categoriesNameTV2.setTextColor(context.getResources().getColor(R.color.white));
//            }
        });
        holder.binding.categoriesLL3.setOnClickListener(v -> {
            EventBus.getDefault().post(new ShowSubCategoriesEventBuss(holder.binding.categoriesNameTV3.getText().toString()));

//            if (holder.binding.categoriesLL3.getBackground().getConstantState()==context.getResources().getDrawable(R.drawable.rounder_corner_pink_big).getConstantState())
//            {
//                holder.binding.categoriesLL3.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
//                holder.binding.categoriesNameTV3.setTextColor(context.getResources().getColor(R.color.white));
//            }else{
//
//                holder.binding.categoriesLL3.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_pink_big));
//                holder.binding.categoriesNameTV3.setTextColor(context.getResources().getColor(R.color.white));
//            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();

    }

}
