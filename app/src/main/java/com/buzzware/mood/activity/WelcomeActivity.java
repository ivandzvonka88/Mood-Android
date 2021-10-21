package com.buzzware.mood.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {
    ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListener();

    }

    private void setListener() {
        binding.enterPhoneOrEmailTV.setOnClickListener(v -> {
            startActivity(new Intent(WelcomeActivity.this, RegistraionPhoneOrEmailActivity.class));
        });
        binding.signInTV.setOnClickListener(v->{
            startActivity(new Intent(WelcomeActivity.this,SignInActivity.class));
        });
    }
}