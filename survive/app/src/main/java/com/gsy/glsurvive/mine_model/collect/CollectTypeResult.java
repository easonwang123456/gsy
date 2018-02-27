package com.gsy.glsurvive.mine_model.collect;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2018/1/4.
 */

public class CollectTypeResult {

    /**
     * code : 200
     * msg : success
     * content : [{"type":0,"typeName":"全部","typeNum":1},{"type":1,"typeName":"攻略","typeNum":"1"},{"type":2,"typeName":"活动","typeNum":0},{"type":5772,"typeName":"赛事","typeNum":0},{"type":5,"typeName":"新闻","typeNum":0},{"type":13,"typeName":"视频","typeNum":0}]
     * post : []
     * userId : 4756
     * package :
     * time : 0.020992994308472
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
        @Override
        public String toString() {
            return "ContentBean{" +
                    "type=" + type +
                    ", typeName='" + typeName + '\'' +
                    ", typeNum=" + typeNum +
                    '}';
        }

        /**
         * type : 0
         * typeName : 全部
         * typeNum : 1
         */

        private int type;
        private String typeName;
        private int typeNum;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getTypeNum() {
            return typeNum;
        }

        public void setTypeNum(int typeNum) {
            this.typeNum = typeNum;
        }
    }
}
