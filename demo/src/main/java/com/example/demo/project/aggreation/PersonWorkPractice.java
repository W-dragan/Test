package com.example.demo.project.aggreation;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author: wanglong
 * @Date: 2021/3/4 10:59
 */
@Setter
@Getter
public class PersonWorkPractice {
    private Long id;
    private String workPracticeName;
    private Integer workPracticeCost;
    private BigDecimal personWorkPracticeBigDecimal;
    private ActionType actionType;
}
