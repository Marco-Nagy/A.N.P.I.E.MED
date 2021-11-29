package com.obelix.anpiemed.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.anpiemed.R;
import com.example.anpiemed.adapters.ArtAdapter;
import com.example.anpiemed.databinding.FragmentArtBinding;
import com.example.anpiemed.model.Art;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ArtFragment extends Fragment {
FragmentArtBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_art, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setArtRecyclerView();
    }
    public void setArtRecyclerView() {
        List<Art> arts = new ArrayList<>();
        arts.add(new Art(R.drawable.hypatia, "Description for art",""));

        ArtAdapter categoriesAdapter = new ArtAdapter(arts, getContext());
        binding.productRV.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        binding.productRV.setAdapter(categoriesAdapter);
    }
}