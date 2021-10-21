package com.buzzware.mood.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {
    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setView();
        setListener();
    }

    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v -> {
            finish();
        });
        binding.togglePhoneNumberTV.setOnClickListener(v -> {
            binding.togglePhoneNumberTV.setBackgroundResource(R.drawable.rounder_corner_pink);
            binding.toggleEmailTV.setBackgroundResource(R.drawable.rounder_corner_light_black);
            binding.phoneCl.setVisibility(View.VISIBLE);
            binding.emailCl.setVisibility(View.GONE);
        });
        binding.toggleEmailTV.setOnClickListener(v -> {
            binding.togglePhoneNumberTV.setBackgroundResource(R.drawable.rounder_corner_light_black);
            binding.toggleEmailTV.setBackgroundResource(R.drawable.rounder_corner_pink);
            binding.phoneCl.setVisibility(View.GONE);
            binding.emailCl.setVisibility(View.VISIBLE);
        });
        binding.loginBT.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
           // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
           // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.loginEmailBT.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
           // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
          //  overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.forgotPasswordTV.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this, ForgotPasswordActivity.class));
        });
        binding.includeView.backIV.setOnClickListener(v -> {
            finish();
        });

        binding.passwordHideIV.setOnClickListener(v -> {
            binding.passwordET.setTransformationMethod(PasswordTransformationMethod.getInstance());
            binding.passwordHideIV.setVisibility(View.GONE);
            binding.passwordShowIV.setVisibility(View.VISIBLE);
        });
        binding.passwordShowIV.setOnClickListener(v -> {
            binding.passwordET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            binding.passwordHideIV.setVisibility(View.VISIBLE);
            binding.passwordShowIV.setVisibility(View.GONE);
        });
        binding.passwordEmailHideIV.setOnClickListener(v -> {
            binding.passwordEmailET.setTransformationMethod(PasswordTransformationMethod.getInstance());
            binding.passwordEmailHideIV.setVisibility(View.GONE);
            binding.passwordEmailShowIV.setVisibility(View.VISIBLE);
        });
        binding.passwordEmailShowIV.setOnClickListener(v -> {
            binding.passwordEmailET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            binding.passwordEmailHideIV.setVisibility(View.VISIBLE);
            binding.passwordEmailShowIV.setVisibility(View.GONE);
        });

    }

    private void setView() {
        binding.includeView.titleTV.setText("Sign In");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}