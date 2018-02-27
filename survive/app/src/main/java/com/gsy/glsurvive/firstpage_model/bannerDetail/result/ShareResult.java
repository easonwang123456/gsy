package com.gsy.glsurvive.firstpage_model.bannerDetail.result;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/3.
 */

public class ShareResult {

    /**
     * code : 200
     * msg : success
     * content : [{"shareType":1,"title":"标题","titleUrl":"http://","text":"2016-01-01","imgUrl":"http://","site":"123","siteUrl":"http://"}]
     */

    private int code;
    private String msg;
    private ArrayList<ContentBean> content;

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

    public ArrayList<ContentBean> getContent() {
        return content;
    }

    public void setContent(ArrayList<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * shareType : 1
         * title : 标题
         * titleUrl : http://
         * text : 2016-01-01
         * imgUrl : http://
         * site : 123
         * siteUrl : http://
         */

        private int shareType;
        private String title;
        private String titleUrl;
        private String text;
        private String imgUrl;
        private String site;
        private String siteUrl;

        public int getShareType() {
            return shareType;
        }

        public void setShareType(int shareType) {
            this.shareType = shareType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleUrl() {
            return titleUrl;
        }

        public void setTitleUrl(String titleUrl) {
            this.titleUrl = titleUrl;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getSiteUrl() {
            return siteUrl;
        }

        public void setSiteUrl(String siteUrl) {
            this.siteUrl = siteUrl;
        }
    }
}
