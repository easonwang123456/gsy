package com.gsy.glsurvive.data_model.facility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunListResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by TR-AND2 on 2017/12/4.
 */

public class FacilityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private ArrayList<NewFacilityResult> mDatas = new ArrayList<>();
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

    public void addgunPointer(ArrayList<NewFacilityResult> datas, Context context) {
        this.context=context;
        mDatas=datas;
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
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.facility_recycler_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(viewHolder);
        if(viewHolder instanceof Holder) {
              Picasso.with(context).load(mDatas.get(pos).getImg()).into(((Holder) viewHolder).facility_img);
            ((Holder) viewHolder).component_name.setText(mDatas.get(pos).getName());
             ((Holder) viewHolder).content.setText(mDatas.get(pos).getContent());

//            ((Holder) viewHolder).gun_name.setText(mDatas.get(pos).getName());
//            ((Holder) viewHolder).power_num.setText(""+mDatas.get(pos).getWqwl());
//            ((Holder) viewHolder).range_num.setText(""+mDatas.get(pos).getWqsc());
//            ((Holder) viewHolder).stable_num.setText(""+mDatas.get(pos).getWqwd());
//            ((Holder) viewHolder).speed_num.setText(""+mDatas.get(pos).getWqss());
//            ((Holder) viewHolder).power_bar.setProgress(Integer.parseInt(mDatas.get(pos).getWqwl()));
//            ((Holder) viewHolder).range_bar.setProgress(Integer.parseInt(mDatas.get(pos).getWqsc()));
//            ((Holder) viewHolder).stable_bar.setProgress(Integer.parseInt(mDatas.get(pos).getWqwd()));
//            ((Holder) viewHolder).speed_bar.setProgress(Integer.parseInt(mDatas.get(pos).getWqss()));
//            if(mDatas.get(pos).getImgUrl().equals("")){
//                Picasso.with(context).load(R.mipmap.wuwang).transform(new RoundedCornersTransformation(15, 1)).into(((Holder) viewHolder).img);
//            }else{
//                Picasso.with(context).load(mDatas.get(pos).getImgUrl()).transform(new RoundedCornersTransformation(15, 1)).into(((Holder) viewHolder).img);
//            }
//
//            if(mListener == null) return;
//            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
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

    class Holder extends RecyclerView.ViewHolder {
        ImageView facility_img;
        TextView component_name,content;


        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            facility_img= (ImageView) itemView.findViewById(R.id.facility_img);
            component_name= (TextView) itemView.findViewById(R.id.component_name);
            content = (TextView) itemView.findViewById(R.id.content);


        }
    }

    interface OnItemClickListener {
        void onItemClick(int position, int id, int type);
    }
}