package com.gsy.glsurvive.mine_model.register;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TR-AND2 on 2017/12/7.
 */

public class RegisterCodeResult {


    /**
     * code : 200
     * msg : success
     * content : {"result":false,"message":"今天短信发送已达上限"}
     * post : {"userName":"15968125724","codeType":"1"}
     * userId : 0
     * package :
     * time : 0.01739501953125
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

    @Override
    public String toString() {
        return "RegisterCodeResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                ", post=" + post +
                ", userId=" + userId +
                ", packageX='" + packageX + '\'' +
                ", time=" + time +
                '}';
    }

    public static class ContentBean {
        /**
         * result : false
         * message : 今天短信发送已达上限
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
         * userName : 15968125724
         * codeType : 1
         */

        private String userName;
        private String codeType;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getCodeType() {
            return codeType;
        }

        public void setCodeType(String codeType) {
            this.codeType = codeType;
        }

        @Override
        public String toString() {
            return "PostBean{" +
                    "userName='" + userName + '\'' +
                    ", codeType='" + codeType + '\'' +
                    '}';
        }
    }
}
