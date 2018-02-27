package com.gsy.glsurvive.mine_model.message;

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

public class MyMessagePresenter {
    private static int mpage=2;
    private EachMessageFragment eachMessageFragment;

    public MyMessagePresenter(EachMessageFragment eachMessageFragment) {
        this.eachMessageFragment = eachMessageFragment;
    }

    public void messageLike(Context context, int limit, final int page, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).messageLike(params,limit,page).enqueue(new Callback<MessageLikeResult>() {
            @Override
            public void onResponse(Call<MessageLikeResult> call, Response<MessageLikeResult> response) {
                try {
                    if(response.body().getCode()==200){
                        if(!response.body().getContent().isEmpty() && index==2 ){
                            mpage=page+1;
                        }
                  eachMessageFragment.messageLikeList(response.body().getContent(),mpage,index);


                    }
                    //Log.e("msg","response:"+response.body().string());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MessageLikeResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
    public void messageReply(Context context, int limit, final int page, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).replyComment(params,limit,page).enqueue(new Callback<ReplyMessageResult>() {
            @Override
            public void onResponse(Call<ReplyMessageResult> call, Response<ReplyMessageResult> response) {
                try {
                    if(response.body().getCode()==200){
                        if(!response.body().getContent().isEmpty() && index==2 ){
                            mpage=page+1;
                        }
                      eachMessageFragment.messageReplyList(response.body().getContent(),mpage,index);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ReplyMessageResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
}
