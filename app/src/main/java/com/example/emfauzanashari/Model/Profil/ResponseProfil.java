package com.example.emfauzanashari.Model.Profil;

import com.google.gson.annotations.SerializedName;

public class ResponseProfil {
    @SerializedName("name")
    private String name;

    @SerializedName("updated_at")
    private Object updatedAt;

    @SerializedName("nim")
    private String nim;

    @SerializedName("prodi")
    private int prodi;
    @SerializedName("fakultas")
    private int fakultas;

    @SerializedName("created_at")
    private Object createdAt;
}
