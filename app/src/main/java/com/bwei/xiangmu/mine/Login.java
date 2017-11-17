package com.bwei.xiangmu.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.mine.bean.LoginBean;
import com.bwei.xiangmu.mine.bean.UserBean;
import com.bwei.xiangmu.mine.presenter.IPresenter;
import com.bwei.xiangmu.mine.register.Register;
import com.bwei.xiangmu.mine.view.IView;
import com.bwei.xiangmu.utils.SharedPreferencesUtils;
import com.bwei.xiangmu.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity implements IView{

    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.Login_btn)
    Button LoginBtn;
    @BindView(R.id.mobilea)
    EditText mobilea;
    @BindView(R.id.passworda)
    EditText passworda;
    IPresenter iPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        iPresenter = new IPresenter(this);

    }
    @Override
    protected void onResume() {
        super.onResume();
        /*加载登陆页面设置登陆标志为false*/
        SharedPreferencesUtils.setParam(Login.this, "isLogin", false);
    }

    @OnClick({R.id.zhuce, R.id.Login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuce:
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
                break;
            case R.id.Login_btn:
                String mobile = mobilea.getText().toString().trim();
                String password = passworda.getText().toString().trim();
                iPresenter.getLogin(new UserBean(mobile,password));
                break;

        }
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        SharedPreferencesUtils.setParam(Login.this, "mobile", loginBean.getData().getMobile());
        SharedPreferencesUtils.setParam(Login.this, "isLogin", true);
        if (loginBean.getData().getNickname() == null){
            SharedPreferencesUtils.setParam(Login.this, "nickname", "");
        }else{
            SharedPreferencesUtils.setParam(Login.this, "nickname", loginBean.getData().getNickname());
        }
        // 登陆成功
        ToastUtil.show(Login.this, loginBean.getMsg(), Toast.LENGTH_SHORT);
        // 返回
        finish();
    }

    @Override
    public void onLoginFailed(String error) {
            ToastUtil.show(Login.this,"账号或者密码有误，请重新输入！！",Toast.LENGTH_SHORT);
    }
}
