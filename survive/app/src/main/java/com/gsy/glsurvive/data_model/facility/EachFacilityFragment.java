package com.gsy.glsurvive.data_model.facility;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunAdapter;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunListResult;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunPresenter;
import com.gsy.glsurvive.firstpage_model.gun.gun_detail.GunDetailActivity;

import java.util.ArrayList;


/**
 * Created by TR-AND2 on 2017/12/1.
 */

public class EachFacilityFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private RecyclerView recyclerView;
    private View view;
    public FacilityAdapter mAdapter;
    private ProgressDialog mProgressDialog;
    private TextView gun_pointer,aim_glass,grip,clip,butt,gun_pointer_seleted,aim_glass_seleted,grip_seleted,clip_seleted,butt_seleted;
    private TextView head,bag,anti_gun,belt,clothes,head_seleted,bag_seleted,anti_gun_seleted,belt_seleted,clothes_seleted;
    public static EachFacilityFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        EachFacilityFragment pageFragment = new EachFacilityFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        mAdapter=new FacilityAdapter();
        loading();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mPage==1){
            view=inflater.inflate(R.layout.fragment_facility_component,container,false);
            gun_pointer= (TextView) view.findViewById(R.id.gun_pointer);
            aim_glass= (TextView) view.findViewById(R.id.aim_glass);
            grip= (TextView) view.findViewById(R.id.grip);
            clip= (TextView) view.findViewById(R.id.clip);
            butt= (TextView) view.findViewById(R.id.butt);
            gun_pointer_seleted= (TextView) view.findViewById(R.id.gun_pointer_seleted);
            aim_glass_seleted= (TextView) view.findViewById(R.id.aim_glass_seleted);
            grip_seleted= (TextView) view.findViewById(R.id.grip_seleted);
            clip_seleted= (TextView) view.findViewById(R.id.clip_seleted);
            butt_seleted= (TextView) view.findViewById(R.id.butt_seleted);
            recyclerView= (RecyclerView) view.findViewById(R.id.facility_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            new FacilityPresenter(EachFacilityFragment.this).componentList(getActivity());
        }
        if(mPage==2){
            view=inflater.inflate(R.layout.fragment_facility_armor,container,false);
            head= (TextView) view.findViewById(R.id.head);
            bag= (TextView) view.findViewById(R.id.bag);
            anti_gun= (TextView) view.findViewById(R.id.anti_gun);
            belt= (TextView) view.findViewById(R.id.belt);
            clothes= (TextView) view.findViewById(R.id.clothes);
            head_seleted= (TextView) view.findViewById(R.id.head_seleted);
            bag_seleted= (TextView) view.findViewById(R.id.bag_seleted);
            anti_gun_seleted= (TextView) view.findViewById(R.id.anti_gun_seleted);
            belt_seleted= (TextView) view.findViewById(R.id.belt_seleted);
            clothes_seleted= (TextView) view.findViewById(R.id.clothes_seleted);
            recyclerView= (RecyclerView) view.findViewById(R.id.facility_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            new FacilityPresenter(EachFacilityFragment.this).amorList(getActivity());
        }
        if(mPage==3){
            view=inflater.inflate(R.layout.fragment_facility_prop,container,false);
            recyclerView= (RecyclerView) view.findViewById(R.id.facility_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            new FacilityPresenter(EachFacilityFragment.this).propList(getActivity());
        }

        return view;
    }

    public void showComponentList(final FacilityResult.ContentBean.PeijianBean peijianBean){
        mProgressDialog.dismiss();
        final ArrayList<NewFacilityResult> list=new ArrayList<>();
        gun_pointer_seleted.setVisibility(View.VISIBLE);
        gun_pointer.setVisibility(View.INVISIBLE);
        for(int i=0;i<peijianBean.getQk().size();i++){
            NewFacilityResult newFacilityResult=new NewFacilityResult();
            newFacilityResult.setImg(peijianBean.getQk().get(i).getImgUrl());
            newFacilityResult.setName(peijianBean.getQk().get(i).getName());
            newFacilityResult.setContent(peijianBean.getQk().get(i).getText());
            list.add(newFacilityResult);

        }
        mAdapter.addgunPointer(list,getActivity());
        recyclerView.setAdapter(mAdapter);

        gun_pointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gun_pointer_seleted.setVisibility(View.VISIBLE);
                gun_pointer.setVisibility(View.INVISIBLE);
                aim_glass.setVisibility(View.VISIBLE);
                aim_glass_seleted.setVisibility(View.INVISIBLE);
                grip.setVisibility(View.VISIBLE);
                grip_seleted.setVisibility(View.INVISIBLE);
                clip.setVisibility(View.VISIBLE);
                clip_seleted.setVisibility(View.INVISIBLE);
                butt.setVisibility(View.VISIBLE);
                butt_seleted.setVisibility(View.INVISIBLE);
                list.clear();
                for(int i=0;i<peijianBean.getQk().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(peijianBean.getQk().get(i).getImgUrl());
                    newFacilityResult.setName(peijianBean.getQk().get(i).getName());
                    newFacilityResult.setContent(peijianBean.getQk().get(i).getText());
                    list.add(newFacilityResult);

                }
            mAdapter.addgunPointer(list,getActivity());
            recyclerView.setAdapter(mAdapter);
            }
        });
        aim_glass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gun_pointer_seleted.setVisibility(View.INVISIBLE);
                gun_pointer.setVisibility(View.VISIBLE);
                aim_glass.setVisibility(View.INVISIBLE);
                aim_glass_seleted.setVisibility(View.VISIBLE);
                grip.setVisibility(View.VISIBLE);
                grip_seleted.setVisibility(View.INVISIBLE);
                clip.setVisibility(View.VISIBLE);
                clip_seleted.setVisibility(View.INVISIBLE);
                butt.setVisibility(View.VISIBLE);
                butt_seleted.setVisibility(View.INVISIBLE);
                list.clear();
                for(int i=0;i<peijianBean.getMzj().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(peijianBean.getMzj().get(i).getImgUrl());
                    newFacilityResult.setName(peijianBean.getMzj().get(i).getName());
                    newFacilityResult.setContent(peijianBean.getMzj().get(i).getText());
                    list.add(newFacilityResult);

                }
                mAdapter.addgunPointer(list,getActivity());
                recyclerView.setAdapter(mAdapter);
            }
        });
        grip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                gun_pointer_seleted.setVisibility(View.INVISIBLE);
                gun_pointer.setVisibility(View.VISIBLE);
                aim_glass.setVisibility(View.VISIBLE);
                aim_glass_seleted.setVisibility(View.INVISIBLE);
                grip.setVisibility(View.INVISIBLE);
                grip_seleted.setVisibility(View.VISIBLE);
                clip.setVisibility(View.VISIBLE);
                clip_seleted.setVisibility(View.INVISIBLE);
                butt.setVisibility(View.VISIBLE);
                butt_seleted.setVisibility(View.INVISIBLE);
                for(int i=0;i<peijianBean.getWb().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(peijianBean.getWb().get(i).getImgUrl());
                    newFacilityResult.setName(peijianBean.getWb().get(i).getName());
                    newFacilityResult.setContent(peijianBean.getWb().get(i).getText());
                    list.add(newFacilityResult);

                }
                mAdapter.addgunPointer(list,getActivity());
                recyclerView.setAdapter(mAdapter);
            }
        });
        clip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                gun_pointer_seleted.setVisibility(View.INVISIBLE);
                gun_pointer.setVisibility(View.VISIBLE);
                aim_glass.setVisibility(View.VISIBLE);
                aim_glass_seleted.setVisibility(View.INVISIBLE);
                grip.setVisibility(View.VISIBLE);
                grip_seleted.setVisibility(View.INVISIBLE);
                clip.setVisibility(View.INVISIBLE);
                clip_seleted.setVisibility(View.VISIBLE);
                butt.setVisibility(View.VISIBLE);
                butt_seleted.setVisibility(View.INVISIBLE);
                for(int i=0;i<peijianBean.getDj().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(peijianBean.getDj().get(i).getImgUrl());
                    newFacilityResult.setName(peijianBean.getDj().get(i).getName());
                    newFacilityResult.setContent(peijianBean.getDj().get(i).getText());
                    list.add(newFacilityResult);

                }
                mAdapter.addgunPointer(list,getActivity());
                recyclerView.setAdapter(mAdapter);
            }
        });
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                gun_pointer_seleted.setVisibility(View.INVISIBLE);
                gun_pointer.setVisibility(View.VISIBLE);
                aim_glass.setVisibility(View.VISIBLE);
                aim_glass_seleted.setVisibility(View.INVISIBLE);
                grip.setVisibility(View.VISIBLE);
                grip_seleted.setVisibility(View.INVISIBLE);
                clip.setVisibility(View.VISIBLE);
                clip_seleted.setVisibility(View.INVISIBLE);
                butt.setVisibility(View.INVISIBLE);
                butt_seleted.setVisibility(View.VISIBLE);
                for(int i=0;i<peijianBean.getQt().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(peijianBean.getQt().get(i).getImgUrl());
                    newFacilityResult.setName(peijianBean.getQt().get(i).getName());
                    newFacilityResult.setContent(peijianBean.getQt().get(i).getText());
                    list.add(newFacilityResult);

                }
                mAdapter.addgunPointer(list,getActivity());
                recyclerView.setAdapter(mAdapter);
            }
        });
    }

    public void showAmorList(final FacilityResult.ContentBean.FangjuBean fangjuBean){
        mProgressDialog.dismiss();
        final ArrayList<NewFacilityResult> list=new ArrayList<>();
        head_seleted.setVisibility(View.VISIBLE);
        head.setVisibility(View.INVISIBLE);
        for(int i=0;i<fangjuBean.getTbhj().size();i++){
            NewFacilityResult newFacilityResult=new NewFacilityResult();
            newFacilityResult.setImg(fangjuBean.getTbhj().get(i).getImgUrl());
            newFacilityResult.setName(fangjuBean.getTbhj().get(i).getName());
            newFacilityResult.setContent(fangjuBean.getTbhj().get(i).getText());
            list.add(newFacilityResult);

        }
        mAdapter.addgunPointer(list,getActivity());
        recyclerView.setAdapter(mAdapter);


        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                head_seleted.setVisibility(View.VISIBLE);
                head.setVisibility(View.INVISIBLE);
                bag.setVisibility(View.VISIBLE);
                bag_seleted.setVisibility(View.INVISIBLE);
                anti_gun.setVisibility(View.VISIBLE);
                anti_gun_seleted.setVisibility(View.INVISIBLE);
                belt.setVisibility(View.VISIBLE);
                belt_seleted.setVisibility(View.INVISIBLE);
                clothes.setVisibility(View.VISIBLE);
                clothes_seleted.setVisibility(View.INVISIBLE);
                list.clear();
                for(int i=0;i<fangjuBean.getBb().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(fangjuBean.getTbhj().get(i).getImgUrl());
                    newFacilityResult.setName(fangjuBean.getTbhj().get(i).getName());
                    newFacilityResult.setContent(fangjuBean.getTbhj().get(i).getText());
                    list.add(newFacilityResult);

                }
                mAdapter.addgunPointer(list,getActivity());
                recyclerView.setAdapter(mAdapter);
            }
        });
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                head_seleted.setVisibility(View.INVISIBLE);
                head.setVisibility(View.VISIBLE);
                bag.setVisibility(View.INVISIBLE);
                bag_seleted.setVisibility(View.VISIBLE);
                anti_gun.setVisibility(View.VISIBLE);
                anti_gun_seleted.setVisibility(View.INVISIBLE);
                belt.setVisibility(View.VISIBLE);
                belt_seleted.setVisibility(View.INVISIBLE);
                clothes.setVisibility(View.VISIBLE);
                clothes_seleted.setVisibility(View.INVISIBLE);
                list.clear();
                for(int i=0;i<fangjuBean.getBb().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(fangjuBean.getBb().get(i).getImgUrl());
                    newFacilityResult.setName(fangjuBean.getBb().get(i).getName());
                    newFacilityResult.setContent(fangjuBean.getBb().get(i).getText());
                    list.add(newFacilityResult);

                }
                mAdapter.addgunPointer(list,getActivity());
                recyclerView.setAdapter(mAdapter);
            }
        });
        anti_gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                head_seleted.setVisibility(View.INVISIBLE);
                head.setVisibility(View.VISIBLE);
                bag.setVisibility(View.VISIBLE);
                bag_seleted.setVisibility(View.INVISIBLE);
                anti_gun.setVisibility(View.INVISIBLE);
                anti_gun_seleted.setVisibility(View.VISIBLE);
                belt.setVisibility(View.VISIBLE);
                belt_seleted.setVisibility(View.INVISIBLE);
                clothes.setVisibility(View.VISIBLE);
                clothes_seleted.setVisibility(View.INVISIBLE);
                for(int i=0;i<fangjuBean.getFdbx().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(fangjuBean.getFdbx().get(i).getImgUrl());
                    newFacilityResult.setName(fangjuBean.getFdbx().get(i).getName());
                    newFacilityResult.setContent(fangjuBean.getFdbx().get(i).getText());
                    list.add(newFacilityResult);

                }
                mAdapter.addgunPointer(list,getActivity());
                recyclerView.setAdapter(mAdapter);
            }
        });
        belt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                head_seleted.setVisibility(View.INVISIBLE);
                head.setVisibility(View.VISIBLE);
                bag.setVisibility(View.VISIBLE);
                bag_seleted.setVisibility(View.INVISIBLE);
                anti_gun.setVisibility(View.VISIBLE);
                anti_gun_seleted.setVisibility(View.INVISIBLE);
                belt.setVisibility(View.INVISIBLE);
                belt_seleted.setVisibility(View.VISIBLE);
                clothes.setVisibility(View.VISIBLE);
                clothes_seleted.setVisibility(View.INVISIBLE);
                for(int i=0;i<fangjuBean.getPd().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(fangjuBean.getPd().get(i).getImgUrl());
                    newFacilityResult.setName(fangjuBean.getPd().get(i).getName());
                    newFacilityResult.setContent(fangjuBean.getPd().get(i).getText());
                    list.add(newFacilityResult);

                }
                mAdapter.addgunPointer(list,getActivity());
                recyclerView.setAdapter(mAdapter);
            }
        });
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                head_seleted.setVisibility(View.INVISIBLE);
                head.setVisibility(View.VISIBLE);
                bag.setVisibility(View.VISIBLE);
                bag_seleted.setVisibility(View.INVISIBLE);
                anti_gun.setVisibility(View.VISIBLE);
                anti_gun_seleted.setVisibility(View.INVISIBLE);
                belt.setVisibility(View.VISIBLE);
                belt_seleted.setVisibility(View.INVISIBLE);
                clothes.setVisibility(View.INVISIBLE);
                clothes_seleted.setVisibility(View.VISIBLE);
                for(int i=0;i<fangjuBean.getWy().size();i++){
                    NewFacilityResult newFacilityResult=new NewFacilityResult();
                    newFacilityResult.setImg(fangjuBean.getWy().get(i).getImgUrl());
                    newFacilityResult.setName(fangjuBean.getWy().get(i).getName());
                    newFacilityResult.setContent(fangjuBean.getWy().get(i).getText());
                    list.add(newFacilityResult);

                }
                mAdapter.addgunPointer(list,getActivity());
                recyclerView.setAdapter(mAdapter);
            }
        });
    }

    public void showPropList(ArrayList<FacilityResult.ContentBean.DaojuBean> daojuBeen){
        mProgressDialog.dismiss();
        final ArrayList<NewFacilityResult> list=new ArrayList<>();
        for(int i=0;i<daojuBeen.size();i++){
            NewFacilityResult newFacilityResult=new NewFacilityResult();
            newFacilityResult.setImg(daojuBeen.get(i).getImgUrl());
            newFacilityResult.setName(daojuBeen.get(i).getName());
            newFacilityResult.setContent(daojuBeen.get(i).getText());
            list.add(newFacilityResult);
        }
        mAdapter.addgunPointer(list,getActivity());
        recyclerView.setAdapter(mAdapter);

    }
    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(getActivity(), R.style.CustomProgressDialog);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
        mProgressDialog.setContentView(R.layout.loading_dialog);
        mProgressDialog.setOnKeyListener(onKeyListener);
    }
    //判断mProgressDialog的消失条件
    private DialogInterface.OnKeyListener onKeyListener = new DialogInterface.OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                mProgressDialog.dismiss();
            }
            return false;
        }
    };
}
