package com.gsy.glsurvive.firstpage_model.video;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class VideoListResult {

    /**
     * code : 200
     * msg : success
     * content : [{"id":399,"type":13,"item":0,"name":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第3场","imgUrl":"http://rs.0.gaoshouyou.com/i/ac/e4/69accd9a8fe438936b5aecb471705507.jpg","time":"2017-04-12","hits":"25","commentNum":"0","dingNum":"0","description":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第3场","source":"http://www.gaoshouyou.com/vid/b/2/b60065049c277fdbf6b19af6e5ec61f3.mp4","shareUrl":"http://m.gaoshouyou.com/video399.html","status":false}]
     * post : {"typeId":"0","id":"0","page":"1","limit":"1"}
     * userId : 0
     * package :
     * time : 0.038372993469238
     */

    private int code;
    private String msg;
    private PostBean post;
    private int userId;
    @SerializedName("package")
    private String packageX;
    private double time;
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

    public ArrayList<ContentBean> getContent() {
        return content;
    }

    public void setContent(ArrayList<ContentBean> content) {
        this.content = content;
    }

    public static class PostBean {
        /**
         * typeId : 0
         * id : 0
         * page : 1
         * limit : 1
         */

        private String typeId;
        private String id;
        private String page;
        private String limit;

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }
    }

    public static class ContentBean {
        /**
         * id : 399
         * type : 13
         * item : 0
         * name : 【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第3场
         * imgUrl : http://rs.0.gaoshouyou.com/i/ac/e4/69accd9a8fe438936b5aecb471705507.jpg
         * time : 2017-04-12
         * hits : 25
         * commentNum : 0
         * dingNum : 0
         * description : 【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第3场
         * source : http://www.gaoshouyou.com/vid/b/2/b60065049c277fdbf6b19af6e5ec61f3.mp4
         * shareUrl : http://m.gaoshouyou.com/video399.html
         * status : false
         */

        private int id;
        private int type;
        private int item;
        private String name;
        private String imgUrl;
        private String time;
        private String hits;
        private String commentNum;
        private String dingNum;
        private String description;
        private String source;
        private String shareUrl;
        private boolean status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getHits() {
            return hits;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public String getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(String commentNum) {
            this.commentNum = commentNum;
        }

        public String getDingNum() {
            return dingNum;
        }

        public void setDingNum(String dingNum) {
            this.dingNum = dingNum;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "ContentBean{" +
                    "id=" + id +
                    ", type=" + type +
                    ", item=" + item +
                    ", name='" + name + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", time='" + time + '\'' +
                    ", hits='" + hits + '\'' +
                    ", commentNum='" + commentNum + '\'' +
                    ", dingNum='" + dingNum + '\'' +
                    ", description='" + description + '\'' +
                    ", source='" + source + '\'' +
                    ", shareUrl='" + shareUrl + '\'' +
                    ", status=" + status +
                    '}';
        }
    }
}
