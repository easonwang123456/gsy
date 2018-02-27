package com.gsy.glsurvive.firstpage_model.gun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by TR-AND2 on 2017/12/4.
 */

public class FirstGunAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private ArrayList<FirstGunListResult.ContentBean> mDatas = new ArrayList<>();
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

    public void addDatas(ArrayList<FirstGunListResult.ContentBean> datas, Context context) {
        this.context=context;
        mDatas.addAll(datas);

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
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gun_recycler_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(viewHolder);
        if(viewHolder instanceof Holder) {
            ((Holder) viewHolder).gun_name.setText(mDatas.get(pos).getName());
            ((Holder) viewHolder).power_num.setText(""+mDatas.get(pos).getWqwl());
            ((Holder) viewHolder).range_num.setText(""+mDatas.get(pos).getWqsc());
            ((Holder) viewHolder).stable_num.setText(""+mDatas.get(pos).getWqwd());
            ((Holder) viewHolder).speed_num.setText(""+mDatas.get(pos).getWqss());
            ((Holder) viewHolder).power_bar.setProgress(Integer.parseInt(mDatas.get(pos).getWqwl()));
            ((Holder) viewHolder).range_bar.setProgress(Integer.parseInt(mDatas.get(pos).getWqsc()));
            ((Holder) viewHolder).stable_bar.setProgress(Integer.parseInt(mDatas.get(pos).getWqwd()));
            ((Holder) viewHolder).speed_bar.setProgress(Integer.parseInt(mDatas.get(pos).getWqss()));
            if(mDatas.get(pos).getImgUrl().equals("")){
                Picasso.with(context).load(R.mipmap.wuwang).transform(new RoundedCornersTransformation(15, 1)).into(((Holder) viewHolder).img);
            }else{
                Picasso.with(context).load(mDatas.get(pos).getImgUrl()).transform(new RoundedCornersTransformation(15, 1)).into(((Holder) viewHolder).img);
            }

            if(mListener == null) return;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
        TextView power_num,range_num,stable_num,speed_num,gun_name;
        ProgressBar power_bar,range_bar,stable_bar,speed_bar;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            img= (ImageView) itemView.findViewById(R.id.recycler_img);
            gun_name= (TextView) itemView.findViewById(R.id.gun_name);
            power_num = (TextView) itemView.findViewById(R.id.power_num);
            range_num = (TextView) itemView.findViewById(R.id.range_num);
            stable_num = (TextView) itemView.findViewById(R.id.stable_num);
            speed_num = (TextView) itemView.findViewById(R.id.speed_num);
            power_bar= (ProgressBar) itemView.findViewById(R.id.power_bar);
            range_bar= (ProgressBar) itemView.findViewById(R.id.range_bar);
            stable_bar= (ProgressBar) itemView.findViewById(R.id.stable_bar);
            speed_bar= (ProgressBar) itemView.findViewById(R.id.speed_bar);

        }
    }

    interface OnItemClickListener {
        void onItemClick(int position, int id, int type);
    }
}