package com.gsy.glsurvive.data_model.facility;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gsy.glsurvive.firstpage_model.gun.EachGunFragment;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/20.
 */

public class FacilityFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<EachFacilityFragment> list =new ArrayList<>();//ViewPager要填充的fragment列表
    private  ArrayList<String> tabTitles=new ArrayList<>();

    public FacilityFragmentPagerAdapter(FragmentManager fm, ArrayList<EachFacilityFragment> list, ArrayList<String> tabTitles) {
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