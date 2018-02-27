package com.gsy.glsurvive.firstpage_model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/14.
 */

public class FirstPageRecommandResult {

    /**
     * code : 200
     * msg : success
     * content : {"banner":[{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/aa/99/c8aac4947a99bdad2e52fb6fbff100a3.jpg","title":"新版血王宫","url":"70459","jump":4,"id":70459,"typeId":70459,"type":"1","width":720,"height":288},{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/79/e2/3679f351a9e2969d9d28cb14e27290bb.jpg","title":"黄忠实战教学","url":"70493","jump":4,"id":70493,"typeId":70493,"type":"1","width":720,"height":288},{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/5e/15/595efcac2215e9b3067ba3613ce7abe4.jpg","title":"S6上分英雄","url":"70211","jump":4,"id":70211,"typeId":70211,"type":"1","width":720,"height":288},{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/8e/af/a98e03e25cafda4c7f44e3145fc00517.jpg","title":"周免","url":"70760","jump":4,"id":70760,"typeId":70760,"type":"1","width":720,"height":288}],"menu":[{"imgUrl":"http://rs.0.gaoshouyou.com/i/ce/fa/b9cebfdaa6fa83b6cf7a5914d715f31f.png","title":"新手指南","url":"5694","jump":7,"id":5694,"type":0,"typeId":5694},{"imgUrl":"http://rs.0.gaoshouyou.com/i/89/8d/2f898eb5ab8ddcf777c8e6a6f1dfc3a9.png","title":"周免英雄","url":"1","jump":8,"id":1,"type":0,"typeId":1},{"imgUrl":"http://rs.0.gaoshouyou.com/i/fb/81/a0fbc2e3bf818153bcff2b05c2d11cd9.png","title":"独家礼包","url":"2","jump":8,"id":2,"type":0,"typeId":2},{"imgUrl":"http://rs.0.gaoshouyou.com/i/3a/01/c93ad6e5770101730856dfecb36290a1.png","title":"开服开测","url":"0","jump":7,"id":0,"type":0,"typeId":0}],"postData":[{"id":94010,"item":0,"name":"荒野行动毛瑟狙击枪实用性评测","type":1,"imgUrl":"","time":"2017-12-14","hits":"68","commentNum":"1","description":"毛瑟狙击枪在《荒野行动》中是一把远距离射击非常好用的武器，当然前提是有倍镜的情况下...下面小编就为大家带来毛瑟狙击枪实用性评测供大家参考。","dataType":1}]}
     * post : {"type":"0","typeId":"0","limit":"1"}
     * userId : 0
     * package :
     * time : 0.031246900558472
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
        private ArrayList<BannerBean> banner;
        private ArrayList<MenuBean> menu;
        private ArrayList<PostDataBean> postData;

        public ArrayList<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(ArrayList<BannerBean> banner) {
            this.banner = banner;
        }

        public ArrayList<MenuBean> getMenu() {
            return menu;
        }

        public void setMenu(ArrayList<MenuBean> menu) {
            this.menu = menu;
        }

        public ArrayList<PostDataBean> getPostData() {
            return postData;
        }

        public void setPostData(ArrayList<PostDataBean> postData) {
            this.postData = postData;
        }

        public static class BannerBean {
            /**
             * item : 3
             * imgUrl : http://rs.0.gaoshouyou.com/i/aa/99/c8aac4947a99bdad2e52fb6fbff100a3.jpg
             * title : 新版血王宫
             * url : 70459
             * jump : 4
             * id : 70459
             * typeId : 70459
             * type : 1
             * width : 720
             * height : 288
             */

            private int item;
            private String imgUrl;
            private String title;
            private String url;
            private int jump;
            private int id;
            private int typeId;
            private String type;
            private int width;
            private int height;

            public int getItem() {
                return item;
            }

            public void setItem(int item) {
                this.item = item;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getJump() {
                return jump;
            }

            public void setJump(int jump) {
                this.jump = jump;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            @Override
            public String toString() {
                return "BannerBean{" +
                        "item=" + item +
                        ", imgUrl='" + imgUrl + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        ", jump=" + jump +
                        ", id=" + id +
                        ", typeId=" + typeId +
                        ", type='" + type + '\'' +
                        ", width=" + width +
                        ", height=" + height +
                        '}';
            }
        }

        public static class MenuBean {
            /**
             * imgUrl : http://rs.0.gaoshouyou.com/i/ce/fa/b9cebfdaa6fa83b6cf7a5914d715f31f.png
             * title : 新手指南
             * url : 5694
             * jump : 7
             * id : 5694
             * type : 0
             * typeId : 5694
             */

            private String imgUrl;
            private String title;
            private String url;
            private int jump;
            private int id;
            private int type;
            private int typeId;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getJump() {
                return jump;
            }

            public void setJump(int jump) {
                this.jump = jump;
            }

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

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }
        }

        public static class PostDataBean {
            /**
             * id : 94010
             * item : 0
             * name : 荒野行动毛瑟狙击枪实用性评测
             * type : 1
             * imgUrl :
             * time : 2017-12-14
             * hits : 68
             * commentNum : 1
             * description : 毛瑟狙击枪在《荒野行动》中是一把远距离射击非常好用的武器，当然前提是有倍镜的情况下...下面小编就为大家带来毛瑟狙击枪实用性评测供大家参考。
             * dataType : 1
             */

            private int id;
            private int item;
            private String name;
            private int type;
            private String imgUrl;
            private String time;
            private String hits;
            private String commentNum;
            private String description;
            private int dataType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getDataType() {
                return dataType;
            }

            public void setDataType(int dataType) {
                this.dataType = dataType;
            }

            @Override
            public String toString() {
                return "PostDataBean{" +
                        "id=" + id +
                        ", item=" + item +
                        ", name='" + name + '\'' +
                        ", type=" + type +
                        ", imgUrl='" + imgUrl + '\'' +
                        ", time='" + time + '\'' +
                        ", hits='" + hits + '\'' +
                        ", commentNum='" + commentNum + '\'' +
                        ", description='" + description + '\'' +
                        ", dataType=" + dataType +
                        '}';
            }
        }
    }

    public static class PostBean {
        /**
         * type : 0
         * typeId : 0
         * limit : 1
         */

        private String type;
        private String typeId;
        private String limit;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }
    }
}
