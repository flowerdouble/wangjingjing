package com.bwei.xiangmu.utils;

import com.bwei.xiangmu.home.bean.HomeBean;
import com.bwei.xiangmu.mine.bean.LoginBean;
import com.bwei.xiangmu.mine.register.bean.RegBean;
import com.bwei.xiangmu.sort.bean.LeftBean;
import com.bwei.xiangmu.sort.bean.RightBean;
import com.bwei.xiangmu.xq.bean.DetailsBean;
import com.bwei.xiangmu.xq.bean.ParBean;

import java.util.HashMap;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {
    @GET("/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBean> getHome();
    @GET
    Observable<LoginBean> getLogin(@Url String url);
    @GET
    Observable<RegBean> getReg(@Url String url);
    // 分类 左侧接口
    @GET
    Observable<LeftBean> getLeftData(@Url String url);
    // 分类 右侧接口
    @POST
    Observable<RightBean> getRightData(@Url String url, @QueryMap HashMap<String,String> map);
    @POST
    Observable<ParBean> getRightSubItem(@Url String url, @QueryMap HashMap<String,String> map);

    // 详情页的接口
    @POST
    Observable<DetailsBean> getDetailsData(@Url String url, @QueryMap HashMap<String,String> map);
}
