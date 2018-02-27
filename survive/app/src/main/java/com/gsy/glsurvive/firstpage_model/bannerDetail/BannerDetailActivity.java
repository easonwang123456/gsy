package com.gsy.glsurvive.firstpage_model.bannerDetail;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.TextAppearanceSpan;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.emoj.Emoji;
import com.gsy.glsurvive.emoj.EmojiUtil;
import com.gsy.glsurvive.emoj.FaceFragment;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.BannerDetailResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CommentListResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ShareResult;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoListDetailActivity;
import com.gsy.glsurvive.mine_model.login.LoginActivity;
import com.gsy.glsurvive.utils.AppUtils;
import com.gsy.glsurvive.utils.DisplayUtils;
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
import java.util.List;


/**
 * Created by TR-AND2 on 2017/12/18.
 */

public class BannerDetailActivity extends BaseActivity implements BannerDetailView,FaceFragment.OnEmojiClickListener{
    private LinearLayout emoj_list,comment_before,comment_after,content,banner_menu,back,like_linear;
    private FrameLayout emoj;
    private EditText editText;
    private Boolean flag=true;
    private Boolean isReply=false;
    private BannerRecyclerAdapter bannerRecyclerAdapter;
    private CommentRecyclerAdapter commentRecyclerAdapter;
    private RecyclerView recyclerView,recycler_comment;
    private TextView title,from,time,like_number,comment_number,page_collect,page_weibo,page_circle,banner_total;
    private ListView listView;
    private List<String> list_menu;
    private View pop_view;
    private static int comment_id;
    private static int position_reply;
    private ImageView like_iv;
    private View mPopwindow;
    private PopupWindow menu;
    private SpannableString spanText;
    private int article_id,type;
    private SharedPreferences sharedPreferences;
    private  int loadPage=2;
    private ProgressDialog mProgressDialog;
    private  ArrayList<String> arraylist=new ArrayList<>();
    private int currentPosition;
    //存放图片id
    private int[] imageIds = new int[]{R.mipmap.shoucang_icon, R.mipmap.fenxiang_icon, R.mipmap.shuaxin_icon,};
    @Override
    public void addLayout() {
        loading();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        sharedPreferences=this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_banner_detail);
        editText = (EditText) findViewById(R.id.edit_text);
        StatusBarUtil.setTranslucentForImageView(BannerDetailActivity.this,null);
        FaceFragment faceFragment = FaceFragment.Instance();
        getSupportFragmentManager().beginTransaction().add(R.id.Container,faceFragment).commit();

    }

    @Override
    public void initView() {
        like_iv= (ImageView) findViewById(R.id.like_iv);
        like_linear= (LinearLayout) findViewById(R.id.like_linear);
        back= (LinearLayout) findViewById(R.id.banner_back);
        like_number= (TextView) findViewById(R.id.like_number);
        comment_number= (TextView) findViewById(R.id.comment_number);
        bannerRecyclerAdapter=new BannerRecyclerAdapter();
        commentRecyclerAdapter =new CommentRecyclerAdapter();
        recycler_comment= (RecyclerView)findViewById(R.id.recycler_comment1);
        recycler_comment.setLayoutManager(new LinearLayoutManager(BannerDetailActivity.this));

        setHeader(recycler_comment);
        comment_after= (LinearLayout) findViewById(R.id.comment_after);
        comment_before= (LinearLayout) findViewById(R.id.comment_before);
        emoj_list= (LinearLayout) findViewById(R.id.emoj_list);
        emoj= (FrameLayout) findViewById(R.id.emoj);
        banner_menu= (LinearLayout) findViewById(R.id.banner_menu);

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
                new BannerDetailPresenter(BannerDetailActivity.this).like(BannerDetailActivity.this,article_id,type);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        page_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sharedPreferences.getString("userId",null)==null){
                    Intent intent=new Intent(BannerDetailActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else{
                    new BannerDetailPresenter(BannerDetailActivity.this).collect(BannerDetailActivity.this,article_id,type);
                }

            }
        });
        page_weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BannerDetailPresenter(BannerDetailActivity.this).shareUrl(BannerDetailActivity.this,article_id,type,1);
            }
        });

        page_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BannerDetailPresenter(BannerDetailActivity.this).shareUrl(BannerDetailActivity.this,article_id,type,2);
            }
        });

    }

    @Override
    public void afterView() {
        comment_after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(isReply){
                Log.e("msg","comment_id:"+comment_id);
                new BannerDetailPresenter(BannerDetailActivity.this).sendReply(BannerDetailActivity.this,article_id,type,editText.getText().toString(),comment_id,0);
                isReply=false;
            }else {
                new BannerDetailPresenter(BannerDetailActivity.this).sendComment(BannerDetailActivity.this, article_id, type, editText.getText().toString(),0);
          }
                editText.setText(null);
                editText.setHint("让我也来说两句");
                AppUtils.hideSoftInput(editText);
                comment_after.setVisibility(View.GONE);
                comment_before.setVisibility(View.VISIBLE);
            }
        });

        bannerRecyclerAdapter.setOnItemClickListener(new BannerRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id, int type) {
                if(type==13){
                    Intent intent = new Intent(BannerDetailActivity.this, VideoListDetailActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("type", type);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(BannerDetailActivity.this, BannerDetailActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("type", type);
                    startActivity(intent);
                }
            }
        });
        //回复
        commentRecyclerAdapter.setOnItemClickListener(new CommentRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position, final int commentId, final int type, final String name, ImageView view) {
                mPopwindow = LayoutInflater.from(BannerDetailActivity.this).inflate(R.layout.pop_window_more,null, false);
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
                        Log.e("msg","commentId:"+commentId);
                        comment_id=commentId;
                        position_reply=position;
                        isReply=true;

                    }
                });

            }
        });
        //评论点赞
        commentRecyclerAdapter.setOnLikeClickListener(new CommentRecyclerAdapter.OnLikeClickListener() {
            @Override
            public void onLikeClick(int position, int commentId, int type,ImageView imageView,TextView textView,int num) {
                new BannerDetailPresenter(BannerDetailActivity.this).commentLike(BannerDetailActivity.this,commentId,imageView,textView,num);
            }
        });

       //更多
        banner_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowManager manager_pop = (WindowManager)BannerDetailActivity.this.getSystemService(Context.WINDOW_SERVICE);
                DisplayMetrics outMetrics_pop = new DisplayMetrics();
                Display defaultDisplay_pop = manager_pop.getDefaultDisplay();
                defaultDisplay_pop.getMetrics(outMetrics_pop);
                int width_pop = outMetrics_pop.widthPixels;
                int height_pop = outMetrics_pop.heightPixels;
                pop_view = LayoutInflater.from(BannerDetailActivity.this).inflate(R.layout.popwin_menu,null);
                menu=new PopupWindow(pop_view, (int) (width_pop*0.23), ViewGroup.LayoutParams.WRAP_CONTENT, true);
                //设置可以获得焦点
                menu.setFocusable(true);
                //设置弹窗内可点击
                menu.setTouchable(true);
                //设置弹窗外可点击
                menu.setOutsideTouchable(true);
                menu.setBackgroundDrawable(new BitmapDrawable());
                menu.setContentView(pop_view);
                menu.showAsDropDown(banner_menu,DisplayUtils.dp2px(BannerDetailActivity.this,-40),DisplayUtils.dp2px(BannerDetailActivity.this,5));
                initData();
                new BannerDetailPresenter(BannerDetailActivity.this).share(BannerDetailActivity.this,article_id,type);

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


         RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.comment_refresh);

            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    refreshlayout.finishRefresh(0);
                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    new BannerDetailPresenter(BannerDetailActivity.this).commentList(BannerDetailActivity.this,article_id,type,20,loadPage,2,false);
                    refreshlayout.finishLoadmore(1000);
                }
            });

        Intent intent=getIntent();
        article_id=intent.getExtras().getInt("id");
        type=intent.getExtras().getInt("type");
        new BannerDetailPresenter(BannerDetailActivity.this).detailRequest(BannerDetailActivity.this,article_id,type);
        new BannerDetailPresenter(BannerDetailActivity.this).commentList(BannerDetailActivity.this,article_id,type,20,1,1,false);
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
            EmojiUtil.handlerEmojiText(editText, editText.getText().toString(),this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showContent(final ArrayList<BannerDetailResult.ContentBean.PostDataBean> list) {
      Log.e("msg","list:"+list);
        mProgressDialog.dismiss();
                new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView tv;
              if(list==null){return;}
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getText()==null){
                        if(list.get(i).getDType()==2){
                            spanText = new SpannableString(list.get(i).getTitle());
                            tv = new TextView(BannerDetailActivity.this);
                            tv.setTextSize(17);
                            tv.setLineSpacing(1.5f,1.5f);
                            //若需自定义TextAppearance，可以在系统样式上进行修改
                            spanText.setSpan(new TextAppearanceSpan(BannerDetailActivity.this, android.R.style.TextAppearance_DeviceDefault_Medium),
                                    0, 0, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                            tv.append("\n");
                            tv.append(spanText);
                            content.addView(tv);
                        }
                        if(list.get(i).getDType()==1){
                            final int getTop=list.get(i).getTop();
                            final ImageView imageView = new ImageView(BannerDetailActivity.this);
                            final LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
                            param.gravity = Gravity.CENTER;  //必须要加上这句，setMargins才会起作用，而且此句还必须在setMargins下面
                            param.height=DisplayUtils.getScreenHeightPixels(BannerDetailActivity.this)/3;
                            imageView.setLayoutParams(param);
                            Picasso.with(BannerDetailActivity.this).load(list.get(i).getImgUrl()).placeholder(R.mipmap.zhanweitu).into(imageView);
                            arraylist.add(list.get(i).getImgUrl());
                            content.addView(imageView);
                            imageView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                     Intent intent=new Intent(BannerDetailActivity.this,ViewPagerActivity.class);
                                     intent.putExtra("getTop",getTop);
                                    intent.putStringArrayListExtra("arraylist", arraylist);
                                    //Log.e("msg","url:"+arraylist.get(position));
                                    startActivity(intent);
                                }
                            });
                        }
                        continue;
                    }
                    for(int j=0;j<list.get(i).getText().size();j++){
                        spanText = new SpannableString(list.get(i).getText().get(j).getText());
                        tv = new TextView(BannerDetailActivity.this);
                        tv.setLineSpacing(1.5f,1.5f);
                        tv.setTextSize(16);
                        if(list.get(i).getText().get(j).getTType()==4){
                            spanText.setSpan(new URLSpan(list.get(i).getText().get(j).getText()), 0,list.get(i).getText().get(j).getText().length() ,
                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            tv.setMovementMethod(LinkMovementMethod.getInstance());
                        }else{
                            //若需自定义TextAppearance，可以在系统样式上进行修改
                            spanText.setSpan(new TextAppearanceSpan(BannerDetailActivity.this, android.R.style.TextAppearance_DeviceDefault_Medium),
                                    0, 0, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                        }
                        tv.append("\n");
                        tv.append(spanText);
                        content.addView(tv);
                    }
                }
            }
        },100);

    }

    @Override
    public void showRecycler(ArrayList<BannerDetailResult.ContentBean.OtherDataBean> list) {
        bannerRecyclerAdapter.addDatas(list,BannerDetailActivity.this);
        recyclerView.setAdapter(bannerRecyclerAdapter);
        mProgressDialog.dismiss();
    }

    @Override
    public void showComment(ArrayList<CommentListResult.ContentBean> list,Boolean refresh,int page,int index) {
        if(refresh){
            commentRecyclerAdapter.updateList(list,BannerDetailActivity.this);
        } else if(index==1){
            commentRecyclerAdapter.refresh(list,BannerDetailActivity.this,this);
            recycler_comment.setAdapter(commentRecyclerAdapter);
            loadPage=2;
        }else if(!list.isEmpty()&& index==2){
            loadPage=page;
            commentRecyclerAdapter.addDatas(list,BannerDetailActivity.this,this);
            recycler_comment.setAdapter(commentRecyclerAdapter);
        }

    }

    @Override
    public void refreshSmallAdapter() {
        new BannerDetailPresenter(BannerDetailActivity.this).commentList(BannerDetailActivity.this,article_id,type,10,1,1,true);

    }
    @Override
    public void refreshAdapter() {
        new BannerDetailPresenter(BannerDetailActivity.this).commentList(BannerDetailActivity.this,article_id,type,10,1,1,true);

    }

    @Override
    public void showGetContent(BannerDetailResult.ContentBean contentBean) {
        if(contentBean.isStatus()){
            this.like_iv.setImageResource(R.mipmap.pinlun_selected_dianzan);

        }
        this.banner_total.setText(contentBean.getCommentNum());
        this.comment_number.setText(contentBean.getCommentNum());
        this.like_number.setText(contentBean.getDingNum());
        this.title.setText(contentBean.getName());
        this.from.setText(contentBean.getFrom());
        this.time.setText(contentBean.getTime());
        mProgressDialog.dismiss();
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (list_menu.get(position)) {
                    case "收藏":
                        if(sharedPreferences.getString("userId",null)==null){
                            Intent intent=new Intent(BannerDetailActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }else{
                            new BannerDetailPresenter(BannerDetailActivity.this).collect(BannerDetailActivity.this,article_id,type);
                        }

                        break;
                    case "分享":
                        UMImage thumb = new UMImage(BannerDetailActivity.this,list.get(0).getImgUrl());
                        UMWeb web = new UMWeb(list.get(0).getSiteUrl());
                        web.setTitle(list.get(0).getTitle());//标题
                        web.setThumb(thumb);  //缩略图
                        web.setDescription(list.get(0).getText());//描述
                        new ShareAction(BannerDetailActivity.this).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE).
                                withText("hello").withMedia(web)
                                .setCallback(umShareListener)
                                .open();
                        menu.dismiss();
                        break;
                    case "刷新":
                        bannerRecyclerAdapter.notifyDataSetChanged();
                        menu.dismiss();
                        break;
                }
            }
        });
    }

    @Override
    public void dismissMenu() {
        menu.dismiss();
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
    public void shareUrl(ArrayList<ShareResult.ContentBean> list,int index_type) {
        UMImage thumb = new UMImage(this,list.get(0).getImgUrl());
        UMWeb web = new UMWeb(list.get(0).getSiteUrl());
        web.setTitle(list.get(0).getTitle());//标题
        web.setThumb(thumb);  //缩略图
        web.setDescription(list.get(0).getText());//描述
        if(index_type==1){
            new ShareAction(BannerDetailActivity.this).setPlatform(SHARE_MEDIA.SINA)
                    .withText("hello").withMedia(web)
                    .setCallback(umShareListener)
                    .share();
        }else{
            new ShareAction(BannerDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                    .withText("hello").withMedia(web)
                    .setCallback(umShareListener)
                    .share();
        }

    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(BannerDetailActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(BannerDetailActivity.this,"分享失败", Toast.LENGTH_SHORT).show();
            if(t!=null){
                ToastUtils.showToast(BannerDetailActivity.this,t.getMessage());
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

    //回复点赞
    public void showReplyLike(ImageView imageView,TextView textView,Boolean isResult,String num){
        imageView.setImageResource(R.mipmap.pinlun_selected_dianzan);
        if(isResult){
            textView.setText(""+(Integer.parseInt(num)+1));
        }
    }

    public void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(BannerDetailActivity.this).inflate(R.layout.banner_recycler_header, view, false);
        recyclerView= (RecyclerView)header.findViewById(R.id.banner_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(BannerDetailActivity.this));
        page_collect= (TextView) header.findViewById(R.id.page_collect);
        page_weibo= (TextView) header.findViewById(R.id.page_weibo);
        page_circle= (TextView) header.findViewById(R.id.page_circle);
        title= (TextView)header.findViewById(R.id.banner_title);
        from = (TextView)header.findViewById(R.id.from);
        time = (TextView)header.findViewById(R.id.time);
        content = (LinearLayout) header.findViewById(R.id.content);
        banner_total= (TextView)header.findViewById(R.id.banner_comment_total);
        commentRecyclerAdapter.setHeaderView(header);
    }
    private void initData() {
        listView = (ListView)pop_view.findViewById(R.id.title_list);
        list_menu = new ArrayList<>();
        list_menu.add("收藏");
        list_menu.add("分享");
        list_menu.add("刷新");

        //设置列表的适配器
        listView.setAdapter(new BaseAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if(convertView==null){
                    holder=new ViewHolder();
                    convertView=LayoutInflater.from(BannerDetailActivity.this).inflate(R.layout.menu_item, null);
                    holder.tv1=(TextView) convertView.findViewById(R.id.menu_item);
                    holder.iv1= (ImageView) convertView.findViewById(R.id.menu_icon);
                    convertView.setTag(holder);
                }else{
                    holder=(ViewHolder) convertView.getTag();
                }
                holder.tv1.setText( list_menu.get(position));
                holder.iv1.setBackgroundResource(imageIds[position]);

                return convertView;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public Object getItem(int position) {
                return list_menu.get(position);
            }

            @Override
            public int getCount() {
                return list_menu.size();
            }
        });

    }


    class ViewHolder{
        TextView tv1;
        ImageView iv1;
    }

    //ProgressDialog模拟网络请求
    public void loading() { Log.e("msg","jinlaile");
        mProgressDialog = new ProgressDialog(BannerDetailActivity.this, R.style.CustomProgressDialog);
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