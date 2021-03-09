package com.example.demo.project.aggreation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: wanglong
 * @Date: 2021/3/4 10:59
 */
@Setter
@Getter
public class PersonWorkExt {
    private Long id;
    private String workName;
    private Integer personWorkExtCost;
    private ActionType actionType;
}
