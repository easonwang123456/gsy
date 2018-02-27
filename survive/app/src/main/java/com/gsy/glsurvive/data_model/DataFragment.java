package com.gsy.glsurvive.data_model;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseFragment;
import com.gsy.glsurvive.data_model.facility.FacilityActivity;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunActivity;
import com.gsy.glsurvive.firstpage_model.map.FirstMapActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;

/**
 * Created by TR-AND2 on 2017/12/21.
 */

public class DataFragment extends BaseFragment {
    private View view;
    private LinearLayout click,net,map,gun,goods,carry;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_data,container,false);
        click= (LinearLayout) view.findViewById(R.id.click);
        net= (LinearLayout) view.findViewById(R.id.net);
        map= (LinearLayout) view.findViewById(R.id.data_map);
        gun= (LinearLayout) view.findViewById(R.id.data_gun);
        goods= (LinearLayout) view.findViewById(R.id.data_goods);
        //carry= (LinearLayout) view.findViewById(R.id.carry);
//        carry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getActivity(),CarryListActivity.class);
//                startActivity(intent);
//            }
//        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),H5UrlActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });
        net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),H5UrlActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FirstMapActivity.class);
//                intent.putExtra("type",3);
                startActivity(intent);
            }
        });
        gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FirstGunActivity.class);
               // intent.putExtra("type",4);
                startActivity(intent);
            }
        });
        goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FacilityActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void logic() {
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(getActivity(),null);
    }

    @Override
    public void httpRequest() {

    }
}
