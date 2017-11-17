package com.bwei.xiangmu.sort.mode;

/**
 * Created by Long° Engagement on 2017/11/14.
 */

public interface ISortMode {
    void GetData();

    // 请求右侧数据的接口
    void GetRightData(int cid);
}
