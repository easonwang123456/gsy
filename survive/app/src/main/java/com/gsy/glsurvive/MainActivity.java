package com.gsy.glsurvive;
import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hubert.library.Controller;
import com.app.hubert.library.HighLight;
import com.app.hubert.library.NewbieGuide;
import com.app.hubert.library.OnGuideChangedListener;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.data_model.DataFragment;
import com.gsy.glsurvive.firstpage_model.FirstPageFragment;
import com.gsy.glsurvive.mine_model.MineFragment;
import com.gsy.glsurvive.strategy_model.StrategyFragment;
import com.gsy.glsurvive.utils.AppUtils;
import com.gsy.glsurvive.utils.ShareUtil;
import com.gsy.glsurvive.utils.ToastUtils;
import com.umeng.socialize.UMShareAPI;

public class MainActivity extends BaseActivity {

    private LinearLayout firstPage;
    private LinearLayout strategy;
    private LinearLayout data;
    private LinearLayout mine;

    private TextView firstPage_tv;
    private TextView strategy_tv;
    private TextView data_tv;
    private TextView mine_tv;

    private ImageView firstPage_iv;
    private ImageView strategy_iv;
    private ImageView data_iv;
    private ImageView mine_iv;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment[] fragments=new Fragment[4];
    private int count;
    private long exitTime = 0;
    private ImageView delete;
    private Button five_star;
    private Button submit;
    private TextView title,content;
    private SharedPreferences sharedPreferences;
    final public static int REQUEST_CODE_ASK_STORAGE = 123;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_main);
        setPermisson();
        int currentTime= (int) (System.currentTimeMillis()/1000/60/60/24);
        sharedPreferences=this.getSharedPreferences("time", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor =sharedPreferences.edit();
        final Intent intent=getIntent();
        if(intent.getBooleanExtra("flag",false)){
            LayoutInflater layoutInflater = this.getLayoutInflater();
            View customDialog = layoutInflater.inflate(R.layout.update_dialog, null);
            title= (TextView) customDialog.findViewById(R.id.update_title);
            content= (TextView) customDialog.findViewById(R.id.description_update);
            submit= (Button)customDialog.findViewById(R.id.download);
            delete= (ImageView) customDialog.findViewById(R.id.dialog_delete);
            title.setText(intent.getStringExtra("title"));
            content.setText(intent.getStringExtra("content"));
            final Dialog dialog = new Dialog(this, R.style.edit_AlertDialog_style);
            dialog.show();
            dialog.getWindow().setContentView(customDialog);
            dialog.setCanceledOnTouchOutside(false);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Log.e("msg","downUrl:"+intent.getStringExtra("downUrl"));
                    AppUtils.loadNewVersionProgress(MainActivity.this,intent.getStringExtra("downUrl"));
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }
       if(!ShareUtil.getTag(this)){
           //对数据进行编辑，返回editor对象
           editor.putInt("firstTime", (int) (System.currentTimeMillis()/1000/60/60/24));
           editor.putBoolean("flag",true);
           editor.putBoolean("isSubmit",true);
           editor.commit();//将数据持久化到存储介质中
       }

       if(sharedPreferences.getBoolean("isSubmit",true) &&(currentTime-sharedPreferences.getInt("firstTime",0))>=7){
           editor.putBoolean("isSubmit",false);
           LayoutInflater layoutInflater = this.getLayoutInflater();
           View customDialog = layoutInflater.inflate(R.layout.open_diaglog, null);
           delete= (ImageView) customDialog.findViewById(R.id.dialog_delete);
           five_star= (Button) customDialog.findViewById(R.id.five_star);
           final Dialog dialog = new Dialog(this, R.style.edit_AlertDialog_style);
           dialog.show();
           dialog.getWindow().setContentView(customDialog);
           dialog.setCanceledOnTouchOutside(false);
           delete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   dialog.dismiss();
               }
           });
           five_star.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   try {
                       dialog.dismiss();
                       String apppkg = "com.gsy.glsurvive";
                       Uri uri = Uri.parse("market://details?id=" + apppkg);
                       Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                       startActivity(intent);
                   } catch (Exception e) {
                       Toast.makeText(MainActivity.this, "打开指定应用市场失败", Toast.LENGTH_SHORT).show();
                   }
               }
           });
           editor.commit();
       }

        if(ShareUtil.getTag(this) && sharedPreferences.getBoolean("flag",true)){
            editor.putBoolean("flag",false);
            LayoutInflater layoutInflater = this.getLayoutInflater();
            View customDialog = layoutInflater.inflate(R.layout.open_diaglog, null);
            delete= (ImageView) customDialog.findViewById(R.id.dialog_delete);
            five_star= (Button) customDialog.findViewById(R.id.five_star);
            final Dialog dialog = new Dialog(this, R.style.edit_AlertDialog_style);
            dialog.show();
            dialog.getWindow().setContentView(customDialog);
            dialog.setCanceledOnTouchOutside(false);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            five_star.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                        editor.putBoolean("isSubmit",false);
                        String apppkg = "com.gsy.glsurvive";
                        Uri uri = Uri.parse("market://details?id=" + apppkg);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "打开指定应用市场失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            editor.commit();
        }
    }

    @Override
    public void initView() {
        if(!ShareUtil.getTag(this)){
            //引导层显示
            View guide = LayoutInflater.from(MainActivity.this).inflate(R.layout.guide_surface_first,null);
            //  guide.setBackground(new BitmapDrawable());
            LinearLayout layout= (LinearLayout) guide.findViewById(R.id.high_light);
            ImageView next= (ImageView) guide.findViewById(R.id.next_step);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("msg","diasnle");
                    ToastUtils.showToast(MainActivity.this,"下一步");

                }
            });
            Controller controller = NewbieGuide.with(MainActivity.this)
                    .setOnGuideChangedListener(new OnGuideChangedListener() {//设置监听
                        @Override
                        public void onShowed(Controller controller) {
                        }
                        @Override
                        public void onRemoved(Controller controller) {
                            firstPage_iv.setImageResource(R.mipmap.hy_shouye);
                            strategy_iv.setImageResource(R.mipmap.hy_selected_gonglue);
                            data_iv.setImageResource(R.mipmap.hy_zilioaku);
                            mine_iv.setImageResource(R.mipmap.hy_wode);
                            firstPage_tv.setTextColor(getResources().getColor(R.color.white));
                            strategy_tv.setTextColor(getResources().getColor(R.color.brown));
                            data_tv.setTextColor(getResources().getColor(R.color.white));
                            mine_tv.setTextColor(getResources().getColor(R.color.white));
                            choice(1);
                        }
                    })
                    .addHighLight(layout, HighLight.Type.RECTANGLE)
                    .setBackgroundColor(Color.BLACK)//设置引导层背景色，建议有透明度，默认背景色为：0xb2000000
                    .setEveryWhereCancelable(false)//设置点击任何区域消失，默认为true
                    .setLayoutRes(R.layout.guide_surface_first,R.id.next_step)//自定义的提示layout,第二个可变参数为点击隐藏引导层view的id
                    .alwaysShow(true)//是否每次都显示引导层，默认false
                    .setLabel("guide1")
                    .build();//构建引导层的控制器
                  controller.show();//显示引导层
        }


        firstPage = (LinearLayout) findViewById(R.id.first_page);
        strategy = (LinearLayout) findViewById(R.id.strategy);
        data= (LinearLayout) findViewById(R.id.data);
        mine = (LinearLayout) findViewById(R.id.mine);

        firstPage_tv= (TextView) findViewById(R.id.first_page_tv);
        strategy_tv= (TextView) findViewById(R.id.strategy_tv);
        data_tv= (TextView) findViewById(R.id.data_tv);
        mine_tv= (TextView) findViewById(R.id.mine_tv);

        firstPage_iv= (ImageView) findViewById(R.id.first_page_iv);
        strategy_iv= (ImageView) findViewById(R.id.strategy_iv);
        data_iv= (ImageView) findViewById(R.id.data_iv);
        mine_iv= (ImageView) findViewById(R.id.mine_iv);
    }

    @Override
    public void afterView() {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragments[0]=new FirstPageFragment();
        fragmentTransaction.add(R.id.main_layout,fragments[0]);
        fragmentTransaction.commit();
        count=0;
        //程序开始默认首页
        firstPage_iv.setImageResource(R.mipmap.hy_selected_shouye);
        firstPage_tv.setTextColor(getResources().getColor(R.color.brown));
        //首页
        firstPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstPage_iv.setImageResource(R.mipmap.hy_selected_shouye);
                strategy_iv.setImageResource(R.mipmap.hy_gonglue);
                data_iv.setImageResource(R.mipmap.hy_zilioaku);
                mine_iv.setImageResource(R.mipmap.hy_wode);
                firstPage_tv.setTextColor(getResources().getColor(R.color.brown));
                strategy_tv.setTextColor(getResources().getColor(R.color.white));
                data_tv.setTextColor(getResources().getColor(R.color.white));
                mine_tv.setTextColor(getResources().getColor(R.color.white));
                choice(0);
            }
        });
        //攻略
        strategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstPage_iv.setImageResource(R.mipmap.hy_shouye);
                strategy_iv.setImageResource(R.mipmap.hy_selected_gonglue);
                data_iv.setImageResource(R.mipmap.hy_zilioaku);
                mine_iv.setImageResource(R.mipmap.hy_wode);
                firstPage_tv.setTextColor(getResources().getColor(R.color.white));
                strategy_tv.setTextColor(getResources().getColor(R.color.brown));
                data_tv.setTextColor(getResources().getColor(R.color.white));
                mine_tv.setTextColor(getResources().getColor(R.color.white));
                choice(1);
            }
        });
        //资料库
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstPage_iv.setImageResource(R.mipmap.hy_shouye);
                strategy_iv.setImageResource(R.mipmap.hy_gonglue);
                data_iv.setImageResource(R.mipmap.hy_selected_ziliaok);
                mine_iv.setImageResource(R.mipmap.hy_wode);
                firstPage_tv.setTextColor(getResources().getColor(R.color.white));
                strategy_tv.setTextColor(getResources().getColor(R.color.white));
                data_tv.setTextColor(getResources().getColor(R.color.brown));
                mine_tv.setTextColor(getResources().getColor(R.color.white));
                choice(2);
            }
        });
        //我的
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstPage_iv.setImageResource(R.mipmap.hy_shouye);
                strategy_iv.setImageResource(R.mipmap.hy_gonglue);
                data_iv.setImageResource(R.mipmap.hy_zilioaku);
                mine_iv.setImageResource(R.mipmap.hy_selected_wode);
                firstPage_tv.setTextColor(getResources().getColor(R.color.white));
                strategy_tv.setTextColor(getResources().getColor(R.color.white));
                data_tv.setTextColor(getResources().getColor(R.color.white));
                mine_tv.setTextColor(getResources().getColor(R.color.brown));
                choice(3);
            }
        });
    }
    public void choice(int btn_index){
        if(count!=btn_index){
            fragmentTransaction=fragmentManager.beginTransaction();
            if(fragments[btn_index]==null){
                fragments[btn_index]=newFragment(btn_index);
                fragmentTransaction.add(R.id.main_layout,fragments[btn_index]);
            }else{
                fragmentTransaction.show(fragments[btn_index]);
            }
            fragmentTransaction.hide(fragments[count]);
            fragmentTransaction.commit();
            count=btn_index;
        }
    }

    public Fragment newFragment(int btn_index){
        switch (btn_index){
            case 0:
                return new FirstPageFragment();
            case 1:
                return new StrategyFragment();
            case 2:
                return new DataFragment();
            case 3:
                return new MineFragment();
        }
        return  null;
    }

    //再按一次返回键退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }
    public void setPermisson() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_STORAGE);
                return ;
            } else {
                Log.e("msg", "权限申请ok");

            }
        } else {
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_STORAGE:
                Log.e("msg","grantResults[0]:"+grantResults[0]);
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // Permission Denied
                    Toast.makeText(this, "授权失败！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
