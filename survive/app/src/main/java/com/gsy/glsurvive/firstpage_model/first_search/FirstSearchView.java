package com.gsy.glsurvive.firstpage_model.first_search;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public interface FirstSearchView {
    void showRecycler(ArrayList<FirstSearchResult.ContentBean> list,int page,int index);
    void showHots(ArrayList<HotTopicResult.ContentBean.HotsBean> list);
}
