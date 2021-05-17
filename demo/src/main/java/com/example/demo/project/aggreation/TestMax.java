package com.example.demo.project.aggreation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author: wanglong
 * @Date: 2021/3/4 10:52
 */
public class TestMax {

    //1.增删改入库操作
    //2.查询全量数据
    //3.内存计算并赋值
    //4.再次入库
    //??如果主表和子表都有聚合,主表第一次写库时,会调子表的第一次写库,然后子表聚合再次写库
    // 主表赋值完以后第二次写库时,又会重复调子表的写库,子表又会重复计算再写库
    //解决方案:每个汇总第二次写库时,直接调dao方法

    /**
     * 如果是删除聚合根,则比较特殊,不作任何处理
     * 删除非聚合根,不可能发生,删除非聚合根本质上还是走的聚合根的update
     * question 新增和修改则是统一处理,统一调update方法（update还会多一次查询）
     * answer List<Person> personList = personDao.selectByIds();
     *        List<PersonDto> personDtoList = this.selectByPersonList(personList);
     */

    /**
     * 测试聚合最大值
     * @param personList
     */
    private static void testMaxInteger(List<Person> personList) {
        //条件表达式
//        if (true) {
            for (Person person : personList) {
                Optional<Integer> max = person.getPersonWorkList().stream()
                        .map(PersonWork::getWorkCost)
//                        .flatMap(List::stream)
//                        .map(PersonWorkPractice::getWorkPracticeCost)
                        .filter(Objects::nonNull)
                        .min(Comparator.naturalOrder());
                max.ifPresent(max1-> person.setMaxPersonWorkPracticeCost(max.get()));

            }
//        }
//        if(true){
//            //同实体的第n个汇总字段
//            for(Person person : personList){
//                person.getPersonWorkList().stream()
//                        .map(PersonWork::getWorkCost)
//                        .max(Comparator.naturalOrder());
//            }
//        }
//        //统一进行入库操作,一个实体只进行一次update
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        PersonWork personWork = new PersonWork();
        personWork.setWorkCost(5);
        PersonWork personWork1 = new PersonWork();
        personWork1.setWorkCost(3);
        person.setPersonWorkList(Arrays.asList(personWork, personWork1));
        Person person1 = new Person();
        PersonWork personWork2 = new PersonWork();
        PersonWork personWork3 = new PersonWork();
        person1.setPersonWorkList(Arrays.asList(personWork2, personWork3));
        personList.add(person);
        personList.add(person1);
        testMaxInteger(personList);
    }
    /**
     * 处理特殊的一对一场景
     *
     * @param personList
     */
    private void testMaxOne2One(List<Person> personList) {
        //条件表达式
        if (true) {
            for (Person person : personList) {
                Optional<BigDecimal> bigDecimal = person.getPersonWorkList().stream()
                        .map(PersonWork::getPersonWorkPracticeList)
                        .flatMap(List::stream)
                        .map(PersonWorkPractice::getPersonWorkPracticeBigDecimal)
                        .max(Comparator.naturalOrder());
                bigDecimal.ifPresent(max1-> person.setMaxBigDecimal(bigDecimal.get()));
                person.getPersonWorkList().stream()
                        .map(PersonWork::getPersonWorkExt)
                        .map(PersonWorkExt::getPersonWorkExtCost)
                        .max(Comparator.naturalOrder());
            }
        }
        if(true){
            //同实体的第n个汇总字段

        }
        //统一进行入库操作,一个实体只进行一次update
    }
    /**
     * 1 personWork.selectListByParentIds
     * 2 BeanCopy
     * 3 PersonWorkPractice.selectByParenIds
     * 4 回写
     */
    private List<PersonWork> selectByParentIds(List<Long> ids){
        return null;
    }

    /**
     * 1 dao.selectByIds
     * 2 BeanCopy
     * 3 personWorkService.selectByParentIds
     * @param ids
     * @return
     */
    private List<Person> selectByIds(List<Long> ids){
        return null;
    }

}
