package com.gsy.glsurvive.strategy_model.battle;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.strategy_model.battle.battle_recycler.BattleListActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class BattleActivity extends BaseActivity implements BattleView{
     private GridAdapter gridAdapter;
     private GridView gridView;
     private TextView title;
     private LinearLayout back;
    private ProgressDialog mProgressDialog;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_battle);
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(BattleActivity.this,null);
        loading();

    }

    @Override
    public void initView() {
         Intent intent=getIntent();
         gridView= (GridView) findViewById(R.id.battle_gridView);
         title= (TextView) findViewById(R.id.H5_title);
         back= (LinearLayout) findViewById(R.id.H5_back);
         title.setText(intent.getStringExtra("title"));
    }

    @Override
    public void afterView() {
     //   new BattlePresenter(BattleActivity.this).battleList(BattleActivity.this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showGridView(final ArrayList<BattleResult.ContentBean> list) {
        mProgressDialog.dismiss();
        gridAdapter=new GridAdapter(BattleActivity.this,list);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(BattleActivity.this,BattleListActivity.class);
                intent.putExtra("title",list.get(position).getName());
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);

            }
        });
    }
    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(BattleActivity.this, R.style.CustomProgressDialog);
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
