package com.example.emfauzanashari.Model.ListMatakuliah;

import com.google.gson.annotations.SerializedName;

public class ResponseMateri {
    public String getJudul_status() {
        return judul_status;
    }

    public void setJudul_status(String judul_status) {
        this.judul_status = judul_status;
    }

    public String getIsi_materi() {
        return isi_materi;
    }

    public void setIsi_materi(String isi_materi) {
        this.isi_materi = isi_materi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public ResponseMateri(String judul_status, String isi_materi, String kategori) {
        this.judul_status = judul_status;
        this.isi_materi = isi_materi;
        this.kategori = kategori;
    }

    @SerializedName("judul_status")
    private String judul_status;

    @SerializedName("isi_materi")
    private String isi_materi;

    @SerializedName("kategori")
    private String kategori;
}
