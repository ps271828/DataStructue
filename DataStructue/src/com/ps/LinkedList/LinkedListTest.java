package com.ps.LinkedList;

/**
 * @Author:panshuang
 * @Data:2018/9/9 23:52
 * @Description:��������Ļ�������
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkList.addFirst(i);
            System.out.println(linkList.toString());
            System.out.println(linkList.get(i));
        }

        linkList.add(2, 666);
        System.out.println(linkList);
    }
}
