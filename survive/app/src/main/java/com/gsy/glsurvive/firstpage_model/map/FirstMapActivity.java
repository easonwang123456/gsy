package com.gsy.glsurvive.firstpage_model.map;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.firstpage_model.first_search.FirstSearchActivity;
import com.gsy.glsurvive.firstpage_model.first_search.HotTopicResult;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.view.Tag;
import com.gsy.glsurvive.view.TagListView;
import com.gsy.glsurvive.view.TagView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by TR-AND2 on 2018/1/29.
 */

public class FirstMapActivity extends BaseActivity implements MapView {
     private ImageView map,search;
     private LinearLayout back;
     private TagListView tagListView;
     private ProgressDialog mProgressDialog;
     private TextView content,all_resource,wash_car,wash_boat,poor_rich,advanced_gun;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_first_map);
        StatusBarUtil.setTranslucentForImageView(this,null);
        loading();
    }

    @Override
    public void initView() {
     all_resource= (TextView) findViewById(R.id.all_resource);
     wash_car= (TextView) findViewById(R.id.wash_car);
     wash_boat= (TextView) findViewById(R.id.wash_boat);
     poor_rich= (TextView) findViewById(R.id.poor_rich);
     advanced_gun= (TextView) findViewById(R.id.advanced_gun);
     content= (TextView) findViewById(R.id.content);
     map= (ImageView) findViewById(R.id.map_iv);
     back= (LinearLayout) findViewById(R.id.map_back);
     search= (ImageView) findViewById(R.id.map_search);
    }

    @Override
    public void afterView() {
        //使图片实现可以放大缩小的功能
       PhotoViewAttacher mAttacher=new PhotoViewAttacher(map);

        new FirstMapPresenter(FirstMapActivity.this).mapMenu(this);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstMapActivity.this,FirstSearchActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(this, R.style.CustomProgressDialog);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
        mProgressDialog.setContentView(R.layout.loading_dialog);
        mProgressDialog.setOnKeyListener(onKeyListener);
    }
    //判断mProgressDialog的消失条件
    private DialogInterface.OnKeyListener onKeyListener = new DialogInterface.OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                mProgressDialog.dismiss();
            }
            return false;
        }
    };

    @Override
    public void showMenu(final ArrayList<MapDetailResult.ContentBean> list) {
        mProgressDialog.dismiss();
        Picasso.with(FirstMapActivity.this).load(list.get(0).getImgUrl()).into(map);
        content.setText(list.get(0).getText());
        all_resource.setText(list.get(0).getName());
        wash_car.setText(list.get(1).getName());
        wash_boat.setText(list.get(2).getName());
        poor_rich.setText(list.get(3).getName());
        advanced_gun.setText(list.get(4).getName());
        all_resource.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Picasso.with(FirstMapActivity.this).load(list.get(0).getImgUrl()).into(map);
                  content.setText(list.get(0).getText());

              }
          });
        wash_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(FirstMapActivity.this).load(list.get(1).getImgUrl()).into(map);
                content.setText(list.get(1).getText());

            }
        });
        wash_boat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(FirstMapActivity.this).load(list.get(2).getImgUrl()).into(map);
                content.setText(list.get(2).getText());

            }
        });
        poor_rich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(FirstMapActivity.this).load(list.get(3).getImgUrl()).into(map);
                content.setText(list.get(3).getText());

            }
        });
        advanced_gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(FirstMapActivity.this).load(list.get(4).getImgUrl()).into(map);
                content.setText(list.get(4).getText());

            }
        });




    }
}
