package com.gsy.glsurvive.firstpage_model.video.video_detail;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.emoj.Emoji;
import com.gsy.glsurvive.emoj.EmojiUtil;
import com.gsy.glsurvive.emoj.FaceFragment;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ShareResult;
import com.gsy.glsurvive.mine_model.login.LoginActivity;
import com.gsy.glsurvive.utils.AppUtils;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.utils.ToastUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import java.io.IOException;
import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by TR-AND2 on 2018/1/2.
 */

public class VideoListDetailActivity extends BaseActivity implements VideoDetailView,FaceFragment.OnEmojiClickListener {
    private VideoDetailRecyclerAdapter videoDetailRecyclerAdapter;
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private LinearLayout emoj_list,comment_before,comment_after,like_linear;
    private FrameLayout emoj;
    private EditText editText;
    private Boolean flag=true;
    private VideoCommentRecyclerAdapter videoCommentRecyclerAdapter;
    private RecyclerView recyclerView,recycler_comment;
    private TextView like_number,comment_number,title,name,time,video_tv,comment_total,video_collect,video_weibo,video_circle;
    private View mPopwindow;
    private static int comment_id;
    private ImageView like_iv,video_menu,imgUrl,back;
    private int video_id,video_type;
    private Boolean isReply=false;
    private int loadPage=2;
    private SharedPreferences sharedPreferences;
    //存放图片id
    private int[] imageIds = new int[]{R.mipmap.shoucang_icon, R.mipmap.fenxiang_icon, R.mipmap.shuaxin_icon,};
    private ProgressDialog mProgressDialog;
    @Override
    public void addLayout() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_video_detail);
        sharedPreferences=this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        loading();
        editText = (EditText) findViewById(R.id.edit_text);
        FaceFragment faceFragment = FaceFragment.Instance();
        getSupportFragmentManager().beginTransaction().add(R.id.Container,faceFragment).commit();
        videoDetailRecyclerAdapter=new VideoDetailRecyclerAdapter();
        videoCommentRecyclerAdapter=new VideoCommentRecyclerAdapter();
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(VideoListDetailActivity.this,null);
    }

    @Override
    public void initView() {
        jcVideoPlayerStandard= (JCVideoPlayerStandard)findViewById(R.id.video_player_detail);
        jcVideoPlayerStandard.backButton.setImageResource(0);
        jcVideoPlayerStandard.tinyBackImageView.setBackground(null);
        like_iv= (ImageView) findViewById(R.id.like_iv);
        like_linear= (LinearLayout) findViewById(R.id.like_linear);
        back= (ImageView) findViewById(R.id.video_back);
        like_number= (TextView) findViewById(R.id.like_number);
        comment_number= (TextView) findViewById(R.id.comment_number);
        recycler_comment= (RecyclerView)findViewById(R.id.recycler_comment_video);
        recycler_comment.setLayoutManager(new LinearLayoutManager(VideoListDetailActivity.this));

        setHeader(recycler_comment);
        comment_after= (LinearLayout) findViewById(R.id.comment_after);
        comment_before= (LinearLayout) findViewById(R.id.comment_before);
        emoj_list= (LinearLayout) findViewById(R.id.emoj_list);
        emoj= (FrameLayout) findViewById(R.id.emoj);
        video_menu= (ImageView) findViewById(R.id.video_menu);

        emoj_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    emoj.setVisibility(View.VISIBLE);
                    flag=false;
                }else{
                    emoj.setVisibility(View.GONE);
                    flag=true;
                }

            }
        });
        like_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new VideoDetailPresenter(VideoListDetailActivity.this).like(VideoListDetailActivity.this,video_id,video_type);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        video_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sharedPreferences.getString("userId",null)==null){
                    Intent intent=new Intent(VideoListDetailActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    new VideoDetailPresenter(VideoListDetailActivity.this).collect(VideoListDetailActivity.this, video_id, video_type);
                }
            }
        });
        video_weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new VideoDetailPresenter(VideoListDetailActivity.this).shareUrl(VideoListDetailActivity.this,video_id,video_type,1);
            }
        });

        video_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new VideoDetailPresenter(VideoListDetailActivity.this).shareUrl(VideoListDetailActivity.this,video_id,video_type,2);
            }
        });
    }


    @Override
    public void afterView() {
        comment_after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isReply){
                    new VideoDetailPresenter(VideoListDetailActivity.this).sendReply(VideoListDetailActivity.this,video_id,video_type,editText.getText().toString(),comment_id ,0);
                    isReply=false;
                }else {
                    new VideoDetailPresenter(VideoListDetailActivity.this).sendComment(VideoListDetailActivity.this,video_id,video_type, editText.getText().toString(),0);
                }
                editText.setText(null);
                editText.setHint("让我也来说两句");
                AppUtils.hideSoftInput(editText);
                comment_after.setVisibility(View.GONE);
                comment_before.setVisibility(View.VISIBLE);
            }
        });


        videoDetailRecyclerAdapter.setOnItemClickListener(new VideoDetailRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id, int type) {
                if(type==13){
                    Intent intent = new Intent(VideoListDetailActivity.this, VideoListDetailActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("type", type);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(VideoListDetailActivity.this, BannerDetailActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("type", type);
                    startActivity(intent);
                }
            }
        });
        //回复
        videoCommentRecyclerAdapter.setOnItemClickListener(new VideoCommentRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, final int commentId, final int type, final String name, ImageView view) {
                mPopwindow = LayoutInflater.from(VideoListDetailActivity.this).inflate(R.layout.pop_window_more,null, false);
                final PopupWindow  popupView = new PopupWindow(mPopwindow, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                TextView reply_tv= (TextView) mPopwindow.findViewById(R.id.reply_tv);
                popupView.setTouchable(true);
                popupView.setOutsideTouchable(true);
                popupView.setBackgroundDrawable(new BitmapDrawable());
                popupView.setContentView(mPopwindow);
                popupView.showAsDropDown(view);
                reply_tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupView.dismiss();
                        AppUtils.openSoftInput(editText);
                        editText.setHint("回复"+name);
                        comment_id=commentId;
                        isReply=true;
                    }
                });

            }
        });
        //评论点赞
        videoCommentRecyclerAdapter.setOnLikeClickListener(new VideoCommentRecyclerAdapter.OnLikeClickListener() {
            @Override
            public void onLikeClick(int position, int commentId, int type,ImageView imageView,TextView textView,int num) {
                new VideoDetailPresenter(VideoListDetailActivity.this).commentLike(VideoListDetailActivity.this,commentId,imageView,textView,num);
            }
        });

        //更多
        video_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new VideoDetailPresenter(VideoListDetailActivity.this).share(VideoListDetailActivity.this,video_id,video_type);

            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( editText.getText().toString().equalsIgnoreCase("")){
                    comment_after.setVisibility(View.GONE);
                    comment_before.setVisibility(View.VISIBLE);

                }else{
                    comment_before.setVisibility(View.GONE);
                    comment_after.setVisibility(View.VISIBLE);}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.refreshLayout_video);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(0);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                Log.e("msg","loadpage:"+loadPage);
                new VideoDetailPresenter(VideoListDetailActivity.this).videoCommentList(VideoListDetailActivity.this,video_id,video_type,20,loadPage,2,false);
                refreshlayout.finishLoadmore(1000);
            }
        });
        Intent intent=getIntent();
        video_id=intent.getIntExtra("id",1);
        video_type=intent.getIntExtra("type",1);
        Log.e("msg","video_id:"+video_id);
        new VideoDetailPresenter(VideoListDetailActivity.this).videoDetail(this,video_id);
        Log.e("msg","视频id:"+intent.getIntExtra("id",1));
        new VideoDetailPresenter(VideoListDetailActivity.this).videoCommentList(VideoListDetailActivity.this,video_id,video_type,20,1,1,false);

    }

    @Override
    public void videoDetail(VideoDetailResult.ContentBean contentBean, ArrayList<VideoDetailResult.ContentBean.OtherDataBean> list_detail) {
        jcVideoPlayerStandard.setUp(contentBean.getSource(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
        Picasso.with(VideoListDetailActivity.this).load(contentBean.getImgUrl()).into(jcVideoPlayerStandard.thumbImageView);
        title.setText(contentBean.getName());
        name.setText(contentBean.getAuthor());
        time.setText(contentBean.getTime());
        video_tv.setText(contentBean.getDescription());
        Picasso.with(VideoListDetailActivity.this).load(contentBean.getAuthorUrl()).into(imgUrl);
        videoDetailRecyclerAdapter.addDatas(list_detail,VideoListDetailActivity.this);
        recyclerView.setAdapter(videoDetailRecyclerAdapter);

    }


    @Override
    public void videoCommentList(ArrayList<VideoCommentResult.ContentBean> list, Boolean refresh,int page,int index) {
        mProgressDialog.dismiss();
        if(refresh){
            videoCommentRecyclerAdapter.updateList(list,VideoListDetailActivity.this);
        }else if(index==1){
            videoCommentRecyclerAdapter.refresh(list,VideoListDetailActivity.this,this);
            recycler_comment.setAdapter(videoCommentRecyclerAdapter);
            loadPage=2;
        }else if(!list.isEmpty()&& index==2){
            loadPage=page;
            videoCommentRecyclerAdapter.addDatas(list,VideoListDetailActivity.this,this);

        }

    }


    @Override
    public void refreshSmallAdapter() {
        new VideoDetailPresenter(VideoListDetailActivity.this).videoCommentList(VideoListDetailActivity.this,video_id,video_type,20,1,1,true);

    }
    @Override
    public void refreshAdapter() {
        new VideoDetailPresenter(VideoListDetailActivity.this).videoCommentList(VideoListDetailActivity.this,video_id,video_type,20,1,1,true);


    }

    @Override
    public void onEmojiDelete() {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            return;
        }
        if ("]".equals(text.substring(text.length() - 1, text.length()))) {
            int index = text.lastIndexOf("[");
            if (index == -1) {
                int action = KeyEvent.ACTION_DOWN;
                int code = KeyEvent.KEYCODE_DEL;
                KeyEvent event = new KeyEvent(action, code);
                editText.onKeyDown(KeyEvent.KEYCODE_DEL, event);
                displayTextView();
                return;
            }
            editText.getText().delete(index, text.length());
            displayTextView();
            return;
        }
        int action = KeyEvent.ACTION_DOWN;
        int code = KeyEvent.KEYCODE_DEL;
        KeyEvent event = new KeyEvent(action, code);
        editText.onKeyDown(KeyEvent.KEYCODE_DEL, event);
        displayTextView();
    }

    @Override
    public void onEmojiClick(Emoji emoji) {
        if (emoji != null) {
            int index = editText.getSelectionStart();
            Editable editable = editText.getEditableText();
            if (index < 0) {
                editable.append(emoji.getContent());
            } else {
                editable.insert(index, emoji.getContent());
            }
        }
        displayTextView();
    }
    private void displayTextView() {
        try {
            EmojiUtil.handlerEmojiText(editText, editText.getText().toString(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void showGetContent(VideoDetailResult.ContentBean contentBean) {
        if(contentBean.isStatus()){
            this.like_iv.setImageResource(R.mipmap.pinlun_selected_dianzan);
        }
        this.comment_number.setText(contentBean.getCommentNum());
        this.like_number.setText(contentBean.getDingNum());
        this.comment_total.setText(contentBean.getCommentNum());

    }

    @Override
    public void showLike(Boolean flag) {
        if(flag){
            like_iv.setBackgroundResource(R.mipmap.pinlun_selected_dianzan);
            like_number.setText(""+(Integer.parseInt(this.like_number.getText().toString())+1));
        }
    }

    @Override
    public void showShare(final ArrayList<ShareResult.ContentBean> list) {
                        UMImage thumb = new UMImage(VideoListDetailActivity.this,list.get(0).getImgUrl());
                        UMWeb web = new UMWeb(list.get(0).getSiteUrl());
                        web.setTitle(list.get(0).getTitle());//标题
                        web.setThumb(thumb);  //缩略图
                        web.setDescription(list.get(0).getText());//描述
                        new ShareAction(VideoListDetailActivity.this).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE).
                                withText("hello").withMedia(web)
                                .setCallback(umShareListener)
                                .open();
    }

    @Override
    public void dismissMenu() {

    }

    //评论点赞
    @Override
    public void showLike(ImageView imageView,TextView textView,Boolean isResult,int num) {
        imageView.setImageResource(R.mipmap.pinlun_selected_dianzan);

        if(isResult){
            textView.setText(""+(num+1));
        }
    }

    @Override
    public void shareUrl(ArrayList<ShareResult.ContentBean> list, int index_type) {
        UMImage thumb = new UMImage(VideoListDetailActivity.this,list.get(0).getImgUrl());
        UMWeb web = new UMWeb(list.get(0).getSiteUrl());
        web.setTitle(list.get(0).getTitle());//标题
        web.setThumb(thumb);  //缩略图
        web.setDescription(list.get(0).getText());//描述
        if(index_type==1){
            new ShareAction(VideoListDetailActivity.this).setPlatform(SHARE_MEDIA.SINA).
                    withText("hello").withMedia(web)
                    .setCallback(umShareListener)
                    .share();
        }else{
            new ShareAction(VideoListDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).
                    withText("hello").withMedia(web)
                    .setCallback(umShareListener)
                    .share();
        }

    }

    //回复点赞
    public void showReplyLike(ImageView imageView,TextView textView,Boolean isResult,String num){
        imageView.setImageResource(R.mipmap.pinlun_selected_dianzan);
        if(isResult){
            textView.setText(""+(Integer.parseInt(num)+1));
        }
    }
    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(VideoListDetailActivity.this).inflate(R.layout.video_detail_header,view,false);
        recyclerView= (RecyclerView) header.findViewById(R.id.video_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(VideoListDetailActivity.this));
        title= (TextView)header.findViewById(R.id.video_title);
        name= (TextView)header.findViewById(R.id.author);
        time= (TextView) header.findViewById(R.id.time);
        video_tv= (TextView)header.findViewById(R.id.title_tv);
        imgUrl= (ImageView) header.findViewById(R.id.img_url);
        comment_total= (TextView) header.findViewById(R.id.comment_total);
        video_collect= (TextView) header.findViewById(R.id.video_collect);
        video_weibo= (TextView) header.findViewById(R.id.video_weibo);
        video_circle= (TextView) header.findViewById(R.id.video_circle);
        videoCommentRecyclerAdapter.setHeaderView(header);

    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(VideoListDetailActivity.this,"分享成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(VideoListDetailActivity.this,"分享失败", Toast.LENGTH_SHORT).show();
            if(t!=null){
                ToastUtils.showToast(VideoListDetailActivity.this,t.getMessage());
            }
        }
        @Override
        public void onCancel(SHARE_MEDIA platform) {

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(VideoListDetailActivity.this, R.style.CustomProgressDialog);
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
