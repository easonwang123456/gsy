package com.gsy.glsurvive.strategy_model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.utils.DisplayUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<EachStrategyResult.ContentBean.HotDataBean>  list =new ArrayList<>();

	public GridAdapter(Context context, ArrayList<EachStrategyResult.ContentBean.HotDataBean> list) {
		super();
		this.context = context;
		this.list = list;
	}
	class ViewHolder{
		TextView tv,see_num;
		ImageView img;

	}
	public void updateAdapter(ArrayList<EachStrategyResult.ContentBean.HotDataBean> list){
		this.list=list;
		notifyDataSetChanged();
	}

	public ArrayList<EachStrategyResult.ContentBean.HotDataBean> getList() {
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
		if(convertView==null){
			holder=new ViewHolder();
			convertView=LayoutInflater.from(context).inflate(R.layout.grid_hot_item, null);
			holder.img= (ImageView) convertView.findViewById(R.id.grid_hot_img);
			holder.tv= (TextView) convertView.findViewById(R.id.grid_hot_title);
			holder.see_num= (TextView) convertView.findViewById(R.id.see_num);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
        holder.tv.setText(list.get(position).getName());
		holder.see_num.setText(list.get(position).getHits());
		Picasso.with(context).load(list.get(position).getImgUrl()).into(holder.img);
		GridView.LayoutParams param = new GridView.LayoutParams((DisplayUtils.getScreenWidthPixels(context)-DisplayUtils.dp2px(context,15))/2,(DisplayUtils.getScreenHeightPixels(context)-DisplayUtils.dp2px(context,25))/4);
		convertView.setLayoutParams(param);
		return convertView;

	}

}




