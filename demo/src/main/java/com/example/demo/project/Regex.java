package com.example.demo.project;

/**
 * @Author: wanglong
 * @Date: 2021/5/28 10:51
 */
public class Regex {
    public static boolean checkName(String name){
        //首字母不能为数字,且整个字符串不包含大写字母^在前面是是匹配第一个开始,^在[]中间表示反匹配
        String regex = "^[^0-9A-Z]+[^A-Z]";
        return name.matches(regex);
    }

    public static void main(String[] args) {
        String str = "adsfaA";
        System.out.println(checkName(str));
    }
}
