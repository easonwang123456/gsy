package com.gsy.glsurvive.mine_model.profile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by TR-AND2 on 2018/1/12.
 */

public class ImgUrlResult {

    /**
     * code : 200
     * msg : success
     * content : {"result":true,"message":"头像上传成功","imgUrl":"http://www.gaoshouyou.com/static/images/touxiang/6a87af35cdbf8c3055e4ecacce377889.png?ran=735"}
     * post : []
     * userId : 38538
     * package :
     * time : 0.024841785430908
     */

    private int code;
    private String msg;
    private ContentBean content;
    private int userId;
    @SerializedName("package")
    private String packageX;
    private double time;
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

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
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

    public List<?> getPost() {
        return post;
    }

    public void setPost(List<?> post) {
        this.post = post;
    }

    public static class ContentBean {
        /**
         * result : true
         * message : 头像上传成功
         * imgUrl : http://www.gaoshouyou.com/static/images/touxiang/6a87af35cdbf8c3055e4ecacce377889.png?ran=735
         */

        private boolean result;
        private String message;
        private String imgUrl;

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

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
