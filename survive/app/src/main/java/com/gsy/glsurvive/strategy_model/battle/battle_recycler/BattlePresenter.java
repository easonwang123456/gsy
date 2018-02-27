package com.gsy.glsurvive.strategy_model.battle.battle_recycler;

import android.content.Context;
import android.util.Log;

import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.strategy_model.battle.BattleActivity;
import com.gsy.glsurvive.strategy_model.battle.battle_recycler.BattleListActivity;
import com.gsy.glsurvive.strategy_model.battle.battle_recycler.BattleListResult;
import com.gsy.glsurvive.utils.LogUtil;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class BattlePresenter {
    private static int mpage=2;
    private BattleActivity battleActivity;
    private BattleListActivity battleListActivity;

    public BattlePresenter(BattleActivity battleActivity) {
        this.battleActivity = battleActivity;
    }

    public BattlePresenter(BattleListActivity battleListActivity) {this.battleListActivity = battleListActivity;}

//    public void battleList(Context context){
//        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
//        ServiceManager.getInstance(context).getService(GuideAPI.class).battleList(params).enqueue(new Callback<BattleResult>() {
//            @Override
//            public void onResponse(Call<BattleResult> call, Response<BattleResult> response) {
//                try {
//                    Log.e("msg","response:"+response.body().getContent());
//                    if(response.body().getCode()==200){
//                        battleActivity.showGridView(response.body().getContent());
//
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BattleResult> call, Throwable t) {
//                Log.e("msg","t:"+t.getMessage());
//            }
//        });
//    }

    public void battleRecycler(final Context context, final int type, int limit, final int page, int typeId, final int index){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).battleList(params,type,limit,page,typeId).enqueue(new Callback<FirstPageRecommandResult>() {
            @Override
            public void onResponse(Call<FirstPageRecommandResult> call, Response<FirstPageRecommandResult> response) {
                try {
                    if(response.body().getCode()==200){
                        if(!response.body().getContent().getPostData().isEmpty() && index==2 ){
                            mpage=page+1;
                        }
                        Log.e("msg","mpage:"+mpage);
                          battleListActivity.showRecycler(response.body().getContent().getPostData(), mpage, index);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<FirstPageRecommandResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
}
