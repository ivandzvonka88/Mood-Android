package com.buzzware.mood.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems2;
import com.buzzware.mood.databinding.ActivityMainBinding;
import com.buzzware.mood.databinding.ActivitySongInfoBinding;
import com.buzzware.mood.fragment.HomeFragment;

public class SongInfoActivity extends AppCompatActivity {

    ActivitySongInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySongInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setView();
        setListeners();
    }

    private void setListeners() {
        binding.includeView.backIV.setOnClickListener(view -> {
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Song Info");
        initRecyclerViewFoodItems();
    }

    private void initRecyclerViewFoodItems() {
        GridLayoutManager layoutManager5 = new GridLayoutManager(this, 3);
        binding.foodItemsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterFoodItems2 adapter = new RecyclerViewAdapterFoodItems2(this, null);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }
}