package com.gsy.glsurvive.firstpage_model.gun;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2018/2/2.
 */

public class GunTypeResult {

    /**
     * code : 200
     * msg : success
     * content : [{"typeId":0,"name":"全部"},{"typeId":1,"name":"突击步枪"},{"typeId":2,"name":"狙击步枪"},{"typeId":3,"name":"霰弹枪"},{"typeId":4,"name":"冲锋枪"},{"typeId":5,"name":"手枪"},{"typeId":6,"name":"机枪"},{"typeId":7,"name":"弩"},{"typeId":8,"name":"近战"},{"typeId":9,"name":"投掷武器"}]
     * post : []
     * userId : 0
     * package :
     * time : 0.014310121536255
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
         * typeId : 0
         * name : 全部
         */

        private int typeId;
        private String name;

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
