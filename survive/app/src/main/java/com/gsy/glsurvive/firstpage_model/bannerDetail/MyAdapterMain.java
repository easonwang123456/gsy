//package com.example.tr_and2.guide.firstpage_model.bannerDetail;
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.administrator.nba.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
///**
// * Created by Zhang on 2017/3/1.
// */
//
//import android.widget.BaseAdapter;
//import android.widget.CheckBox;
//
//public class MyAdapterMain extends BaseAdapter {
//	private Context context;
//	private ArrayList<CommentListResult.ContentBean> list;
//
//	class ViewHolder{
//		TextView tv1;
//		TextView tv2;
//		TextView tv3;
//		ImageView iv;
//		CheckBox checkBox;
//
//	}
//	public void updateAdapter(ArrayList<CommentListResult.ContentBean> list){
//		this.list=list;
//		notifyDataSetChanged();
//	}
//
//	public ArrayList<CommentListResult.ContentBean> getList() {
//		return list;
//	}
//
//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		return list.size();
//	}
//
//	@Override
//	public Object getItem(int arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public long getItemId(int arg0) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public View getView(final int position, View convertView, ViewGroup arg2) {
//		ViewHolder holder;
//		if(convertView==null){
//			holder=new ViewHolder();
//			convertView=LayoutInflater.from(context).inflate(R.layout.collect_item1, null);
//			holder.tv1=(TextView) convertView.findViewById(R.id.title11);
//			holder.tv2=(TextView) convertView.findViewById(R.id.author_name11);
//			holder.tv3= (TextView) convertView.findViewById(R.id.time11);
//			holder.iv= (ImageView) convertView.findViewById(R.id.iVpicture);
//			//holder.checkBox= (CheckBox) convertView.findViewById(R.id.checkBox);
//			convertView.setTag(holder);
//		}else{
//			holder=(ViewHolder) convertView.getTag();
//		}
////		holder.checkBox.setOnClickListener(new View.OnClickListener(){
////			@Override
////			public void onClick(View v) {
//////				list.get(position).setCheck(!list.get(position).isCheck());
////			}
////		});
//		holder.tv1.setText(list.get(position).getTitle());
//		holder.tv2.setText(list.get(position).getAuthorname());
//		holder.tv3.setText(list.get(position).getTime());
//		Picasso.with(context).load(list.get(position).getPicture()).resize(100,80).placeholder(R.drawable.aio_image_default)
//				.error(R.drawable.aio_image_fail).into(holder.iv );
//		//holder.checkBox.setChecked(list.get(position).isCheck());
//
//		return convertView;
//
//	}
//
//}
//
//
//
//
