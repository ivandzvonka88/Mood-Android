package com.buzzware.mood.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    ActivityForgotPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setView();
        setListener();
    }

    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
        binding.sendBT.setOnClickListener(v->{
            startActivity(new Intent(ForgotPasswordActivity.this,EmailOTPActivity.class).putExtra("type","forgot"));
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Forgot Password");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}