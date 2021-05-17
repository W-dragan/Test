package com.example.demo.project.association;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: wanglong
 * @Date: 2021/3/12 10:32
 */
@Setter
@Getter
public class UserOrganization {
    private Long id;
    private Long userId;
    private Long orgId;
    private String userName;
    private String userCaption;
    private String orgName;
    private String orgCaption;
}
