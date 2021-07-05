package com.example.demo.leetcode;

import com.google.errorprone.annotations.Var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * <p>
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * <p>
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回
 * <p>
 * <p>
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
 * ["John", "johnnybravo@mail.com"],
 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 * ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 * ["John", "johnnybravo@mail.com"],
 * ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/6/28 17:14
 */
public class Number721 {
    /**
     * 邮箱相同账号一定相同
     * 不用并查集成功完成
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //只有名字重复的才进行比对
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        //先预处理,去重,按ascii码排序
        for (List<String> list : accounts) {
            List<String> res = new ArrayList<>();
            res.add(list.get(0));
            Set<String> set = new HashSet<>(list.subList(1, list.size()));
            ArrayList<String> strings = new ArrayList<>(set);
            Collections.sort(strings);
            res.addAll(strings);
            result.add(res);
        }
        accounts.clear();
        accounts.addAll(result);
        result.clear();
        for (List<String> list : accounts) {
            for (int i = 1; i < list.size(); i++) {
                Integer integer = map.getOrDefault(list.get(i), -1);
                Integer r = integer + 1;
                map.put(list.get(i), r);
            }
        }

        Map<String, Integer> multiple = map.entrySet().stream().filter(entry -> entry.getValue() > 0).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (multiple.isEmpty()) {
            //为空说明没有重复邮箱
            return accounts;
        }
        Map<String, Set<String>> emailMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : multiple.entrySet()) {
            //重复的邮箱账号
            String key = entry.getKey();
            Iterator<List<String>> iterator = accounts.iterator();
            while (iterator.hasNext()) {
                List<String> list = iterator.next();
                Set<String> set = new HashSet<>(list);
                String name = list.get(0);
                //移除姓名
                set.remove(name);
                //如果包含该邮箱,则说明必有重复,将该list移除
                if (set.contains(key)) {
                    iterator.remove();
                    Set<String> old = emailMap.getOrDefault(name, new HashSet<>());
                    if (old.isEmpty()) {
                        emailMap.put(name, set);
                    } else {
                        //求并集
                        set.removeAll(old);
                        set.addAll(old);
                        emailMap.put(name, set);
                    }
                }

            }

        }
        for (Map.Entry<String, Set<String>> entry : emailMap.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(entry.getKey());
            List<String> email = new ArrayList<>(entry.getValue());
            list.addAll(email);
            accounts.add(list);
        }
        for (List<String> list : accounts) {
            List<String> l = new ArrayList<>();
            l.add(list.get(0));
            list.remove(0);
            Collections.sort(list);
            l.addAll(list);
            result.add(l);
        }
        return result;
    }

//    public static void main(String[] args) {
//        List<List<String>> accounts = new ArrayList<>();
//        List<String> list1 = new ArrayList<>();
//        list1.add("John");
//        list1.add("johnsmith@mail.com");
//        list1.add("john00@mail.com");
//        accounts.add(list1);
//        List<String> list2 = new ArrayList<>();
//        list2.add("John");
//        list2.add("johnnybravo@mail.com");
//        accounts.add(list2);
//        List<String> list3 = new ArrayList<>();
//        list3.add("John");
//        list3.add("johnsmith@mail.com");
//        list3.add("john_newyork@mail.com");
//        accounts.add(list3);
//        List<String> list4 = new ArrayList<>();
//        list4.add("Mary");
//        list4.add("mary@mail.com");
//        accounts.add(list4);
//        Number721 number721 = new Number721();
//        List<List<String>> result = number721.accountsMerge(accounts);
//        System.out.println(result);
//    }

//    public static void main(String[] args) {
//        List<List<String>> list = new ArrayList<>();
//        List<String> list1 = Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co");
//        list.add(list1);
//        List<String> list2 = Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co");
//        list.add(list2);
//        List<String> list3 = Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co");
//        list.add(list3);
//        List<String> list4 = Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co");
//        list.add(list4);
//        List<String> list5 = Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co");
//        list.add(list5);
//        Number721 number721 = new Number721();
//        List<List<String>> result = number721.accountsMerge(list);
//        System.out.println(result);
//
//    }

/**
 * 输入
 * [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
 * ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
 * ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
 * ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
 * ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 *
 * actual
 * [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
 * ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
 * ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
 * ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
 * ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 *
 * expected
 * [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],
 * ["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],
 * ["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],
 * ["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],
 * ["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 */

    /**
     * 输入
     * [["Lily","Lily8@m.co","Lily2@m.co","Lily2@m.co"],
     * ["Fern","Fern6@m.co","Fern1@m.co","Fern1@m.co"],
     * ["John","John8@m.co","John0@m.co","John2@m.co"],
     * ["Kevin","Kevin4@m.co","Kevin8@m.co","Kevin0@m.co"],
     * ["Fern","Fern2@m.co","Fern7@m.co","Fern7@m.co"],
     * ["John","John4@m.co","John6@m.co","John7@m.co"],
     * ["Hanzo","Hanzo8@m.co","Hanzo8@m.co","Hanzo6@m.co"],
     * ["Bob","Bob8@m.co","Bob6@m.co","Bob1@m.co"]]
     * <p>
     * 输出
     * [["John","John0@m.co","John2@m.co","John8@m.co"],
     * ["Kevin","Kevin0@m.co","Kevin4@m.co","Kevin8@m.co"],
     * ["John","John4@m.co","John6@m.co","John7@m.co"],
     * ["Bob","Bob1@m.co","Bob6@m.co","Bob8@m.co"],
     * ["Fern","Fern1@m.co","Fern2@m.co","Fern6@m.co","Fern7@m.co"],
     * ["Hanzo","Hanzo6@m.co","Hanzo8@m.co"],
     * ["Lily","Lily2@m.co","Lily8@m.co"]]
     * <p>
     * 期望
     * [["Lily","Lily2@m.co","Lily8@m.co"],
     * ["Fern","Fern1@m.co","Fern6@m.co"],
     * ["John","John0@m.co","John2@m.co","John8@m.co"],
     * ["Kevin","Kevin0@m.co","Kevin4@m.co","Kevin8@m.co"],
     * ["Fern","Fern2@m.co","Fern7@m.co"],
     * ["John","John4@m.co","John6@m.co","John7@m.co"],
     * ["Hanzo","Hanzo6@m.co","Hanzo8@m.co"],
     * ["Bob","Bob1@m.co","Bob6@m.co","Bob8@m.co"]]
     */
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = Arrays.asList("Lily", "Lily8@m.co", "Lily2@m.co", "Lily2@m.co");
        list.add(list1);
        List<String> list2 = Arrays.asList("Fern", "Fern6@m.co", "Fern1@m.co", "Fern1@m.co");
        list.add(list2);
        List<String> list3 = Arrays.asList("John", "John8@m.co", "John0@m.co", "John2@m.co");
        list.add(list3);
        List<String> list4 = Arrays.asList("Kevin", "Kevin4@m.co", "Kevin8@m.co", "Kevin0@m.co");
        list.add(list4);
        List<String> list5 = Arrays.asList("Fern","Fern2@m.co","Fern7@m.co","Fern7@m.co");
        List<String> list6 = Arrays.asList("John", "John4@m.co", "John6@m.co", "John7@m.co");
        List<String> list7 = Arrays.asList("Hanzo", "Hanzo8@m.co", "Hanzo8@m.co", "Hanzo6@m.co");
        List<String> list8 = Arrays.asList("Bob", "Bob8@m.co", "Bob6@m.co", "Bob1@m.co");
        list.add(list5);
        list.add(list6);
        list.add(list7);
        list.add(list8);
        Number721 number721 = new Number721();
        List<List<String>> result = number721.accountsMerge(list);
        System.out.println(result);

    }
}
