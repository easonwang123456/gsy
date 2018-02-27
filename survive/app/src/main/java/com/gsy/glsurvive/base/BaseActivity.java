package com.gsy.glsurvive.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

public abstract class BaseActivity extends AppCompatActivity {
     Activity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        addLayout();
        initView();
        afterView();
        PushAgent.getInstance(BaseActivity.this).onAppStart();

    }
    public abstract void addLayout();
    public abstract void initView();
    public abstract void afterView();
    /***
     * 跳转
     */
    public void gotoActivity(Class<?> toactivity,boolean close){
        Intent intent=new Intent(this,toactivity);
        startActivity(intent);
        if(close){
            finish();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
