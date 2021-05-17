package com.example.demo.project.association;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @Author: wanglong
 * @Date: 2021/3/15 13:50
 */
@Setter
@Getter
public class UserAndAttachment {
    private Long id;
    //
    private Long uuid1;

    private Long attach1RefId;

    private String attach1Name;

    private String attach1Url;
    //
    private Long uuid2;

    private Long attach2RefId;

    private String attach2Name;

    private String attach2Url;

    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//        Date date = new Date();
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);
//        Timestamp timestamp = new Timestamp(4651321651L);
//        System.out.println(timestamp);
        String a = "11:11:11";
        String b = "22:22:22";
        System.out.println(a.compareTo(b));
        String str = "0:0:0";
        String pattern = "(^([0-1]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)$)|(^([0-5]?\\d):([0-5]?\\d)$)|(^[0-5]?\\d$)";
        boolean matches = Pattern.matches(pattern, str);
        System.out.println(matches);
        Map<String, Set<String>> paramMap = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("B");
        set1.add("C");
        paramMap.put("A", set1);
        HashSet<String> set2 = new HashSet<>();
        set2.add("D");
        paramMap.put("B", set2);
        HashSet<String> set3 = new HashSet<>();
        set3.add("E");
        paramMap.put("D", set3);
        //进行排序
        List<Expression> expressionList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        paramMap.forEach((k,v)->{
            Expression expression = new Expression();
            expression.setName(k);
            expression.setParam(v);
            expression.setObj(k);
            expressionList.add(expression);
        });
        Set<String> keySet = paramMap.keySet();
        Queue<Expression> queue = new LinkedList<>(expressionList);
        while (!queue.isEmpty()){
            Expression first = queue.peek();
            Optional.ofNullable(first).ifPresent(f->{
                Set<String> paramSet = paramMap.get(f.getName());
                //求表达式参数和返回变量的交集,如果不为空,说明有依赖,则放到队列最后
                paramSet.retainAll(keySet);
                Expression remove = queue.remove();
                if(!paramSet.isEmpty()){
                    queue.add(remove);
                }else {
                    //为空则说明没有依赖,可以直接入队,同时去掉keySet中该表达式返回值的key
                    list.add(f.getObj());
                    keySet.remove(f.getName());
                }
            });
        }
        System.out.println(list.toString());
    }
    @Setter
    @Getter
    static class Expression{
        private Long id;
        private String obj;
        private String name;
        private Set<String> param;
    }

}
