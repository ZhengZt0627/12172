package com.example.a12172.presenter;

import com.example.a12172.base.BasePresenter;
import com.example.a12172.bean.MainBean;
import com.example.a12172.callback.IMainListenter;
import com.example.a12172.constract.MainContract;
import com.example.a12172.model.MainModel;

public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.MainPresenter {
    private MainContract.MainModel mainModel;

    public MainPresenter() {
        this.mainModel = new MainModel();
    }

    @Override
    public void getdata() {
        mainModel.MainModel("%E7%A6%8F%E5%88%A9/20/19", new IMainListenter<MainBean>() {
            @Override
            public void onScuess(MainBean mainBean) {
               iview.onScuess(mainBean);
            }

            @Override
            public void onFeil(String msg) {

            }
        });

    }
}