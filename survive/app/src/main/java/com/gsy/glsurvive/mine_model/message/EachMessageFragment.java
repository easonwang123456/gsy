package com.gsy.glsurvive.mine_model.message;

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

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class EachMessageFragment extends Fragment {
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
    private MessageLikeAdapter messageLikeAdapter;
    private MessageReplyAdapter messageReplyAdapter;
    private ProgressDialog mProgressDialog;
    public static EachMessageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        EachMessageFragment pageFragment = new EachMessageFragment();
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
        messageLikeAdapter=new MessageLikeAdapter();
        messageReplyAdapter=new MessageReplyAdapter();
        RefreshLayout refreshLayout = (RefreshLayout)view.findViewById(R.id.refreshLayout);
        if(mPage==1){
            new MyMessagePresenter(EachMessageFragment.this).messageLike(getActivity(),10,1,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new MyMessagePresenter(EachMessageFragment.this).messageLike(getActivity(),10,1,1);
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
                    Log.e("msg","loadPage1:"+loadPage);
                    new MyMessagePresenter(EachMessageFragment.this).messageLike(getActivity(),10,loadPage,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });


        }
        if(mPage==2){
          new MyMessagePresenter(EachMessageFragment.this).messageReply(getActivity(),10,1,1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new MyMessagePresenter(EachMessageFragment.this).messageReply(getActivity(),10,1,1);
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
                    new MyMessagePresenter(EachMessageFragment.this).messageReply(getActivity(),10,loadPage,2);
                    refreshlayout.finishLoadmore(1000);
                }
            });
        }

    messageLikeAdapter.setOnItemClickListener(new MessageLikeAdapter.OnItemClickListener() {
     @Override
     public void onItemClick(int position, int id, int type) {
         Intent intent=new Intent(getActivity(), BannerDetailActivity.class);
         intent.putExtra("id",id);
         intent.putExtra("type",type);
         startActivity(intent);
     }
 });
        messageReplyAdapter.setOnItemClickListener(new MessageReplyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id, int type) {
                Intent intent=new Intent(getActivity(), BannerDetailActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });
        return view;
    }
 public void messageLikeList(ArrayList<MessageLikeResult.ContentBean> list,int page,int index){
     mProgressDialog.dismiss();
     if(index==1){
         messageLikeAdapter.addDatas(list,getActivity());
         recyclerView.setAdapter(messageLikeAdapter);

     }
     if(!list.isEmpty() & index==2){
         loadPage=page;
         messageLikeAdapter.addDatas(list,getActivity());

     }

 }
    public void messageReplyList(ArrayList<ReplyMessageResult.ContentBean> list,int page,int index){
        mProgressDialog.dismiss();
        if(index==1){
            messageReplyAdapter.addDatas(list,getActivity());
            recyclerView.setAdapter(messageReplyAdapter);
            loadPage=2;

        }
        if(!list.isEmpty() & index==2){
            loadPage=page;
            messageReplyAdapter.addDatas(list,getActivity());

        }

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
