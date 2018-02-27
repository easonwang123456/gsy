package com.gsy.glsurvive.strategy_model;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/18.
 */

public class EachStrategyPresenter {
    private EachStrategyFragment eachStrategyFragment;
    private static int mpage=2;
    public EachStrategyPresenter(EachStrategyFragment eachStrategyFragment) {
        this.eachStrategyFragment = eachStrategyFragment;
    }

    public void strategyRequest(final Context context, final int limit, final int page, int typeId, final int order, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).strategyList(params,limit,page,typeId,order).enqueue(new Callback<EachStrategyResult>() {
            @Override
            public void onResponse(Call<EachStrategyResult> call, Response<EachStrategyResult> response) {
                try {
                    //Log.e("msg","response123:"+response.body().string());
                    if(response.body().getCode()==200){
                        if(index==2){
                            mpage=page+1;
                        }
                        Log.e("msg","mpage:"+mpage);
                        if(order==1) {
                           eachStrategyFragment.showRecycler(response.body().getContent().getPostData(), index, mpage);
                           eachStrategyFragment.showMenu(response.body().getContent().getMenu());
                           eachStrategyFragment.showBanner(response.body().getContent().getBanner());
                           eachStrategyFragment.showHot(response.body().getContent().getHotData());

                        }else{
                            eachStrategyFragment.showRecycler(response.body().getContent().getPostData(), index, mpage);
                       }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<EachStrategyResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }

}
