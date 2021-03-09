package com.example.demo.project.aggreation;

/**
 * @Author: wanglong
 * @Date: 2021/3/9 14:20
 */
public class TestAll {
    /**
     * 1 发布应用时,找到实体相关的主子孙所有的表达式（包含条件表达式）
     * 2 从下往上找.同级先放计算,然后移除
     * 3 如果发现有引用关系,则一直查找到没有引用为止,根据此情况进行排序
     * 4 如果计算参与汇总,则放在最后处理
     * 5 对汇总计算字段再次重新从下往上
     */
}
