package com.example.waittimeproject.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.waittimeproject.Notice_Write;
import com.example.waittimeproject.R;
import com.example.waittimeproject.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Home_frame extends Fragment {
    DatabaseReference myRef;
    FirebaseDatabase database;
    ListView listView;
    private FirebaseAuth auth;
    TextView nickname;
    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayList<String> time = new ArrayList<String>();
    String name;
    private Context mcontext;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mcontext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_home_frame, container, false);

        auth = FirebaseAuth.getInstance();
        nickname = root.findViewById(R.id.nickname);
        listView = root.findViewById(R.id.listView);
        final FirebaseUser user = auth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel userModel = snapshot.child("users").child(user.getUid()).getValue(UserModel.class);
                Notice_Write notice_write = snapshot.child("notice").getValue(Notice_Write.class);
                if (userModel != null){
                    name = userModel.getUid();
                    nickname.setText(name + "님");
                }
                if (notice_write != null){
                    arrayList = notice_write.getNotice();
                    time = notice_write.getTime();
                }
                makeAdapter(arrayList,time);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return root;
    }
    private void makeAdapter(ArrayList<String> reason, ArrayList<String> point) {

        ArrayList<HashMap<String, String>> arrayList1 = new ArrayList<>();

        for(int i = 0; i < reason.size(); i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("reason", reason.get(i));
            hashMap.put("point", point.get(i));
            Log.d("asdf",reason.get(i));
            arrayList1.add(hashMap);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                mcontext,
                arrayList1,
                R.layout.row_point,
                new String[]{"reason","point"},
                new int[]{R.id.notice_text, R.id.notice_date});
        listView.setAdapter(adapter);
    }

}
