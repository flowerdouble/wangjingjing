package com.bwei.xiangmu.mine.mode;

import com.bwei.xiangmu.mine.bean.LoginBean;
import com.bwei.xiangmu.mine.bean.UserBean;
import com.bwei.xiangmu.utils.LoginRetroFactory;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long° Engagement on 2017/11/13.
 */

public class MineModel implements IModel {
   LoginBean loginBean;
   private onLogin onlogin;

    public MineModel(onLogin onlogin) {
        this.onlogin = onlogin;

    }
    public interface onLogin{
        void onlogin(LoginBean loginBean);
    }
    @Override
    public void OnLogin(UserBean userBean) {
        loginBean = new LoginBean();

        Observable<LoginBean> loginBeanObservable = LoginRetroFactory.getInstance().getLogin("user/login"+ "?mobile=" + userBean.getMobile() + "&password=" + userBean.getPassword());
        loginBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean data) {
                            loginBean = data;
                            onlogin.onlogin(loginBean);
                    }
                });

    }
}
