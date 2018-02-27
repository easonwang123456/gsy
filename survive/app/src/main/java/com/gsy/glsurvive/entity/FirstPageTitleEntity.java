package com.gsy.glsurvive.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2017/12/5.
 */

public class FirstPageTitleEntity {

    /**
     * code : 200
     * msg : success
     * content : [{"type":0,"name":"推荐"},{"type":1,"name":"最新"},{"type":2,"name":"活动"},{"type":13,"name":"视频"},{"type":5772,"name":"赛事"},{"type":5,"name":"新闻"}]
     * post : []
     * userId : 0
     * package :
     * time : 0.014621019363403
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
         * type : 0
         * name : 推荐
         */

        private int type;
        private String name;

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

        @Override
        public String toString() {
            return "ContentBean{" +
                    "type=" + type +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FirstPageTitleEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", userId=" + userId +
                ", packageX='" + packageX + '\'' +
                ", time=" + time +
                ", content=" + content +
                ", post=" + post +
                '}';
    }
}
