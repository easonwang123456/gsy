package com.gsy.glsurvive.firstpage_model.first_search;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class FirstSearchResult {

    /**
     * code : 200
     * msg : success
     * content : [{"id":93995,"item":0,"name":"这不说的就是我吗？荒野行动佛系玩家的八大表现","type":5,"imgUrl":"http://rs.0.gaoshouyou.com/i/27/72/4e27fbc135727d2301abb7b4c89763f1.jpeg","time":"2017-12-14","hits":"67","commentNum":"0","description":"在《荒野行动》中，有些玩家被大家称为佛系玩家，小编今天看了以后简直深有体会~下面就是佛系玩家的八大表现，一起来看看吧！","dataType":1}]
     * post : {"keyWord":"我","limit":"10","page":"1","type":"0"}
     * userId : 0
     * package :
     * time : 0.027723073959351
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
         * keyWord : 我
         * limit : 10
         * page : 1
         * type : 0
         */

        private String keyWord;
        private String limit;
        private String page;
        private String type;

        public String getKeyWord() {
            return keyWord;
        }

        public void setKeyWord(String keyWord) {
            this.keyWord = keyWord;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class ContentBean {
        /**
         * id : 93995
         * item : 0
         * name : 这不说的就是我吗？荒野行动佛系玩家的八大表现
         * type : 5
         * imgUrl : http://rs.0.gaoshouyou.com/i/27/72/4e27fbc135727d2301abb7b4c89763f1.jpeg
         * time : 2017-12-14
         * hits : 67
         * commentNum : 0
         * description : 在《荒野行动》中，有些玩家被大家称为佛系玩家，小编今天看了以后简直深有体会~下面就是佛系玩家的八大表现，一起来看看吧！
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

        @Override
        public String toString() {
            return "ContentBean{" +
                    "id=" + id +
                    ", item=" + item +
                    ", name='" + name + '\'' +
                    ", type=" + type +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", time='" + time + '\'' +
                    ", hits='" + hits + '\'' +
                    ", commentNum='" + commentNum + '\'' +
                    ", description='" + description + '\'' +
                    ", dataType=" + dataType +
                    '}';
        }
    }
}
