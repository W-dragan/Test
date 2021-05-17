package com.example.demo.project.aggreation;

import java.util.List;

/**
 * @Author: wanglong
 * @Date: 2021/4/13 14:32
 */
public class TestCount {

    public Long count(List<Person> personList){
        for(Person person:personList){
            Long countPersonWork = person.getCountPersonWork();
            person.getPersonWorkList().stream()
                    .map(PersonWork::getPersonWorkPracticeList)
                    .count();
        }
        long count = personList.stream()
                .map(Person::getPersonWorkList)
                .flatMap(List::stream)
                .map(PersonWork::getPersonWorkPracticeList)
                .count();
        System.out.println(count);
        return count;
    }
}
