package com.gsy.glsurvive.firstpage_model.rookie;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class RookiePresenter {
    private static int mpage=2;
    private RookieActivity rookieActivity;

    public RookiePresenter(RookieActivity rookieActivity) {
        this.rookieActivity = rookieActivity;
    }
    public void rookieList(Context context, int limit, final int page, int typeId, final int order, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).rookieList(params,limit,page,typeId,order).enqueue(new Callback<RookieResult>() {
            @Override
            public void onResponse(Call<RookieResult> call, Response<RookieResult> response) {
                try {
                    if(response.body().getCode()==200){
                        if(index==2){
                            mpage=page+1;
                        }
                        Log.e("msg","mpage:"+mpage);
                     rookieActivity.showRecycler(response.body().getContent().getPostData(), mpage,index);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<RookieResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
}
