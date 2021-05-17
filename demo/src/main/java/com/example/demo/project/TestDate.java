package com.example.demo.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: wanglong
 * @Date: 2021/3/1 17:10
 */
public class TestDate {

    //    public static void main(String[] args) throws ParseException {
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//        String format = simpleDateFormat.format(date);
////		System.out.println(format);
////		Time time = new Time(135163161651L);
////		System.out.println(time);
//        Date parse = simpleDateFormat.parse(format);
//        System.out.println(parse);
//    }
    public static void main(String[] args) {
        String a = "2020-03-01";
        String b = "2020-04-01";
        System.out.println(b.compareTo(a));;
        String aa = "1.2435235";
        String substring = aa.substring(aa.indexOf(".")+1);
        System.out.println(substring);
    }
}
