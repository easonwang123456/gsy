package com.gsy.glsurvive.mine_model.setting.update;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

/**
 * Created by TR-AND2 on 2017/12/21.
 */

public class H5AboutUsActivity extends BaseActivity {
    private static final String website="http://www.gaoshouyou.com";
    private static final String sina="http://m.weibo.cn/u/5211402235";
    private static final String qq="http://api.gl.gaoshouyou.com/ziliao/hyxd/map.html";
    private static final String disclaimer="http://api.gl.gaoshouyou.com/disclaimer";
    private static final String aboutus="http://api.gl.gaoshouyou.com/about_us";
    private static final String register_agreement="http://api.gl.gaoshouyou.com/agreement";

    private WebView webView;
    private LinearLayout back,about_layout;
    private TextView title;
    private ImageView more;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_us_h5);
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(H5AboutUsActivity.this,null);
    }

    @Override
    public void initView() {
    title= (TextView) findViewById(R.id.about_title);
    webView= (WebView) findViewById(R.id.webView_us);
    back= (LinearLayout) findViewById(R.id.H5_back);
    about_layout= (LinearLayout) findViewById(R.id.about_layout);
    more= (ImageView) findViewById(R.id.more);
    back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void afterView() {
        Intent intent=getIntent();
        int type=intent.getExtras().getInt("type");
        switch (type){
            case 1:
                webView.loadUrl(website);
                about_layout.setVisibility(View.GONE);
                break;
            case 2:
                webView.loadUrl(sina);
                title.setText("高手游微博");
                break;
            case 3:
//                webView.loadUrl(qq);
//                more.setVisibility(View.INVISIBLE);
                break;
            case 4:
                webView.loadUrl(disclaimer);
                title.setText("免责申明");
                more.setVisibility(View.INVISIBLE);
                break;
            case 5:
                webView.loadUrl(aboutus);
                title.setText("关于高手游");
                more.setVisibility(View.INVISIBLE);
                break;
            case 6:
                webView.loadUrl(register_agreement);
                title.setText("用户协议");
                more.setVisibility(View.INVISIBLE);
                break;

        }
        urlchange();
        webSetting();

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
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
