package com.gsy.glsurvive.lead;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gsy.glsurvive.MainActivity;
import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

public class LeadActivity extends BaseActivity {
    private ViewPager viewPager;
    private LinearLayout enter;

    @Override
    public void addLayout() {
        setContentView(R.layout.leadviewpager);
        StatusBarUtil.setTranslucentForImageView(LeadActivity.this,null);
    }

    @Override
    public void initView() {
        enter= (LinearLayout) findViewById(R.id.enter);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        //数据源图片
        ImageView[] views=new ImageView[3];
        for(int i=0;i<views.length;i++){
            views[i]=new ImageView(this);
        }
        views[0].setBackgroundResource(R.drawable.a);
        views[1].setBackgroundResource(R.drawable.b);
        views[2].setBackgroundResource(R.drawable.c);

        //设置适配器
        viewPager.setAdapter(new ViewPagerAdapter(views));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                Log.e("msg","被选中："+position);
                if(position==2){
                    enter.setVisibility(View.VISIBLE);
                    enter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           gotoActivity(MainActivity.class,true);
                        }
                    });

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void afterView() {

        //ShareUtil.saveTag(this);
    }


}
