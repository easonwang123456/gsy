package com.gsy.glsurvive.mine_model.setting;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.mine_model.setting.update.UpdateResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.DataCleanManager;

import java.io.File;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/13.
 */

public class SettingPresenter {
    private SettingView settingView;

    public SettingPresenter(SettingView settingView) {
        this.settingView = settingView;
    }

    public void clearCache(Context context){
        DataCleanManager.deleteFolderFile(String.valueOf(context.getExternalCacheDir()),true);
        File file=new File(String.valueOf(context.getExternalCacheDir()));
        try {
            String cache=new DataCleanManager().getCacheSize(file);
            settingView.showcache(cache);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).update(params).enqueue(new Callback<UpdateResult>() {
            @Override
            public void onResponse(Call<UpdateResult> call, Response<UpdateResult> response) {
                try {
                    if(response.body().getCode()==200){
                         settingView.showUpdate(response.body().getContent());

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<UpdateResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
}
