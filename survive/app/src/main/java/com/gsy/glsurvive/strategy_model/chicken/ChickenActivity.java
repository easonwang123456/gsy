package com.gsy.glsurvive.strategy_model.chicken;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.firstpage_model.EachPageFragment;
import com.gsy.glsurvive.firstpage_model.FirstPagePresenter;
import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoListDetailActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class ChickenActivity extends BaseActivity implements ChickenView{
    private static int loadPage=2;
    private RecyclerView recyclerView;
    private ChickenRecyclerAdapter chickenRecyclerAdapter;
    private LinearLayout back;
    private ProgressDialog mProgressDialog;
    private int id;
    private TextView title_tv;
    @Override
    public void addLayout() {
         setContentView(R.layout.activity_chicken);
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(ChickenActivity.this,null);
        loading();
    }

    @Override
    public void initView() {
        title_tv= (TextView) findViewById(R.id.title_tv);
        back= (LinearLayout) findViewById(R.id.chicken_back);
        recyclerView= (RecyclerView) findViewById(R.id.chicken_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(ChickenActivity.this));
        chickenRecyclerAdapter=new ChickenRecyclerAdapter();

    }

    @Override
    public void afterView() {
        Intent intent=getIntent();
        title_tv.setText(intent.getStringExtra("title"));
        id=intent.getExtras().getInt("typeId");
        new ChickenPresenter(ChickenActivity.this).chickenRecycler(ChickenActivity.this,id,10,1,0,1);
        RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.chicken_refresh);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new ChickenPresenter(ChickenActivity.this).chickenRecycler(ChickenActivity.this,id,10,1,0,1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    new ChickenPresenter(ChickenActivity.this).chickenRecycler(ChickenActivity.this,id,10,loadPage,0,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });
        chickenRecyclerAdapter.setOnItemClickListener(new ChickenRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id, int type, ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> list) {
                if(type==13){
                    Intent intent=new Intent(ChickenActivity.this, VideoListDetailActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("type",type);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(ChickenActivity.this, BannerDetailActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("type",type);
                    startActivity(intent);
                }
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
    public void showChickenRecycler(ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> list,int page,int index) {
        mProgressDialog.dismiss();
        if(index==1){
            chickenRecyclerAdapter.refresh(list,this);
            recyclerView.setAdapter(chickenRecyclerAdapter);
            loadPage=2;
        }
        if(!list.isEmpty() && index==2){
            loadPage=page;
            chickenRecyclerAdapter.addDatas(list,this);
        }

    }
    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(ChickenActivity.this, R.style.CustomProgressDialog);
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
