package com.gsy.glsurvive.firstpage_model.rookie;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public interface RookieView {
    void showRecycler(ArrayList<RookieResult.ContentBean.PostDataBean> list,int page,int index);
}
