package com.corylab.task5.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.corylab.task5.databinding.FragmentSecondBinding;
import com.corylab.task5.ui.adapters.ItemsViewAdapter;
import com.corylab.task5.ui.viewmodels.ItemsViewModel;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    ItemsViewModel itemsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemsViewModel = new ViewModelProvider(this).get(ItemsViewModel.class);
        itemsViewModel.init(requireActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ItemsViewAdapter recipeCommentsViewAdapter = new ItemsViewAdapter(requireActivity().getApplicationContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        binding.recycler.setLayoutManager(layoutManager);
        binding.recycler.setAdapter(recipeCommentsViewAdapter);
        itemsViewModel.getTextBlocks().observe(getViewLifecycleOwner(), recipeCommentsViewAdapter::updateTextBlocks);
    }
}