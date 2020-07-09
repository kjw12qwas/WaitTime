package com.example.waittimeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView Sign_up; //회원가입 텍스트
    EditText login_id;
    EditText login_password;
    TextView lost_password;
    Button login_button;
    ImageView google_login;
    ImageView facebook_login;
    ImageView github_login;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sign_up = findViewById(R.id.Sign_up); // 회원가입 초기화
        login_id = findViewById(R.id.login_id);
        login_password = findViewById(R.id.login_password);
        lost_password = findViewById(R.id.lost_password);
        login_button = findViewById(R.id.login_button);
        google_login = findViewById(R.id.google_login);
        facebook_login = findViewById(R.id.facebook_login);
        github_login = findViewById(R.id.github_login);
        auth = FirebaseAuth.getInstance();


        String str = Sign_up.getText().toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(str);
        ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#4E78DB")),12,16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Sign_up.setText(ssb); //글자색을 바꿔주는 코드

        Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });
        lost_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),FindActivity.class));
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
