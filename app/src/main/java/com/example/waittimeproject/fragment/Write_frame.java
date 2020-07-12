package com.example.waittimeproject.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.waittimeproject.R;
import com.example.waittimeproject.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Write_frame extends Fragment {
    String name;
    Button profile_next2, profile_next3, profile_next4;
    DatabaseReference myRef;
    FirebaseDatabase database;
    TextView nickname;
    private FirebaseAuth auth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_write_frame,container,false);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        nickname = root.findViewById(R.id.nickname);
        auth = FirebaseAuth.getInstance();
        profile_next2 = root.findViewById(R.id.profile_next2);
        profile_next3 = root.findViewById(R.id.profile_next3);
        profile_next4 = root.findViewById(R.id.profile_next4);
        final FirebaseUser user = auth.getCurrentUser();

        profile_next2.setOnClickListener(listener);
        profile_next3.setOnClickListener(listener);
        profile_next4.setOnClickListener(listener);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel userModel = snapshot.child("users").child(user.getUid()).getValue(UserModel.class);
                if (userModel != null){
                    name = userModel.getUid();
                    nickname.setText(name + "님");
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
                case R.id.profile_next2:
                    break;
                case R.id.profile_next3:
                    break;
                case R.id.profile_next4:
                    break;
            }
        }
    };
}
