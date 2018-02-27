package com.gsy.glsurvive.mine_model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.mine_model.collect.MyCollectActivity;
import com.gsy.glsurvive.mine_model.login.LoginActivity;
import com.gsy.glsurvive.mine_model.login.LoginPresenter;
import com.gsy.glsurvive.mine_model.message.MyMessageActivity;
import com.gsy.glsurvive.mine_model.register.RegisterActivity;
import com.gsy.glsurvive.mine_model.profile.ProfileActivity;
import com.gsy.glsurvive.mine_model.setting.SettingActivity;
import com.gsy.glsurvive.mine_model.suggestion.SuggestionActivity;
import com.gsy.glsurvive.mine_model.video.LocalVideoActivity;
import com.gsy.glsurvive.utils.DisplayUtils;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.utils.ToastUtils;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by TR-AND2 on 2017/11/30.
 */

public class MineFragment extends Fragment {
    private View view;
    private Button register_bt,login_bt;
    private FrameLayout before_login,after_login;
    private TextView nickName_tv,signature_tv;
    private ImageView photoUrl;
    private LinearLayout profile_details,setting,suggestion,my_message,my_collect,local_video,share;
    private SharedPreferences sharedPreferences;
    private String userId=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_mine,null);
        sharedPreferences=getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        StatusBarUtil.setTranslucentForImageView(getActivity(),null);
        share= (LinearLayout) view.findViewById(R.id.share);
        my_collect= (LinearLayout) view.findViewById(R.id.my_collect);
        local_video= (LinearLayout) view.findViewById(R.id.local_video);
        my_message= (LinearLayout)view.findViewById(R.id.my_message);
        profile_details= (LinearLayout) view.findViewById(R.id.profile_details);
        setting= (LinearLayout) view.findViewById(R.id.setting);
        suggestion= (LinearLayout) view.findViewById(R.id.my_suggestion);
        before_login= (FrameLayout) view.findViewById(R.id.header_before_login);
        after_login= (FrameLayout) view.findViewById(R.id.header_after_header);
        register_bt= (Button) view.findViewById(R.id.register_bt);
        login_bt= (Button) view.findViewById(R.id.login_bt);
        nickName_tv= (TextView) view.findViewById(R.id.nickName);
        photoUrl= (ImageView) view.findViewById(R.id.img_camera_login);
        signature_tv= (TextView) view.findViewById(R.id.signature);
        //改变header的广播
        IntentFilter messageFilter = new IntentFilter(LoginPresenter.ACTION);
        getActivity().registerReceiver(messageReceiver, messageFilter);

        //退出header的广播
        IntentFilter message = new IntentFilter(DisplayUtils.ACTION);
        getActivity().registerReceiver(logout_message, message);
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent);
            }
        });
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
      profile_details.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent =new Intent(getActivity(),ProfileActivity.class);
              startActivity(intent);
          }
      });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),SettingActivity.class);
                startActivity(intent);
            }
        });
        suggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),SuggestionActivity.class);
                startActivity(intent);
            }
        });
        my_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sharedPreferences.getString("userId",null)==null){
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(getActivity(),MyMessageActivity.class);
                    startActivity(intent);
                }
            }
        });
        my_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sharedPreferences.getString("userId",null)==null){
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(getActivity(),MyCollectActivity.class);
                    startActivity(intent);
                }

            }
        });
        local_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LocalVideoActivity.class);
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://www.gaoshouyou.com";
                UMImage thumb = new UMImage(getActivity(),R.drawable.logo);
                UMWeb web = new UMWeb(url);
                web.setTitle("荒野行动高手攻略");//标题
                web.setThumb(thumb);  //缩略图
                web.setDescription("大吉大利，今晚吃鸡！");//描述
                new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE).
                        withText("hello").withMedia(web)
                        .setCallback(umShareListener)
                        .open();
            }
        });

        return view;
    }

    private BroadcastReceiver messageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(LoginPresenter.ACTION)) {//动作检测
                before_login.setVisibility(View.INVISIBLE);
                after_login.setVisibility(View.VISIBLE);
                String nickName=sharedPreferences.getString("nickName","你好，游客");//如果取不到，那默认值为空
                String signature=sharedPreferences.getString("signature","留下你的印记...").trim();
                String imgUrl=sharedPreferences.getString("imgUrl",null);
                userId=sharedPreferences.getString("userId",null);
                nickName_tv.setText(nickName);
                signature_tv.setText(signature);
                Log.e("msg","imgUrl:"+imgUrl);
                Picasso.with(getActivity()).load(imgUrl).into(photoUrl);

            }
        }
    };
    private BroadcastReceiver logout_message = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(DisplayUtils.ACTION)) {//动作检测
                before_login.setVisibility(View.VISIBLE);
                after_login.setVisibility(View.INVISIBLE);
                SharedPreferences sharedPreferences=context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                //对数据进行编辑，返回editor对象
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("userId",null);
                editor.commit();
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        if(sharedPreferences.getString("userId",null)==null){
            before_login.setVisibility(View.VISIBLE);
            after_login.setVisibility(View.INVISIBLE);
        }else {
            before_login.setVisibility(View.INVISIBLE);
            after_login.setVisibility(View.VISIBLE);
            String nickName = sharedPreferences.getString("nickName", null);//如果取不到，那默认值为空
            String signature = sharedPreferences.getString("signature", null).trim();
            String imgUrl = sharedPreferences.getString("imgUrl", null);
            userId = sharedPreferences.getString("userId", null);
            Log.e("msg","nickName:"+nickName);
            nickName_tv.setText(nickName);
            signature_tv.setText(signature);
            if(imgUrl==null){
                Log.e("msg","imgUrl为空："+imgUrl);
                Picasso.with(getActivity()).load(R.mipmap.wuwang).into(photoUrl);
            }else {
                Picasso.with(getActivity()).load(imgUrl).into(photoUrl);
            }
        }


    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {

            Toast.makeText(getActivity(),"分享成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(getActivity(),"分享失败", Toast.LENGTH_SHORT).show();
            if(t!=null){
                ToastUtils.showToast(getActivity(),t.getMessage());
            }
        }
        @Override
        public void onCancel(SHARE_MEDIA platform) {
        }
    };

}
