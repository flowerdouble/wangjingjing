package com.bwei.xiangmu.mine.register.view;

/**
 * Created by Long° Engagement on 2017/11/13.
 */

public interface IRegjsterView {
    void onRegisterSuccess(String ok);

    // 注册失败
    void onRegisterFailed(String error);
}
