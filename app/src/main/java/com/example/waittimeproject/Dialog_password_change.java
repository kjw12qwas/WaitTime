package com.example.waittimeproject;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.waittimeproject.fragment.Home_frame;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class Dialog_password_change extends Dialog implements View.OnClickListener {
    private Context mContext;
    private FirebaseAuth auth;
    private TextView btn_cancel;
    private TextView btn_ok;
    ArrayList<String> arrayList = new ArrayList<String>();
    EditText notice;
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH)+1;
    int date = calendar.get(Calendar.DATE);
    String time = year + "-" + month + "-" + date;
    ArrayList<String> time_list = new ArrayList<String>();
    DatabaseReference myRef;
    FirebaseDatabase database;
    public Dialog_password_change(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_password_change);
        auth = FirebaseAuth.getInstance();
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_ok = findViewById(R.id.btn_ok);
        notice = findViewById(R.id.notice);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        btn_cancel.setOnClickListener(this);
        btn_ok.setOnClickListener(this);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Notice_Write notice_write = snapshot.child("notice").getValue(Notice_Write.class);
                if (notice_write != null){
                    arrayList = notice_write.getNotice();
                    time_list = notice_write.getTime();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel:
                dismiss();
                break;
            case R.id.btn_ok:
                arrayList.add(notice.getText().toString());
                time_list.add(time);
                WriteNewUser(arrayList,time_list);
                dismiss();
                break;
        }
    }
    private  void WriteNewUser(ArrayList<String> notice, ArrayList<String> time){
        if (notice.size() > 10){
            notice.remove(0);
            time.remove(0);
        }
        Notice_Write notice_write = new Notice_Write(notice,time);
        myRef.child("notice").setValue(notice_write);
    }
}
