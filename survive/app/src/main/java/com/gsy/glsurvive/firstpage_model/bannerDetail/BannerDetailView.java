package com.gsy.glsurvive.firstpage_model.bannerDetail;

import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.firstpage_model.bannerDetail.result.BannerDetailResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CommentListResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ShareResult;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/27.
 */

public interface BannerDetailView {
    void showContent(ArrayList<BannerDetailResult.ContentBean.PostDataBean> list);
    void showRecycler(ArrayList<BannerDetailResult.ContentBean.OtherDataBean> list);
    void showComment(ArrayList<CommentListResult.ContentBean> list,Boolean refresh,int page,int index);
    void refreshAdapter();
    void showGetContent(BannerDetailResult.ContentBean contentBean);
    void showLike(Boolean flag);
    void showShare(ArrayList<ShareResult.ContentBean> list);
    void dismissMenu();
    void showLike(ImageView imageView, TextView textView,Boolean isResult,int num);
    void shareUrl(ArrayList<ShareResult.ContentBean> list,int type);
    void refreshSmallAdapter();
}
