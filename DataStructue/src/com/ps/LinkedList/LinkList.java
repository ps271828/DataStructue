package com.ps.LinkedList;

/**
 * @Author:panshuang
 * @Data:2018/9/3 23:45
 * @Description:单向链表初步实现
 */

/**
 * 链表，真正的动态数结构，栈，队列底层都是静态的数组，而链表真正的可以无限延长，且效率很高
 * @param <T>
 */
public class LinkList <T>{
     private class Node{
        T t;
        Node next;

        public Node(T t, Node node){
            this.t = t;
            this.next = node;
        }

        public  Node(T t){
            this(t, null);
        }

        public Node(){
            this(null, null);
        }

         @Override
         public String toString() {
             return t.toString();
         }
     }

//     private Node head;
    //新增虚拟头节点，避免头节点添加元素的特殊处理
     private Node dummyHead;
     private int size;

    /**
     * 指定头元素的构造器，实际应该很少用到
     * @param node
     */
     public LinkList(Node node){
         //this.head = node;
         this.dummyHead = new Node(null, null);
         this.size = 0;
     }

     public  LinkList(){
         this(null);
     }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty(){
         return this.size == 0;
    }

    public void addFirst(T t){
        /* this.head = new Node(t, this.head);
         this.size++;*/
        //index应该还是为0，不影响后续的添加元素
        add(0, t);
    }

    /**
     * 添加元素到指定位置，实际就是找到指定位置的前一个元素，然后将插入元素的next指向前一个元素的next，再将前一个元素的next指向当前出啊如的元素
     * @param index
     * @param t
     */
    public void add(int index, T t){
         if (index < 0 || index >size) {
             throw new IllegalStateException("The index is invalid!");
         }

       /* if (index == 0) {
            addFirst(t);
        }else {*/
       //新增虚拟头节点后，无需关注头节点的处理，且新增头节点后，元素计数从1开始，不再从0开始
            Node prev = this.dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = new Node(t,prev.next);
            this.size ++;
       /* }*/
    }

    public void addLast(T t){
         add(this.size, t);
    }
}
