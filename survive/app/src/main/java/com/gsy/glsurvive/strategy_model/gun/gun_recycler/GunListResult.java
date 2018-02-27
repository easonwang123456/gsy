package com.gsy.glsurvive.strategy_model.gun.gun_recycler;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class GunListResult {

    /**
     * code : 200
     * msg : success
     * content : [{"id":93996,"item":0,"name":"荒野行动新手实用技巧分享","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/15/f6/6415e63f8cf6bd5b851d5f389a42690d.jpeg","time":"2017-12-14","hits":"95","commentNum":"0","description":"《荒野行动》作为最近非常火爆的吃鸡手游，自然有很多新手玩家加入，那么下面小编就为大家带来一些新手实用技巧，希望能够帮到大家~","dataType":1}]
     * post : {"id":"6465","page":"1","limit":"1"}
     * userId : 0
     * package :
     * time : 0.022051811218262
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
         * id : 6465
         * page : 1
         * limit : 1
         */

        private String id;
        private String page;
        private String limit;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }
    }

    public static class ContentBean {
        /**
         * id : 93996
         * item : 0
         * name : 荒野行动新手实用技巧分享
         * type : 1
         * imgUrl : http://rs.0.gaoshouyou.com/i/15/f6/6415e63f8cf6bd5b851d5f389a42690d.jpeg
         * time : 2017-12-14
         * hits : 95
         * commentNum : 0
         * description : 《荒野行动》作为最近非常火爆的吃鸡手游，自然有很多新手玩家加入，那么下面小编就为大家带来一些新手实用技巧，希望能够帮到大家~
         * dataType : 1
         */

        private int id;
        private int item;
        private String name;
        private int type;
        private String imgUrl;
        private String time;
        private String hits;
        private String commentNum;
        private String description;
        private int dataType;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getHits() {
            return hits;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public String getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(String commentNum) {
            this.commentNum = commentNum;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDataType() {
            return dataType;
        }

        public void setDataType(int dataType) {
            this.dataType = dataType;
        }
    }
}