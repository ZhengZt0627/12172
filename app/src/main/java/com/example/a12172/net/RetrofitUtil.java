package com.example.a12172.net;

import com.example.a12172.callback.IMainListenter;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtil implements MainWorkInterface {
    private static RetrofitUtil retrofitUtil;
    private final ApiService apiService;

    public RetrofitUtil() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseUrl.baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    public static RetrofitUtil getInstance(){
        if (retrofitUtil==null){
            synchronized (RetrofitUtil.class){
                if (retrofitUtil==null){
                    retrofitUtil=new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }

    @Override
    public <T> void get(String url, IMainListenter callback) {
        apiService.getdata(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String string = value.string();
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t= actualTypeArguments[0];
                            Gson gson = new Gson();
                            T json = gson.fromJson(string, t);
                            callback.onScuess(json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
