package com.gsy.glsurvive.network;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.gsy.glsurvive.utils.Sha1;
import com.gsy.glsurvive.utils.AndroidUtils;
import com.gsy.glsurvive.utils.LogUtil;

import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;

import static com.gsy.glsurvive.utils.GlobalConfig.APPID;
import static com.gsy.glsurvive.utils.GlobalConfig.APPSECRET;

/**
 * Created by TR-AND2 on 2017/12/5.
 */
public class ServiceManager extends RetrofitHelper {

    private static ServiceManager INSTANCE;

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public ServiceManager(Context context) {
        super(context);
    }


    public static ServiceManager getInstance(Context context) {
        if (INSTANCE == null) {
            if (INSTANCE == null) {
                synchronized (ServiceManager.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new ServiceManager(context);
                    }
                }
            }
        }
        return INSTANCE;
    }

    public Map<String, String> createHeader() {
        SharedPreferences sharedPreferences=mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String userId=sharedPreferences.getString("userId",null);//如果取不到，那默认值为空
        String randomNumber=Integer.toString(new Random().nextInt());
        String timestamp = System.currentTimeMillis() + "";
        Map<String, String> headers = new WeakHashMap<>();
        headers.put("packageName",AndroidUtils.getPackageName(mContext));
       // LogUtil.e("msg",""+AndroidUtils.getPackageName(mContext));
        headers.put("appId", APPID);
        headers.put("nonce", randomNumber);
        headers.put("timestamp", timestamp);
        headers.put("version", AndroidUtils.getVersionName(mContext));
        headers.put("versionCode", AndroidUtils.getVersionCode(mContext) + "");
        headers.put("device", 1 + "");
        headers.put("deviceInfo", getDeviceInfo());
        String deviceToken = getDeviceToken();
       // Log.e("msg","deviceToken:"+deviceToken);
        Log.e("msg","getDeviceInfo():"+getDeviceInfo());
        if (!TextUtils.isEmpty(deviceToken)) {
            headers.put("device_token", deviceToken);
        }
        String channel = getChannel();
        if (!TextUtils.isEmpty(channel)) {
            headers.put("channel", channel);//渠道名, 屏蔽广告
        }
        headers.put("userId", userId + "");
        headers.put("sign", Sha1.getSha1(APPID+userId+randomNumber+timestamp+APPSECRET) );
        Log.d("createHeader", "createHeader: " + headers);
        return headers;
    }
//
//    public String getChannel() {
//        String msg = "";
//        try {
//            ApplicationInfo appInfo = BaseApplication.getInstance()
//                    .getPackageManager()
//                    .getApplicationInfo(AndroidUtils.getPackageName(BaseApplication.getInstance()),
//                            PackageManager.GET_META_DATA);
//            msg = appInfo.metaData.getString("TD_CHANNEL_ID");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return msg;
//    }
//
//    @Deprecated
//    public String getBaseURLParams() {
//        String randomCode = Encryption.getRandomCode();
//        String timestamp = System.currentTimeMillis() + "";
//        StringBuilder sb = new StringBuilder();
//        sb.append("?");
//        String deviceId = getTokenId();
//        UserEntity user = UserManager.getInstance().getUser();
//        String id = "0";//未登录为0
//        if (user != null) {
//            id = user.getId();
//        }
//        if (TextUtils.isEmpty(id)) {
//            id = "0";
//        }
//        sb.append("userId=" + id + "&");
//        sb.append("tokenId="+ deviceId +"&");
//        sb.append("timestamp="+timestamp+"&");
//        sb.append("nonce="+randomCode+"&");
//        sb.append("device=2&");
//   sb.append("packageName=" + AndroidUtils.getPackageName(mContext) + "&");
//        sb.append("sign="+ Encryption.getSingCode(GlobalConfig.APP_KEY, randomCode, timestamp, GlobalConfig.APP_ID)+"&");
//        Log.d("getBaseParams" ,""+GlobalConfig.APP_ID + deviceId + timestamp+randomCode);
//        sb.append("versionCode="+ AndroidUtils.getVersionCode(mContext) +"&");
//        sb.append("version="+ AndroidUtils.getVersionName(mContext));
//        Log.d("tag",sb.toString());
//        return sb.toString();
//    }

//    /**H5 GET方式加密 请求基本参数**/
//    public String getBaseParams() {
//        UserEntity user = UserManager.getInstance().getUser();
//        String id = "0";//未登录为0
//        String session = "";
//        if (user != null) {
//            id = user.getId();
//            session = user.getSession();
//        }
//        if (TextUtils.isEmpty(id)) {
//            id = "0";
//        }
//        return getBaseParams(id, session);
//    }
//    public String getBaseParams(String userId, String session) {
//        userId = URLEncoder.encode(userId);
//        String randomCode = Encryption.getRandomCode();
//        String timestamp = System.currentTimeMillis() + "";
//        StringBuilder sb = new StringBuilder();
//        sb.append("?");
//        String tokenId = getTokenId();
//        sb.append("tokenId=" + tokenId + "&");
//        sb.append("timestamp=" + timestamp + "&");
//        sb.append("nonce=" + randomCode + "&");
//        sb.append("deviceInfo=" + getDeviceInfo() + "&");
//        sb.append("session=" + session + "&");
//        String channel = getChannel();
//        if (!TextUtils.isEmpty(channel)) {
//            sb.append("channel=" + channel + "&");//渠道名
//        }
//        sb.append("userId=" + userId + "&");
//        sb.append("device=2&");
//        //sign = md5(appId+userId+tokenId+timestamp+nonce+appKey)  GDWWc+aeHeumnF8EUSuIOw==
//        sb.append("sign="+Encryption.getSingCodeToUrl(GlobalConfig.APP_ID_H5, userId, tokenId, timestamp,
//                randomCode, GlobalConfig.APP_KEY_H5)+"&");
////        LogUtil.d("getBaseParams" ,""+ GlobalConfig.APP_ID+userId+tokenId+timestamp+randomCode);
//        sb.append("versionCode="+ AndroidUtils.getVersionCode(mContext) +"&");
//        sb.append("version="+ AndroidUtils.getVersionName(mContext));
//
//        String msg = sb.toString();
//        LogUtil.d("getBaseParams", " msg = " + msg, " userId = " + userId);
//        return msg;
//    }
//


}
