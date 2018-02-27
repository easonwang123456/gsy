package com.gsy.glsurvive.mine_model.collect;

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

public class MyCollectActivity extends BaseActivity implements MyCollectView{
    private CollectFragmentPagerAdapter  pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<String> tabTitles=new ArrayList<>();
    private ArrayList<EachCollectFragment> mViewList = new ArrayList<>();
    private LinearLayout message_back;


    @Override
    public void addLayout() {
        //设置状态栏
        setContentView(R.layout.activity_my_collect);
        StatusBarUtil.setTranslucentForImageView(MyCollectActivity.this,null);
        EachCollectFragment fragment1=EachCollectFragment.newInstance(1);
        EachCollectFragment fragment2=EachCollectFragment.newInstance(2);
        EachCollectFragment fragment3=EachCollectFragment.newInstance(3);
        EachCollectFragment fragment4=EachCollectFragment.newInstance(4);
        EachCollectFragment fragment5=EachCollectFragment.newInstance(5);
        mViewList.add(fragment1);
        mViewList.add(fragment2);
        mViewList.add(fragment3);
        mViewList.add(fragment4);
        mViewList.add(fragment5);

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
        new MyCollectPresenter(MyCollectActivity.this).collectType(MyCollectActivity.this);

    }

    @Override
    public void showTitle(ArrayList<CollectTypeResult.ContentBean> list) {
        for(int i=0;i<list.size();i++){
            tabTitles.add(list.get(i).getTypeName());
        }
        Log.e("msg",""+tabTitles);
        pagerAdapter = new CollectFragmentPagerAdapter(getSupportFragmentManager(),mViewList,tabTitles);
        viewPager.setAdapter(pagerAdapter);
        for(int i=0;i<tabTitles.size();i++){
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }


//    interface OnItemClickListener {
//        void onItemClick();
//    }


}
