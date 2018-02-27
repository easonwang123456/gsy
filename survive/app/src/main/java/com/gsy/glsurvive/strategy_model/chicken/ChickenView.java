package com.gsy.glsurvive.strategy_model.chicken;

import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/12.
 */

public interface ChickenView {
    void showChickenRecycler(ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> list,int page,int index);
}
