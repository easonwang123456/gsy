package com.gsy.glsurvive.firstpage_model.video;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoCommentRecyclerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by TR-AND2 on 2017/12/4.
 */

public class VideoRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private ArrayList<VideoListResult.ContentBean> mDatas = new ArrayList<>();
    public View mHeaderView;
    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void addDatas(ArrayList<VideoListResult.ContentBean> datas,Context context) {
        this.context=context;
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
    public void refresh(ArrayList<VideoListResult.ContentBean> datas,Context context){
    this.context=context;
    this.mDatas=datas;
    notifyDataSetChanged();
}
    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) return new Holder(mHeaderView);
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_recycler_item, parent, false);
        jcVideoPlayerStandard= (JCVideoPlayerStandard)layout.findViewById(R.id.videoplayer);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(viewHolder);
        if(viewHolder instanceof Holder) {
            jcVideoPlayerStandard.setUp(mDatas.get(pos).getSource(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, mDatas.get(pos).getName());
            ((Holder) viewHolder).repost.setText(mDatas.get(pos).getHits());
            ((Holder) viewHolder).like.setText(mDatas.get(pos).getDingNum());
            ((Holder) viewHolder).comment.setText(mDatas.get(pos).getCommentNum());
            if(mDatas.get(pos).getImgUrl().isEmpty()){
                Picasso.with(context).load(R.mipmap.wuwang).into(jcVideoPlayerStandard.thumbImageView);
            }else {
                Picasso.with(context).load(mDatas.get(pos).getImgUrl()).into(jcVideoPlayerStandard.thumbImageView);
            }
            if(mDatas.get(pos).isStatus()){
                ((Holder) viewHolder).like_video_iv.setImageResource(R.mipmap.pinlun_selected_dianzan);
            }else{
                ((Holder) viewHolder).like_video_iv.setImageResource(R.mipmap.pinlun_dianzan);
            }
        }
        if(mListener == null) return;
        ((Holder) viewHolder).comment_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(pos, mDatas.get(pos).getId(),mDatas.get(pos).getType(),null);
            }
        });
        ((Holder) viewHolder).download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDownLoadClick(pos, mDatas.get(pos).getId(),mDatas.get(pos).getType(),mDatas.get(pos).getSource(),mDatas.get(pos).getName(),mDatas.get(pos).getImgUrl());
            }
        });
        ((Holder) viewHolder).volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeListener.onVolumeClick(pos,mDatas.get(pos).getId(),mDatas.get(pos).getType(),((Holder) viewHolder).volume);
            }
        });
        ((Holder) viewHolder).like_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeListener.onLikeClick(pos,mDatas.get(pos).getId(),mDatas.get(pos).getType(),((Holder) viewHolder).like_video_iv,((Holder) viewHolder).like,mDatas.get(pos).getDingNum());
            }
        });
        ((Holder) viewHolder).repost_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repostListener.onRepostClick(pos,mDatas.get(pos).getId(),mDatas.get(pos).getType(),((Holder) viewHolder).repost,mDatas.get(pos).getHits());
            }
        });

    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? mDatas.size() : mDatas.size() + 1;
    }

   class Holder extends RecyclerView.ViewHolder {
        TextView like,comment,repost,download;
        LinearLayout comment_detail,like_video,repost_video;
        ImageView volume,like_video_iv;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            like = (TextView) itemView.findViewById(R.id.like_video_tv);
            repost = (TextView) itemView.findViewById(R.id.repost_video_tv);
            comment = (TextView) itemView.findViewById(R.id.comment_video_tv);
            comment_detail= (LinearLayout) itemView.findViewById(R.id.comment_video);
            download= (TextView) itemView.findViewById(R.id.download);
            volume= (ImageView) itemView.findViewById(R.id.jc_volume);
            like_video_iv= (ImageView) itemView.findViewById(R.id.like_video_iv);
            like_video= (LinearLayout) itemView.findViewById(R.id.like_video);
            repost_video= (LinearLayout) itemView.findViewById(R.id.repost_video);

        }

    }


    public void autoPlayVideo(RecyclerView view,int visibleCount){

        for (int i = 0; i < visibleCount; i++) {
            if (view!=null&&view.getChildAt(i)!=null&&view.getChildAt(i).findViewById(R.id.videoplayer) != null) {
                JCVideoPlayerStandard videoPlayerStandard1 = (JCVideoPlayerStandard) view.getChildAt(i).findViewById(R.id.videoplayer);
                ImageView viewItem_Volume= (ImageView) view.getChildAt(i).findViewById(R.id.jc_volume);
                Rect rect = new Rect();
                videoPlayerStandard1.getLocalVisibleRect(rect);
                int videoheight= videoPlayerStandard1.getHeight();

           if (rect.top==0&&rect.bottom<=videoheight){
                    if (videoPlayerStandard1.currentState == JCVideoPlayer.CURRENT_STATE_NORMAL || videoPlayerStandard1.currentState == JCVideoPlayer.CURRENT_STATE_ERROR) {
                        videoPlayerStandard1.startButton.performClick();
                    }
                    return;
               }
            }
        }
        JCVideoPlayer.releaseAllVideos();
    }

    public OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public OnDownLoadClickListener listener;
    public void setOnDownLoadClickListener(OnDownLoadClickListener download) {listener = download;}

    private OnVolumeListener volumeListener;
    public void setOnVolumeListener(OnVolumeListener listener){
        volumeListener=listener;
    }

    private OnLikeListener likeListener;
    public void setOnLikeListener(OnLikeListener listener){
        likeListener=listener;
    }

    private OnRepostListener repostListener;
    public void setOnRepostListener(OnRepostListener listener){
        repostListener=listener;
    }

    interface OnItemClickListener {
        void onItemClick(int position, int id, int type,String source);
    }
    interface OnDownLoadClickListener {
        void onDownLoadClick(int position, int id, int type,String source,String title,String imgUrl);
    }
    interface OnVolumeListener {
        void onVolumeClick(int position, int id,int type,ImageView imageView);
    }
    interface OnLikeListener {
        void onLikeClick(int position, int id,int type,ImageView imageView,TextView textView,String num);
    }
    interface OnRepostListener {
        void onRepostClick(int position, int id,int type,TextView textView,String num);
    }

}