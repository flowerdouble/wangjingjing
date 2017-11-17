package com.bwei.xiangmu.mine.presenter;

import com.bwei.xiangmu.mine.bean.LoginBean;
import com.bwei.xiangmu.mine.bean.UserBean;
import com.bwei.xiangmu.mine.mode.MineModel;
import com.bwei.xiangmu.mine.view.IView;

/**
 * Created by Long° Engagement on 2017/11/13.
 */

public class IPresenter implements MineModel.onLogin{
    IView iView;
    MineModel mineModel;

    public IPresenter(IView iView) {
        this.iView = iView;
        mineModel = new MineModel(this);
    }
    public void getLogin(UserBean userBean){
        mineModel.OnLogin(userBean);
    }

    @Override
    public void onlogin(LoginBean loginBean) {
            if(loginBean.getCode().equals("0")){
                iView.onLoginSuccess(loginBean);
            }
        else{
                iView.onLoginFailed(loginBean.getMsg());
            }
    }
}
