package com.example.demo.project.aggreation;

/**
 * @Author: wanglong
 * @Date: 2021/3/4 11:00
 */
public enum ActionType {
    /**
     * 普通状态
     */
    NORMAL("normal", "普通状态"),
    /**
     * 新增状态
     */
    INSERT("insert", "新增状态"),
    /**
     * 修改状态
     */
    UPDATE("update", "修改状态"),
    /**
     * 删除状态
     */
    DELETE("delete", "删除状态");

    private String code;
    private String message;

    ActionType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
