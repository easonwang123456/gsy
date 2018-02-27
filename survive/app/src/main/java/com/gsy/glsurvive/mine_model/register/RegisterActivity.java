package com.gsy.glsurvive.mine_model.register;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.mine_model.setting.update.H5AboutUsActivity;
import com.gsy.glsurvive.utils.Sha1;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.mine_model.login.LoginActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

/**
 * Created by TR-AND2 on 2017/12/7.
 */

public class RegisterActivity extends BaseActivity implements RegisterView {
    private LinearLayout register_back;
    private CountDownTimer timer;
    private TextView register_code;
    private EditText register_username,register_VerificationCode,register_password;
    private TextView register_tv,register_agreement;

    @Override
    public void addLayout() {
        setContentView(R.layout.activity_register);
    }

    @Override
    public void initView() {
        StatusBarUtil.setTranslucentForImageView(RegisterActivity.this,null);
        register_back= (LinearLayout) findViewById(R.id.register_back);
        register_code= (TextView) findViewById(R.id.register_code);
        register_username= (EditText) findViewById(R.id.register_username);
        register_VerificationCode= (EditText) findViewById(R.id.register_VerificationCode);
        register_password= (EditText) findViewById(R.id.register_password);
        register_tv= (TextView) findViewById(R.id.register_tv);
        register_agreement= (TextView) findViewById(R.id.register_agreement);
    }

    @Override
    public void afterView() {
        register_agreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, H5AboutUsActivity.class);
                intent.putExtra("type",6);
                startActivity(intent);
            }
        });
    //请求验证码
    register_code.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        new RegisterPresenter(RegisterActivity.this).registerCode(register_username.getText().toString(),"1",RegisterActivity.this);
    }
});
      //注册
    register_tv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
      new RegisterPresenter(RegisterActivity.this).registerRequest(register_username.getText().toString(), Sha1.getSha1(register_password.getText().toString()),register_VerificationCode.getText().toString(),RegisterActivity.this);
      }
  });
      //返回
        register_back.setOnClickListener(new View.OnClickListener() {
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
        Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void startCountDown() {
        timer= new CountDownTimer(60000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                register_code.setText(millisUntilFinished / 1000 + "秒");
                register_code.setEnabled(false);//设置不可点击
            }

            @Override
            public void onFinish() {
                register_code.setText("重新获取");
                register_code.setEnabled(true);
            }
        };

        timer.start();
    }

}
