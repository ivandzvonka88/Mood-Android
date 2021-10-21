package com.buzzware.mood.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.buzzware.mood.R;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems2;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItemsFavorite;
import com.buzzware.mood.adapter.RecyclerViewAdapterHashtag;
import com.buzzware.mood.adapter.RecyclerViewAdapterMusic;
import com.buzzware.mood.databinding.ActivityFavoritesBinding;

public class FavoritesActivity extends AppCompatActivity {

    ActivityFavoritesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityFavoritesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        initRecyclerViewFoodItems();
        setListener();

    }
    private void setView() {
        binding.includeView.titleTV.setText("Bookmarks");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }
    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
        binding.burgerTV.setOnClickListener(v->{
            binding.burgerTV.setTextColor(getResources().getColor(R.color.pink_300));
            binding.mexicanTV.setTextColor(getResources().getColor(R.color.gray_200));
            binding.lASportsTV.setTextColor(getResources().getColor(R.color.gray_200));

        });
        binding.mexicanTV.setOnClickListener(v->{

            binding.burgerTV.setTextColor(getResources().getColor(R.color.gray_200));
            binding.mexicanTV.setTextColor(getResources().getColor(R.color.pink_300));
            binding.lASportsTV.setTextColor(getResources().getColor(R.color.gray_200));
        });
        binding.lASportsTV.setOnClickListener(v->{

            binding.burgerTV.setTextColor(getResources().getColor(R.color.gray_200));
            binding.mexicanTV.setTextColor(getResources().getColor(R.color.gray_200));
            binding.lASportsTV.setTextColor(getResources().getColor(R.color.pink_300));
        });

    }


    private void initRecyclerViewFoodItems() {
        GridLayoutManager layoutManager5 = new GridLayoutManager(FavoritesActivity.this, 3);
        binding.foodItemsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterFoodItemsFavorite adapter = new RecyclerViewAdapterFoodItemsFavorite(FavoritesActivity.this, null);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }
    private void initRecyclerViewHashtag() {
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(FavoritesActivity.this);
        binding.foodItemsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterHashtag adapter = new RecyclerViewAdapterHashtag(FavoritesActivity.this, null);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }
    private void initRecyclerViewMusic() {
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(FavoritesActivity.this);
        binding.foodItemsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterMusic adapter = new RecyclerViewAdapterMusic(FavoritesActivity.this, null);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }



}