package com.buzzware.mood.fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import com.buzzware.mood.R;
import com.buzzware.mood.activity.AddVideoActivity;
import com.buzzware.mood.activity.BookMarkActivity;
import com.buzzware.mood.activity.FavoritesActivity;
import com.buzzware.mood.activity.MainActivity;
import com.buzzware.mood.activity.SettingAndPrivacyActivity;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems2;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItemsFavorite;
import com.buzzware.mood.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        SetView();
        SetListeners();
        initRecyclerViewFoodItems();

        return binding.getRoot();
    }

    private void SetListeners() {
        binding.myVideoLL.setOnClickListener(v->{
            binding.myVideoTV.setTextColor(getResources().getColor(R.color.pink_300));
            ImageViewCompat.setImageTintList(binding.myVideoIV, ColorStateList.valueOf(getResources().getColor(R.color.pink_300)));
            binding.likeVideoTV.setTextColor(getResources().getColor(R.color.gray_200));
            ImageViewCompat.setImageTintList(binding.likeVideoIV, ColorStateList.valueOf(getResources().getColor(R.color.gray_200)));
        });
        binding.likeVideoTV.setOnClickListener(v->{
            binding.myVideoTV.setTextColor(getResources().getColor(R.color.gray_200));
            ImageViewCompat.setImageTintList(binding.myVideoIV, ColorStateList.valueOf(getResources().getColor(R.color.gray_200)));
            binding.likeVideoTV.setTextColor(getResources().getColor(R.color.pink_300));
            ImageViewCompat.setImageTintList(binding.likeVideoIV, ColorStateList.valueOf(getResources().getColor(R.color.pink_300)));
        });

        binding.editIV.setOnClickListener(v->{
            startActivity(new Intent(getContext(), SettingAndPrivacyActivity.class));
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.saveIV.setOnClickListener(v->{
//            startActivity(new Intent(getContext(), FavoritesActivity.class));
            startActivity(new Intent(getContext(), BookMarkActivity.class));
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }
    private void SetView() {
        binding.includeView.titleTV.setText("Erica Martin");
        binding.includeView.backIV.setVisibility(View.GONE);
        binding.includeView.menuIV.setImageResource(R.drawable.menu_icon);
    }
    private void initRecyclerViewFoodItems() {
        GridLayoutManager layoutManager5 = new GridLayoutManager(getContext(), 3);
        binding.foodItemsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterFoodItemsFavorite adapter = new RecyclerViewAdapterFoodItemsFavorite(getContext(), null);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }
    @Override
    public void onResume() {
        super.onResume();
        MainActivity.binding.bottomNavigation.getMenu().getItem(4).setChecked(true);
    }
}