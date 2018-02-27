//package com.example.tr_and2.guide.firstpage_model.bannerDetail;
//
///**
// * Created by TR-AND2 on 2017/12/28.
// */
//
//import android.content.Context;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.tr_and2.guide.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class VideoCommentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//    private static final int HEAD_TYPE=00001;
//    private static final int BODY_TYPE=00002;
//    private static final int FOOT_TYPE=00003;
//    private int headCount=1;//头部个数，后续可以自己拓展
//    private int footCount=1;//尾部个数，后续可以自己拓展
//    private LayoutInflater mLayoutInflater;
//    private List<String>listData=new ArrayList<>();
//    public VideoCommentListAdapter(Context context,List<String>listData) {
//        //this.context=context;
//        mLayoutInflater=LayoutInflater.from(context);
//        this.listData=listData;
//    }
//    private int getBodySize() {
//        return listData.size();
//    }
//    private boolean isHead(int position) {
//        return headCount!=0&&position<headCount;
//    }
//    private boolean isFoot(int position) {
//        return footCount!=0&&(position>=(getBodySize()+headCount));
//    }
//    @Override
//    public int getItemViewType(int position) {
//        if (isHead(position)) {
//            return HEAD_TYPE;
//        }else if (isFoot(position)) {
//            return FOOT_TYPE;
//        }else {
//            return BODY_TYPE;
//        }
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        switch (viewType) {
//            case HEAD_TYPE:
//                return new HeadViewHolder(mLayoutInflater.inflate(R.layout.test_header,parent,false));
//            case BODY_TYPE:
//                return new BodyViewHolder(mLayoutInflater.inflate(R.layout.recycler_item,parent,false));
//            case FOOT_TYPE:
//                return new FootViewHolder(mLayoutInflater.inflate(R.layout.test_footer,parent,false));
//            default:
//                return null;
//        }
//
//
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof HeadViewHolder) {
//
//        }else if (holder instanceof BodyViewHolder) {
//          ((BodyViewHolder) holder).body.setText(listData.get(position-headCount));
//
//        }else if (holder instanceof FootViewHolder) {
//
//        }
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return headCount+getBodySize()+footCount;
//    }
//    private static class HeadViewHolder extends RecyclerView.ViewHolder{
//
//        public HeadViewHolder(View itemView) {
//            super(itemView);
//        }
//    }
//    private static class BodyViewHolder extends RecyclerView.ViewHolder{
//        TextView body;
//        public BodyViewHolder(View itemView) {
//            super(itemView);
//            body= (TextView) itemView.findViewById(R.id.recycler_title);
//        }
//    }
//    private static class FootViewHolder extends RecyclerView.ViewHolder {
//
//        public FootViewHolder(View itemView) {
//            super(itemView);
//        }
//    }
//}
