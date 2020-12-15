package com.example.tawsilatn.Activities.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tawsilatn.R;
import com.example.tawsilatn.controllers.DriverViewHolder;
import com.example.tawsilatn.global.Constant;
import com.example.tawsilatn.models.DriverModel;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //Setting the recycle view
        recyclerView = root.findViewById(R.id.rcv_List_driver);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);


        DriverViewHolder driverViewHolder = new DriverViewHolder(getContext(), Constant.getListDriver());
        recyclerView.setAdapter(driverViewHolder);

        return root;
    }



}