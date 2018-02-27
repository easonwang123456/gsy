package com.gsy.glsurvive.firstpage_model.video.video_detail;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.emoj.EmojiUtil;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/4.
 */

public class VideoCommentRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private VideoReplyCommentAdapter videoReplyCommentAdapter;
    private ArrayList<VideoCommentResult.ContentBean> mDatas = new ArrayList<>();
    public View mHeaderView;
    private VideoListDetailActivity videoListDetailActivity;

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void addDatas(ArrayList<VideoCommentResult.ContentBean> datas,Context context,VideoListDetailActivity videoListDetailActivity) {
        this.context=context;
        this.videoListDetailActivity=videoListDetailActivity;
        this.mDatas.addAll(datas);
    }

    public void updateList(ArrayList<VideoCommentResult.ContentBean> datas,Context context){
        this.context=context;
        this.mDatas=datas;
        notifyDataSetChanged();
    }
    public void refresh(ArrayList<VideoCommentResult.ContentBean> datas, Context context,VideoListDetailActivity videoListDetailActivity) {
        this.context=context;
        this.videoListDetailActivity=videoListDetailActivity;
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
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_recycler_item, parent, false);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(viewHolder);
        if(viewHolder instanceof Holder) {
            videoReplyCommentAdapter=new VideoReplyCommentAdapter();
            if (mDatas.get(pos).getReply() != null && mDatas.get(pos).getReply().size() != 0) {
                ((Holder) viewHolder).recyclerView.setLayoutManager(new LinearLayoutManager(context));
                videoReplyCommentAdapter.addDatas(mDatas.get(pos).getReply(), context);
                ((Holder) viewHolder).recyclerView.setAdapter(videoReplyCommentAdapter);
                Log.e("msg","pos里面:"+pos);
                ((Holder) viewHolder).recyclerView.setVisibility(View.VISIBLE);
            }else{
                ((Holder) viewHolder).recyclerView.setVisibility(View.GONE);
            }
            ((Holder) viewHolder).name.setText(mDatas.get(pos).getNickName());
            ((Holder) viewHolder).time.setText(mDatas.get(pos).getTime());
            ((Holder) viewHolder).comment.setText(mDatas.get(pos).getText());
            ((Holder) viewHolder).num.setText(""+mDatas.get(pos).getAgreeNum());
            Picasso.with(context).load(mDatas.get(pos).getImgUrl()).placeholder(R.mipmap.zhanweitu).into(((Holder) viewHolder).img);
            if(mDatas.get(pos).isStatus()){
                ((Holder) viewHolder).like.setImageResource(R.mipmap.pinlun_selected_dianzan);
            }else{
                ((Holder) viewHolder).like.setImageResource(R.mipmap.pinlun_dianzan);
            }
        }
        try {
            EmojiUtil.handlerEmojiText(((Holder) viewHolder).comment,mDatas.get(pos).getText(),context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(mListener == null) return;

        ((Holder) viewHolder).more .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(pos, mDatas.get(pos).getCommentId(),1,mDatas.get(pos).getNickName(),((Holder) viewHolder).more);
            }
        });

        ((Holder) viewHolder).like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlikeListener.onLikeClick(pos,mDatas.get(pos).getCommentId(),1,((Holder) viewHolder).like,((Holder) viewHolder).num,mDatas.get(pos).getAgreeNum());
            }
        });

        //回复点赞
        videoReplyCommentAdapter.setOnItemClickListener(new VideoReplyCommentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id, ImageView imageView,TextView textView,String num) {
           new VideoDetailPresenter(videoListDetailActivity).commentReplyLike(context,id,imageView,textView,num);
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
        ImageView img,like,more;
        TextView name,time,num,comment;
        RecyclerView recyclerView;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            img= (ImageView) itemView.findViewById(R.id.comment_img);
            name = (TextView) itemView.findViewById(R.id.name_comment);
            time = (TextView) itemView.findViewById(R.id.comment_time);
            num = (TextView) itemView.findViewById(R.id.like_number_comment);
            more= (ImageView) itemView.findViewById(R.id.comment_more);
            like= (ImageView) itemView.findViewById(R.id.like_comment);
            comment = (TextView) itemView.findViewById(R.id.comment_tv);
            recyclerView= (RecyclerView) itemView.findViewById(R.id.reply_recycler);

        }

    }

    public OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }
    interface OnItemClickListener {
        void onItemClick(int position, int commentId, int type,String name,ImageView imageView);
    }


    public OnLikeClickListener mlikeListener;
    public void setOnLikeClickListener(OnLikeClickListener li) {
        mlikeListener = li;
    }
    interface OnLikeClickListener {
        void onLikeClick(int position, int commentId, int type,ImageView imageView,TextView textView,int num);
    }



}