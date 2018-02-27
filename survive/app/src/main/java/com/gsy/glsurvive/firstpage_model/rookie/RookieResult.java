package com.gsy.glsurvive.firstpage_model.rookie;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class RookieResult {
    /**
     * code : 200
     * msg : success
     * content : {"banner":[{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/9e/15/679e2f656515163b5bd3d9cfd8e11949.jpg","title":"新版血王宫","url":"70459","jump":4,"id":70459,"typeId":70459,"type":"1","width":720,"height":288},{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/79/e2/3679f351a9e2969d9d28cb14e27290bb.jpg","title":"黄忠实战教学","url":"70493","jump":4,"id":70493,"typeId":70493,"type":"1","width":720,"height":288},{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/5e/15/595efcac2215e9b3067ba3613ce7abe4.jpg","title":"S6上分英雄","url":"70211","jump":4,"id":70211,"typeId":70211,"type":"1","width":720,"height":288}],"menu":[{"imgUrl":"http://rs.0.gaoshouyou.com/i/ee/80/6ceed27a2d8096de4e34f8998c35fbc0.png","title":"新手","url":"5694","jump":7,"id":5694,"type":0,"typeId":5694},{"imgUrl":"http://rs.0.gaoshouyou.com/i/30/e1/f5301ecc26e1be62d7a0db8cf0106ce3.png","title":"铭文","url":"70196","jump":4,"id":70196,"type":"1","typeId":70196},{"imgUrl":"http://rs.0.gaoshouyou.com/i/ee/ca/d7ee641799cadfdabddca89a7540f40c.png","title":"阵容","url":"70211","jump":4,"id":70211,"type":"1","typeId":70211}],"hotData":[{"id":93974,"item":0,"name":"荒野行动狙击枪爆头技巧介绍","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/46/60/a246aff7ad60bc640ae63b6054cb221a.jpeg","time":"2017-12-14","hits":"98","commentNum":"1","description":"在《荒野行动》中，狙击枪无疑是最好的远程武器，不过有些新玩家掌握不好的话就会打不到人，那就非常的尴尬了~下面小编就为大家带来狙击枪爆头技巧，一起来看看吧！","dataType":1},{"id":93996,"item":0,"name":"荒野行动新手实用技巧分享","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/15/f6/6415e63f8cf6bd5b851d5f389a42690d.jpeg","time":"2017-12-14","hits":"95","commentNum":"0","description":"《荒野行动》作为最近非常火爆的吃鸡手游，自然有很多新手玩家加入，那么下面小编就为大家带来一些新手实用技巧，希望能够帮到大家~","dataType":1},{"id":94010,"item":0,"name":"荒野行动毛瑟狙击枪实用性评测","type":1,"imgUrl":"","time":"2017-12-14","hits":"78","commentNum":"1","description":"毛瑟狙击枪在《荒野行动》中是一把远距离射击非常好用的武器，当然前提是有倍镜的情况下...下面小编就为大家带来毛瑟狙击枪实用性评测供大家参考。","dataType":1}],"postData":[{"id":94010,"item":0,"name":"荒野行动毛瑟狙击枪实用性评测","type":1,"imgUrl":"","time":"2017-12-14","hits":"78","commentNum":"1","description":"毛瑟狙击枪在《荒野行动》中是一把远距离射击非常好用的武器，当然前提是有倍镜的情况下...下面小编就为大家带来毛瑟狙击枪实用性评测供大家参考。","dataType":1}]}
     * post : {"limit":"1","page":"1","typeId":"0","order":"1"}
     * userId : 0
     * package :
     * time : 0.024772882461548
     */

    private int code;
    private String msg;
    private RookieResult.ContentBean content;
    private RookieResult.PostBean post;
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

    public RookieResult.ContentBean getContent() {
        return content;
    }

    public void setContent(RookieResult.ContentBean content) {
        this.content = content;
    }

    public RookieResult.PostBean getPost() {
        return post;
    }

    public void setPost(RookieResult.PostBean post) {
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

        private ArrayList<RookieResult.ContentBean.PostDataBean> postData;

        public  ArrayList<RookieResult.ContentBean.PostDataBean> getPostData() {
            return postData;
        }

        public void setPostData( ArrayList<RookieResult.ContentBean.PostDataBean> postData) {
            this.postData = postData;
        }



        public static class PostDataBean {
            /**
             * id : 94010
             * item : 0
             * name : 荒野行动毛瑟狙击枪实用性评测
             * type : 1
             * imgUrl :
             * time : 2017-12-14
             * hits : 78
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
         * limit : 1
         * page : 1
         * typeId : 0
         * order : 1
         */

        private String limit;
        private String page;
        private String typeId;
        private String order;

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
