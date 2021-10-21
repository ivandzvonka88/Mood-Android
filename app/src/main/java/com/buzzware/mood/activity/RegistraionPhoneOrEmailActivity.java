package com.buzzware.mood.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityRegistraionPhoneOrEmailBinding;

public class RegistraionPhoneOrEmailActivity extends AppCompatActivity {

    ActivityRegistraionPhoneOrEmailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistraionPhoneOrEmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();

    }

    private void setListener() {
        binding.togglePhoneNumberTV.setOnClickListener(v->{
            binding.togglePhoneNumberTV.setBackgroundResource(R.drawable.rounder_corner_pink);
            binding.toggleEmailTV.setBackgroundResource(R.drawable.rounder_corner_light_black);
            binding.phoneCl.setVisibility(View.VISIBLE);
            binding.emailCl.setVisibility(View.GONE);
        });
        binding.toggleEmailTV.setOnClickListener(v->{
            binding.togglePhoneNumberTV.setBackgroundResource(R.drawable.rounder_corner_light_black);
            binding.toggleEmailTV.setBackgroundResource(R.drawable.rounder_corner_pink);
            binding.phoneCl.setVisibility(View.GONE);
            binding.emailCl.setVisibility(View.VISIBLE);
        });
        binding.sendCondePhoneNumberBT.setOnClickListener(v->{
            startActivity(new Intent(RegistraionPhoneOrEmailActivity.this,PhoneOTPActivity.class));
        });
        binding.sendCondeEmailBT.setOnClickListener(v->{
            startActivity(new Intent(RegistraionPhoneOrEmailActivity.this,EmailOTPActivity.class).putExtra("type","normal"));
        });
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Registration");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}