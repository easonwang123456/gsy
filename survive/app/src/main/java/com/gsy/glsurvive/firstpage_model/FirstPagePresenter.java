package com.gsy.glsurvive.firstpage_model;



import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.LogUtil;

import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by TR-AND2 on 2017/12/14.
 */

public class FirstPagePresenter {

    private EachPageFragment eachPageFragment;
    private static int mpage=2;
    public FirstPagePresenter(EachPageFragment eachPageFragment) {
        this.eachPageFragment = eachPageFragment;
    }

    public void firstPageRequest(final Context context, final int type, int limit, final int page, int typeId, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).firstPageList(params,type,limit,page,typeId).enqueue(new Callback<FirstPageRecommandResult>() {
            @Override
            public void onResponse(Call<FirstPageRecommandResult> call, Response<FirstPageRecommandResult> response) {
                try {
                    if(response.body().getCode()==200){
                        if(!response.body().getContent().getPostData().isEmpty() && index==2 ){
                            mpage=page+1;
                        }
                        Log.e("msg","mpage:"+mpage);
                     if(type==0) {
                        LogUtil.e("msg","response.body().getContent().getPostData().size:"+response.body().getContent().getPostData().size());
                        LogUtil.e("msg","response.body().getContent().getPostData().:"+response.body().getContent().getPostData());
                            eachPageFragment.showRecycler(response.body().getContent().getPostData(), index, mpage);
                            eachPageFragment.showMenu(response.body().getContent().getMenu());
                            eachPageFragment.showBanner(response.body().getContent().getBanner());
                        }else{
                            eachPageFragment.showRecycler(response.body().getContent().getPostData(), index, mpage);
                        }

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
