package com.gsy.glsurvive.strategy_model.gun.gun_recycler;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.strategy_model.gun.GunActivity;
import com.gsy.glsurvive.strategy_model.gun.gun_recycler.GunListActivity;
import com.gsy.glsurvive.strategy_model.gun.gun_recycler.GunListResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class GunPresenter {
    private GunActivity gunActivity;
    private GunListActivity gunListActivity;
    private static int mpage=2;

    public GunPresenter(GunListActivity gunListActivity) {
        this.gunListActivity = gunListActivity;
    }

    public GunPresenter(GunActivity gunActivity) {
        this.gunActivity = gunActivity;
    }

//    public void gunList(Context context){
//        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
//        ServiceManager.getInstance(context).getService(GuideAPI.class).gunList(params).enqueue(new Callback<GunResult>() {
//            @Override
//            public void onResponse(Call<GunResult> call, Response<GunResult> response) {
//                try {
//                    if(response.body().getCode()==200){
//                        gunActivity.showGridView(response.body().getContent());
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GunResult> call, Throwable t) {
//                Log.e("msg","t:"+t.getMessage());
//            }
//        });
//    }

    public void gunRecycler(final Context context, final int type, int limit, final int page, int typeId, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).gunRecycler(params,type,limit,page,typeId).enqueue(new Callback<FirstPageRecommandResult>() {
            @Override
            public void onResponse(Call<FirstPageRecommandResult> call, Response<FirstPageRecommandResult> response) {
                try {
                    if(response.body().getCode()==200){
                        if(index==2){
                            mpage=page+1;
                        }
                        gunListActivity.showRecycler(response.body().getContent().getPostData(),mpage,index);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<FirstPageRecommandResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
}
