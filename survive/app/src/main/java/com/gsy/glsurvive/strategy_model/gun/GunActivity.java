package com.gsy.glsurvive.strategy_model.gun;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.strategy_model.gun.gun_recycler.GunListActivity;
import com.gsy.glsurvive.strategy_model.gun.gun_recycler.GunPresenter;
import com.gsy.glsurvive.utils.StatusBarUtil;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class GunActivity extends BaseActivity implements GunView {
    private GridAdapter gridAdapter;
    private GridView gridView;
    private TextView title;
    private LinearLayout back;
    private ProgressDialog mProgressDialog;
    @Override
    public void addLayout() {
     setContentView(R.layout.activity_gun);
        //设置状态栏
     StatusBarUtil.setTranslucentForImageView(GunActivity.this,null);
     loading();
    }

    @Override
    public void initView() {
        Intent intent=getIntent();
        title= (TextView) findViewById(R.id.H5_title);
        gridView= (GridView) findViewById(R.id.gun_gridView);
        back= (LinearLayout) findViewById(R.id.H5_back);
        title.setText(intent.getStringExtra("title"));
    }

    @Override
    public void afterView() {
        //new GunPresenter(GunActivity.this).gunList(GunActivity.this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showGridView(final ArrayList<GunResult.ContentBean> list) {
        mProgressDialog.dismiss();
        gridAdapter=new GridAdapter(GunActivity.this,list);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(GunActivity.this,GunListActivity.class);
                intent.putExtra("title",list.get(position).getName());
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);
            }
        });
    }
    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(GunActivity.this, R.style.CustomProgressDialog);
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
}
