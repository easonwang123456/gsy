package com.gsy.glsurvive.mine_model.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2017/12/4.
 */

public class LocalVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private List<LocalVideoBean> mDatas = new ArrayList<>();
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

    public void addDatas(List<LocalVideoBean> datas,Context context) {
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
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.local_video_item, parent, false);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(viewHolder);
        if(viewHolder instanceof Holder) {
            ((Holder) viewHolder).title.setText(mDatas.get(pos).getName());
            ((Holder) viewHolder).location.setText(mDatas.get(pos).getPath());
            ((Holder) viewHolder).img.setImageBitmap(mDatas.get(pos).getBitmap());
//            if(mDatas.get(pos).getImgUrl().equals("")){
//                Picasso.with(context).load(R.mipmap.wuwang).transform(new RoundedCornersTransformation(15, 1)).into(((Holder) viewHolder).img);
//            }else{
//                Picasso.with(context).load(mDatas.get(pos).getImgUrl()).transform(new RoundedCornersTransformation(15, 1)).into(((Holder) viewHolder).img);
//            }


            if(mListener == null) return;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   mListener.onItemClick(pos,mDatas.get(pos).getPath(),mDatas.get(pos).getName());
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
        TextView title,location;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            img= (ImageView) itemView.findViewById(R.id.bitmap_img);
            title = (TextView) itemView.findViewById(R.id.name);
            location= (TextView) itemView.findViewById(R.id.location);

        }
    }

    interface OnItemClickListener {
        void onItemClick(int position,String path,String title);
    }
}