package com.gsy.glsurvive.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by TR-AND2 on 2017/12/7.
 */

public class WidgetUtil extends AppCompatActivity {
    private Context context=this;
    /***
     * 跳转
     */
    public  void gotoActivity(Class<?> toactivity,boolean close){
        Intent intent=new Intent(context,toactivity);
        startActivity(intent);
        if(close){
            finish();
        }
    }
}
