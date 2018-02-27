package com.gsy.glsurvive.firstpage_model.bannerDetail.result;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2017/12/28.
 */

public class CommentListResult {

    /**
     * code : 200
     * msg : success
     * content : [{"commentId":3626,"userId":30,"nickName":"LSM阿斯顿发射点反对司法","imgUrl":"http://www.gaoshouyou.com/h5_game/jicilang/jietu.jpg","text":"嗡嗡嗡嗡嗡嗡嗡嗡嗡[鄙视][傻眼][嘘][嘻嘻][月亮][下雨]顶顶顶顶顶顶顶顶","agreeNum":0,"status":false,"time":"2017-12-28","replyNum":2,"reply":[{"replyCommentId":3628,"replyUserId":0,"replyNickName":"内网IP网友.177","byUserId":30,"byNickName":"LSM阿斯顿发射点反对司法","replyText":"嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻详详细细[猪头][来][蜡烛][绿丝带][弱][委屈]","replyTime":"12-28 16:32","replyAgreeNum":"0","replyStatus":false,"replyMain":true,"publish":false},{"replyCommentId":3627,"replyUserId":30,"replyNickName":"LSM阿斯顿发射点反对司法","byUserId":30,"byNickName":"LSM阿斯顿发射点反对司法","replyText":"猜猜猜踩踩踩嚓嚓嚓成","replyTime":"12-28 16:31","replyAgreeNum":"0","replyStatus":false,"replyMain":true,"publish":false}],"publish":false},{"commentId":3623,"userId":0,"nickName":"内网IP网友.177","imgUrl":"http://test.gaoshouyou.com/static/images/touxiang/default.jpg","text":"[爱你][衰][衰][衰][晕][左哼哼][威武]","agreeNum":0,"status":false,"time":"2017-12-28","replyNum":3,"reply":[{"replyCommentId":3629,"replyUserId":0,"replyNickName":"内网IP网友.177","byUserId":30,"byNickName":"LSM阿斯顿发射点反对司法","replyText":"她她她她她她她她她她她她她她她她她她她","replyTime":"12-28 16:33","replyAgreeNum":"0","replyStatus":false,"replyMain":false,"publish":false},{"replyCommentId":3625,"replyUserId":30,"replyNickName":"LSM阿斯顿发射点反对司法","byUserId":0,"byNickName":"内网IP网友.177","replyText":"钱钱钱钱钱钱钱钱钱钱钱钱","replyTime":"12-28 16:29","replyAgreeNum":"0","replyStatus":false,"replyMain":false,"publish":false},{"replyCommentId":3624,"replyUserId":0,"replyNickName":"内网IP网友.177","byUserId":0,"byNickName":"内网IP网友.177","replyText":"啊啊啊啊啊啊啊啊啊","replyTime":"12-28 16:28","replyAgreeNum":"0","replyStatus":false,"replyMain":true,"publish":false}],"publish":false}]
     */

    private int code;
    private String msg;
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

    public ArrayList<ContentBean> getContent() {
        return content;
    }

    public void setContent(ArrayList<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {


        /**
         * commentId : 3626
         * userId : 30
         * nickName : LSM阿斯顿发射点反对司法
         * imgUrl : http://www.gaoshouyou.com/h5_game/jicilang/jietu.jpg
         * text : 嗡嗡嗡嗡嗡嗡嗡嗡嗡[鄙视][傻眼][嘘][嘻嘻][月亮][下雨]顶顶顶顶顶顶顶顶
         * agreeNum : 0
         * status : false
         * time : 2017-12-28
         * replyNum : 2
         * reply : [{"replyCommentId":3628,"replyUserId":0,"replyNickName":"内网IP网友.177","byUserId":30,"byNickName":"LSM阿斯顿发射点反对司法","replyText":"嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻详详细细[猪头][来][蜡烛][绿丝带][弱][委屈]","replyTime":"12-28 16:32","replyAgreeNum":"0","replyStatus":false,"replyMain":true,"publish":false},{"replyCommentId":3627,"replyUserId":30,"replyNickName":"LSM阿斯顿发射点反对司法","byUserId":30,"byNickName":"LSM阿斯顿发射点反对司法","replyText":"猜猜猜踩踩踩嚓嚓嚓成","replyTime":"12-28 16:31","replyAgreeNum":"0","replyStatus":false,"replyMain":true,"publish":false}]
         * publish : false
         */

        private int commentId;
        private int userId;
        private String nickName;
        private String imgUrl;
        private String text;
        private int agreeNum;
        private boolean status;
        private String time;
        private int replyNum;
        private boolean publish;
        private ArrayList<ReplyBean> reply;

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getAgreeNum() {
            return agreeNum;
        }

        public void setAgreeNum(int agreeNum) {
            this.agreeNum = agreeNum;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public boolean isPublish() {
            return publish;
        }

        public void setPublish(boolean publish) {
            this.publish = publish;
        }

        public ArrayList<ReplyBean> getReply() {
            return reply;
        }

        public void setReply(ArrayList<ReplyBean> reply) {
            this.reply = reply;
        }

        public static class ReplyBean {
            /**
             * replyCommentId : 3628
             * replyUserId : 0
             * replyNickName : 内网IP网友.177
             * byUserId : 30
             * byNickName : LSM阿斯顿发射点反对司法
             * replyText : 嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻详详细细[猪头][来][蜡烛][绿丝带][弱][委屈]
             * replyTime : 12-28 16:32
             * replyAgreeNum : 0
             * replyStatus : false
             * replyMain : true
             * publish : false
             */

            private int replyCommentId;
            private int replyUserId;
            private String replyNickName;
            private int byUserId;
            private String byNickName;
            private String replyText;
            private String replyTime;
            private String replyAgreeNum;
            private boolean replyStatus;
            private boolean replyMain;
            private boolean publish;

            public int getReplyCommentId() {
                return replyCommentId;
            }

            public void setReplyCommentId(int replyCommentId) {
                this.replyCommentId = replyCommentId;
            }

            public int getReplyUserId() {
                return replyUserId;
            }

            public void setReplyUserId(int replyUserId) {
                this.replyUserId = replyUserId;
            }

            public String getReplyNickName() {
                return replyNickName;
            }

            public void setReplyNickName(String replyNickName) {
                this.replyNickName = replyNickName;
            }

            public int getByUserId() {
                return byUserId;
            }

            public void setByUserId(int byUserId) {
                this.byUserId = byUserId;
            }

            public String getByNickName() {
                return byNickName;
            }

            public void setByNickName(String byNickName) {
                this.byNickName = byNickName;
            }

            public String getReplyText() {
                return replyText;
            }

            public void setReplyText(String replyText) {
                this.replyText = replyText;
            }

            public String getReplyTime() {
                return replyTime;
            }

            public void setReplyTime(String replyTime) {
                this.replyTime = replyTime;
            }

            public String getReplyAgreeNum() {
                return replyAgreeNum;
            }

            public void setReplyAgreeNum(String replyAgreeNum) {
                this.replyAgreeNum = replyAgreeNum;
            }

            public boolean isReplyStatus() {
                return replyStatus;
            }

            public void setReplyStatus(boolean replyStatus) {
                this.replyStatus = replyStatus;
            }

            public boolean isReplyMain() {
                return replyMain;
            }

            public void setReplyMain(boolean replyMain) {
                this.replyMain = replyMain;
            }

            public boolean isPublish() {
                return publish;
            }

            public void setPublish(boolean publish) {
                this.publish = publish;
            }

            @Override
            public String toString() {
                return "ReplyBean{" +
                        "replyCommentId=" + replyCommentId +
                        ", replyUserId=" + replyUserId +
                        ", replyNickName='" + replyNickName + '\'' +
                        ", byUserId=" + byUserId +
                        ", byNickName='" + byNickName + '\'' +
                        ", replyText='" + replyText + '\'' +
                        ", replyTime='" + replyTime + '\'' +
                        ", replyAgreeNum='" + replyAgreeNum + '\'' +
                        ", replyStatus=" + replyStatus +
                        ", replyMain=" + replyMain +
                        ", publish=" + publish +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ContentBean{" +
                    "commentId=" + commentId +
                    ", userId=" + userId +
                    ", nickName='" + nickName + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", text='" + text + '\'' +
                    ", agreeNum=" + agreeNum +
                    ", status=" + status +
                    ", time='" + time + '\'' +
                    ", replyNum=" + replyNum +
                    ", publish=" + publish +
                    ", reply=" + reply +
                    '}';
        }
    }
}
