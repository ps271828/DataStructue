package com.ps.Array;

import java.util.*;

/**
 * @Author:panshuang
 * @Data:2018/8/28 22:14
 * @Description:
 */
public class ArrayTest {
    public static void main(String[] args){
        //顺序添加测试
        Array<Integer> arrInt = new Array<>(10);
        for (int i = 0; i <10; i++) {
            arrInt.add(i);
        }
        System.out.println(arrInt.toString());

        //首项添加测试
        arrInt.addFirst(99);
        System.out.println(arrInt.toString());

        //尾项添加
        arrInt.addLast(100);
        System.out.println(arrInt.toString());

        //根据索引移除元素
        arrInt.remove(3);
        System.out.println(arrInt.toString());

        //包含测试
        System.out.println(arrInt.contains(5));

        //根据元素删除测试
        arrInt.removeByElement(5);
        System.out.println(arrInt.toString());

        //根据索引找寻测试
        System.out.println(arrInt.find(1));

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        //迭代器自带remove方法删除元素不会破坏迭代器的合法性
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.remove();
        }
        System.out.println(list.size());

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
           map.put(i, i);
        }

        //mao需要转化为Set才能使用迭代器，且也只能进行remove操作，不能进行添加操作
        Set<Map.Entry<Integer, Integer>> mapEntry = map.entrySet();
        Iterator mapIterator = mapEntry.iterator();
        while (mapIterator.hasNext()){
            mapIterator.remove();
        }
    }
}
