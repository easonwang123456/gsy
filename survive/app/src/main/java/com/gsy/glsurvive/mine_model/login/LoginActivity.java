package com.gsy.glsurvive.mine_model.login;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.mine_model.modify.ModifyPasswordActivity;
import com.gsy.glsurvive.utils.Sha1;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.mine_model.register.RegisterActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

/**
 * Created by TR-AND2 on 2017/12/8.
 */

public class LoginActivity extends BaseActivity implements LoginView {
     private LinearLayout login_back;
     private EditText userName,password;
     private TextView register_now,password_forget,login_tv;
    @Override
    public void addLayout() {
     setContentView(R.layout.activity_login);
    }

    @Override
    public void initView() {
        StatusBarUtil.setTranslucentForImageView(LoginActivity.this,null);
        login_back= (LinearLayout) findViewById(R.id.login_back);
        userName= (EditText) findViewById(R.id.userName);
        password= (EditText) findViewById(R.id.password);
        login_tv= (TextView) findViewById(R.id.login_tv);
        register_now= (TextView) findViewById(R.id.register_now);
        password_forget= (TextView) findViewById(R.id.password_forget);
    }

    @Override
    public void afterView() {
        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登陆
                new LoginPresenter(LoginActivity.this).loginRequest(userName.getText().toString(), Sha1.getSha1(password.getText().toString()),LoginActivity.this);
            }
        });

        //立即注册
        register_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //忘记密码
        password_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, ModifyPasswordActivity.class);
                startActivity(intent);
            }
        });
        //返回
        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void navigateToHome() {
            finish();
    }

}
