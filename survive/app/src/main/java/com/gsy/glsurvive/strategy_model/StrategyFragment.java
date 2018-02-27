package com.gsy.glsurvive.strategy_model;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.adapter.StrategyFragmentPagerAdapter;
import com.gsy.glsurvive.base.BaseFragment;
import com.gsy.glsurvive.firstpage_model.first_search.FirstSearchActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/11/30.
 */

public class StrategyFragment extends BaseFragment  {
    private StrategyFragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private View view;
    private ArrayList<String> tabTitles=new ArrayList<>();
    private ArrayList<EachStrategyFragment> mViewList = new ArrayList<>();
    private LinearLayout search;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_strategy,container,false);
        search= (LinearLayout) view.findViewById(R.id.strategy_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FirstSearchActivity.class);
                startActivity(intent);
            }
        });
        viewPager = (ViewPager)view.findViewById(R.id.viewpager1);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout1);
        tabTitles.add("推荐");
        tabTitles.add("最新");
        pagerAdapter = new StrategyFragmentPagerAdapter(getFragmentManager(),mViewList,tabTitles);
        viewPager.setAdapter(pagerAdapter);
        for(int i=0;i<tabTitles.size();i++){
            Log.e("msg","123");
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        return view;
    }

    @Override
    public void logic() {
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(getActivity(),null);
        EachStrategyFragment fragment1=EachStrategyFragment.newInstance(1);
        EachStrategyFragment fragment2=EachStrategyFragment.newInstance(2);
        mViewList.add(fragment1);
        mViewList.add(fragment2);

    }

    @Override
    public void httpRequest() {

                    }


}
