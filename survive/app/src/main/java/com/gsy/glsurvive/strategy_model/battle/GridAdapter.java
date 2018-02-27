package com.gsy.glsurvive.strategy_model.battle;

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
	private ArrayList<BattleResult.ContentBean> list;

	public GridAdapter(Context context, ArrayList<BattleResult.ContentBean> list) {
		super();
		this.context = context;
		this.list = list;
	}
	class ViewHolder{
		TextView tv;
		ImageView img;
	}
	public void updateAdapter(ArrayList<BattleResult.ContentBean> list){
		this.list=list;
		notifyDataSetChanged();
	}

	public ArrayList<BattleResult.ContentBean> getList() {
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
			convertView=LayoutInflater.from(context).inflate(R.layout.grid_item, null);
			holder.img= (ImageView) convertView.findViewById(R.id.battle_img);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}

		Picasso.with(context).load(list.get(position).getImgUrl()).into(holder.img);
		GridView.LayoutParams param = new GridView.LayoutParams((DisplayUtils.getScreenWidthPixels(context)-DisplayUtils.dp2px(context,15))/2,(DisplayUtils.getScreenHeightPixels(context)-DisplayUtils.dp2px(context,25))/4);
		convertView.setLayoutParams(param);
		return convertView;

	}

}




