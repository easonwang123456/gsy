package com.gsy.glsurvive.strategy_model.gun;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2017/12/26.
 */

public class GunResult {

    /**
     * code : 200
     * msg : success
     * content : [{"id":6465,"name":"AK-47","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/ec/0b/15ec36624e0b57fb62f7c8f40254abde.png"},{"id":6476,"name":"AWM","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/33/a1/f3334d2430a1ddab969d375770202a6e.png"},{"id":6468,"name":"M4A1","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/89/99/4789323d0c991d234ffb6179d1c319c7.png"},{"id":6475,"name":"M24","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/52/7a/ba52daa6817a6d1120343250f7035934.png"},{"id":6474,"name":"MK43","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/42/73/5742c3c6ed735d87cf45f5748bef45e6.png"},{"id":6469,"name":"M860","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/e2/86/bce21afcca86119dd194ae30abd9b7ab.png"},{"id":6478,"name":"毛瑟狙击枪","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/a6/f1/54a635b8b1f1df23535ed03a46e0818c.png"},{"id":6471,"name":"MK5","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/39/a6/5d3976020ea66f0fd2a14f5757819110.png"},{"id":6466,"name":"MK60","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/c5/97/3bc56f1b2697330fad934f539a77513c.png"},{"id":6473,"name":"MP5","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/27/59/57272c95bb5979c1ac500e6360653de2.png"},{"id":6467,"name":"S-ACR","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/7b/1d/6c7b10cbb31d680b619ff5a0bd1b9d10.png"},{"id":6470,"name":"SK12","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/ed/54/ffedfa3a93547406cc8640ea25b60776.png"},{"id":6477,"name":"S-TRG","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/79/75/ff79e3f90675ca4ee1c56623120eb4f4.png"},{"id":6472,"name":"UZI","type":1,"imgUrl":"http://rs.0.gaoshouyou.com/i/68/f4/f46846967df42abf965a2526ec4c18c7.png"}]
     * post : []
     * userId : 0
     * package :
     * time : 0.020026922225952
     */

    private int code;
    private String msg;
    private int userId;
    @SerializedName("package")
    private String packageX;
    private double time;
    private ArrayList<ContentBean> content;
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

    public List<?> getPost() {
        return post;
    }

    public void setPost(List<?> post) {
        this.post = post;
    }

    public static class ContentBean {
        /**
         * id : 6465
         * name : AK-47
         * type : 1
         * imgUrl : http://rs.0.gaoshouyou.com/i/ec/0b/15ec36624e0b57fb62f7c8f40254abde.png
         */

        private int id;
        private String name;
        private int type;
        private String imgUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
    }
}
