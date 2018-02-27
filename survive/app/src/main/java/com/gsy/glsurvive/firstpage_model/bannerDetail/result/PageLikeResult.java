package com.gsy.glsurvive.firstpage_model.bannerDetail.result;

/**
 * Created by TR-AND2 on 2017/12/29.
 */

public class PageLikeResult {

    /**
     * code : 200
     * msg : success
     * content : {"result":false,"message":"已经点过赞了"}
     */

    private int code;
    private String msg;
    private ContentBean content;

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

    public static class ContentBean {
        /**
         * result : false
         * message : 已经点过赞了
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
}
