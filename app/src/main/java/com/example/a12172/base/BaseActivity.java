package com.example.a12172.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<V extends BasePresenter> extends AppCompatActivity implements BaseView{
    public V presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (presenter==null){
            presenter=getPresenter();
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract V getPresenter();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayoutId();

    public void createPresenter(){
        Type genericInterfaces = this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces).getActualTypeArguments();
                Type p=actualTypeArguments[0];
        try {
            presenter= (V)p.getClass().newInstance();

            presenter.attachView(this);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
