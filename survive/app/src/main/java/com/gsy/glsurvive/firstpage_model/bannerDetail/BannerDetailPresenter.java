package com.gsy.glsurvive.firstpage_model.bannerDetail;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gsy.glsurvive.firstpage_model.bannerDetail.result.BannerDetailResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CollectResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CommentLikeResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CommentListResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.PageLikeResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ReplyCommentResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ShareResult;
import com.gsy.glsurvive.network.GuideAPI;
import com.gsy.glsurvive.network.ServiceManager;
import com.gsy.glsurvive.utils.LogUtil;
import com.gsy.glsurvive.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by TR-AND2 on 2017/12/18.
 */

public class BannerDetailPresenter {
 private BannerDetailView bannerDetailView;
 private ArrayList<CommentListResult.ContentBean> list_comment=new ArrayList<>();
    private ArrayList<CommentListResult.ContentBean.ReplyBean> list_reply=new ArrayList<>();
    private static int mpage=2;
 private BannerDetailActivity bannerDetailActivity;

    public BannerDetailPresenter(BannerDetailActivity bannerDetailActivity) {
        this.bannerDetailActivity = bannerDetailActivity;
    }

    public void detailRequest(final Context context, int id, int type){
       Log.e("msg","id:"+id);
        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();

        ServiceManager.getInstance(context).getService(GuideAPI.class).bannerDetail(params,id,type).enqueue(new Callback<BannerDetailResult>() {
            @Override
            public void onResponse(Call<BannerDetailResult> call, Response<BannerDetailResult> response) {
                try {
                    if(response.body().getCode()==200){
                        bannerDetailActivity.showContent(response.body().getContent().getPostData());
                        bannerDetailActivity.showRecycler(response.body().getContent().getOtherData());
                        bannerDetailActivity.showGetContent(response.body().getContent());
                        Log.e("msg","title:"+response.body().getContent().getName());
                        LogUtil.e("msg","response.body().getContent().getPostData():"+response.body().getContent().getPostData());


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<BannerDetailResult> call, Throwable t) {
                Log.e("msg",""+t.getMessage());
            }
        });

    }
    public void commentList(final Context context, int id, int type, int limit, final int page, final int index, final Boolean refresh){

        Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();

        ServiceManager.getInstance(context).getService(GuideAPI.class).commentList(params,id,type,limit,page).enqueue(new Callback<CommentListResult >() {
            @Override
            public void onResponse(Call<CommentListResult > call, Response<CommentListResult > response) {
                try {
                    if(response.body().getCode()==200){
                        Log.e("msg","请求page:"+page);
                            if(!response.body().getContent().isEmpty() &&index==2 ){
                                mpage=page+1;
                            }

                        bannerDetailActivity.showComment(response.body().getContent(),refresh,mpage,index);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CommentListResult > call, Throwable t) {
                Log.e("msg",""+t.getMessage());
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
                            bannerDetailActivity.refreshAdapter();
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
                            ToastUtils.showToast(context,response.body().getContent().getMessage(), Toast.LENGTH_SHORT);
                            CommentListResult.ContentBean.ReplyBean replyBean=new CommentListResult.ContentBean.ReplyBean();
                            replyBean.setReplyText(response.body().getContent().getText());
                            replyBean.setReplyTime(response.body().getContent().getTime());
                            replyBean.setReplyAgreeNum(""+response.body().getContent().getAgreeNum());
                            replyBean.setReplyNickName(response.body().getContent().getByNickName());
                            replyBean.setReplyStatus(response.body().getContent().isStatus());
                            bannerDetailActivity.refreshSmallAdapter();
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
                            bannerDetailActivity.showLike(response.body().getContent().isResult());
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
                          bannerDetailActivity.showShare(response.body().getContent());
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
  public void collect(final Context context, final int id, final int type){
      Map<String, String> params = ServiceManager.getInstance(context).getUrlParams();
      ServiceManager.getInstance(context).getService(GuideAPI.class).collect(params,id,type).enqueue(new Callback<CollectResult>() {
          @Override
          public void onResponse(Call<CollectResult> call, Response<CollectResult> response) {
              try {

                      ToastUtils.showToast(context,response.body().getContent().getMessage());
                      bannerDetailActivity.dismissMenu();

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
                            bannerDetailActivity.showLike(imageView,textView,response.body().getContent().isResult(),num);
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
                            bannerDetailActivity.showReplyLike(imageView,textView,response.body().getContent().isResult(),num);
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
                            bannerDetailActivity.shareUrl(response.body().getContent(),index_type);
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
