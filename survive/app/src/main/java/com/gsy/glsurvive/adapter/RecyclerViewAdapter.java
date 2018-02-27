package com.gsy.glsurvive.adapter;

/**
 * Created by TR-AND2 on 2017/12/1.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gsy.glsurvive.R;

import java.util.ArrayList;

/**
 * Created by Zhang on 2017/3/1.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private ArrayList<String> list;
    private Context context;
    private LayoutInflater mInflater;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    public RecyclerViewAdapter(Context context,ArrayList<String> list){
        this.context=context;
        this.list=list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder  holder=new MyViewHolder( mInflater.inflate(R.layout.recylerview_item,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(View view) {
            super(view);
           textView = (TextView) view.findViewById(R.id.test);

        }
    }

//    @Override
//    public int getItemViewType(int position) {
//         if(mHeaderView == null) return TYPE_NORMAL;
//         if(position == 0) return TYPE_HEADER;
//        return TYPE_NORMAL;
//    }

    public interface onItemClickListener{
        public void onItemClick(View view,int position);
    }
    private onItemClickListener listener;
    public void setOnItemclickListener(onItemClickListener listener){
        this.listener=listener;

    }
}

