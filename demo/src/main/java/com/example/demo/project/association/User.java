package com.example.demo.project.association;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: wanglong
 * @Date: 2021/3/12 10:31
 */
@Setter
@Getter
public class User {
    private Long id;
    private String name;
    private String caption;
    private List<UserOrganization> userOrganizationList;
    private Long attach1;
    private List<UserAndAttachment> attch1UserAndAttachmentList;
    private Long attach2;
    private List<UserAndAttachment> attch2UserAndAttachmentList;
}
