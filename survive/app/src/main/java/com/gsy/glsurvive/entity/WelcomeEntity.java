package com.gsy.glsurvive.entity;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Created by TR-AND2 on 2017/12/6.
 */


public class WelcomeEntity {

    /**
     * code : 200
     * msg : success
     * content : {"start":[{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/06/a8/720678665ba8e364d2d8804ce00f8f81.png","title":"启动图","url":"","jump":0,"id":0,"typeId":0,"type":0,"width":720,"height":288}],"update":[{"result":true,"title":"紧急修复","description":"紧急修复，紧急修复，紧急修复","version":"1.3.1","downUrl":"http://rs.0.gaoshouyou.com/d/de/9b/68ded39e449b25670cb99c35e52e37ca.apk","force":false}],"hots":[{"name":"S8赛季"},{"name":"S9赛季上线时间"},{"name":"王者荣耀爆料"},{"name":"周免英雄"},{"name":"新英雄苏烈"}],"mode":true,"luckNum":44}
     * post : []
     * userId : 0
     * package :
     * time : 0.017263889312744
     */

    private int code;
    private String msg;
    private ContentBean content;
    private int userId;
    @SerializedName("package")
    private String packageX;
    private double time;
    private List<?> post;

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

    public List<?> getPost() {
        return post;
    }

    public void setPost(List<?> post) {
        this.post = post;
    }

    public static class ContentBean {
        /**
         * start : [{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/06/a8/720678665ba8e364d2d8804ce00f8f81.png","title":"启动图","url":"","jump":0,"id":0,"typeId":0,"type":0,"width":720,"height":288}]
         * update : [{"result":true,"title":"紧急修复","description":"紧急修复，紧急修复，紧急修复","version":"1.3.1","downUrl":"http://rs.0.gaoshouyou.com/d/de/9b/68ded39e449b25670cb99c35e52e37ca.apk","force":false}]
         * hots : [{"name":"S8赛季"},{"name":"S9赛季上线时间"},{"name":"王者荣耀爆料"},{"name":"周免英雄"},{"name":"新英雄苏烈"}]
         * mode : true
         * luckNum : 44
         */

        private boolean mode;
        private int luckNum;
        private List<StartBean> start;
        private List<UpdateBean> update;
        private List<HotsBean> hots;

        public boolean isMode() {
            return mode;
        }

        public void setMode(boolean mode) {
            this.mode = mode;
        }

        public int getLuckNum() {
            return luckNum;
        }

        public void setLuckNum(int luckNum) {
            this.luckNum = luckNum;
        }

        public List<StartBean> getStart() {
            return start;
        }

        public void setStart(List<StartBean> start) {
            this.start = start;
        }

        public List<UpdateBean> getUpdate() {
            return update;
        }

        public void setUpdate(List<UpdateBean> update) {
            this.update = update;
        }

        public List<HotsBean> getHots() {
            return hots;
        }

        public void setHots(List<HotsBean> hots) {
            this.hots = hots;
        }

        public static class StartBean {
            /**
             * item : 3
             * imgUrl : http://rs.0.gaoshouyou.com/i/06/a8/720678665ba8e364d2d8804ce00f8f81.png
             * title : 启动图
             * url :
             * jump : 0
             * id : 0
             * typeId : 0
             * type : 0
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
            private int type;
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

            public int getType() {
                return type;
            }

            public void setType(int type) {
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
        }

        public static class UpdateBean {
            /**
             * result : true
             * title : 紧急修复
             * description : 紧急修复，紧急修复，紧急修复
             * version : 1.3.1
             * downUrl : http://rs.0.gaoshouyou.com/d/de/9b/68ded39e449b25670cb99c35e52e37ca.apk
             * force : false
             */

            private boolean result;
            private String title;
            private String description;
            private String version;
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

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
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

        public static class HotsBean {
            /**
             * name : S8赛季
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
