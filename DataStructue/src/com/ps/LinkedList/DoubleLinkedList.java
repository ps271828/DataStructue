package com.ps.LinkedList;

/**
 * @Author:panshuang
 * @Data:2018/9/16 22:34
 * @Description:双向链表初步实现
 */
public class DoubleLinkedList<T> {

    private Integer size;

    private Node head;

    public DoubleLinkedList(){
        this.head = new Node();
        this.size = 0;
    }

    private class Node{
        T t;
        Node prev, next;

        public Node(T t, Node prev, Node next){
            this.t = t;
            this.prev = prev;
            this.next = next;
        }

        public Node(T t, Node next){
            this(t, null, next);
        }

        public Node(T t){
            this(t, null, null);
        }

        public Node(){
            this(null, null, null);
        }
    }

    /**
     * 添加
     * @param index
     * @param t
     */
    public void add(Integer index, T t){
        if (index < 0 || index > size) {
            throw new IllegalStateException("The index is invalid!");
        }

        this.size ++;
        Node prev = this.head.prev;
        Node node = new Node(t);
        if (prev == null) {
            node.prev = prev;
            node.next = head;
            head = node;
            return;
        }

        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }

        prev.next = node;
        node.prev = prev;
        if (prev.next.next !=  null) {
            node.next = prev.next.next;
        }
    }

    /**
     * 头部添加
     * @param t
     */
    public void addFirst(T t){
        add(0, t);
    }

    /**
     * 尾部添加
     * @param t
     */
    public void addLast(T t){
        add(this.size, t);
    }

    /**
     * 删除
     * @param index
     * @return
     */
    public T remove(Integer index){
        if (index < 0 || index > this.size) {
            throw  new IllegalStateException("The index is invalid!");
        }

        T t;
        Node curr = this.head ;
        for (int i = 0; i < index - 1 ; i++) {
            curr = curr.next;
        }
        this.size -- ;
        t = curr.t;
        //处理头节点，尾节点以及当中节点三种情况
        if (curr.prev == null && curr.next != null) {
            curr.next.prev = null;
            this.head = curr.next;
        }else if (curr.next == null && curr.prev != null) {
             curr.prev.next = null;
        }else {
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
        }
        curr = null;
        return t;
    }

    /**
     * 尾部删除
     * @return
     */
    public T removeLast(){
        return remove(this.size);
    }

    /**
     * 头部删除
     * @return
     */
    public T removaFirst(){
        return remove(0);
    }

    /**
     * 获取大小
     * @return
     */
    public Integer getSize(){
        return this.size;
    }
    /**
     * 获取指定位置元素
     * @param index
     * @return
     */
    public T get(Integer index){
        if (index < 0 || index >= this.size) {
            throw new IllegalStateException("The index is invalid!");
        }
        Node curr = this.head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.t;
    }

    /**
     * 获取头部元素
     * @return
     */
    public T getFirst(){
        return get(0);
    }

    /**
     * 获取尾部元素
     * @return
     */
    public T getLast(){
        return get(this.size);
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head:");
        Node curr = this.head;
        while (curr.next != null){
            sb.append(curr.t);
            sb.append("-->");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            doubleLinkedList.add(0,i);
            System.out.println(doubleLinkedList);
        }

        doubleLinkedList.removaFirst();
        System.out.println(doubleLinkedList);
    }
}
