package com.gsy.glsurvive.utils;

/**
 * Created by TR-AND2 on 2017/12/5.
 */


public abstract class GlobalConfig {

    public static final boolean isDebug = false; //是否debug模式 很重要【发布一定置为false】否则影响性能

    public static Boolean isOnlineHttp = true; //是否采用线上地址 对于基本类型的静态常量，JAVA在编译的时候就会把代码中对此常量中引用的地方替换成相应常量值。【基本类型反射无效】

    public static final boolean showLog = isDebug; //是否显示log日志

    public static final boolean ALLOW_OPEN_DEV_DIALOG = isDebug; //是否允许开启开发者选框

    public static final boolean OPEN_STATISTICS = true;//关闭/开启统计(所有统计及其相关都将关闭/开启， 新项目、新版本建议关闭)

    public static final boolean SHOW_NET_ERROR = isDebug; //显示错误信息

    public static final int EXIT_APP_DOUBLE_CLICK_TIME = 2000; //双击退出程序时间间隔

    public static final int LAUNCH_TIME = 3000;//欢迎界面展示时间

    public static final boolean isSmoothScrollList = true; //一键回顶,是否平滑滚动列表

//    String ONLINE_HTTP = "http://yuliao.app.fanjian.net/";//线上

    //    String LOCAL_HTTP = "http://test.fanjian.net/api/";//本地
    public static final String LOCAL_HTTP = "http://mobile.gaoshouyou.com/";//本地

    public static final String ONLINE_HTTP = "http://api.gl.gaoshouyou.com/";//线上

    //图片线上服务器(自己服务器上的部分大图需要转换)
    public static final String IMAGE_ONLINE_HTTP = ONLINE_HTTP;

    public static final String APPID = "86654AA913";//头信息

    public static final String APPSECRET = "E972329E3ADAEE9266A9FCC069E9A536";//头信息

    public static final String APP_ID_H5 = "YE100A08E5";//H5追加

    public static final String APP_KEY_H5 = "DSKs4Sf4sEO6sw3qwERdr4";//H5追加

    public static final String SEED = "@!*&$123456";//本地加密

    public static final String BASE64_ENCODED_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgxjoX8D8TyModSbBsmHBOT1QDe3hniomwKMMQ8No95hoy71bX4MwgqaQAEOy6nBzkC2fx9E1mo/N0eH9hETB7505i0nOS7IRN2fWuRum61SHEJEDE3Fm5Vxij5DgZ5y3YOh8616zTc0K01qadNhUUX6iG7wRK00kcrDWIDt0sJcuV+TNCGu0skeiGgl2Eh1TfzSUc/H6RCOpUc4NM1xQtEPEUFll8nJdRgLBZmTiLCdts4aWGTMT70P3Sw0P5nzbTFXr+S1LsYaXYLJ6e1hK97sNIjRrD2b4sYuXYR9Ek7Lrbue0DkIBAxLIspVvkyYDr3nHJOpuoA0A1E+Kculm1QIDAQAB";

}