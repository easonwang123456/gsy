package com.gsy.glsurvive.mine_model.register;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.LogUtil;
import com.gsy.glsurvive.utils.ToastUtils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/7.
 */

public class RegisterPresenter {

    private RegisterView registerView;
    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
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
                              registerView.startCountDown();
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
    public void registerRequest(String userName, String passWord, String code, final Context context){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).register(params,userName,passWord,code).enqueue(new Callback<RegisterResult>() {
            @Override
            public void onResponse(Call<RegisterResult> call, Response<RegisterResult> response) {
                try {
                    if(response.body().getCode()==200){
                      ToastUtils.showToast(context,response.body().getContent().getMessage());
                      registerView.navigateToHome();
                    }
                    ToastUtils.showToast(context,response.body().getContent().getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<RegisterResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }
}
