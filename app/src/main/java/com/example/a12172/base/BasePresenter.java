package com.example.a12172.base;

public class BasePresenter<T extends BaseView>{
    public T iview;
    public void attachView(T t){
        iview=t;
    }
}
