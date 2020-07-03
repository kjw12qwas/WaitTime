package com.example.waittimeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.example.waittimeproject.fragment.Home_frame;
import com.example.waittimeproject.fragment.Profile_frame;
import com.example.waittimeproject.fragment.Write_frame;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class fragment_Home extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Home_frame home_frame = new Home_frame();
    private Profile_frame profile_frame = new Profile_frame();
    private Write_frame write_frame = new Write_frame();

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment__home);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view); // 첫 화면에 띄워줄 프래그먼트
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_main_Frame,home_frame).commitAllowingStateLoss();
        bottomNavigationView.setSelectedItemId(R.id.home_f);
        //바텀 네비게이션뷰 안의 아이템들 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home_f: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout_main_Frame,home_frame).commitAllowingStateLoss(); // 홈 프래그먼트로 넘어감
                        break;
                    }
                    case R.id.write: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout_main_Frame,write_frame).commitAllowingStateLoss(); // 작성 프래그먼트로 넘어감
                        break;
                    }
                    case R.id.profile:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout_main_Frame,profile_frame).commitAllowingStateLoss(); // 개인정보 화면으로 넘어감
                        break;
                    }
                }
                return true;
            }
        });

    }

}
