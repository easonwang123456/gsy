package com.gsy.glsurvive.mine_model.modify;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.mine_model.register.RegisterCodeResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.LogUtil;
import com.gsy.glsurvive.utils.ToastUtils;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/8.
 */

public class ModifyPresenter {
    private ModifyView modifyView;

    public ModifyPresenter(ModifyView modifyView) {
        this.modifyView = modifyView;
    }
    public void modifyRequest(String userName, String code, String passWord, final Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).refindPassword(params,userName,code,passWord).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if(response.isSuccessful()){
                        LogUtil.e("msg","response:"+response.body().string());
                        ToastUtils.showToast(context,response.message());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }
    public void registerCode(String userName, String codeType, final Context context){
        LogUtil.e("msg","username:"+userName);
        LogUtil.e("msg","code:"+codeType);
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).code(params,userName,codeType).enqueue(new Callback<RegisterCodeResult>() {
            @Override
            public void onResponse(Call<RegisterCodeResult> call, Response<RegisterCodeResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getContent().isResult()==true){
                            modifyView.startCountDown();
                        }
                        ToastUtils.showToast(context,response.body().getContent().getMessage());
                        LogUtil.e("msg","response:"+response.body());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<RegisterCodeResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }
}
