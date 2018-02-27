package com.gsy.glsurvive.mine_model.collect;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class CollectDeleteResult {

    /**
     * code : 200
     * msg : success
     * content : {"result":true,"message":"取消收藏"}
     * post : {"collectId":"20705"}
     * userId : 38538
     * package :
     * time : 0.01695990562439
     */

    private int code;
    private String msg;
    private ContentBean content;
    private PostBean post;
    private int userId;
    @SerializedName("package")
    private String packageX;
    private double time;

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

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
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

    public static class ContentBean {
        /**
         * result : true
         * message : 取消收藏
         */

        private boolean result;
        private String message;

        public boolean isResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class PostBean {
        /**
         * collectId : 20705
         */

        private String collectId;

        public String getCollectId() {
            return collectId;
        }

        public void setCollectId(String collectId) {
            this.collectId = collectId;
        }
    }
}
