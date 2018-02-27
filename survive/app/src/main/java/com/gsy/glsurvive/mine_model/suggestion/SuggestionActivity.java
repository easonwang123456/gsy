package com.gsy.glsurvive.mine_model.suggestion;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

/**
 * Created by TR-AND2 on 2017/12/11.
 */

public class SuggestionActivity extends BaseActivity implements SuggestionView{
    private LinearLayout back,submit;
    private EditText content,contact;

    @Override
    public void addLayout() {
        setContentView(R.layout.activity_suggestion);
    }

    @Override
    public void initView() {
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(SuggestionActivity.this,null);
        back= (LinearLayout) findViewById(R.id.suggestion_back);
        content= (EditText) findViewById(R.id.suggestion_content);
        contact= (EditText) findViewById(R.id.contact);
        submit= (LinearLayout) findViewById(R.id.submit_suggestion);
    }

    @Override
    public void afterView() {
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             new SuggestionPresenter(SuggestionActivity.this).suggestion(SuggestionActivity.this,content.getText().toString(),contact.getText().toString());
            }
        });
    }

    @Override
    public void showFinish() {
        finish();
    }
}
