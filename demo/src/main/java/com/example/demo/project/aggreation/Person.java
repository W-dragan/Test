package com.example.demo.project.aggreation;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: wanglong
 * @Date: 2021/3/4 10:52
 */
@Setter
@Getter
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private Integer maxPersonWorkPracticeCost;
    private List<PersonWork> personWorkList;
    private Long countPersonWork;

    private BigDecimal maxBigDecimal;
}
