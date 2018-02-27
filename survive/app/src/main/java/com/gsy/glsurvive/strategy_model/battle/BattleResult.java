package com.gsy.glsurvive.strategy_model.battle;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class BattleResult {

    /**
     * code : 200
     * msg : success
     * content : [{"id":6480,"name":"滨海镇","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/8e/ce/5e8e517ba2ce579d0007901b6eb3cad7.png"},{"id":6481,"name":"采石场","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/b8/66/f3b86ae2d8667bff985a8fc02daa6897.png"},{"id":6482,"name":"灯塔城","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/f4/43/2ef4874b1543a110d2e41a91c948bae2.png"},{"id":6483,"name":"东港旧址","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/e6/b3/61e6953fccb3a543ec9e86c715811e9b.png"},{"id":6484,"name":"伐木场","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/32/5c/f232c8f0a65cb1c4f0e986382af9fd4e.png"},{"id":6485,"name":"废弃车站","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/e9/dd/4ce9d17a80dd8862259b657613ea5aff.png"},{"id":6486,"name":"海景山庄","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/e1/94/3de17ff59594822474c2b79e8b82f7f8.png"},{"id":6487,"name":"旧电厂","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/f4/4a/c5f428420a4a089f4a6d524efb664406.png"},{"id":6488,"name":"缆车区","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/59/52/50597fe44052681bd81549f3012e0a7e.png"},{"id":6489,"name":"老城","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/65/5c/d165a4f2b25c3c53cc0f2603c68b0bb7.png"},{"id":6490,"name":"雷达站","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/33/ee/e533740e41ee06a75c6f89c9bfd4231a.png"},{"id":6491,"name":"临海废墟","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/15/d4/3115f2aee0d46e3cbd483a501184155f.png"},{"id":6492,"name":"南郊城","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/51/69/3251ee245269a9a07acce92243b43856.png"},{"id":6493,"name":"湿地","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/f2/77/64f2e72e7c7704cb584fd1c0cb1163e1.png"},{"id":6494,"name":"西港","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/92/4f/2892ba6b504ff978a65d855d3dcfb489.png"},{"id":6495,"name":"中部主城","type":2,"imgUrl":"http://rs.0.gaoshouyou.com/i/d6/6a/57d641de526a33f5887dc3a038d5385b.png"}]
     * post : []
     * userId : 0
     * package :
     * time : 0.026324987411499
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
         * id : 6480
         * name : 滨海镇
         * type : 2
         * imgUrl : http://rs.0.gaoshouyou.com/i/8e/ce/5e8e517ba2ce579d0007901b6eb3cad7.png
         */

        private int id;
        private String name;
        private int type;
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

        @Override
        public String toString() {
            return "ContentBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", type=" + type +
                    ", imgUrl='" + imgUrl + '\'' +
                    '}';
        }
    }
}
