package com.example.emfauzanashari.nyoba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emfauzanashari.Model.Login.LoginUser;
import com.example.emfauzanashari.Model.Login.ResponseLogin;
import com.example.emfauzanashari.retrofit.ApiClient;
import com.example.emfauzanashari.retrofit.BaseApiService;
import com.example.emfauzanashari.other.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login;
    private EditText Nim;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nim = findViewById(R.id.Nim);
        password = findViewById(R.id.password);

        Nim.setText("admin");
        password.setText("admin123");
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

        private void userLogin( final String name, final String password){
            final LoginUser loginUser = new LoginUser(name, password);
            BaseApiService baseApiService = ApiClient.client();
            baseApiService.getLogin(loginUser).enqueue(new Callback<ResponseLogin>() {
                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    ResponseLogin responseLogin = response.body();
                    if (response.isSuccessful()) {
                        Constant.token = response.body();
                        Intent DashboardIntent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(DashboardIntent);
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Eror", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {

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
                    }
                    break;
            }

        }

}
