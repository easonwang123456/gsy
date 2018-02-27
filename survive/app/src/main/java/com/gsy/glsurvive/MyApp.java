package com.gsy.glsurvive;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;


/**
 * Created by Administrator on 2017/3/6.
 */

public class MyApp extends MultiDexApplication {
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("1106703620", "2ixn5qE1b0HHgtKN");
        PlatformConfig.setSinaWeibo("4198910584", "532db5918f62b2cf8a87d2355fa13223", "https://api.weibo.com/oauth2/default.html");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        UMShareAPI.get(this);
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "3f46e91fe56007466cf3f37881408e7e");
        UMConfigure.setLogEnabled(true);

         PushAgent mPushAgent = PushAgent.getInstance(this);
         mPushAgent.setDebugMode(true);
        //注册推送服务，每次调用register方法都会回调该接口
         mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("msg","deviceToken:"+deviceToken);

            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e("msg","fail:"+s1);
            }
        });

    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
