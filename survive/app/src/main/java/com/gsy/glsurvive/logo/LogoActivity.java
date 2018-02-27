package com.gsy.glsurvive.logo;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.MainActivity;
import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.lead.LeadActivity;
import com.gsy.glsurvive.utils.AppUtils;
import com.gsy.glsurvive.utils.ShareUtil;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/15.
 */

public class LogoActivity extends BaseActivity implements LogoView {
    private static int TIME =5;
    private TextView mTime;
    private LinearLayout skip;
    private ImageView img_url,delete;
    private Message message;
    private Button submit;
    private Boolean flag=false;
    private String title,content,downUrl;

    @Override
    public void addLayout() {
        message = handler.obtainMessage(1);
        handler.sendMessageDelayed(message, 1000);

        if(!ShareUtil.getTag(this)){//默认是false
            gotoActivity(LeadActivity.class,true);
         //  message.recycle();
          handler.removeMessages(1);

        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_logo);
        StatusBarUtil.setTranslucentForImageView(LogoActivity.this,null);
    }

    @Override
    public void initView() {
        img_url= (ImageView) findViewById(R.id.lead_img);
        mTime = (TextView) findViewById(R.id.count_down);
        skip= (LinearLayout) findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              goHome();
             handler.removeMessages(1);
            }
        });
    }

    @Override
    public void afterView() {
     new LogoPresenter(LogoActivity.this).leadRequest(LogoActivity.this);
    }


    private void goHome() {
        Intent intent = new Intent(LogoActivity.this, MainActivity.class);
        Log.e("flag",""+flag);
        intent.putExtra("flag",flag);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        intent.putExtra("downUrl",downUrl);
        startActivity(intent);
        finish();
    }


    @Override
    public void showLead(ArrayList<LogoResult.ContentBean.StartBean> list) {
      Picasso.with(LogoActivity.this).load(list.get(0).getImgUrl()).into(img_url);


    }

    @Override
    public void update(final ArrayList<LogoResult.ContentBean.UpdateBean> list) {
        flag=list.get(0).isResult();
        title=list.get(0).getTitle();
        content=list.get(0).getDescription();
        downUrl=list.get(0).getDownUrl();
     }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    TIME--;
                    Log.e("msg","TIME:"+TIME);
                    mTime.setText(TIME + "s");
                    if (TIME > 0) {
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);      // send message
                    } else {
                        //跳转到主界面
                        goHome();
                    }
            }
            super.handleMessage(msg);
        }
    };
}
