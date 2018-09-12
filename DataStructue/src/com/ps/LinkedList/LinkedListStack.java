package com.ps.LinkedList;

import com.ps.stack.ArrayStack;

/**
 * @Author:panshuang
 * @Data:2018/9/10 23:49
 * @Description:单链表实现队列
 */
public class LinkedListStack <T> implements ArrayStack <T> {

    private class Node{
        public T t;
        public Node next;

        public Node(T t, Node next){
            this.t = t;
            this.next = next;
        }

        public  Node(T t){
            this(t, null);
        }

        public Node(){
            this(null, null);
        }
    }

    private Node top;
    private Integer size;

    public LinkedListStack(){
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T t) {
        if (this.top == null) {
            this.top = new Node(t);
        }else {
          /*  Node curr = new Node(t);
            curr.next = this.top;
            this.top = curr;*/
          this.top = new Node(t, this.top);
        }
        this.size ++;
    }

    @Override
    public T pop() {
        if (this.size == 0) {
            throw new IllegalStateException("The stack is Empty!");
        }
        Node retNode = this.top;
        this.top = this.top.next;
        retNode.next = null;
        this.size --;
        return retNode.t;
    }

    @Override
    public T peek() {
        if (this.size == 0)
            throw new IllegalStateException("The stack is Empty!@");
        return this.top.t;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
