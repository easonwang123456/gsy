//package com.example.tr_and2.guide.view;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.graphics.drawable.BitmapDrawable;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ListView;
//import android.widget.PopupWindow;
//import android.widget.TextView;
//
//import com.example.tr_and2.guide.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by TR-AND2 on 2017/12/27.
// */
//
//public class CustomWin {
//    private Context context;
//    private View view;
//    private ListView listView;
//    private List<String> list;
//
//    public CustomWin(Context context) {
//        this(context, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//    }
//
//    public CustomWin(Context context, int with, int height) {
//        this.context = context;
//
//        view = LayoutInflater.from(context).inflate(R.layout.popwin_menu,null);
//        PopupWindow popupWindow=new PopupWindow(view,200,300);
//        popupWindow.setWidth(with);
//        popupWindow.setHeight(height);
//        //设置可以获得焦点
//        popupWindow.setFocusable(true);
//        //设置弹窗内可点击
//        popupWindow.setTouchable(true);
//        //设置弹窗外可点击
//        popupWindow.setOutsideTouchable(true);
//        popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        popupWindow.setContentView(view);
//        //setAnimationStyle(R.style.popwin_anim_style);
//        initData();
//    }
//
//    private void initData() {
//        listView = (ListView) view.findViewById(R.id.title_list);
//        list = new ArrayList<String>();
//        list.add("添加好友");
//        list.add("扫一扫");
//        list.add("支付宝");
//        list.add("视频聊天");
//        //设置列表的适配器
//        listView.setAdapter(new BaseAdapter() {
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                TextView textView = null;
//
//                if (convertView == null) {
//                    textView = new TextView(context);
//                    textView.setTextColor(Color.rgb(255,255,255));
//                    textView.setTextSize(14);
//                    //设置文本居中
//                    textView.setGravity(Gravity.CENTER);
//                    //设置文本域的范围
//                    textView.setPadding(0, 13, 0, 13);
//                    //设置文本在一行内显示（不换行）
//                    textView.setSingleLine(true);
//                } else {
//                    textView = (TextView) convertView;
//                }
//                //设置文本文字
//                textView.setText(list.get(position));
//                //设置文字与图标的间隔
////                textView.setCompoundDrawablePadding(0);
////                //设置在文字的左边放一个图标
////                textView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap., null, null, null);
//
//                return textView;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return list.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return list.size();
//            }
//        });
//    }
//}