package com.bwei.xiangmu.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.sort.adapter.LeftAdapter;
import com.bwei.xiangmu.sort.adapter.RightAdapter;
import com.bwei.xiangmu.sort.bean.LeftBean;
import com.bwei.xiangmu.sort.bean.RightBean;
import com.bwei.xiangmu.sort.presenter.ISortPresenter;
import com.bwei.xiangmu.sort.view.ISortView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * Created by Long° Engagement on 2017/11/8.
 */

public class Frment_sort extends Fragment implements ISortView {
    ISortPresenter isortpresenter;
    LeftAdapter leftAdapter;
    @BindView(R.id.sort_left_listview)
    ListView sortLeftListview;
    Unbinder unbinder;
    @BindView(R.id.sort_right_listview)
    ListView sortRightListview;
    RightAdapter right_adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fr_sort, null);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }
    private void init() {
        isortpresenter = new ISortPresenter(this);
        isortpresenter.GetData();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void ShowLeftData(LeftBean leftBean) {
        Log.d("main2", "ShowLeftData: "+leftBean.getData().get(0).getName()+"==");
        leftAdapter = new LeftAdapter(leftBean, getActivity());
        sortLeftListview.setAdapter(leftAdapter);
        leftClick();
    }
    @Override
    public void ShowRightData(final RightBean rightBean) {
        right_adapter = new RightAdapter(rightBean, getActivity());
        sortRightListview.setAdapter(right_adapter);
       //右侧条目点击
    /*    right_adapter.GetItemData(new RightAdapter.GetItemData() {
            @Override
            public void getItemData(String name, String pscid) {
            }
        });*/
    }
    private void leftClick() {
        leftAdapter.setClickName(new LeftAdapter.ClickName() {
            @Override
            public void Clickname(int cid) {
                //展示右侧的数据
                isortpresenter.GetRightData(cid);
            }
        });

    }


}
