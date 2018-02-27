package com.gsy.glsurvive.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.gsy.glsurvive.R;
import com.necer.ndialog.NDialog;

public class DisplayUtils {
    public static final String ACTION = "log_out";

    /**
     * 将px值转换为dp值
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dp值转换为px值
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值
     */
    public static int px2sp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值
     */
    public static int sp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidthPixels(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeightPixels(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metric);
        return metric.heightPixels;
    }

    public static void showNormalDialog(final Activity activity,String message){
        new NDialog(activity)
                .setMessageCenter(false)
                .setMessage(message)
                .setMessageSize(16)
                .setNegativeButtonText("再看会儿")
                .setNegativeTextColor(R.color.brown)
                .setPositiveTextColor(R.color.brown)
                .setButtonCenter(false)
                .setButtonSize(14)
                .setCancleable(true)
                .setOnConfirmListener(new NDialog.OnConfirmListener() {
                    @Override
                    public void onClick(int which) {
                        //which,0代表NegativeButton，1代表PositiveButton
                          if(which==1){
                              Intent intent = new Intent(ACTION);
                              activity.sendBroadcast(intent);
                              activity.finish();
                          }
                    }
                }).create(NDialog.CONFIRM).show();

    }
}
