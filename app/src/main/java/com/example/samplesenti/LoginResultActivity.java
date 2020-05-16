package com.example.samplesenti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginResultActivity extends AppCompatActivity {

    TextView TextView_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView_get=findViewById(R.id.TextView_get);
        //값을 받아올 intent 만들기
        Intent intent =getIntent();

        Bundle bundle=intent.getExtras();//bundle값을 받아온다.

        //key값으로 하나씩 꺼내온다
        String email = bundle.getString("email");//
        String password = bundle.getString("password");

        TextView_get.setText(email+" / "+password);
    }
}


