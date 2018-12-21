package com.example.emfauzanashari.nyoba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.emfauzanashari.retrofit.BaseApiService;

public class MkActivity extends AppCompatActivity {
    EditText edt_Status, edtNomor;
    Button btInsert, btBack;
    BaseApiService mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mk);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("id");
            Log.d("id", j);
        }
    }
}
