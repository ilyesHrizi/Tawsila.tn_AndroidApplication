package com.example.tawsilatn.controllers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tawsilatn.Activities.InformationActivity;
import com.example.tawsilatn.R;
import com.example.tawsilatn.models.DriverModel;

import java.sql.Driver;
import java.util.List;
import java.util.jar.Attributes;

public class DriverViewHolder extends RecyclerView.Adapter<DriverViewHolder.MyAdapterDriver> {
    Context context;
    List<DriverModel> DriverData;



    public DriverViewHolder(Context context, List<DriverModel> driverData)
    {
            this.context=context;
            this.DriverData=driverData;

    }
    @NonNull
    @Override
    public DriverViewHolder.MyAdapterDriver onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.drivers_item_view,parent,false);
        return new MyAdapterDriver(row);
    }

    @Override
    public void onBindViewHolder(@NonNull final DriverViewHolder.MyAdapterDriver holder, int position) {
            holder.NameDriver.setText(DriverData.get(position).getDriverName());
            holder.EmailDriver.setText(DriverData.get(position).getDriverEmail());
            holder.DriverPhoneNumber.setText(DriverData.get(position).getDriverPhoneNumber());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SendDriverInformation(holder.NameDriver.getText().toString()
                            ,holder.EmailDriver.getText().toString()
                            ,holder.DriverPhoneNumber.getText().toString());
                }
            });
    }

    @Override
    public int getItemCount() {
        return DriverData.size();
    }

    public class MyAdapterDriver extends RecyclerView.ViewHolder {
        TextView NameDriver,EmailDriver,DriverPhoneNumber;
        public MyAdapterDriver(@NonNull View itemView) {
            super(itemView);

            NameDriver = itemView.findViewById(R.id.driver_name);
            EmailDriver = itemView.findViewById(R.id.driver_email);
            DriverPhoneNumber = itemView.findViewById(R.id.driver_phoneNumber);


        }
    }
    public void SendDriverInformation(String NameDriver , String EmailDriver , String PhoneNumber)
        {

            Intent intent = new Intent( context, InformationActivity.class);
            intent.putExtra("name" , NameDriver );
            intent.putExtra("email",EmailDriver );
            intent.putExtra("phone", PhoneNumber);
            context.startActivity(intent);
        }
}
