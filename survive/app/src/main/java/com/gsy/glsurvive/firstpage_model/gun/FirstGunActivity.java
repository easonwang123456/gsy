package com.gsy.glsurvive.firstpage_model.gun;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.firstpage_model.first_search.FirstSearchActivity;
import com.gsy.glsurvive.mine_model.collect.CollectTypeResult;
import com.gsy.glsurvive.utils.StatusBarUtil;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/29.
 */

public class FirstGunActivity extends BaseActivity implements GunView {
    private GunFragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<String> tabTitles=new ArrayList<>();
    private ArrayList<EachGunFragment> mViewList = new ArrayList<>();
    private LinearLayout message_back;
    private ImageView search;

    @Override
    public void addLayout() {
        //设置状态栏
        setContentView(R.layout.activity_first_gun);
        StatusBarUtil.setTranslucentForImageView(this,null);
        EachGunFragment fragment1=EachGunFragment.newInstance(1);
        EachGunFragment fragment2=EachGunFragment.newInstance(2);
        EachGunFragment fragment3=EachGunFragment.newInstance(3);
        EachGunFragment fragment4=EachGunFragment.newInstance(4);
        EachGunFragment fragment5=EachGunFragment.newInstance(5);
        EachGunFragment fragment6=EachGunFragment.newInstance(6);
//        EachGunFragment fragment7=EachGunFragment.newInstance(7);
//        EachGunFragment fragment8=EachGunFragment.newInstance(8);
//        EachGunFragment fragment9=EachGunFragment.newInstance(9);
        mViewList.add(fragment1);
        mViewList.add(fragment2);
        mViewList.add(fragment3);
        mViewList.add(fragment4);
        mViewList.add(fragment5);
        mViewList.add(fragment6);
//        mViewList.add(fragment7);
//        mViewList.add(fragment8);
//        mViewList.add(fragment9);


    }

    @Override
    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_gun);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_gun);
        message_back= (LinearLayout) findViewById(R.id.gun_back);
        search= (ImageView) findViewById(R.id.gun_search);
        message_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstGunActivity.this, FirstSearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void afterView() {
        new FirstGunPresenter(FirstGunActivity.this).gunType(this);

    }

    @Override
    public void showTitle(ArrayList<GunTypeResult.ContentBean> list) {
        for(int i=0;i<list.size();i++){
            tabTitles.add(list.get(i).getName());
        }
        Log.e("msg",""+tabTitles);
        pagerAdapter = new GunFragmentPagerAdapter(getSupportFragmentManager(),mViewList,tabTitles);
        viewPager.setAdapter(pagerAdapter);
        for(int i=0;i<tabTitles.size();i++){
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


//    interface OnItemClickListener {
//        void onItemClick();
//    }


}
