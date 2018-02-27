package com.gsy.glsurvive.data_model.facility;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.data_model.CarryListResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.LogUtil;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2018/2/8.
 */

public class FacilityPresenter {
    private EachFacilityFragment eachFacilityFragment;

    public FacilityPresenter(EachFacilityFragment eachFacilityFragment) {
        this.eachFacilityFragment = eachFacilityFragment;
    }

    public void componentList(Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).facilityList(params).enqueue(new Callback<FacilityResult>() {
            @Override
            public void onResponse(Call<FacilityResult> call, Response<FacilityResult> response) {
                try {
                    if(response.body().getCode()==200){
                      eachFacilityFragment.showComponentList(response.body().getContent().getPeijian());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<FacilityResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
    public void amorList(Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).facilityList(params).enqueue(new Callback<FacilityResult>() {
            @Override
            public void onResponse(Call<FacilityResult> call, Response<FacilityResult> response) {
                try {
                    if(response.body().getCode()==200){
                        eachFacilityFragment.showAmorList(response.body().getContent().getFangju());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<FacilityResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
    public void propList(Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).facilityList(params).enqueue(new Callback<FacilityResult>() {
            @Override
            public void onResponse(Call<FacilityResult> call, Response<FacilityResult> response) {
                try {
                    if(response.body().getCode()==200){
                        eachFacilityFragment.showPropList(response.body().getContent().getDaoju());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<FacilityResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
}
