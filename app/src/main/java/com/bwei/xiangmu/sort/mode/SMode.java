package com.bwei.xiangmu.sort.mode;

import android.util.Log;

import com.bwei.xiangmu.sort.bean.LeftBean;
import com.bwei.xiangmu.sort.bean.RightBean;
import com.bwei.xiangmu.utils.Field;
import com.bwei.xiangmu.utils.RightRetroFactory;
import com.bwei.xiangmu.utils.SortLeftRetroFactory;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long° Engagement on 2017/11/14.
 */

public class SMode implements ISortMode {
    LeftBean leftBean;
    RightBean rightBean;

    public SMode(OnRFinish onRFinish, OnLFinish onLFinish) {
        this.onRFinish = onRFinish;
        this.onLFinish = onLFinish;
    }

    private OnLFinish onLFinish;
    public interface OnLFinish{
        void OnLifeFinish(LeftBean bean);

    }
    public interface OnRFinish{
        void  OnRightFinish(RightBean rightBean);
    }
    private OnRFinish onRFinish;
    @Override
    public void GetData() {
        final Observable<LeftBean> leftData = SortLeftRetroFactory.getInstance().getLeftData(Field.SORT_LEFT_PATH);
        leftData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LeftBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("main2", "onCompleted: ");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.d("main2", "onError: ");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(LeftBean bean) {
                        leftBean =  bean;
                        onLFinish.OnLifeFinish(bean);
                        Log.d("main2", "onNext: "+bean.getData().get(0).getName()+"--");
                    }
                });
    }

    @Override
    public void GetRightData(int cid) {
        HashMap<String,String> map = new HashMap<>();
        map.put("cid",cid+"");
        final Observable<RightBean> rightbean = RightRetroFactory.getInstance().getRightData(Field.SORT_RIGHT_PATH,map);
        rightbean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RightBean Bean) {
                         rightBean =Bean ;
                        Log.d("right",Bean.getMsg());
                        onRFinish.OnRightFinish(Bean);

                    }
                });
    }
}
