package com.gsy.glsurvive.firstpage_model.gun.gun_detail;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/2/5.
 */

public class GunDetailResult {

    /**
     * code : 200
     * msg : success
     * content : {"id":1683,"type":1,"typeId":2,"name":"AWM","imgUrl":"http://rs.0.gaoshouyou.com/i/b8/81/3bb8cb02508110f6ff1486afbd5989b6.png","wqwl":"120","wqsc":"100","wqwd":"34","wqss":"6","duibi":[{"st0":1,"st1":2,"st2":2,"st3":2,"tb0":1,"tb1":1,"tb2":1,"tb3":2,"name":"AWM"},{"st0":2,"st1":2,"st2":2,"st3":3,"tb0":1,"tb1":1,"tb2":1,"tb3":2,"name":"M24"},{"st0":2,"st1":2,"st2":3,"st3":0,"tb0":1,"tb1":1,"tb2":1,"tb3":2,"name":"Kar98k"}],"sjsh":"132","sjcs":"910","sjhz":"1.30","sjrl":"5","sjjg":"1.800s","sjjl":"100-1000","sjfs":"自动","sjms":"单发","sjsj":"4.200s","peijian":[{"id":1629,"type":2,"typeId":1,"name":"狙击枪消音器","imgUrl":"http://rs.0.gaoshouyou.com/i/4e/5e/994e26d3fc5ecfc8be516a1cd27aec45.png"},{"id":1638,"type":2,"typeId":2,"name":"8倍CQBSS瞄准镜","imgUrl":"http://rs.0.gaoshouyou.com/i/95/92/e09562dbe292dff7502fe97ed59a69ea.png"},{"id":1651,"type":2,"typeId":5,"name":"狙击枪快速扩容弹夹","imgUrl":"http://rs.0.gaoshouyou.com/i/be/09/0dbe9e10da09eb78e850b644f1f997e4.png"},{"id":1656,"type":2,"typeId":5,"name":"狙击枪托腮板","imgUrl":"http://rs.0.gaoshouyou.com/i/f3/28/47f3f2e5f728888828b22d636efed213.png"}]}
     * post : {"id":"1683"}
     * userId : 0
     * package :
     * time : 0.018045902252197
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
        /**
         * id : 1683
         * type : 1
         * typeId : 2
         * name : AWM
         * imgUrl : http://rs.0.gaoshouyou.com/i/b8/81/3bb8cb02508110f6ff1486afbd5989b6.png
         * wqwl : 120
         * wqsc : 100
         * wqwd : 34
         * wqss : 6
         * duibi : [{"st0":1,"st1":2,"st2":2,"st3":2,"tb0":1,"tb1":1,"tb2":1,"tb3":2,"name":"AWM"},{"st0":2,"st1":2,"st2":2,"st3":3,"tb0":1,"tb1":1,"tb2":1,"tb3":2,"name":"M24"},{"st0":2,"st1":2,"st2":3,"st3":0,"tb0":1,"tb1":1,"tb2":1,"tb3":2,"name":"Kar98k"}]
         * sjsh : 132
         * sjcs : 910
         * sjhz : 1.30
         * sjrl : 5
         * sjjg : 1.800s
         * sjjl : 100-1000
         * sjfs : 自动
         * sjms : 单发
         * sjsj : 4.200s
         * peijian : [{"id":1629,"type":2,"typeId":1,"name":"狙击枪消音器","imgUrl":"http://rs.0.gaoshouyou.com/i/4e/5e/994e26d3fc5ecfc8be516a1cd27aec45.png"},{"id":1638,"type":2,"typeId":2,"name":"8倍CQBSS瞄准镜","imgUrl":"http://rs.0.gaoshouyou.com/i/95/92/e09562dbe292dff7502fe97ed59a69ea.png"},{"id":1651,"type":2,"typeId":5,"name":"狙击枪快速扩容弹夹","imgUrl":"http://rs.0.gaoshouyou.com/i/be/09/0dbe9e10da09eb78e850b644f1f997e4.png"},{"id":1656,"type":2,"typeId":5,"name":"狙击枪托腮板","imgUrl":"http://rs.0.gaoshouyou.com/i/f3/28/47f3f2e5f728888828b22d636efed213.png"}]
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
        private String sjsh;
        private String sjcs;
        private String sjhz;
        private String sjrl;
        private String sjjg;
        private String sjjl;
        private String sjfs;
        private String sjms;
        private String sjsj;
        private ArrayList<DuibiBean> duibi;
        private ArrayList<PeijianBean> peijian;

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

        public String getSjsh() {
            return sjsh;
        }

        public void setSjsh(String sjsh) {
            this.sjsh = sjsh;
        }

        public String getSjcs() {
            return sjcs;
        }

        public void setSjcs(String sjcs) {
            this.sjcs = sjcs;
        }

        public String getSjhz() {
            return sjhz;
        }

        public void setSjhz(String sjhz) {
            this.sjhz = sjhz;
        }

        public String getSjrl() {
            return sjrl;
        }

        public void setSjrl(String sjrl) {
            this.sjrl = sjrl;
        }

        public String getSjjg() {
            return sjjg;
        }

        public void setSjjg(String sjjg) {
            this.sjjg = sjjg;
        }

        public String getSjjl() {
            return sjjl;
        }

        public void setSjjl(String sjjl) {
            this.sjjl = sjjl;
        }

        public String getSjfs() {
            return sjfs;
        }

        public void setSjfs(String sjfs) {
            this.sjfs = sjfs;
        }

        public String getSjms() {
            return sjms;
        }

        public void setSjms(String sjms) {
            this.sjms = sjms;
        }

        public String getSjsj() {
            return sjsj;
        }

        public void setSjsj(String sjsj) {
            this.sjsj = sjsj;
        }

        public ArrayList<DuibiBean> getDuibi() {
            return duibi;
        }

        public void setDuibi(ArrayList<DuibiBean> duibi) {
            this.duibi = duibi;
        }

        public ArrayList<PeijianBean> getPeijian() {
            return peijian;
        }

        public void setPeijian(ArrayList<PeijianBean> peijian) {
            this.peijian = peijian;
        }

        public static class DuibiBean {
            /**
             * st0 : 1
             * st1 : 2
             * st2 : 2
             * st3 : 2
             * tb0 : 1
             * tb1 : 1
             * tb2 : 1
             * tb3 : 2
             * name : AWM
             */

            private int st0;
            private int st1;
            private int st2;
            private int st3;
            private int tb0;
            private int tb1;
            private int tb2;
            private int tb3;
            private String name;

            public int getSt0() {
                return st0;
            }

            public void setSt0(int st0) {
                this.st0 = st0;
            }

            public int getSt1() {
                return st1;
            }

            public void setSt1(int st1) {
                this.st1 = st1;
            }

            public int getSt2() {
                return st2;
            }

            public void setSt2(int st2) {
                this.st2 = st2;
            }

            public int getSt3() {
                return st3;
            }

            public void setSt3(int st3) {
                this.st3 = st3;
            }

            public int getTb0() {
                return tb0;
            }

            public void setTb0(int tb0) {
                this.tb0 = tb0;
            }

            public int getTb1() {
                return tb1;
            }

            public void setTb1(int tb1) {
                this.tb1 = tb1;
            }

            public int getTb2() {
                return tb2;
            }

            public void setTb2(int tb2) {
                this.tb2 = tb2;
            }

            public int getTb3() {
                return tb3;
            }

            public void setTb3(int tb3) {
                this.tb3 = tb3;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class PeijianBean {
            /**
             * id : 1629
             * type : 2
             * typeId : 1
             * name : 狙击枪消音器
             * imgUrl : http://rs.0.gaoshouyou.com/i/4e/5e/994e26d3fc5ecfc8be516a1cd27aec45.png
             */

            private int id;
            private int type;
            private int typeId;
            private String name;
            private String imgUrl;

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
        }
    }

    public static class PostBean {
        /**
         * id : 1683
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
