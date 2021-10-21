package com.buzzware.mood.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityPrivacyBinding;
import com.buzzware.mood.databinding.AlertDialogEveryoneOnlymeBinding;

public class PrivacyActivity extends AppCompatActivity {

    ActivityPrivacyBinding binding;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPrivacyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();

    }

    private void setListener() {
        binding.commentsCL.setOnClickListener(v->{
            showDialog("Comments");
        });
        binding.followingListCL.setOnClickListener(v->{
            showDialog("Following List");
        });
        binding.likedVideosCL.setOnClickListener(v->{
            showDialog("Likes");
        });
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Privacy");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }
    private void showDialog(String title) {
        dialog = new Dialog(PrivacyActivity.this, android.R.style.Theme_NoTitleBar_Fullscreen);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        AlertDialogEveryoneOnlymeBinding dialogBinding = AlertDialogEveryoneOnlymeBinding.inflate(getLayoutInflater());
        dialog.setContentView(dialogBinding.getRoot());
        dialogBinding.titleTV.setText(title);
        dialogBinding.applyTV.setOnClickListener(v -> {
            dialog.dismiss();
        });
        dialogBinding.closeTV.setOnClickListener(v -> {
            dialog.dismiss();
        });
        dialogBinding.everyoneCL.setOnClickListener(v -> {

            dialogBinding.everyoneIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            dialogBinding.onlyMeIV.setImageDrawable(null);
        });
        dialogBinding.onlyMeCL.setOnClickListener(v -> {

            dialogBinding.everyoneIV.setImageDrawable(null);
            dialogBinding.onlyMeIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}