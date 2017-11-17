package com.bwei.xiangmu.sort.view;

import com.bwei.xiangmu.sort.bean.LeftBean;
import com.bwei.xiangmu.sort.bean.RightBean;

/**
 * Created by Long° Engagement on 2017/11/14.
 */

public interface ISortView {

    void ShowLeftData(LeftBean leftBean);
    // 展示右侧数据
    void ShowRightData(RightBean rightBean);
}
