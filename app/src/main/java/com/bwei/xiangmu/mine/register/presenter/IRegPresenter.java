package com.bwei.xiangmu.mine.register.presenter;

import android.content.Context;
import android.widget.Toast;

import com.bwei.xiangmu.mine.bean.UserBean;
import com.bwei.xiangmu.mine.register.mode.RegMode;
import com.bwei.xiangmu.mine.register.view.IRegjsterView;

/**
 * Created by Long° Engagement on 2017/11/13.
 */

public class IRegPresenter implements RegMode.isReg {
    private  final IRegjsterView iRegjsterView;
    private  final RegMode regMode;
    Context context;

    public IRegPresenter(IRegjsterView iRegjsterView) {
        this.iRegjsterView = iRegjsterView;
        regMode = new RegMode(this);
    }

    public void Reg(UserBean userBean){
        regMode.onRegister(userBean);
    }
    @Override
    public void isreg(String flag) {
        if (flag.equals("注册成功")){
            iRegjsterView.onRegisterSuccess(flag);
        }
        else {
            Toast.makeText(context,"ssss",Toast.LENGTH_SHORT).show();
            iRegjsterView.onRegisterFailed(flag);
        }
    }
}
