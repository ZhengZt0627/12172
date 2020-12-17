package com.example.a12172.model;


import com.example.a12172.callback.IMainListenter;
import com.example.a12172.constract.MainContract;
import com.example.a12172.net.RetrofitUtil;

public class MainModel implements MainContract.MainModel {
    @Override
    public <T> void MainModel(String url, IMainListenter<T> callBack) {
        RetrofitUtil.getInstance().get(url,callBack);
    }
}
