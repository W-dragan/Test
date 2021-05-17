package com.example.demo.project.association;

/**
 * @Author: wanglong
 * @Date: 2021/4/8 15:06
 */
public enum PersonSex {
    MALE("male", "udc.entity.relation.multiplicity.one2one"),
    FEMALE("female", "udc.entity.relation.multiplicity.one2many");

    private String code;
    private String message;
    PersonSex(String code, String message){
        this.code = code;
        this.message = message;
    }
}
