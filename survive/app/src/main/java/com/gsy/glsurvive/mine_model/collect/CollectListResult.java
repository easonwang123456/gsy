package com.gsy.glsurvive.mine_model.collect;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/4.
 */

public class CollectListResult {

    /**
     * code : 200
     * msg : success
     * content : [{"id":94010,"collectId":167,"name":"荒野行动毛瑟狙击枪实用性评测","imgUrl":"","type":1,"time":"2017-12-14","hits":"456","commentNum":"47"}]
     * post : {"type":"0","limit":"1","page":"1"}
     * userId : 4756
     * package :
     * time : 0.023927211761475
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
         * type : 0
         * limit : 1
         * page : 1
         */

        private String type;
        private String limit;
        private String page;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

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
        @Override
        public String toString() {
            return "ContentBean{" +
                    "id=" + id +
                    ", collectId=" + collectId +
                    ", name='" + name + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", type=" + type +
                    ", time='" + time + '\'' +
                    ", hits='" + hits + '\'' +
                    ", commentNum='" + commentNum + '\'' +
                    '}';
        }

        /**
         * id : 94010
         * collectId : 167
         * name : 荒野行动毛瑟狙击枪实用性评测
         * imgUrl :
         * type : 1
         * time : 2017-12-14
         * hits : 456
         * commentNum : 47
         */

        private int id;
        private int collectId;
        private String name;
        private String imgUrl;
        private int type;
        private String time;
        private String hits;
        private String commentNum;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCollectId() {
            return collectId;
        }

        public void setCollectId(int collectId) {
            this.collectId = collectId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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
    }
}
