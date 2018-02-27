package com.gsy.glsurvive.firstpage_model.rookie;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
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

public class RookieActivity extends BaseActivity implements RookieView{
    private RecyclerView recyclerView;
    public RookieAdapter mAdapter;
    private int loadPage=2;
    private Boolean flag=false;
    private LinearLayout back;
    private ProgressDialog mProgressDialog;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_rookie);
        loading();

    }

    @Override
    public void initView() {
        back= (LinearLayout) findViewById(R.id.rookie_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView= (RecyclerView)findViewById(R.id.rookie_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(RookieActivity.this));
        mAdapter=new RookieAdapter();
        RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.rookie_refresh);

            Log.e("msg","123");
             new RookiePresenter(RookieActivity.this).rookieList(RookieActivity.this,10,1,0,1,1);

            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new RookiePresenter(RookieActivity.this).rookieList(RookieActivity.this,10,1,0,1,1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    new RookiePresenter(RookieActivity.this).rookieList(RookieActivity.this,10,loadPage,0,1,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });
    }

    @Override
    public void afterView() {
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(RookieActivity.this,null);
    }

    @Override
    public void showRecycler(ArrayList<RookieResult.ContentBean.PostDataBean> list,int page,int index) {
        mProgressDialog.dismiss();
        if(!list.isEmpty() & index==1){
            mAdapter.refresh(list,RookieActivity.this);
            recyclerView.setAdapter(mAdapter);
            loadPage=2;
        }
        if(!list.isEmpty() & index==2){
            loadPage=page;
            mAdapter.addDatas(list,RookieActivity.this);
            // recyclerView.setAdapter(mAdapter);
        }
//        if(list.size()==0){
//            Toast.makeText(getActivity(), "没有了...", Toast.LENGTH_SHORT).show();
//        }
        mAdapter.setOnItemClickListener(new RookieAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position, int id, int type) {
                if(type==13){
                    Intent intent=new Intent(RookieActivity.this, VideoListDetailActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("type",type);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(RookieActivity.this, BannerDetailActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("type",type);
                    startActivity(intent);
                }

            }
        });
    }
    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(RookieActivity.this, R.style.CustomProgressDialog);
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
