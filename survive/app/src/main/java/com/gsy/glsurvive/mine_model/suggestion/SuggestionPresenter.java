package com.gsy.glsurvive.mine_model.suggestion;

import android.content.Context;
import android.util.Log;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.ToastUtils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2018/1/3.
 */

public class SuggestionPresenter {
    private SuggestionView suggestionView;

    public SuggestionPresenter(SuggestionView suggestionView) {
        this.suggestionView = suggestionView;
    }

    public void suggestion(final Context context, String text, String contact){
          Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
          ServiceManager.getInstance(context).getService(GuideAPI.class).suggestion(params,text,contact).enqueue(new Callback<SuggestionResult>() {
              @Override
              public void onResponse(Call<SuggestionResult> call, Response<SuggestionResult> response) {
                  try {
                        Log.e("msg","msg:"+response.body().getContent().getMessage());
                        Log.e("msg","code:"+response.body().getCode());
                          ToastUtils.showToast(context,response.body().getContent().getMessage());
                          suggestionView.showFinish();


                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              }

              @Override
              public void onFailure(Call<SuggestionResult> call, Throwable t) {
                  ToastUtils.showToast(context,t.getMessage());

              }
          });
      }
}
