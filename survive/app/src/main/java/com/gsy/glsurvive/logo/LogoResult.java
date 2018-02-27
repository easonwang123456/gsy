package com.gsy.glsurvive.logo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2018/1/15.
 */

public class LogoResult {

    /**
     * code : 200
     * msg : success
     * content : {"start":[{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/89/2f/9a89847e0f2fd17e782eed26b79e5f2d.png","title":"启动图","url":"http://www.gaoshouyou.com/youxiku/10938.html","jump":2,"id":0,"typeId":0,"type":0,"width":720,"height":288}],"update":[{"result":false}],"hots":[{"name":"荒野行动"},{"name":"吃鸡"}],"mode":true,"dingNum":0,"replyNum":0,"systemNum":0,"sixinNum":0,"active":0,"tagData":null}
     * post : []
     * userId : 0
     * package :
     * time : 0.016526937484741
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
         * start : [{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/89/2f/9a89847e0f2fd17e782eed26b79e5f2d.png","title":"启动图","url":"http://www.gaoshouyou.com/youxiku/10938.html","jump":2,"id":0,"typeId":0,"type":0,"width":720,"height":288}]
         * update : [{"result":false}]
         * hots : [{"name":"荒野行动"},{"name":"吃鸡"}]
         * mode : true
         * dingNum : 0
         * replyNum : 0
         * systemNum : 0
         * sixinNum : 0
         * active : 0
         * tagData : null
         */

        private boolean mode;
        private int dingNum;
        private int replyNum;
        private int systemNum;
        private int sixinNum;
        private int active;
        private Object tagData;
        private ArrayList<StartBean> start;
        private ArrayList<UpdateBean> update;
        private List<HotsBean> hots;

        public boolean isMode() {
            return mode;
        }

        public void setMode(boolean mode) {
            this.mode = mode;
        }

        public int getDingNum() {
            return dingNum;
        }

        public void setDingNum(int dingNum) {
            this.dingNum = dingNum;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public int getSystemNum() {
            return systemNum;
        }

        public void setSystemNum(int systemNum) {
            this.systemNum = systemNum;
        }

        public int getSixinNum() {
            return sixinNum;
        }

        public void setSixinNum(int sixinNum) {
            this.sixinNum = sixinNum;
        }

        public int getActive() {
            return active;
        }

        public void setActive(int active) {
            this.active = active;
        }

        public Object getTagData() {
            return tagData;
        }

        public void setTagData(Object tagData) {
            this.tagData = tagData;
        }

        public ArrayList<StartBean> getStart() {
            return start;
        }

        public void setStart(ArrayList<StartBean> start) {
            this.start = start;
        }

        public ArrayList<UpdateBean> getUpdate() {
            return update;
        }

        public void setUpdate(ArrayList<UpdateBean> update) {
            this.update = update;
        }

        public List<HotsBean> getHots() {
            return hots;
        }

        public void setHots(List<HotsBean> hots) {
            this.hots = hots;
        }

        public static class StartBean {
            @Override
            public String toString() {
                return "StartBean{" +
                        "item=" + item +
                        ", imgUrl='" + imgUrl + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        ", jump=" + jump +
                        ", id=" + id +
                        ", typeId=" + typeId +
                        ", type=" + type +
                        ", width=" + width +
                        ", height=" + height +
                        '}';
            }

            /**
             * item : 3
             * imgUrl : http://rs.0.gaoshouyou.com/i/89/2f/9a89847e0f2fd17e782eed26b79e5f2d.png
             * title : 启动图
             * url : http://www.gaoshouyou.com/youxiku/10938.html
             * jump : 2
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
             * result : false
             */

            private boolean result;
            private String title;
            private String description;
            private String version;
            private String downUrl;
            private boolean force;

            public boolean isForce() {
                return force;
            }

            public void setForce(boolean force) {
                this.force = force;
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

            public boolean isResult() {
                return result;
            }

            public void setResult(boolean result) {
                this.result = result;
            }
        }

        public static class HotsBean {
            /**
             * name : 荒野行动
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
