package com.gsy.glsurvive.firstpage_model.video.video_detail;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CollectResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CommentLikeResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.PageLikeResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ReplyCommentResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ShareResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.ToastUtils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TR-AND2 on 2018/1/2.
 */

public class VideoDetailPresenter {
    private VideoListDetailActivity videoListDetailActivity;
    private static int mpage=2;
    public VideoDetailPresenter(VideoListDetailActivity videoListDetailActivity) {
        this.videoListDetailActivity = videoListDetailActivity;
    }

    public void videoDetail(Context context, int id){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).videoDetail(params,id).enqueue(new Callback<VideoDetailResult>() {
            @Override
            public void onResponse(Call<VideoDetailResult> call, Response<VideoDetailResult> response) {
                try {
                    if(response.body().getCode()==200){
                        videoListDetailActivity.videoDetail(response.body().getContent(),response.body().getContent().getOtherData());
                        videoListDetailActivity.showGetContent(response.body().getContent());
                       Log.e("msg","videoDetail:"+response.body().getContent().getOtherData());
                        Log.e("msg","showGetContent:"+response.body().getContent());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<VideoDetailResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }
    public void videoCommentList(Context context, int id, int type, int limit, final int page, final int index, final Boolean refresh){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).videoCommentList(params,id,type,limit,page).enqueue(new Callback<VideoCommentResult>() {
            @Override
            public void onResponse(Call<VideoCommentResult> call, Response<VideoCommentResult> response) {
                try {

                    if(response.body().getCode()==200){
                        if(!response.body().getContent().isEmpty() &&index==2 ){
                            mpage=page+1;
                        }
                        Log.e("msg","videoCommentList:"+response.body().getContent());
                        videoListDetailActivity.videoCommentList(response.body().getContent(),refresh,mpage,index);
                    }
//


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<VideoCommentResult> call, Throwable t) {
                Log.e("msg","t:"+t.getMessage());
            }
        });
    }


    public void sendComment(final Context context, int id, int type,String text,int rating){

        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();

        ServiceManager.getInstance(context).getService(GuideAPI.class).sendComment(params,id,type,text,rating).enqueue(new Callback<ReplyCommentResult>() {
            @Override
            public void onResponse(Call<ReplyCommentResult> call, Response<ReplyCommentResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getCode()==200){
                            ToastUtils.showToast(context,response.body().getContent().getMessage(), Toast.LENGTH_SHORT);
                            Log.e("msg","sendComment:"+response.body().getContent());
                            videoListDetailActivity.refreshAdapter();

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ReplyCommentResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });

    }

    public void sendReply(final Context context, int id, int type,String text,int commentId,int rating){

        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();

        ServiceManager.getInstance(context).getService(GuideAPI.class).sendReply(params,id,type,text,commentId,rating).enqueue(new Callback<ReplyCommentResult>() {
            @Override
            public void onResponse(Call<ReplyCommentResult> call, Response<ReplyCommentResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getCode()==200){
                            Log.e("msg","jinlaile3");
                            ToastUtils.showToast(context,response.body().getContent().getMessage(), Toast.LENGTH_SHORT);

                            videoListDetailActivity.refreshSmallAdapter();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ReplyCommentResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });

    }

    public void like(final Context context, int id, int type){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();

        ServiceManager.getInstance(context).getService(GuideAPI.class).like(params,id,type).enqueue(new Callback<PageLikeResult>() {
            @Override
            public void onResponse(Call<PageLikeResult> call, Response<PageLikeResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getCode()==200){
                            ToastUtils.showToast(context,response.body().getContent().getMessage());
                            videoListDetailActivity.showLike(response.body().getContent().isResult());
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<PageLikeResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });

    }
    public void share(final Context context, int id, int type){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).share(params,id,type).enqueue(new Callback<ShareResult>() {
            @Override
            public void onResponse(Call<ShareResult> call, Response<ShareResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getCode()==200){
                            videoListDetailActivity.showShare(response.body().getContent());
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ShareResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });

    }
    public void collect(final Context context, int id, int type){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).collect(params,id,type).enqueue(new Callback<CollectResult>() {
            @Override
            public void onResponse(Call<CollectResult> call, Response<CollectResult> response) {
                try {
                    ToastUtils.showToast(context,response.body().getContent().getMessage());
                    videoListDetailActivity.dismissMenu();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CollectResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }

    public void commentLike(final Context context, int commentId, final ImageView imageView, final TextView textView, final int num){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).commentLike(params,commentId).enqueue(new Callback<CommentLikeResult>() {
            @Override
            public void onResponse(Call<CommentLikeResult> call, Response<CommentLikeResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getCode()==200){
                            ToastUtils.showToast(context,response.body().getContent().getMessage());
                            videoListDetailActivity.showLike(imageView,textView,response.body().getContent().isResult(),num);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CommentLikeResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }

    public void commentReplyLike(final Context context, int commentId, final ImageView imageView, final TextView textView, final String num){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).commentLike(params,commentId).enqueue(new Callback<CommentLikeResult>() {
            @Override
            public void onResponse(Call<CommentLikeResult> call, Response<CommentLikeResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getCode()==200){
                            ToastUtils.showToast(context,response.body().getContent().getMessage());
                            videoListDetailActivity.showReplyLike(imageView,textView,response.body().getContent().isResult(),num);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CommentLikeResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });
    }

    public void shareUrl(final Context context, int id, int type, final int index_type){
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
        ServiceManager.getInstance(context).getService(GuideAPI.class).share(params,id,type).enqueue(new Callback<ShareResult>() {
            @Override
            public void onResponse(Call<ShareResult> call, Response<ShareResult> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body().getCode()==200){
                            videoListDetailActivity.shareUrl(response.body().getContent(),index_type);
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ShareResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });

    }
}
