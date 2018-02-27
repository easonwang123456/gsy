package com.gsy.glsurvive.firstpage_model.video.video_detail;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.R;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/10.
 */

public class VideoReplyListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<VideoCommentResult.ContentBean.ReplyBean> list =new ArrayList<>();
    class ViewHolder {
        TextView name;
        TextView time;
        ImageView like;
        TextView likeNum;
        TextView content;

    }

    public void addDatas(ArrayList<VideoCommentResult.ContentBean.ReplyBean> list,Context context) {
        this.context=context;
        this.list=list;
        Log.e("msg","listAdapter:"+this.list);

    }

    public ArrayList<VideoCommentResult.ContentBean.ReplyBean> getList() {
        return list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup arg2) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.reply_recycler_item, null);
            holder.likeNum= (TextView) convertView.findViewById(R.id.like_reply_tv);
            holder.time = (TextView) convertView.findViewById(R.id.reply_time);
            holder.like = (ImageView) convertView.findViewById(R.id.like_reply_iv);
            holder.content= (TextView) convertView.findViewById(R.id.reply_text);
            holder.name= (TextView) convertView.findViewById(R.id.reply_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getReplyNickName());
        holder.time.setText(list.get(position).getReplyTime());
        holder.like.setImageResource(R.mipmap.dianzan);
        //holder.likeNum.setText(list.get(position).getAgreeNum());
        holder.content.setText(list.get(position).getReplyText());
        return convertView;
    }
}
