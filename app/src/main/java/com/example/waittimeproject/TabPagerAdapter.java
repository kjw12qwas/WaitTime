package com.example.waittimeproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.waittimeproject.fragment.Home_frame;
import com.example.waittimeproject.fragment.Profile_frame;
import com.example.waittimeproject.fragment.Write_frame;

import java.util.ArrayList;
import java.util.List;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    int num;

    public TabPagerAdapter(FragmentManager fm, int num){
        super(fm);
        this.num = num;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Write_frame tab1 = new Write_frame();
                return tab1;
            case 1:
                Home_frame tab2 = new Home_frame();
                return tab2;
            case 2:
                Profile_frame tab3 = new Profile_frame();
                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num;
    }
}
