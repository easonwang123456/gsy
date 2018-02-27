//package com.gsy.glchicken.firstpage_model.video.video_detail;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.gsy.glchicken.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//
///**
// * Created by ethan on 2017/5/25.
// */
//public class VideoCommentListAdapter extends BaseAdapter {
//    private Context context;
//    private ArrayList<VideoCommentResult.ContentBean> list=new ArrayList<>();
//    private VideoReplyListAdapter videoReplyListAdapter;
//
//    class ViewHolder {
//        TextView title;
//        TextView time;
//        ImageView like;
//        TextView likeNum;
//        ImageView more;
//        TextView content;
//        ImageView imgUrl;
//        ListView listView;
//    }
//
//    public void addDatas(ArrayList<VideoCommentResult.ContentBean> list,Context context) {
//        this.context=context;
//        this.list.addAll(list);
//        notifyDataSetChanged();
//    }
//
//    public ArrayList<VideoCommentResult.ContentBean> getList() {
//        return list;
//    }
//
//    @Override
//    public int getCount() {
//        // TODO Auto-generated method stub
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int arg0) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public long getItemId(int arg0) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup arg2) {
//        ViewHolder holder;
//        if (convertView == null) {
//            holder = new ViewHolder();
//            convertView = LayoutInflater.from(context).inflate(R.layout.comment_recycler_item, null);
//            holder.title= (TextView) convertView.findViewById(R.id.name_comment);
//            holder.time = (TextView) convertView.findViewById(R.id.comment_time);
//            holder.like = (ImageView) convertView.findViewById(R.id.like_comment);
//            holder.likeNum= (TextView) convertView.findViewById(R.id.like_number);
//            holder.more= (ImageView) convertView.findViewById(R.id.comment_more);
//            holder.content= (TextView) convertView.findViewById(R.id.comment_tv);
//            holder.imgUrl= (ImageView) convertView.findViewById(R.id.comment_img);
//           // holder.listView= (ListView) convertView.findViewById(R.id.reply_recycler);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        if (list.get(position).getReply() != null && list.get(position).getReply().size() != 0) {
//            videoReplyListAdapter=new VideoReplyListAdapter();
//            videoReplyListAdapter.addDatas(list.get(position).getReply(), context);
//           // holder.listView.setAdapter(videoReplyListAdapter);
//           // holder.listView.setVisibility(View.VISIBLE);
//        }else{
//          //  holder.listView.setVisibility(View.GONE);
//        }
//
//
//        holder.title.setText(list.get(position).getNickName());
//        holder.time.setText(list.get(position).getTime());
//        holder.like.setImageResource(R.mipmap.dianzan);
//       // holder.likeNum.setText(list.get(position).getAgreeNum());
//        holder.content.setText(list.get(position).getText());
//        Picasso.with(context).load(list.get(position).getImgUrl());
//        return convertView;
//    }
//
//}
