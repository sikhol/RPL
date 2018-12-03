package com.example.emfauzanashari.Model.Login;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin{

    @SerializedName("id_user")
    private int idUser;

    @SerializedName("username")
    private String username;

    @SerializedName("token")
    private String token;

    public void setIdUser(int idUser){
        this.idUser = idUser;
    }

    public int getIdUser(){
        return idUser;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    @Override
    public String toString(){
        return
                "ResponseLogin{" +
                        "id_user = '" + idUser + '\'' +
                        ",username = '" + username + '\'' +
                        ",token = '" + token + '\'' +
                        "}";
    }
}
