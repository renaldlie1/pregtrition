package com.example.pregtrition.model;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("nim")
    private String nim;
    @SerializedName("name")
    private String name;
    @SerializedName("prodi")
    private String prodi;



    public News(String nim, String name, String prodi) {
        this.nim = nim;
        this.name = name;
        this.prodi = prodi;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        prodi = prodi;
    }
}
