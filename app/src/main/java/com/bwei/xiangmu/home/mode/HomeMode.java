package com.bwei.xiangmu.home.mode;


import android.content.Context;
import android.util.Log;

import com.bwei.xiangmu.home.bean.HomeBean;
import com.bwei.xiangmu.utils.ApiServer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long° Engagement on 2017/11/9.
 */

public class HomeMode implements IModeView{
    HomeBean.DataBean data;
    Context context;
    private  OnFinish onFinish;
    public void setOnFinish(OnFinish onFinish) {
        this.onFinish = onFinish;
    }
    public interface OnFinish{
        void OnFinishListener(HomeBean.DataBean data);
    }
    @Override
    public void GetHomeData(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<HomeBean> home = apiServer.getHome();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        data = homeBean.getData();
                        onFinish.OnFinishListener(data);

                    }
                });
    }

}
