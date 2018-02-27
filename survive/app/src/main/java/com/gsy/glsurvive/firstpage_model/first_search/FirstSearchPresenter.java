package com.gsy.glsurvive.firstpage_model.first_search;
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

public class FirstSearchPresenter {
    private FirstSearchActivity firstSearchActivity;
    private static int mpage=2;

    public FirstSearchPresenter(FirstSearchActivity firstSearchActivity) {
        this.firstSearchActivity = firstSearchActivity;
    }

    public void firstSearch(final Context context, String keyWord, int limit, final int page, String type, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).firstPageSearch(params,keyWord,limit,page,type).enqueue(new Callback<FirstSearchResult>() {
            @Override
            public void onResponse(Call<FirstSearchResult> call, Response<FirstSearchResult> response) {
                try {
                  if(response.body().getCode()==200){
                      if(!response.body().getContent().isEmpty() && index==2 ){
                          mpage=page+1;
                      }
                      Log.e("msg","page:"+page);
                      Log.e("msg","mpage:"+mpage);
                      Log.e("msg","list:"+response.body().getContent());
                      firstSearchActivity.showRecycler(response.body().getContent(),mpage,index);
                  }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<FirstSearchResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }
    public void hotTopic(Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).searchHot(params).enqueue(new Callback<HotTopicResult>() {
            @Override
            public void onResponse(Call<HotTopicResult> call, Response<HotTopicResult> response) {
                try {
                    firstSearchActivity.showHots(response.body().getContent().getHots());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<HotTopicResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
}
}
