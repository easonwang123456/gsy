package com.gsy.glsurvive.firstpage_model.bannerDetail;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
   private ArrayList<ImageView> list=new ArrayList<>();
    private TextView total;

    public ViewPagerAdapter(ArrayList<ImageView> list,TextView total)
    {
        this.list = list;
        this.total=total;
    }

    @Override
    public int getCount() {                                                                 //获得size
        // TODO Auto-generated method stub
        total.setText(""+list.size());
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.e("msg","销毁的position"+position);

        container.removeView((View) object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        PhotoView photoView=new PhotoView();
        container.addView(list.get(position));
      //  Log.e("msg","生成的position"+position);
        return list.get(position);
    }

}



