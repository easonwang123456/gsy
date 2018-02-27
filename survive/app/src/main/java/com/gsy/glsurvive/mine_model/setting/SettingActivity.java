package com.gsy.glsurvive.mine_model.setting;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.mine_model.setting.update.UpdateResult;
import com.gsy.glsurvive.utils.DataCleanManager;
import com.gsy.glsurvive.utils.DisplayUtils;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.utils.ToastUtils;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by TR-AND2 on 2017/12/11.
 */

public class SettingActivity extends BaseActivity implements SettingView{
    private RelativeLayout clear_cache,check_new,about_us,log_out;
    private TextView cache_tv;
    private Switch aSwitch;
    private WifiManager wifiManager;
    private TelephonyManager telephonyManager;
    private ConnectivityManager connectivityManager;
    private Method method;
    private boolean isConnect = false;
    private LinearLayout back;

    @Override
    public void addLayout() {
     setContentView(R.layout.activity_setting);
    }

    @Override
    public void initView() {
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(SettingActivity.this,null);
        getCache();
        back= (LinearLayout) findViewById(R.id.setting_back);
        clear_cache= (RelativeLayout) findViewById(R.id.clear_cache);
        cache_tv= (TextView) findViewById(R.id.cache_tv);
        check_new= (RelativeLayout) findViewById(R.id.check_new);
        about_us= (RelativeLayout) findViewById(R.id.about_us);
        log_out= (RelativeLayout) findViewById(R.id.log_out);
        aSwitch= (Switch) findViewById(R.id.switch_mobile);
    }

    @Override
    public void afterView() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        check_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new SettingPresenter(SettingActivity.this).update(SettingActivity.this);
            }
        });
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            DisplayUtils.showNormalDialog(SettingActivity.this,"确认退出吗？");
            }
        });
    clear_cache.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         new SettingPresenter(SettingActivity.this).clearCache(SettingActivity.this);

        }
    });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 拿到一个wifi管理器，用来管理wifi的开关
                wifiManager = (WifiManager) getApplicationContext().getSystemService(getApplicationContext().WIFI_SERVICE);
                // 拿到一个telphonyManager，用来判断我们现在有没有联网的
                telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
                if (telephonyManager.getDataState() == TelephonyManager.DATA_CONNECTED)
                {
                    isConnect = true;
                }
                // 拿到一个链接管理器，打开和关闭数据链接都通过它控制了
                connectivityManager = (ConnectivityManager)getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                try {
                    method = ConnectivityManager.class.getDeclaredMethod(
                            "setMobileDataEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                if(isChecked){
                  wifiManager.setWifiEnabled(false);
                    try {
                        if(!isConnect){
                        method.invoke(connectivityManager, true);}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    @Override
    public void showcache(String cache) {
        cache_tv.setText(cache);
    }

    @Override
    public void showUpdate(UpdateResult.ContentBean contentBean) {
      ToastUtils.showToast(SettingActivity.this,contentBean.getDescription());
      if(contentBean.isResult()){

      }else{
          ToastUtils.showToast(SettingActivity.this,"当前已是最新版本");
      }
    }


    public void getCache(){
        File file=new File(String.valueOf(SettingActivity.this.getExternalCacheDir()));
        try {
           String cache=new DataCleanManager().getCacheSize(file);
            cache_tv.setText(cache);
        } catch (Exception e) {
            e.printStackTrace();
        }
}}
