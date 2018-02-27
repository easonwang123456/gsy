package com.gsy.glsurvive.firstpage_model;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.data_model.H5UrlActivity;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunActivity;
import com.gsy.glsurvive.firstpage_model.map.FirstMapActivity;
import com.gsy.glsurvive.firstpage_model.rookie.RookieActivity;
import com.gsy.glsurvive.firstpage_model.video.VideoDetailActivity;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoListDetailActivity;
import com.gsy.glsurvive.utils.LogUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by TR-AND2 on 2017/12/1.
 */

public class EachPageFragment extends Fragment {
    private BGABanner bgaBanner;
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private RecyclerView recyclerView;
    private View view;
    public FirstPageAdapter mAdapter;
    private ArrayList<String> bannerBeanArrayList =new ArrayList<>();
    private ImageView rookie_iv,video_iv,gun_iv,facility_iv;
    private TextView rookie_tv,video_tv,gun_tv,facility_tv;
    private int loadPage=2;
    private Boolean flag1=false;
    private Boolean flag2=false;
    private Boolean flag3=false;
    private Boolean flag4=false;
    private LinearLayout rookie,video,gun,facility;
    private ProgressDialog mProgressDialog;
    public static EachPageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        EachPageFragment pageFragment = new EachPageFragment();
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

        view=inflater.inflate(R.layout.fragment_page,container,false);
        loading();
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter=new FirstPageAdapter();
        RefreshLayout refreshLayout = (RefreshLayout)view.findViewById(R.id.refreshLayout);
        if(mPage==1){
            new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),0,10,1,0,1);
            setHeader(recyclerView);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),0,10,1,0,1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    if(!flag1){
                        loadPage=2;
                        flag1=true;
                    }
                    new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),0,10,loadPage,0,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });


        }
        if(mPage==2){
            new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),1,10,1,0,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),1,10,1,0,1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    if(!flag2){
                        loadPage=2;
                        flag2=true;
                    }
                    new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),1,10,loadPage,0,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });
        }
        if(mPage==3){
           new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),2,10,1,0,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),2,10,1,0,1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {

                    if(!flag3){
                        loadPage=2;
                        flag3=true;
                    }
                    new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),2,10,loadPage,0,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });

        }
        if(mPage==4){
            new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),13,10,1,0,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),13,10,1,0,1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {

                    if(!flag4){
                        loadPage=2;
                        flag4=true;
                    }
                    new FirstPagePresenter(EachPageFragment.this).firstPageRequest(getActivity(),13,10,loadPage,0,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });

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
    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.first_page_header, view, false);
        rookie= (LinearLayout) header.findViewById(R.id.rookie_guide);
        video= (LinearLayout) header.findViewById(R.id.video_details);
        gun= (LinearLayout) header.findViewById(R.id.gun_list);
        facility= (LinearLayout) header.findViewById(R.id.facility);
        rookie_iv= (ImageView) header.findViewById(R.id.rookie_iv);
        video_iv= (ImageView) header.findViewById(R.id.video_iv);
        gun_iv= (ImageView) header.findViewById(R.id.gun_iv);
        facility_iv= (ImageView) header.findViewById(R.id.facility_iv);
        rookie_tv= (TextView) header.findViewById(R.id.rookie_tv);
        video_tv= (TextView) header.findViewById(R.id.video_tv);
        gun_tv= (TextView) header.findViewById(R.id.gun_tv);
        facility_tv= (TextView) header.findViewById(R.id.facility_tv);
        bgaBanner= (BGABanner) header.findViewById(R.id.banner_splash_pager);
        mAdapter.setHeaderView(header);

        rookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), RookieActivity.class);
                startActivity(intent);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), VideoDetailActivity.class);
                startActivity(intent);
            }
        });
        gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FirstGunActivity.class);
                startActivity(intent);
            }
        });
        facility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FirstMapActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showBanner(final ArrayList<FirstPageRecommandResult.ContentBean.BannerBean> list) {
        mProgressDialog.dismiss();
        bannerBeanArrayList.clear();
        for(int i=0;i<list.size();i++){
            bannerBeanArrayList.add(list.get(i).getImgUrl());
        }
        bgaBanner.setData(bannerBeanArrayList,null);
        bgaBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Picasso.with(getActivity())
                        .load(model)
                        .placeholder(R.mipmap.wuwang)
                        .error(R.mipmap.wushoucang)
                        .into(itemView);
            }
        });


        bgaBanner.setDelegate(new BGABanner.Delegate<ImageView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
                if(Integer.parseInt(list.get(position).getType())==13){
                    Intent intent=new Intent(getActivity(),VideoListDetailActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    intent.putExtra("type",Integer.parseInt(list.get(position).getType()));
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(getActivity(),BannerDetailActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    intent.putExtra("type",Integer.parseInt(list.get(position).getType()));
                    startActivity(intent);

                }

            }
        });


    }

  public void showRecycler(final ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> list, int index, int page){
      if(index==1){
          mAdapter.refresh(list,getActivity());
          recyclerView.setAdapter(mAdapter);
          loadPage=2;
      }
      if(!list.isEmpty() && index==2){
          Log.e("msg","page:"+page);
          loadPage=page;
          mAdapter.addDatas(list,getActivity());

      }
      mProgressDialog.dismiss();

      mAdapter.setOnItemClickListener(new FirstPageAdapter.OnItemClickListener() {

          @Override
          public void onItemClick(int position, int id, int type,ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> list) {
              if(type==13){
                  Intent intent=new Intent(getActivity(),VideoListDetailActivity.class);
                  intent.putExtra("id",list.get(position).getId());
                  intent.putExtra("type",list.get(position).getType());
                  startActivity(intent);
              }else {
                  Intent intent = new Intent(getActivity(), BannerDetailActivity.class);
                  intent.putExtra("id", list.get(position).getId());
                  intent.putExtra("type", list.get(position).getType());
                  startActivity(intent);

              }
          }
      });
  }
   public void showMenu(ArrayList<FirstPageRecommandResult.ContentBean.MenuBean> list){
       Picasso.with(getActivity()).load(list.get(0).getImgUrl()).placeholder(R.mipmap.wuwang).into(rookie_iv);
       Picasso.with(getActivity()).load(list.get(1).getImgUrl()).placeholder(R.mipmap.wuwang).into(video_iv);
       Picasso.with(getActivity()).load(list.get(2).getImgUrl()).placeholder(R.mipmap.wuwang).into(gun_iv);
       Picasso.with(getActivity()).load(list.get(3).getImgUrl()).placeholder(R.mipmap.wuwang).into(facility_iv);
       rookie_tv.setText(list.get(0).getTitle());
       video_tv.setText(list.get(1).getTitle());
       gun_tv.setText(list.get(2).getTitle());
       facility_tv.setText(list.get(3).getTitle());
 }
//    public RectF getRectF(View view) {
//        RectF rectF = new RectF();
//        if (view != null) {
//            int[] location = new int[2];
//            view.getLocationOnScreen(location);
//            rectF.left = location[0];
//            rectF.top = location[1];
//            rectF.right = location[0] + view.getWidth();
//            rectF.bottom = location[1] + view.getHeight();
//        }
//        return rectF;
//    }

}
