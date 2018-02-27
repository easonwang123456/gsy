package com.gsy.glsurvive.firstpage_model.video;
import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ShareResult;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoListDetailActivity;
import com.gsy.glsurvive.utils.DownloadUtils;
import com.gsy.glsurvive.utils.ToastUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class EachVideoFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private ScrollRecycler recyclerView;
    private View view;
    private TextView repost_tv;
    private String repost_num;
    private  int loadPage = 2;
    private Boolean flag1 = false;
    private Boolean flag2 = false;
    private Boolean flag3 = false;
    private Boolean flag4 = false;
    private VideoRecyclerAdapter mAdapter;
    private LinearLayoutManager linearLayoutManager;
    private CompleteReceiver completeReceiver;
    private Boolean isChanged = true;
    private ProgressDialog mProgressDialog;


    public static EachVideoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        EachVideoFragment pageFragment = new EachVideoFragment();
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
        view = inflater.inflate(R.layout.fragment_page, container, false);
        loading();
        completeReceiver = new CompleteReceiver();
        getActivity().registerReceiver(completeReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        recyclerView = (ScrollRecycler) view.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new VideoRecyclerAdapter();
        RefreshLayout refreshLayout = (RefreshLayout) view.findViewById(R.id.refreshLayout);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int visibleItemCount = linearLayoutManager.getChildCount();
                if (newState == ScrollRecycler.SCROLL_STATE_IDLE) {
                    mAdapter.autoPlayVideo(recyclerView, visibleItemCount);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });

        if (mPage == 1) {
            new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 0, 0, 1, 10, 1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 0, 0, 1, 10, 1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    if (!flag1) {
                        loadPage = 2;
                        flag1 = true;
                    }
                    new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 0, 0, loadPage, 10, 2);
                    refreshlayout.finishLoadmore(1000);
                }
            });


        }
        if (mPage == 2) {
            new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 2, 0, 1, 10, 1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 2, 0, 1, 10, 1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    if (!flag2) {
                        loadPage = 2;
                        flag2 = true;
                    }
                    new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 2, 0, loadPage, 10, 2);
                    refreshlayout.finishLoadmore(1000);
                }
            });
        }
        if (mPage == 3) {
            new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 3, 0, 1, 10, 1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 3, 0, 1, 10, 1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    if (!flag3) {
                        loadPage = 2;
                        flag3 = true;
                    }
                    new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 3, 0, loadPage, 10, 2);
                    refreshlayout.finishLoadmore(1000);
                }
            });

        }
        if (mPage == 4) {
            new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 1, 0, 1, 10, 1);
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 1, 0, 1, 10, 1);
                    refreshlayout.finishRefresh(1000);

                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {

                    if (!flag4) {
                        loadPage = 2;
                        flag4 = true;
                    }
                    new VideoPresenter(EachVideoFragment.this).videoList(getActivity(), 1, 0, loadPage, 10, 2);
                    refreshlayout.finishLoadmore(1000);
                }
            });

        }
        mAdapter.setOnItemClickListener(new VideoRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id, int type, String source) {
                Intent intent = new Intent(getActivity(), VideoListDetailActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("type", type);
                startActivity(intent);
            }
        });
        mAdapter.setOnDownLoadClickListener(new VideoRecyclerAdapter.OnDownLoadClickListener() {
            @Override
            public void onDownLoadClick(int position, int id, int type, String source, String title, String urlImg) {
                if (Build.VERSION.SDK_INT >= 23){
                    if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                        ToastUtils.showToast(getActivity(),"检查权限是否开启");
                    }else{
                        ToastUtils.showToast(getActivity(), "开始下载");
                        DownloadUtils.downLoadFile(source, "" + title + ".mp4", "guide", getActivity());
                    }
                }

            }
        });

        mAdapter.setOnVolumeListener(new VideoRecyclerAdapter.OnVolumeListener() {
            @Override
            public void onVolumeClick(int position, int id, int type, ImageView imageView) {
                AudioManager mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
                if (isChanged) {
                    mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
                    imageView.setImageResource(R.drawable.jc_close_volume);
                    isChanged = false;
                } else {
                    imageView.setImageResource(R.drawable.jc_add_volume);
                    mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                    isChanged = true;
                }

            }
        });
        mAdapter.setOnLikeListener(new VideoRecyclerAdapter.OnLikeListener() {
            @Override
            public void onLikeClick(int position, int id, int type, ImageView imageView, TextView textView, String num) {
                new VideoPresenter(EachVideoFragment.this).like(getActivity(), id, type, imageView, textView, num);
            }
        });
        mAdapter.setOnRepostListener(new VideoRecyclerAdapter.OnRepostListener() {
            @Override
            public void onRepostClick(int position, int id, int type, TextView textView, String num) {
                repost_tv = textView;
                repost_num = num;
                new VideoPresenter(EachVideoFragment.this).share(getActivity(), id, type);
            }
        });
        return view;
    }

    public void showLike(Boolean flag, ImageView imageView, TextView textView, String num) {
        if (flag) {
            imageView.setImageResource(R.mipmap.pinlun_selected_dianzan);
            textView.setText("" + (Integer.parseInt(num) + 1));
        }
    }

    public void showShare(final ArrayList<ShareResult.ContentBean> list) {
        UMImage thumb = new UMImage(getActivity(),list.get(0).getImgUrl());
        UMWeb web = new UMWeb(list.get(0).getSiteUrl());
        web.setTitle(list.get(0).getTitle());//标题
         web.setThumb(thumb);  //缩略图
        web.setDescription(list.get(0).getText());//描述
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE).
                withText("hello").withMedia(web)
                .setCallback(umShareListener)
                .open();
    }

    public void showVideoList(ArrayList<VideoListResult.ContentBean> list, int page, int index) {
        mProgressDialog.dismiss();
        if (index == 1) {
            mAdapter.refresh(list, getActivity());
            recyclerView.setAdapter(mAdapter);
            loadPage=2;
        }
        if (list != null & index == 2) {
            loadPage = page;
            mAdapter.addDatas(list, getActivity());
        }
    }

    class CompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
                Toast.makeText(context, "下载完成", Toast.LENGTH_LONG).show();
            }else{
                ToastUtils.showToast(context,"下载失败");
            }
        }
    }
        private UMShareListener umShareListener = new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA platform) {
                //分享开始的回调
            }

            @Override
            public void onResult(SHARE_MEDIA platform) {
                repost_tv.setText("" + (Integer.parseInt(repost_num) + 1));
                Toast.makeText(getActivity(), "分享成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
                Toast.makeText(getActivity(),"分享失败啦", Toast.LENGTH_SHORT).show();
                if (t != null) {
                    ToastUtils.showToast(getActivity(),t.getMessage());
                }
            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {

            }
        };



        //ProgressDialog模拟网络请求
        public void loading() {
            Log.e("msg", "jinlaile");
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(completeReceiver);
    }

}