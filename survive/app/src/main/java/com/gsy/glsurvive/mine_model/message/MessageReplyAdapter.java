package com.gsy.glsurvive.mine_model.message;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/4.
 */

public class MessageReplyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;

    private ArrayList<ReplyMessageResult.ContentBean> mDatas = new ArrayList<>();

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

    public void addDatas(ArrayList<ReplyMessageResult.ContentBean> datas,Context context) {
        this.context=context;
         mDatas.addAll(datas);
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
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_reply_recycler_item, parent, false);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(viewHolder);
        if(viewHolder instanceof Holder) {
            ((Holder) viewHolder).title.setText(mDatas.get(pos).getName());
            ((Holder) viewHolder).time.setText(mDatas.get(pos).getTime());
            ((Holder) viewHolder).nickName.setText(mDatas.get(pos).getReplyNickName());
            ((Holder) viewHolder).content.setText(mDatas.get(pos).getReplyText());
            ((Holder) viewHolder).nick_name.setText(mDatas.get(pos).getNickName()+":");
            ((Holder) viewHolder).comment_tv.setText(mDatas.get(pos).getText());
            Picasso.with(context).load(mDatas.get(pos).getReplyImgUrl()).into(((Holder) viewHolder).img);

            if(mListener == null) return;
            ((Holder) viewHolder).title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(pos, mDatas.get(pos).getId(),mDatas.get(pos).getType());
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
        ImageView img;
        TextView nickName,time,content,title,nick_name,comment_tv;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            img= (ImageView) itemView.findViewById(R.id.picture_img);
            nickName = (TextView) itemView.findViewById(R.id.nick_name_tv);
            time = (TextView) itemView.findViewById(R.id.time_tv);
            content = (TextView) itemView.findViewById(R.id.message_tv);
            title = (TextView) itemView.findViewById(R.id.title_tv);
            nick_name= (TextView) itemView.findViewById(R.id.nick_name);
            comment_tv= (TextView) itemView.findViewById(R.id.comment_tv);
        }
    }

    interface OnItemClickListener {
        void onItemClick(int position, int id, int type);
    }
}