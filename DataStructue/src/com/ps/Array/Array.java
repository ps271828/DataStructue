package com.ps.Array;

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

   //查找元素

    //更新元素

    //是否包含元素

    //删除第一个元素

    //删除最后一个元素


}
