package com.gsy.glsurvive.utils;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppUtils {

    /**
     * 获取版本名称
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    /**
     * 获取版本号
     */
    public static int getAppVersionCode(Context context) {
        int versioncode = -1;
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versioncode = pi.versionCode;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versioncode;
    }

    public static String getIMEI(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    /**
     * 显示软键盘
     */
    public static void openSoftInput(EditText et) {
        InputMethodManager inputMethodManager = (InputMethodManager) et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(et, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 隐藏软键盘
     */
    public static void hideSoftInput(EditText et) {
        InputMethodManager inputMethodManager = (InputMethodManager) et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(et.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 获取SD卡路径
     *
     * @return 如果sd卡不存在则返回null
     */
    public static File getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);   //判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir;
    }

    /**
     * 安装文件
     *
     * @param data
     */
    public static void promptInstall(Context context, Uri data) {
        Intent promptInstall = new Intent(Intent.ACTION_VIEW)
                .setDataAndType(data, "application/vnd.android.package-archive");
        // FLAG_ACTIVITY_NEW_TASK 可以保证安装成功时可以正常打开 app
        promptInstall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(promptInstall);
    }

    public static void copy2clipboard(Context context, String text) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("clip", text);
        cm.setPrimaryClip(clip);
    }
    public static void startBrower(Context context,String uri)
    {
        startBrower(context,Uri.parse(uri));
    }
    static void startBrower(Context context,Uri uri)
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
         /*其实可以不用添加该Category*/
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         /*如果想用浏览器打开本地html文件的话，则只能通过显式intent启动浏览器*/
        boolean explicitMode=false;
        String scheme=uri.getScheme();
        if(scheme!=null&&scheme.startsWith("file")) {
            explicitMode=true;
        }
        if(explicitMode) {
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        } else {
            intent.addCategory("android.intent.category.BROWSABLE");
        }
        context.startActivity(intent);
    }




    /**
     * 下载新版本程序
     */
    public static void loadNewVersionProgress(final Context context, final String downUrl) {
        final ProgressDialog pd;    //进度条对话框
        pd = new  ProgressDialog(context);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
        pd.show();
        //启动子线程下载任务
        new Thread(){
            @Override
            public void run() {
                try {
                    File file = getFileFromServer(downUrl, pd);
                    //sleep(2000);
                    installApk(file,context);
                    pd.dismiss(); //结束掉进度条对话框
                } catch (Exception e) {
                    //下载apk失败
                    Toast.makeText(context, "下载新版本失败", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }}.start();
    }

    /**
     * 安装apk
     */
    public static void installApk(File file,Context context) {
        Intent intent = new Intent();
        //执行动作
        intent.setAction(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //判读版本是否在7.0以上
        if (Build.VERSION.SDK_INT >= 24) {
            //provider authorities
            Uri apkUri = FileProvider.getUriForFile(context, "com.gsy.glsurvive.fileprovider", file);
            //Granting Temporary Permissions to a URI
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }

        context.startActivity(intent);

    }

    /**
     * 从服务器获取apk文件的代码
     * 传入网址uri，进度条对象即可获得一个File文件
     * （要在子线程中执行哦）
     */
    public static File getFileFromServer(String uri, ProgressDialog pd) throws Exception{
        //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            URL url = new URL(uri);
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //获取到文件的大小
            pd.setMax(conn.getContentLength()/1024/1024);
            InputStream is = conn.getInputStream();
            long time= System.currentTimeMillis();//当前时间的毫秒数
            File file = new File(Environment.getExternalStorageDirectory(), time+".apk");
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len ;
            int total=0;
            while((len =bis.read(buffer))!=-1){
                fos.write(buffer, 0, len);
                total+= len;
                //获取当前下载量
                pd.setProgress(total/1024/1024);
                // pd.setProgressNumberFormat(""+(total/1024/1024)+"M");

            }
            fos.close();
            bis.close();
            is.close();
            return file;
        }
        else{
            return null;
        }
    }
}
