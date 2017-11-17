package com.bwei.xiangmu.mine.view;

import com.bwei.xiangmu.mine.bean.LoginBean;

/**
 * Created by Long° Engagement on 2017/11/13.
 */

public interface IView {
    // 登陆成功
    void onLoginSuccess(LoginBean loginBean);
    // 登陆失败
    void onLoginFailed(String error);
}
