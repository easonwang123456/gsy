package com.gsy.glsurvive.firstpage_model.gun.gun_detail;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/2/5.
 */

public class GunDetailActivity extends BaseActivity implements GunDetailView {
    private  GunDetailFragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<String> tabTitles=new ArrayList<>();
    private ArrayList<EachGunDetailFragment> mViewList = new ArrayList<>();
    private LinearLayout message_back;
    private TextView title,name;
    private ImageView img;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_first_gun_detail);
    }

    @Override
    public void initView() {
        title= (TextView) findViewById(R.id.gun_title);
        name= (TextView) findViewById(R.id.gun_name);
        img= (ImageView) findViewById(R.id.gun_img);
        //设置状态栏
        Intent intent=getIntent();
        StatusBarUtil.setTranslucentForImageView(this,null);
        new GunDetailPresenter(this).gunDetail(this,intent.getIntExtra("id",1));
        EachGunDetailFragment fragment1=EachGunDetailFragment.newInstance(1,intent.getIntExtra("id",1));
        EachGunDetailFragment fragment2=EachGunDetailFragment.newInstance(2,intent.getIntExtra("id",1));
        EachGunDetailFragment fragment3=EachGunDetailFragment.newInstance(3,intent.getIntExtra("id",1));
        mViewList.add(fragment1);
        mViewList.add(fragment2);
        mViewList.add(fragment3);
    }

    @Override
    public void afterView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_gun_detail);
        tabLayout = (TabLayout) findViewById(R.id.tab_gun_detail);
        message_back= (LinearLayout) findViewById(R.id.gun_back);
        tabTitles.add("伤害");
        tabTitles.add("数据");
        tabTitles.add("配件");
        pagerAdapter = new GunDetailFragmentPagerAdapter(getSupportFragmentManager(),mViewList,tabTitles);
        viewPager.setAdapter(pagerAdapter);
        for(int i=0;i<tabTitles.size();i++){
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        message_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void showDetail(GunDetailResult.ContentBean contentBean) {
        Log.e("msg","contentBean.getName():"+contentBean.getName());
        title.setText(contentBean.getName());
        name.setText(contentBean.getName());
        Picasso.with(this).load(contentBean.getImgUrl()).into(img);

    }
}
