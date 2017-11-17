package com.bwei.xiangmu.utils;

/**
 * Created by Administrator on 2017/10/19 0019.
 */

public class Field {
    public static final String LOGIN_URL = "http://120.27.23.105/";
    public static final String REG_URL = "http://120.27.23.105/";

    public static final String HOME_PATH = "http://result.eolinker.com/";
    // 分类左侧接口
    public static final String SORT_LEFT = "http://120.27.23.105/";
    public static final String SORT_LEFT_PATH = "product/getCatagory";
    public static final String SEARCHE_GOODS = "http://120.27.23.105/"; // 拼接?keywords=笔记本&page=1
    public static final String SEARCHE_GOODS_PATH = "product/searchProducts"; // 拼接?keywords=笔记本&page=1
    // 分类右侧接口
    public static final String SORT_RIGHT = "http://120.27.23.105/";
    public static final String SORT_RIGHT_PATH = "product/getProductCatagory";

    // 子分类下的商品列表接口
    public static final String SORT_RIGHT_ITEM = "http://120.27.23.105/";
    public static final String SORT_RIGHT_ITEM_PATH = "product/getProducts";

    // 详情页单条目的接口
    public static final String SORT_DETAILS = "http://120.27.23.105/";
    public static final String SORT_DETAILS_PATH = "product/getProductDetail";
}
