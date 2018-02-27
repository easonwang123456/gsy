package com.gsy.glsurvive.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.WindowManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by TR-AND2 on 2017/12/12.
 */

public class PermissionUtil {

    final public static int REQUEST_CODE_ASK_STORAGE = 123;

    public static void setCameraPermisson(Activity activity){
        if (Build.VERSION.SDK_INT >= 23) {
            if(ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE_ASK_STORAGE);
                return;
            }else{
                Log.e("msg", "权限申请ok");
            }
        } else {

        }
    }

    public static void backgroundAlpha(float bgAlpha,Activity activity) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        activity.getWindow().setAttributes(lp);
    }

    public static String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date) + ".jpg";
    }

}
