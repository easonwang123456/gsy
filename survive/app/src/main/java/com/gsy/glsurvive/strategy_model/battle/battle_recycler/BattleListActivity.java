package com.gsy.glsurvive.strategy_model.battle.battle_recycler;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class BattleListActivity extends BaseActivity implements BattleListView {
    private TextView title;
    private RecyclerView recyclerView;
    private static int loadPage=2;
    private BattleRecyclerAdapter battleRecyclerAdapter;
    private int id;
    private LinearLayout back;
    private ProgressDialog mProgressDialog;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_battle_list);
        battleRecyclerAdapter=new BattleRecyclerAdapter();
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(BattleListActivity.this,null);
        loading();
    }

    @Override
    public void initView() {
        title= (TextView) findViewById(R.id.battle_title);
        recyclerView= (RecyclerView) findViewById(R.id.battle_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(BattleListActivity.this));
        back= (LinearLayout) findViewById(R.id.H5_back);
    }

    @Override
    public void afterView() {
        Intent intent=getIntent();
        title.setText(intent.getStringExtra("title"));
        id=intent.getExtras().getInt("typeId");
        new BattlePresenter(BattleListActivity.this).battleRecycler(BattleListActivity.this,id,10,1,0,1);
        RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.battle_refresh);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                new BattlePresenter(BattleListActivity.this).battleRecycler(BattleListActivity.this,id,10,1,0,1);
                refreshlayout.finishRefresh(1000);

            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                new BattlePresenter(BattleListActivity.this).battleRecycler(BattleListActivity.this,id,10,loadPage,0,2);
                refreshlayout.finishLoadmore(1000);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showRecycler(ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> list, int page, int index) {
        Log.e("msg","dixing:"+list);
        mProgressDialog.dismiss();
        if(!list.isEmpty() & index==1){
            battleRecyclerAdapter.refresh(list,BattleListActivity.this);
            recyclerView.setAdapter(battleRecyclerAdapter);
            loadPage=2;
        }
        if(!list.isEmpty() & index==2){
            loadPage=page;
            battleRecyclerAdapter.addDatas(list,BattleListActivity.this);
        }

        battleRecyclerAdapter.setOnItemClickListener(new BattleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id, int type) {
             Intent intent=new Intent(BattleListActivity.this, BannerDetailActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });
    }
    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(BattleListActivity.this, R.style.CustomProgressDialog);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
        mProgressDialog.setContentView(R.layout.loading_dialog);
        mProgressDialog.setOnKeyListener(onKeyListener);
    }
    //判断mProgressDialog的消失条件
    private DialogInterface.OnKeyListener onKeyListener = new DialogInterface.OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                mProgressDialog.dismiss();
            }
            return false;
        }
    };
}
