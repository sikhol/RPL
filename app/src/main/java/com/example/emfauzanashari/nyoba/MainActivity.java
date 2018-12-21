package com.example.emfauzanashari.nyoba;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emfauzanashari.Model.Login.LoginUser;
import com.example.emfauzanashari.Model.Login.ResponseLogin;
import com.example.emfauzanashari.Model.Login.UserSession;
import com.example.emfauzanashari.retrofit.ApiClient;
import com.example.emfauzanashari.retrofit.BaseApiService;
import com.example.emfauzanashari.other.Constant;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login;
    private EditText Nim;
    private EditText password;
    private ProgressDialog loadingBar;

    private String PREFER_NAME = "Reg";
    private UserSession session;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nim = findViewById(R.id.Nim);
        password = findViewById(R.id.password);

        session = new UserSession(this);
        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        loadingBar = new ProgressDialog(MainActivity.this);
    }

        private void userLogin( final String name, final String password){
            loadingBar.setTitle("Proses");
            loadingBar.setMessage("Tunggu Proses Login");
            loadingBar.setCancelable(false);
            loadingBar.show();
            final LoginUser loginUser = new LoginUser(name, password);
            BaseApiService baseApiService = ApiClient.client();
            baseApiService.getLogin(loginUser).enqueue(new Callback<ResponseLogin>() {
                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    ResponseLogin responseLogin = response.body();
                    if (response.isSuccessful()) {
                        Constant.token = response.body();
//                        JSONObject jsonResult = new JSONObject();


//                        Log.d("hasil", responseLogin.getUsername());
                        session.createUserLoginSession(responseLogin.getUsername());
                        session.createNimLoginSession(responseLogin.getIdUser());
                        session.createProdiLoginSession(responseLogin.getProdi());


                        Intent DashboardIntent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(DashboardIntent);

                        Toast.makeText(MainActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Eror", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {
                    Toast.makeText(getBaseContext(), "Periksa Internet Anda", Toast.LENGTH_SHORT).show();
                    finish();
                    loadingBar.dismiss();
                }
            });
        }


        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.btn_login:
//                Intent login = new Intent(this, DashboardActivity.class);
//                startActivity(login);

                    if (!Nim.getText().toString().equals("") && !password.getText().toString().equals("")) {
                        userLogin(Nim.getText().toString(), password.getText().toString());
                    }else if (TextUtils.isEmpty(Nim.getText().toString()) && TextUtils.isEmpty(password.getText().toString())) {
                        Nim.setError("Tidak Boleh Kosong");
                        password.setError("Tidak Boleh Kosong");
                    } else if (TextUtils.isEmpty(Nim.getText().toString())){
                        password.setError("Tidak Boleh Kosong");
                    } else if (TextUtils.isEmpty(Nim.getText().toString())){
                        password.setError("Tidak Boleh Kosong");
                    } else {
                        Toast.makeText(this, "Cek Internet Anda", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

        }

}
