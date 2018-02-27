package com.gsy.glsurvive.network;
import com.gsy.glsurvive.data_model.CarryListResult;
import com.gsy.glsurvive.data_model.facility.FacilityResult;
import com.gsy.glsurvive.entity.FirstPageTitleEntity;
import com.gsy.glsurvive.firstpage_model.FirstPageRecommandResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.BannerDetailResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CollectResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CommentLikeResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.CommentListResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.PageLikeResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ReplyCommentResult;
import com.gsy.glsurvive.firstpage_model.bannerDetail.result.ShareResult;
import com.gsy.glsurvive.firstpage_model.first_search.FirstSearchResult;
import com.gsy.glsurvive.firstpage_model.first_search.HotTopicResult;
import com.gsy.glsurvive.firstpage_model.gun.FirstGunListResult;
import com.gsy.glsurvive.firstpage_model.gun.GunTypeResult;
import com.gsy.glsurvive.firstpage_model.gun.gun_detail.GunDetailResult;
import com.gsy.glsurvive.firstpage_model.map.MapDetailResult;
import com.gsy.glsurvive.firstpage_model.rookie.RookieResult;
import com.gsy.glsurvive.firstpage_model.video.VideoListResult;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoCommentResult;
import com.gsy.glsurvive.firstpage_model.video.video_detail.VideoDetailResult;
import com.gsy.glsurvive.logo.LogoResult;
import com.gsy.glsurvive.mine_model.collect.CollectDeleteResult;
import com.gsy.glsurvive.mine_model.collect.CollectListResult;
import com.gsy.glsurvive.mine_model.collect.CollectTypeResult;
import com.gsy.glsurvive.mine_model.login.LoginResult;
import com.gsy.glsurvive.mine_model.message.MessageLikeResult;
import com.gsy.glsurvive.mine_model.message.ReplyMessageResult;
import com.gsy.glsurvive.mine_model.profile.ImgUrlResult;
import com.gsy.glsurvive.mine_model.profile.ProfileResult;
import com.gsy.glsurvive.mine_model.register.RegisterCodeResult;
import com.gsy.glsurvive.mine_model.register.RegisterResult;
import com.gsy.glsurvive.mine_model.setting.update.UpdateResult;
import com.gsy.glsurvive.mine_model.suggestion.SuggestionResult;
import com.gsy.glsurvive.strategy_model.EachStrategyResult;
import com.gsy.glsurvive.strategy_model.battle.battle_recycler.BattleListResult;
import com.gsy.glsurvive.strategy_model.battle.BattleResult;
import com.gsy.glsurvive.strategy_model.gun.GunResult;
import com.gsy.glsurvive.strategy_model.gun.gun_recycler.GunListResult;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;

/**
 * Created by TR-AND2 on 2017/11/30.
 */

public interface GuideAPI {
    //app启动数据
    @POST("welcome/index")
    Call<LogoResult> initAPP(@QueryMap Map<String, String> map);

   //app启动数据
   @POST("welcome/index")
   Call<HotTopicResult> searchHot(@QueryMap Map<String, String> map);

    //首页tabTitles
    @POST("home/type")
    Call<FirstPageTitleEntity> firstPageList(@QueryMap Map<String, String> map);

   //注册
   @FormUrlEncoded
   @POST("user/register")
   Call<RegisterResult> register(@QueryMap Map<String, String> map,
                                 @Field("userName") String userName,
                                 @Field("passWord") String passWord,
                                 @Field("code") String code);
    //获取验证码
    @FormUrlEncoded
    @POST("action/code")
    Call<RegisterCodeResult> code(@QueryMap Map<String, String> map,
                                  @Field("userName") String userName,
                                  @Field("codeType") String codeType);

    //登录
    @FormUrlEncoded
    @POST("user/login")
    Call<LoginResult> login(@QueryMap Map<String, String> map,
                            @Field("userName") String userName,
                            @Field("passWord") String passWord
    );

    //用户个人资料
    @FormUrlEncoded
    @POST("user/info")
    Call<ResponseBody> userInfo(@QueryMap Map<String, String> map
    );

    //修改个人信息
    @FormUrlEncoded
    @POST("user/set")
    Call<ProfileResult> userInfoReset(@QueryMap Map<String, String> map,
                                      @Field("nickName") String nickName,
                                      @Field("sex") String sex,
                                      @Field("signature") String signature,
                                      @Field("birthday") String birthday,
                                      @Field("location") String location

    );

    //修改头像
    @Multipart
    @POST("user/set/avatar")
    Call<ImgUrlResult> userImageReset(@QueryMap Map<String, String> map,
                                      @Part MultipartBody.Part file
                                      );
    //找回密码
    @FormUrlEncoded
    @POST("user/password/find")
    Call<ResponseBody> refindPassword(@QueryMap Map<String, String> map,
                                      @Field("userName") String userName,
                                      @Field("code") String code,
                                      @Field("passWord") String passWord
    );
    //首页文章列表
    @FormUrlEncoded
    @POST("home/index")
    Call<FirstPageRecommandResult> firstPageList(@QueryMap Map<String, String> map,
                                                 @Field("type") int type,
                                                 @Field("limit") int limit,
                                                 @Field("page") int page,
                                                 @Field("typeId") int typeId
    );
    //banner
    @FormUrlEncoded
    @POST("post/detail")
    Call<BannerDetailResult> bannerDetail(@QueryMap Map<String, String> map,
                                          @Field("id") int Id,
                                          @Field("type") int type
    );
    //攻略分类
    @FormUrlEncoded
    @POST("gonglue/type")
    Call<ResponseBody> strategyType(@QueryMap Map<String, String> map

    );
    //攻略列表
    @FormUrlEncoded
    @POST("gonglue/lists")
    Call<EachStrategyResult> strategyList(@QueryMap Map<String, String> map,
                                         @Field("limit") int limit,
                                         @Field("page") int page,
                                         @Field("typeId") int typeId,
                                         @Field("order") int order
    );
 //新手列表
 @FormUrlEncoded
 @POST("gonglue/lists")
 Call<RookieResult> rookieList(@QueryMap Map<String, String> map,
                               @Field("limit") int limit,
                               @Field("page") int page,
                               @Field("typeId") int typeId,
                               @Field("order") int order
 );
 //载具列表
 @POST("hyxd/ziliao/zaiju")
 Call<CarryListResult>carryList(@QueryMap Map<String, String> map
 );


 //地形列表
 @FormUrlEncoded
 @POST("home/index")
 Call<FirstPageRecommandResult> battleList(@QueryMap Map<String, String> map,
                              @Field("type") int type,
                              @Field("limit") int limit,
                              @Field("page") int page,
                              @Field("typeId") int typeId);


// //枪械列表
// @POST("hyxd/gun/lists")
// Call<GunResult>gunList(@QueryMap Map<String, String> map);
 //地形图文章
// @FormUrlEncoded
// @POST("hyxd/land/detail")
// Call<BattleListResult> battleRecycler(@QueryMap Map<String, String> map,
//                                       @Field("id") int id,
//                                       @Field("page") int page,
//                                       @Field("limit") int limit
//                                   );
 //枪械列表
 @FormUrlEncoded
 @POST("home/index")
 Call<FirstPageRecommandResult> gunRecycler(@QueryMap Map<String, String> map,
                                           @Field("type") int type,
                                           @Field("limit") int limit,
                                           @Field("page") int page,
                                           @Field("typeId") int typeId);

 //吃鸡列表
 @FormUrlEncoded
 @POST("home/index")
 Call<FirstPageRecommandResult> chickenRecycler(@QueryMap Map<String, String> map,
                                            @Field("type") int type,
                                            @Field("limit") int limit,
                                            @Field("page") int page,
                                            @Field("typeId") int typeId);

 //首页搜索
 @FormUrlEncoded
 @POST("action/search")
 Call<FirstSearchResult>firstPageSearch(@QueryMap Map<String, String> map,
                                        @Field("keyWord") String keyWord,
                                        @Field("limit") int limit,
                                        @Field("page") int page,
                                        @Field("type") String type
 );
 //文章评论详情
 @FormUrlEncoded
 @POST("comment/index")
 Call<CommentListResult> commentList(@QueryMap Map<String, String> map,
                                     @Field("id") int id,
                                     @Field("type") int type,
                                     @Field("limit") int limit,
                                     @Field("page") int page
 );
 //发表评论
 @FormUrlEncoded
 @POST("comment/send")
 Call<ReplyCommentResult> sendComment(@QueryMap Map<String, String> map,
                                      @Field("id") int id,
                                      @Field("type") int type,
                                      @Field("text") String text,
                                      //@Field("commentId") int commentId,
                                      @Field("rating") int rating
 );
 //回复评论
 @FormUrlEncoded
 @POST("comment/send")
 Call<ReplyCommentResult> sendReply(@QueryMap Map<String, String> map,
                                      @Field("id") int id,
                                      @Field("type") int type,
                                      @Field("text") String text,
                                      @Field("commentId") int commentId,
                                      @Field("rating") int rating
 );
 //点赞
 @FormUrlEncoded
 @POST("action/agree")
 Call<PageLikeResult> like(@QueryMap Map<String, String> map,
                           @Field("id") int id,
                           @Field("type") int type
 );

 //视频详情
 @FormUrlEncoded
 @POST("video/detail")
 Call<VideoDetailResult> videoDetail(@QueryMap Map<String, String> map,
                                     @Field("id") int id
 );

 //视频详情
 @FormUrlEncoded
 @POST("video/lists")
 Call<VideoListResult> videoList(@QueryMap Map<String, String> map,
                                 @Field("typeId") int typeId,
                                 @Field("id") int id,
                                 @Field("page") int page,
                                 @Field("limit") int limit
 );
 //视频评论详情
 @FormUrlEncoded
 @POST("comment/index")
 Call<VideoCommentResult> videoCommentList(@QueryMap Map<String, String> map,
                                           @Field("id") int id,
                                           @Field("type") int type,
                                           @Field("limit") int limit,
                                           @Field("page") int page
 );

 //分享
 @FormUrlEncoded
 @POST("action/share")
 Call<ShareResult> share(@QueryMap Map<String, String> map,
                         @Field("id") int id,
                         @Field("type") int type

 );
 //收藏
 @FormUrlEncoded
 @POST("action/collect")
 Call<CollectResult> collect(@QueryMap Map<String, String> map,
                             @Field("id") int id,
                             @Field("type") int type

 );
 //意见反馈
 @FormUrlEncoded
 @POST("action/feedback")
 Call<SuggestionResult> suggestion(@QueryMap Map<String, String> map,
                                   @Field("text") String text,
                                   @Field("contact") String contact

 );
 //我的收藏
 @POST("user/collect/type")
 Call<CollectTypeResult> collectType(@QueryMap Map<String, String> map
 );

 //用户收藏列表
 @FormUrlEncoded
 @POST("user/collect")
 Call<CollectListResult> collectList(@QueryMap Map<String, String> map,
                                     @Field("type") int type,
                                     @Field("limit") int limit,
                                     @Field("page") int page
 );

 //检查更新
 @POST("set/update")
 Call<UpdateResult> update(@QueryMap Map<String, String> map);


 //我的点赞
 @FormUrlEncoded
 @POST("user/message/ding")
 Call<MessageLikeResult> messageLike(@QueryMap Map<String, String> map,
                                     @Field("limit") int limit,
                                     @Field("page") int page
 );

 //点赞我的
 @FormUrlEncoded
 @POST("action/agree/comment")
 Call<CommentLikeResult> commentLike(@QueryMap Map<String, String> map,
                                     @Field("commentId") int commentId

 );
 //回复我的
 @FormUrlEncoded
 @POST("user/message/reply")
 Call<ReplyMessageResult> replyComment(@QueryMap Map<String, String> map,
                                       @Field("limit") int limit,
                                       @Field("page") int page

 );
 //取消收藏
 @FormUrlEncoded
 @POST("action/remove")
 Call<CollectDeleteResult> cancelCollect(@QueryMap Map<String, String> map,
                                         @Field("collectId") String collectId

 );
 //枪械分类
 @POST("jdqs/gun/type")
 Call<GunTypeResult> gunType (@QueryMap Map<String, String> map);

 //枪械列表
 @FormUrlEncoded
 @POST("jdqs/gun/lists")
 Call<FirstGunListResult> firstGunList (@QueryMap Map<String, String> map,
                                        @Field("typeId") int typeId);
 //枪械详情
 @FormUrlEncoded
 @POST("jdqs/gun/detail")
 Call<GunDetailResult> firstGunDetail (@QueryMap Map<String, String> map,
                                       @Field("id") int id);

 //地图详情
 @POST("jdqs/land/lists")
 Call<MapDetailResult> firstMapDetail(@QueryMap Map<String, String> map);

 //物品资料详情
 @POST("jdqs/wupin/lists")
 Call<FacilityResult> facilityList(@QueryMap Map<String, String> map);
}
