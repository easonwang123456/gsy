package com.gsy.glsurvive.logo;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2018/1/15.
 */

public class LogoPresenter {
    private LogoView logoView;

    public LogoPresenter(LogoView logoView) {
        this.logoView = logoView;
    }

    public void leadRequest(final Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).initAPP(params).enqueue(new Callback<LogoResult>() {
            @Override
            public void onResponse(Call<LogoResult> call, Response<LogoResult> response) {
                try {
                Log.e("msg","response:"+response.body().getContent().getStart());
                 logoView.showLead(response.body().getContent().getStart());
                 logoView.update(response.body().getContent().getUpdate());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<LogoResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
}
