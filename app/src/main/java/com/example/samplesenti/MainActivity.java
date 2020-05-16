package com.example.samplesenti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //자료형 선언
    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    RelativeLayout RelativeLayout_login;
    String emailOK="123@gmail.com";
    String passwordOK ="1234";

    String inputEmail="";
    String inputPassword="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //화면에서 컴포넌트를 찾아라: findViewById
        TextInputEditText_email=findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password=findViewById(R.id.TextInputEditText_password);
        RelativeLayout_login=findViewById(R.id.RelativeLayout_login);

        //1.값을 가져온다 - 검사 (123@gmail.com / 1234)
        //2.클릭을 감지한다
        //3.1번의 값을 다음 액티비티로 넘긴다

        RelativeLayout_login.setClickable(false);

        //텍스트 감지(email) : addTextChangedListener
        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Log.d("SENTI",s +","+count);
                if (s != null) {
                    inputEmail = s.toString();
                    RelativeLayout_login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //텍스트 감지(password) : addTextChangedListener
        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s!=null) {
                    inputPassword = s.toString();
                    RelativeLayout_login.setEnabled(validation());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //클릭을 감지하고 싶은 컴포넌트에 클릭 리스너를 설치한다
        //RelativeLayout_login.setClickable(true);//setClickable:클릭 가능여부 설정
        RelativeLayout_login.setOnClickListener(new View.OnClickListener() {//setOnClickListener:클릭 리스너 설정
            @Override
            public void onClick(View v) {//클릭을 감지
                String email = TextInputEditText_email.getText().toString();//입력한 값(String)을 가져온다:getText
                String password = TextInputEditText_password.getText().toString();

                //값을 넘겨줄때 Intent사용(암기)

                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);//MainActivity에서 LoginResultActivity로 넘겨준다
                intent.putExtra("email",email);//값넣기, 값 넣을때는 "값을 찾아올때 쓸 이름(key),값(value)"
                intent.putExtra("password",password);
                startActivity(intent);
            }

        });
   }

   public boolean validation(){
        return inputEmail.equals(emailOK)&&inputPassword.equals(passwordOK);//string을 비교할때는 equals를 사용한다.
   }
}



