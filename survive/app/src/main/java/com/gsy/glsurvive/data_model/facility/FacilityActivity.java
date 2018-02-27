package com.gsy.glsurvive.data_model.facility;

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
import com.gsy.glsurvive.firstpage_model.gun.*;
import com.gsy.glsurvive.firstpage_model.gun.GunView;
import com.gsy.glsurvive.utils.StatusBarUtil;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/29.
 */

public class FacilityActivity extends BaseActivity implements GunView {
    private FacilityFragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<String> tabTitles=new ArrayList<>();
    private ArrayList<EachFacilityFragment> mViewList = new ArrayList<>();
    private LinearLayout message_back;
    private ImageView search;

    @Override
    public void addLayout() {
        //设置状态栏
        setContentView(R.layout.activity_facility);
        StatusBarUtil.setTranslucentForImageView(this,null);
        EachFacilityFragment fragment1=EachFacilityFragment.newInstance(1);
        EachFacilityFragment fragment2=EachFacilityFragment.newInstance(2);
        EachFacilityFragment fragment3=EachFacilityFragment.newInstance(3);

        mViewList.add(fragment1);
        mViewList.add(fragment2);
        mViewList.add(fragment3);

    }

    @Override
    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_facility);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_facility);
        message_back= (LinearLayout) findViewById(R.id.facility_back);
        search= (ImageView) findViewById(R.id.facility_search);
        message_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FacilityActivity.this, FirstSearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void afterView() {
        tabTitles.add("配件");
        tabTitles.add("防具");
        tabTitles.add("道具");
        pagerAdapter = new FacilityFragmentPagerAdapter(getSupportFragmentManager(),mViewList,tabTitles);
        viewPager.setAdapter(pagerAdapter);
        for(int i=0;i<tabTitles.size();i++){
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    public void showTitle(ArrayList<GunTypeResult.ContentBean> list) {

    }

}
