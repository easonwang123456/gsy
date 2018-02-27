package com.gsy.glsurvive.firstpage_model.gun;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2018/2/2.
 */

public class FirstGunListResult {

    /**
     * code : 200
     * msg : success
     * content : [{"id":1682,"type":1,"typeId":1,"name":"AKM","imgUrl":"http://rs.0.gaoshouyou.com/i/eb/4f/7cebcb3c484f66b7e117513435c81be0.png","wqwl":"49","wqsc":"60","wqwd":"34","wqss":"61"},{"id":1683,"type":1,"typeId":2,"name":"AWM","imgUrl":"http://rs.0.gaoshouyou.com/i/bf/cf/b1bfe5cb43cf18b3710d1d72e8438094.png","wqwl":"120","wqsc":"100","wqwd":"34","wqss":"6"},{"id":1684,"type":1,"typeId":1,"name":"M416","imgUrl":"http://rs.0.gaoshouyou.com/i/cb/3b/bacb089d153b71947694bbc19310de05.png","wqwl":"44","wqsc":"57","wqwd":"32","wqss":"78"},{"id":1685,"type":1,"typeId":2,"name":"M24","imgUrl":"http://rs.0.gaoshouyou.com/i/1f/0c/271fa8fa820cb35d1a8fb78f6b1e99d1.png","wqwl":"88","wqsc":"96","wqwd":"32","wqss":"6"},{"id":1686,"type":1,"typeId":6,"name":"M249","imgUrl":"http://rs.0.gaoshouyou.com/i/66/6f/5766b97dda6fa33a85f192bb720a7a58.png","wqwl":"44","wqsc":"70","wqwd":"44","wqss":"77"},{"id":1687,"type":1,"typeId":1,"name":"SCAR-L","imgUrl":"http://rs.0.gaoshouyou.com/i/30/14/7a30e9453d14f0f00a0af62247b610d1.png","wqwl":"44","wqsc":"55","wqwd":"31","wqss":"71"},{"id":1688,"type":1,"typeId":3,"name":"S12k","imgUrl":"http://rs.0.gaoshouyou.com/i/5d/d4/4e5d7c027ed46bd4b8c1db909f5ff18f.png","wqwl":"22","wqsc":"9","wqwd":"86","wqss":"15"},{"id":1689,"type":1,"typeId":4,"name":"UZI","imgUrl":"http://rs.0.gaoshouyou.com/i/14/c9/5314708a2cc98952a7d28ae16ef0f3e8.png","wqwl":"23","wqsc":"22","wqwd":"31","wqss":"70"},{"id":1690,"type":1,"typeId":2,"name":"Kar98k","imgUrl":"http://rs.0.gaoshouyou.com/i/de/2c/d1dee1b8e92c875a1ed7c9536a08c281.png","wqwl":"75","wqsc":"79","wqwd":"34","wqss":"4"}]
     * post : {"typeId":"0"}
     * userId : 0
     * package :
     * time : 0.018700122833252
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
         */

        private String typeId;

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }
    }

    public static class ContentBean {
        /**
         * id : 1682
         * type : 1
         * typeId : 1
         * name : AKM
         * imgUrl : http://rs.0.gaoshouyou.com/i/eb/4f/7cebcb3c484f66b7e117513435c81be0.png
         * wqwl : 49
         * wqsc : 60
         * wqwd : 34
         * wqss : 61
         */

        private int id;
        private int type;
        private int typeId;
        private String name;
        private String imgUrl;
        private String wqwl;
        private String wqsc;
        private String wqwd;
        private String wqss;

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

        public String getWqwl() {
            return wqwl;
        }

        public void setWqwl(String wqwl) {
            this.wqwl = wqwl;
        }

        public String getWqsc() {
            return wqsc;
        }

        public void setWqsc(String wqsc) {
            this.wqsc = wqsc;
        }

        public String getWqwd() {
            return wqwd;
        }

        public void setWqwd(String wqwd) {
            this.wqwd = wqwd;
        }

        public String getWqss() {
            return wqss;
        }

        public void setWqss(String wqss) {
            this.wqss = wqss;
        }
    }
}
