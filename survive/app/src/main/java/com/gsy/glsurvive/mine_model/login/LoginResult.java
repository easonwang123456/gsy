package com.gsy.glsurvive.mine_model.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TR-AND2 on 2017/12/8.
 */

public class LoginResult {

    /**
     * code : 200
     * msg : success
     * content : {"result":true,"message":"登录成功","userId":38538,"nickName":"gsy-1512616670","imgUrl":"http://www.gaoshouyou.com/static/images/touxiang/default.jpg","signature":"123","money":"0.00"}
     * post : {"userName":"13881875273","passWord":"7c4a8d09ca3762af61e59520943dc26494f8941b"}
     * userId : 0
     * package :
     * time : 0.015698909759521
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
         * message : 登录成功
         * userId : 38538
         * nickName : gsy-1512616670
         * imgUrl : http://www.gaoshouyou.com/static/images/touxiang/default.jpg
         * signature : 123
         * money : 0.00
         */

        private boolean result;
        private String message;
        private int userId;
        private String nickName;
        private String imgUrl;
        private String signature;
        private String money;

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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        @Override
        public String toString() {
            return "ContentBean{" +
                    "result=" + result +
                    ", message='" + message + '\'' +
                    ", userId=" + userId +
                    ", nickName='" + nickName + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", signature='" + signature + '\'' +
                    ", money='" + money + '\'' +
                    '}';
        }
    }

    public static class PostBean {
        /**
         * userName : 13881875273
         * passWord : 7c4a8d09ca3762af61e59520943dc26494f8941b
         */

        private String userName;
        private String passWord;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }
    }
}
