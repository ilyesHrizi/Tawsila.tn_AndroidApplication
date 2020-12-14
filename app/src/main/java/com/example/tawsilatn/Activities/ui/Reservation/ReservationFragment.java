package com.example.tawsilatn.Activities.ui.Reservation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tawsilatn.R;
import com.example.tawsilatn.controllers.DriverViewHolder;
import com.example.tawsilatn.controllers.MyReservationViewHolder;
import com.example.tawsilatn.models.DriverModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ReservationFragment extends Fragment {

    private FirebaseRecyclerOptions<DriverModel> options;
    private FirebaseRecyclerAdapter<DriverModel, MyReservationViewHolder> adapter;
    private DatabaseReference databaseReference;
    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        recyclerView = root.findViewById(R.id.RecycleView_Res);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        getRecycleViewItem();
        adapter.startListening();
        recyclerView.setAdapter(adapter);
        return root;
    }
// this function use easy method to get data from firebase
    private void getRecycleViewItem() {


        databaseReference = FirebaseDatabase.getInstance().getReference().child("MyDriver");

        //setting the request from firebase with our model

        options = new FirebaseRecyclerOptions.Builder<DriverModel>().setQuery(databaseReference, DriverModel.class).build();

        //setting the view holder ( put the data in the widget )
        adapter = new FirebaseRecyclerAdapter<DriverModel, MyReservationViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyReservationViewHolder holder, int position, @NonNull final DriverModel model) {


                holder.NameDriver.setText(model.getDriverName());
                holder.EmailDriver.setText(model.getDriverEmail());
                holder.DriverPhoneNumber.setText(model.getDriverPhoneNumber());
            }

            @NonNull
            @Override
            public MyReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drivers_item_view, parent, false);

                return new MyReservationViewHolder(v);
            }


        };
    }
}