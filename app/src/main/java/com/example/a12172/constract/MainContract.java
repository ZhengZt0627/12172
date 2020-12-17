package com.example.a12172.constract;

import com.example.a12172.base.BaseView;
import com.example.a12172.bean.MainBean;
import com.example.a12172.callback.IMainListenter;

public class MainContract {
    public interface MainView extends BaseView{
        void onScuess(MainBean mainBean);
        void onFeil(String str);
    }
    public interface MainModel{
        <T> void MainModel(String url, IMainListenter<T> callBack);
    }
    public interface MainPresenter extends BaseView{
        void getdata();
    }
}
