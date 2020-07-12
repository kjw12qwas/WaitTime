package com.example.waittimeproject;

import java.util.ArrayList;

public class Notice_Write {
    ArrayList<String> notice;
    ArrayList<String> time;
    public Notice_Write(){

    }
    public Notice_Write(ArrayList<String> notice, ArrayList<String> time){
        this.notice = notice;
        this.time = time;
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public ArrayList<String> getNotice() {
        return notice;
    }
}
