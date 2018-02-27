package com.gsy.glsurvive.firstpage_model.gun;
import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by TR-AND2 on 2017/12/14.
 */

public class FirstGunPresenter {
    private GunView gunView;
    private EachGunFragment eachGunFragment;
    private static int mpage=2;

    public FirstGunPresenter(EachGunFragment eachGunFragment) {this.eachGunFragment = eachGunFragment;}

    public FirstGunPresenter(GunView gunView) {this.gunView = gunView;}

//    public void firstPageRequest(final Context context, final int type, int limit, final int page, int typeId, final int index){
//        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
//        ServiceManager.getInstance(context).getService(GuideAPI.class).firstPageList(params,type,limit,page,typeId).enqueue(new Callback<FirstPageRecommandResult>() {
//            @Override
//            public void onResponse(Call<FirstPageRecommandResult> call, Response<FirstPageRecommandResult> response) {
//                try {
//                    if(response.body().getCode()==200){
//                        if(!response.body().getContent().getPostData().isEmpty() && index==2 ){
//                            mpage=page+1;
//                        }
//                        Log.e("msg","mpage:"+mpage);
//                            eachGunFragment.showRecycler(response.body().getContent().getPostData(), index, mpage);
//
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<FirstPageRecommandResult> call, Throwable t) {
//                Log.e("msg","t:"+t.getMessage());
//            }
//        });
//    }
    public void gunType(Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).gunType(params).enqueue(new Callback<GunTypeResult>() {
            @Override
            public void onResponse(Call<GunTypeResult> call, Response<GunTypeResult> response) {
                try {
                   // Log.e("msg","response:"+response.body().string());
                    if(response.body().getCode()==200){
                        gunView.showTitle(response.body().getContent());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<GunTypeResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }

    public void gunList(Context context,int typeId){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).firstGunList(params,typeId).enqueue(new Callback<FirstGunListResult>() {
            @Override
            public void onResponse(Call<FirstGunListResult> call, Response<FirstGunListResult> response) {
                try {
                  //   Log.e("msg","response:"+response.body().string());
                    if(response.body().getCode()==200){
                        eachGunFragment.showRecycler(response.body().getContent());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<FirstGunListResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
}
