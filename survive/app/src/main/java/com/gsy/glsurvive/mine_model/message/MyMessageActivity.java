package com.gsy.glsurvive.mine_model.message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class MyMessageActivity extends BaseActivity {
    private MessageFragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<String> tabTitles=new ArrayList<>();
    private ArrayList<EachMessageFragment> mViewList = new ArrayList<>();
    private LinearLayout message_back;

    @Override
    public void addLayout() {
     setContentView(R.layout.activity_my_message);
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(MyMessageActivity.this,null);
        EachMessageFragment fragment1=EachMessageFragment.newInstance(1);
        EachMessageFragment fragment2=EachMessageFragment.newInstance(2);
        EachMessageFragment fragment3=EachMessageFragment.newInstance(3);

        mViewList.add(fragment1);
        mViewList.add(fragment2);
        mViewList.add(fragment3);

    }

    @Override
    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_my_message);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_my_message);
        message_back= (LinearLayout) findViewById(R.id.message_back);
        message_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void afterView() {
        tabTitles.add("赞我的");
        tabTitles.add("回复我的");
        tabTitles.add("系统消息");
        pagerAdapter = new  MessageFragmentPagerAdapter(getSupportFragmentManager(),mViewList,tabTitles);
        viewPager.setAdapter(pagerAdapter);
        for(int i=0;i<tabTitles.size();i++){
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }
}
