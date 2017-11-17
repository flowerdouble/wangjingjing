package com.bwei.xiangmu.home.presenter;

import com.bwei.xiangmu.home.bean.HomeBean;
import com.bwei.xiangmu.home.mode.HomeMode;
import com.bwei.xiangmu.home.view.IHomeView;

/**
 * Created by Long° Engagement on 2017/11/9.
 */

public class IPresenter implements HomeMode.OnFinish {
    private  final IHomeView iHomeView;
    private final HomeMode homeMode;

    public IPresenter(IHomeView iHomeView) {
        this.iHomeView = iHomeView;
        this .homeMode =  new HomeMode();
        homeMode.setOnFinish(this);
    }
    public void setHome(String url){
        homeMode.GetHomeData(url);
    }
    @Override
    public void OnFinishListener(HomeBean.DataBean data) {
        iHomeView.ShowHomeData(data);
    }
}
