package com.gsy.glsurvive.data_model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


/**
 * Created by TR-AND2 on 2017/12/21.
 */

public class CarryListResult {

    /**
     * code : 200
     * msg : success
     * content : [{"id":1569,"name":"面包车","type":3,"text":"面包车","imgUrl":"http://rs.0.gaoshouyou.com/i/1d/f5/f51d0604f8f5b8d8809c49d0ab84b62a.png","bjUrl":"http://rs.0.gaoshouyou.com/i/1c/75/4a1cf327a075763a329e1e7a8caed0dc.png"},{"id":1570,"name":"全地形车","type":3,"text":"全地形车","imgUrl":"http://rs.0.gaoshouyou.com/i/4d/0b/004dce2d8c0b7d3fc946acbd742fbe53.png","bjUrl":"http://rs.0.gaoshouyou.com/i/c4/10/b9c449d78410d9a2d9a978df612c5436.png"},{"id":1571,"name":"吉普车","type":3,"text":"吉普","imgUrl":"http://rs.0.gaoshouyou.com/i/65/d2/29658bf647d2ff74d3444e8f5324f8b2.png","bjUrl":"http://rs.0.gaoshouyou.com/i/0b/e9/2d0b55ce41e967ffb19acc176df43cfa.png"},{"id":1572,"name":"船","type":3,"text":"船","imgUrl":"http://rs.0.gaoshouyou.com/i/b2/43/7db2fff97143c7e7b4fe4eea07fd017a.png","bjUrl":"http://rs.0.gaoshouyou.com/i/ba/d3/27ba7e003fd332d2022fffbe4e8eaaa3.png"}]
     * post : []
     * userId : 0
     * package :
     * time : 0.12842392921448
     */

    private int code;
    private String msg;
    private int userId;
    @SerializedName("package")
    private String packageX;
    private double time;
    private ArrayList<ContentBean> content;
    private ArrayList<?> post;

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

    public ArrayList<?> getPost() {
        return post;
    }

    public void setPost(ArrayList<?> post) {
        this.post = post;
    }

    public static class ContentBean {
        @Override
        public String toString() {
            return "ContentBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", type=" + type +
                    ", text='" + text + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", bjUrl='" + bjUrl + '\'' +
                    '}';
        }

        /**
         * id : 1569
         * name : 面包车
         * type : 3
         * text : 面包车
         * imgUrl : http://rs.0.gaoshouyou.com/i/1d/f5/f51d0604f8f5b8d8809c49d0ab84b62a.png
         * bjUrl : http://rs.0.gaoshouyou.com/i/1c/75/4a1cf327a075763a329e1e7a8caed0dc.png
         */

        private int id;
        private String name;
        private int type;
        private String text;
        private String imgUrl;
        private String bjUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getBjUrl() {
            return bjUrl;
        }

        public void setBjUrl(String bjUrl) {
            this.bjUrl = bjUrl;
        }
    }
}
