package com.example.waittimeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Sign_up; //회원가입 텍스트
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sign_up = findViewById(R.id.Sign_up); // 회원가입 초기화

        String str = Sign_up.getText().toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(str);
        ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#4E78DB")),12,16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Sign_up.setText(ssb); //글자색을 바꿔주는 코드

    }
}
