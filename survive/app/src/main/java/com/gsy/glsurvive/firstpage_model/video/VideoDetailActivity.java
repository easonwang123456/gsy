package com.gsy.glsurvive.firstpage_model.video;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class VideoDetailActivity extends BaseActivity{
    private VideoFragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<String> tabTitles=new ArrayList<>();
    private ArrayList<EachVideoFragment> mViewList = new ArrayList<>();
    private LinearLayout message_back;

    @Override
    public void addLayout() {
        setContentView(R.layout.activity_video);
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(VideoDetailActivity.this,null);
        EachVideoFragment fragment1= EachVideoFragment.newInstance(1);
        EachVideoFragment fragment2= EachVideoFragment.newInstance(2);
        EachVideoFragment fragment3= EachVideoFragment.newInstance(3);
        EachVideoFragment fragment4= EachVideoFragment.newInstance(4);

        mViewList.add(fragment1);
        mViewList.add(fragment2);
        mViewList.add(fragment3);
        mViewList.add(fragment4);
    }

    @Override
    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_my_video);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_my_video);
        message_back= (LinearLayout) findViewById(R.id.video_back);
        message_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void afterView() {
        tabTitles.add("推荐");
        tabTitles.add("生存");
        tabTitles.add("解说");
        tabTitles.add("娱乐");
        pagerAdapter = new VideoFragmentPagerAdapter(getSupportFragmentManager(),mViewList,tabTitles);
        viewPager.setAdapter(pagerAdapter);
        for(int i=0;i<tabTitles.size();i++){
            Log.e("msg","123");
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(VideoDetailActivity.this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
