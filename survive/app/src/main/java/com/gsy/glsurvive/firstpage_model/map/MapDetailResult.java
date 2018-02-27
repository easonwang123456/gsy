package com.gsy.glsurvive.firstpage_model.map;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2018/2/7.
 */

public class MapDetailResult {

    /**
     * code : 200
     * msg : success
     * content : [{"id":1677,"name":"全资源","text":"","imgUrl":"http://rs.0.gaoshouyou.com/i/3a/c9/153a472455c92b5e0b5dd6673d3feb9f.jpg"},{"id":1678,"name":"刷车点","text":"红色高几率，黄色随机","imgUrl":"http://rs.0.gaoshouyou.com/i/ff/fc/58ff4449bdfc719702f0eb0e55fce87e.jpg"},{"id":1679,"name":"刷船点","text":"","imgUrl":"http://rs.0.gaoshouyou.com/i/67/44/0767d9bf53445c3beb19d6cd5e54b4be.jpg"},{"id":1680,"name":"贫富房区分布","text":"红色区域：高级物资、黄色区域：中级物资","imgUrl":"http://rs.0.gaoshouyou.com/i/12/b9/e012f5148cb914d524e03ec45b405c23.jpg"},{"id":1681,"name":"高级枪械","text":"","imgUrl":"http://rs.0.gaoshouyou.com/i/b9/70/53b9b889087015962a1f7bbbd015131d.jpg"}]
     * post : []
     * userId : 0
     * package :
     * time : 0.017231941223145
     */

    private int code;
    private String msg;
    private int userId;
    @SerializedName("package")
    private String packageX;
    private double time;
    private ArrayList<ContentBean> content;
    private List<?> post;

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

    public List<?> getPost() {
        return post;
    }

    public void setPost(List<?> post) {
        this.post = post;
    }

    public static class ContentBean {
        /**
         * id : 1677
         * name : 全资源
         * text :
         * imgUrl : http://rs.0.gaoshouyou.com/i/3a/c9/153a472455c92b5e0b5dd6673d3feb9f.jpg
         */

        private int id;
        private String name;
        private String text;
        private String imgUrl;

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
    }
}
