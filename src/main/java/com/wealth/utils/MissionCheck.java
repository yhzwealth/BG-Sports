package com.wealth.utils;

/**
 * @program: BG-Sports
 * @author: iamYBG
 * @description: 每日任务检测
 * @create: 2021-12-08
 */
public class MissionCheck {

    private static String info = "<div style=\"overflow-y: hidden;height: 300px\">\n" +
            "  <br/>\n" +
            "  <div style=\"font-size: 35px;color: black;text-align: center;font-weight: bold;font-family: 'Heiti SC',serif\">\n" +
            "    每日任务\n" +
            "  </div>\n" +
            "  <br/>\n" +
            "  <hr/>\n" +
            "  <div style=\"font-size: 18px;color: black;text-align: center;font-family: 'Heiti SC',serif\">\n" +
            "    完成每日任务，可以获得Y币参与比赛竞猜\n" +
            "  </div>\n" +
            "  <br/>\n" +
            "  <div style=\"height: 15px\">\n" +
            "    <span style=\"font-size: 20px;color: black;font-family: 'Heiti SC',serif;float: left\">\n" +
            "      1. 每日登录\n" +
            "    </span>\n" +
            "    <span style=\"font-size: 20px;color: red;font-family: 'Heiti SC',serif;float: right;\">\n" +
            "      ✅\n" +
            "    </span>\n" +
            "    <span style=\"font-size: 20px;color: red;font-family: 'Heiti SC',serif;float: right;padding-right: 40px\">\n" +
            "      10Y币\n" +
            "    </span>\n" +
            "  </div>\n" +
            "  <br/>\n" +
            "  <div style=\"height: 15px\">\n" +
            "    <span style=\"font-size: 20px;color: black;font-family: 'Heiti SC',serif;float: left\">\n" +
            "      2. 每日阅读10篇新闻\n" +
            "    </span>\n" +
            "    <span style=\"font-size: 20px;color: red;font-family: 'Heiti SC',serif;float: right;\">\n" +
            "      MISSION2\n" +
            "    </span>\n" +
            "    <span style=\"font-size: 20px;color: red;font-family: 'Heiti SC',serif;float: right;padding-right: 40px\">\n" +
            "      5Y币\n" +
            "    </span>\n" +
            "  </div>\n" +
            "  <br/>\n" +
            "  <div style=\"height: 15px\">\n" +
            "    <span style=\"font-size: 20px;color: black;font-family: 'Heiti SC',serif;float: left\">\n" +
            "      3. 每日参与一次竞猜\n" +
            "    </span>\n" +
            "    <span style=\"font-size: 20px;color: red;font-family: 'Heiti SC',serif;float: right;\">\n" +
            "      MISSION3\n" +
            "    </span>\n" +
            "    <span style=\"font-size: 20px;color: red;font-family: 'Heiti SC',serif;float: right;padding-right: 40px\">\n" +
            "      20Y币\n" +
            "    </span>\n" +
            "  </div>\n" +
            "</div>";

    public static String check(Boolean mission2, Boolean mission3){
        if(mission2){
            info = info.replace("MISSION2","✅");
        }else{
            info = info.replace("MISSION2","❌");
        }

        if(mission3){
            info = info.replace("MISSION3","✅");
        }else{
            info = info.replace("MISSION3","❌");
        }

        return info;
    }

}
