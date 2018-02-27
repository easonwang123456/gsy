package com.gsy.glsurvive.data_model;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/21.
 */

public class CarryListPresenter  {
    private CarryListActivity carryListActivity;

    public CarryListPresenter(CarryListActivity carryListActivity) {
        this.carryListActivity = carryListActivity;
    }
    public void carryList(final Context context){
       Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
       ServiceManager.getInstance(context).getService(GuideAPI.class).carryList(params).enqueue(new Callback<CarryListResult>() {
           @Override
           public void onResponse(Call<CarryListResult> call, Response<CarryListResult> response) {
               try {
                Log.e("msg","response:"+response.body().getContent());
                  if(response.body().getCode()==200){
                      carryListActivity.showRecycler(response.body().getContent());
                  }

               } catch (Exception e) {
                   e.printStackTrace();
               }
           }

           @Override
           public void onFailure(Call<CarryListResult> call, Throwable t) {
               Log.e("msg","t:"+t.getMessage());
           }
       });

   }
}
