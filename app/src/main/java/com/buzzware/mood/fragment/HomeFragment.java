package com.buzzware.mood.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.buzzware.mood.R;
import com.buzzware.mood.activity.MainActivity;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems;
import com.buzzware.mood.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        initRecyclerViewFoodItems();
        setListener();

        return binding.getRoot();
    }

    private void setListener() {
        binding.followingTV.setOnClickListener(v->{
            binding.followingTV.setTextColor(getResources().getColor(R.color.pink_300));
            binding.nearbyTV.setTextColor(getResources().getColor(R.color.gray_200));
        });
        binding.nearbyTV.setOnClickListener(v->{
            binding.nearbyTV.setTextColor(getResources().getColor(R.color.pink_300));
            binding.followingTV.setTextColor(getResources().getColor(R.color.gray_200));
        });

    }

    private void initRecyclerViewFoodItems() {
        GridLayoutManager layoutManager5 = new GridLayoutManager(getActivity(), 2);
        binding.foodItemsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterFoodItems adapter = new RecyclerViewAdapterFoodItems(getContext(), null, clickListener);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }

    RecyclerViewAdapterFoodItems.ClickListener clickListener = new RecyclerViewAdapterFoodItems.ClickListener() {
        @Override
        public void OnClick() {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(MainActivity.binding.mainFragmentContainer.getId(), new FoodItemDetailFragment())
                    .addToBackStack(null).commit();
        }
    };
    @Override
    public void onResume() {
        super.onResume();
        MainActivity.binding.bottomNavigation.getMenu().getItem(0).setChecked(true);
    }
}