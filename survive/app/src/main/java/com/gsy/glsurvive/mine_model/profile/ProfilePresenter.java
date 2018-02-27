package com.gsy.glsurvive.mine_model.profile;
import android.content.Context;
import android.util.Log;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.CustomDatePicker;
import com.gsy.glsurvive.utils.LogUtil;
import com.gsy.glsurvive.utils.ToastUtils;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/11.
 */

public class ProfilePresenter{
    private ProfileView profileView;
    CustomDatePicker customDatePicker;

    public ProfilePresenter(ProfileView profileView) {
        this.profileView = profileView;
    }
    public void profileUpload(final Context context, String nickName, String sex, String signature, String birthday, String location){
        LogUtil.e("msg","nickName:"+nickName+"  sex:"+sex+" signature:"+signature+"  birthday:"+birthday+"  location:"+location);
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).userInfoReset(params,nickName,sex,signature,birthday,location).enqueue(new Callback<ProfileResult>() {
            @Override
            public void onResponse(Call<ProfileResult> call, Response<ProfileResult> response) {
                try {
                        if(response.body().getContent().isResult()==true) {

                            ToastUtils.showToast(context,response.body().getContent().getMessage());
                            profileView.showResetUserInfo(response.body().getPost());
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ProfileResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }
    public void imgUrlUpLoad(final Context context, String imgUrl){
//            MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);//表单类型
              if(imgUrl==null) return;

              File file = new File(imgUrl);
//            RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/JPEG"), file);
//            builder.addFormDataPart("headerData", file.getName(), photoRequestBody);
//            List<MultipartBody.Part> parts = builder.build().parts();
        // 创建 RequestBody，用于封装构建RequestBody
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

       // MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body = MultipartBody.Part.createFormData("userImg", file.getName(), requestFile);

        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).userImageReset(params,body).enqueue(new Callback<ImgUrlResult>() {
            @Override
            public void onResponse(Call<ImgUrlResult> call, Response<ImgUrlResult> response) {
                try {
                    if(response.body().getCode()==200){
                        Log.e("msg","msg:"+response.body().getContent().getMessage());
                        profileView.showImgUrl(response.body().getContent().getImgUrl());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ImgUrlResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }

}
