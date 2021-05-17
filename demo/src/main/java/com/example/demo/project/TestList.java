package com.example.demo.project;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanglong
 * @Date: 2021/5/11 9:54
 */
public class TestList {

    public static void main(String[] args) {
        Test test = new Test();
        ArrayList<String> objects = new ArrayList<>();
        objects.add("a");
        objects.add("b");
        test.setStringList(objects);
        test.getStringList().add("c");
        System.out.println(test.stringList);
    }
    @Setter
    @Getter
    static class Test {
        public List<String> stringList;
    }
}
