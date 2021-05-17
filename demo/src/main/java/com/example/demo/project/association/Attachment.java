package com.example.demo.project.association;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author: wanglong
 * @Date: 2021/3/15 13:35
 */
@Setter
@Getter
public class Attachment {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");;
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Attachment() throws ParseException {
    }
    private Long id = 5L;
    private String name = "";
    private String url;
    @JsonFormat
    private Date date = dateFormat.parse("2000-01-01");
//    private Date dateTime = dateTimeFormat.parse("");
    private String time = "09:30:25";
    private Integer money = 5;
    private BigDecimal bigDecimal = new BigDecimal("5.4");
    private PersonSex personSex = PersonSex.FEMALE;


    public static void main(String[] args) throws ParseException {
        List<Integer> integers = Arrays.asList(1, 2, 3,4,5);
        for(Integer i=0;i<integers.size() ;i++){
            if(i==2){
                continue;
            }
            System.out.println(i);
        }
        BigDecimal bigDecimal = new BigDecimal("3.6");
        System.out.println(bigDecimal);
        Attachment attachment = new Attachment();
        System.out.println(attachment.getDate());
    }


}
