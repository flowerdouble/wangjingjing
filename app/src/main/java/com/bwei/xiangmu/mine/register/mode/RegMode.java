package com.bwei.xiangmu.mine.register.mode;

import android.content.Context;
import com.bwei.xiangmu.mine.bean.UserBean;
import com.bwei.xiangmu.mine.register.bean.RegBean;
import com.bwei.xiangmu.utils.RegRetroFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long° Engagement on 2017/11/13.
 */

public class RegMode implements IRegjsterMode {
    String flag = "";
    private isReg isReg;
    Context context;

    public RegMode(RegMode.isReg isReg) {
        this.isReg = isReg;
    }

    public interface isReg{
        void isreg(String flag);
    }
    @Override
    public void onRegister(UserBean userBean) {
       /* HashMap<String, String> map = new HashMap<>();
        map.put("mobile", userBean.getMobile());
        map.put("password", userBean.getPassword());*/
        Observable<RegBean> reg = RegRetroFactory.getInstance().getReg("user/reg"+ "?mobile=" + userBean.getMobile() + "&password=" + userBean.getPassword());
        reg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RegBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RegBean regBean) {
                        String msg = regBean.getMsg();
                        flag = msg;
                        isReg.isreg(flag);
                      /*  Log.d("reg", "RegBean onNext: "+regBean.getMsg());*/

                    }
                });
    }
}
