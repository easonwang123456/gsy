package com.gsy.glsurvive.mine_model.collect;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoListDetailActivity;
import com.gsy.glsurvive.utils.PermissionUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class EachCollectFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private RecyclerView recyclerView;
    private View view;
    private static int loadPage=2;
    private Boolean flag1=false;
    private Boolean flag2=false;
    private Boolean flag3=false;
    private Boolean flag4=false;
    private Boolean flag5=false;
    private Boolean flag6=false;
    private ArrayList<CollectListResult.ContentBean> list_collect=new ArrayList<>();
    private CollectAdapter collectRecyclerAdapter;
    private PopupWindow popupWindow;
    private ImageView collect_empty;
    private ProgressDialog mProgressDialog;

    public static EachCollectFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        EachCollectFragment pageFragment = new EachCollectFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        loading();

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_collect,container,false);
        collect_empty= (ImageView) view.findViewById(R.id.collect_empty);
        collectRecyclerAdapter=new CollectAdapter();
        recyclerView= (RecyclerView) view.findViewById(R.id.collect_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RefreshLayout refreshLayout = (RefreshLayout)view.findViewById(R.id.refreshLayout);
        if(mPage==1){
            new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),0,10,1,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),0,10,1,1);
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
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),0,10,loadPage,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });


        }
        if(mPage==2){
            new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),1,10,1,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),1,10,1,1);
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
                    Log.e("msg","loadPage2:"+loadPage);
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),1,10,loadPage,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });
        }
        if(mPage==3){
            new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),2,10,1,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),2,10,1,1);
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
                    Log.e("msg","loadPage3:"+loadPage);
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),2,10,loadPage,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });

        }
        if(mPage==4){
            new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),5,10,1,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),1,10,1,1);
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
                    Log.e("msg","loadPage4:"+loadPage);
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),1,10,loadPage,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });

        }
        if(mPage==5){
            new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),13,10,1,1);
            refreshLayout.setOnRefreshListener( new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),5,10,1,1);
                    refreshlayout.finishRefresh(1000);
                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    if(!flag5){
                        loadPage=2;
                        flag5=true;
                    }
                    Log.e("msg","loadPage5:"+loadPage);
                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),5,10,loadPage,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });

        }

//        if(mPage==6){
//            new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),13,10,1,1);
//            refreshLayout.setOnRefreshListener( new OnRefreshListener() {
//                @Override
//                public void onRefresh(RefreshLayout refreshlayout) {
//                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),13,10,1,1);
//                    refreshlayout.finishRefresh(1000);
//
//                }
//            });
//            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
//                @Override
//                public void onLoadmore(RefreshLayout refreshlayout) {
//                    if(!flag6){
//                        loadPage=2;
//                        flag6=true;
//                    }
//                    Log.e("msg","loadPage5:"+loadPage);
//                    new MyCollectPresenter(EachCollectFragment.this).collectList(getActivity(),13,10,loadPage,2);
//                    refreshlayout.finishLoadmore(1000);
//                }
//            });
//
//        }

        collectRecyclerAdapter.setOnItemClickListener(new CollectAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id, int type) {
                if(type==13){
                    Intent intent=new Intent(getActivity(), VideoListDetailActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("type",type);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(getActivity(), BannerDetailActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("type",type);
                    startActivity(intent);
                }

            }
        });
        collectRecyclerAdapter.setOnLongClickListener(new CollectAdapter.OnLongClickListener() {
            @Override
            public void onLongClick(final int position, int id, int type, final String collectId) {
                PermissionUtil.backgroundAlpha(0.5f,getActivity());
                View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.collect_pop, null);
                Button delete= (Button) contentView.findViewById(R.id.delete_collect);
                Button cancel= (Button) contentView.findViewById(R.id.cancel_collect);
                //绑定弹出界面的内容到popwindow控件上，设置该popwindow的长和宽，200px，单位是像素。
                popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,true);
                //设置SelectPicPopupWindow弹出窗体动画效果
                popupWindow.setAnimationStyle(R.style.popupAnimation);
                //popupWindow.setFocusable(true); //设置PopupWindow可获得焦点
                popupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0,0);
                  delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new MyCollectPresenter(EachCollectFragment.this).collectCancel(getActivity(),collectId,position);

                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        PermissionUtil.backgroundAlpha(1f,getActivity());
                    }
                });

            }
        });
        return view;
    }

    public void showCollectList(ArrayList<CollectListResult.ContentBean> list,int page,int index){
        mProgressDialog.dismiss();
        if(!list.isEmpty()&&index==1){
            collectRecyclerAdapter.refresh(list,getActivity(),getActivity());
            recyclerView.setAdapter(collectRecyclerAdapter);
            collect_empty.setVisibility(View.INVISIBLE);
            loadPage=2;

        }
        if(!list.isEmpty() & index==2){
            loadPage=page;
            collectRecyclerAdapter.addDatas(list,getActivity(),getActivity());

        }

    }
  public void showDelete(int position){
      collectRecyclerAdapter.removeItem(position);
      popupWindow.dismiss();
      PermissionUtil.backgroundAlpha(1f,getActivity());
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
