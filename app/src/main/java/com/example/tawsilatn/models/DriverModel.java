package com.example.tawsilatn.models;

public class DriverModel {

String DriverName ;
String DriverEmail ;
String DriverPhoneNumber;


    public DriverModel() {
    }

    public DriverModel(String driverName, String driverEmail, String driverPhoneNumber) {
        DriverName = driverName;
        DriverEmail = driverEmail;
        DriverPhoneNumber = driverPhoneNumber;

    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getDriverEmail() {
        return DriverEmail;
    }

    public void setDriverEmail(String driverEmail) {
        DriverEmail = driverEmail;
    }

    public String getDriverPhoneNumber() {
        return DriverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        DriverPhoneNumber = driverPhoneNumber;
    }


}
