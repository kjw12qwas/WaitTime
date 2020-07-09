package com.example.waittimeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    // Firebase 인증을 사용하기 위한 객체
    EditText editTextEmail;
    EditText editTextPassword;
    ImageView password_appear;
    Button SignUp;
    Button Cancel;
    private FirebaseAuth auth;
    TextView Sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.Sign_up_ID);
        editTextPassword = findViewById(R.id.Sign_up_password);
        password_appear = findViewById(R.id.appear);
        SignUp = findViewById(R.id.Sign_up_button);
        Cancel = findViewById(R.id.Sign_up_cancel);
        Sign_up = findViewById(R.id.Sign_up);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (editTextEmail.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()) {
                    Toast.makeText(SignUp.this, "이메일과 비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                } else {
                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = auth.getCurrentUser();
                                        SignUp_user(user);
                                    } else {
                                        Toast.makeText(SignUp.this, "이메일이나 비밀번호가 맞지않습니다.!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
    private void SignUp_user(FirebaseUser user){
        if (user != null){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
