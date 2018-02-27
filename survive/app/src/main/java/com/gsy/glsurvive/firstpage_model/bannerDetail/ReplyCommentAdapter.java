package com.gsy.glsurvive.firstpage_model.bannerDetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.emoj.EmojiUtil;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CommentListResult;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/4.
 */

public class ReplyCommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;


    private ArrayList<CommentListResult.ContentBean.ReplyBean> mDatas = new ArrayList<>();

    public View mHeaderView;

    public OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void addDatas(ArrayList<CommentListResult.ContentBean.ReplyBean> mDatas,Context context) {
        this.context=context;
        this.mDatas=mDatas;
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
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.reply_recycler_item, parent, false);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(viewHolder);
        if(viewHolder instanceof Holder) {
            ((Holder) viewHolder).name.setText(mDatas.get(pos).getReplyNickName());
            ((Holder) viewHolder).time.setText(mDatas.get(pos).getReplyTime());
            ((Holder) viewHolder).num.setText(mDatas.get(pos).getReplyAgreeNum());
            try {
                EmojiUtil.handlerEmojiText(((Holder) viewHolder).comment,mDatas.get(pos).getReplyText(),context);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(mDatas.get(pos).isReplyStatus()){
                ((Holder) viewHolder).like.setImageResource(R.mipmap.pinlun_selected_dianzan);
            }else{
                ((Holder) viewHolder).like.setImageResource(R.mipmap.pinlun_dianzan);
            }
            if(mListener == null) return;
            ((Holder) viewHolder).like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(pos, mDatas.get(pos).getReplyCommentId(),((Holder) viewHolder).like,((Holder) viewHolder).num,mDatas.get(pos).getReplyAgreeNum());
                }
            });
        }
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
        ImageView img,like;
        TextView name,time,num,comment;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            name = (TextView) itemView.findViewById(R.id.reply_name);
            time = (TextView) itemView.findViewById(R.id.reply_time);
            num = (TextView) itemView.findViewById(R.id.like_reply_tv);
            like= (ImageView) itemView.findViewById(R.id.like_reply_iv);
            comment = (TextView) itemView.findViewById(R.id.reply_text);

        }
    }

    interface OnItemClickListener {
        void onItemClick(int position, int id,ImageView imageView,TextView textView,String num);
    }
}