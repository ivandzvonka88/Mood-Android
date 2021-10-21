package com.buzzware.mood.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buzzware.mood.R;
import com.buzzware.mood.activity.ChatActivity;
import com.buzzware.mood.activity.FoodItemDetailActivity;
import com.buzzware.mood.activity.MainActivity;
import com.buzzware.mood.activity.OtherUserProfileActivity;
import com.buzzware.mood.databinding.BottomsheetDialogFilterBinding;
import com.buzzware.mood.databinding.BottomsheetDialogLocationBinding;
import com.buzzware.mood.databinding.FragmentActivityBinding;
import com.buzzware.mood.databinding.FragmentPopularBinding;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class ActivityFragment extends Fragment {

    FragmentActivityBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentActivityBinding.inflate(inflater, container, false);

        SetView();
        SetListeners();

        return binding.getRoot();
    }

    private void SetView() {
        binding.includeView.titleTV.setText("Activity");
        binding.includeView.backIV.setImageResource(R.drawable.filter);
        binding.includeView.menuIV.setImageResource(R.drawable.chat);

        binding.notification5.titleTV.setText("@melinda5 follow you");
        binding.notification5.watchBtn.setText("Follow");
        binding.notification5.profilePic.setImageResource(R.drawable.melinda);

        binding.notification7.titleTV.setText("@melinda5 follow you");
        binding.notification7.watchBtn.setText("Follow");
        binding.notification7.profilePic.setImageResource(R.drawable.melinda);
    }

    private void SetListeners() {
        binding.includeView.backIV.setOnClickListener(view -> {
            showBottomSheetDialogFilters();
        });

        binding.includeView.menuIV.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), ChatActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        binding.notification1.mainLayout.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.notification2.mainLayout.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.notification3.mainLayout.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.notification4.mainLayout.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.notification5.mainLayout.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.notification6.mainLayout.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.notification7.mainLayout.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.activity1.mainLayout.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.activity2.mainLayout.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }

    private void showBottomSheetDialogFilters() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.SheetDialog);
        final BottomsheetDialogFilterBinding binding2 = BottomsheetDialogFilterBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(binding2.getRoot());

        binding2.allActivityCL.setOnClickListener(v->{
            binding2.allActivityIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            binding2.likesIV.setImageDrawable(null);
            binding2.commentIV.setImageDrawable(null);
            binding2.mentionsIV.setImageDrawable(null);
            binding2.followersIV.setImageDrawable(null);
        });
        binding2.likesCL.setOnClickListener(v->{
            binding2.likesIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            binding2.allActivityIV.setImageDrawable(null);
            binding2.commentIV.setImageDrawable(null);
            binding2.mentionsIV.setImageDrawable(null);
            binding2.followersIV.setImageDrawable(null);
        });
        binding2.commentsCL.setOnClickListener(v->{
            binding2.commentIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            binding2.allActivityIV.setImageDrawable(null);
            binding2.likesIV.setImageDrawable(null);
            binding2.mentionsIV.setImageDrawable(null);
            binding2.followersIV.setImageDrawable(null);
        });
        binding2.mentionsCL.setOnClickListener(v->{
            binding2.mentionsIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            binding2.allActivityIV.setImageDrawable(null);
            binding2.likesIV.setImageDrawable(null);
            binding2.commentIV.setImageDrawable(null);
            binding2.followersIV.setImageDrawable(null);
        });
        binding2.followersCL.setOnClickListener(v->{
            binding2.followersIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
            binding2.allActivityIV.setImageDrawable(null);
            binding2.likesIV.setImageDrawable(null);
            binding2.commentIV.setImageDrawable(null);
            binding2.mentionsIV.setImageDrawable(null);
        });
        binding2.closeTV.setOnClickListener(v->{
            bottomSheetDialog.dismiss();
        });
        binding2.applyTV.setOnClickListener(v->{
            bottomSheetDialog.dismiss();
        });

        bottomSheetDialog.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.binding.bottomNavigation.getMenu().getItem(3).setChecked(true);
    }
}