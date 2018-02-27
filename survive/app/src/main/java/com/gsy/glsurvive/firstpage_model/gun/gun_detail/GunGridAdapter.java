package com.gsy.glsurvive.firstpage_model.gun.gun_detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.strategy_model.battle.BattleResult;
import com.gsy.glsurvive.utils.DisplayUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GunGridAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<GunDetailResult.ContentBean.PeijianBean> list;

	public GunGridAdapter(Context context, ArrayList<GunDetailResult.ContentBean.PeijianBean> list) {
		super();
		this.context = context;
		this.list = list;
	}
	class ViewHolder{
		TextView tv;
		ImageView img;
	}
	public void updateAdapter(ArrayList<GunDetailResult.ContentBean.PeijianBean> list){
		this.list=list;
		notifyDataSetChanged();
	}

	public ArrayList<GunDetailResult.ContentBean.PeijianBean> getList() {
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
			convertView=LayoutInflater.from(context).inflate(R.layout.component_item, null);
			holder.img= (ImageView) convertView.findViewById(R.id.component_img);
			holder.tv= (TextView) convertView.findViewById(R.id.component_name);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}

		Picasso.with(context).load(list.get(position).getImgUrl()).into(holder.img);
		holder.tv.setText(list.get(position).getName());
		GridView.LayoutParams param = new GridView.LayoutParams((DisplayUtils.getScreenWidthPixels(context)-DisplayUtils.dp2px(context,1))/3,(DisplayUtils.getScreenHeightPixels(context)-DisplayUtils.dp2px(context,1))/6);
		convertView.setLayoutParams(param);
		return convertView;

	}

}




