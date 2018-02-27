package com.gsy.glsurvive.firstpage_model.first_search;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class HotTopicResult {

    /**
     * code : 200
     * msg : success
     * content : {"start":[],"update":[{"result":false}],"hots":[{"name":"王者"},{"name":"荣耀"},{"name":"天天"},{"name":"攻略"},{"name":"每日一题"}],"mode":true,"ADsearch":{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/31/19/f531086b1319f9255633601cb98d3c04.jpg","title":"5","url":"http://www.gaoshouyou.com/luba","jump":1,"id":0,"typeId":0,"type":0,"width":720,"height":288},"ADziliao":{"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/31/19/f531086b1319f9255633601cb98d3c04.jpg","title":"5","url":"http://www.gaoshouyou.com/luba","jump":1,"id":0,"typeId":0,"type":0,"width":720,"height":288},"dingNum":0,"replyNum":0,"systemNum":0,"sixinNum":0,"active":0,"tagData":null}
     * post : []
     * userId : 0
     * package :
     * time : 0.021105051040649
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
         * start : []
         * update : [{"result":false}]
         * hots : [{"name":"王者"},{"name":"荣耀"},{"name":"天天"},{"name":"攻略"},{"name":"每日一题"}]
         * mode : true
         * ADsearch : {"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/31/19/f531086b1319f9255633601cb98d3c04.jpg","title":"5","url":"http://www.gaoshouyou.com/luba","jump":1,"id":0,"typeId":0,"type":0,"width":720,"height":288}
         * ADziliao : {"item":3,"imgUrl":"http://rs.0.gaoshouyou.com/i/31/19/f531086b1319f9255633601cb98d3c04.jpg","title":"5","url":"http://www.gaoshouyou.com/luba","jump":1,"id":0,"typeId":0,"type":0,"width":720,"height":288}
         * dingNum : 0
         * replyNum : 0
         * systemNum : 0
         * sixinNum : 0
         * active : 0
         * tagData : null
         */

        private boolean mode;
        private ADsearchBean ADsearch;
        private ADziliaoBean ADziliao;
        private int dingNum;
        private int replyNum;
        private int systemNum;
        private int sixinNum;
        private int active;
        private Object tagData;
        private List<?> start;
        private List<UpdateBean> update;
        private ArrayList<HotsBean> hots;

        public boolean isMode() {
            return mode;
        }

        public void setMode(boolean mode) {
            this.mode = mode;
        }

        public ADsearchBean getADsearch() {
            return ADsearch;
        }

        public void setADsearch(ADsearchBean ADsearch) {
            this.ADsearch = ADsearch;
        }

        public ADziliaoBean getADziliao() {
            return ADziliao;
        }

        public void setADziliao(ADziliaoBean ADziliao) {
            this.ADziliao = ADziliao;
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

        public List<?> getStart() {
            return start;
        }

        public void setStart(List<?> start) {
            this.start = start;
        }

        public List<UpdateBean> getUpdate() {
            return update;
        }

        public void setUpdate(List<UpdateBean> update) {
            this.update = update;
        }

        public ArrayList<HotsBean> getHots() {
            return hots;
        }

        public void setHots(ArrayList<HotsBean> hots) {
            this.hots = hots;
        }

        @Override
        public String toString() {
            return "ContentBean{" +
                    "mode=" + mode +
                    ", ADsearch=" + ADsearch +
                    ", ADziliao=" + ADziliao +
                    ", dingNum=" + dingNum +
                    ", replyNum=" + replyNum +
                    ", systemNum=" + systemNum +
                    ", sixinNum=" + sixinNum +
                    ", active=" + active +
                    ", tagData=" + tagData +
                    ", start=" + start +
                    ", update=" + update +
                    ", hots=" + hots +
                    '}';
        }

        public static class ADsearchBean {
            /**
             * item : 3
             * imgUrl : http://rs.0.gaoshouyou.com/i/31/19/f531086b1319f9255633601cb98d3c04.jpg
             * title : 5
             * url : http://www.gaoshouyou.com/luba
             * jump : 1
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

        public static class ADziliaoBean {
            /**
             * item : 3
             * imgUrl : http://rs.0.gaoshouyou.com/i/31/19/f531086b1319f9255633601cb98d3c04.jpg
             * title : 5
             * url : http://www.gaoshouyou.com/luba
             * jump : 1
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

            public boolean isResult() {
                return result;
            }

            public void setResult(boolean result) {
                this.result = result;
            }
        }

        public static class HotsBean {
            /**
             * name : 王者
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "HotsBean{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }
    }
}
