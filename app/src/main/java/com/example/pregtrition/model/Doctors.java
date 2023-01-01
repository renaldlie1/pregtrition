package com.example.pregtrition.model;

import com.google.gson.annotations.SerializedName;

public class Doctors {

    @SerializedName("doctor_name")
    private String doctor_name;
    @SerializedName("doctor_profesion")
    private String doctor_profesion;
    @SerializedName("doctor_exp")
    private String doctor_exp;

    public Doctors(String doctor_name, String doctor_profesion, String doctor_exp) {
        this.doctor_name = doctor_name;
        this.doctor_profesion = doctor_profesion;
        this.doctor_exp = doctor_exp;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_profesion() {
        return doctor_profesion;
    }

    public void setDoctor_profesion(String doctor_profesion) {
        this.doctor_profesion = doctor_profesion;
    }

    public String getDoctor_exp() {
        return doctor_exp;
    }

    public void setDoctor_exp(String doctor_exp) {
        this.doctor_exp = doctor_exp;
    }
}
