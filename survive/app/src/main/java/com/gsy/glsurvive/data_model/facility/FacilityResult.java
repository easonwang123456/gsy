package com.gsy.glsurvive.data_model.facility;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR-AND2 on 2018/2/8.
 */

public class FacilityResult {

    /**
     * code : 200
     * msg : success
     * content : {"peijian":{"qk":[{"id":1620,"type":2,"typeId":1,"name":"扼流圈","text":"S1897,S686用扼流圈\n降低霰弹枪弹丸散射\n-18.20% 弹丸散射\n+15.40% 弹丸速度","imgUrl":"http://rs.0.gaoshouyou.com/i/79/ec/5c7975e9a0ecdd7f4539084a37c99870.png"},{"id":1621,"type":2,"typeId":1,"name":"步枪枪口补偿器","text":"AKM,M16A4,M416,SCAR-L ,S12K用枪口补偿器\n略微降低平行方向后坐力并且降低垂直方向后坐力\n-25.00% 后坐力效果\n-10.00% 平行方向后坐力\n-15.00% 垂直方向后坐力\n-10.00% 基础散射度","imgUrl":"http://rs.0.gaoshouyou.com/i/d6/7a/b0d6ffbb257a77ccae3d2511a0b9f6b0.png"},{"id":1622,"type":2,"typeId":1,"name":"冲锋枪枪口补偿器","text":"SMG用枪口补偿器\n略微降低平行方向后坐力并且降低垂直方向后坐力\n-25.00% 后坐力效果\n-20.00% 平行方向后坐力\n-25.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/d7/29/ded736c88429fbb385eab253e8d172d4.png"},{"id":1623,"type":2,"typeId":1,"name":"狙击枪枪口补偿器","text":"M24,AWM,SKS,Kar98K用枪口补偿器, Mk14, Mini14\n略微降低平行方向后坐力并且降低垂直方向后坐力\n-25.00% 后坐力效果\n-20.00% 平行方向后坐力\n-20.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/e0/46/18e00a852b465d757b210657260fd99a.png"},{"id":1624,"type":2,"typeId":1,"name":"步枪消焰器","text":"AKM,M16A4,M416,SCAR-L,S12K用消焰器\n消除枪口火焰,略微降低平行与垂直方向后坐力\n-10.00% 后坐力效果\n-10.00% 平行方向后坐力\n-10.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/5b/3c/335b732a1a3c02b4568406e6688702ee.png"},{"id":1625,"type":2,"typeId":1,"name":"狙击枪消焰器","text":"M24,AWM,SKS,Kar98K用消焰器, Mk14, Mini14\n消除枪口火焰,略微降低平行与垂直方向后坐力\n-10.00% 后坐力效果\n-10.00% 平行方向后坐力\n-10.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/85/35/d785b3325a357d88f34575791393f77c.png"},{"id":1626,"type":2,"typeId":1,"name":"冲锋枪消焰器","text":"SMG用消焰器\n消除枪口火焰,略微降低平行与垂直方向后坐力\n-10.00% 后坐力效果\n-10.00% 平行方向后坐力\n-10.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/e0/25/dde06c4ba6252cec027f8c630044a307.png"},{"id":1627,"type":2,"typeId":1,"name":"步枪消音器","text":"AKM,M16A4,M416,SCAR-L ,S12K消音器\n降低武器音量,提升隐匿效果\n-5.00% 偏差","imgUrl":"http://rs.0.gaoshouyou.com/i/5f/aa/db5f377b3eaa59153733f4b1497f61ef.png"},{"id":1628,"type":2,"typeId":1,"name":"冲锋枪消音器","text":"冲锋枪专用消音器\n降低武器音量,提升隐匿效果\n-5.00% 偏差","imgUrl":"http://rs.0.gaoshouyou.com/i/06/91/310658a1bb91fc00313975a63f09b46f.png"},{"id":1629,"type":2,"typeId":1,"name":"狙击枪消音器","text":"M24,AWM,SKS,Kar98K抑制器, Mk14, Mini14\n降低武器音量,提升隐匿效果\n-5.00% 偏差","imgUrl":"http://rs.0.gaoshouyou.com/i/4e/5e/994e26d3fc5ecfc8be516a1cd27aec45.png"},{"id":1630,"type":2,"typeId":1,"name":"手枪消音器","text":"手枪消音器\n降低武器音量,提升隐匿效果\n-5.00% 偏差","imgUrl":"http://rs.0.gaoshouyou.com/i/d3/aa/2bd31c5729aa048d6dea71a9002aab32.png"},{"id":1654,"type":2,"typeId":1,"name":"战术枪托","text":"M416,Vector战术枪托\n后坐力消退更快,降低武器摇晃\n-20.00% 后坐力效果\n+15.00% 后坐力消退\n-10.00% 画面抖动\n-10.00% 摇晃","imgUrl":"http://rs.0.gaoshouyou.com/i/58/ee/1b584336d9ee4a9f2de37bfd4a11c725.png"}],"wb":[{"id":1631,"type":2,"typeId":3,"name":"角式前握把","text":"M416,SCAR-L,UMP9, SKS, Mk14专用角式前握把\n略微降低垂直方向与水平方向后坐力,加快进入瞄准状态速度\n-20.00% 后坐力效果\n-20.00% 平行方向后坐力\n+10.00% 快速瞄准","imgUrl":"http://rs.0.gaoshouyou.com/i/5b/47/825bd7d2a1471d1a5e336bd08415c1a0.png"},{"id":1632,"type":2,"typeId":3,"name":"十字弩箭袋","text":"适用武器：十字弩\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/83/ec/fd832852fbecec2c440472342a1508c7.png"},{"id":1633,"type":2,"typeId":3,"name":"垂直前握把","text":"M416,SCAR-L,UMP9,Vector, SKS, Mk14专用垂直前握把\n降低水平方向后坐力,加快进入瞄准状态速度\n-20.00% 后坐力效果\n-15.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/15/3a/491591f7bf3ad31ebdc9263c32445cbf.png"}],"mzj":[{"id":1634,"type":2,"typeId":2,"name":"红点瞄准镜","text":"适用武器: UMP9, Vector, P9, P1911, P18C, AKM, M16A4, M416, SCAR-L, Groza, SKS, S12K, M249, Kar98k, M24, Mk14, Mini14, AWM, Crossbow,AUGA3\n+20.00% 快速瞄准","imgUrl":"http://rs.0.gaoshouyou.com/i/fd/34/7ffd686d6a344e08052197bbcf328d16.png"},{"id":1635,"type":2,"typeId":2,"name":"全息瞄准镜","text":"适用武器: UMP9, Vector, AKM, M16A4, M416, SCAR-L, Groza, S12K, M249, Kar98k, M24, SKS, Mk14, Mini14, AWM, Crossbow,AUGA3\n+20.00% 快速瞄准","imgUrl":"http://rs.0.gaoshouyou.com/i/cc/bb/64ccfa1facbb92f7766faaa386d3b559.png"},{"id":1636,"type":2,"typeId":2,"name":"2倍点式瞄准镜","text":"适用武器: UMP9, Vector, AKM, M16A4, M416, SCAR-L, Groza, SKS, S12K, M249, Kar98k, M24, Mk14, Mini14, AWM,AUGA3\n1.80X 放大倍数\n+10.00% 快速瞄准","imgUrl":"http://rs.0.gaoshouyou.com/i/f1/a0/96f1fb1377a08417fbabe602313aacc5.png"},{"id":1637,"type":2,"typeId":2,"name":"4倍先进战斗全息瞄准镜","text":"适用武器: UMP9, Vector, AKM, M16A4, M416, SCAR-L, Groza, S12K, M249, Kar98k, M24, SKS, Mk14, Mini14, AWM,AUGA3\n4.00X 放大倍数","imgUrl":"http://rs.0.gaoshouyou.com/i/58/c6/52586df962c661f785eb2ce90d744f00.png"},{"id":1638,"type":2,"typeId":2,"name":"8倍CQBSS瞄准镜","text":"适用武器: AKM,  M416, SCAR-L, SKS, S12K, M249, Kar98k, M24, SKS, Mk14, Mini14, AWM\n7.25X 放大倍数","imgUrl":"http://rs.0.gaoshouyou.com/i/95/92/e09562dbe292dff7502fe97ed59a69ea.png"},{"id":1639,"type":2,"typeId":2,"name":"15倍PM II瞄准镜","text":"适用武器: AKM, M16A4, M416, SCAR-L, S12K, M249, Kar98k, M24, SKS, Mk14, Mini14, AWM\n12.00X 放大倍数","imgUrl":"http://rs.0.gaoshouyou.com/i/3a/b4/473a2dfcecb47c3defca9a824ace9a8e.png"}],"dj":[{"id":1640,"type":2,"typeId":4,"name":"手枪快速弹夹","text":"P9,P1911,P18C快速弹夹\n增加装填速度\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/73/f8/117324b2eef8f8ff46ac7b83798fa2bc.png"},{"id":1641,"type":2,"typeId":4,"name":"手枪扩容弹夹","text":"P9,P1911,P19C扩容弹夹\n增加弹夹容量\nP18C : 25 (17 默认)\nP1911 : 12 (7 默认)\nP92 : 20 (15 默认)","imgUrl":"http://rs.0.gaoshouyou.com/i/e3/bf/f1e3ff5adabf78a7e346bb8473568354.png"},{"id":1642,"type":2,"typeId":4,"name":"手枪扩容快速弹夹","text":"P9,P1911,P18C扩容快速弹夹\n改良装填速度以及弹夹容量\n-30.00% 装填时间\nP18C : 25 (17 默认)\nP1911 : 12 (7 默认)\nP92 : 20 (15 默认)","imgUrl":"http://rs.0.gaoshouyou.com/i/06/e0/fe069160e0e004ca8cf9297d26a9a714.png"},{"id":1643,"type":2,"typeId":4,"name":"冲锋枪扩容弹夹","text":"UZI,UMP9,Vector,Tommy Gun扩容弹夹\n增加装填速度\nUZI 装填: 35 (25 默认)\nUMP 装填: 40 (30 默认)\nVECTOR 装填: 25 (13 默认)\nTommy Gun 装填：50（30默认）","imgUrl":"http://rs.0.gaoshouyou.com/i/7d/31/147dc60fce31d5fda6f5456eba888293.png"},{"id":1644,"type":2,"typeId":4,"name":"冲锋枪快速扩容弹夹","text":"UZI,UMP9,Vector,Tommy Gun快速扩容弹夹\n-30.00% 装填时间\n增加装弹数\nUZI 装填: 35 (25 默认)\nUMP 装填: 40 (30 默认)\nVECTOR 装填: 25 (13 默认)\nTommy Gun 装填：50（30默认）","imgUrl":"http://rs.0.gaoshouyou.com/i/4d/84/1a4dacb63a84611d8e45e7c1499255e9.png"},{"id":1645,"type":2,"typeId":4,"name":"冲锋枪快速弹夹","text":"UZI,UMP9,Vector,Tommy Gun快速弹夹\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/7d/83/c07d8a28c0833c4fd76c12209e95f581.png"},{"id":1646,"type":2,"typeId":4,"name":"步枪扩容弹夹","text":"AKM,M16A4,M416,SCAR-L ,S12K,Groza,AUGA3扩容弹夹\n增加装弹量\n步枪 装弹：40（30默认）\nS12K 装弹：8（5默认）","imgUrl":"http://rs.0.gaoshouyou.com/i/bf/0b/68bfd086230b3a01f158ba11ba44f628.png"},{"id":1647,"type":2,"typeId":4,"name":"步枪快速扩容弹夹","text":"AKM,M16A4,M416,SCAR-L ,S12K,Groza,AUGA3快速扩容弹夹\n-30.00% 装填时间\n增加装弹量\n步枪 装弹：40（30默认）\nS12K 装弹：8（5默认）","imgUrl":"http://rs.0.gaoshouyou.com/i/14/8b/79140a608f8b13df012a9fe6933dfec1.png"},{"id":1648,"type":2,"typeId":4,"name":"步枪快速弹夹","text":"AKM,M16A4,M416,SCAR-L ,S12K,Groza,AUGA3快速弹夹\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/55/af/c85535b81fafca2120199944fd256aec.png"},{"id":1649,"type":2,"typeId":4,"name":"狙击枪快速弹夹","text":"M24,AWM,SKS,VSS, Mk14, Mini14快速弹夹\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/c4/c5/85c4063d10c585a46f8f256252de163d.png"},{"id":1650,"type":2,"typeId":4,"name":"狙击枪扩容弹夹","text":"M24,AWM,SKS,VSS, Mk14, Mini14扩容弹夹\n增加弹夹容量\nM24 装弹: 7 (5 默认)\nAWM 装弹: 7 (5 默认)\nSKS 装弹: 20 (10 默认)\nMK14 装弹: 20 (10 默认)\nMINI14 装弹: 30 (20 默认)\nVSS 装弹: 20 (10 默认)","imgUrl":"http://rs.0.gaoshouyou.com/i/76/87/6376399f24870a96c52ebe4826b92b83.png"}],"qt":[{"id":1651,"type":2,"typeId":5,"name":"狙击枪快速扩容弹夹","text":"M24,AWM,SKS,VSS, Mk14, Mini14\n改良装填速度以及弹夹容量\n-30.00% 装填时间\nM24 装弹: 7 (5 默认)\nAWM 装弹: 7 (5 默认)\nSKS 装弹: 20 (10 默认)\nMK14 装弹: 20 (10 默认)\nMINI14 装弹: 30 (20 默认)\nVSS 装弹: 20 (10 默认)","imgUrl":"http://rs.0.gaoshouyou.com/i/be/09/0dbe9e10da09eb78e850b644f1f997e4.png"},{"id":1652,"type":2,"typeId":5,"name":"霰弹枪子弹袋","text":"S1897,S686子弹袋\n改良装填速度以及弹夹容量\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/a9/d4/71a9c863d7d471958e4605fc9df0cf31.png"},{"id":1653,"type":2,"typeId":5,"name":"微型UZI枪托","text":"后坐力消退更快,降低武器摇晃\n-20.00% 后坐力效果\n-20.00% 垂直方向后坐力\n+15.00% 后坐力消退","imgUrl":"http://rs.0.gaoshouyou.com/i/29/7b/97299b31697b8f8bd5a10d16d4988529.png"},{"id":1655,"type":2,"typeId":5,"name":"子弹袋","text":"Kar98k,Win94子弹袋\n改良装填速度以及弹夹容量\n-50.00% 基础散射度\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/fb/51/1bfb1c4cf9516d520198dd6120eee568.png"},{"id":1656,"type":2,"typeId":5,"name":"狙击枪托腮板","text":"M24,AWM,SKS,VSS,Kar98k,Mk14狙击枪托腮板\n降低后坐力效果以及摇晃\n-20.00% 垂直方向后坐力\n-20.00% 画面抖动\n-15.00% 摇晃","imgUrl":"http://rs.0.gaoshouyou.com/i/f3/28/47f3f2e5f728888828b22d636efed213.png"}]},"fangju":{"tbhj":[{"id":1657,"type":3,"typeId":1,"name":"摩托头盔 (绿色) (1级)","text":"伤害减免:30%\n耐久度:80\n重量:40","imgUrl":"http://rs.0.gaoshouyou.com/i/a7/3c/31a72b143e3c5a3a7ba4654ccb5adcf8.png"},{"id":1658,"type":3,"typeId":1,"name":"摩托头盔 (灰色) (1级)","text":"伤害减免:30%\n耐久度:80\n重量:40","imgUrl":"http://rs.0.gaoshouyou.com/i/fc/fa/92fc790de9faf8d02aff011f89e6b5ac.png"},{"id":1659,"type":3,"typeId":1,"name":"军用头盔 (沙漠迷彩) (2级)","text":"伤害减免:40%\n耐久度:150\n重量:50","imgUrl":"http://rs.0.gaoshouyou.com/i/d8/6b/90d87cd97d6b5730e096cd25e3bfb4a0.png"},{"id":1660,"type":3,"typeId":1,"name":"军用头盔 (森林迷彩) (2级)","text":"伤害减免:40%\n耐久度:150\n重量:50","imgUrl":"http://rs.0.gaoshouyou.com/i/a7/00/47a7bddf1f007df8b340c5bab9dad6d2.png"},{"id":1661,"type":3,"typeId":1,"name":"俄国特战队头盔 (3级)","text":"伤害减免:55%\n耐久度:230\n重量:60","imgUrl":"http://rs.0.gaoshouyou.com/i/1e/4e/a31e32eb2a4e2ba7c0585b0bf0f46bab.png"}],"fdbx":[{"id":1662,"type":3,"typeId":3,"name":"警用背心 (1级)","text":"携带容量加成:+50\n伤害减免:30%\n耐久度:200\n重量:120","imgUrl":"http://rs.0.gaoshouyou.com/i/1e/5e/ad1e2600c45e60e81be745265825f1f8.png"},{"id":1663,"type":3,"typeId":3,"name":"警用背心 (2级)","text":"携带容量加成:+50\n伤害减免:40%\n耐久度:220\n重量:150","imgUrl":"http://rs.0.gaoshouyou.com/i/f5/a4/90f53c94c5a4cf93ee3a65e69f6aec70.png"},{"id":1664,"type":3,"typeId":3,"name":"军用背心 (3级)","text":"携带容量加成:+50\n伤害减免:55%\n耐久度:250\n重量:180","imgUrl":"http://rs.0.gaoshouyou.com/i/ae/53/9aae7afe49533592a199b34c6f056907.png"}],"pd":[{"id":1665,"type":3,"typeId":4,"name":"工具带","text":"携带容量加成:+50\n伤害减免:0%\n重量:20","imgUrl":"http://rs.0.gaoshouyou.com/i/c8/d5/89c8134df9d500cd1d853820cebac26d.png"}],"wy":[{"id":1666,"type":3,"typeId":5,"name":"吉利服","text":"携带容量加成:+0\n伤害减免:0%\n重量:100","imgUrl":"http://rs.0.gaoshouyou.com/i/c8/4e/c6c885f0a34ed27acbfce731bd874461.png"}],"bb":[{"id":1667,"type":3,"typeId":2,"name":"背包 (1级)","text":"携带容量加成:+150\n重量:400","imgUrl":"http://rs.0.gaoshouyou.com/i/eb/92/78eb51ca7792cae8f1059c55913536a2.png"},{"id":1668,"type":3,"typeId":2,"name":"背包 (2级)","text":"携带容量加成:+200\n重量:400","imgUrl":"http://rs.0.gaoshouyou.com/i/aa/b0/17aa51ca99b094e4b381d4ccb6622014.png"},{"id":1669,"type":3,"typeId":2,"name":"背包 (3级)","text":"携带容量加成:+250\n重量:400","imgUrl":"http://rs.0.gaoshouyou.com/i/8c/5c/f48ce422955c7711f7b3873c67682072.png"}]},"daoju":[{"id":1670,"type":4,"typeId":0,"name":"肾上腺素","text":"肾上腺素能够瞬间给角色100点加成。使用时执行某些动作将会取消使用。\n8秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/cd/42/1ecdeed2c0429746436234f2ba81bfd6.png"},{"id":1671,"type":4,"typeId":0,"name":"能量饮料","text":"能量饮料能够瞬间给予角色40点能量加成。使用时执行某些动作将会取消使用\n4秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/e2/ee/91e273a914eea0b3cbb950206d5deed7.png"},{"id":1672,"type":4,"typeId":0,"name":"止痛药","text":"止痛药能够瞬间给予角色60点加成。使用时执行某些动作将会取消使用\n6秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/59/8d/5159aac0f08db7d0592495f2914bc339.png"},{"id":1673,"type":4,"typeId":0,"name":"绷带","text":"绷带能够逐渐治疗角色10点生命值。使用时执行某些动作将会取消使用。绷带最多能将角色生命值恢复至75点。\n4秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/5e/d3/d35e5e3bfdd3bd0678ad0f89f00f268b.png"},{"id":1674,"type":4,"typeId":0,"name":"急救包","text":"急救包能够瞬间治疗角色生命值至75点。使用时执行某些动作将会取消使用。急救包最多能角色生命值恢复至75点。\n6秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/bf/cf/37bf2ce0dbcf5b9022a38f87d29ca02c.png"},{"id":1675,"type":4,"typeId":0,"name":"医疗箱","text":"医疗箱能够瞬间将角色生命值治疗至100点。使用时执行某些动作将会取消使用。\n8秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/63/a7/d76389303da71f79d1ebe2ae6fa91890.png"},{"id":1676,"type":4,"typeId":0,"name":"汽油桶","text":"你可以用它来加油\n3秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/84/c5/ad8482441fc508f638571c936090536c.png"}]}
     * post : []
     * userId : 0
     * package :
     * time : 0.016534805297852
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
         * peijian : {"qk":[{"id":1620,"type":2,"typeId":1,"name":"扼流圈","text":"S1897,S686用扼流圈\n降低霰弹枪弹丸散射\n-18.20% 弹丸散射\n+15.40% 弹丸速度","imgUrl":"http://rs.0.gaoshouyou.com/i/79/ec/5c7975e9a0ecdd7f4539084a37c99870.png"},{"id":1621,"type":2,"typeId":1,"name":"步枪枪口补偿器","text":"AKM,M16A4,M416,SCAR-L ,S12K用枪口补偿器\n略微降低平行方向后坐力并且降低垂直方向后坐力\n-25.00% 后坐力效果\n-10.00% 平行方向后坐力\n-15.00% 垂直方向后坐力\n-10.00% 基础散射度","imgUrl":"http://rs.0.gaoshouyou.com/i/d6/7a/b0d6ffbb257a77ccae3d2511a0b9f6b0.png"},{"id":1622,"type":2,"typeId":1,"name":"冲锋枪枪口补偿器","text":"SMG用枪口补偿器\n略微降低平行方向后坐力并且降低垂直方向后坐力\n-25.00% 后坐力效果\n-20.00% 平行方向后坐力\n-25.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/d7/29/ded736c88429fbb385eab253e8d172d4.png"},{"id":1623,"type":2,"typeId":1,"name":"狙击枪枪口补偿器","text":"M24,AWM,SKS,Kar98K用枪口补偿器, Mk14, Mini14\n略微降低平行方向后坐力并且降低垂直方向后坐力\n-25.00% 后坐力效果\n-20.00% 平行方向后坐力\n-20.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/e0/46/18e00a852b465d757b210657260fd99a.png"},{"id":1624,"type":2,"typeId":1,"name":"步枪消焰器","text":"AKM,M16A4,M416,SCAR-L,S12K用消焰器\n消除枪口火焰,略微降低平行与垂直方向后坐力\n-10.00% 后坐力效果\n-10.00% 平行方向后坐力\n-10.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/5b/3c/335b732a1a3c02b4568406e6688702ee.png"},{"id":1625,"type":2,"typeId":1,"name":"狙击枪消焰器","text":"M24,AWM,SKS,Kar98K用消焰器, Mk14, Mini14\n消除枪口火焰,略微降低平行与垂直方向后坐力\n-10.00% 后坐力效果\n-10.00% 平行方向后坐力\n-10.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/85/35/d785b3325a357d88f34575791393f77c.png"},{"id":1626,"type":2,"typeId":1,"name":"冲锋枪消焰器","text":"SMG用消焰器\n消除枪口火焰,略微降低平行与垂直方向后坐力\n-10.00% 后坐力效果\n-10.00% 平行方向后坐力\n-10.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/e0/25/dde06c4ba6252cec027f8c630044a307.png"},{"id":1627,"type":2,"typeId":1,"name":"步枪消音器","text":"AKM,M16A4,M416,SCAR-L ,S12K消音器\n降低武器音量,提升隐匿效果\n-5.00% 偏差","imgUrl":"http://rs.0.gaoshouyou.com/i/5f/aa/db5f377b3eaa59153733f4b1497f61ef.png"},{"id":1628,"type":2,"typeId":1,"name":"冲锋枪消音器","text":"冲锋枪专用消音器\n降低武器音量,提升隐匿效果\n-5.00% 偏差","imgUrl":"http://rs.0.gaoshouyou.com/i/06/91/310658a1bb91fc00313975a63f09b46f.png"},{"id":1629,"type":2,"typeId":1,"name":"狙击枪消音器","text":"M24,AWM,SKS,Kar98K抑制器, Mk14, Mini14\n降低武器音量,提升隐匿效果\n-5.00% 偏差","imgUrl":"http://rs.0.gaoshouyou.com/i/4e/5e/994e26d3fc5ecfc8be516a1cd27aec45.png"},{"id":1630,"type":2,"typeId":1,"name":"手枪消音器","text":"手枪消音器\n降低武器音量,提升隐匿效果\n-5.00% 偏差","imgUrl":"http://rs.0.gaoshouyou.com/i/d3/aa/2bd31c5729aa048d6dea71a9002aab32.png"},{"id":1654,"type":2,"typeId":1,"name":"战术枪托","text":"M416,Vector战术枪托\n后坐力消退更快,降低武器摇晃\n-20.00% 后坐力效果\n+15.00% 后坐力消退\n-10.00% 画面抖动\n-10.00% 摇晃","imgUrl":"http://rs.0.gaoshouyou.com/i/58/ee/1b584336d9ee4a9f2de37bfd4a11c725.png"}],"wb":[{"id":1631,"type":2,"typeId":3,"name":"角式前握把","text":"M416,SCAR-L,UMP9, SKS, Mk14专用角式前握把\n略微降低垂直方向与水平方向后坐力,加快进入瞄准状态速度\n-20.00% 后坐力效果\n-20.00% 平行方向后坐力\n+10.00% 快速瞄准","imgUrl":"http://rs.0.gaoshouyou.com/i/5b/47/825bd7d2a1471d1a5e336bd08415c1a0.png"},{"id":1632,"type":2,"typeId":3,"name":"十字弩箭袋","text":"适用武器：十字弩\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/83/ec/fd832852fbecec2c440472342a1508c7.png"},{"id":1633,"type":2,"typeId":3,"name":"垂直前握把","text":"M416,SCAR-L,UMP9,Vector, SKS, Mk14专用垂直前握把\n降低水平方向后坐力,加快进入瞄准状态速度\n-20.00% 后坐力效果\n-15.00% 垂直方向后坐力","imgUrl":"http://rs.0.gaoshouyou.com/i/15/3a/491591f7bf3ad31ebdc9263c32445cbf.png"}],"mzj":[{"id":1634,"type":2,"typeId":2,"name":"红点瞄准镜","text":"适用武器: UMP9, Vector, P9, P1911, P18C, AKM, M16A4, M416, SCAR-L, Groza, SKS, S12K, M249, Kar98k, M24, Mk14, Mini14, AWM, Crossbow,AUGA3\n+20.00% 快速瞄准","imgUrl":"http://rs.0.gaoshouyou.com/i/fd/34/7ffd686d6a344e08052197bbcf328d16.png"},{"id":1635,"type":2,"typeId":2,"name":"全息瞄准镜","text":"适用武器: UMP9, Vector, AKM, M16A4, M416, SCAR-L, Groza, S12K, M249, Kar98k, M24, SKS, Mk14, Mini14, AWM, Crossbow,AUGA3\n+20.00% 快速瞄准","imgUrl":"http://rs.0.gaoshouyou.com/i/cc/bb/64ccfa1facbb92f7766faaa386d3b559.png"},{"id":1636,"type":2,"typeId":2,"name":"2倍点式瞄准镜","text":"适用武器: UMP9, Vector, AKM, M16A4, M416, SCAR-L, Groza, SKS, S12K, M249, Kar98k, M24, Mk14, Mini14, AWM,AUGA3\n1.80X 放大倍数\n+10.00% 快速瞄准","imgUrl":"http://rs.0.gaoshouyou.com/i/f1/a0/96f1fb1377a08417fbabe602313aacc5.png"},{"id":1637,"type":2,"typeId":2,"name":"4倍先进战斗全息瞄准镜","text":"适用武器: UMP9, Vector, AKM, M16A4, M416, SCAR-L, Groza, S12K, M249, Kar98k, M24, SKS, Mk14, Mini14, AWM,AUGA3\n4.00X 放大倍数","imgUrl":"http://rs.0.gaoshouyou.com/i/58/c6/52586df962c661f785eb2ce90d744f00.png"},{"id":1638,"type":2,"typeId":2,"name":"8倍CQBSS瞄准镜","text":"适用武器: AKM,  M416, SCAR-L, SKS, S12K, M249, Kar98k, M24, SKS, Mk14, Mini14, AWM\n7.25X 放大倍数","imgUrl":"http://rs.0.gaoshouyou.com/i/95/92/e09562dbe292dff7502fe97ed59a69ea.png"},{"id":1639,"type":2,"typeId":2,"name":"15倍PM II瞄准镜","text":"适用武器: AKM, M16A4, M416, SCAR-L, S12K, M249, Kar98k, M24, SKS, Mk14, Mini14, AWM\n12.00X 放大倍数","imgUrl":"http://rs.0.gaoshouyou.com/i/3a/b4/473a2dfcecb47c3defca9a824ace9a8e.png"}],"dj":[{"id":1640,"type":2,"typeId":4,"name":"手枪快速弹夹","text":"P9,P1911,P18C快速弹夹\n增加装填速度\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/73/f8/117324b2eef8f8ff46ac7b83798fa2bc.png"},{"id":1641,"type":2,"typeId":4,"name":"手枪扩容弹夹","text":"P9,P1911,P19C扩容弹夹\n增加弹夹容量\nP18C : 25 (17 默认)\nP1911 : 12 (7 默认)\nP92 : 20 (15 默认)","imgUrl":"http://rs.0.gaoshouyou.com/i/e3/bf/f1e3ff5adabf78a7e346bb8473568354.png"},{"id":1642,"type":2,"typeId":4,"name":"手枪扩容快速弹夹","text":"P9,P1911,P18C扩容快速弹夹\n改良装填速度以及弹夹容量\n-30.00% 装填时间\nP18C : 25 (17 默认)\nP1911 : 12 (7 默认)\nP92 : 20 (15 默认)","imgUrl":"http://rs.0.gaoshouyou.com/i/06/e0/fe069160e0e004ca8cf9297d26a9a714.png"},{"id":1643,"type":2,"typeId":4,"name":"冲锋枪扩容弹夹","text":"UZI,UMP9,Vector,Tommy Gun扩容弹夹\n增加装填速度\nUZI 装填: 35 (25 默认)\nUMP 装填: 40 (30 默认)\nVECTOR 装填: 25 (13 默认)\nTommy Gun 装填：50（30默认）","imgUrl":"http://rs.0.gaoshouyou.com/i/7d/31/147dc60fce31d5fda6f5456eba888293.png"},{"id":1644,"type":2,"typeId":4,"name":"冲锋枪快速扩容弹夹","text":"UZI,UMP9,Vector,Tommy Gun快速扩容弹夹\n-30.00% 装填时间\n增加装弹数\nUZI 装填: 35 (25 默认)\nUMP 装填: 40 (30 默认)\nVECTOR 装填: 25 (13 默认)\nTommy Gun 装填：50（30默认）","imgUrl":"http://rs.0.gaoshouyou.com/i/4d/84/1a4dacb63a84611d8e45e7c1499255e9.png"},{"id":1645,"type":2,"typeId":4,"name":"冲锋枪快速弹夹","text":"UZI,UMP9,Vector,Tommy Gun快速弹夹\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/7d/83/c07d8a28c0833c4fd76c12209e95f581.png"},{"id":1646,"type":2,"typeId":4,"name":"步枪扩容弹夹","text":"AKM,M16A4,M416,SCAR-L ,S12K,Groza,AUGA3扩容弹夹\n增加装弹量\n步枪 装弹：40（30默认）\nS12K 装弹：8（5默认）","imgUrl":"http://rs.0.gaoshouyou.com/i/bf/0b/68bfd086230b3a01f158ba11ba44f628.png"},{"id":1647,"type":2,"typeId":4,"name":"步枪快速扩容弹夹","text":"AKM,M16A4,M416,SCAR-L ,S12K,Groza,AUGA3快速扩容弹夹\n-30.00% 装填时间\n增加装弹量\n步枪 装弹：40（30默认）\nS12K 装弹：8（5默认）","imgUrl":"http://rs.0.gaoshouyou.com/i/14/8b/79140a608f8b13df012a9fe6933dfec1.png"},{"id":1648,"type":2,"typeId":4,"name":"步枪快速弹夹","text":"AKM,M16A4,M416,SCAR-L ,S12K,Groza,AUGA3快速弹夹\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/55/af/c85535b81fafca2120199944fd256aec.png"},{"id":1649,"type":2,"typeId":4,"name":"狙击枪快速弹夹","text":"M24,AWM,SKS,VSS, Mk14, Mini14快速弹夹\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/c4/c5/85c4063d10c585a46f8f256252de163d.png"},{"id":1650,"type":2,"typeId":4,"name":"狙击枪扩容弹夹","text":"M24,AWM,SKS,VSS, Mk14, Mini14扩容弹夹\n增加弹夹容量\nM24 装弹: 7 (5 默认)\nAWM 装弹: 7 (5 默认)\nSKS 装弹: 20 (10 默认)\nMK14 装弹: 20 (10 默认)\nMINI14 装弹: 30 (20 默认)\nVSS 装弹: 20 (10 默认)","imgUrl":"http://rs.0.gaoshouyou.com/i/76/87/6376399f24870a96c52ebe4826b92b83.png"}],"qt":[{"id":1651,"type":2,"typeId":5,"name":"狙击枪快速扩容弹夹","text":"M24,AWM,SKS,VSS, Mk14, Mini14\n改良装填速度以及弹夹容量\n-30.00% 装填时间\nM24 装弹: 7 (5 默认)\nAWM 装弹: 7 (5 默认)\nSKS 装弹: 20 (10 默认)\nMK14 装弹: 20 (10 默认)\nMINI14 装弹: 30 (20 默认)\nVSS 装弹: 20 (10 默认)","imgUrl":"http://rs.0.gaoshouyou.com/i/be/09/0dbe9e10da09eb78e850b644f1f997e4.png"},{"id":1652,"type":2,"typeId":5,"name":"霰弹枪子弹袋","text":"S1897,S686子弹袋\n改良装填速度以及弹夹容量\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/a9/d4/71a9c863d7d471958e4605fc9df0cf31.png"},{"id":1653,"type":2,"typeId":5,"name":"微型UZI枪托","text":"后坐力消退更快,降低武器摇晃\n-20.00% 后坐力效果\n-20.00% 垂直方向后坐力\n+15.00% 后坐力消退","imgUrl":"http://rs.0.gaoshouyou.com/i/29/7b/97299b31697b8f8bd5a10d16d4988529.png"},{"id":1655,"type":2,"typeId":5,"name":"子弹袋","text":"Kar98k,Win94子弹袋\n改良装填速度以及弹夹容量\n-50.00% 基础散射度\n-30.00% 装填时间","imgUrl":"http://rs.0.gaoshouyou.com/i/fb/51/1bfb1c4cf9516d520198dd6120eee568.png"},{"id":1656,"type":2,"typeId":5,"name":"狙击枪托腮板","text":"M24,AWM,SKS,VSS,Kar98k,Mk14狙击枪托腮板\n降低后坐力效果以及摇晃\n-20.00% 垂直方向后坐力\n-20.00% 画面抖动\n-15.00% 摇晃","imgUrl":"http://rs.0.gaoshouyou.com/i/f3/28/47f3f2e5f728888828b22d636efed213.png"}]}
         * fangju : {"tbhj":[{"id":1657,"type":3,"typeId":1,"name":"摩托头盔 (绿色) (1级)","text":"伤害减免:30%\n耐久度:80\n重量:40","imgUrl":"http://rs.0.gaoshouyou.com/i/a7/3c/31a72b143e3c5a3a7ba4654ccb5adcf8.png"},{"id":1658,"type":3,"typeId":1,"name":"摩托头盔 (灰色) (1级)","text":"伤害减免:30%\n耐久度:80\n重量:40","imgUrl":"http://rs.0.gaoshouyou.com/i/fc/fa/92fc790de9faf8d02aff011f89e6b5ac.png"},{"id":1659,"type":3,"typeId":1,"name":"军用头盔 (沙漠迷彩) (2级)","text":"伤害减免:40%\n耐久度:150\n重量:50","imgUrl":"http://rs.0.gaoshouyou.com/i/d8/6b/90d87cd97d6b5730e096cd25e3bfb4a0.png"},{"id":1660,"type":3,"typeId":1,"name":"军用头盔 (森林迷彩) (2级)","text":"伤害减免:40%\n耐久度:150\n重量:50","imgUrl":"http://rs.0.gaoshouyou.com/i/a7/00/47a7bddf1f007df8b340c5bab9dad6d2.png"},{"id":1661,"type":3,"typeId":1,"name":"俄国特战队头盔 (3级)","text":"伤害减免:55%\n耐久度:230\n重量:60","imgUrl":"http://rs.0.gaoshouyou.com/i/1e/4e/a31e32eb2a4e2ba7c0585b0bf0f46bab.png"}],"fdbx":[{"id":1662,"type":3,"typeId":3,"name":"警用背心 (1级)","text":"携带容量加成:+50\n伤害减免:30%\n耐久度:200\n重量:120","imgUrl":"http://rs.0.gaoshouyou.com/i/1e/5e/ad1e2600c45e60e81be745265825f1f8.png"},{"id":1663,"type":3,"typeId":3,"name":"警用背心 (2级)","text":"携带容量加成:+50\n伤害减免:40%\n耐久度:220\n重量:150","imgUrl":"http://rs.0.gaoshouyou.com/i/f5/a4/90f53c94c5a4cf93ee3a65e69f6aec70.png"},{"id":1664,"type":3,"typeId":3,"name":"军用背心 (3级)","text":"携带容量加成:+50\n伤害减免:55%\n耐久度:250\n重量:180","imgUrl":"http://rs.0.gaoshouyou.com/i/ae/53/9aae7afe49533592a199b34c6f056907.png"}],"pd":[{"id":1665,"type":3,"typeId":4,"name":"工具带","text":"携带容量加成:+50\n伤害减免:0%\n重量:20","imgUrl":"http://rs.0.gaoshouyou.com/i/c8/d5/89c8134df9d500cd1d853820cebac26d.png"}],"wy":[{"id":1666,"type":3,"typeId":5,"name":"吉利服","text":"携带容量加成:+0\n伤害减免:0%\n重量:100","imgUrl":"http://rs.0.gaoshouyou.com/i/c8/4e/c6c885f0a34ed27acbfce731bd874461.png"}],"bb":[{"id":1667,"type":3,"typeId":2,"name":"背包 (1级)","text":"携带容量加成:+150\n重量:400","imgUrl":"http://rs.0.gaoshouyou.com/i/eb/92/78eb51ca7792cae8f1059c55913536a2.png"},{"id":1668,"type":3,"typeId":2,"name":"背包 (2级)","text":"携带容量加成:+200\n重量:400","imgUrl":"http://rs.0.gaoshouyou.com/i/aa/b0/17aa51ca99b094e4b381d4ccb6622014.png"},{"id":1669,"type":3,"typeId":2,"name":"背包 (3级)","text":"携带容量加成:+250\n重量:400","imgUrl":"http://rs.0.gaoshouyou.com/i/8c/5c/f48ce422955c7711f7b3873c67682072.png"}]}
         * daoju : [{"id":1670,"type":4,"typeId":0,"name":"肾上腺素","text":"肾上腺素能够瞬间给角色100点加成。使用时执行某些动作将会取消使用。\n8秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/cd/42/1ecdeed2c0429746436234f2ba81bfd6.png"},{"id":1671,"type":4,"typeId":0,"name":"能量饮料","text":"能量饮料能够瞬间给予角色40点能量加成。使用时执行某些动作将会取消使用\n4秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/e2/ee/91e273a914eea0b3cbb950206d5deed7.png"},{"id":1672,"type":4,"typeId":0,"name":"止痛药","text":"止痛药能够瞬间给予角色60点加成。使用时执行某些动作将会取消使用\n6秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/59/8d/5159aac0f08db7d0592495f2914bc339.png"},{"id":1673,"type":4,"typeId":0,"name":"绷带","text":"绷带能够逐渐治疗角色10点生命值。使用时执行某些动作将会取消使用。绷带最多能将角色生命值恢复至75点。\n4秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/5e/d3/d35e5e3bfdd3bd0678ad0f89f00f268b.png"},{"id":1674,"type":4,"typeId":0,"name":"急救包","text":"急救包能够瞬间治疗角色生命值至75点。使用时执行某些动作将会取消使用。急救包最多能角色生命值恢复至75点。\n6秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/bf/cf/37bf2ce0dbcf5b9022a38f87d29ca02c.png"},{"id":1675,"type":4,"typeId":0,"name":"医疗箱","text":"医疗箱能够瞬间将角色生命值治疗至100点。使用时执行某些动作将会取消使用。\n8秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/63/a7/d76389303da71f79d1ebe2ae6fa91890.png"},{"id":1676,"type":4,"typeId":0,"name":"汽油桶","text":"你可以用它来加油\n3秒使用时间","imgUrl":"http://rs.0.gaoshouyou.com/i/84/c5/ad8482441fc508f638571c936090536c.png"}]
         */

        private PeijianBean peijian;
        private FangjuBean fangju;
        private ArrayList<DaojuBean> daoju;

        public PeijianBean getPeijian() {
            return peijian;
        }

        public void setPeijian(PeijianBean peijian) {
            this.peijian = peijian;
        }

        public FangjuBean getFangju() {
            return fangju;
        }

        public void setFangju(FangjuBean fangju) {
            this.fangju = fangju;
        }

        public ArrayList<DaojuBean> getDaoju() {
            return daoju;
        }

        public void setDaoju(ArrayList<DaojuBean> daoju) {
            this.daoju = daoju;
        }

        public static class PeijianBean {
            private ArrayList<QkBean> qk;
            private ArrayList<WbBean> wb;
            private ArrayList<MzjBean> mzj;
            private ArrayList<DjBean> dj;
            private ArrayList<QtBean> qt;

            public ArrayList<QkBean> getQk() {
                return qk;
            }

            public void setQk(ArrayList<QkBean> qk) {
                this.qk = qk;
            }

            public ArrayList<WbBean> getWb() {
                return wb;
            }

            public void setWb(ArrayList<WbBean> wb) {
                this.wb = wb;
            }

            public ArrayList<MzjBean> getMzj() {
                return mzj;
            }

            public void setMzj(ArrayList<MzjBean> mzj) {
                this.mzj = mzj;
            }

            public ArrayList<DjBean> getDj() {
                return dj;
            }

            public void setDj(ArrayList<DjBean> dj) {
                this.dj = dj;
            }

            public ArrayList<QtBean> getQt() {
                return qt;
            }

            public void setQt(ArrayList<QtBean> qt) {
                this.qt = qt;
            }

            public static class QkBean {
                /**
                 * id : 1620
                 * type : 2
                 * typeId : 1
                 * name : 扼流圈
                 * text : S1897,S686用扼流圈
                 降低霰弹枪弹丸散射
                 -18.20% 弹丸散射
                 +15.40% 弹丸速度
                 * imgUrl : http://rs.0.gaoshouyou.com/i/79/ec/5c7975e9a0ecdd7f4539084a37c99870.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }

            public static class WbBean {
                /**
                 * id : 1631
                 * type : 2
                 * typeId : 3
                 * name : 角式前握把
                 * text : M416,SCAR-L,UMP9, SKS, Mk14专用角式前握把
                 略微降低垂直方向与水平方向后坐力,加快进入瞄准状态速度
                 -20.00% 后坐力效果
                 -20.00% 平行方向后坐力
                 +10.00% 快速瞄准
                 * imgUrl : http://rs.0.gaoshouyou.com/i/5b/47/825bd7d2a1471d1a5e336bd08415c1a0.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }

            public static class MzjBean {
                /**
                 * id : 1634
                 * type : 2
                 * typeId : 2
                 * name : 红点瞄准镜
                 * text : 适用武器: UMP9, Vector, P9, P1911, P18C, AKM, M16A4, M416, SCAR-L, Groza, SKS, S12K, M249, Kar98k, M24, Mk14, Mini14, AWM, Crossbow,AUGA3
                 +20.00% 快速瞄准
                 * imgUrl : http://rs.0.gaoshouyou.com/i/fd/34/7ffd686d6a344e08052197bbcf328d16.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }

            public static class DjBean {
                /**
                 * id : 1640
                 * type : 2
                 * typeId : 4
                 * name : 手枪快速弹夹
                 * text : P9,P1911,P18C快速弹夹
                 增加装填速度
                 -30.00% 装填时间
                 * imgUrl : http://rs.0.gaoshouyou.com/i/73/f8/117324b2eef8f8ff46ac7b83798fa2bc.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }

            public static class QtBean {
                /**
                 * id : 1651
                 * type : 2
                 * typeId : 5
                 * name : 狙击枪快速扩容弹夹
                 * text : M24,AWM,SKS,VSS, Mk14, Mini14
                 改良装填速度以及弹夹容量
                 -30.00% 装填时间
                 M24 装弹: 7 (5 默认)
                 AWM 装弹: 7 (5 默认)
                 SKS 装弹: 20 (10 默认)
                 MK14 装弹: 20 (10 默认)
                 MINI14 装弹: 30 (20 默认)
                 VSS 装弹: 20 (10 默认)
                 * imgUrl : http://rs.0.gaoshouyou.com/i/be/09/0dbe9e10da09eb78e850b644f1f997e4.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }
        }

        public static class FangjuBean {
            private ArrayList<TbhjBean> tbhj;
            private ArrayList<FdbxBean> fdbx;
            private ArrayList<PdBean> pd;
            private ArrayList<WyBean> wy;
            private ArrayList<BbBean> bb;

            public ArrayList<TbhjBean> getTbhj() {
                return tbhj;
            }

            public void setTbhj(ArrayList<TbhjBean> tbhj) {
                this.tbhj = tbhj;
            }

            public ArrayList<FdbxBean> getFdbx() {
                return fdbx;
            }

            public void setFdbx(ArrayList<FdbxBean> fdbx) {
                this.fdbx = fdbx;
            }

            public ArrayList<PdBean> getPd() {
                return pd;
            }

            public void setPd(ArrayList<PdBean> pd) {
                this.pd = pd;
            }

            public ArrayList<WyBean> getWy() {
                return wy;
            }

            public void setWy(ArrayList<WyBean> wy) {
                this.wy = wy;
            }

            public ArrayList<BbBean> getBb() {
                return bb;
            }

            public void setBb(ArrayList<BbBean> bb) {
                this.bb = bb;
            }

            public static class TbhjBean {
                /**
                 * id : 1657
                 * type : 3
                 * typeId : 1
                 * name : 摩托头盔 (绿色) (1级)
                 * text : 伤害减免:30%
                 耐久度:80
                 重量:40
                 * imgUrl : http://rs.0.gaoshouyou.com/i/a7/3c/31a72b143e3c5a3a7ba4654ccb5adcf8.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }

            public static class FdbxBean {
                /**
                 * id : 1662
                 * type : 3
                 * typeId : 3
                 * name : 警用背心 (1级)
                 * text : 携带容量加成:+50
                 伤害减免:30%
                 耐久度:200
                 重量:120
                 * imgUrl : http://rs.0.gaoshouyou.com/i/1e/5e/ad1e2600c45e60e81be745265825f1f8.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }

            public static class PdBean {
                /**
                 * id : 1665
                 * type : 3
                 * typeId : 4
                 * name : 工具带
                 * text : 携带容量加成:+50
                 伤害减免:0%
                 重量:20
                 * imgUrl : http://rs.0.gaoshouyou.com/i/c8/d5/89c8134df9d500cd1d853820cebac26d.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }

            public static class WyBean {
                /**
                 * id : 1666
                 * type : 3
                 * typeId : 5
                 * name : 吉利服
                 * text : 携带容量加成:+0
                 伤害减免:0%
                 重量:100
                 * imgUrl : http://rs.0.gaoshouyou.com/i/c8/4e/c6c885f0a34ed27acbfce731bd874461.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }

            public static class BbBean {
                /**
                 * id : 1667
                 * type : 3
                 * typeId : 2
                 * name : 背包 (1级)
                 * text : 携带容量加成:+150
                 重量:400
                 * imgUrl : http://rs.0.gaoshouyou.com/i/eb/92/78eb51ca7792cae8f1059c55913536a2.png
                 */

                private int id;
                private int type;
                private int typeId;
                private String name;
                private String text;
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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }
            }
        }

        public static class DaojuBean {
            /**
             * id : 1670
             * type : 4
             * typeId : 0
             * name : 肾上腺素
             * text : 肾上腺素能够瞬间给角色100点加成。使用时执行某些动作将会取消使用。
             8秒使用时间
             * imgUrl : http://rs.0.gaoshouyou.com/i/cd/42/1ecdeed2c0429746436234f2ba81bfd6.png
             */

            private int id;
            private int type;
            private int typeId;
            private String name;
            private String text;
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

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
        }
    }
}
