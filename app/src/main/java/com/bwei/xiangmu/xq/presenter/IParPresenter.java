package com.bwei.xiangmu.xq.presenter;

import com.bwei.xiangmu.xq.bean.ParBean;

import com.bwei.xiangmu.xq.mode.IPmode;
import com.bwei.xiangmu.xq.view.IView;

/**
 * Created by Long° Engagement on 2017/11/17.
 */

public class IParPresenter implements IPmode.GetPscidData{
   private final IView iView;
    private  final IPmode iPmode;

    public IParPresenter(IView iView) {
        this.iView = iView;
        iPmode = new IPmode(this);
    }

    @Override
    public void getPscidData(ParBean parBean) {
        iView.ShowData(parBean);
    }
    public void GetData(String pscid){
        iPmode.GetData(pscid);
    }
}
