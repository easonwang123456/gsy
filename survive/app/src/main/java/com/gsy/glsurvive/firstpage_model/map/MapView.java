package com.gsy.glsurvive.firstpage_model.map;

import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.firstpage_model.first_search.HotTopicResult;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/29.
 */

public interface MapView {
    void showMenu(ArrayList<MapDetailResult.ContentBean> list);
}
