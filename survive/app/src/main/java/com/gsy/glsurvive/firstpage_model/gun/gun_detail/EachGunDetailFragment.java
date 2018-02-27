package com.gsy.glsurvive.firstpage_model.gun.gun_detail;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunAdapter;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunListResult;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunPresenter;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoListDetailActivity;

import java.util.ArrayList;


/**
 * Created by TR-AND2 on 2017/12/1.
 */

public class EachGunDetailFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private int id;
    private View view;
    private ProgressDialog mProgressDialog;
    private GunGridAdapter gunGridAdapter;
    private GridView gridView;
    private TableLayout tableLayout;
    private ProgressBar power_bar,range_bar,stable_bar,speed_bar;
    private TextView power_num,range_num,stable_num,speed_num,per_damage,initial_speed,recoil,volume,interval,back_zero,reload_mode,shoot_mode,reload_time;
    int[] img=new int[]{R.mipmap.huise,R.mipmap.red,R.mipmap.juse,R.mipmap.lanse};
    public static EachGunDetailFragment newInstance(int page,int id) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        args.putInt("id",id);
        EachGunDetailFragment pageFragment = new EachGunDetailFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        id=getArguments().getInt("id");
        loading();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mPage==1){
            new GunDetailPresenter(EachGunDetailFragment.this).gunDetailDamage(getActivity(),id);
            view=inflater.inflate(R.layout.fragment_damage,container,false);
            power_bar= (ProgressBar) view.findViewById(R.id.power_bar);
            range_bar= (ProgressBar) view.findViewById(R.id.range_bar);
            stable_bar= (ProgressBar) view.findViewById(R.id.stable_bar);
            speed_bar= (ProgressBar) view.findViewById(R.id.speed_bar);
            power_num= (TextView) view.findViewById(R.id.power_num);
            range_num= (TextView) view.findViewById(R.id.range_num);
            stable_num= (TextView) view.findViewById(R.id.stable_num);
            speed_num= (TextView) view.findViewById(R.id.speed_num);
            tableLayout= (TableLayout) view.findViewById(R.id.tablelayout_damage);
            tableLayout.setStretchAllColumns(true);//设置所有的item都可伸缩扩展
            tableLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);//设置分割线为中间显示

        }
        if(mPage==2){
            new GunDetailPresenter(EachGunDetailFragment.this).gunDetailData(getActivity(),id);
            view=inflater.inflate(R.layout.fragment_gun_data,container,false);
            per_damage= (TextView) view.findViewById(R.id.per_damage);
            initial_speed= (TextView) view.findViewById(R.id.initial_speed);
            recoil= (TextView) view.findViewById(R.id.recoil);
            volume= (TextView) view.findViewById(R.id.volume);
            interval= (TextView) view.findViewById(R.id.interval);
            back_zero= (TextView) view.findViewById(R.id.back_zero);
            reload_mode= (TextView) view.findViewById(R.id.reload_mode);
            shoot_mode= (TextView) view.findViewById(R.id.shoot_mode);
            reload_time= (TextView) view.findViewById(R.id.reload_time);
        }
        if(mPage==3){
            new GunDetailPresenter(EachGunDetailFragment.this).gunDetailComponent(getActivity(),id);
            view=inflater.inflate(R.layout.fragment_component,container,false);
            gridView= (GridView) view.findViewById(R.id.component_gridView);
        }

        return view;
    }

    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(getActivity(), R.style.CustomProgressDialog);
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

    public void showDamage(GunDetailResult.ContentBean contentBean){
        mProgressDialog.dismiss();
        power_bar.setProgress(Integer.parseInt(contentBean.getWqwl()));
        range_bar.setProgress(Integer.parseInt(contentBean.getWqsc()));
        stable_bar.setProgress(Integer.parseInt(contentBean.getWqwd()));
        speed_bar.setProgress(Integer.parseInt(contentBean.getWqss()));
        power_num.setText(""+contentBean.getWqwl());
        range_num.setText(""+contentBean.getWqsc());
        stable_num.setText(""+contentBean.getWqwd());
        speed_num.setText(""+contentBean.getWqss());
        int length = contentBean.getDuibi().size();//根据数据，判断行数
        for (int i = 0; i < length;i++){
            View layout = LayoutInflater.from(getActivity()).inflate(R.layout.tablayout_item,null);//布局打气筒获取单行对象
            TextView name= (TextView) layout.findViewById(R.id.gun_name);
            ImageView st0= (ImageView) layout.findViewById(R.id.st0);
            ImageView st1= (ImageView) layout.findViewById(R.id.st1);
            ImageView st2= (ImageView) layout.findViewById(R.id.st2);
            ImageView st3= (ImageView) layout.findViewById(R.id.st3);
            ImageView tb0= (ImageView) layout.findViewById(R.id.tb0);
            ImageView tb1= (ImageView) layout.findViewById(R.id.tb1);
            ImageView tb2= (ImageView) layout.findViewById(R.id.tb2);
            ImageView tb3= (ImageView) layout.findViewById(R.id.tb3);
            name.setText(contentBean.getDuibi().get(i).getName());
            st0.setImageResource(img[contentBean.getDuibi().get(i).getSt0()]);
            st1.setImageResource(img[contentBean.getDuibi().get(i).getSt1()]);
            st2.setImageResource(img[contentBean.getDuibi().get(i).getSt2()]);
            st3.setImageResource(img[contentBean.getDuibi().get(i).getSt3()]);

            tb0.setImageResource(img[contentBean.getDuibi().get(i).getTb0()]);
            tb1.setImageResource(img[contentBean.getDuibi().get(i).getTb1()]);
            tb2.setImageResource(img[contentBean.getDuibi().get(i).getTb2()]);
            tb3.setImageResource(img[contentBean.getDuibi().get(i).getTb3()]);
            tableLayout.addView(layout);//将这一行加入表格中
        }
    }


    public void showData(GunDetailResult.ContentBean contentBean){
        mProgressDialog.dismiss();
        per_damage.setText(""+contentBean.getSjsh());
        initial_speed.setText(""+contentBean.getSjcs());
        recoil.setText(""+contentBean.getSjhz());
        volume.setText(""+contentBean.getSjrl());
        interval.setText(""+contentBean.getSjjg());
        back_zero.setText(""+contentBean.getSjjl());
        reload_mode.setText(""+contentBean.getSjfs());
        shoot_mode.setText(""+contentBean.getSjms());
        reload_time.setText(""+contentBean.getSjsj());
    }

    public void showComponent(GunDetailResult.ContentBean contentBean){
        mProgressDialog.dismiss();
        gunGridAdapter=new GunGridAdapter(getActivity(),contentBean.getPeijian());
        gridView.setAdapter(gunGridAdapter);
    }


}
