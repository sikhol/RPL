package com.example.emfauzanashari.nyoba;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.emfauzanashari.Adapter.CustomAdapterMataKuliah;
import com.example.emfauzanashari.Model.ListMatakuliah.ResponseListMatakuliah;
import com.example.emfauzanashari.other.Constant;
import com.example.emfauzanashari.retrofit.ApiClient;
import com.example.emfauzanashari.retrofit.BaseApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMkActivity extends AppCompatActivity {
    private CustomAdapterMataKuliah adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mk);

        progressDoalog = new ProgressDialog(ListMkActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        BaseApiService baseApiService = ApiClient.client();
        baseApiService.getListMatakuliah(Constant.header + Constant.token.getToken()).enqueue(new Callback<List<ResponseListMatakuliah>>() {
            @Override
            public void onResponse(Call<List<ResponseListMatakuliah>> call, Response<List<ResponseListMatakuliah>> response) {
                progressDoalog.dismiss();
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<ResponseListMatakuliah>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(ListMkActivity.this, "Eror", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void loadDataList(List<ResponseListMatakuliah> matakuliahList) {
        recyclerView = findViewById(R.id.recycler_matakuliah);
        adapter = new CustomAdapterMataKuliah(matakuliahList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListMkActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
