package com.buzzware.mood.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivitySettingAndPrivacyBinding;
import com.buzzware.mood.databinding.AlertDialogLanguageBinding;
import com.buzzware.mood.databinding.AlertDialogTermsConditionsBinding;
import com.buzzware.mood.databinding.AlertDialogTermsPrivacyPolicyBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SettingAndPrivacyActivity extends AppCompatActivity {

    ActivitySettingAndPrivacyBinding binding;
    BottomSheetDialog bottomSheetDialog;
    AlertDialogLanguageBinding alertDialogLanguageBinding;
    AlertDialogTermsConditionsBinding alertDialogTermsConditionsBinding;
    AlertDialogTermsPrivacyPolicyBinding alertDialogTermsPrivacyPolicyBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySettingAndPrivacyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();

    }

    private void setListener() {
        binding.manageAccountCL.setOnClickListener(v->{
            startActivity(new Intent(SettingAndPrivacyActivity.this,ManageAccountActivity.class));
        });
        binding.privacyCL.setOnClickListener(v->{
            startActivity(new Intent(SettingAndPrivacyActivity.this,PrivacyActivity.class));
        });
        binding.shareProfileCL.setOnClickListener(v->{
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "https://android-developers.googleblog.com/2021/07/05/introduing-android/html");
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, "Share");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            startActivity(shareIntent);
        });
        binding.notificationsCL.setOnClickListener(v->{
            startActivity(new Intent(SettingAndPrivacyActivity.this,NotificationActivity.class));
        });
        binding.reportProblemCL.setOnClickListener(v->{
            startActivity(new Intent(SettingAndPrivacyActivity.this,ReportProblemActivity.class));
        });
        binding.helpCenterCL.setOnClickListener(v->{
            startActivity(new Intent(SettingAndPrivacyActivity.this,HelpCenterActivity.class));
        });
        binding.appLanguageCL.setOnClickListener(v->{
            ShowLanguageDialog();
        });
        binding.termsConditionsCL.setOnClickListener(v->{
            ShowTermAndConditionDialog();
        });
        binding.privacyPolicyCL.setOnClickListener(v->{
            ShowPrivacyDialog();
        });
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
        binding.logoutCL.setOnClickListener(v->{
            Intent intent = new Intent(SettingAndPrivacyActivity.this, SignInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Setting and Privacy");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    private void ShowLanguageDialog() {
        bottomSheetDialog = new BottomSheetDialog(SettingAndPrivacyActivity.this, R.style.SheetDialog);
        alertDialogLanguageBinding = AlertDialogLanguageBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(alertDialogLanguageBinding.getRoot());
        alertDialogLanguageBinding.applyTV.setOnClickListener(v->{
            bottomSheetDialog.dismiss();
        });
        alertDialogLanguageBinding.closeTV.setOnClickListener(v->{
            bottomSheetDialog.dismiss();
        });
        alertDialogLanguageBinding.englishCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.arabicCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.deutchCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.espanolCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.esuomiCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.francaisCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.bahasaIndonesiaCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.pCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.turkiyeCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.vietNamCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(null);
        });
        alertDialogLanguageBinding.cebuanoCL.setOnClickListener(v->{
            alertDialogLanguageBinding.englishIV.setImageDrawable(null);
            alertDialogLanguageBinding.arabicIV.setImageDrawable(null);
            alertDialogLanguageBinding.deutchIV.setImageDrawable(null);
            alertDialogLanguageBinding.espanolIV.setImageDrawable(null);
            alertDialogLanguageBinding.esuomiIV.setImageDrawable(null);
            alertDialogLanguageBinding.francaisIV.setImageDrawable(null);
            alertDialogLanguageBinding.bahasaIndonesiaIV.setImageDrawable(null);
            alertDialogLanguageBinding.pIV.setImageDrawable(null);
            alertDialogLanguageBinding.turkiyeIV.setImageDrawable(null);
            alertDialogLanguageBinding.vietNamIV.setImageDrawable(null);
            alertDialogLanguageBinding.cebuanoIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
        });
        bottomSheetDialog.show();
    }
    private void ShowTermAndConditionDialog() {
        bottomSheetDialog = new BottomSheetDialog(SettingAndPrivacyActivity.this, R.style.SheetDialog);
        alertDialogTermsConditionsBinding = AlertDialogTermsConditionsBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(alertDialogTermsConditionsBinding.getRoot());
        alertDialogTermsConditionsBinding.closeTV.setOnClickListener(v->{
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.show();
    }
    private void ShowPrivacyDialog() {
        bottomSheetDialog = new BottomSheetDialog(SettingAndPrivacyActivity.this, R.style.SheetDialog);
        alertDialogTermsPrivacyPolicyBinding = AlertDialogTermsPrivacyPolicyBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(alertDialogTermsPrivacyPolicyBinding.getRoot());
        alertDialogTermsPrivacyPolicyBinding.closeTV.setOnClickListener(v->{
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.show();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}