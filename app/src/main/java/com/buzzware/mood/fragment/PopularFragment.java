package com.buzzware.mood.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buzzware.mood.R;
import com.buzzware.mood.activity.MainActivity;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems3;
import com.buzzware.mood.adapter.RecyclerViewAdapterHashTags;
import com.buzzware.mood.databinding.FragmentHomeBinding;
import com.buzzware.mood.databinding.FragmentPopularBinding;

public class PopularFragment extends Fragment {
    FragmentPopularBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPopularBinding.inflate(inflater, container, false);

        SetView();
        initRecyclerViewHashTags();

        return binding.getRoot();
    }

    private void SetView() {
        binding.includeView.titleTV.setText("Popular");
        binding.includeView.backIV.setVisibility(View.GONE);
    }

    private void initRecyclerViewHashTags() {
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.hashTagsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterHashTags adapter = new RecyclerViewAdapterHashTags(getContext(), null);
        binding.hashTagsRV.setItemAnimator(new DefaultItemAnimator());
        binding.hashTagsRV.setAdapter(adapter);
    }
    @Override
    public void onResume() {
        super.onResume();
        MainActivity.binding.bottomNavigation.getMenu().getItem(1).setChecked(true);
    }

}