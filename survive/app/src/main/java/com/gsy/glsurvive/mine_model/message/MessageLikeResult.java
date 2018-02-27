package com.gsy.glsurvive.mine_model.message;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/8.
 */

public class MessageLikeResult {

    /**
     * code : 200
     * msg : success
     * content : [{"msgId":0,"msgType":0,"commentId":3666,"userId":4756,"nickName":"gsy-1514966523","userImg":"http://www.gaoshouyou.com/static/images/touxiang/default.jpg","text":"dhvccgg","time":"5分钟前","id":94010,"type":1,"name":"荒野行动毛瑟狙击枪实用性评测"}]
     * post : {"limit":"1","page":"1"}
     * userId : 4756
     * package :
     * time : 0.090607881546021
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
         * msgId : 0
         * msgType : 0
         * commentId : 3666
         * userId : 4756
         * nickName : gsy-1514966523
         * userImg : http://www.gaoshouyou.com/static/images/touxiang/default.jpg
         * text : dhvccgg
         * time : 5分钟前
         * id : 94010
         * type : 1
         * name : 荒野行动毛瑟狙击枪实用性评测
         */

        private int msgId;
        private int msgType;
        private int commentId;
        private int userId;
        private String nickName;
        private String userImg;
        private String text;
        private String time;
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

        public String getUserImg() {
            return userImg;
        }

        public void setUserImg(String userImg) {
            this.userImg = userImg;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
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
