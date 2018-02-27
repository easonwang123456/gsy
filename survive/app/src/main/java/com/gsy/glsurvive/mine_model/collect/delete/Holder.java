package com.gsy.glsurvive.mine_model.collect.delete;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;

/**
 * Created by TR-AND2 on 2018/1/4.
 */

public class Holder extends RecyclerView.ViewHolder {
    ImageView img,mark_iv;
    TextView title,time,see,comment,mark_tv,delete;
    LinearLayout item_layout;


    public Holder(View itemView) {
        super(itemView);
        img= (ImageView) itemView.findViewById(R.id.recycler_img);
        title = (TextView) itemView.findViewById(R.id.recycler_title);
        time = (TextView) itemView.findViewById(R.id.recycler_time);
        see = (TextView) itemView.findViewById(R.id.recycler_see);
        comment = (TextView) itemView.findViewById(R.id.recycler_comment);
        mark_iv= (ImageView) itemView.findViewById(R.id.mark_iv);
        mark_tv= (TextView) itemView.findViewById(R.id.mark_tv);
        item_layout= (LinearLayout) itemView.findViewById(R.id.item_layout);
      //  delete= (TextView) itemView.findViewById(R.id.collect_delete);

    }
}