package com.bwei.xiangmu.xq.view;

import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.mine.bean.LoginBean;
import com.bwei.xiangmu.utils.ApiServer;
import com.bwei.xiangmu.utils.Field;
import com.bwei.xiangmu.utils.ToastUtil;
import com.bwei.xiangmu.xq.bean.DetailsBean;
import com.bwei.xiangmu.xq.view.widget.media.IRenderView;
import com.bwei.xiangmu.xq.view.widget.media.IjkVideoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailsGoodsPageActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.details_linear1)
    LinearLayout detailsLinear1;
    @BindView(R.id.search_goods_title)
    TextView searchGoodsTitle;
    @BindView(R.id.search_goods_subhead)
    TextView searchGoodsSubhead;
    @BindView(R.id.search_goods_bargainPrice)
    TextView searchGoodsBargainPrice;
    @BindView(R.id.search_goods_price)
    TextView searchGoodsPrice;
    @BindView(R.id.search_goods_salenum)
    TextView searchGoodsSalenum;
    @BindView(R.id.kefu)
    RadioButton kefu;
    @BindView(R.id.dianpu)
    RadioButton dianpu;
    @BindView(R.id.shoucang)
    RadioButton shoucang;
    @BindView(R.id.add_cart)
    Button addCart;
    @BindView(R.id.add_buy)
    Button addBuy;
    @BindView(R.id.activity_details_goods_page)
    RelativeLayout activityDetailsGoodsPage;
    @BindView(R.id.video_view)
    IjkVideoView videoView;
    List<LoginBean.DataBean> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_goods_page);
        ButterKnife.bind(this);
        videoView.setAspectRatio(IRenderView.AR_ASPECT_FIT_PARENT);
        videoView.setVideoURI(Uri.parse("http://mp4.vjshi.com/2013-05-28/2013052815051372.mp4"));
        videoView.start();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        String pid = getIntent().getStringExtra("pid");
        ToastUtil.show(DetailsGoodsPageActivity.this, pid, 2000);
        GetData(pid);
    }

    private void GetData(String pid) {
        ApiServer retrofit = new Retrofit.Builder()
                .baseUrl(Field.SORT_DETAILS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(ApiServer.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        Observable<DetailsBean> data = retrofit.getDetailsData(Field.SORT_DETAILS_PATH, map);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DetailsBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("details", "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("details", "onError: ");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        DetailsBean.DataBean data = detailsBean.getData();
                        searchGoodsTitle.setText(data.getTitle());
                        searchGoodsSubhead.setText(data.getSubhead());
                        searchGoodsBargainPrice.setText("商品原价 " + data.getBargainPrice());
                        searchGoodsPrice.setText("￥商品现价" + data.getPrice());
                        searchGoodsSalenum.setText(data.getSalenum() + "人付款");
                    }
                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }
    @Override
    protected void onPause() {
        super.onPause();
        videoView.stopPlayback();
    }

    @OnClick({R.id.add_cart, R.id.add_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_cart:
        /*      //  initPopWindow(view);
               view = LayoutInflater.from(DetailsGoodsPageActivity.this).inflate(R.layout.pop_item, null, false);
                //1.构造一个PopupWindow，参数依次是加载的View，宽高

                final PopupWindow popWindow = new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT, true);
                popWindow.setAnimationStyle(R.anim.anim_pop);  //设置加载动画
                //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
                //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
                //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
                popWindow.setTouchable(true);
                popWindow.setTouchInterceptor(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                        // 这里如果返回true的话，touch事件将被拦截
                        // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                    }
                });
                popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效

                //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
                popWindow.showAsDropDown(view, 200, 1100);*/
              lista = new ArrayList<>();
                for (int i=0;i<lista.size();i++){

                    Toast.makeText(DetailsGoodsPageActivity.this,lista.get(i).getUid(),Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.add_buy:
                break;
        }
    }
}
