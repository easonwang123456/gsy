package com.gsy.glsurvive.firstpage_model.gun;

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

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.gsy.glsurvive.firstpage_model.gun.gun_detail.GunDetailActivity;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoListDetailActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;


/**
 * Created by TR-AND2 on 2017/12/1.
 */

public class EachGunFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private RecyclerView recyclerView;
    private View view;
    public FirstGunAdapter mAdapter;
    private ProgressDialog mProgressDialog;
    public static EachGunFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        EachGunFragment pageFragment = new EachGunFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_each_gun,container,false);
        loading();
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter=new FirstGunAdapter();
        if(mPage==1){
            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),0);

        }
        if(mPage==2){
            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),1);
        }
        if(mPage==3){
            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),2);
        }
        if(mPage==4){
            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),3);
        }
        if(mPage==5){
            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),4);
        }
//        if(mPage==6){
//            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),5);
//
//        }
        if(mPage==6){
            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),6);

        }
//        if(mPage==7){
//            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),7);
//
//        }
//        if(mPage==8){
//            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),8);
//
//        }
//        if(mPage==9){
//            new FirstGunPresenter(EachGunFragment.this).gunList(getActivity(),9);
//
//        }

        return view;
    }

       public void showRecycler(ArrayList<FirstGunListResult.ContentBean> list){
          mAdapter.addDatas(list,getActivity());
          recyclerView.setAdapter(mAdapter);
          mProgressDialog.dismiss();

      mAdapter.setOnItemClickListener(new FirstGunAdapter.OnItemClickListener() {

          @Override
          public void onItemClick(int position, int id, int type) {
                  Intent intent=new Intent(getActivity(),GunDetailActivity.class);
                  intent.putExtra("id",id);
                  startActivity(intent);

          }
      });
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
}
