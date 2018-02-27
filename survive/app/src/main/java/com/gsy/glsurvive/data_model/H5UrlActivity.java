package com.gsy.glsurvive.data_model;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.AppUtils;
import com.gsy.glsurvive.utils.DisplayUtils;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.utils.ToastUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2017/12/21.
 */

public class H5UrlActivity extends BaseActivity {
    private static final String DH5="http://api.gl.gaoshouyou.com/h5/game-0-4-1.html";
    private static final String NetH5="http://api.gl.gaoshouyou.com/h5/game-0-3-1.html";
    private static final String Map="http://api.gl.gaoshouyou.com/ziliao/hyxd/map.html";
    private static final String gun="http://api.gl.gaoshouyou.com/ziliao/hyxd/wuqi.html";
    private static final String goods="http://api.gl.gaoshouyou.com/ziliao/hyxd/wupin.html";
    private WebView webView;
    private ProgressBar progressBar;
    private LinearLayout back,h5_more;
    private TextView title;
    private View pop_view;
    private PopupWindow menu;
    private ListView listView;
    private List<String> list_menu;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_h5_game);
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(H5UrlActivity.this,null);
    }

    @Override
    public void initView() {
        h5_more= (LinearLayout) findViewById(R.id.h5_more);
        title= (TextView) findViewById(R.id.H5_title);
        webView= (WebView) findViewById(R.id.game_recommand_webview);
        back= (LinearLayout) findViewById(R.id.H5_back);
        progressBar= (ProgressBar) findViewById(R.id.web_progressbar);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void afterView() {
        h5_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop_view = LayoutInflater.from(H5UrlActivity.this).inflate(R.layout.popwin_menu,null);
                menu=new PopupWindow(pop_view, (int) (DisplayUtils.getScreenWidthPixels(H5UrlActivity.this)*0.22), ViewGroup.LayoutParams.WRAP_CONTENT, true);
                //设置可以获得焦点
                menu.setFocusable(true);
                //设置弹窗内可点击
                menu.setTouchable(true);
                //设置弹窗外可点击
                menu.setOutsideTouchable(true);
                menu.setBackgroundDrawable(new BitmapDrawable());
                menu.setContentView(pop_view);
                menu.showAsDropDown(h5_more, DisplayUtils.dp2px(H5UrlActivity.this,-40),DisplayUtils.dp2px(H5UrlActivity.this,5));
                initData();
            }
        });

        Intent intent=getIntent();
        int type=intent.getExtras().getInt("type");
        switch (type){
            case 1:
                webView.loadUrl(DH5);
                break;
            case 2:
                webView.loadUrl(NetH5);
                break;
            case 3:
                webView.loadUrl(Map);
                title.setText("地图");
                break;
            case 4:
                webView.loadUrl(gun);
                title.setText("枪械");
                break;
            case 5:
                webView.loadUrl(goods);
                title.setText("物品");
                break;

        }
        progressbar();
        urlchange();
        webSetting();
    }
    private void progressbar() {
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    if (View.INVISIBLE ==  progressBar.getVisibility()) {
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

        });
    }
    private void urlchange() {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
    private void webSetting() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);//关键点
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        webSettings.setSupportZoom(true); // 支持缩放
        webSettings.setLoadWithOverviewMode(true);
    }
    public void initData(){
        listView = (ListView)pop_view.findViewById(R.id.title_list);
        list_menu = new ArrayList<>();
        list_menu.add("分享");
        list_menu.add("复制链接");
        list_menu.add("其他打开");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (list_menu.get(position)) {
                    case "分享":
                        UMImage thumb = new UMImage(H5UrlActivity.this,R.drawable.logo);
                        UMWeb web = new UMWeb(webView.getUrl());
                        web.setTitle(webView.getTitle());//标题
                        web.setThumb(thumb);  //缩略图
                        web.setDescription(null);//描述
                        new ShareAction(H5UrlActivity.this).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE).
                                withText("hello").withMedia(web)
                                .setCallback(umShareListener)
                                .open();
                        menu.dismiss();
                        break;
                    case "复制链接":
                        AppUtils.copy2clipboard(H5UrlActivity.this,webView.getUrl());
                        ToastUtils.showToast(H5UrlActivity.this,"已复制至剪贴板");
                        menu.dismiss();
                        break;
                    case "其他打开":
                        AppUtils.startBrower(H5UrlActivity.this,webView.getUrl());
                        menu.dismiss();
                        break;
                }
            }
        });
        //设置列表的适配器
        listView.setAdapter(new BaseAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
               ViewHolder holder;
                if(convertView==null){
                    holder=new ViewHolder();
                    convertView=LayoutInflater.from(H5UrlActivity.this).inflate(R.layout.menu_h5_item, null);
                    holder.tv1=(TextView) convertView.findViewById(R.id.menu_item);
                    convertView.setTag(holder);
                }else{
                    holder=(ViewHolder) convertView.getTag();
                }
                holder.tv1.setText( list_menu.get(position));
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
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(H5UrlActivity.this,"分享成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(H5UrlActivity.this,"分享失败", Toast.LENGTH_SHORT).show();
            if(t!=null){
               ToastUtils.showToast(H5UrlActivity.this,t.getMessage());
            }
        }
        @Override
        public void onCancel(SHARE_MEDIA platform) {

        }
    };
}
