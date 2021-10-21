package com.buzzware.mood.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityNewPasswordCreationBinding;

public class NewPasswordCreationActivity extends AppCompatActivity {

    ActivityNewPasswordCreationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNewPasswordCreationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();

    }

    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("New Password Creation");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }
}