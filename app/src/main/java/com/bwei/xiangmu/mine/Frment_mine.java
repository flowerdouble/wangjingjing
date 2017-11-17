package com.bwei.xiangmu.mine;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Long° Engagement on 2017/11/8.
 */

public class Frment_mine extends Fragment {


    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.uesr_tv)
    TextView uesrTv;
    Unbinder unbinder;
    private boolean isLogin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fr_mine, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d("mine", "onResume: ");
        isLogin = (boolean) SharedPreferencesUtils.getParam(getActivity(), "isLogin", false);
        String mobile = (String) SharedPreferencesUtils.getParam(getActivity(), "mobile", "未登录");
        String nickname = (String) SharedPreferencesUtils.getParam(getActivity(), "nickname", "");
        // 如果登陆则传入用户的用户名
        if (isLogin) {
            if (nickname.equals("")){
                nickname = "";
            }
            uesrTv.setText("手机号:" + mobile);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @OnClick({R.id.img, R.id.uesr_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img:
                if (!isLogin) {
                    // 如果没有登陆则跳转到登陆页面
                    Intent intent = new Intent(getActivity(), Login.class);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("是否退出登录")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    isLogin = false;
                                    uesrTv .setText("未登录");
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.create().show();
                }
                break;
            case R.id.uesr_tv:
                break;
        }
    }
}
