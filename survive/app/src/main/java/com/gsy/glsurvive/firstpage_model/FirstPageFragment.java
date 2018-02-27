package com.gsy.glsurvive.firstpage_model;

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
import com.gsy.glsurvive.adapter.FirstFragmentPagerAdapter;
import com.gsy.glsurvive.base.BaseFragment;
import com.gsy.glsurvive.entity.FirstPageTitleEntity;
import com.gsy.glsurvive.firstpage_model.first_search.FirstSearchActivity;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2017/11/30.
 */

public class FirstPageFragment extends BaseFragment {
    private FirstFragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private View view;
    private ArrayList<String> tabTitles=new ArrayList<>();
    private ArrayList<EachPageFragment> mViewList = new ArrayList<>();
    private LinearLayout search_img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_firstpage,container,false);
        search_img= (LinearLayout) view.findViewById(R.id.first_page_search);
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        pagerAdapter = new FirstFragmentPagerAdapter(getFragmentManager(),mViewList,tabTitles);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for(int i=0;i<tabTitles.size();i++){
            tabLayout.addTab(tabLayout.newTab());
        }
    search_img.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Intent intent=new Intent(getActivity(), FirstSearchActivity.class);
          startActivity(intent);
      }
  });
        return view;
    }

    @Override
    public void logic() {
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(getActivity(),null);
        EachPageFragment fragment1=EachPageFragment.newInstance(1);
        EachPageFragment fragment2=EachPageFragment.newInstance(2);
        EachPageFragment fragment3=EachPageFragment.newInstance(3);
        EachPageFragment fragment4=EachPageFragment.newInstance(4);
//        EachFacilityFragment fragment5=EachFacilityFragment.newInstance(5);
//        EachFacilityFragment fragment6=EachFacilityFragment.newInstance(6);
        mViewList.add(fragment1);
        mViewList.add(fragment2);
        mViewList.add(fragment3);
        mViewList.add(fragment4);
//        mViewList.add(fragment5);
//        mViewList.add(fragment6);


    }

    @Override
    public void httpRequest() {
        Map<String, String> params = ServiceManager.getInstance(getActivity()).getUrlParams();
        ServiceManager.getInstance(getActivity()).getService(GuideAPI.class).firstPageList(params).enqueue(new Callback<FirstPageTitleEntity>() {
            @Override
            public void onResponse(Call<FirstPageTitleEntity> call, Response<FirstPageTitleEntity> response) {
                try {
                    if(response.isSuccessful()){
                       for(int i=0;i<response.body().getContent().size();i++){
                         tabTitles.add(response.body().getContent().get(i).getName());
                       }
                        viewPager.setAdapter(pagerAdapter);
                        tabLayout.setupWithViewPager(viewPager);
                        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<FirstPageTitleEntity> call, Throwable t) {
                Log.e("msg","T:"+t.getMessage());
            }
        });
    }
}
