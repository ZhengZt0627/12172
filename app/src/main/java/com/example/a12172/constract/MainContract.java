package com.example.a12172.constract;

import com.example.a12172.base.BaseModel;
import com.example.a12172.base.BaseView;
import com.example.a12172.bean.MainBean;
import com.example.a12172.net.IMainListenter;

public class MainContract {
    public interface MainView extends BaseView {
        void onScuess(MainBean mainBean);
        void onFeil(String str);
    }
    public abstract static class  MainModel implements BaseModel {
        public abstract <T> void MainModel(String url, IMainListenter<T> callBack);
    }
    public interface MainPresenter{
        void getdata();
    }
}
