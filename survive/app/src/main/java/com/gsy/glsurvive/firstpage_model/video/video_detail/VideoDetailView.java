package com.gsy.glsurvive.firstpage_model.video.video_detail;

import android.widget.ImageView;
import android.widget.TextView;

import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ShareResult;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public interface VideoDetailView {
    void videoDetail(VideoDetailResult.ContentBean contentBean,ArrayList<VideoDetailResult.ContentBean.OtherDataBean> list_detail);
    void videoCommentList(ArrayList<VideoCommentResult.ContentBean> list, Boolean refresh,int page,int index);
    void showGetContent(VideoDetailResult.ContentBean contentBean);
    void showLike(Boolean flag);
    void showShare(ArrayList<ShareResult.ContentBean> list);
    void dismissMenu();
    void showLike(ImageView imageView, TextView textView, Boolean isResult, int num);
    void shareUrl(ArrayList<ShareResult.ContentBean> list,int type);
    void refreshAdapter();
    void refreshSmallAdapter();
}

