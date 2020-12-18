package com.example.yarbil.base;

public abstract class BasePresenter<T extends BaseView, M extends BaseModel>{
    public T iview;
    public M iModel;
    public void attachView(T t){
        iview=t;
        iModel=getModel();
    }

    protected abstract M getModel();
}
