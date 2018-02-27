package com.gsy.glsurvive.firstpage_model.gun.gun_detail;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.firstpage_model.gun.FirstGunListResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2018/2/5.
 */

public class GunDetailPresenter {
    private GunDetailView gunDetailView;
    private EachGunDetailFragment eachGunDetailFragment;

    public GunDetailPresenter(EachGunDetailFragment eachGunDetailFragment) {this.eachGunDetailFragment = eachGunDetailFragment;}

    public GunDetailPresenter(GunDetailView gunDetailView) {this.gunDetailView = gunDetailView;}

    public void gunDetail(Context context, int id){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).firstGunDetail(params,id).enqueue(new Callback<GunDetailResult>() {
            @Override
            public void onResponse(Call<GunDetailResult> call, Response<GunDetailResult> response) {
                try {
                 // Log.e("msg","response:"+response.body().string());
                    if(response.body().getCode()==200){
                    gunDetailView.showDetail(response.body().getContent());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<GunDetailResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }

    public void gunDetailDamage(Context context, int id){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).firstGunDetail(params,id).enqueue(new Callback<GunDetailResult>() {
            @Override
            public void onResponse(Call<GunDetailResult> call, Response<GunDetailResult> response) {
                try {
                    // Log.e("msg","response:"+response.body().string());
                    if(response.body().getCode()==200){
                        eachGunDetailFragment.showDamage(response.body().getContent());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<GunDetailResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
    public void gunDetailData(Context context, int id){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).firstGunDetail(params,id).enqueue(new Callback<GunDetailResult>() {
            @Override
            public void onResponse(Call<GunDetailResult> call, Response<GunDetailResult> response) {
                try {
                    // Log.e("msg","response:"+response.body().string());
                    if(response.body().getCode()==200){
                        eachGunDetailFragment.showData(response.body().getContent());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<GunDetailResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }

    public void gunDetailComponent(Context context, int id){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).firstGunDetail(params,id).enqueue(new Callback<GunDetailResult>() {
            @Override
            public void onResponse(Call<GunDetailResult> call, Response<GunDetailResult> response) {
                try {
                    // Log.e("msg","response:"+response.body().string());
                    if(response.body().getCode()==200){
                        eachGunDetailFragment.showComponent(response.body().getContent());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<GunDetailResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
}
