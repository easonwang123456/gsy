package com.gsy.glsurvive.data_model;

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

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private ArrayList<CarryListResult.ContentBean> mDatas = new ArrayList<>();

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

    public void addDatas(ArrayList<CarryListResult.ContentBean> mDatas,Context context) {
        this.context=context;
        this.mDatas=mDatas;
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
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.carry_recycler_item, parent, false);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(viewHolder);
        if(viewHolder instanceof Holder) {
            ((Holder) viewHolder).carry_title.setText(mDatas.get(pos).getName());
            ((Holder) viewHolder).carry_description.setText(mDatas.get(pos).getText());
             Picasso.with(context).load(mDatas.get(pos).getBjUrl()).into(((Holder) viewHolder).carry_background);
             Picasso.with(context).load(mDatas.get(pos).getImgUrl()).into(((Holder) viewHolder).carry_img);

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
        ImageView carry_background,carry_img;
        TextView carry_title,carry_description;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            carry_background= (ImageView) itemView.findViewById(R.id.carry_background);
            carry_img= (ImageView) itemView.findViewById(R.id.carry_img);
            carry_title = (TextView) itemView.findViewById(R.id.carry_title_tv);
            carry_description = (TextView) itemView.findViewById(R.id.description_tv);


        }
    }

    interface OnItemClickListener {
        void onItemClick(int position, int id, int type);
    }
}