package com.example.waittimeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class FindActivity extends AppCompatActivity implements View.OnClickListener {

     EditText lost_id;
     Button lost_button;
     private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        lost_id = findViewById(R.id.lost_id);
        lost_button = findViewById(R.id.lost_button);
        auth = FirebaseAuth.getInstance();

        lost_button.setOnClickListener(this);
    }
    public void onClick(View view){
        if (view == lost_button){
            String emailAddress = lost_id.getText().toString().trim();
            auth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(FindActivity.this,"이메일을 보냈습니다.",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            } else {
                                Toast.makeText(FindActivity.this,"메일 보내기 실패!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
