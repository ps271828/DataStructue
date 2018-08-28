package com.ps.Array;

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

    }
}
