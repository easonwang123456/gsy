package com.gsy.glsurvive.mine_model.login;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.ToastUtils;

import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/8.
 */

public class LoginPresenter {
    public static final String ACTION = "change_header";
    private LoginView loginView;
    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void loginRequest(String userName, String password, final Context context){


        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();

        ServiceManager.getInstance(context).getService(GuideAPI.class).login(params,userName,password).enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                try {
                    if(response.isSuccessful()){
                        ToastUtils.showToast(context,response.body().getContent().getMessage());
                        Log.e("msg",""+response.body().getContent().getUserId());
                        if(response.body().getContent().isResult()==true) {
                            loginView.showMessage(response.body().getContent().getMessage());
                            SharedPreferences sharedPreferences=context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                            //对数据进行编辑，返回editor对象
                            SharedPreferences.Editor editor =sharedPreferences.edit();
                            editor.putString("userId", ""+response.body().getContent().getUserId());
                            editor.putString("nickName", ""+response.body().getContent().getNickName());
                            editor.putString("money", ""+response.body().getContent().getMoney());
                            editor.putString("imgUrl", ""+response.body().getContent().getImgUrl());
                            editor.putString("signature", ""+response.body().getContent().getSignature());
                            Log.e("msg","234:"+response.body().getContent().getUserId());
                            editor.commit();//将数据持久化到存储介质中
                            loginView.navigateToHome();
                            Intent intent = new Intent(ACTION);
                            context.sendBroadcast(intent);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }
}
