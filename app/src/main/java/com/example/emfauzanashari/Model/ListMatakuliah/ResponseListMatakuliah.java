package com.example.emfauzanashari.Model.ListMatakuliah;

import com.google.gson.annotations.SerializedName;

public class ResponseListMatakuliah {
    @SerializedName("nama_mk")
    private String nama_mk;

    @SerializedName("updated_at")
    private Object updatedAt;

    @SerializedName("id_mata_kuliah")
    private String idMataKuliah;

    @SerializedName("sks")
    private int sks;

    @SerializedName("created_at")
    private Object createdAt;


    public void setNama_mk(String nama_mk){
        this.nama_mk = nama_mk;
    }

    public String getNama_mk()
    {
        return nama_mk;
    }

    public void setUpdatedAt(Object updatedAt){

        this.updatedAt = updatedAt;
    }

    public Object getUpdatedAt(){


        return updatedAt;

    }

    public void setIdMataKuliah(String idMataKuliah){
        this.idMataKuliah = idMataKuliah;
    }

    public String getIdMataKuliah(){

        return idMataKuliah;
    }

    public void setSks(int sks){
        this.sks = sks;
    }

    public int getSks(){

        return sks;
    }

    public void setCreatedAt(Object createdAt)
    {
        this.createdAt = createdAt;
    }

    public Object getCreatedAt(){

        return createdAt;
    }

    @Override
    public String toString(){
        return
                "ResponseListMataKuliah{" +
                        "nama_mk= '" + nama_mk+ '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",id_mata_kuliah = '" + idMataKuliah+ '\'' +
                        ",sks= '" + sks+ '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        "}";
    }
}
