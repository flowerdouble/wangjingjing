package com.bwei.xiangmu.mine.register;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.mine.bean.UserBean;
import com.bwei.xiangmu.mine.register.presenter.IRegPresenter;
import com.bwei.xiangmu.mine.register.view.IRegjsterView;
import com.bwei.xiangmu.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends AppCompatActivity implements IRegjsterView{
    @BindView(R.id.Register_back)
    TextView RegisterBack;
    @BindView(R.id.Register_name)
    EditText RegisterName;
    @BindView(R.id.Register_pass)
    EditText RegisterPass;
    @BindView(R.id.Register_password)
    EditText RegisterPassword;
    @BindView(R.id.Register_email)
    EditText RegisterEmail;
    @BindView(R.id.Register_btn)
    Button RegisterBtn;
    IRegPresenter iRegPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        iRegPresenter = new IRegPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @OnClick({R.id.Register_back, R.id.Register_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Register_back:
                finish();
                break;
            case R.id.Register_btn:
                String mobile = RegisterName.getText().toString().trim();
                String pass = RegisterPass.getText().toString().trim();
                String pass2 = RegisterPassword.getText().toString().trim();
                String email = RegisterEmail.getText().toString().trim();
                if ( pass != "" && pass2 != "" && pass.equals(pass2)){
                    if (mobile != "" && email != ""){
                        iRegPresenter.Reg(new UserBean(mobile,pass2));
                    }else{
                        ToastUtil.show(Register.this,"信息不完整", Toast.LENGTH_SHORT);
                    }
                }else{
                    ToastUtil.show(Register.this,"密码不一致",Toast.LENGTH_SHORT);
                }

                break;
        }
    }

    @Override
    public void onRegisterSuccess(String ok) {
        ToastUtil.show(Register.this,ok,2000);
        finish();
    }

    @Override
    public void onRegisterFailed(String error) {

    }
}
