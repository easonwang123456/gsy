package com.gsy.glsurvive.firstpage_model.bannerDetail.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TR-AND2 on 2017/12/29.
 */

public class ReplyCommentResult {

    /**
     * code : 200
     * msg : success
     * content : {"result":true,"message":"回复成功","commentType":2,"commentId":3631,"userId":0,"nickName":"内网IP网友.3","byUserId":"0","byNickName":"内网IP网友.177","imgUrl":"http://www.gaoshouyou.com/static/images/touxiang/default.jpg","text":"哦哦哦","agreeNum":0,"status":false,"time":"2017-12-29 14:43:23","replyMain":false}
     * post : {"id":"94010","type":"1","text":"哦哦哦","commentId":"3630","rating":"0"}
     * userId : 0
     * package :
     * time : 0.65472602844238
     */

    private int code;
    private String msg;
    private ContentBean content;
    private PostBean post;
    private int userId;
    @SerializedName("package")
    private String packageX;
    private double time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public PostBean getPost() {
        return post;
    }

    public void setPost(PostBean post) {
        this.post = post;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public static class ContentBean {
        /**
         * result : true
         * message : 回复成功
         * commentType : 2
         * commentId : 3631
         * userId : 0
         * nickName : 内网IP网友.3
         * byUserId : 0
         * byNickName : 内网IP网友.177
         * imgUrl : http://www.gaoshouyou.com/static/images/touxiang/default.jpg
         * text : 哦哦哦
         * agreeNum : 0
         * status : false
         * time : 2017-12-29 14:43:23
         * replyMain : false
         */

        private boolean result;
        private String message;
        private int commentType;
        private int commentId;
        private int userId;
        private String nickName;
        private String byUserId;
        private String byNickName;
        private String imgUrl;
        private String text;
        private int agreeNum;
        private boolean status;
        private String time;
        private boolean replyMain;

        public boolean isResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCommentType() {
            return commentType;
        }

        public void setCommentType(int commentType) {
            this.commentType = commentType;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getByUserId() {
            return byUserId;
        }

        public void setByUserId(String byUserId) {
            this.byUserId = byUserId;
        }

        public String getByNickName() {
            return byNickName;
        }

        public void setByNickName(String byNickName) {
            this.byNickName = byNickName;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getAgreeNum() {
            return agreeNum;
        }

        public void setAgreeNum(int agreeNum) {
            this.agreeNum = agreeNum;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public boolean isReplyMain() {
            return replyMain;
        }

        public void setReplyMain(boolean replyMain) {
            this.replyMain = replyMain;
        }
    }

    public static class PostBean {
        /**
         * id : 94010
         * type : 1
         * text : 哦哦哦
         * commentId : 3630
         * rating : 0
         */

        private String id;
        private String type;
        private String text;
        private String commentId;
        private String rating;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }
    }
}
