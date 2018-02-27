package com.gsy.glsurvive.data_model;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/21.
 */

public class CarryListActivity extends BaseActivity implements CarryListView{
    private DataAdapter dataAdapter;
    private RecyclerView recyclerView;
    private LinearLayout back;
    private ProgressDialog mProgressDialog;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_carry_detail);
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(CarryListActivity.this,null);
        dataAdapter=new DataAdapter();
        loading();
    }

    @Override
    public void initView() {
    recyclerView= (RecyclerView) findViewById(R.id.carry_recycler);
        back= (LinearLayout) findViewById(R.id.carry_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void afterView() {
     new CarryListPresenter(CarryListActivity.this).carryList(CarryListActivity.this);

    }

    @Override
    public void showRecycler(ArrayList<CarryListResult.ContentBean> list) {
        mProgressDialog.dismiss();
        recyclerView.setLayoutManager(new LinearLayoutManager(CarryListActivity.this));
        dataAdapter.addDatas(list,CarryListActivity.this);
        recyclerView.setAdapter(dataAdapter);
    }
    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(CarryListActivity.this, R.style.CustomProgressDialog);
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
