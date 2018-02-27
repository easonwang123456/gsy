package com.gsy.glsurvive.adapter;

/**
 * Created by TR-AND2 on 2017/12/1.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gsy.glsurvive.firstpage_model.EachPageFragment;

import java.util.ArrayList;

public class FirstFragmentPagerAdapter extends FragmentPagerAdapter {
   private ArrayList<EachPageFragment> list =new ArrayList<>();//ViewPager要填充的fragment列表
    private  ArrayList<String> tabTitles=new ArrayList<>();

    public FirstFragmentPagerAdapter(FragmentManager fm, ArrayList<EachPageFragment> list, ArrayList<String> tabTitles) {
        super(fm);
        this.list=list;
        this.tabTitles=tabTitles;

    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}