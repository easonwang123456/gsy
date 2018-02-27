package com.gsy.glsurvive.strategy_model;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.hubert.library.Controller;
import com.app.hubert.library.HighLight;
import com.app.hubert.library.NewbieGuide;
import com.app.hubert.library.OnGuideChangedListener;
import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoListDetailActivity;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.gsy.glsurvive.strategy_model.battle.BattleActivity;
import com.gsy.glsurvive.strategy_model.battle.battle_recycler.BattleListActivity;
import com.gsy.glsurvive.strategy_model.chicken.ChickenActivity;
import com.gsy.glsurvive.strategy_model.gun.GunActivity;
import com.gsy.glsurvive.strategy_model.gun.gun_recycler.GunListActivity;
import com.gsy.glsurvive.utils.ShareUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cn.bingoogolapple.bgabanner.BGABanner;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by TR-AND2 on 2017/12/18.
 */

public class EachStrategyFragment extends Fragment {
    private BGABanner bgaBanner;
    public static final String PAGE = "PAGE";
    private int mPage;
    private RecyclerView recyclerView;
    private View view;
    public StrategyAdapter mAdapter;
    private ArrayList<String> bannerBeanArrayList =new ArrayList<>();
    private ImageView hot1,hot2,hot3,hot4,mix,creation,survive;
    private TextView hot_see1,hot_see2,hot_see3,hot_see4,hot_title_tv1,hot_title_tv2,hot_title_tv3,hot_title_tv4;
    private int  loadPage=2;
    private Boolean flag1=false;
    private Boolean flag2=false;
    private LinearLayout battle,gun_strategy,chicken;
    private String title1,title2,title3;
    private int typeId1,typeId2,typeId3;
    public static EachStrategyFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(PAGE, page);
        Log.e("msg","page1:"+page);
        EachStrategyFragment pageFragment = new EachStrategyFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_page,container,false);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter=new StrategyAdapter();
        RefreshLayout refreshLayout = (RefreshLayout)view.findViewById(R.id.refreshLayout);
        if(mPage==1){
            //引导层显示
            if(!ShareUtil.getTag(getActivity())){
                ShareUtil.saveTag(getActivity());
                View guide = LayoutInflater.from(getActivity()).inflate(R.layout.guide_surface_strategy,null);
                LinearLayout layout= (LinearLayout) guide.findViewById(R.id.high_light);
                Controller controller = NewbieGuide.with(getActivity())
                        .setOnGuideChangedListener(new OnGuideChangedListener() {//设置监听
                            @Override
                            public void onShowed(Controller controller) {
                            }
                            @Override
                            public void onRemoved(Controller controller) {
                                controller.remove();//移除引导层
                            }
                        })
                        .addHighLight(layout, HighLight.Type.RECTANGLE)
                        .setBackgroundColor(Color.BLACK)//设置引导层背景色，建议有透明度，默认背景色为：0xb2000000
                        .setEveryWhereCancelable(false)//设置点击任何区域消失，默认为true
                        .setLayoutRes(R.layout.guide_surface_strategy,R.id.ok)//自定义的提示layout,第二个可变参数为点击隐藏引导层view的id
                        .alwaysShow(true)//是否每次都显示引导层，默认false
                        .setLabel("guide2")
                        .build();//构建引导层的控制器
                controller.show();//显示引导层

            }

            new EachStrategyPresenter(EachStrategyFragment.this).strategyRequest(getActivity(),10,1,0,1,1);
            setHeader(recyclerView);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new EachStrategyPresenter(EachStrategyFragment.this).strategyRequest(getActivity(),10,1,0,1,1);
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
                   new EachStrategyPresenter(EachStrategyFragment.this).strategyRequest(getActivity(),10,loadPage,0,1,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });


        }
        if(mPage==2){
            new EachStrategyPresenter(EachStrategyFragment.this).strategyRequest(getActivity(),10,1,0,0,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new EachStrategyPresenter(EachStrategyFragment.this).strategyRequest(getActivity(),10,1,0,0,1);
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
                    new EachStrategyPresenter(EachStrategyFragment.this).strategyRequest(getActivity(),10,loadPage,0,0,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });
        }

        return view;
    }

    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_strategy_header, view, false);
        battle= (LinearLayout) header.findViewById(R.id.battle);
        gun_strategy= (LinearLayout) header.findViewById(R.id.gun_strategy);
        chicken= (LinearLayout) header.findViewById(R.id.chicken);
        mix= (ImageView) header.findViewById(R.id.mix_iv);
        creation= (ImageView) header.findViewById(R.id.creation_iv);
        survive= (ImageView) header.findViewById(R.id.survive_iv);
        hot1= (ImageView) header.findViewById(R.id.hot1);
        hot2= (ImageView) header.findViewById(R.id.hot2);
        hot3= (ImageView) header.findViewById(R.id.hot3);
        hot4= (ImageView) header.findViewById(R.id.hot4);
        hot_see1= (TextView) header.findViewById(R.id.hot_see1);
        hot_see2= (TextView) header.findViewById(R.id.hot_see2);
        hot_see3= (TextView) header.findViewById(R.id.hot_see3);
        hot_see4= (TextView) header.findViewById(R.id.hot_see4);
        hot_title_tv1= (TextView) header.findViewById(R.id.hot_title_tv1);
        hot_title_tv2= (TextView) header.findViewById(R.id.hot_title_tv2);
        hot_title_tv3= (TextView) header.findViewById(R.id.hot_title_tv3);
        hot_title_tv4= (TextView) header.findViewById(R.id.hot_title_tv4);
        bgaBanner= (BGABanner) header.findViewById(R.id.banner_splash_pager_strategy);
        mAdapter.setHeaderView(header);
        battle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), BattleListActivity.class);
                intent.putExtra("title",title1);
                intent.putExtra("typeId",typeId1);
                startActivity(intent);
            }
        });
        gun_strategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), GunListActivity.class);
                intent.putExtra("title",title2);
                intent.putExtra("typeId",typeId2);
                startActivity(intent);
            }
        });
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), ChickenActivity.class);
                intent.putExtra("title",title3);
                intent.putExtra("typeId",typeId3);
                startActivity(intent);
            }
        });

    }

    public void showBanner(final ArrayList<EachStrategyResult.ContentBean.BannerBean> list) {
        bannerBeanArrayList.clear();
        for(int i=0;i<list.size();i++){
            bannerBeanArrayList.add(list.get(i).getImgUrl());
        }
        Log.e("msg","list:"+bannerBeanArrayList);
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

    public void showRecycler(ArrayList<EachStrategyResult.ContentBean.PostDataBean> list,int index,int page){
        if(!list.isEmpty() & index==1){
            mAdapter.refresh(list,getActivity());
            recyclerView.setAdapter(mAdapter);
            loadPage=2;
        }
        if(!list.isEmpty()  & index==2){
            this.loadPage=page;
            mAdapter.addDatas(list,getActivity());
            // recyclerView.setAdapter(mAdapter);
        }

        mAdapter.setOnItemClickListener(new StrategyAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position, int id, int type) {
                Intent intent=new Intent(getActivity(), BannerDetailActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });
    }
    public void showMenu(ArrayList<EachStrategyResult.ContentBean.MenuBean> list){
        Picasso.with(getActivity()).load(list.get(0).getImgUrl()).placeholder(R.mipmap.wuwang).into(mix);
        Picasso.with(getActivity()).load(list.get(1).getImgUrl()).placeholder(R.mipmap.wuwang).into(creation);
        Picasso.with(getActivity()).load(list.get(2).getImgUrl()).placeholder(R.mipmap.wuwang).into(survive);
        title1=list.get(0).getTitle();
        typeId1=list.get(0).getTypeId();
        title2=list.get(1).getTitle();
        typeId2=list.get(1).getTypeId();
        title3=list.get(2).getTitle();
        typeId3=list.get(2).getTypeId();

    }
    public void showHot(final ArrayList<EachStrategyResult.ContentBean.HotDataBean> list){

        Picasso.with(getActivity()).load(list.get(0).getImgUrl()).placeholder(R.mipmap.wuwang).transform(new RoundedCornersTransformation(15, 1)).into(hot1);
        Picasso.with(getActivity()).load(list.get(1).getImgUrl()).placeholder(R.mipmap.wuwang).transform(new RoundedCornersTransformation(15, 1)).into(hot2);
        Picasso.with(getActivity()).load(list.get(2).getImgUrl()).placeholder(R.mipmap.wuwang).transform(new RoundedCornersTransformation(15, 1)).into(hot3);
        Picasso.with(getActivity()).load(list.get(3).getImgUrl()).placeholder(R.mipmap.wuwang).transform(new RoundedCornersTransformation(15, 1)).into(hot4);
//        Log.e("msg","list.get(0).getName():"+list.get(0).getName());
        Log.e("msg","list:"+list);
        hot_title_tv1.setText(list.get(0).getName());
        hot_title_tv2.setText(list.get(1).getName());
        hot_title_tv3.setText(list.get(2).getName());
        hot_title_tv4.setText(list.get(3).getName());
        hot_see1.setText(list.get(0).getHits());
        hot_see2.setText(list.get(1).getHits());
        hot_see3.setText(list.get(2).getHits());
        hot_see4.setText(list.get(3).getHits());

        hot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),BannerDetailActivity.class);
                intent.putExtra("id",list.get(0).getId());
                intent.putExtra("type",list.get(0).getType());
                startActivity(intent);
            }
        });
        hot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),BannerDetailActivity.class);
                intent.putExtra("id",list.get(1).getId());
                intent.putExtra("type",list.get(1).getType());
                startActivity(intent);
            }
        });
        hot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),BannerDetailActivity.class);
                intent.putExtra("id",list.get(2).getId());
                intent.putExtra("type",list.get(2).getType());
                startActivity(intent);
            }
        });
        hot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),BannerDetailActivity.class);
                intent.putExtra("id",list.get(3).getId());
                intent.putExtra("type",list.get(3).getType());
                startActivity(intent);
            }
        });
    }

}
