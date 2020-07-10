package com.example.waittimeproject.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.waittimeproject.R;
import com.google.firebase.auth.FirebaseAuth;

public class Home_frame extends Fragment {
    private FirebaseAuth auth;
    TextView nickname;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_home_frame, container, false);
        auth = FirebaseAuth.getInstance();
        nickname = root.findViewById(R.id.nickname);


        return root;
    }
}
