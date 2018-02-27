package com.gsy.glsurvive.firstpage_model.first_search;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.firstpage_model.bannerDetail.BannerDetailActivity;
import com.gsy.glsurvive.sqlite.DB_C;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.utils.ToastUtils;
import com.gsy.glsurvive.view.Tag;
import com.gsy.glsurvive.view.TagListView;
import com.gsy.glsurvive.view.TagView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class FirstSearchActivity extends BaseActivity implements FirstSearchView {
    private EditText search_et;
    private TextView search_tv,delete_all,search_Tv;
    private RecyclerView recyclerView;
    private FirstSearchAdapter firstSearchAdapter;
    private SearchAdapter searchAdapter;
    private Boolean flag=false;
    private FrameLayout show_search_list,show_search_history;
    private int loadPage=2;
    private DB_C db_c;
    private ListView listView;
    private RelativeLayout search_history_layout;
    private TagListView tagListView;
    private ArrayList<Tag> tag_list=new ArrayList<>();

    @Override
    public void addLayout() {
        setContentView(R.layout.activity_search);
        db_c=new DB_C(FirstSearchActivity.this);
        firstSearchAdapter=new FirstSearchAdapter();
        searchAdapter=new SearchAdapter(FirstSearchActivity.this,db_c.showAll());
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(FirstSearchActivity.this,null);
        new FirstSearchPresenter(FirstSearchActivity.this).hotTopic(FirstSearchActivity.this);
    }

    @Override
    public void initView() {
    search_et= (EditText) findViewById(R.id.search_edit);
    search_tv= (TextView) findViewById(R.id.search_tv);
    recyclerView= (RecyclerView) findViewById(R.id.search_recycler);
    show_search_list= (FrameLayout) findViewById(R.id.show_search_list);
    show_search_history= (FrameLayout) findViewById(R.id.show_search_history);
    listView= (ListView) findViewById(R.id.history_listView);
    tagListView= (TagListView) findViewById(R.id.tag_list);
    delete_all= (TextView) findViewById(R.id.search_delete_all);
    search_history_layout= (RelativeLayout) findViewById(R.id.search_history_layout);
    search_Tv= (TextView) findViewById(R.id.search_Tv);
    }

    @Override
    public void afterView() {
        search_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(search_et.getText().toString().equalsIgnoreCase("")){
                    search_tv.setVisibility(View.GONE);
                    search_Tv.setVisibility(View.VISIBLE);

                }else{
                    search_Tv.setVisibility(View.GONE);
                    search_tv.setVisibility(View.VISIBLE);}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        delete_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_history_layout.setVisibility(View.INVISIBLE);
                db_c.deleteAll();
                searchAdapter.updateAdapter(db_c.showAll());
            }
        });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db_c.delete(db_c.showAll(),position);
                searchAdapter.updateAdapter(db_c.showAll());
            }
        });
        if(db_c.showAll().isEmpty()){
            search_history_layout.setVisibility(View.INVISIBLE);
        }else{
            search_history_layout.setVisibility(View.VISIBLE);
            listView.setAdapter(searchAdapter);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(FirstSearchActivity.this));
        recyclerView.setAdapter(firstSearchAdapter );
        RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.search_refresh);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                new FirstSearchPresenter(FirstSearchActivity.this).firstSearch(FirstSearchActivity.this,search_et.getText().toString(),10,1,"0",1);
                refreshlayout.finishRefresh(1000);

            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                new FirstSearchPresenter(FirstSearchActivity.this).firstSearch(FirstSearchActivity.this,search_et.getText().toString(),10,loadPage,"0",2);
                refreshlayout.finishLoadmore(1000);
            }
        });

        search_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db_c.add(new Random().nextInt(),search_et.getText().toString());
                new FirstSearchPresenter(FirstSearchActivity.this).firstSearch(FirstSearchActivity.this,search_et.getText().toString(),10,1,"0",1);
            }
        });
       search_Tv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
    }

    @Override
    public void showRecycler(ArrayList<FirstSearchResult.ContentBean> list,int page,int index) {
        show_search_list.setVisibility(View.VISIBLE);
        show_search_history.setVisibility(View.INVISIBLE);

        if(list.isEmpty()){
          //  show_search_list.setVisibility(View.INVISIBLE);
            ToastUtils.showToast(this,"暂无内容");
        }
        if(!list.isEmpty()&&index==1){
            firstSearchAdapter.refresh(list,FirstSearchActivity.this);
            recyclerView.setAdapter(firstSearchAdapter);
            loadPage=2;
        }
        if(!list.isEmpty() && index==2){
            loadPage=page;
            firstSearchAdapter.addDatas(list,FirstSearchActivity.this);

        }

        firstSearchAdapter.setOnItemClickListener(new FirstSearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id, int type) {
                Intent intent=new Intent(FirstSearchActivity.this, BannerDetailActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("type",type);
                startActivity(intent);
            }

        });

    }

    @Override
    public void showHots(ArrayList<HotTopicResult.ContentBean.HotsBean> list) {
        for(int i=0;i<list.size();i++){
            Tag tag=new Tag();
            tag.setTitle(list.get(i).getName());
            tag_list.add(tag);
        }
        tagListView.setTags(tag_list);
        tagListView.setOnTagClickListener(new TagListView.OnTagClickListener() {
            @Override
            public void onTagClick(TagView tagView, Tag tag) {
                show_search_list.setVisibility(View.VISIBLE);
                show_search_history.setVisibility(View.INVISIBLE);
                search_et.setText(tag.getTitle());
                db_c.add(new Random().nextInt(),search_et.getText().toString());
                new FirstSearchPresenter(FirstSearchActivity.this).firstSearch(FirstSearchActivity.this,search_et.getText().toString(),10,1,"0",1);

            }
        });

    }
}
