package com.gsy.glsurvive.mine_model.collect;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class MyCollectPresenter {
    private MyCollectView myCollectView;
    private EachCollectFragment eachCollectFragment;
    private static int mpage=2;

    public MyCollectPresenter(MyCollectView myCollectView) {
      this.myCollectView = myCollectView;
   }

    public MyCollectPresenter(EachCollectFragment eachCollectFragment) {this.eachCollectFragment = eachCollectFragment;
    }

    public void collectType(Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).collectType(params).enqueue(new Callback<CollectTypeResult>() {
            @Override
            public void onResponse(Call<CollectTypeResult> call, Response<CollectTypeResult> response) {
                try {
                    Log.e("msg","response:"+response.body().getContent());
                    if(response.body().getCode()==200){
                        myCollectView.showTitle(response.body().getContent());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CollectTypeResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }

    public void collectList(Context context, int type, int limit, final int page, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).collectList(params,type,limit,page).enqueue(new Callback<CollectListResult>() {
            @Override
            public void onResponse(Call<CollectListResult> call, Response<CollectListResult> response) {
                try {
                    if(response.body().getCode()==200){
                        Log.e("msg","page:"+page);
                        Log.e("msg","response.body().getContent():"+response.body().getContent());
                        if(response.body().getContent()!=null && index==2 ){
                            mpage=page+1;
                        }
                        Log.e("msg","listc:"+response.body().getContent());
                       eachCollectFragment.showCollectList(response.body().getContent(),mpage,index);
//                        if(type==0) {
//                            eachPageFragment.showRecycler(response.body().getContent().getPostData(), index, mpage);
//                            eachPageFragment.showMenu(response.body().getContent().getMenu());
//                            eachPageFragment.showBanner(response.body().getContent().getBanner());
//                        }else{
//                            eachPageFragment.showRecycler(response.body().getContent().getPostData(), index, mpage);
//                        }
//
                   }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CollectListResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }

    public void collectCancel(Context context, String collectId, final int position){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).cancelCollect(params,collectId).enqueue(new Callback<CollectDeleteResult>() {
            @Override
            public void onResponse(Call<CollectDeleteResult> call, Response<CollectDeleteResult> response) {
                try {
                    if(response.body().getCode()==200){
                        eachCollectFragment.showDelete(position);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CollectDeleteResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }

}
