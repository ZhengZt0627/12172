package com.example.a12172.net;


import com.example.a12172.callback.IMainListenter;

public interface MainWorkInterface {
    public <T> void get(String url, IMainListenter callback);
}
