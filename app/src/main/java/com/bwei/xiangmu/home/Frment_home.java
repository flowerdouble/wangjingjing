package com.bwei.xiangmu.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.home.adapter.XRAdapter;
import com.bwei.xiangmu.home.bean.HomeBean;
import com.bwei.xiangmu.home.presenter.IPresenter;
import com.bwei.xiangmu.home.view.IHomeView;
import com.bwei.xiangmu.utils.API;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Long° Engagement on 2017/11/8.
 */

public class Frment_home extends Fragment implements IHomeView{
    int REQUEST_CODE = 01;

    @BindView(R.id.leftImageView)
    ImageView leftImageView;
    @BindView(R.id.titleEditText)
    EditText titleEditText;
    @BindView(R.id.rightImageView)
    ImageView rightImageView;
    Unbinder unbinder;
    @BindView(R.id.XR)
    XRecyclerView XR;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fr_home, null);
        ButterKnife.bind(getActivity());
        XR = view.findViewById(R.id.XR);
        XR.setLayoutManager(new LinearLayoutManager(getActivity()));
        ZXingLibrary.initDisplayOpinion(getActivity());
        IPresenter iPresenter = new IPresenter(this);
        iPresenter.setHome(API.BASE);
        leftImageView = view.findViewById(R.id.leftImageView);

        leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void ShowHomeData(HomeBean.DataBean list) {
        XRAdapter adapter = new XRAdapter(list,getActivity());
        XR.setAdapter(adapter);
    }
}
