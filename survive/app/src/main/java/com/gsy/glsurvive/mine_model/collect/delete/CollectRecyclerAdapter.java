package com.gsy.glsurvive.mine_model.collect.delete;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.mine_model.collect.CollectListResult;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/4.
 */

public class CollectRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private ArrayList<CollectListResult.ContentBean> mDatas = new ArrayList<>();
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

    public void addDatas(ArrayList<CollectListResult.ContentBean> datas, Context context) {
        this.context=context;
        mDatas.addAll(datas);
        Log.e("msg","size:"+mDatas.size());
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
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_collect, parent, false);
        return new Holder(layout);
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
            // Picasso.with(context).load(mDatas.get(pos).getImgUrl()).transform(new RoundedCornersTransformation(15, 1)).into(((Holder) viewHolder).img);

            if(mListener == null) return;
//            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.e("msg","pos:"+pos);
//                    Log.e("msg","mdata:"+mDatas.size());
//                    mListener.onItemClick(pos, mDatas.get(pos).getId(),mDatas.get(pos).getType());
//                }
//            });
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

    public void removeItem(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }


}