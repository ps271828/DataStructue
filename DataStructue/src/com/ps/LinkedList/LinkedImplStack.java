package com.ps.LinkedList;

import com.ps.stack.ArrayStack;

/**
 * @Author:panshuang
 * @Data:2018/9/13 23:10
 * @Description:
 */
public class LinkedImplStack <T> implements ArrayStack<T> {

    LinkList<T> linkList = new LinkList<T>();

    @Override
    public void push(T o) {
        linkList.addFirst(o);
    }

    @Override
    public T pop() {
        return linkList.removeFirst();
    }

    @Override
    public T peek() {
        return linkList.getFirst();
    }

    @Override
    public int getSize() {
        return linkList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("peek:");
        sb.append(linkList);
        return sb.toString();
    }
}
