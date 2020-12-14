package com.example.tawsilatn.global;

import com.example.tawsilatn.models.DriverModel;

import java.util.ArrayList;
import java.util.List;

public class Constant {
    public final static long Spalch_delay = 3000;
    public final static String ErrorFieldEmpty = "Field Empty ";
    public final static String ErrorCinInvalid = "Your Cin invalid , Your cin need have minimum 8 number ";
    public final static String ErrorPasswordInvalid = "Your password Empty or to short please enter 8 caracter";
    public final static String ErrorEmailInvalid = "Your Email email need contain lowercase  caracter and number";
    public final static String DataBaseMessage = "Your Register has been added successful";
    public final static String DataBaseMessageError = "Your Email or  password invalid please check  them before login";
    public final static String Key_shared_Connected = "Is_connected";
    public final static String Shared_key = "True";
    public final static String key_shared_Email = "Email";
    public final static String key_shared_password = "Password";
    public final static String key_shared_cin = "Cin";
    public static String Reservation_Id = "";
    public final static String key_shared_Name = "name";
    public static ArrayList<DriverModel> list;
    public final static String add_Reservation = "the driver will call you soon he get all places";
    public final static String ErrorEmailExist = "this mail has been used";

    public static List<DriverModel> getListDriver() {
        //adding driver to my list  , I add them manually
        DriverModel driver1 = new DriverModel("Ahmed Gharbi ",
                "ahmedgharbi5@gmail.com",
                "56451232");
        DriverModel driver2 = new DriverModel("Talel salmi ",
                "TalelSalmi41@gmail.com",
                "23154484");
        DriverModel driver3 = new DriverModel("karim zitouni ",
                "Karimzitouni@gmail.com",
                "23621511");
        DriverModel driver4 = new DriverModel("wael mahjoub ",
                "waelMahjoub@gmail.com",
                "20525158");
        DriverModel driver5 = new DriverModel("Walid lamiri ",
                "walidLamiri@gmail.com",
                "23651484"
        );

        list = new ArrayList<DriverModel>();
        list.add(driver1);
        list.add(driver2);
        list.add(driver3);
        list.add(driver4);
        list.add(driver5);

        return list;

    }
}
