package com.gsy.glsurvive.mine_model.modify;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.utils.Sha1;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

/**
 * Created by TR-AND2 on 2017/12/8.
 */

public class ModifyPasswordActivity extends BaseActivity implements ModifyView{
    private LinearLayout forget_back;
    private EditText forget_username,forget_verification,forget_password;
    private TextView forget_getCode,forget_tv;
//    private TimeCount timeCount;
    private CountDownTimer timer;
    @Override
    public void addLayout() {
       setContentView(R.layout.activity_password_reset);
    }

    @Override
    public void initView() {
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(ModifyPasswordActivity.this,null);
        forget_back= (LinearLayout) findViewById(R.id.banner_back);
        forget_username= (EditText) findViewById(R.id.forget_username);
        forget_verification= (EditText) findViewById(R.id.forget_VerificationCode);
        forget_password= (EditText) findViewById(R.id.forget_password);
        forget_getCode= (TextView) findViewById(R.id.forget_getCode);
        forget_tv= (TextView) findViewById(R.id.forget_tv);

    }

    @Override
    public void afterView() {
        //密码重置
      forget_tv.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              new ModifyPresenter(ModifyPasswordActivity.this).modifyRequest(forget_username.getText().toString(),forget_verification.getText().toString(), Sha1.getSha1(forget_password.getText().toString()),ModifyPasswordActivity.this);
          }
      });
        forget_getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ModifyPresenter(ModifyPasswordActivity.this).registerCode(forget_username.getText().toString(),"2",ModifyPasswordActivity.this);
            }
        });
        //返回
        forget_back.setOnClickListener(new View.OnClickListener() {
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

    }

    @Override
    public void startCountDown() {
        timer= new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                forget_getCode.setText(millisUntilFinished / 1000 + "秒");
                forget_getCode.setEnabled(false);//设置不可点击
            }

            @Override
            public void onFinish() {
                forget_getCode.setText("重新获取");
                forget_getCode.setEnabled(true);
            }
        };
//        timeCount.setCountListener(new TimeCount.CountListener() {
//            @Override
//            public void onTick(Long time) {
//                forget_getCode.setText(String.valueOf(time/1000).concat("s后重新获取"));
//                forget_getCode.setEnabled(false);//设置不可点击
//            }
//            @Override
//            public void onFinish() {
//                forget_getCode.setText("重新获取");
//                forget_getCode.setEnabled(true);
//            }
//        });
        timer.start();
    }
}
