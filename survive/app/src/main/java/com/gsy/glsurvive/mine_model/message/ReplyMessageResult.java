package com.gsy.glsurvive.mine_model.message;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/8.
 */

public class ReplyMessageResult {

    /**
     * code : 200
     * msg : success
     * content : [{"msgId":9507,"msgType":2,"replyCommentId":3669,"replyUserId":4756,"replyNickName":"gsy-1514966523","replyImgUrl":"http://www.gaoshouyou.com/static/images/touxiang/default.jpg","replyText":"sjsjshhs","time":"01-04","nickName":"gsy-1514966523","text":"dhvccgg","id":94010,"type":1,"name":"荒野行动毛瑟狙击枪实用性评测"}]
     * post : {"limit":"1","page":"1"}
     * userId : 4756
     * package :
     * time : 0.027529001235962
     */

    private int code;
    private String msg;
    private PostBean post;
    private int userId;
    @SerializedName("package")
    private String packageX;
    private double time;
    private ArrayList<ContentBean> content;

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

    public ArrayList<ContentBean> getContent() {
        return content;
    }

    public void setContent(ArrayList<ContentBean> content) {
        this.content = content;
    }

    public static class PostBean {
        /**
         * limit : 1
         * page : 1
         */

        private String limit;
        private String page;

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }
    }

    public static class ContentBean {
        /**
         * msgId : 9507
         * msgType : 2
         * replyCommentId : 3669
         * replyUserId : 4756
         * replyNickName : gsy-1514966523
         * replyImgUrl : http://www.gaoshouyou.com/static/images/touxiang/default.jpg
         * replyText : sjsjshhs
         * time : 01-04
         * nickName : gsy-1514966523
         * text : dhvccgg
         * id : 94010
         * type : 1
         * name : 荒野行动毛瑟狙击枪实用性评测
         */

        private int msgId;
        private int msgType;
        private int replyCommentId;
        private int replyUserId;
        private String replyNickName;
        private String replyImgUrl;
        private String replyText;
        private String time;
        private String nickName;
        private String text;
        private int id;
        private int type;
        private String name;

        public int getMsgId() {
            return msgId;
        }

        public void setMsgId(int msgId) {
            this.msgId = msgId;
        }

        public int getMsgType() {
            return msgType;
        }

        public void setMsgType(int msgType) {
            this.msgType = msgType;
        }

        public int getReplyCommentId() {
            return replyCommentId;
        }

        public void setReplyCommentId(int replyCommentId) {
            this.replyCommentId = replyCommentId;
        }

        public int getReplyUserId() {
            return replyUserId;
        }

        public void setReplyUserId(int replyUserId) {
            this.replyUserId = replyUserId;
        }

        public String getReplyNickName() {
            return replyNickName;
        }

        public void setReplyNickName(String replyNickName) {
            this.replyNickName = replyNickName;
        }

        public String getReplyImgUrl() {
            return replyImgUrl;
        }

        public void setReplyImgUrl(String replyImgUrl) {
            this.replyImgUrl = replyImgUrl;
        }

        public String getReplyText() {
            return replyText;
        }

        public void setReplyText(String replyText) {
            this.replyText = replyText;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
