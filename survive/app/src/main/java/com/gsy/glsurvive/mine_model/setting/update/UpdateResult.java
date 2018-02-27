package com.gsy.glsurvive.mine_model.setting.update;

/**
 * Created by TR-AND2 on 2018/1/5.
 */

public class UpdateResult {

    /**
     * code : 200
     * msg : success
     * content : {"result":true,"title":"name","description":"介绍","downUrl":"http://","force":false}
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
        @Override
        public String toString() {
            return "ContentBean{" +
                    "result=" + result +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", downUrl='" + downUrl + '\'' +
                    ", force=" + force +
                    '}';
        }

        /**
         * result : true
         * title : name
         * description : 介绍
         * downUrl : http://
         * force : false
         */

        private boolean result;
        private String title;
        private String description;
        private String downUrl;
        private boolean force;

        public boolean isResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDownUrl() {
            return downUrl;
        }

        public void setDownUrl(String downUrl) {
            this.downUrl = downUrl;
        }

        public boolean isForce() {
            return force;
        }

        public void setForce(boolean force) {
            this.force = force;
        }
    }
}
