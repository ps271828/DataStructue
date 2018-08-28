package com.ps.Array;

import java.util.Arrays;

/**
 * @Author:panshuang
 * @Data:2018/8/27 23:41
 * @Description:数组相关操作
 */
public class Array <T> {

    private T[] data;

    private int size;

    public Array(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapicity(){
        return data.length;
    }

    /**
     * 顺序添加元素
     * @param t
     */
    public void add(T t){
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed, Array is full");
        }
        data[size] = t;
        size++;
    }

    /**
     * 根据坐标添加元素
     * @param index
     * @param t
     */
   public void addByIndex(int index, T t){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is Illegal");
        }
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = t;
        size++;
   }

    /**
     * 第一个位置添加元素
     * @param t
     */
   public void addFirst(T t){
        addByIndex(0, t);
   }

    /**
     * 最后一个位置添加元素
     * @param t
     */
   public  void  addLast(T t){
        addByIndex(size, t);
   }

    /**
     * 查找第index个元素，从0到size-1
     * @param index
     * @return
     */
    public T find(int index){
       if (index < 0 && index >= size) {
           throw new IllegalArgumentException("index is out of bound!");
       }
       return data[index];
    }

    /**
     * 根据坐标跟新元素
     * @param index
     * @param t
     */
    public void set(int index, T t){
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("index is out of bound!");
        }
        data[index] = t;
    }

    /**
     * 查看是否包含某元素，如果包含，返回其索引，否则返回-1
     * @param t
     * @return
     */
    public int contains(T t){
        for (int i = 0; i<size; i++) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据索引删除元素
     * @param index
     * @return
     */
    public T remove(int index){
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("index is out of bound!");
        }
        T t = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
            if (i+1 == size-1) {
                data[i+1] = null;
            }
        }
        size --;
        return t;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public T removeLast(){
        return remove(size-1);
    }

    /**
     * 根据元素删除
     * @param t
     * @return
     */
    public T removeByElement(T t){
        int index = contains(t);
        if (index == -1)
            throw new IllegalArgumentException("This Element is not exists!");
        return remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The Size is "+size+"\n");
        sb.append("The Capicity is "+data.length+"\n");
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i == size-1) {
                sb.append(data[i].toString()+"]");
                continue;
            }
            sb.append(data[i].toString()+",");
        }
        return sb.toString();
    }
}
