package com.buzzware.mood.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ItemDesignSelectCategoriesBinding;
import com.buzzware.mood.model.CategoriesModel;
import com.buzzware.mood.viewHolder.CategoriesItemDesignViewHolder;

import java.util.ArrayList;


public class CategoriesItemAdapter extends RecyclerView.Adapter<CategoriesItemDesignViewHolder> {

    Context context;
    ArrayList<CategoriesModel> mData;
    Dialog dialog;


    @NonNull
    @Override
    public CategoriesItemDesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemDesignSelectCategoriesBinding itemDesignSelectCategoriesBinding =
                ItemDesignSelectCategoriesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new CategoriesItemDesignViewHolder(itemDesignSelectCategoriesBinding);
    }

    public CategoriesItemAdapter(Context context, ArrayList<CategoriesModel> data) {
        mData = new ArrayList<>();
        mData = data;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesItemDesignViewHolder holder, final int position) {

        holder.binding.categoriesNameTV1.setText(mData.get(position).getName1());
        holder.binding.categoriesImageIV1.setImageDrawable(mData.get(position).getImage1());
        holder.binding.categoriesNameTV2.setText(mData.get(position).getName2());
        holder.binding.categoriesImageIV2.setImageDrawable(mData.get(position).getImage2());
        if(mData.get(position).getName1().equals("")) {
            holder.binding.categoriesLL1.setVisibility(View.GONE);
        }
        if(mData.get(position).getName2().equals("")) {
            holder.binding.categoriesLL2.setVisibility(View.GONE);
        }
        holder.binding.categoriesLL1.setOnClickListener(v -> {

            if (holder.binding.categoriesLL1.getBackground().getConstantState()==context.getResources().getDrawable(R.drawable.rounder_corner_white_with_white_stroke).getConstantState())
            {
                holder.binding.categoriesLL1.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_black_with_white_stroke));
                holder.binding.categoriesNameTV1.setTextColor(context.getResources().getColor(R.color.white));
            }else{

                holder.binding.categoriesLL1.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_white_with_white_stroke));
                holder.binding.categoriesNameTV1.setTextColor(context.getResources().getColor(R.color.black));
            }
        });
        holder.binding.categoriesLL2.setOnClickListener(v -> {

            if (holder.binding.categoriesLL2.getBackground().getConstantState()==context.getResources().getDrawable(R.drawable.rounder_corner_white_with_white_stroke).getConstantState())
            {
                holder.binding.categoriesLL2.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_black_with_white_stroke));
                holder.binding.categoriesNameTV2.setTextColor(context.getResources().getColor(R.color.white));
            }else{

                holder.binding.categoriesLL2.setBackground(context.getResources().getDrawable(R.drawable.rounder_corner_white_with_white_stroke));
                holder.binding.categoriesNameTV2.setTextColor(context.getResources().getColor(R.color.black));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();

    }

}
