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

import com.example.waittimeproject.MainActivity;
import com.example.waittimeproject.R;
import com.google.firebase.auth.FirebaseAuth;

public class Profile_frame extends Fragment{
    TextView nickname;
    Button logout,country_change, password_change, accumulate;
    private FirebaseAuth auth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_profile,container,false);
        nickname = root.findViewById(R.id.nickname);
        auth = FirebaseAuth.getInstance();
        logout = root.findViewById(R.id.logout);
        country_change = root.findViewById(R.id.country_change);
        password_change = root.findViewById(R.id.pass_change);
        accumulate = root.findViewById(R.id.accumulate);
        logout.setOnClickListener(listener);
        accumulate.setOnClickListener(listener);
        country_change.setOnClickListener(listener);
        password_change.setOnClickListener(listener);


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
                case R.id.country_change:
                    break;
                case R.id.accumulate :
                    break;
                case R.id.pass_change:
                    break;
            }
        }
    };

}

