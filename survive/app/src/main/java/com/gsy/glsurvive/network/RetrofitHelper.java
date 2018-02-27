package com.gsy.glsurvive.network;
import android.Manifest;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.gsy.glsurvive.utils.Sha1;
import com.gsy.glsurvive.utils.AndroidUtils;
import com.gsy.glsurvive.utils.GlobalConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.gsy.glsurvive.utils.GlobalConfig.APPID;
import static com.gsy.glsurvive.utils.GlobalConfig.APPSECRET;

public abstract class RetrofitHelper {
    public static final int TIME_OUT = 10_000;
    public static final int TIME_OUT_LONG = 5_000_000;
    private static final String TAG = "RetrofitHelper";
    private Retrofit retrofit;
    protected Context mContext;
    //友盟推送返回标记设备id
    private String deviceToken;

    protected RetrofitHelper(Context mContext) {
        this.mContext = mContext;
        retrofit = getRetrofitBuild(TIME_OUT);
    }

    @NonNull
    private Retrofit getRetrofitBuild(int timeOutMillSeconds) {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(GlobalConfig.ONLINE_HTTP)
                .client(getClient(timeOutMillSeconds))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }


    public <T>T getService(Class<T> c) {
        if (c != null && retrofit != null) {
            return retrofit.create(c);
        }
        return null;
    }

    protected abstract Map<String, String> createHeader();

    public String getChannel() {
        String msg = "";
        try {
            ApplicationInfo appInfo = mContext
                    .getPackageManager()
                    .getApplicationInfo(AndroidUtils.getPackageName(mContext),
                            PackageManager.GET_META_DATA);
            msg = appInfo.metaData.getString("TD_CHANNEL_ID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    private String deviceInfo;
    public String getDeviceInfo() {
        if (TextUtils.isEmpty(deviceInfo)) {
            deviceInfo = AndroidUtils.getDeviceModel() + "(" + AndroidUtils.getSystemVersion()+")";
            //清除空格
            if (deviceInfo.contains(" ")) {
                deviceInfo.replace(" ", "");
            }
        }
        return deviceInfo;
    }

    public OkHttpClient getClient(int timeOutMillSeconds) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                // 向Request Header添加一些业务相关数据，如APP版本，token
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder1 = request.newBuilder();
                        Map<String, String> header = createHeader();
                        if (header != null && header.size() > 0) {
                            Set<String> keys = header.keySet();
                            for (String key : keys) {
                                builder1.addHeader(key, header.get(key)).build();
                            }
                        }
                        Request build = builder1.build();
                        return chain.proceed(build);
                    }
                })
                .retryOnConnectionFailure(true)
                .connectTimeout(timeOutMillSeconds, TimeUnit.MILLISECONDS);
        return builder.build();
    }

    public Map<String, String> getUrlParams() {
        String randomNumber=Integer.toString(new Random().nextInt());
        Map map = new HashMap();
        String timestamp = System.currentTimeMillis() + "";
        timestamp = timestamp.substring(0, 10);//仅取10位
        map.put("random",randomNumber );
        map.put("timestamp", timestamp);
        map.put("sign", Sha1.getSha1(APPID+randomNumber+timestamp+APPSECRET));
        //Log.e("msg",""+getDeviceId(mContext));
        return map;
    }
    public static String getDeviceId(Context context){
        String deviceId = null;
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = tm.getDeviceId();
        }
        return deviceId;
    }
}


