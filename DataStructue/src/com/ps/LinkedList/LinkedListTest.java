package com.ps.LinkedList;

/**
 * @Author:panshuang
 * @Data:2018/9/9 23:52
 * @Description:测试链表的基本操作
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

        linkList.remove(2);
        System.out.println(linkList);

        linkList.removeFirst();
        System.out.println(linkList);

        linkList.removeLast();
        System.out.println(linkList);

        linkList.removeLast();
        linkList.removeLast();
        linkList.removeLast();
        System.out.println(linkList);

        LinkedImplStack<Integer> stack = new LinkedImplStack<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
