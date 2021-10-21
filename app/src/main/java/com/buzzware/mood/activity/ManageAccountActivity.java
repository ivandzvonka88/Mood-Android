package com.buzzware.mood.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityManageAccountBinding;
import com.buzzware.mood.databinding.AlertDialogDeleteAccountBinding;

public class ManageAccountActivity extends AppCompatActivity {

    ActivityManageAccountBinding binding;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityManageAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setView();
        setListener();
    }

    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
        binding.phoneNumberCL.setOnClickListener(v->{
            startActivity(new Intent(ManageAccountActivity.this,ChangePhoneNumberActivity.class));
        });
        binding.emailCL.setOnClickListener(v->{
            startActivity(new Intent(ManageAccountActivity.this,ChangeEmailActivity.class));
        });
        binding.changePasswordCL.setOnClickListener(v->{
            startActivity(new Intent(ManageAccountActivity.this,ChangePasswordActivity.class));
        });
        binding.changeCategoriesCL.setOnClickListener(v->{
            startActivity(new Intent(ManageAccountActivity.this,SelectCategoriesActivity.class));
        });
        binding.changeNicknameCL.setOnClickListener(v->{
            startActivity(new Intent(ManageAccountActivity.this,ChangeNickNameActivity.class));
        });
        binding.deleteAccountCL.setOnClickListener(v->{
            showDialogDeleteAccount();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Manage Account");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }
    private void showDialogDeleteAccount() {

        dialog = new Dialog(ManageAccountActivity.this, R.style.Theme_AppCompat_Dialog_Alert);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        final AlertDialogDeleteAccountBinding dialogBinding = AlertDialogDeleteAccountBinding.inflate(LayoutInflater.from(ManageAccountActivity.this));
        dialog.setContentView(dialogBinding.getRoot());
        dialogBinding.yesBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialogBinding.noBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}