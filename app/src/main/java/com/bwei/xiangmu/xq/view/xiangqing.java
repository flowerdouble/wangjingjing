package com.bwei.xiangmu.xq.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.xq.adapter.MyxqAdApter;
import com.bwei.xiangmu.xq.bean.ParBean;
import com.bwei.xiangmu.xq.presenter.IParPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class xiangqing extends AppCompatActivity implements IView {
    IParPresenter iParPresenter;
    MyxqAdApter adApter;
    @BindView(R.id.sub_classification_recyclerview)
    RecyclerView subClassificationRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String pscid = getIntent().getStringExtra("pscid");
        iParPresenter = new IParPresenter(this);
        iParPresenter.GetData(pscid);
    }

    @Override
    public void ShowData(ParBean parBean) {
        adApter = new MyxqAdApter(parBean,xiangqing.this);
        subClassificationRecyclerview.setLayoutManager(new GridLayoutManager(xiangqing.this,1));
        subClassificationRecyclerview.setAdapter(adApter);
    }
}
