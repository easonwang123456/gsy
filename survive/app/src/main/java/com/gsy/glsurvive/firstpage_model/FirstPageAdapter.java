package com.gsy.glsurvive.firstpage_model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.utils.LogUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by TR-AND2 on 2017/12/4.
 */

public class FirstPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> mDatas = new ArrayList<>();
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

    public void addDatas(ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> datas,Context context) {
        this.context=context;
        mDatas.addAll(datas);
        LogUtil.e("msg","addDatas:"+datas);


    }
    public void refresh(ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> datas,Context context) {
        this.context=context;
        mDatas=datas;
        notifyDataSetChanged();
        Log.e("msg","sizee:"+datas.size());
        LogUtil.e("msg","refresh:"+datas);

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
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(viewHolder);
        if(viewHolder instanceof Holder) {
            ((Holder) viewHolder).title.setText(mDatas.get(pos).getName());
            ((Holder) viewHolder).time.setText(mDatas.get(pos).getTime());
            ((Holder) viewHolder).see.setText(mDatas.get(pos).getHits());
            ((Holder) viewHolder).comment.setText(mDatas.get(pos).getCommentNum());
            if(mDatas.get(pos).getImgUrl().equals("")){
                Log.e("msg","namesahc:"+mDatas.get(pos).getName());
                Picasso.with(context).load(R.mipmap.wuwang).transform(new RoundedCornersTransformation(15, 1)).into(((Holder) viewHolder).img);
            }else{
                Picasso.with(context).load(mDatas.get(pos).getImgUrl()).transform(new RoundedCornersTransformation(15, 1)).into(((Holder) viewHolder).img);
            }
            if(mDatas.get(pos).getDataType()==1 ){
                ((Holder) viewHolder).mark_iv.setImageResource(R.drawable.tuijian);
                ((Holder) viewHolder).mark_iv.setVisibility(View.VISIBLE);
            }else if(mDatas.get(pos).getDataType()==2 ){
                ((Holder) viewHolder).mark_iv.setImageResource(R.drawable.top);
                ((Holder) viewHolder).mark_iv.setVisibility(View.VISIBLE);
            }else{
                ((Holder) viewHolder).mark_iv.setVisibility(View.GONE);
            }

            if(mListener == null) return;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(pos, mDatas.get(pos).getId(),mDatas.get(pos).getType(),mDatas);

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
        ImageView img,mark_iv;
        TextView title,time,see,comment,mark_tv;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            img= (ImageView) itemView.findViewById(R.id.recycler_img);
            title = (TextView) itemView.findViewById(R.id.recycler_title);
            time = (TextView) itemView.findViewById(R.id.recycler_time);
            see = (TextView) itemView.findViewById(R.id.recycler_see);
            comment = (TextView) itemView.findViewById(R.id.recycler_comment);
            mark_iv= (ImageView) itemView.findViewById(R.id.mark_iv);
            mark_tv= (TextView) itemView.findViewById(R.id.mark_tv);

        }
    }

    interface OnItemClickListener {
        void onItemClick(int position, int id,int type,ArrayList<FirstPageRecommandResult.ContentBean.PostDataBean> list);
    }
}