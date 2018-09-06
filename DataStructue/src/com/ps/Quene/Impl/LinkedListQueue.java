package com.ps.Quene.Impl;

import com.ps.Quene.Quene;

/**
 * @Author:panshuang
 * @Data:2018/9/6 22:47
 * @Description:使用链表实现queue，链表的头部插入数据，尾部删除数据
 */

/**
 * 头部添加删除数据时间复杂度O（1），尾部删除数据O（n），添加数据O（1）
 * @param <T>
 */
public class LinkedListQueue<T> implements Quene<T> {

    private Node front,tail;

    private Integer size;

    public LinkedListQueue(){
        this.front = null;
        this.tail = null;
        this.size = 0;
    }


    private class Node{
        public T e;
        public Node next;

        public Node(T e, Node next ){
            this.e = e;
            this.next = next;
        }

        public  Node(T e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }
    }

    @Override
    public void enQuene(T t) {
        if (this.tail == null) {
            this.tail = new Node(t);
            this.front = this.tail;
        }else {
            this.tail.next = new Node(t);
            this.tail = this.tail.next;
        }
        this.size++;
    }

    @Override
    public T deQuene() {
        if (this.front == null) {
            throw new IllegalStateException("The queue isEmpty!");
        }
        Node t = this.front;
        this.front = this.front.next;
        t.next = null;
        //防止队首为空后队尾依旧有值，导致再加入的时候队首没有重新初始化
        if (this.front == null) {
            this.tail = null;
        }
        this.size --;
        return t.e;
    }

    @Override
    public T getFront() {
        return this.front.e;
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Front:[");
        Node e = this.front;
        while (e.next != null){
            sb.append(e.e);
            if (e.next != null) {
                sb.append(",");
            }
            e = e.next;
        }
        sb.append("]:tail");
        return sb.toString();
    }
}
