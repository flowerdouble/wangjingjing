package com.bwei.xiangmu.sort.presenter;

import com.bwei.xiangmu.sort.bean.LeftBean;
import com.bwei.xiangmu.sort.bean.RightBean;
import com.bwei.xiangmu.sort.mode.SMode;
import com.bwei.xiangmu.sort.view.ISortView;

/**
 * Created by Long° Engagement on 2017/11/14.
 */

public class ISortPresenter implements SMode.OnLFinish,SMode.OnRFinish {
    private final ISortView iSortView;
    private  final SMode sMode;

    public ISortPresenter(ISortView iSortView) {
        this.iSortView = iSortView;
        sMode = new SMode(this,this);
    }
    @Override
    public void OnLifeFinish(LeftBean bean) {
        iSortView.ShowLeftData(bean);
    }
    @Override
    public void OnRightFinish(RightBean rightBean) {
        iSortView.ShowRightData(rightBean);
    }

    public void GetData(){
        sMode.GetData();
    }

    public void GetRightData(int cid){
        sMode.GetRightData(cid);
    }



}
