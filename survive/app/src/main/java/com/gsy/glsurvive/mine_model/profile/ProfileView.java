package com.gsy.glsurvive.mine_model.profile;

import android.widget.PopupWindow;

/**
 * Created by TR-AND2 on 2017/12/11.
 */

public interface ProfileView {
    void showMessage();// 显示信息
    void dismissPopWindow(PopupWindow popupWindow);
    void showImgUrl(String url);
    void showResetUserInfo( ProfileResult.PostBean postBean);

}
