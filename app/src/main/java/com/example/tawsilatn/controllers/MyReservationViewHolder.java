package com.example.tawsilatn.controllers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tawsilatn.R;

public class MyReservationViewHolder extends  RecyclerView.ViewHolder {
    public  TextView NameDriver,EmailDriver,DriverPhoneNumber;

    public MyReservationViewHolder(@NonNull View itemView) {
        super(itemView);

        NameDriver = itemView.findViewById(R.id.driver_name);
        EmailDriver = itemView.findViewById(R.id.driver_email);
        DriverPhoneNumber = itemView.findViewById(R.id.driver_phoneNumber);
    }
}
