package top.whattowatch.wtw.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/29 23:05
 * @Description:
 */
public class CommonUtils {
    public static String getTypes(String introduction) {
        String types = null;
        types = StringUtils.substringBetween(introduction.trim().replace("　", "").replace(" ", ""), "◎类别", "◎");
        if (types == null) {
            types = StringUtils.substringBetween(introduction.trim().replace("　", "").replace(" ", ""), "类型", "◎");
        }
        if (types == null) {
            types = StringUtils.substringBetween(introduction.trim().replace("　", "").replace(" ", ""), "⊙类别", "⊙");
        }
        if (types == null) {
            types = StringUtils.substringBetween(introduction.trim().replace("　", "").replace(" ", ""), "◎分类", "◎");
        }
        if (types == null) {
            //类型: 动作 / 爱情
            //制片国家/地区: 中国
            types = StringUtils.substringBetween(introduction.trim().replace("　", "").replace(" ", ""), "类型:", "制片国家");
        }
        if (types == null) {
            //类型: 动作 / 爱情
            //制片国家/地区: 中国
            types = StringUtils.substringBetween(introduction.trim().replace("　", "").replace(" ", ""), "类型:", "级别：");
        }
        if (types == null) {
            //【类　　别】惊悚
            //【出品年代】2011
            types = StringUtils.substringBetween(introduction.trim().replace("　", "").replace(" ", ""), "【类别】", "【");
        }
        if (types == null) {
            return types;
        }
        return types.trim().replace("：", "").replace(":", "").replace("[", "").replace("]", "").replace(" ", "").
                replace("/惊吓", "").replace("惊悚片", "恐怖").replace("/惊悚", "").replace("惊悚", "恐怖").replace("/惊怵", "").replace("惊怵/", "恐怖/").replace("历险", "恐怖").replace("恐怖片", "恐怖").
                replace("/神秘", "").replace("/惊险", "").replace("荒诞", "恐怖").replace("栋笃笑", "恐怖").replace("/惊秫", "").replace("惊秫", "恐怖").
                replace("/战争", "").replace("功夫", "动作").replace("武侠/", "").replace("/武侠", "").replace("武侠", "动作").replace("/冒险", "").
                replace("动作西部", "动作").replace("武术", "动作").replace("警匪", "动作").replace("/体育", "").
                replace("玄幻", "悬疑").replace("罪案", "悬疑").replace("/犯罪", "").replace("犯罪/剧情/", "剧情/").replace("犯罪", "悬疑").
                replace("灾难", "悬疑").replace("犯罪悬疑", "悬疑").replace("悬疑悬疑", "悬疑").replace("悬念", "悬疑")
                .replace("科技", "科幻").replace("黑色电影", "科幻").replace("魔幻", "科幻").replace("幻想", "奇幻").replace("神秘", "奇幻")
                .replace("纪录片", "记录").replace("记录片", "记录").replace("纪录", "记录")
                .replace("/家庭动画", "").replace("/家庭", "")
                .replace("励志", "剧情").replace("音乐剧", "剧情").replace("同性", "剧情").replace("歌舞", "剧情").replace("/古装", "").replace("古装/", "")
                .replace("真人秀", "剧情").replace("音乐", "剧情").replace("心理", "剧情").replace("演唱会", "剧情").replace("多类型", "剧情").replace("/西部", "").replace("西部/", "").replace("西部", "")
                .replace("动画片", "动画").replace("卡通", "动画")
                .replace("/浪漫", "").replace("儿童/", "").replace("/儿童", "").replace("/运动", "").replace("运动/", "").replace("美国", "");
    }

    private static String deleteCRLFOnce(String input) {
        return input.replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1");

    }

    public static String deleteCRLF(String input) {
        if (input != null) {
            input = deleteCRLFOnce(input);
            return deleteCRLFOnce(input);
        } else {
            return input;
        }
    }

    public static String getYear(String introduction) {
        introduction = getNoBlankString(introduction);
        String year = null;
        //◎年代
        year = StringUtils.substringBetween(introduction, "◎年代:", "◎");
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "◎年代：", "◎");
        }
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "◎年代", "◎");
        }
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "◎出品年代", "◎");
        }
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "◎时间", "◎");
        }
        //上映日期: 2013-
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "上映日期:", "-");
        }
        //【出品年代】
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "【出品年代】", "【");
        }
        //【上映日期】
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "【上映日期】", "【");
        }
        //⊙年　　代
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "⊙年代", "⊙");
        }
        //【年　　代】
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "【年代】", "【");
        }
        //◎日　　期　2015
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "◎日期", "◎");
        }
        //【发行时间】
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "【发行时间】", "【");
        }
        //◎发行时间
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "◎发行时间", "◎");
        }
        //◎上映日期
        if (year == null) {
            year = StringUtils.substringBetween(introduction, "◎上映日期", "◎");
        }

        if (year != null && year.length() >= 4) {
            return year.trim().replace(" ","").substring(0,4);
        }
        else {
           return "";
        }

    }

    public static String getSimpleIntroduction(String introduction) {
        introduction = getNoBlankString(introduction);
        String newIntroduction = introduction;
        if (newIntroduction != null && !"".equals(newIntroduction)) {
            newIntroduction = StringUtils.substringBetween(introduction, "◎简介", "【下载地址】");
        }//◎簡　　介
        if (newIntroduction == null || "".equals(newIntroduction)) {
            newIntroduction = StringUtils.substringBetween(introduction, "◎簡介", "【下载地址】");
        }//◎剧　　情
        if (newIntroduction == null || "".equals(newIntroduction)) {
            newIntroduction = StringUtils.substringBetween(introduction, "◎剧情", "【下载地址】");
        }
        if (newIntroduction == null || "".equals(newIntroduction)) {
            newIntroduction = StringUtils.substringBetween(introduction, "◎简介", "下载地址");
        }//◎简　　介
        if (newIntroduction == null || "".equals(newIntroduction)) {
            newIntroduction = StringUtils.substringBetween(introduction, "◎简介", "◎");
        }
        //◎简　　介
        return newIntroduction;
    }

    private static String getNoBlankString(String str) {
        if (str != null && !"".equals(str)) {
            return str.replace(" ", "").replace("　", "");
        }
        return str;
    }
    public static String getFirstTitle(String str) {
        if (str != null && !"".equals(str)) {
            return str.split("/")[0];
        }
        return str;
    }


}
