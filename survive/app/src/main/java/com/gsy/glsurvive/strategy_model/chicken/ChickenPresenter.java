package com.gsy.glsurvive.strategy_model.chicken;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2018/1/12.
 */

public class ChickenPresenter {
    private  ChickenActivity chickenActivity;
    private static int mpage=2;

    public ChickenPresenter(ChickenActivity chickenActivity) {
        this.chickenActivity = chickenActivity;
    }

    public void chickenRecycler(final Context context, final int type, int limit, final int page, int typeId, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).battleList(params,type,limit,page,typeId).enqueue(new Callback<FirstPageRecommandResult>() {
            @Override
            public void onResponse(Call<FirstPageRecommandResult> call, Response<FirstPageRecommandResult> response) {
                try {
                    if(response.body().getCode()==200){
                        if(!response.body().getContent().getPostData().isEmpty() && index==2 ){
                            mpage=page+1;
                        }
                        Log.e("msg","mpage:"+mpage);
                        chickenActivity.showChickenRecycler(response.body().getContent().getPostData(), mpage, index);
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
