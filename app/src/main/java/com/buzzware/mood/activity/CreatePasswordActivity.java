package com.buzzware.mood.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityCreatePasswordBinding;

public class CreatePasswordActivity extends AppCompatActivity {

    ActivityCreatePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreatePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();

    }

    private void setListener() {
        binding.finishBT.setOnClickListener(v -> {
            startActivity(new Intent(CreatePasswordActivity.this, SelectCategoriesActivity.class));

        });
        binding.includeView.backIV.setOnClickListener(v -> {
            finish();
        });
        binding.passwordHideIV.setOnClickListener(v->{
            binding.passwordET.setTransformationMethod(PasswordTransformationMethod.getInstance());
            binding.passwordHideIV.setVisibility(View.GONE);
            binding.passwordShowIV.setVisibility(View.VISIBLE);
        });
        binding.passwordShowIV.setOnClickListener(v->{
            binding.passwordET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            binding.passwordHideIV.setVisibility(View.VISIBLE);
            binding.passwordShowIV.setVisibility(View.GONE);
        });
        binding.confirmPasswordHideIV.setOnClickListener(v->{
            binding.confirmPasswordET.setTransformationMethod(PasswordTransformationMethod.getInstance());
            binding.confirmPasswordHideIV.setVisibility(View.GONE);
            binding.confirmPasswordShowIV.setVisibility(View.VISIBLE);
        });
        binding.confirmPasswordShowIV.setOnClickListener(v->{
            binding.confirmPasswordET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            binding.confirmPasswordHideIV.setVisibility(View.VISIBLE);
            binding.confirmPasswordShowIV.setVisibility(View.GONE);
        });

    }

    private void setView() {
        binding.includeView.titleTV.setText("Create Password");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}