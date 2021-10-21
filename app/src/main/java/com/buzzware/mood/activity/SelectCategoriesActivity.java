package com.buzzware.mood.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.buzzware.mood.R;
import com.buzzware.mood.adapter.CategoriesItemAdapter;
import com.buzzware.mood.databinding.ActivitySelectCategoriesBinding;
import com.buzzware.mood.model.CategoriesModel;

import java.util.ArrayList;

public class SelectCategoriesActivity extends AppCompatActivity {

    ActivitySelectCategoriesBinding binding;
    ArrayList<CategoriesModel> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setView();
        setListener();
        setRecycler();

    }

    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
        binding.completeBT.setOnClickListener(v->{
            Intent intent = new Intent(SelectCategoriesActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
        binding.skipTV.setOnClickListener(v->{
            Intent intent = new Intent(SelectCategoriesActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }

    private void setRecycler() {

        data.add(new CategoriesModel(getResources().getDrawable(R.drawable.vegetables_icon),"Vegetables",getResources().getDrawable(R.drawable.fruits_icon),"Fruits"));
        data.add(new CategoriesModel(getResources().getDrawable(R.drawable.fish_icon),"Fish and seafood",getResources().getDrawable(R.drawable.snack_icon),"Snack"));
        data.add(new CategoriesModel(getResources().getDrawable(R.drawable.american_food_icon),"American food",getResources().getDrawable(R.drawable.sweets_icon),"Sweets"));
        data.add(new CategoriesModel(getResources().getDrawable(R.drawable.mediterrenian_food_icon),"Mediterranean food",getResources().getDrawable(R.drawable.salad),""));
        data.add(new CategoriesModel(getResources().getDrawable(R.drawable.salad),"Salads",getResources().getDrawable(R.drawable.meet_icon),"Meat products"));
        data.add(new CategoriesModel(getResources().getDrawable(R.drawable.italian_food_icon),"Italian food",getResources().getDrawable(R.drawable.salad),""));


        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SelectCategoriesActivity.this);
        binding.mainRV.setLayoutManager(linearLayoutManager);
        binding.mainRV.setAdapter(new CategoriesItemAdapter(SelectCategoriesActivity.this, data));
    }

    private void setView() {
        binding.includeView.titleTV.setText("");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}