package com.gsy.glsurvive.firstpage_model.video.video_detail;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/2.
 */

public class VideoDetailResult {

    /**
     * code : 200
     * msg : success
     * content : {"id":399,"type":13,"name":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第3场","imgUrl":"http://rs.0.gaoshouyou.com/i/ac/e4/69accd9a8fe438936b5aecb471705507.jpg","description":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第3场","source":"http://www.gaoshouyou.com/vid/b/2/b60065049c277fdbf6b19af6e5ec61f3.mp4","time":"2017-04-12 16:00","commentNum":"0","dingNum":"0","status":false,"collectId":0,"author":"糖兔子","authorUrl":"http://static.gaoshouyou.com/i/de/48/2ede8486dd48e178f5ae73230b8d42f5.jpg","otherData":[{"id":398,"item":0,"name":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第2场","type":13,"imgUrl":"http://rs.0.gaoshouyou.com/i/cb/bc/d9cba3ced6bc574be0137cb0912437d9.jpg","time":"2017-04-12","hits":"17","commentNum":"0","description":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第2场","status":false,"dingNum":"0","source":"http://www.gaoshouyou.com/vid/f/4/f945018abc45077984f000b770d9491e.mp4","dataType":0},{"id":397,"item":0,"name":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第1场","type":13,"imgUrl":"http://rs.0.gaoshouyou.com/i/05/a1/f305dcaef3a1ce32677f488e4c6b540a.jpg","time":"2017-04-12","hits":"9","commentNum":"0","description":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第1场","status":false,"dingNum":"0","source":"http://www.gaoshouyou.com/vid/5/c/5de0cc1828c26960f49b1fa357acda0a.mp4","dataType":0},{"id":396,"item":0,"name":"【KPL】2017KPL春季赛第3周 AG超玩会 2-1 sViper 第2场","type":13,"imgUrl":"http://rs.0.gaoshouyou.com/i/f3/fd/eff345de88fd43d09952cd40ae9c219c.jpg","time":"2017-04-12","hits":"31","commentNum":"0","description":"【KPL】2017KPL春季赛第3周 AG超玩会 2-1 sViper 第2场","status":false,"dingNum":"0","source":"http://ugcbsy.qq.com/flv/221/15/k039179gbsk.mp4?vkey=816233DCC2B08A3C4EFB956CB3788633A6FAF844EF495233A34B894AB4A0EB2144FD9C374D891A6CF41F547DC6275EC0B1D35F96571382EFD1AB6F29E1B3BFDCFE6CC706CD3A63BEA11D47B0AE71BE7448B1771DC4AA025D8E274A27AB10083CEC92A67E45B363BB","dataType":0}]}
     * post : {"id":"399"}
     * userId : 0
     * package :
     * time : 0.25960993766785
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
        @Override
        public String toString() {
            return "ContentBean{" +
                    "id=" + id +
                    ", type=" + type +
                    ", name='" + name + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", description='" + description + '\'' +
                    ", source='" + source + '\'' +
                    ", time='" + time + '\'' +
                    ", commentNum='" + commentNum + '\'' +
                    ", dingNum='" + dingNum + '\'' +
                    ", status=" + status +
                    ", collectId=" + collectId +
                    ", author='" + author + '\'' +
                    ", authorUrl='" + authorUrl + '\'' +
                    ", otherData=" + otherData +
                    '}';
        }

        /**
         * id : 399
         * type : 13
         * name : 【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第3场
         * imgUrl : http://rs.0.gaoshouyou.com/i/ac/e4/69accd9a8fe438936b5aecb471705507.jpg
         * description : 【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第3场
         * source : http://www.gaoshouyou.com/vid/b/2/b60065049c277fdbf6b19af6e5ec61f3.mp4
         * time : 2017-04-12 16:00
         * commentNum : 0
         * dingNum : 0
         * status : false
         * collectId : 0
         * author : 糖兔子
         * authorUrl : http://static.gaoshouyou.com/i/de/48/2ede8486dd48e178f5ae73230b8d42f5.jpg
         * otherData : [{"id":398,"item":0,"name":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第2场","type":13,"imgUrl":"http://rs.0.gaoshouyou.com/i/cb/bc/d9cba3ced6bc574be0137cb0912437d9.jpg","time":"2017-04-12","hits":"17","commentNum":"0","description":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第2场","status":false,"dingNum":"0","source":"http://www.gaoshouyou.com/vid/f/4/f945018abc45077984f000b770d9491e.mp4","dataType":0},{"id":397,"item":0,"name":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第1场","type":13,"imgUrl":"http://rs.0.gaoshouyou.com/i/05/a1/f305dcaef3a1ce32677f488e4c6b540a.jpg","time":"2017-04-12","hits":"9","commentNum":"0","description":"【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第1场","status":false,"dingNum":"0","source":"http://www.gaoshouyou.com/vid/5/c/5de0cc1828c26960f49b1fa357acda0a.mp4","dataType":0},{"id":396,"item":0,"name":"【KPL】2017KPL春季赛第3周 AG超玩会 2-1 sViper 第2场","type":13,"imgUrl":"http://rs.0.gaoshouyou.com/i/f3/fd/eff345de88fd43d09952cd40ae9c219c.jpg","time":"2017-04-12","hits":"31","commentNum":"0","description":"【KPL】2017KPL春季赛第3周 AG超玩会 2-1 sViper 第2场","status":false,"dingNum":"0","source":"http://ugcbsy.qq.com/flv/221/15/k039179gbsk.mp4?vkey=816233DCC2B08A3C4EFB956CB3788633A6FAF844EF495233A34B894AB4A0EB2144FD9C374D891A6CF41F547DC6275EC0B1D35F96571382EFD1AB6F29E1B3BFDCFE6CC706CD3A63BEA11D47B0AE71BE7448B1771DC4AA025D8E274A27AB10083CEC92A67E45B363BB","dataType":0}]
         */

        private int id;
        private int type;
        private String name;
        private String imgUrl;
        private String description;
        private String source;
        private String time;
        private String commentNum;
        private String dingNum;
        private boolean status;
        private int collectId;
        private String author;
        private String authorUrl;
        private ArrayList<OtherDataBean> otherData;

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

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
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

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public int getCollectId() {
            return collectId;
        }

        public void setCollectId(int collectId) {
            this.collectId = collectId;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthorUrl() {
            return authorUrl;
        }

        public void setAuthorUrl(String authorUrl) {
            this.authorUrl = authorUrl;
        }

        public ArrayList<OtherDataBean> getOtherData() {
            return otherData;
        }

        public void setOtherData(ArrayList<OtherDataBean> otherData) {
            this.otherData = otherData;
        }

        public static class OtherDataBean {
            @Override
            public String toString() {
                return "OtherDataBean{" +
                        "id=" + id +
                        ", item=" + item +
                        ", name='" + name + '\'' +
                        ", type=" + type +
                        ", imgUrl='" + imgUrl + '\'' +
                        ", time='" + time + '\'' +
                        ", hits='" + hits + '\'' +
                        ", commentNum='" + commentNum + '\'' +
                        ", description='" + description + '\'' +
                        ", status=" + status +
                        ", dingNum='" + dingNum + '\'' +
                        ", source='" + source + '\'' +
                        ", dataType=" + dataType +
                        '}';
            }

            /**
             * id : 398
             * item : 0
             * name : 【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第2场
             * type : 13
             * imgUrl : http://rs.0.gaoshouyou.com/i/cb/bc/d9cba3ced6bc574be0137cb0912437d9.jpg
             * time : 2017-04-12
             * hits : 17
             * commentNum : 0
             * description : 【KPL】2017KPL春季赛第3周 eStar 2-1 YTG 第2场
             * status : false
             * dingNum : 0
             * source : http://www.gaoshouyou.com/vid/f/4/f945018abc45077984f000b770d9491e.mp4
             * dataType : 0
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
            private boolean status;
            private String dingNum;
            private String source;
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

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }

            public String getDingNum() {
                return dingNum;
            }

            public void setDingNum(String dingNum) {
                this.dingNum = dingNum;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public int getDataType() {
                return dataType;
            }

            public void setDataType(int dataType) {
                this.dataType = dataType;
            }
        }
    }

    public static class PostBean {
        /**
         * id : 399
         */

        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
