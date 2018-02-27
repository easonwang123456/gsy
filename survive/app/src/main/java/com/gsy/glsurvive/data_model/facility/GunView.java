package com.gsy.glsurvive.data_model.facility;

import com.gsy.glsurvive.firstpage_model.gun.GunTypeResult;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public interface GunView {
    void showTitle(ArrayList<GunTypeResult.ContentBean> list);

}
