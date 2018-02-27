package com.gsy.glsurvive.mine_model.setting;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.mine_model.setting.update.H5AboutUsActivity;
import com.gsy.glsurvive.utils.AppUtils;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.utils.ToastUtils;

/**
 * Created by TR-AND2 on 2018/1/5.
 */

public class AboutUsActivity extends BaseActivity{
    private RelativeLayout website,sina,qq,disclaimer,about_us;
    private LinearLayout back;

    @Override
    public void addLayout() {
        setContentView(R.layout.activity_about_us);
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(AboutUsActivity.this,null);
    }

    @Override
    public void initView() {
     back= (LinearLayout) findViewById(R.id.about_back);
     website= (RelativeLayout) findViewById(R.id.website);
     sina= (RelativeLayout) findViewById(R.id.sina);
     qq= (RelativeLayout) findViewById(R.id.qq);
     disclaimer= (RelativeLayout) findViewById(R.id.disclaimer);
     about_us= (RelativeLayout) findViewById(R.id.about_us);
    }

    @Override
    public void afterView() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
     website.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(AboutUsActivity.this, H5AboutUsActivity.class);
             intent.putExtra("type",1);
             startActivity(intent);
         }
     });

        sina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutUsActivity.this, H5AboutUsActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });

        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.copy2clipboard(AboutUsActivity.this,"27971222");
                ToastUtils.showToast(AboutUsActivity.this,"已复制至剪贴板");
            }
        });

        disclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutUsActivity.this, H5AboutUsActivity.class);
                intent.putExtra("type",4);
                startActivity(intent);
            }
        });
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutUsActivity.this, H5AboutUsActivity.class);
                intent.putExtra("type",5);
                startActivity(intent);
            }
        });
    }
}
