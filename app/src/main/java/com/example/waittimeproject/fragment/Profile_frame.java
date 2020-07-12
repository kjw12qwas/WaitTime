package com.example.waittimeproject.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.waittimeproject.Dialog_password_change;
import com.example.waittimeproject.MainActivity;
import com.example.waittimeproject.R;
import com.example.waittimeproject.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile_frame extends Fragment{
    String name,phone;
    DatabaseReference myRef;
    FirebaseDatabase database;
    TextView nickname,profile_name,profile_phone;
    Button logout,notice_write, accumulate;
    private FirebaseAuth auth;
    private Dialog_password_change dialog_password_change;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_profile,container,false);
        profile_name = root.findViewById(R.id.profile_name);
        nickname = root.findViewById(R.id.nickname);
        auth = FirebaseAuth.getInstance();
        logout = root.findViewById(R.id.logout);
        profile_phone = root.findViewById(R.id.profile_phone);
        notice_write = root.findViewById(R.id.notice_write);
        accumulate = root.findViewById(R.id.accumulate);
        logout.setOnClickListener(listener);
        accumulate.setOnClickListener(listener);
        notice_write.setOnClickListener(listener);
        final FirebaseUser user = auth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel userModel = snapshot.child("users").child(user.getUid()).getValue(UserModel.class);
                if (userModel != null){
                    name = userModel.getUid();
                    phone = userModel.getPhone();
                    nickname.setText(name + "님");
                    profile_name.setText(name + "님");
                    profile_phone.setText(phone);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return root;
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.logout:
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getActivity().getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    break;
                case R.id.notice_write:
                    dialog_password_change = new Dialog_password_change(getContext());
                    dialog_password_change.setCancelable(false);
                    dialog_password_change.show();
                    break;
                case R.id.accumulate :
                    break;
            }
        }
    };

}

