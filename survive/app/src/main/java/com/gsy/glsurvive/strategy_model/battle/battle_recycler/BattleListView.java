package com.gsy.glsurvive.strategy_model.battle.battle_recycler;

import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public interface BattleListView {
    void showRecycler(ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> list, int page, int index);
}
