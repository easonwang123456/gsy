package com.gsy.glsurvive.firstpage_model.bannerDetail;
import android.Manifest;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.DownloadUtils;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.utils.ToastUtils;
import com.gsy.glsurvive.view.MyViewPager;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by TR-AND2 on 2018/1/22.
 */

public class ViewPagerActivity extends BaseActivity {
    private TextView current_number,total_number;
    private TextView download;
    private MyViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private CompleteReceiverImg completeReceiver;
    private int getTop;

    @Override
    public void addLayout() {
        setContentView(R.layout.image_viewpager_detail);
        StatusBarUtil.setColor(ViewPagerActivity.this,R.color.black);
        completeReceiver = new CompleteReceiverImg();
        registerReceiver(completeReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    @Override
    public void initView() {
        viewPager= (MyViewPager) findViewById(R.id.viewpager);
        download= (TextView) findViewById(R.id.download_pic);
        current_number= (TextView) findViewById(R.id.current_number);
        total_number= (TextView) findViewById(R.id.total_number);

    }

    @Override
    public void afterView() {
        final Intent intent=getIntent();
        getTop=intent.getIntExtra("getTop",0);
        ArrayList<ImageView> list_img = new ArrayList<>();
        for (int i = 0; i < intent.getStringArrayListExtra("arraylist").size(); i++) {
            PhotoView imageView = new PhotoView(this);
            Picasso.with(ViewPagerActivity.this).load(intent.getStringArrayListExtra("arraylist").get(i)).into(imageView);
            list_img.add(imageView);
            //使图片实现可以放大缩小的功能
           // PhotoViewAttacher mAttacher=new PhotoViewAttacher(imageView);
            imageView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    finish();
                }
            });
            ;
        }

        viewPagerAdapter=new ViewPagerAdapter(list_img,total_number);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(getTop-1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, float positionOffset, int positionOffsetPixels) {
                current_number.setText(""+(position+1));

                download.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (ContextCompat.checkSelfPermission(ViewPagerActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                ToastUtils.showToast(ViewPagerActivity.this, "检查权限是否开启");
                            }else{
                                DownloadUtils.downLoadFile(intent.getStringArrayListExtra("arraylist").get(position),""+System.currentTimeMillis()+".png","image/download",ViewPagerActivity.this);
                            }
                        }else{
                            DownloadUtils.downLoadFile(intent.getStringArrayListExtra("arraylist").get(position),""+System.currentTimeMillis()+".png","image/download",ViewPagerActivity.this);
                        }
                    }
                });
            }
            @Override
            public void onPageSelected(final int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
    class CompleteReceiverImg extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
                ToastUtils.showToast(context,"已下载至image/download");
            }else{
                ToastUtils.showToast(context,"下载失败");
            }


        }
    }


}
