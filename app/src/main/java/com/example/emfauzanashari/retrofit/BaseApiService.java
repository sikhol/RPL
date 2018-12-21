package com.example.emfauzanashari.retrofit;

import com.example.emfauzanashari.Model.ListMatakuliah.ResponseListMatakuliah;
import com.example.emfauzanashari.Model.ListMatakuliah.ResponseMateri;
import com.example.emfauzanashari.Model.Login.LoginUser;
import com.example.emfauzanashari.Model.Login.ResponseLogin;
import com.example.emfauzanashari.Model.Profil.ResponseProfil;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiService {

    @POST("auth/signin")
    Call<ResponseLogin> getLogin (@Body LoginUser loginUser);
    @GET("mata_kuliah")
    Call<List<ResponseListMatakuliah>> getListMatakuliah (@Header("Authorization") String token);
    @GET("profile")
    Call<ResponseProfil> getProfil(@Header("Authorizationn") String token);
    @POST("mata_kuliah/{id_mata_kuiah}")
    Call<ResponseMateri> postMateri (@Path("id_mata_kuliah")String id_mata_kuliah,
                                       @Field("judul_status") String judul_status,
                                       @Field("isi_materi") String isi_materi,
                                       @Field("kategori") String kategori,
                                       @Field("foto") String foto,

                                       @Header("Authorization") String token);



}
