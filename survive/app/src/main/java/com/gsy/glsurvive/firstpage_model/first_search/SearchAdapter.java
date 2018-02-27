package com.gsy.glsurvive.firstpage_model.first_search;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.BaseAdapter;

import com.gsy.glsurvive.R;

public class SearchAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<FirstSearchResult.ContentBean> list;

	public SearchAdapter(Context context, ArrayList<FirstSearchResult.ContentBean> list) {
		super();
		this.context = context;
		this.list = list;
	}
	class ViewHolder{
		TextView tv1;
	}
	public void updateAdapter(ArrayList<FirstSearchResult.ContentBean> list){
		this.list=list;
		notifyDataSetChanged();
	}

	public ArrayList<FirstSearchResult.ContentBean> getList() {
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
			convertView=LayoutInflater.from(context).inflate(R.layout.search_list_item, null);
			holder.tv1=(TextView) convertView.findViewById(R.id.history_item);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
//		holder.checkBox.setOnClickListener(new View.OnClickListener(){
//			@Override
//			public void onClick(View v) {
////				list.get(position).setCheck(!list.get(position).isCheck());
//			}
//		});
		holder.tv1.setText(list.get(position).getName());


		return convertView;

	}

}




