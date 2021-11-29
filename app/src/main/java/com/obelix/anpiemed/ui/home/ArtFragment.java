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
import com.obelix.anpiemed.adapters.ArtAdapter;
import com.example.anpiemed.databinding.FragmentArtBinding;
import com.obelix.anpiemed.model.Art;

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
        arts.add(new Art(R.drawable.art, "Art","Arts in ANPIEMED are where artists of all generations test new ideas and shape public conversation. Committed to experimentation, collaboration and advocacy, Arts mission is to enhance the social culture through a deeper engagement with several kind of art. We devoted four main artistic activities: Hypatia Gallery, Art Space, Photo Studio, and Casa Del Cinema.\n"));
        arts.add(new Art(R.drawable.hypatia, "HYPATIA GALLERY","Hypatia gallery is an online space, where we discover new original artwork, and a chance for young artists to pre…"));
        arts.add(new Art(R.drawable.photo, "PHOTO STUDIO","The Photography is one of important instrument to document the city in ANPIEMED; therefore in photo Studio we organize workshops in professional photography, Exhibition and Seminars.  \n"));
        arts.add(new Art(R.drawable.cinema, "CASA DEL CINEMA","Casa Del Cinema is a space devoted for visual art, where we organize film making workshops, seminars, and movie club for Mediterranean film\n"));

        ArtAdapter artAdapter = new ArtAdapter(arts, getContext());
        binding.productRV.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        binding.productRV.setAdapter(artAdapter);
    }
}