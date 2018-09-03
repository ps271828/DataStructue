package com.ps.LinkedList;

/**
 * @Author:panshuang
 * @Data:2018/9/3 23:45
 * @Description:单向联标初步实现
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
}
