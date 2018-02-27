package com.gsy.glsurvive.mine_model.profile;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TR-AND2 on 2017/12/11.
 */

public class ProfileResult {

    /**
     * code : 200
     * msg : success
     * content : {"result":true,"message":"修改成功"}
     * post : {"nickName":"","sex":"保密","signature":"123","birthday":"2017-12-13","location":"四川省-成都市-成华区"}
     * userId : 38538
     * package :
     * time : 0.018209934234619
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
         * message : 修改成功
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

        @Override
        public String toString() {
            return "ContentBean{" +
                    "result=" + result +
                    ", message='" + message + '\'' +
                    '}';
        }
    }

    public static class PostBean {
        /**
         * nickName :
         * sex : 保密
         * signature : 123
         * birthday : 2017-12-13
         * location : 四川省-成都市-成华区
         */

        private String nickName;
        private String sex;
        private String signature;
        private String birthday;
        private String location;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
