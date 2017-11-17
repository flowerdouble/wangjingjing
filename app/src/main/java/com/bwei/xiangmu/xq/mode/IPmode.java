package com.bwei.xiangmu.xq.mode;

import com.bwei.xiangmu.utils.ApiServer;
import com.bwei.xiangmu.utils.Field;
import com.bwei.xiangmu.xq.bean.ParBean;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long° Engagement on 2017/11/17.
 */

public class IPmode implements IParMode {
    ParBean parBean;
    public  interface GetPscidData{

        void getPscidData(ParBean parBean);
    }
    private GetPscidData getPscidData;
    public IPmode(GetPscidData getPscidData) {
        this.getPscidData = getPscidData;
    }

    @Override
    public void GetData(String pscid) {
        ApiServer apiServer = new Retrofit.Builder()
                .baseUrl(Field.SORT_RIGHT_ITEM)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(ApiServer.class);
        HashMap<String,String> map =  new HashMap<>();
        map.put("pscid", pscid);
        Observable<ParBean> observable = apiServer.getRightSubItem(Field.SORT_RIGHT_ITEM_PATH, map);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ParBean>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(ParBean parBean) {
                        parBean = parBean;
                        getPscidData.getPscidData(parBean);
                    }
                });
    }
}
