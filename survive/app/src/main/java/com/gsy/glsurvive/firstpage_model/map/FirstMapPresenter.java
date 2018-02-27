package com.gsy.glsurvive.firstpage_model.map;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.firstpage_model.first_search.HotTopicResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2018/1/29.
 */

public class FirstMapPresenter {
    private MapView mapView;

    public FirstMapPresenter(MapView mapView) {
        this.mapView = mapView;
    }

    public void mapMenu(Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).firstMapDetail(params).enqueue(new Callback<MapDetailResult>() {
            @Override
            public void onResponse(Call<MapDetailResult> call, Response<MapDetailResult> response) {

                try {
                    if(response.body().getCode()==200){
                        mapView.showMenu(response.body().getContent());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<MapDetailResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }
}
