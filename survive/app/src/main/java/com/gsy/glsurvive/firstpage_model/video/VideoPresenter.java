package com.gsy.glsurvive.firstpage_model.video;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.firstpage_model.bannerDetail.result.PageLikeResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ShareResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.ToastUtils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class VideoPresenter {
    private static int mpage=2;
    private EachVideoFragment eachVideoFragment;

    public VideoPresenter(EachVideoFragment eachVideoFragment) {
        this.eachVideoFragment = eachVideoFragment;
    }

    public void videoList(Context context, int typeId, int id, final int page, int limit, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).videoList(params,typeId,id,page,limit).enqueue(new Callback<VideoListResult>() {
            @Override
            public void onResponse(Call<VideoListResult> call, Response<VideoListResult> response) {
                try {
                    if(response.body().getCode()==200){
                        if(response.body().getContent()!=null && index==2 ){
                            mpage=page+1;
                        }
                        eachVideoFragment.showVideoList(response.body().getContent(),mpage,index);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<VideoListResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
    public void like(final Context context, int id, int type, final ImageView imageView, final TextView textView, final String num){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();

        ServiceManager.getInstance(context).getService(GuideAPI.class).like(params,id,type).enqueue(new Callback<PageLikeResult>() {
            @Override
            public void onResponse(Call<PageLikeResult> call, Response<PageLikeResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getCode()==200){
                            ToastUtils.showToast(context,response.body().getContent().getMessage());
                            eachVideoFragment.showLike(response.body().getContent().isResult(),imageView,textView,num);
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<PageLikeResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });

    }

    public void share(final Context context, int id, int type){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).share(params,id,type).enqueue(new Callback<ShareResult>() {
            @Override
            public void onResponse(Call<ShareResult> call, Response<ShareResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getCode()==200){
                            eachVideoFragment.showShare(response.body().getContent());
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ShareResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });

    }
}
